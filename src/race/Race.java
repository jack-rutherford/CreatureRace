package race;

import java.util.Random;

/**
 * 
 * This class deals with handling the instance of the racetrack, handling all the racers
 * creating the race and instantiating the racers, and advancing the race by one turn.
 * It has an interface called RaceInterface where it implements a bunch of methods.
 * 
 * @author jackrutherford
 * @author bereketbessie
 * @date 2/18/22
 * @class CSCI 235
 *
 */
public class Race implements RaceInterface {

	private char[] racetrack;
	private static char[] terrain;
	private Random rand;
	private Creature[] racers;
	private String[] names;

	/**
	 * Constructor for Race class
	 * instantiates the terrain array, Random field, and names array
	 */
	public Race(){
		terrain = new char[] {'.', '#', 'O', '~', '|'};
		rand = new Random();
		names = new String[] {"Charles", "Sophia", "Audrey", "Joseph", "Brendan", "Andrew", "Suzanne", "Natalie", "Addison",
				"Clementine", "Cristopher", "Johnathon"};
	}

	@Override
	/**
	 * Pre condition: the racetrack array has been instantiated
	 * Post condition: returning the racetrack array
	 * Returns a char array representing the racetrack
	 * @return char[]
	 */
	public char[] getRacetrack() {
		return racetrack;
	}

	/**
	 * Pre condition: the racers array has been instantiated and filled with racers
	 * of types of the subclasses of creature
	 * Post condition: returning the array of racers (type creature)
	 * Accessor method for the creatures array list, that
	 * holds all the racers
	 * @return Creature[]
	 */
	public Creature[] getRacers() {
		return racers;
	}

	@Override
	/**
	 * Pre condition: racerIndex >= 0 and racers has been created
	 * Post consition: returning the name of the racer at a given index
	 * Returns the name of the racer at the given index
	 * @param racerIndex
	 * @return String
	 */
	public String getRacerName(int racerIndex) {
		return racers[racerIndex].getName();
	}

	@Override
	/**
	 * Pre condition: racerIndex >= 0 and racers has been created
	 * Post consition: returning the position of the racer at a given index
	 * Returns the position of the racer at the given index
	 * @param racerIndex
	 * @return int
	 */
	public int getRacerPosition(int racerIndex) {
		return racers[racerIndex].getPosition();
	}

	@Override
	/**
	 * Pre condition: racerIndex >= 0 and racers has been created
	 * Post consition: returning a boolean if the racers index is at the end of the racetrack
	 * @param racerIndex
	 * @return boolean
	 */
	public boolean getRacerIsWinner(int racerIndex) {
		return racers[racerIndex].isWinner();
	}

	@Override
	/**
	 * Pre condition: length and numRacers are > 0
	 * Post condition: create a char[] race track that has a length of 'length'
	 * Creates the racetrack of the given length and instantiates ‘numRacers’ number of racers
	 * @param length
	 * @param numRacers
	 */
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
		createRacers(numRacers, names);

	}

	/**
     * Pre condition: the array of Strings is created with names in them and
     * numRacers > 0
	 * Post consition: instantiates an array of creatures of length 'numRacers'
	 * and fills it randomly with the creature subclasses
	 * Creates all of the racers with random names from a static list.
	 * Also instantiates the racers array with the length being
	 * @param numRacers
	 * @param name
	 */
	public void createRacers(int numRacers, String[] name) {
		racers = new Creature[numRacers];
		for(int i = 0; i < racers.length; i++) {
			int num1 = rand.nextInt(3);
			int num2 = rand.nextInt(name.length);
			if(num1 == 0) {
				racers[i] = new Monkey(name[num2], racetrack); //make an monkey with random name
			}
			else if(num1 == 1) {
				racers[i] = new Ostrich(name[num2], racetrack); //make an Ostrich with random name
			}
			else {
				racers[i] = new Turtle(name[num2], racetrack); //make an Turtle with random name
			}
		}
	}

	@Override
	/**
	 * Pre condition: the creature is not at the end of the racetrack
	 * Post condition: the creature moves
	 * Causes each racer to move one turn at a time, moving a number of spaces based on their
	 * movement speed and the terrain
	 */
	public void advanceOneTurn() { //this runs the entire game, but it works :)
		boolean trueFlag = false;
		while(!trueFlag) {
			for(int i = 0; i < racers.length; i++) {
				Creature currentRacer = racers[i];
				currentRacer.move();
				if(getRacerIsWinner(i)) {
					System.out.println("\n" + currentRacer.getCreatureType() + "  (" + currentRacer.getName() + ")  "
							+ (i+1) + "  Is the winner!");
					trueFlag = true;
				}
			}
		}

	}

}
