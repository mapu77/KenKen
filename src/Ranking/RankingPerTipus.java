package Ranking;

import java.util.*;

import Dificultat.Dificultat;

public class RankingPerTipus extends Ranking{
	private int nEntrades; //Nombre d'entrades
	private static ArrayList<Tupla> tempsJugador; //ArrayList de Tupla<Jugador,Temps>

	
	public class CustomComparator implements Comparator<Tupla>{ //Comparador per ordenar de major a menor (per invertir l'ordre invertir el compare)
		public int compare(Tupla t1,Tupla t2){
			return t1.getTemps().compareTo(t2.getTemps());
		}
	}
	public RankingPerTipus (String d, int nEntrades) throws Exception{
		RankingPerTipus.tempsJugador = new ArrayList<Tupla>();
		this.nEntrades=nEntrades;
		if(Dificultat.esValida(d)){ //Validem que la dificultat introduida sigui valida
			CTRLRanking.carregar(this, "Partides");
			for (int j=0; j<Info.size(); j++){ //Per cada linia d'info
				ArrayList<String> s = Info.get(j);
				if (s.get(2).equals(d)){ //Selecciona la linia de la dificultat seleccionada per l'usuari
					String user = new String(s.get(0)); //Agafa l'user
					double time = Double.parseDouble(s.get(3)); //Agafa el temps
					Tupla aux = new Tupla();
					aux.setTemps(time);
					aux.setUser(user); //Ho coloquem a la tupla
					RankingPerTipus.tempsJugador.add(aux); //Ho afegim a ArrayList
				}
			Collections.sort(tempsJugador, new CustomComparator()); //Ordenem ArrayList
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
