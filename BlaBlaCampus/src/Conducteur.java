import java.util.ArrayList;

public class Conducteur extends User {
	private Voiture voiture;
	private ArrayList <Trajet>listeTrajet;
	private int carte_carburant;
	
	public Conducteur(String prenom, String adresse, String mdp, boolean estConnecte, Behavior drivingBehavior,
			Voiture voiture) {
		super(prenom, adresse, mdp, estConnecte, drivingBehavior);
		this.voiture = voiture;
	}
	
	public void deposerTrajet (String adresse_depart, String date, String adresse_arrivee, int prix, String horaire,
			int nbPlacesDispo, Conducteur conducteur) {
	Trajet newTrajet = new Trajet(adresse_depart, date, adresse_arrivee, prix, horaire,
			nbPlacesDispo, this);
	listeTrajet.add(newTrajet);
	}
	
	public void validerReservation(boolean accept, Trajet trajet, Reservation resa) {
		if (accept) {
			for (Trajet t : listeTrajet) {
				if (trajet.equals(t)) {
			trajet.addListe(resa);
			}
				}
			}
	}
	
	public void supprimerReservation(Trajet trajet, Reservation resa) {
			for (Trajet t : listeTrajet) {
				if (trajet.equals(t)) {
			trajet.removeListe(resa);
			}
				}
			}

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

	public int getCarte_carburant() {
		return carte_carburant;
	}

	public void setCarte_carburant(int carte_carburant) {
		this.carte_carburant = carte_carburant;
	}
	
}
