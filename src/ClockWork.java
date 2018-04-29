import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class ClockWork {

	// Clock parameters

	private int longArmIndex, shortArmIndex, secondArmIndex;
	private int radius, centerX, centerY;
	private int[] x, y, xx, yy;
	private int tickTime;

	// Functional and communication fields

	private Timer timer;
	private ActionListener listener;
	private ActionEvent event;

	// Methods

	public ClockWork() { // Constructor
		
	}

	// Setters and getters

	public int[] getIndexValues() {
		int[] arr = null;
		arr[0] = longArmIndex;
		arr[1] = shortArmIndex;
		arr[2] = secondArmIndex;
		return arr;
	}

	public int[][] getXYValues() {
		int[][] arr = null;
		for (int k = 0; k < x.length; k++) {
			arr[0][k] = x[k];
		}
		for (int k = 0; k < y.length; k++) {
			arr[1][k] = y[k];
		}
		return arr;
	}

	public void setTickTime(int tick) { // Set tick time
		tickTime = tick;
	}

	public void addActionListener(ActionListener watch) { // Setter for listener
		
	}

	public void loadTacks() { // Populate four end-point coord-arrs for tacks
		/*
		 * For loop needed Math.cos and Math.sin needed for calcs Try to figure out math
		 * before using hint
		 */

		for (int k = 0; k < 4; k++) {
			x[k] = (int) (centerX + radius * Math.sin(2 * k * Math.PI / 60));
			y[k] = (int) (centerY - radius * Math.cos(2 * k * Math.PI / 60));
		}

	}

	public void makeTimer() { // Instantiates new timer object for timer
		/*
		 * constructor parameters are tickTime for delay new TimerListener (object from
		 * inner class later)
		 */

		Timer timer = new Timer(tickTime, listener);
		TimerListener timerListener = new TimerListener();
		timer.start();
	}

	public void stop() { // Calls stop method of timer class
		/*
		 * Timer.stop most likely
		 */

		timer.stop();

	}

	public void reset() { // Resets the timer
		/*
		 * Stops the timer resets arm index values to 0 calls connect()
		 */
		
		timer.stop();
		longArmIndex = 0;
		shortArmIndex = 0;
		secondArmIndex = 0;
		connect();
		
	}

	private boolean timeFormat(String inp) { // Validates parameter inp if it is correct, t/f based on validation
		boolean tf = false;
		if (inp.indexOf(":") == 3) {
			if (inp.charAt(1) >= 0 && inp.charAt(1) <= 1) {
				if (inp.charAt(2) >= 0 && inp.charAt(2) <= 9) {
					if (inp.charAt(4) >= 0 && inp.charAt(4) <= 5) {
						if (inp.charAt(5) >= 0 && inp.charAt(5) <= 9) {
							tf = true;
						}
					}
				}
			}
		}
		return tf;
	}

	public void setClock(String timeToSet) { // Calls timeFormat to validate timeToSet, if not valid method returns
		if (timeFormat(timeToSet) == true) {
			shortArmIndex = timeToSet.charAt(1) + timeToSet.charAt(2);
			System.out.println("At line 105 the shortArmIndex is " + shortArmIndex);
			longArmIndex = timeToSet.charAt(4) + timeToSet.charAt(5);
			System.out.println("At line 107 the longArmIndex is " + longArmIndex);
			secondArmIndex = 0;
		} else if (timeFormat(timeToSet) == false) {
			System.out.println("Please enter an appropriate time format");
		}
		connect();
	}

	private void connect() { // Calls actionPerformed() with respect to listener as prefix and event in
								// parameter
		listener.actionPerformed(event);
	}

	public class TimerListener { // Class to hold ActionListener for timer

		public void actionPerformed(ActionEvent event) { //
			/*
			 * Updates secondsArmIndex reduced modulo 60 if secondArmIndex is 0 { update
			 * longArmIndex modulo 60}
			 * 
			 * if longArmIndex is divisible by 12 { update shortArmIndex modulo 60}
			 * 
			 * call connect()
			 */

			if (secondArmIndex == 0) {
				// update longArmIndex modulo 60
			}
			if (longArmIndex % 12 == 0) {
				// update shortArmIndex modulo 60
			}

			connect();
		}

	}

}
