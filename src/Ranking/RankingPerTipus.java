package Ranking;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

import Dificultat.Dificultat;

public class RankingPerTipus extends Ranking {
	private String usuari;
	private int nEntrades; //nombre d'entrades a mostrar
	private Map<String,Double> tempsJugador; //jugador, temps
	
	private void Inicialitza(){
		this.tempsJugador = new HashMap<String,Double>();
		for (int i=0; i<Info.size(); ++i) {
			ArrayList<String> s = Info.get(i);
			String user = new String(s.get(0));
			String dif = (Dificultat.esValida(s.get(2))) ? s.get(2) : null;
			double time = Double.parseDouble(s.get(3));
			if (usuari.equals(user)) {
				if (user != null) {
					if (tempsJugador.containsKey(user)) {
						if (tempsJugador.get(user) > time) tempsJugador.put(user,time);
					}
					else tempsJugador.put(user,time);
				}
			}
		}
	}
	
	public RankingPerTipus (String d, int nEntrades){
		this.nEntrades=nEntrades;
		this.Inicialitza();
		for (int i=0; i<nEntrades; i++){
			Dificultat.getD();
		}
		
	}
	
	public void setnEntrades(int nEntrades) {
		this.nEntrades = nEntrades;
	}
	
	public int getnEntrades() {
		return nEntrades;
	}

	public Map<String, Double> getTempsJugador() {
		return tempsJugador;
	}

	public void setTempsJugador(Map<String, Double> tempsJugador) {
		this.tempsJugador = tempsJugador;
	}
	
	
		
}
