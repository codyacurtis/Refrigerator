package src;
public class IdleFridgeDoorClosed implements FridgeState {

	private Refrigerator refrigerator ;
	private final int  rateOfChange;
	private final boolean cooler = false;
	public IdleFridgeDoorClosed(Refrigerator fridge) {
		refrigerator = fridge;
		rateOfChange = fridge.getFridgeRateLossDoorClosed();
	}
	
	@Override
	public void openDoor() {
		refrigerator.setFridgeState(refrigerator.getIdleFridgeDoorOpen());
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
