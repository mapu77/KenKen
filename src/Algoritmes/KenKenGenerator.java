package Algoritmes;

import java.util.*;
import capaDomini.*;

public class KenKenGenerator {
	
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

	private void backtrackingGenerateNumbers(int i, int j) {
		if (i == K.getAlto()) {
			fi = true;
		}
		else {
			Vector<Boolean> used = new Vector<Boolean>();
			for (int k=0; k<=K.getAncho();++k) used.add(k,false); //inicialitzacio used
			int rand = new Random().nextInt(n)+1;
			for (int ii=0; ii<K.getAncho() && !fi; ++ii) {
				while (used.get(rand)) { rand = new Random().nextInt(n)+1; }
				used.set(rand, true);
				if (checkFila(i,rand) && checkCol(j,rand)) {
					K.setNumero(i, j, rand);
					if (j+1 == K.getAncho()) {
						backtrackingGenerateNumbers(i+1,0);
					}
					else {
						backtrackingGenerateNumbers(i,j+1);
					}
				}
			}
			if (!fi) { K.getCella(i, j).borra(); }
		}
	}
	
	private boolean contains(Vector<Cella> v, Cella c) {
		for (int i=0; i<v.size(); ++i) {
			if (v.get(i).equals(c)) return true;
		}
		return false;
	}
	
	private void generateRegions() {
		int reg_count = 0;
		for (int i=0; i<K.getAncho(); ++i) {
			for (int j=0; j<K.getAlto(); ++j) {
				if (K.nRegio(i,j) == -1) { // no te regio
					Stack<Cella> s = new Stack<Cella>();
					Vector<Cella> vc = new Vector<Cella>();
					probStop = 0.1;
					Cella c = K.getCella(i,j);
					vc.add(c);
					s.push(c);
					while (new Random().nextDouble() > probStop) { //No parem
						int rand = new Random().nextInt(4);
						int ii = s.peek().getX()+Y[rand];
						int jj = s.peek().getY()+X[rand];
						if (ii >= 0 && ii < K.getAncho() && jj >= 0 && jj < K.getAlto() && K.nRegio(ii,jj) == -1){
							Cella aux = K.getCella(ii,jj);
							if (!contains(vc,aux)) {
								vc.add(aux);
								s.push(aux);
							}
						}
						probStop += 0.05; 
					}
					RegioKenKen r = new RegioKenKen(vc.size(), vc, "+", 0, reg_count);
					++reg_count;
					K.afegeixRegio(r);
					System.out.println(r.getId());
					for (int q=0; q<vc.size(); ++q) {
						System.out.println("(" + vc.get(q).getX() + "," + vc.get(q).getY() +")");

					}
				}
					
			}
		}
	}
	
	private static int calculaRegioSuma(RegioKenKen r) {
		int res = 0;
		for (int i=0; i<r.getNumCeldas(); ++i) {
			res += r.getCella(i).getNumero();
		}
		return res;
	}
	
	private static int calculaRegioResta(RegioKenKen r) {
		return Math.abs(r.getCella(0).getNumero() - r.getCella(1).getNumero());
	}
	
	private static int calculaRegioMult(RegioKenKen r) {
		int res = 1;
		for (int i=0; i<r.getNumCeldas(); ++i) {
			res *= r.getCella(i).getNumero();
		}
		return res;
	}
	
	private static int calculaRegioDiv(RegioKenKen r) {
		int op1 = r.getCella(0).getNumero()/r.getCella(1).getNumero();
		int op2 = r.getCella(1).getNumero()/r.getCella(0).getNumero();
		return (op1 >= 1) ? op1 : op2;
	}
	
	public void generateRegionSolution() {
		for (int i=0; i<K.getNRegio(); ++i) {
			RegioKenKen r = K.getRegio(i);
			switch (r.getNumCeldas()) {
			case 1:
				r.setOperation("+");
				r.setResult(r.getNumero(0));
				break;
			case 2:
				boolean resta = new Random().nextBoolean();
				if (resta){
					r.setOperation("-");
					r.setResult(calculaRegioResta(r));
				}
				else {
					r.setOperation("/");		
					r.setResult(calculaRegioDiv(r));
				}
				break;
			default:
				boolean suma = new Random().nextBoolean();
				if (suma) {
					r.setOperation("+");
					r.setResult(calculaRegioSuma(r));
				}
				else {
					r.setOperation("*");
					r.setResult(calculaRegioMult(r));
				}
				break;
			}
		}
		
		// Traiem els numeros del tauler
		for (int i=0; i<K.getAlto(); ++i) {
			for (int j=0; j<K.getAncho(); ++j) {
				K.borra(i,j);
			}
		}
	}
	
	public TaulerKenKen generateRandomly(int size) {
		n = size;
		fi = false;
		K = new TaulerKenKen(n);
		backtrackingGenerateNumbers(0,0);
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