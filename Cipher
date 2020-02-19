import java.util.Scanner;

public class Cipher {
	public static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz ";
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		int shift = (int) (Math.random() *25)+1;
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter your word or sentence to be encrypted: ");
		String userSentence = new String();
		userSentence = input.nextLine();
		
		String userSentenceLowerCase = userSentence.toLowerCase();
		String encryptedText =createCipher(userSentenceLowerCase, shift);
		System.out.println("Your encrypted sentence is now: "+ encryptedText);
		System.out.println("After decrypting your text is now: " + decrypt(encryptedText,shift));
		System.out.println("Press 0 to discontinue");
		
	}

	public static String createCipher(String userSentence,int shift){
		
		userSentence = userSentence.toLowerCase();
		
        String encryptedMessage = "";
        for (int index = 0; index < userSentence.length(); index++)
        {
        	if(userSentence.charAt(index) != ' '){
        		int characterIndex = ALPHABET.indexOf(userSentence.charAt(index));
                int keyOfCharacter = (shift + characterIndex)%26;
                char newCharacter = ALPHABET.charAt(keyOfCharacter);
                encryptedMessage += newCharacter;	
        	}
        	else{
        		encryptedMessage += ' ';
        	}
            
        }
        return encryptedMessage;

	}
	public static String encrypt(String userSentence, int shift){
		return createCipher(userSentence, shift);
	}
	public static String decrypt(String encryptedText, int shift){
		
        String descryptedText = "";
        for (int index = 0; index < encryptedText.length(); index++)
        {
        	if(encryptedText.charAt(index) != ' '){
	            int charPosition = ALPHABET.indexOf(encryptedText.charAt(index));
	            int positionKey = (charPosition - shift)%26;
	            if (positionKey < 0)
	            {
	                positionKey = ALPHABET.length() + positionKey;
	            }
	            char newCharacter = ALPHABET.charAt(positionKey);
	            descryptedText += newCharacter;
        	}
        	else{
        		descryptedText += ' ';
        	}
        }
        return descryptedText;
}
}
