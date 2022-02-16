package race;

import java.util.Random;

public class Monkey extends Creature {
private int movementPoints ; 
	public Monkey(String name, char[] track) {
		super(name, 4, track);
	}

		@Override
		public void move(char[] racetrack, int movementPoints) {
			// TODO Auto-generated method stub
			Random rand = new Random();
			movementPoints = rand.nextInt(4)+1;
			char[] track = this.getTrack();
			while(movementPoints > 0 && racePos < track.length) {
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
				else if (track[racePos] == '0') {
					movementPoints = 0;
				}
		}
	}
}

