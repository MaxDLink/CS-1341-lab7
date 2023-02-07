
//name: max link student ID: 48511338 Lab-7-Fall-2021
import java.util.Scanner;
import java.util.Random;

public abstract class Play {

	// static Scanner and Random and variables for print statements
	static Scanner input = new Scanner(System.in); // creates static scanner that can be used across all methods
	static Random rand = new Random(); // creates a static Random operator that can be used across all methods
	static String userInput = "null";
	// simple attributes
	protected int yardsMoved;

	// constructor
	public Play() {
		yardsMoved = 0;

	}// end constructor play

	// getters and setters

	public int getYardsMoved() {
		return yardsMoved;
	}// end getYardsMoved

	public void setYardsMoved(int yards) {
		yardsMoved = yards;
	}// end setYardsMoved

	public abstract int go();

	public String toString() {
		String outcome = null;

		/*
		 * if(userInput.equalsIgnoreCase("P")) { passOrRun = "Pass"; } else { passOrRun
		 * = "Run"; }
		 */
		if (yardsMoved < 0) {
			outcome = "moved back";
		} // end if yardsMoved < 0
		if (yardsMoved > 0) {
			outcome = "moved forward";
		} // end if yardsMoved > 0
		if (yardsMoved == 0) {
			outcome = "Blocked!";
		} // end if yardsMoved == 0


		return outcome;

	}// end of toString

}// end class Play
