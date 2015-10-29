package Ranking;

public class RanquingFactory {
	
	public RankingGeneral generarRankGen() {
		return new RankingGeneral();
	}
	
	public RankingPerTipus generarRankTipus (Dificultat d, int nEntrades) {
		return new RankingPerTipus(d, nEntrades);
	}
	
	public RankingPersonal generarRankPersonal (String username) {
		return new RankingPersonal(username);
	}
}
