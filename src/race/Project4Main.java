package race;

import java.util.Scanner;

public class Project4Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("How many racers are there?");
		int racers;
		do 
		{
			System.out.println("Enter a number greater than 0");
			racers = scan.nextInt();
		}while(racers <= 0);
		System.out.println("How long is the race track");
		int track;
		do
		{
			System.out.println("Enter a number greater than 0");
			track = scan.nextInt();
		}while(track <= 0);

		Race race = new Race();
		race.createRace(track,racers);
		Creature[] racersList = race.getRacers();
		for(int i = 0; i < racersList.length; i++) {
			Creature creature = racersList[i];
			System.out.print("\n" + creature.getCreatureType() + "\t(" + creature.getName() + ")\t"
			+ i + "\t");
			System.out.print(creature.getTrack()); //temporary so we can see the track print
		}
		//race.advanceOneTurn();
		//result(race);
	}
	public static void result(char[] Race){
		
		

	}	
}		
