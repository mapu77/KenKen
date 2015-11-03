package Ranking;

import java.io.*;
import java.util.*;
import persistencia.*;

public class CTRLRanking {
		
	public static void carregar(Ranking r, String arxiu) {
		r.Info = CtrlPersistencia.LoadTable("./../../data/" + arxiu + ".txt");
	}
}
