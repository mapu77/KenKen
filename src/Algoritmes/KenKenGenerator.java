package Algoritmes;

import java.util.*;
import capaDomini.*;

public class KenKenGenerator {
	
	private Vector<Boolean> used; //llistat del 0 a n+1 de valors usats
	private static TaulerKenKen K;
	private int n;
	Random random;
	private int X[] = {1,0,-1,0};
	private int Y[] = {0,1,0,-1};
	private static double probStop;
	
	public KenKenGenerator() {
		Random random = new Random();
	}
	
	/* Retorna si x és un nombre valid per la fila r */
	private static boolean checkFila(int fila, int x) {
		for (int col=0; col<K.getNCols(); ++col) {
			if (K.getCella(fila, col).getNumero() == x) return false;
		}
		return true;
	}
	
	/* Retorna si x és un nombre vàlid per la columna c */
	private static boolean checkCol(int col, int x) {
		for (int fila = 0; fila < K.getNFiles(); ++fila) {
			if (K.getCella(fila, col).getNumero() == x) return false;
		}
		return true;
	}
	
	private void backtrackingGenerateNumbers(int i, int j, int max) {
		if ((i+1)*(j+1) < max) {
			int rand = random.nextInt(n-1)+1; //genera nombre aleatori entre 1 i n
			for (int k=1; k<=n; ++k) {
				for (int ii=1; ii<=n; ++i) used.set(i, false);
				while (!used.get(rand)) rand = random.nextInt(n-1)+1;
				used.set(rand, true);
				K.setNumero(i, j, rand);
				if (checkFila(i,rand) && checkCol(j,rand)) {
					if (j==9) {
						j=0;
						++i;
					}
					else {
						++j;
					}
					backtrackingGenerateNumbers(i,j,max);
				}				
			}
		}
	}
	
	private void generateRegions() {
		int reg_count = 1;
		for (int i=0; i<K.getancho(); ++i) {
			for (int j=0; j<K.getalto(); ++j) {
				if (K.nRegio(i, j) == 0) { // no te regio
					Stack<Cella> s = new Stack<Cella>();
					Vector<Cella> vc = new Vector<Cella>();
					probStop = 0.3;
					vc.add(new Cella(i,j));
					s.push(new Cella(i,j));
					while (random.nextDouble() > probStop) { //No parem
						int rand = random.nextInt(3);
						int ii = s.peek().getX()+Y[rand];
						int jj = s.peek().getY()+X[rand];
						if (ii >= 0 && ii < K.getancho() && jj >= 0 && jj < K.getalto()){
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
		K = new TaulerKenKen(n);
		used = new Vector<Boolean> (n+1);
		for (int i=0; i<=used.size(); ++i) used.set(i, false);
		backtrackingGenerateNumbers(0,0,K.getNumCeldas());
		generateRegions();
		generateRegionSolution();
		return K;
	}
	
	public TaulerKenKen generateKenKenby() {
		return K;
	}
	
	public TaulerKenKen generateKenKen() {
		return K;
	}
	
}
