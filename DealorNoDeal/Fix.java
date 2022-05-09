import java.util.Scanner;
class Fix {
  static Scanner in = new Scanner(System.in);
  public static int credits = 100; // the user starts with 100 credits 
  public static void main(String[] args) {
    menu();
    int choice = getChoice("What game would you like to play?(Enter the number)");
    while(credits > 0 && choice != 6){
			process_choice(choice);
      menu();
			choice = getChoice("What game would you like to play?(Enter the number)");
    }
    System.out.println("Thanks for playing at our arcade! Goodbye.");
  }

	public static void process_choice(int choice){
		if (choice == 1){ // if the user inputs 1, calls the BlackJack method 
			BlackJack();
		}
		else if (choice == 2){
			credits-=5;
			DealOrNoDeal deal = new DealOrNoDeal();
			deal.greet();
			deal.display_cases();
			deal.play();
		}
		else if (choice == 3){
			CodeBreakerGame SinasCode = new CodeBreakerGame ();
			SinasCode.codebreaker();
		}
		else if(choice == 4){
			Slots();
		}
		else if (choice == 5){
			System.out.println("you currently have " + credits + " credits ");
		}
		System.out.println();
	}


	public static void menu(){
			System.out.println("1. BlackJack");
      System.out.println("2. Deal or No Deal");
      System.out.println("3. Code breaker");
      System.out.println("4. Slots");
      System.out.println("5. To show how many credits you currently have");
			System.out.println("6. exit");
	}

	public static int getChoice(String prompt){
		System.out.print(prompt);
		return in.nextInt();
	}
  public static void BlackJack(){
    while (credits > 10){
   System.out.println("Welcome to BlackJack!");
   System.out.println("Click 0 to return to the menu, click any other integer to proceed to the game.");
   int input = in.nextInt();
   if (input == 0){
     break;
   }
   System.out.println("The default bet is 10 credits");
   credits = credits - 10; 
   System.out.println("You now have " + credits + " credits");
    BlackJack Blackjack = new BlackJack();
    credits = Blackjack.system();
   /*
   BlackJack Blackjack = new BlackJack();
   int playerTotal = 0; 
   String outcome = "";
   String blackjack = "";
   int computerTotal = 0; 
     playerTotal = Blackjack.player();
     if (playerTotal == 21){
       blackjack = "yes";
     }
     computerTotal = Blackjack.computer();
     do{
       System.out.println("Would you like to hit or stand (h/s)");
     String hitStand = in.next();
     if (hitStand.equalsIgnoreCase("h")){
       playerTotal = Blackjack.playerHit();
     }
     else{
       break; 
     }
     }while(playerTotal < 21);
     while(true){
     if(playerTotal > 21){
       System.out.println("You went bust! You Lost!");
       outcome = "l";
       break;
     }
     else{
     System.out.println("Fliping the computers hidden card...");
     computerTotal = Blackjack.computerHit();
     }
     if (computerTotal > 21){
       System.out.println("Computer went bust! You Win!");
       outcome = "w";
       break;
     }
     else {
      if (computerTotal == playerTotal){
        System.out.println("It is a draw!");
        outcome = "d"; 
        break;
      }
      else if (computerTotal > playerTotal){
        System.out.println("You Lose!");
        outcome = "l";
        break;
      }
      else if (computerTotal < playerTotal){
        System.out.println("You win!");
        outcome = "w";
        break; 
      }

     }
     }
     if (outcome.equals("w")){
       credits = credits + 20;
     }
     else if (outcome.equals("d")){
       credits = credits + 10; 
     }
     if (blackjack.equalsIgnoreCase("yes")){
       credits = credits + 5; 
     }
     System.out.println("You currently have " + credits + " credits ");   
*/
    }
    
  }

  public static void Slots(){
  
   if (credits >=5){//check how many credits you have

    System.out.println("The default bet for 'Slots' is 5 credits");//prints how much slots costs
    credits = credits - 5; //takes away 5 credits
    
    System.out.println("You now have " + credits + " credits");//prints your new credit amount
    System.out.println("");//spacing

    Slots GoSlots = new Slots(); //make slots object
    int credits4 = GoSlots.slots();//get credits from slots
    credits = credits + credits4;//makes your new credit total

    }//end if statment
    else {//if you dont have enough credits to play
      System.out.println("You have insufficient credits");//print you dont have enough
      System.out.println("To play slots you need a minimum of 5 credits");
    }//end else statement

   System.out.println("");//spacing

  }//end slots method

  

}//end Main class