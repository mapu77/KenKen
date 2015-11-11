package capaDomini.Utils;

public class Partida {
	private String usuari;
	private String idJoc;
	private String Dificultat;
	private int pistes;
	private long tInit;
	private TaulerKenKen K;
	private CtrlPartida CP;
	
	public Partida(String u, String id) {
		this.tInit = System.nanoTime();
		CP = new CtrlPartida();
	}
	
	/* Guarda a la BD una partida acabada */
	public void save() {
		CP.save(this);
	}

	/* Guarda a la BD l'estat del KenKen */
	public void saveKenKen() {
	
	}
}
