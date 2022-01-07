
public class test {
	public static void main(String[] args) {
		Voiture voiture_1 = new Voiture("Peugeot","308","noire");
		Conducteur conducteur_1 = new Conducteur("Antoine","rue du pont de thé Annecy","antoine",true,null, voiture_1);
		User user_1 = new User("Eloise","rue du pont de thé Annecy","eloise",true,null);
		
		Trajet trajet_1 = conducteur_1.deposerTrajet ("rue du pont de the Annecy","10/01/2022","Campus Annecy", 5, "7h50",4);
		user_1.reserverTrajet(trajet_1, 2);
	}
}
