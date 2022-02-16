package race;

public abstract class Creature {
	private int movementSpeed;
	private String name;
	private Race race;
	private char[] raceTrack;
	
	public Creature(String name, int movementSpeed, char[] track) {
		this.name = name;
		this.movementSpeed = movementSpeed;
		raceTrack = track;
	}
	
	public String getName(){
		return name;
	}
	
	public char[] getRaceTrack() {
		return raceTrack;
	}
	
	public int getMoveSpeed() {
		return movementSpeed;
	}
	
	public abstract void move(char[] track);
}
