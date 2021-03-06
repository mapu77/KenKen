package capaDomini.Ranking;

import capaDomini.Usuari.CtrlUser;
import capaPersistencia.CtrlPersistencia;

public class RankingFactory {
	
	public RankingFactory() {
		CtrlPersistencia.setSeparator(" ");
		CtrlUser CU = new CtrlUser();
	}
	
	public RankingGeneral generarRankingGeneral() {
		return new RankingGeneral();
	}
	
	public RankingPerTipus generarRankingPerTipus (String d, int nEntrades) {
		return new RankingPerTipus(d, nEntrades);
	}
	
	public RankingPersonal generarRankingPersonal(String username) {
		return new RankingPersonal(username);
	}
}
