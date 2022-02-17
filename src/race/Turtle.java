package race;

import java.util.Random;

public class Turtle extends Creature {
	private int movementPoints;

	public Turtle(String name, char[] track) {
		super(name, 2, track);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		Random rand = new Random();
		movementPoints = rand.nextInt(2)+1;
		int racePos = this.getPosition();
		char[] track = this.getTrack();
		char currentTrack = track[racePos];
		char pastTrack = track[racePos - 1];
		if(racePos == 0) {
			while(movementPoints > 0 && racePos < track.length) {
				{
					if(track[racePos] == 'O') {
					}
					else if(track[racePos] != '0' && movementPoints >= 1) {
						movementPoints -= 1;

					}
				}
				incrementPosition();
			}
		}
		else {
			while(movementPoints > 0 && racePos < track.length) {
				if(pastTrack != currentTrack) {
					if(track[racePos] == 'O') {
					}
					else if(track[racePos] != '0' && movementPoints >= 1) {
						movementPoints -= 1;

					}
				}
				incrementPosition();
			}
		}
	}

	@Override
	public String getCreatureType() {
		return "Turtle";
	}
}
