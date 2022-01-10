import java.util.EventObject;

public class ResaAccepteeEvent extends EventObject {
	private boolean choix;
	private Trajet trajet;
	private int nbPlace;

	public ResaAccepteeEvent(Object source, boolean choix, Trajet trajet, int nbPlace) {
		super(source);
		this.choix = choix;
		this.trajet = trajet;
		this.nbPlace = nbPlace;
	}

	public boolean isChoix() {
		return choix;
	}

	public void setChoix(boolean choix) {
		this.choix = choix;
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

