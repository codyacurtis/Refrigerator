package src;
public class CoolingFridgeDoorClosed implements FridgeState {

	private Refrigerator refrigerator ;
	public CoolingFridgeDoorClosed(Refrigerator fridge) {
		refrigerator = fridge;
	}
	
	@Override
	public void openDoor() {
		refrigerator.setFridgeCoolingTemp(0);
		refrigerator.setFridgeWarmingTemp(refrigerator.getFridgeRateLossDoorOpen());
		refrigerator.setFridgeState(refrigerator.getIdleFridgeDoorOpen());

	}

	@Override
	public void closeDoor() {
		// Do nothing

	}

}
