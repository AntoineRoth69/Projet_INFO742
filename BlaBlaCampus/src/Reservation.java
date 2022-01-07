
public class Reservation {
	private int id_reservation;
	private int id_1 = 0;
	private int nbPlaces;
	private User owner;
	private Trajet trajet;
	
	public Reservation(int nbPlaces, User owner, Trajet trajet) {
		super();
		this.id_reservation = id_1;
		this.id_1 = id_1++;
		this.nbPlaces = nbPlaces;
		this.owner = owner;
		this.trajet = trajet;
	}
	
	
	
	public void maj() {
		trajet.updateNbPlaces(nbPlaces);
		trajet.updateListe(this);
	}

}
