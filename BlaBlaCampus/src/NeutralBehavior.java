
public class NeutralBehavior implements Behavior {

	public NeutralBehavior() {
		
	}
	
	@Override
	public float getAvantage(float prix_trajet, Object o) {
		float res = 0;
		if (o instanceof User) {
			res = (float) (prix_trajet * 0.95);
			
		}
		if (o instanceof Conducteur) {
			((Conducteur) o).setCarte_carburant(((Conducteur) o).getCarte_carburant()+1);
			
			


		}
		return res;
		
	}
}
