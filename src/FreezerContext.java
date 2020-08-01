package src;

import java.util.Observable;
import java.util.Observer;

@SuppressWarnings("deprecation")
public class FreezerContext implements Observer {

	public static enum Events {
		FREEZER_DOOR_CLOSED_EVENT, FREEZER_DOOR_OPENED_EVENT
	};

	private static RefrigeratorDisplay refrigeratorDisplay;
	private FreezerState freezerState;
	private static FreezerContext instance;

	static {
		instance = new FreezerContext();
		refrigeratorDisplay = RefrigeratorDisplay.instance();
	}

	private FreezerContext() {
	}

	public static FreezerContext instance() {
		if (instance == null) {
			instance = new FreezerContext();
		}
		return instance;
	}

	public void initialize() {
		instance.changeCurrentState(IdleFreezerDoorClosed.instance());
	}

	@Override
	public void update(Observable o, Object arg) {
		freezerState.handle(arg);
	}

	public void processEvent(Object arg) {
		freezerState.handle(arg);
	}

	public void changeCurrentState(FreezerState nextState) {
		freezerState = nextState;
		nextState.run();
	}

}
