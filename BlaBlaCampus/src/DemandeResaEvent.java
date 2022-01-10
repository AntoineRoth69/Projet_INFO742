import java.util.EventObject;

public class DemandeResaEvent extends EventObject {
	private Trajet trajet;
	private int nbPlace;

	public DemandeResaEvent(Object source, Trajet trajet, int nbPlace) {
		super(source);
		this.trajet = trajet;
		this.nbPlace = nbPlace;
	}

	public Trajet getTrajet() {
		return trajet;
	}

	public void setTrajet(Trajet trajet) {
		this.trajet = trajet;
	}

	public int getNbPlace() {
		return nbPlace;
	}

	public void setNbPlace(int nbPlace) {
		this.nbPlace = nbPlace;
	}

	
	
}