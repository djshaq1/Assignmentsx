package Dice;
import java.util.Random; 
public class Game {
	
	public static void main(String[] args) {
		int total = 0;
		 Random rn = new Random();
		int die = rn.nextInt(6) + 1;
	while(die != 1) {
		total = total + die;
		die = rn.nextInt(6) + 1;
	    // do something
	}
	
	System.out.printf("The total for this game is %d\n", total);
	}
	

} 
