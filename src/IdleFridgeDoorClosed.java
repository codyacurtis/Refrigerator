
public class IdleFridgeDoorClosed implements FridgeState {

	private Refrigerator refrigerator ;
	public IdleFridgeDoorClosed(Refrigerator fridge) {
		refrigerator = fridge;
	}
	
	@Override
	public void openDoor() {
		refrigerator.setFridgeCoolingTemp(0);
		refrigerator.setFridgeWarmingTemp(refrigerator.getFridgeRateLossDoorOpen);
		refrigerator.setFridgeState(IdleFridgeDoorClosed());
	}

	@Override
	public void CloseDoor() {
		//Do nothing
	}

}
