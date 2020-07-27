
public class IdleFreezerDoorOpen implements FreezerState {

	private Refrigerator refrigerator ;
	public IdleFreezerDoorOpen(Refrigerator fridge) {
		refrigerator = fridge;
	}
	
	@Override
	public void openDoor() {
		//Do nothing
	}

	@Override
	public void closeDoor() {
		refrigerator.setFreezerCoolingTemp(0);
		refrigerator.setFreezerWarmingTemp(refrigerator.getFreezerRateLossDoorClosed);
		refrigerator.setFreezerState(IdleFreezerDoorClosed());

	}

}
