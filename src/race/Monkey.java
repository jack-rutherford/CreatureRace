package race;

import java.lang.reflect.Array;
import java.util.Random;

public class Monkey extends Creature {
	
	public Monkey(String name, char[] track) {
		super(name, 4, track);
	}

	public void move(char[] raceTrack){
		Random numb = new Random();
		movementPoints = movementPoints + numb.nextInt(2-1)+1;
		if(raceTrack[getRacerPostion()])
			for(int i= 0; i < raceTrack.length; i++);{

			}
	}
}

