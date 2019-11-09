public class TwelveDaysOfChristmasExtended {
	public static final int NUMBER_OF_MONTHS_IN_YEAR = 12;
	
	public static void main(String[] args) {

		
		for(int i = 1; i <= NUMBER_OF_MONTHS_IN_YEAR; i++){			
			System.out.println(getVerse(i));
				for(int j = i; j > 0;j-- )
					System.out.println(getChristmasGift(j));		
			System.out.println();
		}
	}

	
	public static String getChristmasGift(int giftNumber){
		String verse =  " ";
		switch(giftNumber)
		{
		case 12 : verse = "12 drummers drumming";
		break;
		case 11 : verse = "11 pipers piping";
		break;
		case 10 : verse = "10 lords a-leaping";
		break;
		case 9 : verse = "9 ladies dancing";
		break;
		case 8 : verse = "8 maids a-milking";
		break;
		case 7 : verse = "7 swans a-swimming";
		break;
		case 6 : verse = "6 geese a-laying";
		break;
		case 5 : verse = "5 golden rings";
		break;
		case 4 : verse = "4 calling birds";
		break;
		case 3 : verse = "3 french hens";
		break;
		case 2 : verse = "2 turtle doves, and";
		break;
		default: verse = "a partridge in a pear tree.";	
		break;
		}
		return verse;
	}


	public static String getOrdinalString(int dayNumber){
		String ordinalString = "";
		if(dayNumber == 1)
			ordinalString = "first";
		else if (dayNumber == 2)
			ordinalString = "second";
		else if (dayNumber == 3)
			ordinalString = "third";
		else if (dayNumber == 4)
			ordinalString = "fourth";
		else if (dayNumber == 5)
			ordinalString = "fith";
		else if (dayNumber == 6)
			ordinalString = "sixth";		
		else if (dayNumber == 7)
			ordinalString = "seventh";
		else if (dayNumber == 8)
			ordinalString = "eighth";
		else if (dayNumber == 9)
			ordinalString = "ninth";
		else if (dayNumber == 10)
			ordinalString = "tenth";
		else if (dayNumber == 11)
			ordinalString = "eleventh";
		else  
			ordinalString = "twelvth";
		
		return ordinalString;
	}


	public static String getVerse(int verseNumber){
		String verse = "On the " + getOrdinalString(verseNumber)
		+ " my true love sent to me:";
				
		return verse;
	}
	
	
}
