package Ranking;

import java.util.*;

public class stubCTRLRankingPartides {
	public static void carregar(Ranking r, String p) {
		ArrayList<ArrayList<String>> i = new ArrayList<ArrayList<String>>();
		//a[usuari, identificador_joc, dificultat - mida, temps, pistes]
		ArrayList<String> a = new ArrayList<String>(
			    Arrays.asList("mapu77", "123", "4x4", "8.983", "0"));
		i.add(a);
		a = new ArrayList<String>(
			    Arrays.asList("ocapo", "234", "5x5", "12.834", "0"));
		i.add(a);
		a = new ArrayList<String>(
			    Arrays.asList("teru", "345", "6x6", "11.762", "0"));
		i.add(a);
		a = new ArrayList<String>(
			    Arrays.asList("jpont", "234", "4x4", "0.073", "3"));
		i.add(a);
		r.Info = i;
	}
}
