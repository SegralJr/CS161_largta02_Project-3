import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class ControlDevices extends JFrame implements ActionListener {
	
	// Data fields
	
	private ClockWork work;
	private JTextField textField = new JTextField();
	
	private JLabel
	enterTimeLabel = new JLabel("Enter time use format 15:42"),
	selectTickTimeLabel = new JLabel("Select tick time");
	
	private JButton
	runButton = new JButton("Run the Clock"),
	stopButton = new JButton("Stop the Clock"),
	resetButton = new JButton("Reset the Clock"),
	setButton = new JButton("Set the Clock");
	
	private JSlider tickSlider = new JSlider(JSlider.VERTICAL, 0, 1000, 1000);
	
	/*
	 * All of above swing components can be instantiated at declaration
	 */
	
	//Constructor
	
	public ControlDevices(ClockWork cw) { //Constructor
		/*
		 * Initializes data field work
		 * Calls makeSlider()
		 * Calls buildControlGUI()
		 */
		
		work  = new ClockWork();
		makeSlider();
		buildControlGUI();
	}
	
	//Instance methods
	
	private void makeSlider() { //Creates the slider
		/*
		 * Creates the slider
		 * Book, lecture material, and lab 8 experience apply
		 */
		
		tickSlider.setPaintLabels(true);
		tickSlider.setPaintTicks(true);
		tickSlider.setMajorTickSpacing(100);
		tickSlider.setMinorTickSpacing(10);
		
		tickSlider.addChangeListener((ChangeListener) this);
		
	}
	
	private void buildControlGUI() { //Creates the GUI
		/*
		 * Apply necessary JPanels
		 * GUI shown is built on CENTER and EAST regions of pane's BorderLayout
		 * Panel in center applies nested GridLayout
		 * Individual GUI design is welcome as long as control provides needed info and functionality
		 */
	}
	
	public void stateChanged(ChangeEvent event) { //Method from ChangeListener interface
		/*
		 * Calls setter method of tickTime field of ClockWork
		 * Passes current value of slider as parameter
		 */
	}
	
	public void actionPerformed(ActionEvent event) { //Event occurred when component pressed
		/*
		 * If source is:
		 * stop button, then enables run and calls stop() of ClockWork
		 * run button, then disables run and calls makeTimer() of ClockWork
		 * reset button, then enables run and calls reset() of ClockWork
		 * setClock button, then calls setClock() of ClockWork
		 * (passing text from text field as parameter,
		 * sets text field the empty string)
		 */
	}
	
}
