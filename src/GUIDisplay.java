package src;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GUIDisplay extends JFrame implements ActionListener, RefrigeratorDisplay {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Refrigerator refrigerator;
	private JLabel roomTemp = new JLabel("Room Temp");
	private JLabel desiredFridgeTemp = new JLabel("Desired Fridge Temp");
	private JLabel desiredFreezerTemp = new JLabel("Desired Freezer Temp");
	private JTextField newRoomTemp = new JTextField(3);
	private JTextField newFridgeTemp = new JTextField(3);
	private JTextField newFreezerTemp = new JTextField(3);
	private JButton setRoomTemp = new JButton("Set Room Temp");
	private JButton setFridgeTemp = new JButton("Set Fridge Temp");
	private JButton setFreezerTemp = new JButton("Set Freezer Temp");
	private JButton fridgeDoorCloser = new JButton("Close Fridge Door");
	private JButton fridgeDoorOpener = new JButton("Open Fridge Door");
	private JButton freezerDoorCloser = new JButton("Close Freezer Door");
	private JButton freezerDoorOpener = new JButton("Open Freezer Door");
	private JLabel status = new JLabel("Status");
	private JLabel fridgeDoorStatus = new JLabel("Fridge Light Off");
	private JLabel freezerDoorStatus = new JLabel("Freezer Light Off");
	private JLabel fridgeTempStatus = new JLabel("Fridge Temp 39");
	private JLabel freezerTempStatus = new JLabel("Freezer Temp -7");
	private JLabel fridgeCoolingStatus = new JLabel("Fridge Idle");
	private JLabel freezerCoolingStatus = new JLabel("Freezer Idle");

	public GUIDisplay() {
		super("Refrigerator");
		getContentPane().setLayout(new GridBagLayout());

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent event) {
				System.exit(0);
			}
		});

		JPanel thePanel = new JPanel();
		thePanel.setLayout(new GridBagLayout());

		JPanel updatePanel = new JPanel();
		updatePanel.setLayout(new GridBagLayout());

		addComp(updatePanel, roomTemp, 0, 0, 1, 1, GridBagConstraints.EAST, GridBagConstraints.NONE);
		addComp(updatePanel, newRoomTemp, 1, 0, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.NONE);
		addComp(updatePanel, setRoomTemp, 2, 0, 1, 1, GridBagConstraints.WEST, GridBagConstraints.NONE);
		addComp(updatePanel, desiredFridgeTemp, 0, 1, 1, 1, GridBagConstraints.EAST, GridBagConstraints.NONE);
		addComp(updatePanel, newFridgeTemp, 1, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.NONE);
		addComp(updatePanel, setFridgeTemp, 2, 1, 1, 1, GridBagConstraints.WEST, GridBagConstraints.NONE);
		addComp(updatePanel, desiredFreezerTemp, 0, 2, 1, 1, GridBagConstraints.EAST, GridBagConstraints.NONE);
		addComp(updatePanel, newFreezerTemp, 1, 2, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.NONE);
		addComp(updatePanel, setFreezerTemp, 2, 2, 1, 1, GridBagConstraints.WEST, GridBagConstraints.NONE);

		setRoomTemp.addActionListener(GUIDisplay.this);
		setFridgeTemp.addActionListener(GUIDisplay.this);
		setFreezerTemp.addActionListener(GUIDisplay.this);

		addComp(thePanel, updatePanel, 0, 0, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.NONE);

		JPanel stateButtons = new JPanel();
		stateButtons.setLayout(new GridBagLayout());

		addComp(stateButtons, fridgeDoorOpener, 0, 0, 1, 1, GridBagConstraints.WEST, GridBagConstraints.NONE);
		addComp(stateButtons, fridgeDoorCloser, 0, 1, 1, 1, GridBagConstraints.WEST, GridBagConstraints.NONE);
		addComp(stateButtons, freezerDoorOpener, 1, 0, 1, 1, GridBagConstraints.EAST, GridBagConstraints.NONE);
		addComp(stateButtons, freezerDoorCloser, 1, 1, 1, 1, GridBagConstraints.EAST, GridBagConstraints.NONE);
		fridgeDoorOpener.addActionListener(GUIDisplay.this);
		fridgeDoorCloser.addActionListener(GUIDisplay.this);
		freezerDoorOpener.addActionListener(GUIDisplay.this);
		freezerDoorCloser.addActionListener(GUIDisplay.this);

		addComp(thePanel, stateButtons, 0, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.NONE);

		addComp(thePanel, status, 0, 2, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.NONE);

		JPanel refrigeratorStatus = new JPanel();
		refrigeratorStatus.setLayout(new GridBagLayout());

		addComp(refrigeratorStatus, fridgeDoorStatus, 0, 0, 1, 1, GridBagConstraints.WEST, GridBagConstraints.NONE);
		addComp(refrigeratorStatus, freezerDoorStatus, 1, 0, 1, 1, GridBagConstraints.WEST, GridBagConstraints.NONE);
		addComp(refrigeratorStatus, fridgeTempStatus, 0, 1, 1, 1, GridBagConstraints.WEST, GridBagConstraints.NONE);
		addComp(refrigeratorStatus, freezerTempStatus, 1, 1, 1, 1, GridBagConstraints.WEST, GridBagConstraints.NONE);
		addComp(refrigeratorStatus, fridgeCoolingStatus, 0, 2, 1, 1, GridBagConstraints.WEST, GridBagConstraints.NONE);
		addComp(refrigeratorStatus, freezerCoolingStatus, 1, 2, 1, 1, GridBagConstraints.WEST, GridBagConstraints.NONE);

		addComp(thePanel, refrigeratorStatus, 0, 3, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.NONE);

		this.add(thePanel);

		pack();
		setVisible(true);

	}

	private void addComp(JPanel thePanel, JComponent comp, int xPos, int yPos, int compWidth, int compHeight,
			int anchor, int strech) {

		GridBagConstraints gridConstraints = new GridBagConstraints();

		gridConstraints.gridx = xPos;
		gridConstraints.gridy = yPos;
		gridConstraints.gridwidth = compWidth;
		gridConstraints.gridheight = compHeight;
		gridConstraints.weightx = 100;
		gridConstraints.weighty = 100;
		gridConstraints.insets = new Insets(5, 5, 5, 5);
		gridConstraints.anchor = anchor;
		gridConstraints.fill = strech;

		thePanel.add(comp, gridConstraints);
	}

	/**
	 * Process the door buttons (closer and opener) and cook button by simply
	 * calling the Microwave object's methods.
	 * 
	 */
	@Override
	public void actionPerformed(ActionEvent event) {
		if (event.getSource().equals(this.fridgeDoorCloser)) {
			refrigerator.setFridgeState(refrigerator.getIdleFridgeDoorClosed());
			fridgeDoorClosed();
		} else if (event.getSource().equals(this.fridgeDoorOpener)) {
			refrigerator.setFridgeState(refrigerator.getIdleFridgeDoorOpen());
			fridgeDoorOpened();
		} else if (event.getSource().equals(this.freezerDoorCloser)) {
			refrigerator.setFreezerState(refrigerator.getIdleFreezerDoorClosed());
			freezerDoorClosed();
		} else if (event.getSource().equals(this.freezerDoorOpener)) {
			refrigerator.setFreezerState(refrigerator.getIdleFreezerDoorOpen());
			freezerDoorOpened();
		} else if (event.getSource().equals(this.setRoomTemp)) {
			refrigerator.setAmbientTemp(Integer.parseInt(this.newRoomTemp.getText()));
			this.newRoomTemp.setText(null);
		} else if (event.getSource().equals(this.setFridgeTemp)) {
			refrigerator.setDesiredFridgeTemp(Integer.parseInt(this.newFridgeTemp.getText()));
			this.newFridgeTemp.setText(null);
		} else if (event.getSource().equals(this.setFreezerTemp)) {
			refrigerator.setDesiredFreezerTemp(Integer.parseInt(this.newFreezerTemp.getText()));
			this.newFreezerTemp.setText(null);
		}
	}

	@Override
	public void fridgeDoorOpened() {
		setFridgeDoorStatus();
		fridgeCoolingStatus();
	}

	@Override
	public void fridgeDoorClosed() {
		setFridgeDoorStatus();
		fridgeCoolingStatus();
	}

	@Override
	public void freezerDoorOpened() {
		setFreezerDoorStatus();
		freezerCoolingStatus();
	}

	@Override
	public void freezerDoorClosed() {
		turnFreezerLightOff();

	}

	@Override
	public void turnFridgeLightOn() {
		this.fridgeDoorStatus.setText("Light On");
	}

	@Override
	public void turnFridgeLightOff() {
		this.fridgeDoorStatus.setText("Light Off");
	}

	@Override
	public void fridgeIdle() {
		this.fridgeCoolingStatus.setText("Fridge Idle");
	}

	@Override
	public void fridgeCooling() {
		this.fridgeCoolingStatus.setText("Fridge Cooling");
	}

	@Override
	public void turnFreezerLightOn() {
		this.freezerDoorStatus.setText("Freezer Light On");
	}

	@Override
	public void turnFreezerLightOff() {
		this.freezerDoorStatus.setText("Freezer Light Off");
	}

	@Override
	public void freezerIdle() {
		this.freezerCoolingStatus.setText("Freezer Idle");
	}

	@Override
	public void freezerCooling() {
		this.freezerCoolingStatus.setText("Freezer Cooling");
	}

	@Override
	public void setFridgeDoorStatus() {
		fridgeDoorStatus.setText("Fridge " + refrigerator.getFridgeLight());
	}

	@Override
	public void setFreezerDoorStatus() {
		freezerDoorStatus.setText("Freezer " + refrigerator.getFreezerLight());
	}

	@Override
	public void fridgeTempStatus() {
		fridgeTempStatus.setText("Fridge Temp " + refrigerator.getFridgeTemp());
	}

	@Override
	public void freezerTempStatus() {
		freezerTempStatus.setText("Freezer Temp " + refrigerator.getFreezerTemp());
	}

	@Override
	public void fridgeCoolingStatus() {
		fridgeCoolingStatus.setText(refrigerator.getFridgeCooling());
	}

	@Override
	public void freezerCoolingStatus() {
		freezerCoolingStatus.setText(refrigerator.getFreezerCooling());
	}

	@Override
	public void setRefrigerator(Refrigerator refrigerator) {
		this.refrigerator = refrigerator;
	}
}
