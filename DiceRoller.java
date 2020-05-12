import java.util.Random;
import java.util.Scanner;
 
// dice roller java source code
// Also outputs the dice face as ASCII art
public class DiceRoller {
 
    // This has printing information for all numbers
    // For each number,3x3 matrix represents the face
    int[][][] faceConfig = { { { 0, 0, 0, 0, 0}, { 0, 0, 1, 0, 0}, { 0, 0, 0, 0, 0} },  //1
                           { { 1, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0}, { 0, 0, 0, 0, 1} },   //2
                           { { 1, 0, 0, 0, 0 }, { 0, 0, 1, 0, 0}, { 0, 0, 0, 0, 1} },   //3
                           { { 1, 0, 0, 0, 1 }, { 0, 0, 0, 0, 0}, { 1, 0, 0, 0, 1} },   //4
                           { { 1, 0, 0, 0, 1 }, { 0, 0, 1, 0, 0}, { 1, 0, 0, 0, 1} },   //5
                           { { 1, 0, 0, 0, 1 }, { 1, 0, 0, 0, 1}, { 1, 0, 0, 0, 1} } }; //6
 
    public static void main(final String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final DiceRoller dice_1 = new DiceRoller();
        final DiceRoller dice_2 = new DiceRoller();
        System.out.println("Welcome to the dice game, type 'yes' to play the game and 'no' to quit the game");
        String input = scanner.nextLine();
        if(input.equalsIgnoreCase("y") || input.equalsIgnoreCase("yes")){
	        while (true) {
	            final int result_1 = dice_1.roll();
	            final int result_2 = dice_2.roll();
	            final int doubleDiceResult = result_1 + result_2;
	            System.out.println("x==========================x");
	            System.out.println("dice face value:" + result_1);
	            System.out.println("dice face value:" + result_2);
	            System.out.println("x==========================x");
	            System.out.println("dice combined score:"+ doubleDiceResult);
	            System.out.println("x==========================x");
	            dice_1.draw(result_1);
	            dice_1.draw(result_2);
	            
	
	            System.out.println("Roll again? (type no to quit):");
	            input = scanner.nextLine();
	            if (input.equalsIgnoreCase("n") || input.equalsIgnoreCase("no")) {
	                System.out.println("Bye!");
	                scanner.close();
	                return;
	            }
	            else if(input.equalsIgnoreCase("y") || input.equalsIgnoreCase("yes")){
	            }
	        }
        }
        else if(input.equalsIgnoreCase("n") || input.equalsIgnoreCase("no")){
        	System.out.println("Please play the game next time");
        	System.out.println("Bye!");
            scanner.close();
            return;

        }
    }
 
    // Draw the dice face using ascii characters
    private void draw(int value) {
        int[][] displayVal = faceConfig[value - 1];
        //Top of dice
        System.out.println("-------");
 
        for (int i = 0; i < 3; i++) {
            System.out.print("|");
            for (int j = 0; j < 5; j++) {
                if (displayVal[i][j] == 1) {
                    System.out.print("o");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println("|");
        }
        //Bottom of dice
        System.out.println("-------");
 
    }
 
    // Roll the dice in Java
    private int roll() {
        Random r = new Random();
        return r.nextInt(6) + 1;
    }
}

/*

expected outcome:

-------
|o   o|
|  o  |
|o   o|
-------




*/