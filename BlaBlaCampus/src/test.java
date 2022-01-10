
public class test {
	public static void main(String[] args) {
		GoodBehavior good = new GoodBehavior();
		Voiture voiture_1 = new Voiture("Peugeot","308","noire");
		Voiture voiture_2 = new Voiture("Citroen","C3","zebree");
		Conducteur conducteur_1 = new Conducteur("Antoine","rue du pont de th� Annecy","antoine",true,good, voiture_1);
		Conducteur conducteur_2 = new Conducteur("Lucas","rue du pont de th� Annecy","lucas",true,good, voiture_2);
		System.out.println("Le conducteur a une carte de : " + conducteur_1.getCarte_carburant() + "€");
		User user_1 = new User("Eloise","rue du pont de th� Annecy","eloise",true,good);
		
		//1ere resa
		Trajet trajet_1 = conducteur_1.deposerTrajet ("rue du pont de the Annecy","10/01/2022","Campus Annecy", 5, "7h50",4);
		System.out.println(user_1);
		
		//2eme resa
		Trajet trajet_2 = conducteur_2.deposerTrajet ("rue du pont de the Annecy","22/01/2022","Campus Annecy", 5, "10h",4);
		user_1.reserverTrajet(trajet_2, 2);
		System.out.println(user_1);
		//l'auto incremente des id fonctionne bien la resa aussi
		
		//test des prix
		System.out.println("Le conducteur a une carte de : " + conducteur_1.getCarte_carburant() + "euros ");
		System.out.println("");
		System.out.println("Le prix du trajet est : " + trajet_1.getPrix());
		System.out.println("Le passage paie : " + user_1.chercherReservation(trajet_1).getPrix());
				
		//Test exception
		user_1.reserverTrajet(trajet_1, 6);
		System.out.println(user_1);
		
	}
}
