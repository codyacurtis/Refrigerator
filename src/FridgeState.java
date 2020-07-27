package src;
public interface FridgeState {
	void openDoor();
	void closeDoor();
	int getRateOfChange();
	boolean getCooling();
}
