package Ranking;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

import Dificultat.Dificultat;

public class RankingPerTipus extends Ranking {
	private int nEntrades; //nombre d'entrades a mostrar
	private ArrayList<Tupla> tempsJugador; //jugador, temps
	
 class Tupla{
	private String user;
	private Double temps;
	
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public Double getTemps() {
		return temps;
	}
	public void setTemps(Double temps) {
		this.temps = temps;
	}
}
	
	public RankingPerTipus (String d, int nEntrades){
		this.tempsJugador = new ArrayList<Tupla>();
		this.nEntrades=nEntrades;
		if(Dificultat.esValida(d)){
		stubCTRLRanking.carregar(this, "Partides");
			for (int j=0; j<Info.size(); j++){
			ArrayList<String> s = Info.get(j);
				if (s.get(2).equals(d)){
						String user = new String(s.get(0));
						double time = Double.parseDouble(s.get(3));
						Tupla aux = new Tupla();
						aux.setTemps(time);
						aux.setUser(user);
						this.tempsJugador.add(aux);
				}
			}
		
		}
		else{
			System.err.println("No existeix la dificultat");
		}
	}
	
	public void setnEntrades(int nEntrades) {
		this.nEntrades = nEntrades;
	}
	
	public int getnEntrades() {
		return nEntrades;
	}

	public ArrayList<Tupla> getTempsJugador() {
		return tempsJugador;
	}
	
	
		
}
