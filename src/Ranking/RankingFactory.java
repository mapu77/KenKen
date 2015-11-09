package Ranking;

public class RankingFactory {
	
	public RankingGeneral generarRankGen() throws Exception {	
		return new RankingGeneral();
	}
	
	public RankingPerTipus generarRankTipus (String d, int nEntrades) throws Exception {
		return new RankingPerTipus(d, nEntrades);
	}
	
	public RankingPersonal generarRankPersonal (String username) throws Exception {
		return new RankingPersonal(username);
	}
}
