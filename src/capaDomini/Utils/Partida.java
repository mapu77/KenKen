package capaDomini.Utils;

import java.util.Scanner;

import capaDomini.Algoritmes.KenKenGenerator;
import capaDomini.Dificultat.Dificultat;
import excepciones.*;

public class Partida {
	private String usuari;
	private String idJoc; 		//Identificador del tauler
	private String D;			//Dificultat tauler
	private int pistes = 0;
	private long time;
	private CtrlJoc CJ;
	private TaulerKenKen K;
        private TaulerKenKen p2;
	private static Scanner sn;
	
        /* Constructor partida partida guardada */
	public Partida() {
		
	}
	
	/* Creador partida amb KenKen aleatori */
	public Partida(String u, String d) {
		CJ = new CtrlJoc();
		this.D = d;
		this.usuari = u;
		this.time = 0;
		int n = Dificultat.toInt(d);
		K = new KenKenGenerator().generateRandomly(n);
                p2 = new KenKenGenerator().solution();
		this.idJoc = String.valueOf(CJ.guardarTauler(K));
	}
	
	/* Constructor partida seleccionada */
	public Partida(String u, String d, String id) {
		CJ = new CtrlJoc();
		this.idJoc = id;
		this.usuari = u;
		this.D = d;
		this.time = 0;
		K = CJ.llegirTauler(id,d);
                p2 = new KenKenGenerator().solution();
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
	
	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
	}
	
	public TaulerKenKen getK() {
		return K;
	}
        
        public TaulerKenKen getSol() {
		return p2;
	}

	public void setK(TaulerKenKen k) {
		K = k;
	}
}
