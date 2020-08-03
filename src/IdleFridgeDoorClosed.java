package src;

public class IdleFridgeDoorClosed implements FridgeState {

	private Refrigerator refrigerator;
	private final int rateOfChange;
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

	public static Object instance() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void handle(Object arg) {
		// TODO Auto-generated method stub

	}
	
	@Override
	public String toString() {
		return "IdleFridgeDoorClosed";
	}

	@Override
	public String getLight() {
		return "Light Off";
	}
	@Override
	public boolean getDoor() {
		// TODO Auto-generated method stub
		return false;
	}
}
