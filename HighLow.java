import java.util.Scanner;
import javax.swing.JOptionPane;
import javax.swing.JDialog;
import javax.swing.JButton;
import javax.swing.JFrame;


public class HighLow {
	JFrame frame;
	public static final int MAXIMUM_CARD_NUMBER_WITHOUT_NAME = 10;
	public static void main(String[] args) {
		
		Object[] options ={ "Higher", "Lower"};
		int guessCount = 0;		
		
		while(guessCount != 4){	
			
			int cardNumber = (int) (Math.random() *12)+2;
			int nextCardNumber = (int) (Math.random() *12)+2;
			
			System.out.println("The card is a " + ((cardNumber > MAXIMUM_CARD_NUMBER_WITHOUT_NAME) ? intToCardName(cardNumber) : cardNumber));
			
			int userMessage = JOptionPane.showOptionDialog(null, "Will the next card be higher or lower?","Card Game",
					JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,options,options[0]);
			
			 if(userMessage == JOptionPane.YES_OPTION)
			{	
				if(nextCardNumber > cardNumber)
				{
				guessCount++;
				System.out.println("You are correct! The next card number was "+
				((nextCardNumber > MAXIMUM_CARD_NUMBER_WITHOUT_NAME) ? intToCardName(nextCardNumber) : nextCardNumber)+ 
						" Your guess count is now: " + guessCount);
				}
				else
				{
						guessCount = 0;
						System.out.println("You were wrong.The next card number was "+
						((nextCardNumber > MAXIMUM_CARD_NUMBER_WITHOUT_NAME) ? intToCardName(nextCardNumber) : nextCardNumber)
								+" Your guess count has now been reset to 0");
				}
				}
			else
			{
				if(nextCardNumber < cardNumber)
				{
				guessCount++;
				System.out.println("You are correct! The next card number was "
				+((nextCardNumber > MAXIMUM_CARD_NUMBER_WITHOUT_NAME) ? intToCardName(nextCardNumber) : nextCardNumber)
						+" Your guess count is now: " + guessCount);
				}
				else
				{
					guessCount = 0;
					System.out.println("You were wrong. The next card number was "+
					((nextCardNumber > MAXIMUM_CARD_NUMBER_WITHOUT_NAME) ? intToCardName(nextCardNumber) : nextCardNumber)+
					" Your guess count has now been reset to 0");
				}	
			}
			 
		}
	}



	public static String intToCardName(int cardNumber){
		String cardName = "";		
		switch(cardNumber){
		case 11 : cardName = "Jack";
		break;
		case 12 : cardName = "Queen";
		break;
		case 13 : cardName = "King";
		break;
		case 14 : cardName = "Ace";
		break;
		}
		return cardName;
		
	}
}
