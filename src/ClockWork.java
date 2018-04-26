import java.awt.event.ActionListener;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.Timer;

public class ClockWork {
	
	//Clock parameters
	
	private int longArmIndex, shortArmIndex, secondsArmIndex;
	private int radius, centerX, centerY;
	private int[] x, y, xx, yy;
	private int tickTime;
	
	//Functional and communication fields
	
	private Timer timer;
	private ActionListener listener;
	private ActionEvent event;
	
	//Methods
	
	public ClockWork() { //Constructor
		
	}
	
	//Setters and getters
	
	public void setTickTime(int tick) { //Set tick time
		tickTime = tick;
	}
	
	public void addActionListener(ActionListener watch) { //Setter for listener
		
	}
	
	public void loadTacks() { //Populate four end-point coord-arrs for tacks
		/*
		 * For loop needed
		 * Math.cos and Math.sin needed for calcs
		 * Try to figure out math before using hint
		 */
	}
	
	public void makeTimer() { //Instantiates new timer object for timer
		/*
		 * constructor parameters are tickTime for delay
		 * new TimerListener (object from inner class later)
		 */
	}
	
	public void stop() { //Calls stop method of timer class
		/*
		 * Timer.stop most likely
		 */
	}
	
	public void reset() { //Resets the timer
		/*
		 * Stops the timer
		 * resets arm index values to 0
		 * calls connect()
		 */
	}
	
	private boolean timeFormat(String inp) { //Validates parameter inp if it is correct, t/f based on validation
		return inp != null; //Placeholder
	}
	
	public void setClock(String timeToSet) { //CAlls timeFormat to validate timeToSet, if not valid method returns
		
	}
	
	private void connect() { //Calls actionPerformed() with respect to listener as prefix and event in parameter
		
	}
	
	public class TimerListener { //Class to hold ActionListener for timer
		
		public void actionPerformed(ActionEvent event) { //
			/*
			 * Updates secondArmIndex reduced modulo 60
			 * if secondsArmIndex is 0 {
			 * update longArmIndex modulo 60}
			 * 
			 * if longArmIndex is divisible by 12 {
			 * update shortArmIndex modulo 60}
			 * 
			 * call connect()
			 */
		}
		
	}
	
}
