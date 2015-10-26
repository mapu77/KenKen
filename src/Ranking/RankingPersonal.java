package Ranking;

import java.util.*;

public class RankingPersonal extends Ranking {
	private String usuari;
	private int jocsResolts;
	private double avgPistes;
	private ArrayList<Calendar> bestTimes;
	private ArrayList<Dificultat> dificultats;
	
	private void ompleatributs() {
		for (int i=0; i<super.Info.size(); ++i) {
			String[] s = super.Info.get(i).split("//s");
			if (s[0] == usuari) {
				++jocsResolts;
				avgPistes += Double.parseDouble(s[3]);
				
			}
		}
		avgPistes = avgPistes/(double)jocsResolts;
	}
	
	public RankingPersonal(String usuari) {
		this.usuari = usuari;
		super.Info = CTRLRanking.carregar();
		avgPistes = jocsResolts = 0;
		bestTimes = ArrayList<Date>
		this.ompleatributs();
	}
	
	public String getUsuari() {
		return usuari;
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
	
	public ArrayList<Date> getTimes() {
		return bestTimes;
	}
	
	public void setTimes() {
		
	}

	public ArrayList<Dificultat> getDificultats() {
		return dificultats;
	}

	public void setDificultats(ArrayList<Dificultat> dificultats) {
		this.dificultats = dificultats;
	}
}
