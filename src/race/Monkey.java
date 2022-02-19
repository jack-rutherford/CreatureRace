package race;

import java.util.Random;

/**
 * 
 * Monkey class with a max movement speed of 4. Overrides the move method from
 * the creature class to move in its own unique way
 * 
 * @author jackrutherford
 * @author bereketbessie
 * @date 2/18/22
 * @class CSCI 235
 *
 */
public class Monkey extends Creature {
	
	private int movementPoints ;
	
	/**
	 * Constructor for the monkey subclass
	 * Passes information to creature superclass
	 * @param name
	 * @param track
	 */
	public Monkey(String name, char[] track) {
		super(name, 4, track);
	}

	@Override
	/**
	 * Pre condition: The monkey has a position ahead of it to move to
	 * Post condition: The monkey moves ahead a position, or multiple depending
	 * on the terrain and its movement points
	 * Overridden method from the superclass Creature
	 * Monkey moves in a unique way with random movement
	 * points, and moves differently depending on the terrain
	 */
	public void move() {
		// TODO Auto-generated method stub
		Random rand = new Random();
		movementPoints = rand.nextInt(4)+1;
		int racePos = this.getPosition();
		char[] track = this.getTrack();
		while(racePos == 0 && racePos < track.length && movementPoints > 0) {
			if(track[racePos] == '#') {
				incrementPosition();
			}
			else if(track[racePos] == '~' && movementPoints >= 2) {
				movementPoints -= 2;
				incrementPosition();

			}
			else if(track[racePos] == '.' && movementPoints >= 1) {
				movementPoints -= 1;
				incrementPosition();

			}
			else if(track[racePos] == '|' && movementPoints >= 1) {
				movementPoints -= 1;
				incrementPosition();

			}
			else if (track[racePos] == 'O') {
				movementPoints = 0;
				incrementPosition();
			}
			racePos = this.getPosition();
		}
		while(racePos != 0 && racePos < track.length-1 && movementPoints > 0) {
			char pastTrack = track[racePos - 1];
			char currentTrack = track[racePos];
			if(pastTrack != currentTrack) {
				if(track[racePos] == '#') {
					incrementPosition();
				}
				else if(track[racePos] == '~' && movementPoints >= 2) {
					movementPoints -= 2;
					incrementPosition();
				}
				else if(track[racePos] == '.' && movementPoints >= 1) {
					movementPoints -= 1;
					incrementPosition();
				}
				else if(track[racePos] == '|' && movementPoints >= 1) {
					movementPoints -= 1;
					incrementPosition();
				}
				else if (track[racePos] == 'O') {
					movementPoints = 0;
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
	 * Returns the creature type for Monkey
	 * @return "Monkey"
	 */
	public String getCreatureType() {
		return "Monkey";
	}
}


