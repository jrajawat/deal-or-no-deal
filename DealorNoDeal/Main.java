
import java.util.Random;
import java.util.Scanner;

public class Main {
	public static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Welcome to Deal or No Deal!");
		System.out.println("There are 25 cases available today:");
		for (int j = 1; j <= 25; j++) {
			if (j % 5 != 0) {
				System.out.print(j + " ");
			} else {
				System.out.println(j);
			}
		}
		int[] casesNoOrder = { 1, 5, 10, 25, 50, 75, 100, 200, 300, 400, 500, 750, 1000, 5000, 10000, 25000, 50000,
				75000, 100000, 200000, 300000, 400000, 500000, 750000, 1000000 };
		int[] randomCases = randomOrder(casesNoOrder);
		System.out.println("Please choose your personal case. Enter a case number 1 through 25");
		int personalCase = input.nextInt();
		int personalValue = 0;
		personalValue = randomCases[personalCase - 1];
		randomCases[personalCase - 1] = 0;

		play(randomCases, personalValue, personalCase);

	}

	public static int[] randomOrder(int[] casesNoOrder) {
		Random rand = new Random();
		int[] randomCases = new int[25];
		for (int i = 0; i < casesNoOrder.length; i++) {
			randomCases[i] = casesNoOrder[i];
		}
		for (int j = 0; j < randomCases.length; j++) {
			int indexChange = rand.nextInt(randomCases.length);
			int temp = randomCases[indexChange];
			randomCases[indexChange] = randomCases[j];
			randomCases[j] = temp;
		}
		return randomCases;
	}

	public static void play(int[] randomCases, int personalValue, int personalCase) {
		int chooseCases = 6;
		int count = 0;
		int remainingCases = 24;
		int sum = 0;
		double bankOffer = 0;
		while (chooseCases >= 0) {
			System.out.println("You now have to choose " + chooseCases + " case(s).");
			while (count < chooseCases) {
				System.out.println("Choose a case: ");
				int caseChoice = input.nextInt();
				
				for (int i = 0; i <= randomCases.length; i++) {

					if (i == (caseChoice - 1)) {
						System.out.println("That case had a value of: $" + randomCases[i]);
						randomCases[i] = 0;
						count++;
						remainingCases--;
					}
					else {
						System.out.println("You entered an invalid case option, please try again.");
					}
				}
				
			}
			for (int j = 0; j < randomCases.length; j++) {
				if (randomCases[j] != 0) {
					sum += randomCases[j];
				}
			}
			if (chooseCases == 6 || chooseCases == 5) {
				bankOffer = (sum / remainingCases) / 3;
				sum = 0;
				chooseCases--;
				chooseCases = dOND(bankOffer, randomCases, chooseCases);
				count =0;
			} else if (chooseCases == 4 || chooseCases == 3 || chooseCases == 2) {
				bankOffer = (sum / remainingCases) / 2;
				sum = 0;
				chooseCases--;
				chooseCases = dOND(bankOffer, randomCases, chooseCases);
				count =0;
			} else if (remainingCases == 4 || remainingCases == 3 || remainingCases == 2) {
				bankOffer = (sum / remainingCases) / 1.5;
				chooseCases = dOND(bankOffer, randomCases, chooseCases);
				count =0;
			} else if (remainingCases == 1) {
				System.out.println("You now have to open your personal case. This was case: " + personalCase);
				System.out.println("Congratulations! You won: $" + personalValue);
				chooseCases = -1;
			}
		}
	}

	public static int dOND (double bankOffer, int[] randomCases, int chooseCases) {
		int counter=0;
		System.out.printf("The banker offers: $%.2f%n", bankOffer);
		System.out.println("Deal or No Deal?");
		String deal = input.next();
		if (deal.equalsIgnoreCase("deal")) {
			System.out.printf("Congratulations! You won: $%.2f%n", bankOffer);
			chooseCases = -1;
		} else {
			System.out.println("Keep trying!");
			System.out.println("These are the remaining cases.");
			for (int k = 0; k < (randomCases.length); k++) {
				
				if (randomCases[k] != 0) {
					counter++;
					if (counter%5==0) {
						System.out.println(k + 1);
					} else {
						System.out.print((k + 1)+" ");
					}
				}
			}

		}
		return chooseCases;
	}

}






