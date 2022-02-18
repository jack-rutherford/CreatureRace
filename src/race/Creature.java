package race;

import java.util.Random;

/**
 * 
 * Superclass to the animal classes, contains concrete and abstract methods. 
 * Handles all information about creatures, like name, a racetrack reference,
 * their race position, maximum speed, etc. Each subclass overrides the move
 * method and moves in a unique way
 * 
 * @author jackrutherford
 * @author bereketbessie
 * @date 2/18/22
 * @class CSCI 235
 *
 */
public abstract class Creature {
	private int maximumSpeed;
	private String name;
	protected char[] raceTrack;
	private int racePos;
	private boolean flag;


	public Creature(String name, int movementSpeed, char[] track) {
		this.name = name;
		this.maximumSpeed = movementSpeed;
		raceTrack = track;
		racePos = 0;
	}

	/**
	 * Accessor method for name
	 * @return name
	 */
	public String getName(){
		return name;
	}
	
	/**
	 * Accessor method for maximumSpeed
	 * @return maximumSpeed
	 */
	public int getMaximumSpeed() {
		return maximumSpeed;
	}
	
	/**
	 * checks if the racer has won by checking their current position
	 * @return flag
	 */
	public boolean isWinner() {
		if(racePos == raceTrack.length-1) {
			flag = true;
		}
		return flag;
	}
	
	/**
	 * returns a random number of movement points 
	 * based on creatures max speed
	 * @param maxMove
	 * @return randomMovePoints
	 */
	public int randomMovementPoints(int maxMove) {
		Random rand = new Random();
		return rand.nextInt(maximumSpeed)+1;
	}
	
	/**
	 * Accessor method for the race track. 
	 * @return raceTrack
	 */
	protected char[] getTrack() {
		return raceTrack;
	}
	
	/**
	 * Accessor method for racePos. 
	 * @return
	 */
	protected int getPosition() {
		return racePos;
	}
	
	/**
	 * Increments the position
	 * @return racePos++
	 */
	protected int incrementPosition() {
		return racePos++;
	}
	
	/**
	 * Abstract method for move method
	 */
	public abstract void move();
	
	/**
	 * Returns the creature type from the subclass
	 * @return String
	 */
	public abstract String getCreatureType();
}
