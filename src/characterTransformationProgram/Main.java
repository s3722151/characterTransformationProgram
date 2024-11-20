package characterTransformationProgram;
import java.util.Scanner;  // Import the Scanner class - https://www.w3schools.com/java/java_user_input.asp

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Please enter a value. E.g.'Hello World'");
		Scanner myObj = new Scanner(System.in);  // Create a Scanner object
		
		//Step 1: User Enters a value 
		String userName = myObj.nextLine();  // Read user input
		boolean encoded = false; //This is the default value to decide if to decode
		
		//Step: 2 Create a Menu 
		while (userName != null) {
			System.out.println("What you entered is: " + userName);
			System.out.println("Press 1 to enter a encode the string");
			System.out.println("Press 2 to enter a decode the string");
			System.out.println("Press 3 to exit the program");
			
			Scanner option = new Scanner(System.in); //This is what the user enters			
			int optionChosen = option.nextInt();
			
			//Create a SWITCH statement - https://www.w3schools.com/java/java_switch.asp
			switch(optionChosen) {
			  case 1:
					//Option 1: Encode the string 
					//If Input is not encoded: Transform the input based on ASCII table		
						//Else, cannot be encoded
	
			    break;
			  case 2:
					//Option 2: Decode the string 
					//If the input is encoded, decode
						//Else, this is decoded
			    break;

			  case 3:
				//Option 3: Exit the Program 
				System.out.println("Thank you for using this program ");
			    break;

			}	
			

		}

	}

}
