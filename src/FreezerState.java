package src;

public interface FreezerState {
	void openDoor();

	void closeDoor();

	int getRateOfChange();

	boolean getCooling();

	void handle(Object arg);

	void run();

	String getCoolingState();

	String getLightState();
}
