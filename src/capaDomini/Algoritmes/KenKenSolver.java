package capaDomini.Algoritmes;

import java.util.ArrayList;

import capaDomini.Utils.*;

public class KenKenSolver {
	
	private static TaulerKenKen KK;
	private static boolean trobat;
	
	private static void IA () { // inteligencia artificial
		for (int i=0; i<KK.getNRegio(); ++i) {
			if (KK.getRegio(i).getNumCeldas() == 1) { 
				int res = KK.getRegio(i).getResult(); 
				if (res > 0 && res <= KK.getAlto()) {
					KK.getRegio(i).getCella(0).setNumero(res);//posem les regions d'1 cel.la en posicio correcta
					KK.getRegio(i).getCella(0).bloquear();	  //i les bloquejam perque ningu les pugui tocar
				}
			}
		}
	}
	
	private static void backtrackingIA(int i, int j) {
		// Tenim solucio
		if (i==KK.getAlto()) {
			trobat = true;
		}
		// Continuem provant
		else {
			if (KK.getCella(i, j).estaBloqueada()) {
				if (j+1==KK.getAncho()) {
					backtrackingIA(i+1,0);
				}
				else {
					backtrackingIA(i,j+1);
				}
			}
			else {
				for (int value=1; value<=KK.getAncho() && !trobat; ++value) {
					if (KK.checkFila(i,value) && KK.checkCol(j,value)) {
						KK.setNumero(i, j, value);
						RegioKenKen r = KK.getRegio(KK.nRegio(i,j));
						if ((r.estaCompleta() && r.checkRegionC()) || (!r.estaCompleta() && r.checkRegionI())) {
							if (j+1==KK.getAncho()) {
								backtrackingIA(i+1,0);
							}
							else {
								backtrackingIA(i,j+1);
							}
						}
					}
				}
				if (!trobat){
					KK.getCella(i, j).borra();
				}
			}
		}	
	}
	
	private static void backtracking(int i, int j) {
		// Tenim solucio
		if (i==KK.getAlto()) {
			trobat = true;
		}
		// Continuem provant
		else {
			for (int value=1; value<=KK.getAncho() && !trobat; ++value) {
				if (KK.checkFila(i,value) && KK.checkCol(j,value)) {
					KK.setNumero(i, j, value);
					RegioKenKen r = KK.getRegio(KK.nRegio(i,j));
					if ((r.estaCompleta() && r.checkRegionC()) || !r.estaCompleta()) {
						if (j+1==KK.getAncho()) {
							backtracking(i+1,0);
						}
						else {
							backtracking(i,j+1);
						}
					}
				}
			}
			if (!trobat){
				KK.getCella(i, j).borra();
			}
		}	
	}
	
	public boolean comprovaSol (TaulerKenKen T) {
		KK = T;
		trobat = false;
		IA();
		backtrackingIA(0,0);
		return trobat;
	}
	
	private void afegeix1r (TaulerKenKen T) {
		int n = T.getAlto();
		boolean vb[] = new boolean[n];
		for (int i=0; i<n; ++i) {
			vb[i]=false;
		}
		for (int i=0; i<n; ++i) {
			int v = T.getCella(0, i).getNumero();
			if (v != -1) vb[v-1]=true;
		}
		for (int i=0; i<n; ++i) {
			if (vb[i]==false) T.setNumero(0, 0, i+1);
		}
	}
	
	public double backtrackingSolver(TaulerKenKen T) {		
		KK = T;
		trobat = false;
		long t0 = System.nanoTime();
		backtracking(0,0);
		afegeix1r(KK);
		long t1 = System.nanoTime();
		return (double)(t1-t0)/(double)Math.pow(10,9);
	}
	
	public double intelligentSolver(TaulerKenKen T) {
		KK = T;
		trobat = false;
		long t0 = System.nanoTime();
		IA();
		backtrackingIA(0,0);
		afegeix1r(KK);
		long t1 = System.nanoTime();
		return (double)(t1-t0)/(double)Math.pow(10,9);
	}
}