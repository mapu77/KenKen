package Algoritmes;

import java.util.*;
import capaDomini.*;

public class KenKenGenerator {
	
	private Vector<Boolean> used; //llistat del 0 a n+1 de valors usats
	private static TaulerKenKen K;
	private int n;
	private static boolean fi;
	private int X[] = {1,0,-1,0};
	private int Y[] = {0,1,0,-1};
	private static double probStop;
	
	public KenKenGenerator() {
	}
	
	/* Retorna si x és un nombre valid per la fila r */
	private static boolean checkFila(int fila, int x) {
		for (int col=0; col<K.getAncho(); ++col) {
			if (K.getCella(fila, col).getNumero() == x) return false;
		}
		return true;
	}
	
	/* Retorna si x és un nombre vàlid per la columna c */
	private static boolean checkCol(int col, int x) {
		for (int fila = 0; fila < K.getAlto(); ++fila) {
			if (K.getCella(fila, col).getNumero() == x) return false;
		}
		return true;
	}
	
	private void backtrackingGenerateNumbers(int i, int j, int max) {
		if ((i+1)*(j+1) == max) {
			fi = true;
		}
		else {
			int rand = new Random().nextInt(n)+1; //genera nombre aleatori entre 1 i n
			for (int k=1; k<=n && !fi; ++k) {
				for (int ii=1; ii<used.size(); ++ii) used.set(ii,false);
				while (used.get(rand)) rand = new Random().nextInt(n)+1;
				used.set(rand,true);
				if (checkFila(i,rand) && checkCol(j,rand)) {
					K.setNumero(i,j,rand);
					if (j==n) {
						backtrackingGenerateNumbers(i+1,0,max);
					}
					else {
						backtrackingGenerateNumbers(i,j+1,max);
					}
				}				
			}
			if (!fi) K.borra(i, j);
		}
	}
	
	private void generateRegions() {
		int reg_count = 1;
		for (int i=0; i<K.getAncho(); ++i) {
			for (int j=0; j<K.getAlto(); ++j) {
				if (K.nRegio(i, j) == 0) { // no te regio
					Stack<Cella> s = new Stack<Cella>();
					Vector<Cella> vc = new Vector<Cella>();
					probStop = 0.3;
					vc.add(new Cella(i,j));
					s.push(new Cella(i,j));
					while (new Random().nextDouble() > probStop) { //No parem
						int rand = new Random().nextInt(3);
						int ii = s.peek().getX()+Y[rand];
						int jj = s.peek().getY()+X[rand];
						if (ii >= 0 && ii < K.getAncho() && jj >= 0 && jj < K.getAlto()){
							if (!vc.contains(new Cella(ii,jj))) {
								vc.add(new Cella(ii,jj));
								s.push(new Cella(ii,jj));
							}
						}
						probStop += 0.1; 
					}
					RegioKenKen r = new RegioKenKen(vc.size(), vc, "+", 0, reg_count);
					++reg_count;
					K.afegeixRegio(r);
				}
					
			}
		}
	}
	
	public void generateRegionSolution() {
		
	}
	
	public TaulerKenKen generateRandomly(int size) {
		n = size;
		fi = false;
		K = new TaulerKenKen(n);
		used = new Vector<Boolean> ();
		for (int i=0; i<n+1; ++i) used.add(i,false);
		backtrackingGenerateNumbers(0,0,K.getNumCeldas());
		//generateRegions();
		//generateRegionSolution();
		return K;
	}
	
	public TaulerKenKen generateKenKenby() {
		return K;
	}
	
	public TaulerKenKen generateKenKen() {
		return K;
	}
	
}
