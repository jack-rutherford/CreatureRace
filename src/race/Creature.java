package race;

public abstract class Creature {
	private int movementSpeed;
	private String name;
	private Race race;
	private char[] raceTrack;
	
	public void setRaceTrack(){
		raceTrack = race.getRacetrack();
				
	}
}
