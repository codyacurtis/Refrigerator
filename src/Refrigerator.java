
public class Refrigerator {

	
	
	Fridge freezerState;
	Fridge fridgeState;
	
	
	int defaultFridgeTemp;
	int defaultFreezerTemp;
	int userFridgeTemp;
	int userFreezerTemp;
	int currentFridgeTemp;
	int currentFreezerTemp;
	int fridgeLow = 37;
	int fridgeHigh = 41;
	int freezerLow = -9;
	int freezerHigh = 0;
	int ambientTemp;
	
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
	
	public void setUserFridgeTemp(int temperature) {
		userFridgeTemp = temperature;
	}
	
	public void setUserFreezerTemp(int temperature) {
		userFreezerTemp = temperature;
	}
	
	
	public void fridgeCooling() {
		long test = System.currentTimeMillis();
		if(test >= (20*1000) && (currentFridgeTemp > userFridgeTemp + 2 || currentFridgeTemp < defaultFridgeTemp + 2)) {
		  currentFridgeTemp++; 
		}
	}
	
	public void freezerCooling() {
		long test = System.currentTimeMillis();
		if(test >= (30*1000) && (currentFreezerTemp > userFreezerTemp + 1 || currentFreezerTemp > defaultFreezerTemp + 1)) {
		  currentFreezerTemp++; 
		}
	}
	
	public void fridgeDoorClose() {
		//can't be greater than ambientTemp
		long test = System.currentTimeMillis();
		if(test >= (30*1000)) {
			  currentFridgeTemp--; 
			}
	}
	
	public void freezerDoorCLose() {
		long test = System.currentTimeMillis();
		if(test >= (30*1000)) {
			  currentFreezerTemp--; 
			}
	}
	
	
	public void fridgeDoorOpen() {
		long test = System.currentTimeMillis();
		if(test >= (2*1000) && currentFridgeTemp <= ambientTemp) {
			  currentFreezerTemp--; 
			}
	}
	
	
	public void freezerDoorOpen() {
		long test = System.currentTimeMillis();
		if(test >= (1*1000) && currentFreezerTemp <= ambientTemp) {
			  currentFreezerTemp--; 
			}
	}
}
