package Ranking;

import java.util.*;

public class stubCTRLRankingUsuaris {
	public static void carregar(Ranking r, String p) {
		ArrayList<ArrayList<String>> i = new ArrayList<ArrayList<String>>();
		//a[usuari, password]
		ArrayList<String> a = new ArrayList<String>(
			    Arrays.asList("mapu77", "passmapu"));
		i.add(a);
		a = new ArrayList<String>(
			    Arrays.asList("ocapo", "passocapo"));
		i.add(a);
		a = new ArrayList<String>(
			    Arrays.asList("teru", "passteru"));
		i.add(a);
		a = new ArrayList<String>(
			    Arrays.asList("jpont", "passjpont"));
		i.add(a);
		r.Info = i;
	}
}
