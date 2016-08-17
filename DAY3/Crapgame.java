import java.util.Random;

public class Crapgame {
	int totalWins = 0;
	int totalLosses = 0;
public void run(){ 
	int count = 1;
	boolean isFinished = false;
	
	int point = 0;
	Random rn = new Random();
	int dice = 0;
	dice = (rn.nextInt(6) + 1) + (rn.nextInt(6) + 1);

	while (isFinished == false) {
		if (count == 1) {
			if (dice == 12 || dice == 2 || dice == 3) {
				totalLosses++;
				isFinished = true;

			} else if (dice == 7) {
				totalWins++;
				isFinished = true;

			} else {
				point = dice;
				dice = (int) (rn.nextInt(6) + 1) + (int) (rn.nextInt(6) + 1);

			}

		} else {
			if (dice == point) {
				totalWins++;

				isFinished = true;
			} else if (dice == 7) {
				totalLosses++;
			}

		}
	}
	
}

	public static void main(String[] args) {
		Crapgame myGame = new Crapgame();
		for (int i = 0; i < 100; i++) {
		myGame.run();
		}
		System.out.printf("The total wins for this game is %d\n", myGame.totalWins);
		System.out.printf("The total losses for this game is %d\n", myGame.totalLosses);
	}
}
