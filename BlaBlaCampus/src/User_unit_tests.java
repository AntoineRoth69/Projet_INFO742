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
		MessageEvent msg = new MessageEvent(ue,"bla",ud);
		MessageEvent m = this.ue.envoyerMessage(ud, "bla");
		assertEquals(msg.getContenu(),m.getContenu());
		assertEquals(msg.getDestinataire(),m.getDestinataire());
		assertEquals(msg.getSource(),m.getSource());
	}

	/**
	 * test de la méthode reserver trajet 
	 * @throws ReservationException 
	 */
	@Test
	public void testReserverTrajet() throws ReservationException {
		int sizeListRes = this.ue.getListeReservation().size();
		this.ue.reservationAcceptee(this.trajet_1,1);
		assertEquals(sizeListRes+1,this.ue.getListeReservation().size());
		assertEquals(this.trajet_1,this.ue.getListeReservation().get(sizeListRes).getTrajet());
	}

	/**
	 * test de la méthode annuler trajet 
	 * @throws ReservationException 
	 */
	@Test
	public void testAnnulerReservation() throws ReservationException {
		this.ue.reservationAcceptee(this.trajet_1,1);
		int sizeListRes = this.ue.getListeReservation().size();
		this.ue.annulerReservation(trajet_1);
		assertEquals(sizeListRes-1,this.ue.getListeReservation().size());
		assertTrue(this.ue.getListeReservation().isEmpty());
	}
}
