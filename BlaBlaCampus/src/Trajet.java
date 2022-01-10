import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class Trajet {
	private int id_trajet;
	private static final AtomicInteger ID_FACTORY = new AtomicInteger();
	private String adresse_depart;
	private String date;
	private String adresse_arrivee;
	private float prix;
	private String horaire;
	private int nbPlacesDispo;
	private ArrayList <Reservation>listeReservation;
	private Conducteur conducteur;
	
	
	public Trajet(String adresse_depart, String date, String adresse_arrivee, int prix, String horaire,
			int nbPlacesDispo, Conducteur conducteur) {
		this.id_trajet = ID_FACTORY.getAndIncrement();
		this.adresse_depart = adresse_depart;
		this.date = date;
		this.adresse_arrivee = adresse_arrivee;
		this.prix = prix;
		this.horaire = horaire;
		this.nbPlacesDispo = nbPlacesDispo;
		this.conducteur = conducteur;
		this.listeReservation = new ArrayList<Reservation>();
	}
	
	public void removeListe(Reservation resa) {
		this.listeReservation.remove(resa);
	}
	
	public void addListe (Reservation resa) {
		this.listeReservation.add(resa);
	}

	public Reservation chercherReservation() {
		for (Reservation r : listeReservation) {
			if (this.equals(r.getTrajet())) {
				return r;
			}
		}
		return null;
	}
	
	//Met � jour le nb de places dispo dans le trajet 
	public void updateNbPlaces(int nb_places) {
		this.nbPlacesDispo = nbPlacesDispo - nb_places;	
	}
	
	public String toString(){
	return "depart de " + this.adresse_depart + " le " + this.date + " a " + this.horaire + " et arrivee a " + adresse_arrivee;
}

	
	//Getter et setter
	public String getAdresse_depart() {
		return adresse_depart;
	}

	public void setAdresse_depart(String adresse_depart) {
		this.adresse_depart = adresse_depart;
	}
	
	public int getId_trajet() {
		return id_trajet;
	}

	public void setId_trajet(int id_trajet) {
		this.id_trajet = id_trajet;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getAdresse_arrivee() {
		return adresse_arrivee;
	}

	public void setAdresse_arrivee(String adresse_arrivee) {
		this.adresse_arrivee = adresse_arrivee;
	}

	public float getPrix() {
		return prix;
	}

	public void setPrix(float prix) {
		this.prix = prix;
	}

	public String getHoraire() {
		return horaire;
	}

	public void setHoraire(String horaire) {
		this.horaire = horaire;
	}

	public int getNbPlacesDispo() {
		return nbPlacesDispo;
	}

	public Conducteur getConducteur() {
		return conducteur;
	}

	public void setConducteur(Conducteur conducteur) {
		this.conducteur = conducteur;
	}

	public ArrayList<Reservation> getListeReservation() {
		return listeReservation;
	}
}
