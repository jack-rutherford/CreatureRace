package race;

import java.util.Random;

public class Race implements RaceInterface {

	private char[] racetrack;
	private static char[] terrain;
	private Random rand;
	
	
	public Race(){
		terrain = new char[] {'.', '#', 'O', '~', '|'};
		rand = new Random();
	}
	
	@Override
	public char[] getRacetrack() {
		return racetrack;
	}

	@Override
	public String getRacerName(int racerIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getRacerPosition(int racerIndex) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean getRacerIsWinner(int racerIndex) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void createRace(int length, int numRacers) {
		racetrack = new char[length];
		for(int i = 0; i < racetrack.length; i++) {
			int num1 = rand.nextInt(4);
			if(racetrack[i] == racetrack.length-1) {
				racetrack[i] = terrain[4]; //finish line
			}
			else {
				racetrack[i] = terrain[num1];
			}
		}
		
	}

	@Override
	public void advanceOneTurn() {
		// TODO Auto-generated method stub
		
	}

}
