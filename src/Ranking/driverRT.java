package Ranking;

import java.util.*;

public class driverRT {

	public static void main(String[] args) {
		Scanner scan = new Scanner (System.in);
		System.out.println("Ranking per tipus");
		System.out.println("Opcions:");
		System.out.println("1. Consultar ranking");
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
						System.out.println("S'estan visualitzant "+ RT.getnEntrades()+" entrades");	
					}
					else if (opt2 == 2) {
						System.out.println("Dificultat: " +d);
						for(int i=0; i<n;i++){
								System.out.println(i+1 +"a posició " + RT.getTempsJugador().get(i).getUser()+ "  " + RT.getTempsJugador().get(i).getTemps());
						}
					}	
					System.out.println("\nQue vols consultar?");
					System.out.println("Opcions:");
					System.out.println("1: Consultar el nombre d'entrades visibles");
					System.out.println("2: Consultar temps dels jugadors");
					System.out.println("0: Canviar dificultat");
					opt2 = Integer.parseInt(scan.nextLine());
				}
			}
			else {
				System.out.println("Error: Opcio no valida");
				System.out.println("0 per sortir");
			}
			System.out.println("Ranking Personal");
			System.out.println("Opcions:");
			System.out.println("1. Consultar ranking");
			System.out.println("0. Sortir");
			opt = Integer.parseInt(scan.nextLine());
		}
		System.out.println("Fi del programa");
		scan.close();
	}
}
