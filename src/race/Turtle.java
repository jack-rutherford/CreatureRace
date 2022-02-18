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

	public Turtle(String name, char[] track) {
		super(name, 2, track);
		// TODO Auto-generated constructor stub
	}

	@Override
	/**
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
		int counter1 = 0;
		while(racePos == 0 && racePos < track.length && movementPoints > 0 && counter1 == 0) {
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
			counter1++;
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
	 * Returns the creature type for Monkey
	 * @return "Turtle"
	 */
	public String getCreatureType() {
		return "Turtle";
	}
}
