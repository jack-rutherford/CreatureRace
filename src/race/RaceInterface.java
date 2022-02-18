package race;

public interface RaceInterface {
	/**
	 * Returns a char array representing the racetrack
	 * @return char[]
	 */
	char[] getRacetrack();
	
	/**
	 * Returns the name of the racer at the given index
	 * @param racerIndex
	 * @return String
	 */
	
	String getRacerName(int racerIndex);
	
	/**
	 * Returns the position of the racer at the given index
	 * @param racerIndex
	 * @return int
	 */
	int getRacerPosition(int racerIndex);
	
	/**
	 * Returns whether or not the racer at the given index is a winner
	 * @param racerIndex
	 * @return boolean
	 */
	boolean getRacerIsWinner(int racerIndex);
	
	/**
	 * Creates the racetrack of the given length and instantiates ‘numRacers’ number of racers
	 * @param length
	 * @param numRacers
	 */
	void createRace(int length, int numRacers);
	
	/**
	 * Causes each racer to take one turn, moving a number of spaces based on their
	 * movement speed and the terrain
	 */
	void advanceOneTurn();
}
