
public class CoolingFreezerDoorClosed implements FreezerState {
	
	private Refrigerator refrigerator ;
	public CoolingFreezerDoorClosed(Refrigerator fridge) {
		refrigerator = fridge;
	}
	
	
	@Override
	public void openDoor() {
		refrigerator.setFreezerCoolingTemp(0);
		refrigerator.setFreezerWarmingTemp(refrigerator.getFreezerRateLossDoorOpen);
		refrigerator.setFreezerState(IdleFreezerDoorOpen());
	}

	@Override
	public void closeDoor() {
		// Do nothing

	}

}
