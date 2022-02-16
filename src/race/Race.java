package race;

import java.util.Random;

public class Race implements RaceInterface {

	private char[] racetrack;
	private static char[] terrain;
	private Random rand;
	private Creature[] racers;


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
		return "";
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
			if(i == racetrack.length-1) {
				racetrack[i] = terrain[4]; //finish line
			}
			else {
				racetrack[i] = terrain[num1];
			}
		}
		System.out.println(racetrack);
		createRacers(numRacers);

	}

	public void createRacers(int numRacers) {
		racers = new Creature[numRacers];
		for(int i = 0; i < racers.length; i++) {
			int num1 = rand.nextInt(3);
			if(num1 == 0) {
				racers[i] = new Monkey("Name", racetrack);
			}
			else if(num1 == 1) {
				racers[i] = new Ostrich("Name", racetrack);
			}
			else {
				racers[i] = new Turtle("Name", racetrack);
			}
		}
	}

	@Override
	public void advanceOneTurn() {
		for(int i = 0; i < racers.length; i++) {
			Creature currentRacer = racers[i];
			int movePoints = currentRacer.randomMovementPoints(currentRacer.getMaximumSpeed());
			
			while(!currentRacer.isWinner()) {
				currentRacer.move(racetrack);;
				System.out.println(currentRacer.racePos);
			}
		}
	}

}
