package capaDomini;

import java.util.*;
import Algoritmes.KenKenSolver;

public class driverEntraKenKen {
	
	public static void main(String[] args) {
		Scanner sn = new Scanner(System.in);
		System.out.println("Mida del KenKen");
		int n = Integer.parseInt(sn.nextLine());
		System.out.println("He llegit " + n);
		TaulerKenKen T = new TaulerKenKen(n);
		System.out.println("Nombre regions");
		int nr = Integer.parseInt(sn.nextLine());
		System.out.println("He llegit " + nr);
		for (int i=1; i<=nr; ++i) {
			RegioKenKen r = new RegioKenKen(nr);
			r.setId(i);
			System.out.println("Operacio de la regio " + i);
			String op = sn.nextLine();
			r.setOperation(op);
			System.out.println("He llegit " + op);
			System.out.println("Resultat de la regio" + i);
			int res = Integer.parseInt(sn.nextLine());
			r.setResult(res);
			System.out.println("He llegit " + res);
			System.out.println("Nombre cel.les de la regio " + i);
			int nc = sn.nextInt();
			System.out.println("He llegit " + nc);
			for (int j=1; j<=nc; ++j) {
				System.out.println("Cordenades cel.la " + j + " de la regio " + i);
				int x = (sn.nextInt()); //<------ peta aqui perque llegiex coses que no son
				int y = (sn.nextInt());
				System.out.println("He llegit " + x + " " +y);
				Cella c = new Cella(x,y);
				r.Relaciona(j,c);	
			}
			T.afegeixRegio(r);
		}
		
		/*
		int x;
		System.out.println("Entra els valors");
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < n; ++j) {
				System.out.println("Valor per la cel.la (" + (i+1) +","+ (j+1) +")");
				x = sn.nextInt();
				T.setNumero(i,j,x);
			}
		}
		*/
		
		KenKenSolver ks = new KenKenSolver();
		ks.backtrackingSolver(T);
		
		for (int i=0; i<n; ++i) {
			for (int j=0; j<n; ++j) {
				System.out.print(T.getNumero(i,j)+ " ");
			}
			System.out.println();
		}
		sn.close();
	}
}
