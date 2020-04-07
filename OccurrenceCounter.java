import java.util.Scanner;

public class OccurrenceCounter 
{
		private static Scanner input = new Scanner(System.in);
		
		public static void main(String[] args) 
		{	
			System.out.println("Occurence counter for babb:");
			int table[][] = {{0,1} , {2,1} , {0,3} , {2,4} , {0,1}};
			
			printTransitions(table);
			
			while(true)
			{
				System.out.println("Enter a String to count Occurrence of babb:");
				String str = input.nextLine();
				
				if(str.length()<3)
				{
					System.out.println("String length must be >3.....");
					continue;
				}
				
				System.out.println("babb Occurred " + countOccurrence(str, table) + " times.");
			}//while
		}//main()
		
		static void printTransitions(int[][] table) 
		{
			System.out.println("Transition Table:");
			int j = 0;
			for(int[] x : table) 
			{
				int i = 0;
				for(int y : x)
				{
					if(i == 0)
						System.out.println("(Q" + j + " , a) ==> " + "Q" + y);
					else
						System.out.println("(Q" + j + " , b) ==> " + "Q" + y);
					i++;
				}//for
				j++;
			}//for
			
			System.out.println("--------------------------------------------------------");
			
			j=0;
			while(j<=5)
			{
				if(j == 5)
					System.out.println("y(Q" + j + ") ==> 1");
				else
					System.out.println("y(Q" + j + ") ==> 0");
				
				j++;
			}//while
			System.out.println("--------------------------------------------------------");
		}//printTransitions()
		
		static int countOccurrence(String str, int[][] table)
		{
			int sum=0;
			int cs = 0;
			System.out.print("Q0 ==0==> ");
			for(char c : str.toLowerCase().toCharArray())
			{
				if(c == 'a')
				{
					cs = table[cs][0];
					if(cs == 4)
						System.out.print("Q" + cs +" ==1==> ");
					else
						System.out.print("Q" + cs +" ==0==> ");
				}//if
				
				else if(c == 'b')
				{
					cs = table[cs][1];
					if(cs == 4)
						System.out.print("Q" + cs +" ==1==> ");
					else
						System.out.print("Q" + cs +" ==0==> ");
				}//elif
				if(cs == 4 && (c == 'a' || c == 'b'))
					sum++;
			}//for
			System.out.println("End");
			return sum;
		}//countOccurrence()
		
	}//OccurrenceCounter
