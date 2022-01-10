
public class GoodBehavior implements Behavior {

	public GoodBehavior() {
		
	}
	/**
	 *@param prix_trajet
	 *@param o
	 *@return float 
	 * Permet d'affecter les avantages aux personnes ayant un bon comportement 
	 */
	@Override
	public float getAvantage(float prix_trajet, Object o) {
		float res = 0;
		if (o instanceof User) {
			// Le passager va payer son trajet 10% moins chere que le prix réel
			res = (float) (prix_trajet * 0.90);
			

		}
		if (o instanceof Conducteur) {
			// Le conducteur a une carte essence sur laquel s'ajoute deux euros
			((Conducteur) o).setCarte_carburant(((Conducteur) o).getCarte_carburant()+2);

		}
		return res;	
	
	}
	
}
