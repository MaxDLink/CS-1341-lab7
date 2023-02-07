
public class RunPlay extends Play {

	public RunPlay() {
		super();
	}

	public int go() {
		int[] runValues = { 5, -3, -1, 1, 2, 4, 5, 6, 8, 9 }; // array containing run values
		double randNum = rand.nextDouble(); // creates a random integer from 0-1
		randNum *= 10; // broadens the random integer from 0-9.9999
		int randInt = (int) randNum; // truncates to range 0-9
		return yardsMoved = runValues[randInt];
	}// end of go method

	public String toString() {
		return "Run play result - " + super.toString() + " " + yardsMoved + " yards\n";
	}// end toString

}// end of class RunPlay
