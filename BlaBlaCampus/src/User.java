import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class User implements MessageListener{
	// Attributs
	private static final AtomicInteger ID_FACTORY = new AtomicInteger();
	private int id_user;
	private String prenom;
	private String adresse;
	private String mdp;
	private boolean estConnecte;
	protected Behavior behavior;
	private ArrayList<MessageEvent> messageRecus;
	private ArrayList <Reservation>listeReservation;
	
	
	/**
	 * @param prenom
	 * @param adresse
	 * @param mdp
	 * @param estConnecte
	 * @param drivingBehavior
	 * Constructeur de la classe, il correspond à la methode créer compte
	 */
	public User (String prenom, String adresse, String mdp, boolean estConnecte, Behavior drivingBehavior) {
		this.id_user = ID_FACTORY.getAndIncrement();
		this.prenom = prenom;
		this.adresse = adresse;
		this.mdp = mdp;
		this.estConnecte = estConnecte;
		this.behavior = drivingBehavior;
		this.messageRecus = new ArrayList<MessageEvent>();
		this.listeReservation = new ArrayList<Reservation>();
	}

	// Methodes
	
	@Override
	public void onEventCreated(MessageEvent ev) {
		if(ev.getDestinataire().equals(this)) {
			this.messageRecus.add(ev);
		}
	}
	
	/**
	 * @param destinataire
	 * @param contenu
	 * PErmet d'envoyer un String (passé en paramètre de la méthode) à un destinataire 
	 * (User égakement en paramètre de la méthode)
	 */
	public MessageEvent envoyerMessage(User destinataire, String contenu) {
		MessageEvent msg = new MessageEvent(this, contenu, destinataire);
		destinataire.onEventCreated(msg);
		return msg;
	}
	
	/**
	 * @param trajet
	 * Cette méthode permet la suppression de la réservation dans trajet et dans la liste de réservation
	 * de l'utilisateur
	 */
	public void annulerReservation(Trajet trajet) {
		Reservation toRemove = null;
		for (Reservation r : listeReservation) {
			if (trajet.equals(r.getTrajet())) {
				toRemove = r;
			}
		}
		trajet.removeListe(toRemove);
		this.removeFromReservationList(toRemove);
	}
	
	/**
	 * @param trajet
	 * @param nb_place
	 * Cette méthode a pour rôle de réserver un trajet et d'indiquer le nombre de place réservé
	 */

	public void reserverTrajet(Trajet trajet, int nb_place) throws ReservationException {
		if ((trajet.getNbPlacesDispo() - nb_place) <= 0) {
			throw new ReservationException("Resa impossible, nb de places max atteint");
		} 
		else {
			Reservation r = new Reservation(nb_place, this, trajet);
			this.listeReservation.add(r);
			r.setPrix(this.behavior.getAvantage(r.getPrix(), this));
			r.maj(nb_place);
		}
	}
	
	/**
	 * @param trajet
	 * @return Reservation or null
	 * Cette méthode permet de trouver la réservation lié au trajet passé en paramètre de la méthode
	 */
	public Reservation chercherReservation(Trajet trajet) {
		for (Reservation r : listeReservation) {
			if (trajet.equals(r.getTrajet())) {
				return r;
			}
		}
		return null;
	}

	// Equivalent de consulter profil
	public String toString() {
		String s = "User [id_user=" + id_user + ", prenom=" + prenom + ", adresse=" + adresse + ", estConnecte="+ estConnecte + ", Reservation effectuee :";
		for (Reservation r : listeReservation) {
			s += r.toString();
		}
		s += "]";
		return s;
	}

	public void addToReservationList(Reservation r) {
		this.listeReservation.add(r);
	}

	public void removeFromReservationList(Reservation r) {
		this.listeReservation.remove(r);
	}

	// Getter et setter
	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public boolean isEstConnecte() {
		return estConnecte;
	}

	public void setEstConnecte(boolean estConnecte) {
		this.estConnecte = estConnecte;
	}

	public Behavior getBehavior() {
		return behavior;
	}

	public void setBehavior(Behavior drivingBehavior) {
		this.behavior = drivingBehavior;
	}

	public int getId_user() {
		return id_user;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public ArrayList<MessageEvent> getMessageRecus() {
		return messageRecus;
	}

	public ArrayList<Reservation> getListeReservation() {
		return listeReservation;
	}
}
