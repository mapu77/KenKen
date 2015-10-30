package Ranking;

public class RankingFactory {
	
	public RankingGeneral generarRankGen() {
		RankingGeneral G = new RankingGeneral();
		return G;
	}
	
	public RankingPerTipus generarRankTipus (String d, int nEntrades) {
		return new RankingPerTipus(d, nEntrades);
	}
	
	public RankingPersonal generarRankPersonal (String username) {
		return new RankingPersonal(username);
	}
}
