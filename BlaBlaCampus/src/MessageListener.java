import java.util.EventListener;

public interface MessageListener extends EventListener {

	void onEventCreated(MessageEvent ev);
}
