package Ranking;

import java.util.*;

import Dificultat.Dificultat;

public class driverRT {

	public static void main(String[] args) {
		Scanner scan = new Scanner (System.in);
		System.out.println("Ranking per tipus");
		System.out.println("Opcions:");
		System.out.println("1. Consultar rànquing");
		System.out.println("0. Sortir");
		int opt = Integer.parseInt(scan.nextLine());
		while (opt != 0) {
			if (opt == 1) {
				System.out.println("Introdueix la dificultat");
				String d = scan.nextLine();
				System.out.println("Introdueix el nombre d'entrades");
				int n = Integer.parseInt(scan.nextLine());
				RankingPerTipus RT = new RankingPerTipus(d,n);
				System.out.println("1: Consultar el nombre d'entrades visibles");
				System.out.println("2: Consultar temps dels jugadors");
				System.out.println("0: Sortir");
				int opt2 = Integer.parseInt(scan.nextLine());
				while (opt2 != 0) {
					if (opt2 == 1) {
						System.out.println("S'estan visualitzant"+ RT.getnEntrades()+" entrades");	
					}
					else if (opt2 == 2) {
						for (String d : Dificultat.getAll())
							System.out.println(d + ": " + (RT.getTempsJugador(d));
					}	
					System.out.println("Què vols consultar?");
					System.out.println("Opcions:");
					System.out.println("1: Consultar el nombre d'entrades visibles");
					System.out.println("2: Consultar temps dels jugadors");
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
			System.out.println("0. Sortir");
			opt = Integer.parseInt(scan.nextLine());
		}
		System.out.println("Fi del programa");
		scan.close();
	}
}
