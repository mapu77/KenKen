package capaDomini;
//import java.util.*;

//per fer el typedef hi ha la opcio enum -> public enum tipoDificultad {trivial, facil, medio, dificil}

public abstract class Joc {
	private int n;
	private String dificultad;
	private String id;
	private Tauler tauler;
	
	//segurament no es necessaria ja que no serveix
	public Joc() {
		n = 0;
		dificultad = null;
		id = null;
	}
	
	public Joc(int mida, String dif, String idJoc) {
		n = mida;
		dificultad = dif;
		id = idJoc;
		//tauler = new Tauler[n][n]; --------------> millor nomes per sudoku i kenken, ja que hidato no te perque tenir un tauler quadrat
	}
	
	public Joc(int mida, String dif, String idJoc, Tauler t) {
		n = mida;
		dificultad = dif;
		id = idJoc;
		tauler = t;
	}
	
	public String getId() {
		return id;
	}
	
	public int getN() {
		return n;
	}
	
	public String getDificultad() {
		return dificultad;
	}
	
	public Tauler getTauler() {
		return tauler;
	}
}
