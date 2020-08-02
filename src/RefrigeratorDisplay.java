package src;

import java.util.Observable;

@SuppressWarnings("deprecation")
public abstract class RefrigeratorDisplay extends Observable {

	protected static FreezerContext freezerContext;
	protected static FridgeContext fridgeContext;
	protected static RefrigeratorDisplay instance;

	protected RefrigeratorDisplay() {
		instance = this;
		fridgeContext = FridgeContext.instance();
		freezerContext = FreezerContext.instance();
	}

	public static RefrigeratorDisplay instance() {
		return instance;
	}

	public void initialize() {
		fridgeContext.initialize();
		freezerContext.initialize();
	}

	public abstract void turnFridgeLightOn();

	public abstract void turnFridgeLightOff();

	public abstract void fridgeDoorOpened();

	public abstract void fridgeDoorClosed();

	public abstract void fridgeIdle();

	public abstract void fridgeCooling();

	public abstract void turnFreezerLightOn();

	public abstract void turnFreezerLightOff();

	public abstract void freezerDoorOpened();

	public abstract void freezerDoorClosed();

	public abstract void freezerIdle();

	public abstract void freezerCooling();

	public abstract void setRoomTemp();

	public abstract void setFridgeTemp();

	public abstract void setFreezerTemp();
}
