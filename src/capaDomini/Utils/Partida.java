package capaDomini.Utils;

import capaDomini.Algoritmes.KenKenGenerator;
import capaDomini.Dificultat.Dificultat;

public class Partida {
	private String usuari;
	private String idJoc; 		//Identificador del tauler
	private String D;	//Dificultat tauler
	private int pistes;
	private long initialTime;
	private long currentTime = 0;
	private TaulerKenKen K;
	private CtrlPartida CP;
	private CtrlJoc CJ;
	
	public Partida() {
		
	}
	
	/* Creador partda amb KenKen aleatori */
	public Partida(String u, String d) {
		CP = new CtrlPartida();
		CJ = new CtrlJoc();
		this.D = d;
		int n;
		n = Dificultat.toInt(d);
		K = new KenKenGenerator().generateRandomly(n);
	}
	
	public Partida(String u, String d, String id) {
		CP = new CtrlPartida();
		CJ = new CtrlJoc();
		this.D = d;
	}
	
	/* Guarda a la BD una partida acabada */
	private void save() {
		CP.save(this);
	}

	/* Guarda a la BD l'estat del KenKen */
	public void saveKenKen() {
	
	}
	
	public void play() {
		this.initialTime = System.nanoTime();
	}

	public void stop() {
		this.currentTime += System.nanoTime() - initialTime;
	}
	
	public void resume() {
		this.initialTime = System.nanoTime();
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
	
	public long getcurrentTime() {
		return System.nanoTime() - initialTime;
	}
}
