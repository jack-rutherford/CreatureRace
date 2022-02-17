package race;

import java.util.Random;

public class Monkey extends Creature {
	private int movementPoints ; 
	public Monkey(String name, char[] track) {
		super(name, 4, track);
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		Random rand = new Random();
		movementPoints = rand.nextInt(4)+1;
		int racePos = this.getPosition();
		char[] track = this.getTrack();
		char pastTrack = track[racePos - 1];
		char currentTrack = track[racePos];
		while(movementPoints > 0 && racePos < track.length) {
			if(pastTrack != currentTrack) {
				if(track[racePos] == '#') {
				}
				else if(track[racePos] == '~' && movementPoints >= 2) {
					movementPoints -= 2;

				}
				else if(track[racePos] == '.' && movementPoints >= 1) {
					movementPoints -= 1;

				}
				else if(track[racePos] == '|' && movementPoints >= 1) {
					movementPoints -= 1;

				}
				else if (track[racePos] == 'O') {
					movementPoints = 0;
				}
			}
			incrementPosition();

		}

	}
}


