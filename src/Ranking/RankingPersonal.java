package Ranking;

import java.util.*;
import Dificultat.*;

public class RankingPersonal extends Ranking {
	private String usuari;
	private int jocsResolts;
	private double avgPistes;
	private Map<String,Double> bestTime;
	
	private void ompleatributs() {
		for (int i=0; i<Info.size(); ++i) {
			ArrayList<String> s = Info.get(i);
			String user;
			user = new String(s.get(0));
			String dif = (Dificultat.esValida(s.get(2))) ? s.get(2) : null;
			double time = Double.parseDouble(s.get(3));
			int pistes = Integer.parseInt(s.get(4));
			if (usuari.equals(user)) {
				++jocsResolts;
				avgPistes += pistes;
				if (dif != null) {
					if (bestTime.containsKey(dif) && bestTime.get(dif) > time) 
						bestTime.put(dif,time);						
					else bestTime.put(dif,time);
				}
			}
		}
		avgPistes = avgPistes/(double)jocsResolts;
	}
	
	public RankingPersonal(String usuari) {
		if (CtrlUser.getUser(usuari) != null) {
			this.usuari = usuari;
			super.Info = CTRLRanking.carregar();
			this.avgPistes = this.jocsResolts = 0;
			this.ompleatributs();
		}
		else {
			System.err.println("No existeix l'usuari");
		}
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
}
