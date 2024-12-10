import java.util.ArrayList;

public class Rounds {
	
	private int team, UPAcq, UOAcq, fBuy, hBuy, eBuy, wEconDiff, wELODiff,
				wBetOdds, wMap;
	private double mapWinPct, atkWinPct, defWinPct, startELO, endELO;
	
	private int mapNum;
	
	private String mapName;
	
	private static RoundEvent RoundEventA, RoundEventB;
	
	public void addRoundEventA(RoundEvent r) {
		RoundEventA = r;
	}
	
	public void addRoundEventB(RoundEvent r) {
		RoundEventB = r;
	}
	
	public int getTeam() {
		return team;
	}

	public int getUPAAcq() {
		return UPAcq;
	}

	public int getUOAcq() {
		return UOAcq;
	}

	public int getfBuy() {
		return fBuy;
	}

	public int gethBuy() {
		return hBuy;
	}

	public int geteBuy() {
		return eBuy;
	}

	public double getMapWinPct() {
		return mapWinPct;
	}

	public double getAtkWinPct() {
		return atkWinPct;
	}

	public double getDefWinPct() {
		return defWinPct;
	}

	public void setTeam(int team) {
		this.team = team;
	}

	public void setUPAcq(int UPAcq) {
		this.UPAcq = UPAcq;
	}

	public void setUOAcq(int uOAcq) {
		UOAcq = uOAcq;
	}

	public void setfBuy(int fBuy) {
		this.fBuy = fBuy;
	}

	public void sethBuy(int hBuy) {
		this.hBuy = hBuy;
	}

	public void seteBuy(int eBuy) {
		this.eBuy = eBuy;
	}

	public void setMapWinPct(double mapWinPct) {
		this.mapWinPct = mapWinPct;
	}

	public void setAtkWinPct(double atkWinPct) {
		this.atkWinPct = atkWinPct;
	}

	public void setDefWinPct(double defWinPct) {
		this.defWinPct = defWinPct;
	}

	public void setwEconDiff(int wEconDiff) {
		this.wEconDiff = wEconDiff;
	}

	public void setwELODiff(int wELODiff) {
		this.wELODiff = wELODiff;
	}

	public void setwBetOdds(int wBetOdds) {
		this.wBetOdds = wBetOdds;
	}

	public void setwMap(int wMap) {
		this.wMap = wMap;
	}

	public void setStartELO(double startELO) {
		this.startELO = startELO;
	}

	public void setEndELO(double endELO) {
		this.endELO = endELO;
	}

	public int getwEconDiff() {
		return wEconDiff;
	}

	public int getwELODiff() {
		return wELODiff;
	}

	public int getwBetOdds() {
		return wBetOdds;
	}

	public int getwMap() {
		return wMap;
	}

	public double getStartELO() {
		return startELO;
	}

	public double getEndELO() {
		return endELO;
	}
	
	public void setMapName(String n) {
		mapName = n;
	}
	
	public void setMapNum(int n) {
		mapNum = n;
	}
}
