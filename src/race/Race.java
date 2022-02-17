package race;

import java.util.Random;

public class Race implements RaceInterface {

	private char[] racetrack;
	private static char[] terrain;
	private Random rand;
	private Creature[] racers;
	private String[] names;


	public Race(){
		terrain = new char[] {'.', '#', 'O', '~', '|'};
		rand = new Random();
		names = new String[] {"Charles", "Sophia", "Audrey", "Joseph", "Brendan", "Andrew", "Suzanne", "Natalie", "Addison"};
	}

	@Override
	public char[] getRacetrack() {
		return racetrack;
	}
	
	public Creature[] getRacers() {
		return racers;
	}

	@Override
	public String getRacerName(int racerIndex) {
		return racers[racerIndex].getName();
	}

	@Override
	public int getRacerPosition(int racerIndex) {
		return racers[racerIndex].getPosition();
	}

	@Override
	public boolean getRacerIsWinner(int racerIndex) {
		return racers[racerIndex].isWinner();
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
		//System.out.println(racetrack);
		createRacers(numRacers, names);

	}

	public void createRacers(int numRacers, String[] name) {
		racers = new Creature[numRacers];
		for(int i = 0; i < racers.length; i++) {
			int num1 = rand.nextInt(3);
			int num2 = rand.nextInt(name.length);
			if(num1 == 0) {
				racers[i] = new Monkey(name[num2], racetrack);
			}
			else if(num1 == 1) {
				racers[i] = new Ostrich(name[num2], racetrack);
			}
			else {
				racers[i] = new Turtle(name[num2], racetrack);
			}
		}
	}

	@Override
	public void advanceOneTurn() {
		for(int i = 0; i < racers.length-1; i++) {
			Creature currentRacer = racers[i];
			currentRacer.move();
		}
	}

}
