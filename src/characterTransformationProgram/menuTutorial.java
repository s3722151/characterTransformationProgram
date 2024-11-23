package characterTransformationProgram;
import java.util.Scanner;

//Tutorial: https://www.youtube.com/watch?v=25kUc_ammbw&list=WL&index=7
public class menuTutorial {
	boolean exit;
	
	public static void main(String[] args) {
		menuTutorial menuTutorial2 = new menuTutorial();
		menuTutorial2.runMenu();
		
	}
	
	//List of methods
	public void runMenu() {
		printHeader();
		while(!exit) {
			printMenu();
			int choice = getInput();
			performAction(choice);
		}
	}
	
	private void printHeader() {
		System.out.println("+--------------------------------+");
		System.out.println("|        Welcome to our          |");
		System.out.println("|       Menu Application         |");
		System.out.println("+--------------------------------+");
	}

	//public to call these methods later
	private void printMenu() {
		System.out.println("\n Please make a selection");
		System.out.println("1) Tell me a color");
		System.out.println("2) Tell me a shape");
		System.out.println("0) Exit the program");
		
	}
	
	private int getInput() {
		Scanner kb = new Scanner(System.in);
		int choice = 0; //Not conflict with menu options 
		while (choice < 0 || choice > 2);{
			try {
				System.out.print("\nEnter your choice");
				choice = Integer.parseInt(kb.nextLine());				
			}
			catch(NumberFormatException e) {
				System.out.println("Invalid selection. Please try again.");				
			}			
		}
		return choice;

	}
	private void performAction(int choice) {
		switch(choice) {
		case 1:
			System.out.println("Tell me a color");
			break;
		case 2:
			System.out.println("Tell me a shape");
			break;
		case 0:
			exit = true;
			System.out.println("Thank you for using this application");
			break;
		default:
			System.out.println("There is a problem with the input. Please try again.");
			break;
		
		}
	}
	
	//Timestampe: https://youtu.be/25kUc_ammbw?t=928
	private void pickColour()
	{
		int num = (int)(Math.random() * 4);
		switch(num) {
		case 0:
			System.out.print("Green");
			break;
		case 1:
		case 2:
			
		}
	}

}

