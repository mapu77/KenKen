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
		try {
			return new RankingPerTipus(d, nEntrades);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return null;
	}
	
	public RankingPersonal generarRankingPersonal (String username) throws Exception {
		return new RankingPersonal(username);
	}
}
