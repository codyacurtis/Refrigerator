package src;

import java.util.Observable;
import java.util.Observer;

@SuppressWarnings("deprecation")
public class FridgeContext implements Observer {

	public static enum Events {
		FRIDGE_DOOR_CLOSED_EVENT, FRIDGE_DOOR_OPENED_EVENT
	};

	private static RefrigeratorDisplay refrigeratorDisplay;
	private FridgeState fridgeState;
	private static FridgeContext instance;

	static {
		instance = new FridgeContext();
		refrigeratorDisplay = RefrigeratorDisplay.instance();
	}

	private FridgeContext() {
	}

	public static FridgeContext instance() {
		if (instance == null) {
			instance = new FridgeContext();
		}
		return instance;
	}

	public void initialize() {
		instance.changeCurrentState(IdleFridgeDoorClosed.instance());
	}

	private void changeCurrentState(Object instance2) {
		// TODO Auto-generated method stub

	}

	public void processEvent(Object arg) {
		fridgeState.handle(arg);
	}

	@Override
	public void update(Observable o, Object arg) {
		fridgeState.handle(arg);
	}
}
