package src;

public class CoolingFridgeDoorClosed implements FridgeState {

	private Refrigerator refrigerator;
	private final int rateOfChange;
	private final boolean cooler = true;

	public CoolingFridgeDoorClosed(Refrigerator fridge) {
		refrigerator = fridge;
		rateOfChange = fridge.getFridgeCoolerRate();
	}

	@Override
	public void openDoor() {
		refrigerator.setFridgeState(refrigerator.getIdleFridgeDoorOpen());
	}

	@Override
	public void closeDoor() {
		// Do nothing
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
