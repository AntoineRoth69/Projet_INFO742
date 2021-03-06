
public class test {
	public static void main(String[] args) throws ReservationException {
		GoodBehavior good = new GoodBehavior();
		Voiture voiture_1 = new Voiture("Peugeot", "308", "noire");
		Voiture voiture_2 = new Voiture("Citroen", "C3", "zebree");
		Conducteur conducteur_1 = new Conducteur("Antoine", "rue du pont de the Annecy", "antoine", true, good,
				voiture_1);
		Conducteur conducteur_2 = new Conducteur("Lucas", "rue du pont de the Annecy", "lucas", true, good, voiture_2);
		System.out.println("Le conducteur a une carte de : " + conducteur_1.getCarte_carburant() + " euros");
		User user_1 = new User("Eloise", "rue du pont de the Annecy", "eloise", true, good);

		// 1ere resa
		System.out.println("\n Test Resa 1");
		Trajet trajet_1 = conducteur_1.deposerTrajet("rue du pont de the Annecy", "10/01/2022", "Campus Annecy", 5,
				"7h50", 4);
		user_1.demandeReservation(trajet_1, 1);
		System.out.println(user_1);

		// 2eme resa
		System.out.println("\n Test resa 2");
		Trajet trajet_2 = conducteur_2.deposerTrajet("rue du pont de the Annecy", "22/01/2022", "Campus Annecy", 5,
				"10h", 4);
		System.out.println(trajet_2);
		user_1.demandeReservation(trajet_2, 2);
		System.out.println(user_1);
		//l'auto incremente des id fonctionne bien la resa aussi

		// test des prix
		System.out.println("\n Test sur les prix");
		System.out.println("Le conducteur a une carte de : " + conducteur_1.getCarte_carburant() + " euros ");
		System.out.println("");
		System.out.println("Le prix du trajet est : " + trajet_1.getPrix());
		System.out.println("Le passage paie : " + user_1.chercherReservation(trajet_1).getPrix());
		
		
		//Test des avantages lies au comportment
		System.out.println("Le conducteur a une carte de : " + conducteur_1.getCarte_carburant() + " euros ");
		System.out.println("Le prix du trajet est : " + trajet_1.getPrix()+" euros ");
		System.out.println("Le passage paie : " + user_1.chercherReservation(trajet_1).getPrix()+" euros ");
			
		//Test suppression resa
		System.out.println("Test suppression resa");
		System.out.println(user_1);
		conducteur_1.supprimerReservation(trajet_1, user_1.chercherReservation(trajet_1));
		System.out.println(trajet_1);
		System.out.println(user_1);


		// Test exception
		System.out.println("Test exception resa");
		user_1.demandeReservation(trajet_1, 6);
		System.out.println(user_1);
	}
}

