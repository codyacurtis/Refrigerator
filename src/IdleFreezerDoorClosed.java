package src;
public class IdleFreezerDoorClosed implements FridgeState{

	private Refrigerator refrigerator ;
	public IdleFreezerDoorClosed(Refrigerator fridge) {
		refrigerator = fridge;
	}
	
	@Override
	public void openDoor() {
		refrigerator.setFreezerCoolingTemp(0);
		refrigerator.setFreezerWarmingTemp(refrigerator.getFreezerRateLossDoorOpen());
		refrigerator.setFreezerState(refrigerator.getIdleFreezerDoorOpen());
	}

	@Override
	public void CloseDoor() {
		//Do nothing
	}

}
