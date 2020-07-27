package src;

public class Refrigerator {

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
 

	private int defaultFridgeTemp;
	private int defaultFreezerTemp;

	private int userFridgeTemp;
	private int userFreezerTemp;

	private int currentFridgeTemp = 39;
	private int currentFreezerTemp = -5;
	private int fridgeLow = 37;
	private int fridgeHigh = 41;
	private int freezerLow = -9;
	private int freezerHigh = 0;
	private int ambientTemp = 65;

	private int fridgeSeconds = 0;
	private int freezerSeconds = 0;

	private int fridgeRateOfChange = 0;
	private int freezerRateOfChange = 0;

	private boolean fridgeCooling = false;
	private boolean freezerCooling = false;

	private boolean fridgeDoorOpen = false;
	private boolean freezerDoorOpen = false;
	private static Refrigerator refrigerator;

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

	}

	public void clockTicked() {
		// This will be triggered every second
		// Very similar to a run method
		
		//Updates the temp
		if (fridgeState.getRateOfChange() <= fridgeSeconds) {
			fridgeSeconds = 0;
			currentFridgeTemp = (fridgeState.getCooling()) ? currentFridgeTemp - 1 : currentFridgeTemp + 1;
		}
		if (freezerState.getRateOfChange() <= freezerSeconds) {
			freezerSeconds = 0;
			currentFreezerTemp = (freezerState.getCooling()) ? currentFreezerTemp - 1 : currentFreezerTemp + 1;
		}
		fridgeSeconds++;
		freezerSeconds++;
		
		//Turn on the cooling on or off if the temp is too high or too low
		if(currentFridgeTemp >fridgeHigh && !fridgeDoorOpen) {
			setFridgeState(coolingFridgeDoorClosed);
		}else if(currentFridgeTemp < fridgeLow && !fridgeDoorOpen) {
			setFridgeState(idleFridgeDoorClosed);
		}
		
		if(currentFreezerTemp >freezerHigh && !freezerDoorOpen) {
			setFreezerState(coolingFreezerDoorClosed);
		}else if(currentFreezerTemp < freezerLow && !freezerDoorOpen) {
			setFreezerState(idleFreezerDoorClosed);
		}
		
		

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

}
