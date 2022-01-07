
public class BadBehavior implements Behavior{

	public BadBehavior() {
		
	}

	@Override
	public float getAvantage(float prix_trajet, Object o) {
		float res = 0;
		if (o instanceof User) {
			res = (float) (prix_trajet * 1.05);	
		}
		return res;
	}
}
