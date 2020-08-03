package src;

public class IdleFreezerDoorOpen implements FreezerState {

	private Refrigerator refrigerator;
	private final int rateOfChange;
	private final boolean cooler = false;

	public IdleFreezerDoorOpen(Refrigerator fridge) {
		refrigerator = fridge;
		rateOfChange = fridge.getFridgeRateLossDoorOpen();
	}

	@Override
	public void openDoor() {
		// Do nothing
	}

	@Override
	public void closeDoor() {
		refrigerator.setFreezerState(refrigerator.getIdleFreezerDoorClosed());

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

	@Override
	public String toString() {
		return "IdleFreezerDoorOpen";
	}

	@Override
	public String getLight() {
		return "Light On";
	}
	@Override
	public boolean getDoor() {
		// TODO Auto-generated method stub
		return true;
	}

}
