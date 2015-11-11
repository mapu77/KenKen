package capaDomini.Utils;

public class CtrlPartida {
	
	private Partida P;
	private long initialTime;
	private long currentTime = 0;
	
	/* Guarda a la BD una partida acabada */
	public void save() {

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
		
	public long getcurrentTime() {
		currentTime = System.nanoTime() - initialTime;
		return currentTime;
	}
	
	public CtrlPartida() {
		
	}
}
