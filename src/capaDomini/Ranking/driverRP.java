package capaDomini.Ranking;

import java.util.*;
import capaDomini.Dificultat.*;

public class driverRP {

	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner (System.in);
		System.out.println("Ranking Personal");
		System.out.println("----------------");
		System.out.println("Opcions:");
		System.out.println("1. Consultar rànquing");
		System.out.println("0. Exit");
		int opt = scan.nextInt();
		while (opt != 0) {
			if (opt == 1) {
				RankingFactory RF = new RankingFactory();
				System.out.println("De qui vols consultar el rànquing?");
				String u = scan.next();
				RankingPersonal RP = RF.generarRankingPersonal(u);
				System.out.println();
				System.out.println("Què vols consultar?");
				System.out.println("Opcions:");
				System.out.println("1: Nombre de partides");
				System.out.println("2: Nombre de pistes usades (en mitjana)");
				System.out.println("3: Millors temps");
				System.out.println("4: Veure-ho tot");
				System.out.println("0: Canviar usuari");
				int opt2 = scan.nextInt();
				while (opt2 != 0) {
					if (opt2 == 1) {
						System.out.println(u+" ha jugat "+ RP.getResolts()+" partida/es");	
					}
					else if (opt2 == 2) {
						System.out.println(u+" ha usat "+ RP.getPistes()+" pistes en mitjana");
					}
					else if (opt2 == 3) {
						for (String d : Dificultat.getAll()) {
							System.out.println(d + ": " + RP.getBestTime(d));
						}
					}
					else if (opt2 == 4) {
						System.out.println("Usuari: " + u);
						System.out.println(u+" ha jugat "+ RP.getResolts()+" partida/es");
						System.out.println(u+" ha usat "+ RP.getPistes()+" pistes en mitjana");
						for (String d : Dificultat.getAll()) {
							if (RP.getBestTime(d) != null) {
								System.out.println(d + ": " + RP.getBestTime(d));
							}
							else System.out.println(d + ": -");

						}	
					}
					System.out.println();
					System.out.println("Què vols consultar?");
					System.out.println("Opcions:");
					System.out.println("1: Nombre de partides");
					System.out.println("2: Nombre de pistes usades (en mitjana)");
					System.out.println("3: Millors temps");
					System.out.println("4: Veure-ho tot");
					System.out.println("0: Canviar usuari");
					opt2 = scan.nextInt();
				}
			}
			else {
				System.out.println("Error: Opció no vàlida");
				System.out.println("0 per sortir");
			}
			System.out.println();
			System.out.println("Ranking Personal");
			System.out.println("Opcions:");
			System.out.println("1. Consultar rànquing");
			System.out.println("0. Exit");
			opt = scan.nextInt();
		}
		System.out.println("Fi del programa");
		scan.close();
	}
}
