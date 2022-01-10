import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class User implements MessageListener, DemandeResaListener, ResaAccepteeListener{
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
	 * Constructeur de la classe, appele lors de la cr�ation d'un compte
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
	 * Permet d'envoyer un String (passe en parametre de la methode) a un destinataire 
	 * (User egalement en parametre de la methode)
	 */
	public void envoyerMessage(User destinataire, String contenu) {
		MessageEvent msg = new MessageEvent(this, contenu, destinataire);
		destinataire.onEventCreated(msg);
	}
	
	/**
	 * @param trajet
	 * Cette methode permet la suppression de la reservation dans trajet et dans la liste de reservation
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
	
	public void demandeReservation(Trajet trajet, int nb_place) throws ReservationException {
		if ((trajet.getNbPlacesDispo() - nb_place) <= 0) {
			throw new ReservationException("Resa impossible, nb de places max atteint");
		} 
		DemandeResaEvent newResa = new DemandeResaEvent(this, trajet, nb_place);
		trajet.getConducteur().onEventCreated(newResa);
		
	}
	
	public void onEventCreated(ResaAccepteeEvent ev) {
		if(ev.isChoix()) {
			this.reservationAcceptee(ev.getTrajet(), ev.getNbPlace());
		}
	}
	public void reservationAcceptee(Trajet trajet, int nb_place) {
			Reservation r = new Reservation(nb_place, this, trajet);
			this.addToReservationList(r);
			r.setPrix(this.behavior.getAvantage(r.getPrix(), this));
			r.maj(nb_place);
		
	}
	
	/**
	 * @param trajet
	 * @return Reservation or null
	 * Cette methode permet de trouver la reservation lie au trajet passe en parametre de la methode
	 */
	public Reservation chercherReservation(Trajet trajet) {
		for (Reservation r : listeReservation) {
			if (trajet.equals(r.getTrajet())) {
				return r;
			}
		}
		return null;
	}
	
	@SuppressWarnings("deprecation")
	public Conducteur changeUserToDriver(Voiture v) throws Throwable {
		Conducteur newDriver = new Conducteur(this,v);
		this.finalize();
		return newDriver;
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

	public String getMdp() {
		return mdp;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public ArrayList<MessageEvent> getMessageRecus() {
		return messageRecus;
	}

	public ArrayList<Reservation> getListeReservation() {
		return listeReservation;
	}
}
