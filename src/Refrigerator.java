package src;

public class Refrigerator {	
	int ambientTemp;
	int currentFreezerTemp;
	
	int currentFridgeTemp;
	int defaultFreezerTemp;
	int defaultFridgeTemp;
	int freezerHigh = 0;
	int freezerLow = -9;
	int freezerRateLossDoorOpen;
	int freezerRateLosssDoorClosed;
	private FreezerState freezerState;
	int fridgeHigh = 41;
	int fridgeLow = 37;
	int fridgeRateLossDoorClosed;
	
	int fridgeRateLossDoorOpen;
	private FridgeState fridgeState;
	int userFreezerTemp;
	int userFridgeTemp;
	
	public void freezerCooling() {
		long test = System.currentTimeMillis();
		if(test >= (30*1000) && (currentFreezerTemp > userFreezerTemp + 1 || currentFreezerTemp > defaultFreezerTemp + 1)) {
		  currentFreezerTemp++; 
		}
	}

	public void freezerDoorCLose() {
		long test = System.currentTimeMillis();
		if(test >= (30*1000)) {
			  currentFreezerTemp--; 
			}
	}

	public void freezerDoorOpen() {
		long test = System.currentTimeMillis();
		if(test >= (1*1000) && currentFreezerTemp <= ambientTemp) {
			  currentFreezerTemp--; 
			}
	}

	public void fridgeCooling() {
		long test = System.currentTimeMillis();
		if(test >= (20*1000) && (currentFridgeTemp > userFridgeTemp + 2 || currentFridgeTemp < defaultFridgeTemp + 2)) {
		  currentFridgeTemp++; 
		}
	}

	public void fridgeDoorClose() {
		//can't be greater than ambientTemp
		long test = System.currentTimeMillis();
		if(test >= (30*1000)) {
			  currentFridgeTemp--; 
			}
	}

	public void fridgeDoorOpen() {
		long test = System.currentTimeMillis();
		if(test >= (2*1000) && currentFridgeTemp <= ambientTemp) {
			  currentFreezerTemp--; 
			}
	}
	
	public int getAmbientTemp() {
		return ambientTemp;
	}
	
	public int getFreezerRateLosssDoorClosed() {
		return freezerRateLosssDoorClosed;
	}
	
	public int getFreezerTemp() {
		return currentFreezerTemp;
	}
	
	public int getFridgeTemp() {
		return currentFridgeTemp;
	}
	
	public void setAmbientTemp(int temperature) {
		ambientTemp = temperature;
	}

	public void setFreezerRateLossDoorOpen(int freezerRateLossDoorOpen) {
		this.freezerRateLossDoorOpen = freezerRateLossDoorOpen;
	}

	public void setFreezerRateLosssDoorClosed(int freezerRateLosssDoorClosed) {
		this.freezerRateLosssDoorClosed = freezerRateLosssDoorClosed;
	}

	public void setFridgeRateLossDoorClosed(int fridgeRateLossDoorClosed) {
		this.fridgeRateLossDoorClosed = fridgeRateLossDoorClosed;
	}

	public void setFridgeRateLossDoorOpen(int fridgeRateLossDoorOpen) {
		this.fridgeRateLossDoorOpen = fridgeRateLossDoorOpen;
	}

	public void setUserFreezerTemp(int temperature) {
		userFreezerTemp = temperature;
	}

	public void setUserFridgeTemp(int temperature) {
		userFridgeTemp = temperature;
	}

}
