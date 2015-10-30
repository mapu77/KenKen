package Ranking;

import java.io.*;
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
			String user = new String(s.get(0));
			String dif = (Dificultat.esValida(s.get(2))) ? s.get(2) : null;
			double time = Double.parseDouble(s.get(3));
			int pistes = Integer.parseInt(s.get(4));
			if (usuari.equals(user)) {
				++jocsResolts;
				avgPistes += pistes;
				if (dif != null) {
					if (bestTime.containsKey(dif)) {
						if (bestTime.get(dif) > time) bestTime.put(dif,time);
					}
					else bestTime.put(dif,time);
				}
			}
		}
		avgPistes = avgPistes/(double)jocsResolts;
	}
	
	public RankingPersonal(String usuari) {
		System.out.println("Crida al CTRLUsuari per comprovar si l'usuari"
				+ " del qual volem realitzar la consulta, existeix");
		//if (CTRLUser.getUser(usuari) != null) {
			this.usuari = usuari;
			//Info = CTRLRanking.carregar();
			System.out.println("Crida al CTRLRanking per carregar les partides");
			System.out.println("Les carreguem localment");
			try {
				BufferedReader bf = new BufferedReader(new FileReader("/home/edu/Documentos/FIB/5qt_15-16/PROP/KenKen/data/Partides.txt"));
				String linia;
				while ((linia = bf.readLine()) != null) {
					ArrayList<String> s = new ArrayList<String>(Arrays.asList(linia.split(" ")));
					Info.add(s);
				}
				this.avgPistes = this.jocsResolts = 0;
				this.bestTime = new HashMap<String,Double>();
				this.ompleatributs();
				bf.close();
			} catch (IOException e) {
				System.err.println("Error: " + e);
			}
		//}
		/*else {
			System.err.println("No existeix l'usuari");
		}*/
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

	public Map<String,Double> getBestTime() {
		return bestTime;
	}
	
	public String getBestTime(String dif) {
		if (bestTime.get(dif) == null) return "-";
		return String.valueOf(bestTime.get(dif));
	}
}
