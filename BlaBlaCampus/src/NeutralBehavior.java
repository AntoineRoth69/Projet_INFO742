
public class NeutralBehavior implements Behavior {

	public NeutralBehavior() {
		
	}
	
	/**
	 *@param prix_trajet
	 *@param o
	 *@return float 
	 * Permet d'affecter les avantages aux personnes ayant un comportement neutre 
	 */
	@Override
	public float getAvantage(float prix_trajet, Object o) {
		// Le passager va payer son trajet 5% moins chere que le prix réel
		float res = 0;
		if (o instanceof User) {
			res = (float) (prix_trajet * 0.95);
			
		}
		if (o instanceof Conducteur) {
			// Le conducteur a une carte essence sur laquel s'ajoute un euros
			((Conducteur) o).setCarte_carburant(((Conducteur) o).getCarte_carburant()+1);

		}
		return res;
		
	}
}
