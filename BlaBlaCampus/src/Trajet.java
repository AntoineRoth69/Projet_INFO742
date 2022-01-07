import java.util.ArrayList;

public class Trajet {
	private int id_trajet;
	private int id_1 = 0;
	private String adresse_depart;
	private String date;
	private String adresse_arrivee;
	private int prix;
	private String horaire;
	private int nbPlacesDispo;
	private ArrayList <Reservation>listeReservation;
	
	
	public Trajet(String adresse_depart, String date, String adresse_arrivee, int prix, String horaire,
			int nbPlacesDispo) {
		this.id_trajet = id_1;
		this.id_1 = id_1++;
		this.adresse_depart = adresse_depart;
		this.date = date;
		this.adresse_arrivee = adresse_arrivee;
		this.prix = prix;
		this.horaire = horaire;
		this.nbPlacesDispo = nbPlacesDispo;
	}

	public void updateListe(Reservation resa) {
		this.listeReservation.add(resa);
	}
	
	public void updateNbPlaces(int nb_places) {
		this.nbPlacesDispo = nbPlacesDispo - nb_places;
	}

	
	//Getter et setter
	public String getAdresse_depart() {
		return adresse_depart;
	}


	public void setAdresse_depart(String adresse_depart) {
		this.adresse_depart = adresse_depart;
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


	public int getPrix() {
		return prix;
	}


	public void setPrix(int prix) {
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
	
	
	

}
