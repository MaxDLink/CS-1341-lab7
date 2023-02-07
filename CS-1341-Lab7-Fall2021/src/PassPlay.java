
public class PassPlay extends Play {

	// constructor
	public PassPlay() {
		super();
	}

	public int go() {
		int[] passValues = { -10, -5, 0, 0, 0, 5, 10, 15, 20, 25 }; // array containing pass values
		double randNum = rand.nextDouble(); // creates a random integer from 0-1
		randNum *= 10; // broadens the random integer from 0-9.9999
		int randInt = (int) randNum; // truncates to range 0-9
		return yardsMoved = passValues[randInt]; // randomly retrieve a number from passValues
	}// end of go method

	public String toString() {
		return "Pass play result - " + super.toString() + " " + yardsMoved + " yards\n";
	}// end of toString
}// end of class PassPlay
