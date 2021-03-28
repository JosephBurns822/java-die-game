import java.util.Random;

/**
 * The Die Class
 * @author Joseph Burns
 */
public class TheDie {
	private int sides;
	private int value;
	
	/**
	 * @param numSides The number of sides the die will have
	 */
	public TheDie(int numSides) {
		sides = numSides;
		dieRoll();
	}

	/**
	 * @return The amount of sides the die has
	 */
	public int getSides() {
		return sides;
	}
	
	/**
	 * @return The value of the side that the die rolls
	 */
	public int getValue() {
		return value;
	}
	
	/**
	 * Randomly selects a number within the range 1-6
	 */
	public void dieRoll() {
		Random rand = new Random();
		value = rand.nextInt(sides) + 1;
	}
}

	
