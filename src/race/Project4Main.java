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
		race.advanceOneTurn();

		Creature[] racersList = race.getRacers();
		for(int i = 0; i < racersList.length; i++) {
			Creature currentRacer = racersList[i];
			String str = String.valueOf(race.getRacetrack()); //turn racetrack array into a string
			int curPos = racersList[i].getPosition()*2;
			String str1 = str.replace("", " ").trim(); //put spaces between each character
			String finStr = str1.substring(0, curPos) + "<" + str1.substring(curPos, curPos+1) + ">"
					+ str1.substring(curPos+1); // put < > around final character index
			System.out.print("\n" + currentRacer.getCreatureType() + "\t(" + currentRacer.getName() + ")\t"
					+ (i+1) + "\t"); //Print the creature type, name, and index
			System.out.printf("%4s",finStr); 
		}

	}
}
