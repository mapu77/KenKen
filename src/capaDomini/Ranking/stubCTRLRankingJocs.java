package Ranking;

import java.util.*;

public class stubCTRLRankingJocs {
	public static void carregar(Ranking r, String p) {
		ArrayList<ArrayList<String>> i = new ArrayList<ArrayList<String>>();
		//a[identificador, dificultat - mida]
		ArrayList<String> a = new ArrayList<String>(
			    Arrays.asList("123", "4x4"));
		i.add(a);
		a = new ArrayList<String>(
			    Arrays.asList("234", "5x5"));
		i.add(a);
		a = new ArrayList<String>(
			    Arrays.asList("345", "6x6"));
		i.add(a);
		a = new ArrayList<String>(
			    Arrays.asList("456", "3x3"));
		i.add(a);
		r.Info = i;
	}
}
