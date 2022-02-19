package race;

import java.util.Random;

/**
 * 
 * Turtle class with a max movement speed of 2. Overrides the move method from
 * the creature class to move in its own unique way
 * 
 * @author jackrutherford
 * @author bereketbessie
 * @date 2/18/22
 * @class CSCI 235
 *
 */
public class Turtle extends Creature {
	
	private int movementPoints;
	
	/**
	 * Constructor for the turtle subclass
	 * Passes information to creature superclass
	 * @param name
	 * @param track
	 */
	public Turtle(String name, char[] track) {
		super(name, 2, track);
		// TODO Auto-generated constructor stub
	}

	@Override
	/**
	 * Pre condition: The turtle has a position ahead of it to move to
	 * Post condition: The turtle moves ahead a position, or multiple depending
	 * on the terrain and its movement points
	 * Overridden method from the superclass Creature
	 * Turtle moves in a unique way with random movement
	 * points, and moves differently depending on the terrain
	 */
	public void move() {
		// TODO Auto-generated method stub
		Random rand = new Random();
		movementPoints = rand.nextInt(2)+1;
		int racePos = this.getPosition();
		char[] track = this.getTrack();
		while(racePos == 0 && racePos < track.length && movementPoints > 0) {
			{
				if(track[racePos] == 'O') {
					incrementPosition();
				}
				else if(track[racePos] != 'O' && movementPoints >= 1) {
					movementPoints -= 1;
					incrementPosition();

				}
			}
			racePos = this.getPosition();
		}
		while(racePos != 0 && racePos < track.length && movementPoints > 0) {
			char currentTrack = track[racePos];
			char pastTrack = track[racePos - 1];
			if(pastTrack != currentTrack) {
				if(track[racePos] == 'O') {
					incrementPosition();
				}
				if(track[racePos] != 'O' && movementPoints >= 1) {
					movementPoints -= 1;
					incrementPosition();
				}
				else {
					break;
				}
			}
			else {
				incrementPosition();
			}
			racePos = this.getPosition();
		}
	}

	@Override
	/**
	 * Pre condition: none
	 * Post condition: returns a String of the creature type 
	 * Returns the creature type for Turtle
	 * @return "Turtle"
	 */
	public String getCreatureType() {
		return "Turtle";
	}
}
