package Ranking;

import java.util.*;

public class RankingPersonal extends Ranking {
	private String usuari;
	private int jocsResolts;
	private double avgPistes;
	private Map<Dificultat,Double> bestTime;
	
	private void ompleatributs() {
		for (int i=0; i<super.Info.size(); ++i) {
			String[] s = super.Info.get(i).split("//s");
			if (s[0] == usuari) {
				++jocsResolts;
				avgPistes += Double.parseDouble(s[5]);
			}
		}
		avgPistes = avgPistes/(double)jocsResolts;
	}
	
	public RankingPersonal(String usuari) {
		this.usuari = usuari;
		super.Info = CTRLRanking.carregar();
		avgPistes = jocsResolts = 0;
		this.ompleatributs();
	}
	
	public String getUsuari() {
		return usuari;
	}
		
	public int getResolts() {
		return jocsResolts;
	}
	
	public double getPistes() {
		return avgPistes;
	}

	public Map<Dificultat,Double> getBestTime() {
		return bestTime;
	}

	public void setBestTime(Map<Dificultat,Double> bestTime) {
		this.bestTime = bestTime;
	}
}
