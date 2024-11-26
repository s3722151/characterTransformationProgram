package characterTransformationProgram;
import java.util.Scanner;  // Import the Scanner class - https://www.w3schools.com/java/java_user_input.asp
import java.nio.charset.StandardCharsets; //https://mkyong.com/java/how-to-convert-character-to-ascii-in-java/#:~:text=Convert%20String%20to%20ASCII,to%20get%20the%20ASCII%20value.
import java.util.ArrayList;
import java.util.List;



//GPT answer
public class Main {

    public static void main(String[] args) {
        System.out.println("Please enter a value. E.g.'Hello World'");
        Scanner myObj = new Scanner(System.in); // Create a Scanner object

        // Step 1: User enters a value
        String userName = myObj.nextLine(); // Read user input        
        List<Integer> asciiValues = new ArrayList<>(); // Store ASCII values after encoding

        // Step 2: Initialize variables
        boolean encodedState = false; // To track if the string is encodedState
        

        while (true) { // Loop until the user chooses to exit
            System.out.println("What you entered as a value is: " + userName);
            System.out.println("The Status of the encodedState is:" +encodedState);
            System.out.println("Press 1 to encode the string");
            System.out.println("Press 2 to decode the string");
            System.out.println("Press 3 to exit the program");

            int optionChosen = -1; // Default invalid option

            try {
                optionChosen = myObj.nextInt(); // Read user's choice
            } catch (Exception e) {
                System.out.println("Invalid input! Please enter a number (1, 2, or 3).");
                myObj.nextLine(); // Clear the invalid input from the scanner buffer
                continue; // Restart the loop to prompt again
            }

            switch (optionChosen) {
                case 1: // Encode the string
                    if (!encodedState) {
                        System.out.println("Entered 1: You want to encode the string");
                        byte[] bytes = userName.getBytes(StandardCharsets.US_ASCII);
                        List<Integer> result = new ArrayList<>();
                        for (byte aByte : bytes) {
                            result.add((int) aByte);
                        }
                        userName = result.toString();
                        System.out.println("The encodedState value is now: " + userName);
                        encodedState = true; // Mark as encodedState
                    } else {
                        System.out.println("You cannot encode as it is already encodedState.");
                    }
                    break;

                //Look at this tutorial: https://www.tutorialspoint.com/java-program-to-convert-ascii-code-to-string#:~:text=To%20convert%20ASCII%20to%20string,will%20return%20the%20associated%20character.
                case 2: // Decode the string
                    if (encodedState) {
                        System.out.println("You chose to decode the string.");
                        // Convert ASCII values back to characters
                        userName = userName.replaceAll("[\\[\\]]", ""); // Remove '[' and ']' https://beginnersbook.com/2015/05/java-ascii-to-string-conversion/
                        String[] asciiValuesArray = userName.split(", "); // Split by comma and space

                        String decodedString = ""; // Regular string to store the result
                        // Convert each ASCII value back to character. For loop in array - https://www.w3schools.com/java/java_arrays_loop.asp
                        for (String asciiValue : asciiValuesArray) {
                            int ascii = Integer.parseInt(asciiValue); // Convert string to int
                            decodedString += (char) ascii; // Convert all ints to char then add them together in decoded  string
                        }

                        userName = decodedString; // Update userName with the decoded string
                        System.out.println("The decoded value is: " + userName);
                        encodedState = false; // Mark as decoded
                        
                    } else {
                        System.out.println("You cannot decode as it is already decoded.");
                    }
                    break;
                    
                case 3: // Exit the program
                    System.out.println("Entered 3: You want to exit this program.");
                    System.out.println("Thank you for using this program.");
                    myObj.close(); //https://www.w3schools.com/java/ref_scanner_close.asp
                    return;

                default: // Invalid option
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }
    }
}

//References - What you should know
//What is ASCII: https://www.techtarget.com/whatis/definition/ASCII-American-Standard-Code-for-Information-Interchange
//How to make while and switch statements
//How to convert to ascii
  //Easier way: https://www.geeksforgeeks.org/print-given-sentence-equivalent-ascii-form/
  //Initial way I did it (Opps): https://mkyong.com/java/how-to-convert-character-to-ascii-in-java/
//Know how to convert from ASCII back to string 
 //Similar but without decodedString: https://beginnersbook.com/2015/05/java-ascii-to-string-conversion/
//Know what is a List<Integer>: https://www.geeksforgeeks.org/initializing-a-list-in-java/
//How to parse: https://www.oreilly.com/library/view/java-for-dummies/9781118239742/a70.html


/* NOTES
q:If I understand it in the for loop, for every value in asciiValuesArray we convert the value to from string to int, then char. Why char?

 * What is ASCII? ASCII (American Standard Code for Information Interchange) is a standard for representing characters (like A, b, 1, @, etc.) using integer values. For example:
The ASCII value of A is 65.
The ASCII value of a is 97.
The ASCII value of @ is 64.

Why char?
In Java, a char is a data type that represents a single character.
When you cast an integer to a char, Java interprets that integer as an ASCII code and converts it to the corresponding character.

E.G
int ascii = 65;
char character = (char) ascii; // character becomes 'A'

After encoding, your userName contains ASCII values (e.g., [72, 101, 108, 108, 111] for "Hello").
To decode:
	Parse each value as an integer (int).
	Convert the integer to its corresponding character using (char).
	Combine all characters to reconstruct the original string.

Why Not Skip char?
If you don't use char:
	The program would treat the numbers as integers, not characters.
	For example, 72 would remain a number instead of becoming 'H'.

 * 
 */
