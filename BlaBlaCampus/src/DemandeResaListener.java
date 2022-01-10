import java.util.EventListener;

public interface DemandeResaListener extends EventListener {

	void onEventCreated(MessageEvent ev);
}
