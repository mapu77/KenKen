package Ranking;

import java.io.*;
import java.util.*;

public class CTRLRanking {
	private ArrayList<ArrayList<String>> Info;
	
	private void simularlectura() throws IOException {
		FileReader f = new FileReader("/data/Partides.txt");
		BufferedReader bf = new BufferedReader(f);
		String s;
		int i=0;
		while ((s=bf.readLine()) != null) {
			Info.get(i).add(s);
			++i;
		}
		bf.close();
	}
	
	public static ArrayList<String> carregar() {
		
		return null;	
	}
}
