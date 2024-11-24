package characterTransformationProgram;
import java.util.Scanner;  // Import the Scanner class - https://www.w3schools.com/java/java_user_input.asp
import java.nio.charset.StandardCharsets; //https://mkyong.com/java/how-to-convert-character-to-ascii-in-java/#:~:text=Convert%20String%20to%20ASCII,to%20get%20the%20ASCII%20value.
import java.util.ArrayList;
import java.util.List;

//tRY THIS TUTORIAL FOR EXPERIENCE: https://www.youtube.com/watch?v=25kUc_ammbw&list=WL&index=7

//GPT answer
public class Main {

    public static void main(String[] args) {
        System.out.println("Please enter a value. E.g.'Hello World'");
        Scanner myObj = new Scanner(System.in); // Create a Scanner object

        // Step 1: User enters a value
        String userName = myObj.nextLine(); // Read user input        
        List<Integer> asciiValues = new ArrayList<>(); // Store ASCII values after encoding

        // Step 2: Initialize variables
        boolean encoded = false; // To track if the string is encoded

        while (true) { // Loop until the user chooses to exit
            System.out.println("What you entered as a value is: " + userName);
            System.out.println("The Status of the encoded is:" +encoded);
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
                    if (!encoded) {
                        System.out.println("Entered 1: You want to encode the string");
                        byte[] bytes = userName.getBytes(StandardCharsets.US_ASCII);
                        List<Integer> result = new ArrayList<>();
                        for (byte aByte : bytes) {
                            result.add((int) aByte);
                        }
                        System.out.println("The encoded value is now: " + result.toString());
                        encoded = true; // Mark as encoded
                    } else {
                        System.out.println("You cannot encode as it is already encoded.");
                    }
                    break;

                case 2: // Decode the string
                    if (encoded) {
                        System.out.println("You chose to decode the string.");
                        // Convert ASCII values back to characters
                        StringBuilder decodedString = new StringBuilder();
                        for (int ascii : asciiValues) {
                            decodedString.append((char) ascii); // Convert ASCII to character
                        }
                        userName = decodedString.toString(); // Update userName with the decoded string
                        System.out.println("The decoded value is: " + userName);
                        encoded = false; // Mark as decoded
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


