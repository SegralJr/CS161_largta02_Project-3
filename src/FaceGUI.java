import javax.swing.JFrame;
import javax.swing.event.ChangeEvent;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

import javax.swing.JPanel;

public class FaceGUI {
	
	//Data fields
	
	private ClockWork work; //To aggregate
	private Face face; //Inner class reference
	private int radius, centerX, centerY; //Clock face, initialized when GUI is
	
	//GUI Stuff
	
	//Panels
	protected JPanel
	north = new JPanel(),
	east = new JPanel(),
	south = new JPanel(),
	west = new JPanel(),
	center = new JPanel();
	
	//Methods
	
	//Constructor
	public FaceGUI(ClockWork cw) { //Constructor
		/*
		 * Initializes work
		 * Registers this as ActionListener with work
		 * Calls buildClock()
		 */
		
		work = new ClockWork();
		work.addActionListener(this); //??
		buildClock();
	}
	
	//Instance methods
	
	private void buildClock() { //Builds the clock
		/*
		 * Call and parameter choices to build GUI
		 * Initialize circle data,
		 * center is about half of frame
		 * Radius must be less than vertical half size to give room for nums
		 * Method calls setter in ClockWork to pass circle data to the class
		 * Calls loadTacks of ClockWork, instantiates field face
		 */
		
		
		
	}
	
	public void actionPerformed(ActionEvent event) {
		/*
		 * Calls repaint()
		 */
	}
	
	public class Face extends JPanel {
		
		public Face() {
			work = new ClockWork();
		}
		
		@Override
		public void paintComponent(Graphics g) {
			/*
			 * Calls getter(s) to get arms index values, store local
			 * Calls getter(s) to get tack coordinates, store local
			 * Draws 3 circles, fills with white, cyan, and black
			 * (fills must be done in decreasing order of radii)
			 * Runs for loop draw tacks all around clock face
			 * (draws numbers to clock, choosing individually parameters for enclosing rectangles)
			 * (set favorite font before drawing)
			 * Draws clock arms one by one, draw from center to other end such that end is adjustment of tack coords
			 */
			
			int longArmIndex, shortArmIndex, secondArmIndex;
			int[] x = null, y = null;
			int[] arr1 = work.getIndexValues();
			int[][] arr2 = work.getXYValues();
			
			longArmIndex = arr1[0];
			shortArmIndex = arr1[1];
			secondArmIndex = arr1[2];
			
			for(int k = 0; k < arr1.length; k++) {
				x[k] = arr2[0][k];
			}
			for(int k = 0; k < arr1.length; k++) {
				y[k] = arr2[1][k];
			}
		}
		
	}
	
}
