package capaDomini.Ranking;

import java.util.*;

import capaDomini.Dificultat.Dificultat;
import excepciones.*;

public class driverRT {

	private static void mostraOpcions(String d) {
		System.out.println("Opcions:");
		System.out.println("1: Consultar el nombre d'entrades visibles");
		System.out.println("2: Modificar el nombre d'entrades visibles");
		System.out.println("3: Consultar els millors temps dels " + d);
		System.out.println("0: Sortir");	
	}
		
	public static void mostraRankingPerTipus() {
		Scanner scan = new Scanner (System.in);
		System.out.println("Ranking per Tipus:");
		System.out.println("-----------------");
		System.out.println("Introdueix la dificultat");
		String d;
		try {
			d = scan.next();
			if (!Dificultat.esValida(d)) throw (new ExcepcionDificultatInvalida());
			else {
				System.out.println("Introdueix el nombre d'entrades");
				int n = Integer.parseInt(scan.next());
				RankingFactory RF = new RankingFactory();
				RankingPerTipus RT = RF.generarRankingPerTipus(d, n); 
				mostraOpcions(d);
				int opt2;
				while ( (opt2 = scan.nextInt()) != 0) {
					switch (opt2) {
					case 1:
						System.out.println("S'estan visualitzant "+ RT.getnEntrades()+" entrades");
						break;
					case 2:
						System.out.println("Quantes entrades vols veure?");
						n = scan.nextInt();
						RT.setnEntrades(n);
						break;
					case 3:
						System.out.println("Dificultat: " +d);
						int max=RT.getTempsJugador().size();
						System.out.println("Posicio\t\tUsuari\t\tIdJoc\t\tTemps");
						System.out.println("-------\t\t------\t\t-----\t\t-----");
						for(int i=0; i<n;i++){
							if(i<max) {
								System.out.println(i+1 + "a\t\t" + RT.getTempsJugador().get(i).getUser() + "\t\t" 
													+ RT.getTempsJugador().get(i).getId() + "\t\t" + RT.getTempsJugador().get(i).getTemps());
							}
						}
						break;
					default:
						System.err.println("Opcio erronia");
						break;
					}
					System.out.println();
					mostraOpcions(d);
				}
			}
		}catch (ExcepcionDificultatInvalida e) {
			System.out.println(e.getMessage());
		}
		System.out.println("Fi Ranking Per Tipus");
	}
}