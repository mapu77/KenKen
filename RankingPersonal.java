package Ranking;

import java.util.*;

public class RankingPersonal extends Ranking {
	String usuari;
	int jocsResolts;
	double avgPistes;
	ArrayList<Date> bestTimes;
	
	public RankingPersonal(String usuari) {
		this.usuari = usuari;
		//crida al controlador
	}
	
	public void printUsuari() {
		System.out.println(usuari);
	}
	public String getUsuari() {
		return usuari;
	}
	public void setUsuari(String usuari) {
		this.usuari = usuari;
	}
	public void printjocsResolts() {
		System.out.println(jocsResolts);
	}
	public int getJocsResolts() {
		return jocsResolts;
	}
	
	public void setJocsResolts(int jocsResolts) {
		this.jocsResolts = jocsResolts;
	}
	
	public double getAvgPistes() {
		return avgPistes;
	}
	
	public void setAvgPistes(double avgPistes) {
		this.avgPistes = avgPistes;
	}
	
	public ArrayList<Date> getBestTimes() {
		return bestTimes;
	}
	
	public void setBestTimes(ArrayList<Date> bestTimes) {
		this.bestTimes = bestTimes;
	}
}
