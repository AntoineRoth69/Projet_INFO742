import java.util.EventListener;

public interface ResaAccepteeListener extends EventListener {

	void onEventCreated(MessageEvent ev);
}