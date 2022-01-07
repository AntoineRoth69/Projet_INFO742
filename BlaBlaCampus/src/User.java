import java.util.ArrayList;

public class User implements MessageListener{
	private int id_user;
	private int id_1 = 0;
	private String prenom;
	private String adresse;
	private String mdp;
	private boolean estConnecte;
	protected Behavior behavior;
	private ArrayList<MessageEvent> messageRecus;
	private ArrayList <Reservation>listeReservation;
	
	// Constructeur, correspond a la methode creer compte
	public User (String prenom, String adresse, String mdp, boolean estConnecte, Behavior drivingBehavior) {
		this.id_user = id_1;
		this.id_1 = id_1++;
		this.prenom = prenom;
		this.adresse = adresse;
		this.mdp = mdp;
		this.estConnecte = estConnecte;
		this.behavior = drivingBehavior;
	}
	
	// Methodes
	@Override
	public void onEventCreated(MessageEvent ev) {
		// TODO Auto-generated method stub
		if(ev.getDestinataire().equals(this)) {
			this.messageRecus.add(ev);
		}
	}
	
	public void envoyerMessage(User destinataire, String contenu) {
		MessageEvent msg = new MessageEvent(this, contenu, destinataire);
		destinataire.onEventCreated(msg);
	}
	
	public void annulerReservation(Trajet trajet) {
		for (Reservation r : listeReservation) {
			if (trajet.equals(r.getTrajet())) {
				trajet.removeListe(r);
			}
		}
	}
	
	public void reserverTrajet(Trajet trajet, int nb_place) {
		Reservation r = new Reservation(nb_place, this, trajet) ;
		this.listeReservation.add(r);
		r.setPrix(this.behavior.getAvantage(r.getPrix(), this));
	 
	}
	
	
	
	
	// Equivalent de consulter profil 
	public String toString() {
		return "User [id_user=" + id_user + ", id_1=" + id_1 + ", prenom=" + prenom + ", adresse=" + adresse + ", mdp="
				+ mdp + ", estConnecte=" + estConnecte + ", behavior=" + behavior + ", listeReservation="
				+ listeReservation + "]";
	}

	//Getter et setter
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
}
