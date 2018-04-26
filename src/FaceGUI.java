import javax.swing.JFrame;
import javax.swing.event.ChangeEvent;
import javax.swing.*;
import java.awt.*;

import javax.swing.JPanel;

public class FaceGUI {
	
	//Data fields
	
	private ClockWork work; //To aggregate
	private Face face; //Inner class reference
	private int radius, centerX, centerY; //Clock face, initialized when GUI is
	
	//Methods
	
	//Constructor
	public FaceGUI(ClockWork cw) { //Constructor
		/*
		 * Initializes work
		 * Registers this as ActionListener with work
		 * Calls buildClock()
		 */
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
		}
		
	}
	
}
