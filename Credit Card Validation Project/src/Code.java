import java.io.File;
import java.util.Scanner;
import java.io.IOException;

public class Code
	{
		//practice branch edit
		static long [] cardFile = new long [16];
		static long ccNumber, displayNumber;
		static int counter = 0;
		
		public static void main(String[] args) throws IOException
			{
				
				Scanner myFile = new Scanner(new File("secondCheckNumbers.txt"));
				
				while(myFile.hasNext())
					{
						ccNumber = myFile.nextLong();
						displayNumber = ccNumber;
						luhnAlgorithm();
						
					}
				System.out.println("There are " + counter + " possibly valid numbers.");
				
			}

		public static void luhnAlgorithm()
			{
				int index = 15;
				while(ccNumber > 0)
					{
						 cardFile[index] = ccNumber % 10;
							
						 ccNumber = ccNumber / 10;
						 
						 index--;
						
					}
				
				// loop through even indexes
				for (int i = 0; i < cardFile.length; i = i + 2)
					{
						// adds first and second number if sum > 9
						if (cardFile[i] * 2 >= 10)
							{
								cardFile[i] = (cardFile[i] * 2 / 10) + (cardFile[i] * 2 % 10);
								
							}
						// displays any number < 10
						else
							{
								cardFile[i] = cardFile[i] * 2;
							}

					}
				
				int sum = 0;
				
				for(int a = 0; a < cardFile.length; a++)
					{
						sum += cardFile[a]; 
					}

				// check if valid
				
				
				if (sum % 10 == 0)
					{
						counter++;
						System.out.println("The credit card number " + displayNumber + " is valid");
						
					} 
				else
					{
						System.out.println("The credit card number " + displayNumber + "is not a possibly valid number.");
						
					}
				
			}
		
	}
