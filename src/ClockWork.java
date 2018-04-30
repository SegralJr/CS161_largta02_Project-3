import java.awt.event.ActionListener;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.Timer;

public class ClockWork {
	
	//Clock parameters
	
	private int longArmIndex, shortArmIndex, secondArmIndex;
	private int radius, centerX, centerY;
	private int[] x, y, xx, yy;
	private int tickTime;
	
	protected int[][] endsX = null, endsY = null;
	
	//Functional and communication fields
	
	private Timer timer;
	private ActionListener listener;
	private ActionEvent event;
	
	//Methods
	
	public ClockWork() { //Constructor
		
	}
	
	//Setters and getters
	
	public int[] getIndexValues() {
		int[] arr = null;
		arr[0] = longArmIndex;
		arr[1] = shortArmIndex;
		arr[2] = secondArmIndex;
		return arr;
	}
	
	public int[][] getXYValues() {
		int[][] arr = null;
		for(int k = 0; k < x.length; k++) {
			arr[0][k] = x[k];
		}
		for(int k = 0; k < y.length; k++) {
			arr[1][k] = y[k];
		}
		return arr;
	}
	
	public void setTickTime(int tick) { //Set tick time
		tickTime = tick;
	}
	
	public void addActionListener(ActionListener watch) { //Setter for listener
		
	}
	
	public void loadTacks() { //Populate four end-point coord-arrs for tacks
		for(int k = 0; k < 4; k++) {
			for(int j = 0; j < 15; j++) {
				x[j] = (int) (centerX + radius*Math.sin(2*k*Math.PI/60));
				y[j] = (int) (centerY - radius*Math.cos(2*k*Math.PI/60));
				endsX[k][j] = x[j];
				endsY[k][j] = y[j];
			}
		}
		
	}
	
	public void makeTimer() { //Instantiates new timer object for timer
		Timer timer = new Timer(tickTime, listener);
		TimerListener timerListener = new TimerListener();
		timer.start();
	}
	
	public void stop() { //Calls stop method of timer class
		timer.stop();
	}
	
	public void reset() { //Resets the timer
		/*
		 * Stops the timer
		 * resets arm index values to 0
		 * calls connect()
		 */
		
		stop();
		longArmIndex = 0;
		shortArmIndex = 0;
		secondArmIndex = 0;
		connect();
		
	}
	
	private boolean timeFormat(String inp) { //Validates parameter inp if it is correct, t/f based on validation
		boolean tf = false;
		for(int k = 0; k <= 4; k++) {
			System.out.println("Char at index " + k + " is " + inp.charAt(k));
		}
		if(inp.charAt(2) == ':') {
			System.out.println("Char at index 2 is :");
			if(inp.charAt(0) == 0 || inp.charAt(0) == 1) {
				System.out.println("Char at index 0 is either 0 or 1");
				if(inp.charAt(1) >= 0 && inp.charAt(1) <= 9) {
					System.out.println("Char at index 1 is greater than or equal to 0 and less than or equal to 9");
					if(inp.charAt(3) >= 0 && inp.charAt(3) <= 5) {
						System.out.println("Char at index 3 is greater than or equal to 0 and less than or equal to 5");
						if(inp.charAt(4) >= 0 && inp.charAt(4) <= 9) {
							System.out.println("Char at index 4 is greater or equal to than 0 and less than or equal to 9");
							tf = true;
						}
					}
				}
			}
		}
		return tf;
	}
	
	public void setClock(String timeToSet) { //Calls timeFormat to validate timeToSet, if not valid method returns
		timeFormat(timeToSet);
		if(timeFormat(timeToSet) == true) {
			shortArmIndex = timeToSet.charAt(1) + timeToSet.charAt(2);
			System.out.println("At line 105 the shortArmIndex is " + shortArmIndex);
			longArmIndex = timeToSet.charAt(4) + timeToSet.charAt(5);
			System.out.println("At line 107 the longArmIndex is " + longArmIndex);
			secondArmIndex = 0;
		}
		else if(timeFormat(timeToSet) == false) {
			System.out.println("Please enter an appropriate time format");
		}
		connect();
	}
	
	private void connect() { //Calls actionPerformed() with respect to listener as prefix and event in parameter
		//listener.actionPerformed(event);
	}
	
	public class TimerListener { //Class to hold ActionListener for timer
		
		public void actionPerformed(ActionEvent event) { //
			/*
			 * Updates secondsArmIndex reduced modulo 60
			 * if secondArmIndex is 0 {
			 * update longArmIndex modulo 60}
			 * 
			 * if longArmIndex is divisible by 12 {
			 * update shortArmIndex modulo 60}
			 * 
			 * call connect()
			 */
			
			if(secondArmIndex == 0) {
				//update longArmIndex modulo 60
			}
			if(longArmIndex%12 == 0) {
				//update shortArmIndex modulo 60
			}
			
			connect();
		}
		
	}
	
}
