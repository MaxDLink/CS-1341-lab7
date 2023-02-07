//name: max link student ID: 48511338 Lab-6-Fall-2021
import java.util.Scanner; 
import java.util.Random; 

public class ExtraPointsAttempt {

	//static Scanner and Random and variables for print statements 
	static Scanner input = new Scanner (System.in); //creates static scanner that can be used across all methods 
	static Random rand = new Random(); //creates a static Random operator that can be used across all methods 
		
	//simple attributes 
	private int extraPoints; 
	
	//constructor 
	public ExtraPointsAttempt() {
		 extraPoints = 0; //initializes extraPoints to zero 
	}//end ExtraPointsAttempt method 
	
	//getters and setters 
	public int getExtraPoints() {
		return extraPoints; 
	}//end getter for ExtraPoints 
	
	public void setExtrapoints(int points) {
		extraPoints = points; //sets extraPoints equal to the int points 
	}//end setter for ExtraPoints 
	
	//go method 
	public int go(int scoreAddition) {
		while(true) {
		System.out.print("Attempt extra point(s). . Kick or Conversion? (K/C) "); //prompts the user to pass, run, or quit 
		String userInput = input.nextLine(); //takes the user input and considers multiple lines 
		
		if(userInput.equalsIgnoreCase("K")) {
			
			extraPoints = rand.nextInt(2) + 1; //50% chance for successful kick 
			
			if(extraPoints != 2) {
				System.out.print("Scored 1 extra points\n"); //alerts user to score for successful conversion
				extraPoints = 1; //one point to extraPoints 
				break; 
		}//end if conversionChance 
			else {
				System.out.print("Scored 0 extra points\n"); //alerts user to score of unsuccessful conversion
				extraPoints = 0; //adds zero points to extraPoints 
				break; 
			}//end else for unsuccessful conversion 
			
		}//end if kick input  
		
		if(userInput.equalsIgnoreCase("C")) {
			extraPoints = rand.nextInt(4) + 1; //75% chance for successful conversion 
			
		if(extraPoints != 4) {
			System.out.print("Scored 0 extra point\n"); //alerts user to score 
			extraPoints = 0; //adds 0 points to extraPoints 
			break; 
		}//end if kickChance 
		else {
			System.out.print("Scored 4 extra points\n"); //alerts user to unsuccessful conversion 
			extraPoints = 4; //adds 4 points to extraPoints 
			break;
		}//end else for conversion 
		
}//end if conversion input 
		else {
			System.out.print("Invalid Entry!\n");
		}//end input check 
		
		}//end while true loop 
		
		return extraPoints; //returns the value of extraPoints at the end of this method 
	}//end go method 
	
	//toString 
public String toString() {
  return "Extra points attempted resulting in " + extraPoints + " Points"; //toString return statement substituting extraPoints value for how many extra points accumulated 
}//end toString 
}//end class ExtraPointsAttempt
