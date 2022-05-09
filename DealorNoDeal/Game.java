import java.util.Random;
import java.util.Scanner;
public class Game{
	public static void main(String[] args){
		DealOrNoDeal deal = new DealOrNoDeal();
		deal.greet();
		deal.display_cases();
		deal.play();
	}
}


class DealOrNoDeal extends Game{

	int[] randomCases;
	public DealOrNoDeal(){
		this.randomCases = this.randomOrder(new int[]{ 1, 5, 10, 25, 50, 75, 100, 200, 300, 400, 500, 750, 1000, 5000, 10000, 25000, 50000, 75000, 100000, 200000, 300000, 400000, 500000, 750000, 1000000 });

	}

	public void greet(){
    System.out.println("Welcome to Deal or No Deal!");
		System.out.println("There are 25 cases available today:");
	}

	public void display_cases(){
		for (int j = 1; j <= 25; j++) {
			if (j % 5 != 0) {
				System.out.print(j + " ");
			} else {
				System.out.println(j);
			}
		}
	}

	private int[] randomOrder(int[] casesNoOrder) {
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


	public void play() {


		//personal case code
		Scanner input = new Scanner(System.in);
		System.out.println("Please choose your personal case. Enter a case number 1 through 25");
		int personalCase = input.nextInt();
		int personalValue = randomCases[personalCase - 1];
		randomCases[personalCase - 1] = 0;



		//Main Game
		int chooseCases = 6;
		int remainingCases = 24;
		double bankOffer = 0;
		boolean not_started = true;
		while( not_started || (!dOND(bankOffer) && remainingCases > 1 )){
			not_started = false;

			//choose cases
			System.out.println("You now have to choose " + chooseCases + " case(s).");
			int count = 0;
			int sum = 0;
			while (count < chooseCases) {
				System.out.println("Choose a case: ");
				int caseChoice = input.nextInt();
				System.out.println("That case had a value of: $" + randomCases[caseChoice - 1]);
				randomCases[caseChoice - 1] = 0;
				count++;
				remainingCases--;				
			}


			//calculates sum
			for (int j = 0; j < randomCases.length; j++) {
					sum += randomCases[j];
			}


			//calculates constant
			double constant = 1.5;
			if (chooseCases >= 5) {
				constant = 3;
			} 
			else if (chooseCases >= 2) {
				constant = 2;
			}

			//returns bank offer
			bankOffer = (sum / remainingCases) / constant;
			
			if(2 <= chooseCases ){
				chooseCases--;
			}
		}

		System.out.println("You now have to open your personal case. This was case: " + personalCase);
		System.out.println("Congratulations! You won: $" + personalValue);
	}


	public boolean dOND (double bankOffer) {
		Scanner input = new Scanner(System.in);
		int counter=0;
		System.out.printf("The banker offers: $%.2f%n", bankOffer);
		System.out.println("Deal or No Deal?");
		String deal = input.next();
		if (!deal.equalsIgnoreCase("deal")) {

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
			return false;
		}
		System.out.printf("Congratulations! You won: $%.2f%n", bankOffer);
		
		return true;
	}

}
