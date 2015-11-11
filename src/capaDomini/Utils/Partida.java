package capaDomini.Utils;

import capaDomini.Algoritmes.KenKenGenerator;
import capaDomini.Dificultat.Dificultat;

public class Partida {
	private String usuari;
	private String idJoc; 		//Identificador del tauler
	private String D;			//Dificultat tauler
	private int pistes = 0;
	private CtrlJoc CJ;
	private TaulerKenKen K;
	
	public Partida() {
		
	}
	
	/* Creador partida amb KenKen aleatori */
	public Partida(String u, String d) {
		CJ = new CtrlJoc();
		this.D = d;
		int n = Dificultat.toInt(d);
		K = new KenKenGenerator().generateRandomly(n);
	}
	
	public Partida(String u, String d, String id, boolean saved) {
		CJ = new CtrlJoc();
		this.D = d;
		if (!saved) {
			K = CJ.llegeixTauler(id,d);
		}
		else {
			
		}
	}
	
	
	public String getUsuari() {
		return usuari;
	}

	public void setUsuari(String usuari) {
		this.usuari = usuari;
	}

	public String getIdJoc() {
		return idJoc;
	}

	public void setIdJoc(String idJoc) {
		this.idJoc = idJoc;
	}

	public String getD() {
		return D;
	}

	public void setD(String d) {
		D = d;
	}

	public int getPistes() {
		return pistes;
	}

	public void setPistes(int pistes) {
		this.pistes = pistes;
	}
	
	public TaulerKenKen getK() {
		return K;
	}

	public void setK(TaulerKenKen k) {
		K = k;
	}
}
