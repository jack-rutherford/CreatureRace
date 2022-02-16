package race;

import java.util.Random;

public abstract class Creature {
	private int maximumSpeed;
	private String name;
//	private Race race;
	protected char[] racetrack;
	protected int racePos;
	protected boolean flag;


	public Creature(String name, int movementSpeed, char[] track) {
		this.name = name;
		this.maximumSpeed = movementSpeed;
		racetrack = track;
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
	 * checks if the racer has one by checking their current position
	 * @return flag
	 */
	public boolean isWinner() {
		if(racePos == racetrack.length-1) {
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

	public abstract void move(int movePoints);

	
	
}
