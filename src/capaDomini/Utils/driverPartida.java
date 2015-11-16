package capaDomini.Utils;

import java.util.*;

import capaDomini.Dificultat.Dificultat;
import excepciones.ExcepcionDificultatInvalida;

public class driverPartida {
	
	private static void mostrarOpcions() {
		System.out.println("JUGAR KENKEN");
		System.out.println("0 Sortir");
		System.out.println("1 Continuar Partida");
		System.out.println("2 Seleccionar Kenken creat");
		System.out.println("3 Generar Kenken aleatori");
	}
	
	public static void main(String[] args) {
		System.out.println("Introdueix el teu usuari");
		Scanner scan = new Scanner(System.in);
		String u = null;
		if (scan.hasNext()) {
			u = scan.next();
		}
		else System.out.println("Valor incorrecte");
		mostrarOpcions();
		int op;
		while (scan.hasNextInt() && (op = scan.nextInt()) != 0) {
			String d = null;
			CtrlPartida CP;
			CtrlJoc CJ;
			switch(op) {
			case 1:
				CJ = new CtrlJoc();
				if (CJ.existeixPartidaGuardada(u)) {
					Partida p = CJ.loadPartidaGuardada(u);
					CP = new CtrlPartida(p,scan);
					CP.play();
				}
				else {
					System.out.println("No tens cap partida guardada");
				}
				break;
			case 2:
				System.out.println("Dificultat");
				System.out.println("3x3, 4x4, 5x5, 6x6, 7x7, 8x8, 9x9");
				if (scan.hasNext()) d = scan.next();
				CJ = new CtrlJoc();
				try {
					if (!Dificultat.esValida(d)) throw (new ExcepcionDificultatInvalida());
					else {
						System.out.println("Quin tauler vols jugar?");
						System.out.println(CJ.mostrarIdTaulers(d));
						String iden = null;
						if (scan.hasNext()) iden = scan.next();
						if (CJ.existeixTauler(iden,d)) {
							Partida p = new Partida(u, d, iden);
							CP = new CtrlPartida(p, scan);
							CP.play();
						}
						else {
							System.out.println("Aquest tauler no existeix");
						}
					}
				} catch (ExcepcionDificultatInvalida e) {
					System.out.println(e.getMessage());
				}
				break;
			case 3:
				System.out.println("Dificultat KenKen:");
				System.out.println("3x3, 4x4, 5x5, 6x6, 7x7, 8x8, 9x9");
				if (scan.hasNext()) d = scan.next();
				try {
					if (!Dificultat.esValida(d)) throw (new ExcepcionDificultatInvalida());
					else {
						Partida p = new Partida(u,d);
						CP = new CtrlPartida(p,scan);
						CP.play();
					}
				} catch (ExcepcionDificultatInvalida e) {
					System.out.println(e.getMessage());
				}		
				break;
			default:
				System.out.println("Opcio incorrecte");
			}
			System.out.println();
			mostrarOpcions();
		}
		System.out.println("Fi del programa");
	}
}