import static org.junit.Assert.*;

import org.junit.Test;

public class User_unit_tests {
	
	private User ue = new Conducteur("Eloise","rue du pont de thé Annecy","eloise",true,new BadBehavior(),new Voiture("Peugeot","308","noire"));
	private User ud = new User("Clemence"," ","eloise",true,new GoodBehavior());
	private Trajet trajet_1 = ((Conducteur) ue).deposerTrajet ("rue du pont de the Annecy","10/01/2022","Campus Annecy", 5, "7h50",4);
	
	/**
	 * test de la méthode envoyer message 
	 */
	@Test
	public void envoyerMessage() {
		this.ue.envoyerMessage(ud, "bla");
		assertEquals("bla",ud.getMessageRecus().get(0).getContenu());
		assertEquals(ud,ud.getMessageRecus().get(0).getDestinataire());
		assertEquals(ue,ud.getMessageRecus().get(0).getSource());
	}

	/**
	 * test des méthodes de reservation d'un trajet
	 * @throws ReservationException 
	 */
	@Test
	public void testReservationTrajet() throws ReservationException {
		// La réservation n'est pas valide (le conducteur n'accepte pas la reservation)
		this.ud.demandeReservation(this.trajet_1,3);
		assertEquals(0,this.ud.getListeReservation().size());
		assertEquals(4,this.trajet_1.getNbPlacesDispo());
		assertEquals(0,this.trajet_1.getListeReservation().size());
		
		// La réservation est valide (le conducteur accepte la reservation)
		this.ud.demandeReservation(this.trajet_1,1);
		assertEquals(1,this.ud.getListeReservation().size());
		assertEquals(3,this.trajet_1.getNbPlacesDispo());
		assertEquals(1,this.trajet_1.getListeReservation().size());
	}

	/**
	 * test de la méthode annuler trajet 
	 * @throws ReservationException 
	 */
	@Test
	public void testAnnulerReservation() throws ReservationException {
		// On cree une reservation
		this.ue.reservationAcceptee(this.trajet_1,1);
		
		// On annule la reservation
		this.ue.annulerReservation(trajet_1);
		assertTrue(this.ue.getListeReservation().isEmpty());
		assertTrue(this.trajet_1.getListeReservation().isEmpty());
	}
}
