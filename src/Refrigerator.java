package src;

public class Refrigerator {

	public static enum Events {
		FRIDGE_DOOR_CLOSED_EVENT, FRIDGE_DOOR_OPENED_EVENT, FREEZER_DOOR_CLOSED_EVENT, FREEZER_DOOR_OPENED_EVENT
	};

	private FreezerState freezerState;
	private FridgeState fridgeState;

	private CoolingFreezerDoorClosed coolingFreezerDoorClosed;
	private CoolingFridgeDoorClosed coolingFridgeDoorClosed;
	private IdleFreezerDoorClosed idleFreezerDoorClosed;
	private IdleFridgeDoorClosed idleFridgeDoorClosed;
	private IdleFreezerDoorOpen idleFreezerDoorOpen;
	private IdleFridgeDoorOpen idleFridgeDoorOpen;

	private final int fridgeRateLossDoorClosed = 30;
	private final int fridgeRateLossDoorOpen = 2;
	private final int fridgeCoolRate = 20;
	private final int freezerRateLossDoorClosed = 10;
	private final int freezerRateLossDoorOpen = 1;
	private final int freezerCoolRate = 30;

	private int userFridgeTemp;
	private int userFreezerTemp;

	private int currentFridgeTemp = 39;
	private int currentFreezerTemp = -5;
	private int fridgeLow = 37;
	private int fridgeHigh = 41;
	private int freezerLow = 8;
	private int freezerHigh = 0;
	private int ambientTemp = 65;
	private int desiredFridgeTemp = 39;
	private int desiredFreezerTemp = 4;
	private int allowableDifferance = 2;

	private int fridgeSeconds = 0;
	private int freezerSeconds = 0;

	private int fridgeRateOfChange = 0;
	private int freezerRateOfChange = 0;

	private boolean fridgeCooling = false;
	private boolean freezerCooling = false;

	private boolean fridgeDoorOpen = false;
	private boolean freezerDoorOpen = false;
	private static Refrigerator refrigerator;
	private RefrigeratorDisplay display;

	public static Refrigerator instance() {
		if (refrigerator == null) {
			refrigerator = new Refrigerator();
		}
		return refrigerator;
	}

	private Refrigerator() {
		this.coolingFreezerDoorClosed = new CoolingFreezerDoorClosed(this);
		this.coolingFridgeDoorClosed = new CoolingFridgeDoorClosed(this);
		this.idleFreezerDoorClosed = new IdleFreezerDoorClosed(this);
		this.idleFridgeDoorClosed = new IdleFridgeDoorClosed(this);
		this.idleFreezerDoorOpen = new IdleFreezerDoorOpen(this);
		this.idleFridgeDoorOpen = new IdleFridgeDoorOpen(this);

		this.freezerState = idleFreezerDoorClosed;
		this.fridgeState = idleFridgeDoorClosed;

		display = new GUIDisplay();
		display.setRefrigerator(this);

	}

	public void clockTicked() {
		// This will be triggered every second
		// Very similar to a run method

		// Updates the temp
		if (fridgeState.getRateOfChange() <= fridgeSeconds) {
			fridgeSeconds = 0;
			if (currentFridgeTemp < ambientTemp) {
				currentFridgeTemp = (fridgeState.getCooling()) ? currentFridgeTemp - 1 : currentFridgeTemp + 1;
			}
		}
		if (freezerState.getRateOfChange() <= freezerSeconds) {
			freezerSeconds = 0;
			if (currentFreezerTemp < ambientTemp) {
				currentFreezerTemp = (freezerState.getCooling()) ? currentFreezerTemp - 1 : currentFreezerTemp + 1;
			}
		}
		fridgeSeconds++;
		freezerSeconds++;

		// Turn on the cooling on or off if the temp is too high or too low
		if (currentFridgeTemp > fridgeHigh && !fridgeDoorOpen) {
			setFridgeState(coolingFridgeDoorClosed);
		} else if (currentFridgeTemp < fridgeLow && !fridgeDoorOpen) {
			setFridgeState(idleFridgeDoorClosed);
		}

		if (currentFreezerTemp > freezerHigh && !freezerDoorOpen) {
			setFreezerState(coolingFreezerDoorClosed);
		} else if (currentFreezerTemp < freezerLow && !freezerDoorOpen) {
			setFreezerState(idleFreezerDoorClosed);
		}

		display.setFridgeDoorStatus();
		display.setFreezerDoorStatus();
		display.fridgeTempStatus();
		display.freezerTempStatus();
		display.fridgeCoolingStatus();
		display.freezerCoolingStatus();

	}

	public CoolingFreezerDoorClosed getCoolingFreezerDoorClosed() {
		return coolingFreezerDoorClosed;
	}

	public CoolingFridgeDoorClosed getCoolingFridgeDoorClosed() {
		return coolingFridgeDoorClosed;
	}

	public IdleFreezerDoorClosed getIdleFreezerDoorClosed() {
		return idleFreezerDoorClosed;
	}

	public IdleFridgeDoorClosed getIdleFridgeDoorClosed() {
		return idleFridgeDoorClosed;
	}

	public IdleFreezerDoorOpen getIdleFreezerDoorOpen() {
		return idleFreezerDoorOpen;
	}

	public IdleFridgeDoorOpen getIdleFridgeDoorOpen() {
		return idleFridgeDoorOpen;
	}

	public void setCoolingFreezerDoorClosed(CoolingFreezerDoorClosed coolingFreezerDoorClosed) {
		this.coolingFreezerDoorClosed = coolingFreezerDoorClosed;
	}

	public void setCoolingFridgeDoorClosed(CoolingFridgeDoorClosed coolingFridgeDoorClosed) {
		this.coolingFridgeDoorClosed = coolingFridgeDoorClosed;
	}

	public void setIdleFreezerDoorClosed(IdleFreezerDoorClosed idleFreezerDoorClosed) {
		this.idleFreezerDoorClosed = idleFreezerDoorClosed;
	}

	public void setIdleFridgeDoorClosed(IdleFridgeDoorClosed idleFridgeDoorClosed) {
		this.idleFridgeDoorClosed = idleFridgeDoorClosed;
	}

	public void setIdleFreezerDoorOpen(IdleFreezerDoorOpen idleFreezerDoorOpen) {
		this.idleFreezerDoorOpen = idleFreezerDoorOpen;
	}

	public void setIdleFridgeDoorOpen(IdleFridgeDoorOpen idleFridgeDoorOpen) {
		this.idleFridgeDoorOpen = idleFridgeDoorOpen;
	}

	public FreezerState getFreezerState() {
		return freezerState;
	}

	public FridgeState getFridgeState() {
		return fridgeState;
	}

	public void setFreezerState(FreezerState freezerState) {
		this.freezerState = freezerState;
	}

	public void setFridgeState(FridgeState fridgeState) {
		this.fridgeState = fridgeState;
	}

	public int getFridgeRateLossDoorClosed() {
		return fridgeRateLossDoorClosed;
	}

	public int getFridgeRateLossDoorOpen() {
		return fridgeRateLossDoorOpen;
	}

	public int getFreezerRateLossDoorClosed() {
		return freezerRateLossDoorClosed;
	}

	public int getFreezerRateLossDoorOpen() {
		return freezerRateLossDoorOpen;
	}

	public int getFridgeCoolerRate() {
		return fridgeCoolRate;
	}

	public int getFreezerCoolerRate() {
		return freezerCoolRate;
	}

	public int getFridgeTemp() {
		return currentFridgeTemp;
	}

	public int getFreezerTemp() {
		return currentFreezerTemp;
	}

	public int getAmbientTemp() {
		return ambientTemp;
	}

	public void setAmbientTemp(int temperature) {
		ambientTemp = temperature;
	}

	public void setFridgeCoolingTemp(int temperature) {
		userFridgeTemp = temperature;
	}

	public void setFreezerCoolingTemp(int temperature) {
		userFreezerTemp = temperature;
	}

	public int getFridgeRateOfChange() {
		return fridgeRateOfChange;
	}

	public int getFreezerRateOfChange() {
		return freezerRateOfChange;
	}

	public boolean isFridgeCooling() {
		return fridgeCooling;
	}

	public boolean isFreezerCooling() {
		return freezerCooling;
	}

	public void setFridgeRateOfChange(int fridgeRateOfChange) {
		this.fridgeRateOfChange = fridgeRateOfChange;
	}

	public void setFreezerRateOfChange(int freezerRateOfChange) {
		this.freezerRateOfChange = freezerRateOfChange;
	}

	public void setFridgeCooling(boolean fridgeCooling) {
		this.fridgeCooling = fridgeCooling;
	}

	public void setFreezerCooling(boolean freezerCooling) {
		this.freezerCooling = freezerCooling;
	}

	public String getFridgeCooling() {
		return fridgeCooling ? "Fridge Cooling" : "Fridge Idle";
	}

	public String getFreezerCooling() {
		return freezerCooling ? "Freezer Cooling" : "Freezer Idle";
	}

	public String getFridgeLight() {
		return fridgeState.getLight();
	}

	public String getFreezerLight() {
		return freezerState.getLight();
	}

	public int getDesiredFridgeTemp() {
		return desiredFridgeTemp;
	}

	public int getDesiredFreezerTemp() {
		return desiredFreezerTemp;
	}

	public void setDesiredFridgeTemp(int desiredFridgeTemp) {
		this.fridgeHigh = desiredFridgeTemp + allowableDifferance;
		this.fridgeLow = desiredFridgeTemp - allowableDifferance;
		this.desiredFridgeTemp = desiredFridgeTemp;
	}

	public void setDesiredFreezerTemp(int desiredFreezerTemp) {
		this.freezerHigh = desiredFreezerTemp + allowableDifferance;
		this.freezerLow = desiredFreezerTemp - allowableDifferance;
		this.desiredFreezerTemp = desiredFreezerTemp;
	}

	public static void main(String[] args) {
		Clock clock = new Clock();
	}

}
