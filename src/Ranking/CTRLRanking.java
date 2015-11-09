package Ranking;

import java.io.*;
import java.util.*;
import capaPersistencia.*;

public class CTRLRanking {
		
	public static void carregar(Ranking r, String arxiu) throws IOException {
		r.Info = CtrlPersistencia.loadTable("./data/" + arxiu + ".txt");
	}
}
