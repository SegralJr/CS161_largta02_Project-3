import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.*;
import java.awt.*;

public class ControlDevices extends JFrame implements ActionListener, ChangeListener {
	
	// Data fields
	
	private ClockWork work;
	private JTextField textField = new JTextField("Please enter the time here");
	
	private JLabel
	enterTimeLabel = new JLabel("Enter time use format 15:42"),
	selectTickTimeLabel = new JLabel("Select tick time"),
	clickStart = new JLabel("Click to start the clock"),
	clickStop = new JLabel("Click to stop the clock"),
	clickReset = new JLabel("Click to reset the clock");
	
	private JButton
	runButton = new JButton("Run the Clock"),
	stopButton = new JButton("Stop the Clock"),
	resetButton = new JButton("Reset the Clock"),
	setButton = new JButton("Set the Clock");
	
	private JPanel
	east = new JPanel(),
	center = new JPanel();
	
	private JSlider tickSlider = new JSlider(JSlider.VERTICAL, 0, 1000, 1000);
	
	//Constructor
	
	public ControlDevices(ClockWork cw) { //Constructor
		super("Controls for the clock");
		work  = new ClockWork();
		makeSlider();
		buildControlGUI();
	}
	
	//Instance methods
	
	private void makeSlider() { //Creates the slider
		tickSlider.setPaintLabels(true);
		tickSlider.setPaintTicks(true);
		tickSlider.setMajorTickSpacing(100);
		tickSlider.setMinorTickSpacing(10);
		
		tickSlider.addChangeListener(this);
		
	}
	
	private void buildControlGUI() { //Creates the GUI
		/*
		 * Apply necessary JPanels
		 * GUI shown is built on CENTER and EAST regions of pane's BorderLayout
		 * Panel in center applies nested GridLayout
		 * Individual GUI design is welcome as long as control provides needed info and functionality
		 */
		
		Container window = getContentPane();
		
		JPanel runPane = new JPanel(),
				stopPane = new JPanel(),
				resetPane = new JPanel(),
				setPane = new JPanel();
		
		runPane.add(runButton);
		runPane.add(clickStart);
		runButton.addActionListener(this);
		
		stopPane.add(stopButton);
		stopPane.add(clickStop);
		stopButton.addActionListener(this);
		
		resetPane.add(resetButton);
		resetPane.add(clickReset);
		resetButton.addActionListener(this);
		
		setPane.add(enterTimeLabel);
		setPane.add(textField);
		setPane.add(setButton);
		setButton.addActionListener(this);
		
		center.setLayout(new GridLayout(4,0));
		
		center.add(runPane);
		center.add(stopPane);
		center.add(resetPane);
		center.add(setPane);
		
		window.add(center, BorderLayout.WEST);
		
		JPanel sliderPane = new JPanel();
		
		sliderPane.add(tickSlider);
		
		east.add(sliderPane);
		east.add(selectTickTimeLabel);
		
		window.add(east, BorderLayout.EAST);
		
		setSize(700, 650);
		setLocation(400, 400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void stateChanged(ChangeEvent event) { //Method from ChangeListener interface
		work.setTickTime(tickSlider.getValue());
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
		
		if(event.getActionCommand() == "Stop the Clock") {
			work.stop();
			runButton.setEnabled(true);
		}
		if(event.getActionCommand() == "Run the Clock") {
			runButton.setEnabled(false);
		}
		if(event.getActionCommand() == "Reset the Clock") {
			runButton.setEnabled(true);
		}
		if(event.getActionCommand() == "Set the Clock") {
			work.setClock(textField.getText());
			textField.setText("");
		}
	}
	
}
