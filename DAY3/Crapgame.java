import java.util.Random;

public class Crapgame {
	int totalWins = 0;
	int totalLosses = 0;
	boolean forward = true;
public void run(){ 
	
	Random rn = new Random();
	int dice = 0;
	dice = (rn.nextInt(6) + 1) + (rn.nextInt(6) + 1);
	System.out.printf("You rolled a %d\n", dice);
			if (dice == 12 || dice == 2 || dice == 3) {
				totalLosses++;
				System.out.println("You Lose ");
				

			} else if (dice == 7) {
				totalWins++;
				System.out.println("You Win ");
				
			} else {
				int point = dice;
				System.out.printf("Point is %d\n", point);
				while(forward = true) {
				dice = (int) (rn.nextInt(6) + 1) + (int) (rn.nextInt(6) + 1);
				
			
			System.out.printf("Next roll %d\n", dice);
			if (dice == point) {
				totalWins++;
			System.out.println("You Win ");
				break;
			}  if (dice == 7) {
				totalLosses++;
			System.out.println("You Lose ");
				break; 
				
			
			}

		}

			}
}

	public static void main(String[] args) {
		Crapgame myGame = new Crapgame();
		for (int i = 0; i < 5; i++) {
		myGame.run();
		}
		System.out.printf("The total wins for this game is %d\n", myGame.totalWins);
		System.out.printf("The total losses for this game is %d\n", myGame.totalLosses);
		System.out.printf("Do you want to play again? ");
	}
}
