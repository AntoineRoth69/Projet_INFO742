import java.util.concurrent.atomic.AtomicInteger;

public class Reservation {
	private int id_reservation;
	private static final AtomicInteger ID_FACTORY = new AtomicInteger();
	private int nbPlaces;
	private User owner;
	private Trajet trajet;
	private float prix;
	
	public Reservation(int nbPlaces, User owner, Trajet trajet) {
		super();
		this.id_reservation = ID_FACTORY.getAndIncrement();
		this.nbPlaces = nbPlaces;
		this.owner = owner;
		this.trajet = trajet;
		this.prix = trajet.getPrix()*nbPlaces;
	}
	
	
	//met a jour les attributs du trajet suite a une reservation
	public void maj(int nb_place) {
		trajet.updateNbPlaces(nbPlaces);
		trajet.removeListe(this);		
	}

	public String toString() {
			return "id_resa = " + id_reservation + "\n" ;
		}
		
	//getter et setter
	public int getId_reservation() {
		return id_reservation;
	}


	public void setId_reservation(int id_reservation) {
		this.id_reservation = id_reservation;
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
