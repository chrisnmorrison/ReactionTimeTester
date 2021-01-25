import java.util.Scanner;

public class Reaction {

	public static void main(String[] args) throws InterruptedException {
		// initialize variable(s)
		boolean endGame = false;

		System.out.println("Welcome to the Reaction Time Game!");
		System.out.println("Once the game starts, you will be prompted to hit Enter to measure your reaction time.");
		System.out.println("The prompt will be generated randomly, and may occur anywhere between 1 and 10 seconds.");
		System.out.println("Are you ready? Type Yes or Y to Play!");
		Scanner i = new Scanner(System.in);
		// handles letter casing by making input lower case
		String input = i.nextLine();
		input.toLowerCase();

		// loop runs while endGame is false
		while (!endGame) {
			if (input == "yes" || input == "y") {
				System.out.println("Watch for the prompt..");
				
				// Generate random number between 0 and 9000, and cast to a long (necessary for Thread.sleep)
				long randNum = (long) (Math.random() * 9000);
				
				// add 1000 (aka 1 second) to time, so that user has to wait at least 1 second. Otherwise,
				// prompt may be instantaneous
				Thread.sleep(1000 + randNum);
				
				// records start time once sleep() ends
				long start = System.currentTimeMillis();
				System.out.println("PRESS ENTER NOW!");
				
				// System.in.read() reads the Enter key. Try-catch prevents any errors.
				try {
					System.in.read();
				} catch (Exception e) {
				}
				// records end time once Enter is pressed
				long stop = System.currentTimeMillis();

				//calculates reaction time
				long reactionTime = stop - start;
				System.out.println("Your reaction time is " + reactionTime + " milliseconds!\n");
				
				// choice to end game, or play again. For simnplicity, inputting anything other than "N" 
				// will play again.
				System.out.println("Try again? Y or N");
				input = i.next().toUpperCase();
				if (input.equals("N")) {
					System.out.println("Thanks for playing, goodbye!");
					endGame = true;
				}
			}
		}
	}

}
