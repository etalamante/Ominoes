import java.util.Scanner;

public class Ominoes {
	public static void main(String args[])
	{
		OminoTest();
	}
	public static void OminoTest() {
		Scanner myScanner = new Scanner(System.in);
		
		System.out.print("Tests: ");
		int tests = Integer.parseInt(myScanner.nextLine());
		
		for(int i=0;i<tests;i++){
			test(i+1);
		}
	}
	public static void test(int numberOfCases) {
		int X, R, C; //X is the value choosed by Richard to be the X-omino base, R is the grid #rows and C is the grid #columns
		
		//String data;
		
		System.out.println("Enter the number of squares of the omino-base: ");
		
		Scanner reader = new Scanner(System.in);
		X = reader.nextInt();
		
		//data = reader.next().;
		
		System.out.println("Enter the number of rows of the grid: ");
		
		Scanner reader2 = new Scanner(System.in);
		R = reader2.nextInt();
		
		System.out.println("Enter the number of columns of the grid: ");
		
		Scanner reader3 = new Scanner(System.in);
		C = reader3.nextInt();
		
		OminoGame(X, R, C, numberOfCases);

	}
	public static void OminoGame(int X, int R, int C, int numberOfCases) {
		//This method will test the X, R and C values to check if they meet the requirements to make Gabriel win
		
		/* First condition consists of X being less than 7, because otherwise, Richard can choose an omino with and empty square 
		 * inside its borders, making it impossible to Gabriel to fill it
		*/
		int firstIndicator = 7;
		
		/* Second condition consists of the product of R * C being multiple of X, because otherwise, Richard can choose 
		 * an omino not multiple and Gabriel would not have an option to fill the squares
    	*/
		int secondIndicator = ((R * C) % X);
		
		/* Third condition consists of R, C or both being more or equals to X, because otherwise, even with the ones 
		 * multiplied and resulting of X, Richard can choose the straight omino and win
    	*/
		int thirdIndicator = X;
		
		/* Fourth condition consists of R or C (the one who is not equals to X) being more than the half of X (+1 if X is odd), 
		 * because otherwise, richard can choose an omino like a square with more than C and it will not fit on the grid 
    	*/
		int fourthIndicator;
		
		if(X%2 == 0)
			fourthIndicator = X / 2;
		else
			fourthIndicator = (X / 2) + 1;
		
		String winner = "Richard";
		
		if(X < firstIndicator) {
			if(secondIndicator == 0) {
				if(R >= thirdIndicator || C >= thirdIndicator) {
					if(R >= thirdIndicator) {
						if(C >= fourthIndicator) {
							winner = "Gabriel";
						}
					}
					if(C >= thirdIndicator) {
						if(R >= fourthIndicator) {
							winner = "Gabriel";
						}
					}
				}
			}
		}
		System.out.println("Case #" + numberOfCases + ": " + winner + "\n");
	}
}
