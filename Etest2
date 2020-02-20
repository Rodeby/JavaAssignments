import java.util.Scanner;
public class eTest2 {
	public static void main(String[] args) {	
				
		int[] numbers = null;
		boolean finished = false;
		int[] testArray = null;
		do{
			Scanner input = new Scanner( System.in );
			System.out.println("Enter an interger to add to the array (or 'quit' to finish): ");
			if (input.hasNextInt()){
				int[] newNumbers = new int[(numbers==null)?1:numbers.length+1];
				if (numbers!= null)
					System.arraycopy( numbers, 0, newNumbers, 0, numbers.length );
				newNumbers[newNumbers.length-1] = input.nextInt();
				numbers = newNumbers;
				
				
				System.out.println("The minimum value is: "+minimumValue(numbers)+ 
						", and the values are " +(isPalindromic(numbers) ?"": "not ") + "palindromic." );
			
			}
			else if(input.hasNext("quit")){
				finished = true;
			}
			else{
				System.out.println("Invalid input");
			}
			
			
		}while(!finished);
	}
	
	public static int minimumValue(int[] array){
		int noValuesInArray = 0;
		boolean isEmpty = false;		
		if(array == null){
			isEmpty = true;
		}
												
		int minimumValue = array[0];
			
		for(int index = 0; index < array.length;index ++)
			if(array[index]< minimumValue)
				minimumValue = array[index];
		
		return isEmpty ? noValuesInArray : minimumValue;
		
		
	}
	public static boolean isPalindromic(int[] array){
		int firstIndex = 0;
		int lastIndex = array.length-1;
	    boolean isPalindromic = true;
		while(lastIndex>firstIndex ){
		
			if(array[firstIndex] != array[lastIndex])
				isPalindromic = false;
				firstIndex++;
				lastIndex--;
		}
		return isPalindromic;
	}
	
}
