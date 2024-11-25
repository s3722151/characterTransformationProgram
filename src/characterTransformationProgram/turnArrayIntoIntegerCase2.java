package characterTransformationProgram;

public class turnArrayIntoIntegerCase2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//https://www.youtube.com/watch?v=OqHoEAzdFGU  - Tutorial
		
		
		String [] myGrades = {"90", "87","96","100"};
		int [] myNumerizedGrades = new int[myGrades.length];
		
		//We loop for each value in the array
		for (int i = 0; i < myNumerizedGrades.length; i++ ) {
			myNumerizedGrades[i] = Integer.parseInt(myGrades[i]);
		}
		System.out.println(myGrades[0]);
			
	}

}


/* 
Notes
This was an idea for case 2. 
*/