
/**
 * The Player Class
 * @author Joseph Burns
 */
public class Player {
	private TheDie playerDie;
	private static final int startScore = 50;
	private String playerName;
	private int playerScore;
	
	/**
	 * @param pName The player's name that is input
	 * @param die The six sided die from TheDie class
	 */
	public Player(String pName, TheDie die){
		this.playerDie = die;
		this.playerName = pName;
		this.playerScore = startScore;
	}
	
	/**
	 * @return The player's score
	 */
	public int getTheScore(){
		return playerScore;
	}
	
	/**
	 * @return The starting score at the beginning of the game
	 */
	public int getTheStartingScore(){
		return startScore;
	}
	
	/**
	 * @return The player's name
	 */
	public String getPlayerName(){
		return playerName;
	}
	
	/**
	 * The act of the player's turn. The die is rolled and then the player's score is subtracted from the value on the die. The method will check if the player's score went below
	 * one. Then if it is, the value of the die is multiplied by two and then added to the player score. In this case it would just return the absolute value.
	 */
	public void takeTurn(){
		playerDie.dieRoll();
		playerScore = playerScore - playerDie.getValue();
		if (playerScore < 1){
			playerScore = playerDie.getValue() * 2 + playerScore;
		} 
	}
}
