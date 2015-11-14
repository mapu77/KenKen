package capaDomini.Utils;

import capaDomini.Algoritmes.KenKenGenerator;
import capaDomini.Dificultat.Dificultat;
import excepciones.*;

public class Partida {
	private String usuari;
	private String idJoc; 		//Identificador del tauler
	private String D;			//Dificultat tauler
	private int pistes = 0;
	private CtrlJoc CJ;
	private TaulerKenKen K;
	
	public Partida() {
		
	}
	
	/* Constructor partida partida guardada */
	public Partida(String u) {
		CJ = new CtrlJoc();
		this.usuari = u;
		K = CJ.loadPartidaGuardada(u);
		this.D = (String)(String.valueOf(K.getAlto())+"x"+String.valueOf(K.getAlto()));
	}
	
	/* Creador partida amb KenKen aleatori */
	public Partida(String u, String d) {
		CJ = new CtrlJoc();
		this.D = d;
		this.usuari = u;
		int n = Dificultat.toInt(d);
		K = new KenKenGenerator().generateRandomly(n);
	}
	
	/* Constructor partida seleccionada */
	public Partida(String u, String d, String id) {
		CJ = new CtrlJoc();
		this.usuari = u;
		this.D = d;
		K = CJ.llegirTauler(id,d);
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
