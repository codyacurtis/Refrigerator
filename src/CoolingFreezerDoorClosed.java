package src;

public class CoolingFreezerDoorClosed implements FreezerState {

	private Refrigerator refrigerator;
	private final int rateOfChange;
	private final boolean cooler = true;

	public CoolingFreezerDoorClosed(Refrigerator fridge) {
		refrigerator = fridge;
		rateOfChange = fridge.getFreezerCoolerRate();
	}

	@Override
	public void openDoor() {
		refrigerator.setFreezerState(refrigerator.getIdleFreezerDoorOpen());
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

	@Override
	public String toString() {
		return "Freezer Door Closed";
	}

	@Override
	public String getLight() {
		return "Light Off";
	}

}
