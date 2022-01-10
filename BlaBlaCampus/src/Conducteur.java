import java.util.ArrayList;


 
public class Conducteur extends User {
	// Attributs
	private Voiture voiture;
	private ArrayList <Trajet>listeTrajet;
	private float carte_carburant;
	
	/**
	 * @param prenom
	 * @param adresse
	 * @param mdp
	 * @param estConnecte
	 * @param drivingBehavior
	 * @param voiture
	 * Constructeur de la classe
	 */
	public Conducteur(String prenom, String adresse, String mdp, boolean estConnecte, Behavior drivingBehavior,
			Voiture voiture) {
		super(prenom, adresse, mdp, estConnecte, drivingBehavior);
		this.voiture = voiture;
		this.listeTrajet = new ArrayList<Trajet>();
	}
	
	/**
	 * @param adresse_depart
	 * @param date
	 * @param adresse_arrivee
	 * @param prix
	 * @param horaire
	 * @param nbPlacesDispo
	 * @return Trajet
	 * Cette methode permet au conducteur de deposer un trajet
	 */
	public Trajet deposerTrajet (String adresse_depart, String date, String adresse_arrivee, int prix, String horaire,
			int nbPlacesDispo) {
		Trajet newTrajet = new Trajet(adresse_depart, date, adresse_arrivee, prix, horaire,
			nbPlacesDispo, this);
		listeTrajet.add(newTrajet);
		this.behavior.getAvantage(this.getCarte_carburant(), this);
        return newTrajet;
	}
		

	/**
	 * @param accept
	 * @param trajet
	 * @param resa
	 * Cette methode permet au conducteur d'accepter ou non une reservation et donc un passager
	 */
	public void validerReservation(boolean accept, Trajet trajet, Reservation resa) {
		if (accept) {
			for (Trajet t : listeTrajet) {
				if (trajet.equals(t)) {
					trajet.addListe(resa);
				}
			}
		}
	}
	
	/**
	 * @param trajet
	 * @param resa
	 * Cette methode a pour role de supprimer une reservation de la liste des trajets d'un conducteur
	 */
	public void supprimerReservation(Trajet trajet, Reservation resa) {
		for (Trajet t : listeTrajet) {
			if (trajet.equals(t)) {
				trajet.removeListe(resa);
			}
		}
	}
	
	// Getter et Setter
	public Voiture getVoiture() {
		return voiture;
	}

	public void setVoiture(Voiture voiture) {
		this.voiture = voiture;
	}

	public ArrayList<Trajet> getListeTrajet() {
		return listeTrajet;
	}

	public void setListeTrajet(ArrayList<Trajet> listeTrajet) {
		this.listeTrajet = listeTrajet;
	}

	public float getCarte_carburant() {
		return carte_carburant;
	}

	public void setCarte_carburant(float carte_carburant) {
		this.carte_carburant = carte_carburant;
	}
	
}
