import java.util.Scanner;

public class ChuckALuck {

	public static final int STANDARD_ODDS_MULTIPLE = 2;
	public static final int TRIPLE_ODDS_MULTIPLE = 31;
	public static void main(String[] args) {

		boolean quit = false;
		Wallet playerWallet = new Wallet();

		while (!quit) {
			Scanner input = new Scanner(System.in);
			System.out.println("Please enter your amount of cash: ");

			if (input.hasNextDouble()) {
				double playerCash = input.nextDouble();
				if (playerCash > 0) {
					double initialAmount = playerCash;
					playerWallet.put(playerCash);
					while (!quit) {
						System.out.println(
								"Your current wallet balance is: €" + String.format("%.02f", playerWallet.check()));
						System.out.println("Please enter your bet type or enter quit to end");
						String betType = input.next();
						if (betType.equalsIgnoreCase("quit")) {
							quit = true;
						} else if (validInput(betType)) {

							ResolveBet(betType, playerWallet);
							if (playerWallet.check() == 0)
								quit = true;
						} else {
							System.out.println("Not a valid input!");
						}

						if (quit) {
							System.out.println("You started with: €" + String.format("%.02f", initialAmount)
									+ " and ended with: €" + String.format("%.02f", playerWallet.check())
									+ ", which is a " + (initialAmount < playerWallet.check() ? "profit" : "loss")
									+ " of €" + String.format("%.02f", Math.abs(initialAmount - playerWallet.check())));
						}
					}
				} else {
					System.out.println("Not a valid input");
				}
			} else {
				System.out.println("Not a valid input!");
			}

		}

	}

	public static void ResolveBet(String betType, Wallet wallet) {
		Dice dice1 = new Dice();
		Dice dice2 = new Dice();
		Dice dice3 = new Dice();
		double winnings = 0;
		boolean result = false;

		boolean enoughMoney = false;

		while (!enoughMoney) {
			System.out.println("How much would you like to bet?");
			Scanner input = new Scanner(System.in);
			if (input.hasNextDouble()) {
				double bet = input.nextDouble();
				if (!wallet.get(bet)) {
					System.out.println("You don't have that much money!");
				} else {
					dice1.roll();
					dice2.roll();
					dice3.roll();

					int totalDice = dice1.topFace() + dice2.topFace() + dice3.topFace();

					System.out.println(dice1.toString());
					System.out.println(dice2.toString());
					System.out.println(dice3.toString());

					switch (betType.toUpperCase()) {
					case ("TRIPLE"):
						if (Triple(dice1.topFace(), dice2.topFace(), dice3.topFace())) {
							winnings = bet * TRIPLE_ODDS_MULTIPLE;
							result = true;
						}
						break;
					case ("FIELD"):
						if (Field(dice1.topFace(), dice2.topFace(), dice3.topFace())) {
							winnings = bet * STANDARD_ODDS_MULTIPLE;
							result = true;
						}
						break;
					case ("HIGH"):
						if (High(dice1.topFace(), dice2.topFace(), dice3.topFace())) {
							winnings = bet * STANDARD_ODDS_MULTIPLE;
							result = true;

						}
						break;
					case ("LOW"):
						if (Low(dice1.topFace(), dice2.topFace(), dice3.topFace())) {
							winnings = bet * STANDARD_ODDS_MULTIPLE;
							result = true;

						}
						break;
					}

					System.out.println("The total of the dice are: " + totalDice);
					enoughMoney = true;
					if (result == true) {
						wallet.put(winnings);
						System.out.println("Congradulations, you won!");

					} else {
						System.out.println("Unfortunately you lost");

					}
					System.out.println("Your new updated balance is: €" + String.format("%.02f", wallet.check()));
				}
			} else {
				System.out.println("Not a valid input!");
			}

		}

	}

	public static boolean Triple(int dice1, int dice2, int dice3) {
		if (((dice1 == dice2) && (dice1 == dice3)) && !lowHighTriple(dice1, dice2, dice3))
			return true;
		else
			return false;
	}

	public static boolean Field(int dice1, int dice2, int dice3) {
		int totalDice = dice1 + dice2 + dice3;
		if (totalDice < 8 && totalDice > 12)
			return true;
		else
			return false;
	}

	public static boolean High(int dice1, int dice2, int dice3) {
		int totalDice = dice1 + dice2 + dice3;
		if (totalDice > 10 && !HighTriple(dice1, dice2, dice3))
			return true;
		else
			return false;
	}

	public static boolean Low(int dice1, int dice2, int dice3) {
		int totalDice = dice1 + dice2 + dice3;
		if (totalDice < 11 && !LowTriple(dice1, dice2, dice3))
			return true;
		else
			return false;
	}

	public static boolean HighTriple(int dice1, int dice2, int dice3) {
		boolean highTriple = false;
		if (dice1 == 4 && dice2 == 4 && dice3 == 4)
			highTriple = true;
		else if (dice1 == 5 && dice2 == 5 && dice3 == 5)
			highTriple = true;
		else if (dice1 == 6 && dice2 == 6 && dice3 == 6)
			highTriple = true;
		else
			highTriple = false;
		return highTriple;
	}

	public static boolean LowTriple(int dice1, int dice2, int dice3) {
		boolean lowTriple = false;
		if (dice1 == 1 && dice2 == 1 && dice3 == 1)
			lowTriple = true;
		else if (dice1 == 2 && dice2 == 2 && dice3 == 2)
			lowTriple = true;
		else if (dice1 == 3 && dice2 == 3 && dice3 == 3)
			lowTriple = true;
		else
			lowTriple = false;
		return lowTriple;
	}

	public static boolean lowHighTriple(int dice1, int dice2, int dice3) {
		boolean lowHighTriple = false;
		if (dice1 == 1 && dice2 == 1 && dice3 == 1)
			lowHighTriple = true;
		else if (dice1 == 6 && dice2 == 6 && dice3 == 6)
			lowHighTriple = true;
		else
			lowHighTriple = false;
		return lowHighTriple;
	}

	public static boolean validInput(String word) {
		if (word.equalsIgnoreCase("triple") || word.equalsIgnoreCase("field") || word.equalsIgnoreCase("high")
				|| word.equalsIgnoreCase("low") || word.equalsIgnoreCase("quit"))
			return true;
		else
			return false;

	}

	public static boolean validDouble(double number) {
		if (number > 0)
			return true;
		else
			return false;
	}
}
