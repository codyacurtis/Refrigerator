package src;
public class IdleFridgeDoorOpen implements FridgeState {
	
	private Refrigerator refrigerator ;
	public IdleFridgeDoorOpen(Refrigerator fridge) {
		refrigerator = fridge;
	}
	
	@Override
	public void openDoor() {
		//Do nothing

	}

	@Override
	public void CloseDoor() {
		refrigerator.setFridgeCoolingTemp(0);
		refrigerator.setFridgeWarmingTemp(refrigerator.getFridgeRateLossDoorClosed());
		refrigerator.setFridgeState(refrigerator.getIdleFridgeDoorClosed());

	}

}
