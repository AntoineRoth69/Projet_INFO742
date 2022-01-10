
public class BadBehavior implements Behavior{

	public BadBehavior() {
		
	}

	/**
	 *@param prix_trajet
	 *@param o
	 *@return float 
	 * Permet d'affecter le desavantage aux passagers mal note, il paye 5% plus chere
	 */
	@Override
	public float getAvantage(float prix_trajet, Object o) {
		float res = 0;
		if (o instanceof User) {
			res = (float) (prix_trajet * 1.05);	
		}
		return res;
	}
}
