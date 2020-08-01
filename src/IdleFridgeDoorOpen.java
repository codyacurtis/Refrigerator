package src;

public class IdleFridgeDoorOpen implements FridgeState {

	private Refrigerator refrigerator;
	private final int rateOfChange;
	private final boolean cooler = false;

	public IdleFridgeDoorOpen(Refrigerator fridge) {
		refrigerator = fridge;
		rateOfChange = fridge.getFridgeRateLossDoorOpen();
	}

	@Override
	public void openDoor() {
		// Do nothing
	}

	@Override
	public void closeDoor() {
		refrigerator.setFridgeState(refrigerator.getIdleFridgeDoorClosed());

	}

	@Override
	public int getRateOfChange() {
		return rateOfChange;
	}

	@Override
	public boolean getCooling() {
		return cooler;
	}

	@Override
	public void handle(Object arg) {
		// TODO Auto-generated method stub

	}

}
