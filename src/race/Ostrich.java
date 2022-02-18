package race;

import java.util.Random;

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
			if(racePos == 0) {
				while(movementPoints > 0 && racePos < track.length) {

					if(track[racePos] == '#' && movementPoints >= 3) {
						movementPoints -= 3;

					}
					else if(track[racePos] == '|' && movementPoints >= 1) {
						movementPoints -= 1;

					}
					else if (track[racePos] == 'O' && movementPoints >= 2) {
						movementPoints -= 2;
					}
					incrementPosition();
					racePos = this.getPosition();
				}
			}
			else {
				char pastTrack = track[racePos - 1];
				char currentTrack = track[racePos];
				while(movementPoints > 0 && racePos < track.length) {
					if(pastTrack != currentTrack) {

						if(track[racePos] == '#' && movementPoints >= 3) {
							movementPoints -= 3;

						}
						else if(track[racePos] == '|' && movementPoints >= 1) {
							movementPoints -= 1;

						}
						else if (track[racePos] == 'O' && movementPoints >= 2) {
							movementPoints -= 2;
						}
					}
					incrementPosition();
				}
			}
		}
	}

	@Override
	public String getCreatureType() {
		return "Ostrich";
	}
}


