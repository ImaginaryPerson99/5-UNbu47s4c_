import java.util.ArrayList;

public class Match {
	
	private String matchUp, dayOfWeek, month, tournamentName; // move mapName to Rounds.java
	private int day, time;	
	private double pVersion;
	private ArrayList<Rounds> round = new ArrayList<Rounds>();
	
	public void addRound(Rounds r) {
		round.add(r);
	}

	public String getMatchUp() {
		return matchUp;
	}

	public double getpVersion() {
		return pVersion;
	}

	public void setpVersion(double pVersion) {
		this.pVersion = pVersion;
	}

	public void setMatchUp(String matchUp) {
		this.matchUp = matchUp;
	}

	public String getDayOfWeek() {
		return dayOfWeek;
	}

	public void setDayOfWeek(String dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public String getTournamentName() {
		return tournamentName;
	}

	public void setTournamentName(String tournamentName) {
		this.tournamentName = tournamentName;
	}

	public ArrayList<Rounds> getRound() {
		return round;
	}

	public void setRound(ArrayList<Rounds> round) {
		this.round = round;
	}
	
	public String toString() {
		return matchUp + " " + tournamentName;
	}
}
