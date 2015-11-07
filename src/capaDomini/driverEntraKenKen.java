package capaDomini;

import java.util.*;
import Algoritmes.*;


//import capaDomini.*;

public class driverEntraKenKen {
	
	public static void main(String[] args) {
		Scanner sn = new Scanner(System.in);
		System.out.println("Mida del KenKen");
		int n = sn.nextInt();
		KenKenGenerator KG = new KenKenGenerator();
		TaulerKenKen K = KG.generateRandomly(n);
		/*TaulerKenKen T = new TaulerKenKen(n);
		System.out.println("Nombre regions");
		int nr = sn.nextInt();
		for (int i=0; i<nr; ++i) {
			Vector<Cella> VC = new Vector<Cella>();
			System.out.println("Cel.les de la regio " + i);
			int nc = sn.nextInt();
			for (int j=0; j<nc; ++j) {
				System.out.println("Cordenades cel.la " + j + " de la regio " + i);
				VC.add(new Cella(sn.nextInt(),sn.nextInt()));
			}
			System.out.println("Operacio de la regio " + i);
			String op = sn.next();
			System.out.println("Resultat de la regio " + i);
			int res = sn.nextInt();
			RegioKenKen r = new RegioKenKen(nc,VC,op,res,i);
			T.afegeixRegio(r);
		}
		/*
		System.out.println("Introdueix la teva solucio");
		int x;
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < n; ++j) {
				x = sn.nextInt();
				T.setNumero(i,j,x);
			}
		}*/
		KenKenSolver ks = new KenKenSolver();
		ks.backtrackingSolver(K);
		
		K.PrintaKenKen();
		sn.close();
	}
}
