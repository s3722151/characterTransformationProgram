package characterTransformationProgram;
import java.util.Scanner;  // Import the Scanner class - https://www.w3schools.com/java/java_user_input.asp
import java.nio.charset.StandardCharsets; //https://mkyong.com/java/how-to-convert-character-to-ascii-in-java/#:~:text=Convert%20String%20to%20ASCII,to%20get%20the%20ASCII%20value.
import java.util.ArrayList;
import java.util.List;

public class initalCodeIMade {
	public static void main(String[] args) {
	// TODO Auto-generated method stub
	System.out.println("Please enter a value. E.g.'Hello World'");
	Scanner myObj = new Scanner(System.in);  // Create a Scanner object
	
	//Step 1: User Enters a value 
	String userName = myObj.nextLine();  // Read user input
	
	//Step: 2 Create a Menu 
	while (userName != null) {
		System.out.println("What you entered as a value is: " + userName);
		System.out.println("Press 1 to enter a encode the string");
		System.out.println("Press 2 to enter a decode the string");
		System.out.println("Press 3 to exit the program");
		
		Scanner option = new Scanner(System.in); //This is what the user enters			
		int optionChosen = option.nextInt();
		
		
		while (optionChosen > 0 && optionChosen <= 3 ) {
		boolean encoded = false; //This is the default value to decide if to decode

			//Option 1: Encode the string 
			//If Input is not encoded: Transform the input based on ASCII table	
			if(optionChosen == 1 && encoded == false) {
				System.out.println("Entered 1: You want to encode the string");
				
				byte[] bytes = userName.getBytes(StandardCharsets.US_ASCII);
		        List<Integer> result = new ArrayList<>();   // convert bytes to ascii
		        for (byte aByte : bytes) {
		            int ascii = (int) aByte;                // byte -> int
		            result.add(ascii);
		        }
		        System.out.println("The encoded value is now" + result.toString());          
		        encoded = true;
				optionChosen = 0;											
			}
				else if (optionChosen == 1 && encoded == true ){
					System.out.println("You cannot encode as it is already encoded.");
					optionChosen = 0;									
				}
			//Option 2: Decode the string
			//If the input is encoded, decode
			if(optionChosen == 2 && encoded == true) {	
				System.out.println("Entered 2: You want to decode the string");
				optionChosen = 0;
			}
				else if (optionChosen == 2 && encoded == false ){
					System.out.println("You cannot decode as it is already decoded.");
					optionChosen = 0;						
				}
			if(optionChosen == 3) {
				//Option 3: Exit the Program 
				System.out.println("Entered 3: You want to exit this program.");
				System.out.println("Thank you for using this program ");
				optionChosen = 0;
				userName = null;
			}		
				
			}

			
		}


	}

}

/* 
The problems with code:
Problems in the Code
Scope of encoded: The encoded variable is reset to false every time the while (optionChosen > 0 && optionChosen <= 3) 
loop starts because it’s declared inside the loop. As a result, the state of whether the string is encoded or not is lost.

Nested Loops: You have multiple nested while loops, and the outer loop resets the user input (userName != null) 
without considering the inner loop's behavior.

Logic for Option Handling: The variable optionChosen is set to 0 at the end of each branch, 
which might conflict with the user's intention to re-enter a valid option.
*/
