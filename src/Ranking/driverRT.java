package Ranking;

import java.util.*;

import capaPersistencia.CtrlPersistencia;

public class driverRT {

	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner (System.in);
		System.out.println("Ranking per tipus");
		System.out.println("Opcions:");
		System.out.println("1. Consultar ranking");
		System.out.println("0. Sortir");
		CtrlPersistencia.setSeparator(" ");
		int opt = scan.nextInt();
		while (opt != 0) {
			if (opt == 1) {
				System.out.println("Introdueix la dificultat");
				String d = scan.next();
				System.out.println("Introdueix el nombre d'entrades");
				int n = Integer.parseInt(scan.next());
				RankingPerTipus RT = new RankingPerTipus(d,n);
				System.out.println("1: Consultar el nombre d'entrades visibles");
				System.out.println("2: Consultar temps dels jugadors");
				System.out.println("0: Sortir");
				int opt2 = scan.nextInt();
				while (opt2 != 0) {
					if (opt2 == 1) {
						System.out.println("S'estan visualitzant "+ RT.getnEntrades()+" entrades");	
					}
					else if (opt2 == 2) {
						System.out.println("Dificultat: " +d);
						int max=RT.getTempsJugador().size();
						for(int i=0; i<n;i++){
							if(i<max)
								System.out.println(i+1 +"a posició " + RT.getTempsJugador().get(i).getUser()+ "  " + RT.getTempsJugador().get(i).getTemps());
							}
					}	
					System.out.println("\nQue vols consultar?");
					System.out.println("Opcions:");
					System.out.println("1: Consultar el nombre d'entrades visibles");
					System.out.println("2: Consultar temps dels jugadors");
					System.out.println("0: Canviar dificultat");
					opt2 = scan.nextInt();
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
			opt = scan.nextInt();
		}
		System.out.println("Fi del programa");
		scan.close();
	}
}
