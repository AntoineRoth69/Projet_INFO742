import java.util.ArrayList;

public class User {
	private int id_user;
	private int id_1;
	private String prenom;
	private String adresse;
	private String mdp;
	private boolean estConnecte;
	private Behavior drivingBehavior;
	private ArrayList <Reservation>listeReservation;
	
	// Constructeur, correspond à la méthode créer compte
	public User (String prenom, String adresse, String mdp, boolean estConnecte, Behavior drivingBehavior) {
		this.id_user = id_1;
		this.id_1 = id_1++;
		this.prenom = prenom;
		this.adresse = adresse;
		this.mdp = mdp;
		this.estConnecte = estConnecte;
		this.drivingBehavior = drivingBehavior;
	}
	
	// Méthodes
	
	public void annulerReservation(Trajet trajet) {
		for (Reservation r : listeReservation) {
			if (trajet.equals(r.getTrajet())) {
				trajet.removeListe(r);
			}
		}
		
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

	public Behavior getDrivingBehavior() {
		return drivingBehavior;
	}

	public void setDrivingBehavior(Behavior drivingBehavior) {
		this.drivingBehavior = drivingBehavior;
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
