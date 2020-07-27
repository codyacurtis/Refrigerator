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

	private int fridgeWarmingTemp;
	private int freezerWarmingTemp;
	private int fridgeCoolingTemp;
	private int freezerCoolingTemp;

	private int FridgeRateLossDoorClosed = 30;
	private int FridgeRateLossDoorOpen = 2;
	private int FreezerRateLossDoorClosed = 10;
	private int FreezerRateLossDoorOpen = 1;

	private int defaultFridgeTemp;
	private int defaultFreezerTemp;
	private int userFridgeTemp;
	private int userFreezerTemp;
	private int currentFridgeTemp;
	private int currentFreezerTemp;
	private int fridgeLow = 37;
	private int fridgeHigh = 41;
	private int freezerLow = -9;
	private int freezerHigh = 0;
	private int ambientTemp;

	public Refrigerator() {
		this.coolingFreezerDoorClosed = new CoolingFreezerDoorClosed(this);
		this.coolingFridgeDoorClosed = new CoolingFridgeDoorClosed(this);
		this.idleFreezerDoorClosed = new IdleFreezerDoorClosed(this);
		this.idleFridgeDoorClosed = new IdleFridgeDoorClosed(this);
		this.idleFreezerDoorOpen = new IdleFreezerDoorOpen(this);
		this.idleFridgeDoorOpen = new IdleFridgeDoorOpen(this);

		this.freezerState = idleFreezerDoorClosed;
		this.fridgeState = idleFridgeDoorClosed;

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

	public void fridgeCooling() {
		long test = System.currentTimeMillis();
		if (test >= (20 * 1000)
				&& (currentFridgeTemp > userFridgeTemp + 2 || currentFridgeTemp < defaultFridgeTemp + 2)) {
			currentFridgeTemp++;
		}
	}

	public void freezerCooling() {
		long test = System.currentTimeMillis();
		if (test >= (30 * 1000)
				&& (currentFreezerTemp > userFreezerTemp + 1 || currentFreezerTemp > defaultFreezerTemp + 1)) {
			currentFreezerTemp++;
		}
	}

	public void fridgeDoorClose() {
		// can't be greater than ambientTemp
		long test = System.currentTimeMillis();
		if (test >= (30 * 1000)) {
			currentFridgeTemp--;
		}
	}

	public void freezerDoorCLose() {
		long test = System.currentTimeMillis();
		if (test >= (30 * 1000)) {
			currentFreezerTemp--;
		}
	}

	public void fridgeDoorOpen() {
		long test = System.currentTimeMillis();
		if (test >= (2 * 1000) && currentFridgeTemp <= ambientTemp) {
			currentFreezerTemp--;
		}
	}

	public void freezerDoorOpen() {
		long test = System.currentTimeMillis();
		if (test >= (1 * 1000) && currentFreezerTemp <= ambientTemp) {
			currentFreezerTemp--;
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

	public int getFridgeWarmingTemp() {
		return fridgeWarmingTemp;
	}

	public int getFreezerWarmingTemp() {
		return freezerWarmingTemp;
	}

	public int getFridgeCoolingTemp() {
		return fridgeCoolingTemp;
	}

	public int getFreezerCoolingTemp() {
		return freezerCoolingTemp;
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

	public void setFridgeWarmingTemp(int fridgeWarmingTemp) {
		this.fridgeWarmingTemp = fridgeWarmingTemp;
	}

	public void setFreezerWarmingTemp(int freezerWarmingTemp) {
		this.freezerWarmingTemp = freezerWarmingTemp;
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
		return FridgeRateLossDoorClosed;
	}

	public int getFridgeRateLossDoorOpen() {
		return FridgeRateLossDoorOpen;
	}

	public int getFreezerRateLossDoorClosed() {
		return FreezerRateLossDoorClosed;
	}

	public int getFreezerRateLossDoorOpen() {
		return FreezerRateLossDoorOpen;
	}

	public void setFridgeRateLossDoorClosed(int fridgeRateLossDoorClosed) {
		FridgeRateLossDoorClosed = fridgeRateLossDoorClosed;
	}

	public void setFridgeRateLossDoorOpen(int fridgeRateLossDoorOpen) {
		FridgeRateLossDoorOpen = fridgeRateLossDoorOpen;
	}

	public void setFreezerRateLossDoorClosed(int freezerRateLossDoorClosed) {
		FreezerRateLossDoorClosed = freezerRateLossDoorClosed;
	}

	public void setFreezerRateLossDoorOpen(int freezerRateLossDoorOpen) {
		FreezerRateLossDoorOpen = freezerRateLossDoorOpen;
	}
	
	

}
