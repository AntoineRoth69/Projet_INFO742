import java.util.EventObject;

public class MessageEvent extends EventObject {
	private String contenu;

	public MessageEvent(Object source, String contenu) {
		super(source);
		// TODO Auto-generated constructor stub
		this.contenu = contenu;
	}

	public String getContenu() {
		return contenu;
	}

	public void setContenu(String contenu) {
		this.contenu = contenu;
	}

}
