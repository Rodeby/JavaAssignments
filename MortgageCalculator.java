import java.util.Scanner;
public class MortgageCalculator {

public static final int NUMBER_OF_MONTHS_IN_A_YEAR = 12;

	public static void main(String[] args) {
		
		
		boolean quit = false;
		double mortgageAmount = 0;
		double APR = 0;
		double amountToBePaidMonthly = 0;
		double totalMonths = 0;
		boolean continueLoop = false;
		while(!quit){
			mortgageAmount= readDoubleFromUser("Please enter the mortgage amount: ");			
			APR=readDoubleFromUser("Please enter the annual interest rate (APR): ");
			
			
			System.out.println("Assuming a 20 year term, the monthly repayments would be: "
					+String.format("%.02f", calculateMonthlyRepayment(mortgageAmount,20,APR)));
			
			amountToBePaidMonthly = readDoubleFromUser("How much can you afford to pay per month?");								
			totalMonths = monthsToRepayMortgage(mortgageAmount,amountToBePaidMonthly,APR);
			
			System.out.println("If you pay €"+ String.format("%.00f",amountToBePaidMonthly)+ " per month your "
					+ "mortgage would be paid off in " + String.format("%.00f",totalMonths/NUMBER_OF_MONTHS_IN_A_YEAR)
					+" years and " + Math.round(totalMonths%NUMBER_OF_MONTHS_IN_A_YEAR) + " months");
						
			System.out.println("Would you like to use the mortgage calculator again (yes/no)?");
			Scanner input = new Scanner(System.in);
			String inputString = input.next();
			
			if(inputString.equalsIgnoreCase("no"))
				quit = true;

			else if (inputString.equalsIgnoreCase("yes"));
				
			else
				System.out.println("Invalid input.");
			
		}
		System.out.println("Thank you for your time");
	}	

	public static double readDoubleFromUser(String question){
		Scanner input = new Scanner(System.in);
		boolean hasDouble = false;
		double	returnValue = 0;
		do{
			System.out.println(question);
			if(input.hasNextDouble()){
				returnValue = input.nextDouble();
				hasDouble = true;
			}
			else {
				System.out.println("Invalid input");	
				input.next();
			}
		}while(!hasDouble);
		
		return returnValue;
		}
		
		
	
	
	public static double calculateMonthlyRepayment(double principle, int duractionInYears,double APR ){
		
		double monthlyRepayment = 0;
		
		
		
		monthlyRepayment =(double) (principle * (APR/NUMBER_OF_MONTHS_IN_A_YEAR/100)) / ((1 - Math.pow((1+APR/NUMBER_OF_MONTHS_IN_A_YEAR/100), 
				(-duractionInYears*NUMBER_OF_MONTHS_IN_A_YEAR))));
		
		return monthlyRepayment;
		
	}


	public static int monthsToRepayMortgage(double mortgageAmount,double amountToBePaidMonthly,double APR){

		double monthlyPercentageRate = APR/NUMBER_OF_MONTHS_IN_A_YEAR/100;
		double interestEachMonthToBePaid = 0;
		int numberOfMonths = 0;
		while(mortgageAmount>=0){
			interestEachMonthToBePaid = monthlyPercentageRate * mortgageAmount;
			mortgageAmount = mortgageAmount + interestEachMonthToBePaid;
			mortgageAmount = mortgageAmount - amountToBePaidMonthly;
			numberOfMonths++;
		}
		
		
		
		return numberOfMonths;
	}

}

