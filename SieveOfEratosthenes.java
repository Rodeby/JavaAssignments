import java.util.Arrays;
import java.util.Scanner;

public class SieveOfEratosthenes {
public static final int STARTING_INDEX = 2;
	public static void main(String[] args) {
		boolean quit = false;
		while(!quit)
		{
			Scanner input = new Scanner(System.in);
			System.out.println("Enter a number greater than 2 or enter quit to end.");
			if(input.hasNextInt()){
				int limit = input.nextInt();
					if(limit < 2)
						System.out.println("The number you have entered is too low");
					else{
						boolean[] array = createSequence(limit);
						System.out.println(sequenceToString(array));
						int index = STARTING_INDEX;
						while(index * index < limit){							
							while(array[index-STARTING_INDEX] == false && index < limit)
								index++;
							crossOutHigherMultiples(array,index);
							System.out.println(sequenceToString(array));
							index++;
						}
						
						System.out.println(nonCrossedOutSubseqToString(array));
						

					}
			}
			else if(input.hasNext("quit"))
			{
				quit = true;			
			}
			else{
				System.out.println("Not a valid input!");
			}
		
		
		
		}

	}

	public static boolean[] createSequence(int arraySize){	
		boolean[] sequenceArray = new boolean[arraySize];
		for(int index = 0;index < arraySize;index++){			
			sequenceArray[index] = true;
		}
		return sequenceArray;
		
	}
	
	public static boolean[] crossOutHigherMultiples(boolean[] array,int number){
		if (array != null) {
			for (int index = number + number; index <= array.length; index += number) {
				if (index % number == 0)
					array[index - STARTING_INDEX] = false;
			}
			return array;
		} else
			return array;
	}

	public static boolean[] sieve(boolean[] array){
		for (int index = STARTING_INDEX; index <= array.length; index++)
			array = crossOutHigherMultiples(array, index);
		return array;
	}
	public static String sequenceToString(boolean[] array){
		String sequence = "";
		if (array != null) {
			for (int index = 0; index < array.length - 1; index++) {
				if (array[index])
					sequence = sequence + (index + STARTING_INDEX);
				else
					sequence = sequence + "[" + (index + STARTING_INDEX) + "]";
				if (index + STARTING_INDEX != array.length)
					sequence = sequence + ",";
			}
			return sequence;
		} else
			return sequence;
	}
	public static String nonCrossedOutSubseqToString(boolean[] array){
		String sequence = "";
		if (array != null) {
			for (int index = 0; index < array.length - 1; index++) {

				if (index > 0 && array[index])
					sequence = sequence + "," + (index + STARTING_INDEX);
				else if (array[index])
					sequence = sequence + (index + STARTING_INDEX);
			}
			return sequence;
		} else
			return sequence;
	}
	
}
