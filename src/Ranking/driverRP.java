package Ranking;

import java.util.*;
import Dificultat.*;

public class driverRP {

	public static void main(String[] args) {
		Scanner scan = new Scanner (System.in);
		System.out.println("Ranking Personal");
		System.out.println("Opcions:");
		System.out.println("1. Consultar rànquing");
		System.out.println("0. Exit");
		int opt = Integer.parseInt(scan.nextLine());
		while (opt != 0) {
			if (opt == 1) {
				System.out.println("De qui vols consultar el rànquing?");
				String u = scan.nextLine();
				RankingPersonal RP = new RankingPersonal(u);
				System.out.println("Què vols consultar?");
				System.out.println("Opcions:");
				System.out.println("1: Nombre de partides");
				System.out.println("2: Nombre de pistes usades (en mitjana)");
				System.out.println("3: Millors temps");
				System.out.println("4: Veure-ho tot");
				System.out.println("0: Canviar usuari");
				int opt2 = Integer.parseInt(scan.nextLine());
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
							if (RP.getBestTime(d) != null)
								System.out.println(d + ": " + RP.getBestTime(d));
							else System.out.println(d + ": -");

						}	
					}
					System.out.println("Què vols consultar?");
					System.out.println("Opcions:");
					System.out.println("1: Nombre de partides");
					System.out.println("2: Nombre de pistes usades (en mitjana)");
					System.out.println("3: Millors temps");
					System.out.println("4: Veure-ho tot");
					System.out.println("0: Canviar usuari");
					opt2 = Integer.parseInt(scan.nextLine());
				}
			}
			else {
				System.out.println("Error: Opció no vàlida");
				System.out.println("0 per sortir");
			}
			System.out.println("Ranking Personal");
			System.out.println("Opcions:");
			System.out.println("1. Consultar rànquing");
			System.out.println("0. Exit");
			opt = Integer.parseInt(scan.nextLine());
		}
		System.out.println("Fi del programa");
		scan.close();
	}
}
