import java.util.Scanner;

public class MenuBasedSystem{
	public static void main(String[] args){
		
		System.out.println("Welcome to the arcade");
		menu();

		int choice = getChoice("Enter your choice: ");
		while(choice != 5){
			process_choice(choice);

			System.out.println("Lets play again");
			menu();
			choice = getChoice("Enter your choice: ");
		}
	}

	public static void process_choice(int choice){
		if(choice == 1){
			DealOrNoDeal deal = new DealOrNoDeal();
			deal.greet();
			deal.display_cases();
			deal.play();
		}
		else if(choice == 2){
			//add another
		}
		else if(choice == 3){
			//add another
		}
		else if(choice == 4){

		}
		else if(choice == 5){

		}
		System.out.println("\n\n");
	}

	public static void menu(){
		System.out.println("1. Deal or no deal");
		System.out.println("2. Deal or no deal");
		System.out.println("3. Deal or no deal");
		System.out.println("4. Deal or no deal");
		System.out.println("5. exit");
	}


	public static int getChoice(String prompt){
		Scanner input = new Scanner(System.in);
		int choice;
		System.out.print(prompt);
		choice = input.nextInt();
		return choice;
	}
}

