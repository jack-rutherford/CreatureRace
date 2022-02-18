package race;

import java.util.Random;

/**
 * 
 * Ostrich class with a max movement speed of 5. Overrides the move method from
 * the creature class to move in its own unique way
 * 
 * @author jackrutherford
 * @author bereketbessie
 * @date 2/18/22
 * @class CSCI 235
 *
 */
public class Ostrich extends Creature {

	private int movementPoints;

	public Ostrich(String name, char[] track) {
		super(name, 5, track);
		// TODO Auto-generated constructor stub
	}

	@Override
	/**
	 * Overridden method from the superclass Creature
	 * Ostrich moves in a unique way with random movement
	 * points, and moves differently depending on the terrain
	 */
	public void move() {
		// TODO Auto-generated method stub
		Random rand = new Random();
		movementPoints = rand.nextInt(5)+1;
		int racePos = this.getPosition();
		char[] track = this.getTrack();
		if(movementPoints < 5 && track[racePos] == '~' || track[racePos] == '.') {
			movementPoints++;
		}
		
			while(racePos == 0 && racePos < track.length && movementPoints > 0) {

				if(track[racePos] == '#' && movementPoints >= 3) {
					movementPoints -= 3;
					incrementPosition();
				}
				else if(track[racePos] == '|' && movementPoints >= 1) {
					movementPoints -= 1;
					incrementPosition();

				}
				else if (track[racePos] == 'O' && movementPoints >= 2) {
					movementPoints -= 2;
					incrementPosition();
				}
				else if(track[racePos] == '~') {
					incrementPosition();
				}
				else if(track[racePos] == '.') {
					incrementPosition();
				}
				else {
					break;
				}
				racePos = this.getPosition();
			}
			while(racePos != 0 && racePos < track.length-1 && movementPoints > 0) {
				char pastTrack = track[racePos - 1];
				char currentTrack = track[racePos];
				if(pastTrack != currentTrack) {

					if(track[racePos] == '#' && movementPoints >= 3) {
						movementPoints -= 3;
						incrementPosition();
					}
					else if(track[racePos] == '|' && movementPoints >= 1) {
						movementPoints -= 1;
						incrementPosition();
					}
					else if (track[racePos] == 'O' && movementPoints >= 2) {
						movementPoints -= 2;
						incrementPosition();
					}
					if(track[racePos] == '~') {
						incrementPosition();
					}
					else if(track[racePos] == '.') {
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
	 * @return "Ostrich"
	 */
	public String getCreatureType() {
		return "Ostrich";
	}
}


