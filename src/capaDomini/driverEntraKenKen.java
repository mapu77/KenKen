package capaDomini;

import java.util.*;


//import capaDomini.*;

public class driverEntraKenKen {
	
	public static void main(String[] args) {
		Scanner sn = new Scanner(System.in);
		System.out.println("Mida del KenKen");
		int n = sn.nextInt();
		TaulerKenKen T = new TaulerKenKen(n);
		System.out.println("Nombre regions");
		int nr = sn.nextInt();
		for (int i=1; i<=nr; ++i) {
			RegioKenKen r = new RegioKenKen(nr);
			r.setId(i);
			System.out.println("Operacio de la regio " + i);
			String op = sn.next();
			r.setOperation(op);
			System.out.println("Resultat de la regio " + i);
			int res = sn.nextInt();
			r.setResult(res);
			System.out.println("Cel�les de la regio " + i);
			int nc = sn.nextInt();
			for (int j=0; j<nc; ++j) {
				System.out.println("Cordenades cel�la " + j + " de la regio " + i);
				Cella c = new Cella(sn.nextInt(),sn.nextInt());
				r.Relaciona(j,c);	
			}
			T.afegeixRegio(r);
		}
		System.out.println("Introdueix la teva solucio");
		int x;
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < n; ++j) {
				x = sn.nextInt();
				T.setNumero(i,j,x);
			}
		}
		T.PrintaKenKen();
		sn.close();
	}
}
