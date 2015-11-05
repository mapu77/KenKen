package capaDomini;

import java.util.*;

import capaDomini.*;

public class driverEntraKenKen {
	
	public static void main(String[] args) {
		System.out.println("Mida del KenKen");
		int n = Integer.parseInt(new Scanner(System.in).nextLine());
		TaulerKenKen T = new TaulerKenKen(n,n);
		System.out.println("Nombre regions");
		int nr = Integer.parseInt(new Scanner(System.in).nextLine());
		for (int i=1; i<=nr; ++i) {
			RegioKenKen r = new RegioKenKen();
			System.out.println("Cel·les de la regio " + i);
			int nc = Integer.parseInt(new Scanner(System.in).nextLine());
			for (int j=0; j<nc; ++j) {
				System.out.println("Cordenades cel·la " + j + " de la regio " + i);
				int x = Integer.parseInt(new Scanner(System.in).nextLine());
				int y = Integer.parseInt(new Scanner(System.in).nextLine());
				Cela c = new Cela(x,y);
				T.
			}
			
		}
		
	}

}
