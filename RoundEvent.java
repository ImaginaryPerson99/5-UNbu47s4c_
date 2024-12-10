import java.util.ArrayList;

public class RoundEvent {
	private ArrayList<Integer> roundUPAcq;
	private ArrayList<Integer> roundUOAcq;
	private ArrayList<Integer> roundnumAU;
	private ArrayList<Double> roundavgUPA;
	private ArrayList<Integer> roundteamEV;
	
	private ArrayList<Integer> wRound;

	public RoundEvent() {
		
	}
	
	public void setRoundUPAcq(ArrayList<Integer> roundUPAcq) {
		this.roundUPAcq = roundUPAcq;
	}

	public void setRoundUOAcq(ArrayList<Integer> roundUOAcq) {
		this.roundUOAcq = roundUOAcq;
	}

	public void setRoundnumAU(ArrayList<Integer> roundnumAU) {
		this.roundnumAU = roundnumAU;
	}

	public void setRoundavgUPA(ArrayList<Double> roundavgUPA) {
		this.roundavgUPA = roundavgUPA;
	}

	public void setRoundteamEV(ArrayList<Integer> roundteamEV) {
		this.roundteamEV = roundteamEV;
	}

	public void setwRound(ArrayList<Integer> wRound) {
		this.wRound = wRound;
	}
	
	public ArrayList<Integer> getRoundUPAcq(){
		return roundUPAcq;
	}
	
	public String toString() {
		return roundUPAcq.toString();
	}
}
