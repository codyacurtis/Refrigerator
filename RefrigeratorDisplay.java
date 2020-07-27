
public abstract class RefrigeratorDisplay {
	
	protected static RefrigeratorContex contex;
	protected static RefrigeratorDisplay instance;
	
	protected RefrigeratorDisplay() {
		instance = this;
		contex = RefrigeratorContex.instance();
	}
	
	public static RefrigeratorDisplay instance() {
		return instance;
	}
	
	public void initialize() {
		context.initialize();
	}
	
	public abstract void displayFridgeTemp(int temp);
	public abstract void displayFreezerTemp(int temp);
	
	/**
	 * Indicate that the fridge light is on
	 */
	public abstract void turnFridgeLightOn();

	/**
	 * Indicate that the fridge light is off
	 */
	public abstract void turnFridgeLightOff();

	/**
	 * Indicate that the fridge door is now closed
	 */
	public abstract void fridgeDoorClosed();

	/**
	 * Indicate that the fridge door is now open
	 */
	public abstract void fridgeDoorOpened();
	
	/**
	 * Indicate that the fridge is cooling
	 */
	public abstract void fridgeCooling();

	/**
	 * Indicate that the fridge is idle
	 */
	public abstract void fridgeIdle();
	
	/**
	 * Indicate that the freezer light is on
	 */
	public abstract void turnFreezerLightOn();

	/**
	 * Indicate that the freezer light is off
	 */
	public abstract void turnFreezerLightOff();

	/**
	 * Indicate that the freezer door is now closed
	 */
	public abstract void freezerDoorClosed();

	/**
	 * Indicate that the freezer door is now open
	 */
	public abstract void freezerDoorOpened();
	
	/**
	 * Indicate that the freezer is cooling
	 */
	public abstract void freezerCooling();

	/**
	 * Indicate that the freezer is idle
	 */
	public abstract void freezerIdle();

}
