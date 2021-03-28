/* Joseph Burns
 * 9/7/2020
 * The First One to One Game
 * Description - The purpose of this game is to roll a die and get to one as soon as possible. The game can take many players at once to roll. Each player starts with 50 points.
 * Every time the player takes their turn, they roll a six sided die. The number that comes from the roll is then subtracted from the player's total score. Each player will continuously roll
 * until a player reaches one point and deemed the winner. If the possibility the player's total score goes below one point, the number that they roll will be added to their total score instead.
 * The game will end when the first player hits one point.
 */

import java.util.*;

public class Burns_the_one_game_main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// All variables are declared and initialized. The objects are created with the six sided die and the scanner for inputs.
		String morePlayers = "y", playerName, playerWinner = "", theWinner = "";
		ArrayList<Player> playerArrayList = new ArrayList<Player>();
		Scanner keyboard = new Scanner(System.in);
		TheDie playerDie = new TheDie(6);

		// The welcoming to the players of the game. The players will be able to input their names. Then they will be prompted with a yes or no to see if there are more players. The game 
		// can hold any number of players at once. The program will only continue to add players if the string "y" isn't detected. This is just in case an infinite loop is not initialized.
		// The program will also force the input to be lower-case as well just in case user error.
		System.out.println("Welcome to the First-to-One Game!");
		while(morePlayers.equals("y")){
			System.out.println("Enter Player Name:");
			playerName = keyboard.next();
			playerArrayList.add(new Player(playerName, playerDie));
			System.out.println("New Player (y/n):");
			morePlayers = keyboard.next();
			morePlayers = morePlayers.toLowerCase();
		}
		
		// Close the keyboard object because input will not be needed for the rest of the program.
		keyboard.close();
		
		// This is the while loop that is the core of the program. The program will continuously run until a player hits one point. So in that case, a for each loop will work every player's
		// turn in the game. The program will show the player who's turn it is and roll the die with the takeTurn() method. The program will output the player's name and their score after
		// their turn. The program will check to see whether or not the player has one point after their turn. If they do have one point, the program will break out of the for each loop because
		// they became the very first person to hit one point and end the game. Otherwise, the game continues.
		while(playerWinner != "win"){
			for (Player p : playerArrayList){
				System.out.println("Player " + p.getPlayerName() + " Rolling Die...");
				p.takeTurn();
				System.out.println("After " + p.getPlayerName() + "'s turn they have a score of " + p.getTheScore());
				if (p.getTheScore() == 1){
					playerWinner = "win";
					theWinner = p.getPlayerName();
					break;
				}
			}
		}
		
		// This is the final output after a player has hit one point. A nice little congratulations with the player's name!
		System.out.println("Congratulations! " + theWinner + " got to one first and wins!");
	
	}
}