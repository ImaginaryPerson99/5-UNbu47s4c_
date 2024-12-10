import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Data {
	
	/*
	 * Match.java is the "series" of either BO3 or BO5 game, it takes basic data
	 * like the match-up, map name, day of week, month, tournamentName...
	 * Rounds.java is an individual map's data
	 * RoundEvent.java is the list of rounds' data of a map
	 */
	
	static Match match;
	private static ArrayList<Match> arrMatch = new ArrayList<Match>();
	private static ArrayList<Integer> arr = new ArrayList<Integer>();
	private static Scanner file;
	private static String[] line;
	
	private static int counter;
	
	public static void main(String[] args) throws FileNotFoundException {	
		file = new Scanner(new File("VCT Data.csv"));
		int temp = 10;
		
		while(file.hasNextLine()) {
			counter=0;
			arr = new ArrayList<Integer>();
			
			for(int i = 0; i < temp; i++) {
				setMap(file);
				counter++;
				
				if(Character.isDigit(line[0].charAt(0))) {
					temp = Integer.parseInt(line[1].substring(1));
				}
			}			
			arrMatch.add(match);
			
			for(int i = 0; i < 7; i++) {
				if(file.hasNextLine()) {
					file.nextLine();
				}
			}		
		}
	}

	private static void setMap(Scanner file) {
				
		// handles first line
		String[] temp = file.nextLine().trim().split(",");
		line = temp;
		Rounds roundA = new Rounds();
		Rounds roundB = new Rounds();
		RoundEvent roundEventA = new RoundEvent();
		RoundEvent roundEventB = new RoundEvent();
		
		if(Character.isDigit(temp[0].charAt(0))) {
			int mapNum = Integer.parseInt(temp[1].substring(1));
			
			if(mapNum == 2) {
				arr.add(Integer.parseInt(temp[2]));
				arr.add(Integer.parseInt(temp[3].substring(0, temp[3].length()-1)));
			}
			else if(mapNum == 3) {
				arr.add(Integer.parseInt(temp[2]));
				arr.add(Integer.parseInt(temp[3]));
				arr.add(Integer.parseInt(temp[4].substring(0, temp[4].length()-1)));
			}
			else if(mapNum == 4) {
				arr.add(Integer.parseInt(temp[2]));
				arr.add(Integer.parseInt(temp[3]));
				arr.add(Integer.parseInt(temp[4]));
				arr.add(Integer.parseInt(temp[5].substring(0, temp[5].length()-1)));
			}
			else if(mapNum == 5) {
				arr.add(Integer.parseInt(temp[2]));
				arr.add(Integer.parseInt(temp[3]));
				arr.add(Integer.parseInt(temp[4]));
				arr.add(Integer.parseInt(temp[5]));
				arr.add(Integer.parseInt(temp[6].substring(0, temp[6].length()-1)));
			}
			
			match = new Match();
			
			String[] temp3 = temp[0].trim().split("[0-9]+. ");
			String[] temp2 = temp3[1].trim().split(" \\| ");
			
			match.setMatchUp(temp2[0]);
			roundA.setMapNum(Integer.parseInt(""+temp2[1].charAt(temp2[1].length()-1)));
			roundA.setMapName(temp2[2]);
			roundA.setMapNum(Integer.parseInt(""+temp2[1].charAt(temp2[1].length()-1)));
			roundB.setMapName(temp2[2]);
		}else {
			String[] temp2 = temp[0].trim().split(" \\| ");
			roundA.setMapNum(Integer.parseInt(""+temp2[1].charAt(temp2[1].length()-1)));
			roundA.setMapName(temp2[2]);
			roundA.setMapNum(Integer.parseInt(""+temp2[1].charAt(temp2[1].length()-1)));
			roundB.setMapName(temp2[2]);
		}
		
		

		
		// handles second line
		temp = file.nextLine().trim().split(",");
		
		match.setDayOfWeek(temp[0].substring(0));
		temp = temp[1].split(" ");
		
		match.setMonth(temp[1]);		
		match.setDay(Integer.parseInt(temp[2].substring(0, temp[2].length()-2)));
		
		if(temp[3].equals("12:00") && temp[4].equals("AM")) {
			match.setTime(0000);
		}else {
			if(temp[4].equals("AM")) {
				match.setTime(Integer.parseInt(temp[3].replaceAll(":", "")));
			}else {
				match.setTime(1200 + Integer.parseInt(temp[3].replaceAll(":", "")));
			}
		}
		
		// handles third line
		temp = file.nextLine().trim().split(","); 		
		double pVersion = Double.parseDouble(temp[0].replaceAll("Patch ", ""));
		match.setpVersion(pVersion);
		
		// handles fourth line
		temp = file.nextLine().trim().split(","); 
		match.setTournamentName(temp[0]);
		
		// fifth line (nothing)
		file.nextLine();
		
		// sixth line
		temp = file.nextLine().trim().split(",");
		
		roundA.sethBuy(Integer.parseInt(temp[3]));
		roundB.sethBuy(Integer.parseInt(temp[4]));
			
		// seventh line
		temp = file.nextLine().trim().split(",");
		roundA.setfBuy(Integer.parseInt(temp[3]));
		roundB.setfBuy(Integer.parseInt(temp[4]));
		
		// eighth line
		temp = file.nextLine().trim().split(",");
		roundA.seteBuy(Integer.parseInt(temp[3]));
		roundB.seteBuy(Integer.parseInt(temp[4]));
		
		// ninth line
		temp = file.nextLine().trim().split(",");
		roundA.setUPAcq(Integer.parseInt(temp[3]));
		
		ArrayList<Integer> roundUPAcq1 = new ArrayList<Integer>();
		
		for(int i = 0; i < Math.min(arr.get(counter)-1, 23); i++) {
			roundUPAcq1.add(Integer.parseInt(temp[6+i]));
		}
		roundEventA.setRoundUPAcq(roundUPAcq1);
		
		// tenth line
		temp = file.nextLine().trim().split(",");
		roundB.setUPAcq(Integer.parseInt(temp[4])); 
		
		ArrayList<Integer> roundUPAcq2 = new ArrayList<Integer>();
		
		for(int i = 0; i < Math.min(arr.get(counter)-1, 23); i++) {
			roundUPAcq2.add(Integer.parseInt(temp[6+i]));
		}
		roundEventA.setRoundUPAcq(roundUPAcq2);
		
		// eleventh line
		temp = file.nextLine().trim().split(",");
		roundA.setUOAcq(Integer.parseInt(temp[3]));
	
		ArrayList<Integer> roundUOAcq1 = new ArrayList<Integer>();
		
		for(int i = 0; i < Math.min(arr.get(counter)-1, 23); i++) {
			roundUOAcq1.add(Integer.parseInt(temp[6+i]));
		}
		roundEventB.setRoundUOAcq(roundUOAcq1);
		
		// twelfth line
		temp = file.nextLine().trim().split(",");
		roundB.setUOAcq(Integer.parseInt(temp[4]));

		ArrayList<Integer> roundUOAcq2 = new ArrayList<Integer>();
		
		for(int i = 0; i < Math.min(arr.get(counter)-1, 23); i++) {
			roundUOAcq2.add(Integer.parseInt(temp[6+i]));
		}
		roundEventB.setRoundUOAcq(roundUOAcq2);
		
		// thirteenth
		temp = file.nextLine().trim().split(",");
		roundA.setMapWinPct(Double.parseDouble(temp[3].substring(0, temp[3].length()-1)));
		roundB.setMapWinPct(Double.parseDouble(temp[4].substring(0, temp[4].length()-1)));
		
		// fourteenth
		temp = file.nextLine().trim().split(",");
		roundA.setAtkWinPct(Double.parseDouble(temp[3].substring(0, temp[3].length()-1)));
		roundB.setAtkWinPct(Double.parseDouble(temp[4].substring(0, temp[4].length()-1)));

		// fifteenth
		temp = file.nextLine().trim().split(",");
		roundA.setDefWinPct(Double.parseDouble(temp[3].substring(0, temp[3].length()-1)));
		roundB.setDefWinPct(Double.parseDouble(temp[4].substring(0, temp[4].length()-1)));

		// sixteenth (nothing)
		file.nextLine();

		// seventeenth (nothing)
		file.nextLine();

		// eighteenth (nothing)
		file.nextLine();

		// nineteenth (nothing)
		file.nextLine();

		// 20
		temp = file.nextLine().trim().split(",");
		if(temp[2].equals("A")) {
			roundA.setwMap(1);
			roundB.setwMap(0);
		}else{
			roundA.setwMap(0);
			roundB.setwMap(1);
		}
		
		// 21 (nothing)
		file.nextLine();

		// 22
		temp = file.nextLine().trim().split(",");
	
		ArrayList<Integer> roundnumAU1 = new ArrayList<Integer>();
		
		for(int i = 0; i < arr.get(counter); i++) {
			roundnumAU1.add(Integer.parseInt(temp[6+i]));
		}
		roundEventA.setRoundnumAU(roundnumAU1);
		
		// 23
		temp = file.nextLine().trim().split(",");
		
		ArrayList<Integer> roundnumAU2 = new ArrayList<Integer>();
		
		for(int i = 0; i < arr.get(counter); i++) {
			roundnumAU2.add(Integer.parseInt(temp[6+i]));
		}
		roundEventB.setRoundnumAU(roundnumAU2);

		// 24
		temp = file.nextLine().trim().split(",");

		ArrayList<Double> roundavgUPA1 = new ArrayList<Double>();
		
		for(int i = 0; i < arr.get(counter); i++) {
			roundavgUPA1.add(Double.parseDouble(temp[6+i]));
		}
		roundEventA.setRoundavgUPA(roundavgUPA1);
		
		// 25
		temp = file.nextLine().trim().split(",");
		
		ArrayList<Double> roundavgUPA2 = new ArrayList<Double>();
		
		for(int i = 0; i < arr.get(counter); i++) {
			roundavgUPA2.add(Double.parseDouble(temp[6+i]));
		}
		roundEventB.setRoundavgUPA(roundavgUPA2);
		
		// 26
		temp = file.nextLine().trim().split(",");

		ArrayList<Integer> roundteamEV1 = new ArrayList<Integer>();
		
		for(int i = 0; i < arr.get(counter); i++) {
			roundteamEV1.add(Integer.parseInt(temp[6+i]));
		}
		roundEventA.setRoundteamEV(roundteamEV1);
		
		// 27
		temp = file.nextLine().trim().split(",");

		ArrayList<Integer> roundteamEV2 = new ArrayList<Integer>();
		
		for(int i = 0; i < arr.get(counter); i++) {
			roundteamEV2.add(Integer.parseInt(temp[6+i]));
		}
		roundEventB.setRoundteamEV(roundteamEV2);
		
		// 28
		temp = file.nextLine().trim().split(",");

		ArrayList<Integer> wRound1 = new ArrayList<Integer>();
		ArrayList<Integer> wRound2 = new ArrayList<Integer>();

		for(int i = 0; i < arr.get(counter); i++) {
			if(temp[6+i].equals("A")) {
				wRound1.add(1);
				wRound2.add(0);
			}else{
				wRound1.add(0);
				wRound2.add(1);
			}
		}
		roundEventA.setwRound(wRound1);
		roundEventB.setwRound(wRound2);

		// summary add		
		roundA.addRoundEventA(roundEventA);
		roundB.addRoundEventB(roundEventB);
		
		match.addRound(roundA);
		match.addRound(roundB);
		
		arrMatch.add(match);

		// 29 (nothing)
		file.nextLine();

		// 30 (nothing)
		file.nextLine();

		// 31 (nothing)
		file.nextLine();

		// 32 (nothing)
		file.nextLine();

		// 33 (nothing)
		file.nextLine();
		
		
	}

}
