package capaDomini.Ranking;

import java.util.*;
import capaDomini.Dificultat.*;
import capaDomini.Usuari.CtrlUser;
import excepciones.*;

public class driverRP {

	private static void mostraOpcions() {
		System.out.println("Opcions:");
		System.out.println("1: Nombre de partides");
		System.out.println("2: Nombre de pistes usades (en mitjana)");
		System.out.println("3: Millors temps");
		System.out.println("4: Veure-ho tot");
		System.out.println("0: Sortir");
	}
	
	public static void mostraRankingPersonal() {
		Scanner scan = new Scanner (System.in);
		System.out.println("Ranking Personal:");
		System.out.println("----------------");
		System.out.println("De qui vols consultar el rànquing?");
		try {
			String u = scan.next();
			RankingFactory RF = new RankingFactory();
			if (CtrlUser.getUsuari(u) == null) throw (new ExcepcionUsuariNoExisteix());
			else {
				RankingPersonal RP = RF.generarRankingPersonal(u);				
				int opt2;
				mostraOpcions();
				while ((opt2 = scan.nextInt()) != 0) {
					switch(opt2) {
					case 1:
						System.out.println(u+" ha jugat "+ RP.getResolts()+" partida/es");
						break;
					case 2:
						System.out.println(u+" ha usat "+ RP.getPistes()+" pistes en mitjana");
						break;
					case 3:
						System.out.println("Dificultat\t\tTemps");
						for (String d : Dificultat.getAll()) {
							System.out.println(d + ":\t\t" + RP.getBestTime(d));
						}
						break;
					case 4:
						System.out.println("Usuari: " + u);
						System.out.println(u+" ha jugat " + RP.getResolts()+ " partida/es");
						System.out.println(u+" ha usat " + RP.getPistes()+ " pistes en mitjana");
						System.out.println("Dificultat\tTemps");
						for (String d : Dificultat.getAll()) {
							if (RP.getBestTime(d) != null) {
								System.out.println(d + ":\t\t" + RP.getBestTime(d));
							}
							else System.out.println(d + ":\t\t-");

						}	
						break;
					default:
						System.err.println("Opcio erronia");
						break;
					}
					mostraOpcions();
				}
			}	
		} catch (ExcepcionUsuariNoExisteix e) {
			System.out.println(e.getMessage());
		}				
		System.out.println("Fi del programa");
	}
}
