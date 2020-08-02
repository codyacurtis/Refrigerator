package src;

public interface FreezerState {
	void openDoor();

	void closeDoor();

	int getRateOfChange();

	boolean getCooling();

	void handle(Object arg);

	void run();
<<<<<<< HEAD
	
	String getLight();
=======

	String getCoolingState();

	String getLightState();
>>>>>>> branch 'master' of https://github.com/codyacurtis/Refrigerator.git
}
