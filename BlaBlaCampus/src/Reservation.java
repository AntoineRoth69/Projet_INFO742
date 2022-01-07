
public class Reservation {
	private int id_reservation;
	private int id_1 = 0;
	private int nbPlaces;
	private User owner;
	private Trajet trajet;
	private float prix;
	
	public Reservation(int nbPlaces, User owner, Trajet trajet) {
		super();
		this.id_reservation = id_1;
		this.id_1 = id_1++;
		this.nbPlaces = nbPlaces;
		this.owner = owner;
		this.trajet = trajet;
		this.prix = trajet.getPrix()*nbPlaces;
	}
	
	//exceptions s'il n'y a plus assez de pplaces dispo pour ce trajet
	public void exception() throws ReservationException {
		    if (trajet.getNbPlacesDispo() <= 0) {
		        throw new ReservationException("Il n'y a plus assez de places pour ce trajet");
		    }
		
	}
	
	//met � jour les attributs du trajet suite � une r�servation
	public void maj() {
		trajet.updateNbPlaces(nbPlaces);
		trajet.updateListe(this);
	}


	//getter et setter
	public int getId_reservation() {
		return id_reservation;
	}


	public void setId_reservation(int id_reservation) {
		this.id_reservation = id_reservation;
	}


	public int getId_1() {
		return id_1;
	}


	public void setId_1(int id_1) {
		this.id_1 = id_1;
	}



	public int getNbPlaces() {
		return nbPlaces;
	}


	public void setNbPlaces(int nbPlaces) {
		this.nbPlaces = nbPlaces;
	}


	public User getOwner() {
		return owner;
	}



	public void setOwner(User owner) {
		this.owner = owner;
	}



	public Trajet getTrajet() {
		return trajet;
	}



	public void setTrajet(Trajet trajet) {
		this.trajet = trajet;
	}

	public float getPrix() {
		return prix;
	}

	public void setPrix(float prix) {
		this.prix = prix;
	}

	
}
