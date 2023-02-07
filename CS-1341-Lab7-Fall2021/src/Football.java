
//name: max link student ID: 48511338 Lab-7-Fall-2021
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;
import java.util.Random;

public class Football {
	Scanner input = new Scanner(System.in);
	static Random rand = new Random(); // creates a static Random operator that can be used across all methods
	// simple attributes
	private int rounds;
	// reference object team array & String array
	private ArrayList<Team> teams = new ArrayList<Team>(); // turned team array into an array list
	// initialize score & score array
	int score = 0;
	int[] scoreArray = new int[2];

	// constructor
	public Football() {
		System.out.println("Welcome to Football Scramble!\n");
		while (true) {
			System.out.print("Load team names from a file? (y/n) ");
			String userInput = input.next();
			if (userInput.equalsIgnoreCase("Y")) {

				try {
					File myFile = new File("teamData.txt");
					Scanner input = new Scanner(myFile);
					input.useDelimiter("\n");
					while (input.hasNext()) {
						String teamFromFile = input.next();
						Team aTeam = new Team(teamFromFile);
						teams.add(aTeam);
					} // end of while has next
					input.close(); // closes the input file when finished

				} // end of try for file read
				catch (Exception e) {
					System.out.print("problem reading file!");
				} // end of catch for file quality check

				// System.out.print("File loaded!\n");
				// if (teams.size() > 2) {
				// for (int i = 0; i < (teams.size() - 2); i++)
				// teams.remove(i);
				// } // end of if check for teams array size
				updateTeamList();

				// System.out.print("file sized checked and is now " + teams.size());
				break;
			} // end of if for file load
			if (userInput.equalsIgnoreCase("N")) {
				System.out.print("Enter team 1 name: ");
				Team firstTeam = new Team(input.next());
				teams.add(firstTeam);
				System.out.print("Enter team 2 name: ");
				Team secondTeam = new Team(input.next());
				teams.add(secondTeam);
				break;
			} // end of if for no file load
			else {
				System.out.println("Invalid response");
			} // end of else for invalid entry
		} // end of while true

		while (true) {
			try {
				System.out.print("Enter number of rounds: ");
				rounds = input.nextInt(); // records the amount of total rounds to play
				break;
			} catch (InputMismatchException ime) {
				// will prompt again with above
				input.next(); // discard the bad input
			}
		}
	}// end of constructor

	public void updateTeamList() {
		Team team1 = null;
		Team team2 = null;
		while (team1 == team2) {
			team1 = teams.get(rand.nextInt(teams.size()));
			team2 = teams.get(rand.nextInt(teams.size()));
		}
		teams.clear();
		teams.add(team1);
		teams.add(team2);

	}// end updateTeams

	// getters and setters
	public void setRound(int roundNumber) {
		rounds = roundNumber;
	}// end setter

	public int getRound() {
		return rounds;
	}// end getter

	// public methods
	public void playGame() {
		int roundCount = 0; // initializes roundCount to zero
		while (roundCount < rounds) {
			System.out.printf("Round %d of %d: ", (roundCount + 1), rounds); // prints current round
			for (int i = 0; i < teams.size(); i++) {
				showScoreBoard(); // calls the showScoreBoard method
				teams.get(i).takeTurn(); // send takeTurn message to teams array
				printResult();
			} // end for loop for teamsArray
			roundCount++;
		} // end of outer while
		endGame(); // calls endGame method

	}// end playGame

	public void showScoreBoard() {
		System.out.println();

		for (int i = 0; i < 22; i++) {
			System.out.print("*");
		}
		System.out.printf("\n%s%16s%5s", "*", "SCOREBOARD", "*"); // score board second line

		// for score format for team 1
		System.out.printf("\n%s%13s %7s", "*", teams.get(0), "*");
		// for score format for team 2
		System.out.printf("\n%s%13s %7s\n", "*", teams.get(1), "*");

		for (int i = 0; i < 22; i++) {
			System.out.print("*");
		}
		System.out.println();
		System.out.println();
		System.out.println();
	}// end of showScoreBoard

	public int endGame() {
		showScoreBoard();
		if ((teams.get(0)).getScore() == (teams.get(1)).getScore()) // if for tie between the teams
			System.out.printf("It was a tie between the %s and %s", teams.get(0).getName(), teams.get(1).getName());

		if ((teams.get(0)).getScore() > (teams.get(1)).getScore()) // if for team 1 winning
			System.out.printf("Game over, the %s won the game!", teams.get(0).getName());

		if ((teams.get(0)).getScore() < (teams.get(1)).getScore()) // if for team 2 winning
			System.out.printf("Game over, the %s won the game!", teams.get(1).getName());
		return score;
	}// end endGame

	public void printResult() {
		PrintWriter pw = null;
		try {
			pw = new PrintWriter("output.txt");
			pw.println("Game Results:");
			pw.println("************************************");
			for (int i = 0; i < teams.size(); i++) {
				pw.println("*****INSTANT REPLAY FOR TEAM " + teams.get(i).getName() + "*****");
				pw.printf(teams.get(i).instantReplay());
			}
		} catch (Exception e) {
			System.out.print("File not found");
		} finally {
			pw.close();
		}

		// FILL OUT THIS METHOD
	}// end of printResult method
}// end class Football
