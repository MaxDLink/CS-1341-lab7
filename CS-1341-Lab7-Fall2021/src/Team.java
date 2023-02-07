import java.util.ArrayList;
import java.util.Scanner;
//name: max link student ID: 48511338 Lab-7-Fall-2021

public class Team {

	// simple attributes
	private String name;
	private int score;

	// reference attributes
	private ExtraPointsAttempt currentExtra;
	private Play currentPlay;

	// play array list
	private ArrayList<Play> plays = new ArrayList<Play>();

	// constructor
	public Team(String team) {
		name = team; // initializing name to teamName
		score = 0; // initializing score to zero
	}// end of constructor

	// getters and setters
	public void setName(String team) {
		name = team;
	}// end of setName

	public String getName() {
		return name;
	}// end of getName

	public void setScore(int scoreValue) {
		score = scoreValue;
	}// end of setScore

	public int getScore() {
		return score;
	}// end of getScore

	// takeTurn method
	public void takeTurn() {
		int location = 20; // initializes current location to 20
		int downsCounter = 1; // initializes down counter to 1
		int yardsMoved = 0; // initializes getYardsValue to 0
		int targetYardNumber = location + 10; // initializes targetYardNumber to location plus 10
		int yardsToFirstDown = 10; // initializes yardsToFirstDown to zero
		// int count = 0; //initializes count to zero
		int scoreAddition = 0; // initializes scoreAddition to zero
		Scanner input = new Scanner(System.in);

		while (true) {
			while (true) {
				System.out.printf("%s's ball -- Down: %d Yard-line: %d Yards-to-1st-Down: %d.\n", name, downsCounter,
						location, yardsToFirstDown); // prompts the user to pass, run, or quit
				System.out.printf("     Pass or Run (P/R)? "); // prompts the user to pass or run
				String userInput = input.nextLine(); // takes the user input and considers multiple lines
				if (userInput.equalsIgnoreCase("P")) {// start of if that breaks while true loop
					currentPlay = new PassPlay();
					break; // breaks while true loop
				} // end of if
				if (userInput.equalsIgnoreCase("R")) {
					currentPlay = new RunPlay();
					break; // breaks while true loop
				} // end of if
				else {
					System.out.print("Invalid Entry!\n");
					// repeat prompt here
					System.out.printf("     Pass or Run (P/R)? "); // prompts the user to pass or run
					userInput = input.nextLine(); // takes the user input and considers multiple lines
				} // end else
			} // end of while true
			plays.add(currentPlay);

			// System.out.printf("%s's ball -- Down: %d Yard-line: %d Yards-to-1st-Down:
			// %d.\n", name, downsCounter, location, yardsToFirstDown); //prompts the user
			// to pass, run, or quit
			yardsMoved = currentPlay.go(); // calls the go method in Play class
			System.out.print(currentPlay);

			// yardsToFirstDown = yardsToFirstDown - yardsMoved; //updates yardsToFirstDown
			// based on yards moved throughout game

			location += yardsMoved; // updates location based on yards moved
			yardsToFirstDown -= yardsMoved; // updates yardsToFirstDown based on yards moved
			// if(count > 0) {
			if (location >= targetYardNumber) {
				downsCounter = 1; // sets downCounter to 1
				targetYardNumber = location + 10; // updates the targetYardNumber
				yardsToFirstDown = targetYardNumber - location;
			} // end location first condition
			else {
				downsCounter++; // updates downCounter throughout game
				if (downsCounter == 5) {
					System.out.printf("Turn over - next team's turn\n");

					// count++; //increments count based on turnovers from downs
					break;
				} // end break condition for downsCounter

			} // end location 2nd condition
				// }//end count for location conditions & downCounter updates

			// if(count > 0) {
			if (location <= 0 || location - yardsMoved < 0) {// start of if for getYardsValue = 0
				if (yardsMoved < 0) {
					yardsMoved = 0; // sets getYardsValue to zero if its less than zero
				} // end if for getYardsValue = 0
			} // end of if for sacked check
				// }//end of if for count check

			if (location >= 100) { // has to grab location before the pass for the subtraction?
				yardsMoved = 100 - (location - yardsMoved); // subtracts value for distance to touch down
				location = 20;
				System.out.print("Touchdown!!\n"); // displays touch down
				score += 6; // adds six points to score array after touch down based on indexNumber
							// parameter
				currentExtra = new ExtraPointsAttempt(); // assigns instance of ExtraPointsAttempt to currentExtra
				int extraPointAddition = currentExtra.go(scoreAddition); // returns scoreAddition from go method in
																			// ExtraPointsAttempt
				// System.out.println("This is the score addition value " + extraPointAddition);
				score += extraPointAddition; // adds extraPointAddition to score
				currentExtra.toString();
				break;
			} // end if location >= 100

			// count++;
			/*
			 * if(count == 2) break; //second break to end while true loop
			 */
		} // end of while true loop
		
	}// end takeTurn method

	public String instantReplay() {
		String output = "";
		for ( int i = 0; i < plays.size(); i++) {
			output += "Play " + (i+1) + ":    " + plays.get(i);
		}
		return output;
	}// end of instantReplay method

	// toString method
	public String toString() {
		return name + " " + score; // returns the team name and current score
	}// end of toString method

}// end class Team
