package race;

import java.util.Random;

/**
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
	public void move() {
		// TODO Auto-generated method stub
		Random rand = new Random();
		movementPoints = rand.nextInt(5)+1;
		int racePos = this.getPosition();
		char[] track = this.getTrack();
		if(movementPoints < 5 && track[racePos] == '~' || track[racePos] == '.') {
			movementPoints++;
		}
		int counter1 = 0;
		
			while(racePos == 0 && racePos < track.length && movementPoints > 0 && counter1 == 0) {

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
				racePos = this.getPosition();
				counter1++;
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
	public String getCreatureType() {
		return "Ostrich";
	}
}


