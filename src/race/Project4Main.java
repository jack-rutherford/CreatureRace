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
		//result(race);
	}
	public static void result(char[] Race){
		
		
	}
}
