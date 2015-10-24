package Ranking;

import java.util.*;

public class RankingPersonal extends Ranking {
	private String usuari;
	private int jocsResolts;
	private double avgPistes;
	private ArrayList<Date> bestTimes;
	private ArrayList<Dificultat> dificultats;
	
	public RankingPersonal(String usuari) {
		this.usuari = usuari;
		super.Info = CTRLRanking.carregar();
		this.setResolts();
		this.setPistes();
	}
	
	public String getUsuari() {
		return usuari;
	}
	
	public void setUsuari(String usuari) {
		this.usuari = usuari;
	}
		
	public int getResolts() {
		return jocsResolts;
	}
	
	public void setResolts() {
	}
	
	public double getPistes() {
		return avgPistes;
	}
	
	public void setPistes() {
		
	}
	
	public ArrayList<Date> getBestTimes() {
		return bestTimes;
	}
	
	public void setBestTimes(ArrayList<Date> bestTimes) {
		this.bestTimes = bestTimes;
	}

	public ArrayList<Dificultat> getDificultats() {
		return dificultats;
	}

	public void setDificultats(ArrayList<Dificultat> dificultats) {
		this.dificultats = dificultats;
	}
}
