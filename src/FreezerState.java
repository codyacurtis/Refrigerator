package src;
public interface FreezerState {
	void openDoor();
	void closeDoor();
	int getRateOfChange();
	boolean getCooling();
}
