package src;

public interface RefrigeratorDisplay {

	public void setRefrigerator(Refrigerator refrigerator);

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

	public void setFridgeDoorStatus();

	public void setFreezerDoorStatus();

	public void fridgeTempStatus();

	public void freezerTempStatus();

	public void fridgeCoolingStatus();

	public void freezerCoolingStatus();

}
