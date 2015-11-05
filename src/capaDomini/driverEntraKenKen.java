package capaDomini;

import java.util.*;


//import capaDomini.*;

public class driverEntraKenKen {
	
	public static void main(String[] args) {
		Scanner sn = new Scanner(System.in);
		System.out.println("Mida del KenKen");
		int n = Integer.parseInt(sn.nextLine());
		TaulerKenKen T = new TaulerKenKen(n);
		System.out.println("Nombre regions");
		int nr = Integer.parseInt(sn.nextLine());
		for (int i=1; i<=nr; ++i) {
			RegioKenKen r = new RegioKenKen(nr);
			r.setId(i);
			System.out.println("Operacio de la regio " + i);
			r.setOperation(sn.nextLine());
			System.out.println("Resultat de la regio" + i);
			r.setResult(Integer.parseInt(sn.nextLine()));
			System.out.println("Nombre cel.les de la regio " + i);
			int nc = sn.nextInt();
			for (int j=1; j<=nc; ++j) {
				System.out.println("Cordenades cel.la " + j + " de la regio " + i);
				int x = (sn.nextInt());
				int y = (sn.nextInt());
				Cella c = new Cella(x,y);
				r.Relaciona(j,c);	
			}
			T.afegeixRegio(r);
		}
		int x;
		System.out.println("Entra els valors");
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < n; ++j) {
				System.out.println("Valor per la cel.la (" + (i+1) +","+ (j+1) +")");
				x = sn.nextInt();
				T.setNumero(i,j,x);
			}
		}
		
		for (int i=0; i<n; ++i) {
			for (int j=0; j<n; ++j) {
				System.out.print(T.getNumero(i,j)+ " ");
			}
			System.out.println();
		}
		sn.close();
	}
}
