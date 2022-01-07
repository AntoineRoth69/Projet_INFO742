import java.util.EventObject;

public class MessageEvent extends EventObject {
	private String contenu;
	private User destinataire;

	public MessageEvent(Object source, String contenu, User dest) {
		super(source);
		// TODO Auto-generated constructor stub
		this.contenu = contenu;
		this.destinataire = dest;
	}

	public String getContenu() {
		return contenu;
	}

	public void setContenu(String contenu) {
		this.contenu = contenu;
	}

	public User getDestinataire() {
		return destinataire;
	}

	public void setDestinataire(User destinataire) {
		this.destinataire = destinataire;
	}

}
