
public class User {
	private int id_user;
	private String prenom;
	private String adresse;
	private String mdp;
	private boolean estConnecte;
	private Behavior drivingBehavior;
	
	public User (int id_user, String prenom) {
		this.prenom = prenom;
		this.id_user = id_user;
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
