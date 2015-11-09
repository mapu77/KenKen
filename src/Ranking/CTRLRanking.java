package Ranking;

import java.io.*;
import capaPersistencia.*;

public class CTRLRanking {
		
	public static void carregar(Ranking r, String arxiu) {
		CtrlPersistencia.setSeparator(" ");
		try {
			r.Info = CtrlPersistencia.loadTable("./data/" + arxiu + ".txt");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
