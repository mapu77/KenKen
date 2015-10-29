package Ranking;

public class RankingFactory {
	
	public RankingGeneral generarRankGen() {
		RankingGeneral G = new RankingGeneral();
		return G;
	}
	
/*	public RankingTipus generarRankTipus (String Dificultat) {
		return new RankingPerTipus
	}*/
	
	public RankingPersonal generarRankPersonal (String username) {
		return new RankingPersonal(username);
	}
}
