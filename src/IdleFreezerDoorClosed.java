package src;

public class IdleFreezerDoorClosed implements FreezerState{

	private Refrigerator refrigerator ;
	private final int  rateOfChange;
	private final boolean cooler = false;
	
	public IdleFreezerDoorClosed(Refrigerator fridge) {
		refrigerator = fridge;
		rateOfChange = fridge.getFreezerRateLossDoorClosed();
	}
	
	@Override
	public void openDoor() {
		refrigerator.setFreezerState(refrigerator.getIdleFreezerDoorOpen());
	}

	@Override
	public void closeDoor() {
		//Do nothing
	}

	@Override
	public int getRateOfChange() {
		return rateOfChange;
	}

	@Override
	public boolean getCooling() {
		return cooler;
	}

}
