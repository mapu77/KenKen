package capaDomini.Utils;

import java.util.*;

import capaDomini.Algoritmes.KenKenGenerator;
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
		String u = scan.next();
		mostrarOpcions();
		int op;
		while ((op = scan.nextInt()) != 0) {
			String d;
			CtrlPartida CP;
			switch(op) {
			case 1:
				CtrlJoc CJ = new CtrlJoc();
				if (CJ.existeixPartidaGuardada(u)) {
					Partida p = new Partida(u);
					CP = new CtrlPartida(p);
					CP.play();
				}
				else {
					System.err.println("No tens partida guardada");
				}
				break;
			case 2:
				System.out.println("Dificultat");
				System.out.println("3x3, 4x4, 5x5, 6x6, 7x7, 8x8, 9x9");
				d = scan.next();
				try {
					if (!Dificultat.esValida(d)) throw (new ExcepcionDificultatInvalida());
					else {
						/* Cal imprimir al usuari els id de tots els taulells de dificultat d */
						String iden = scan.next();
						Partida p = new Partida(u, d, iden);
						CP = new CtrlPartida(p);
						CP.play();
					}
				} catch (ExcepcionDificultatInvalida e) {
					System.err.println(e.getMessage());
				}
				break;
			case 3:
				System.out.println("Dificultat KenKen:");
				System.out.println("3x3, 4x4, 5x5, 6x6, 7x7, 8x8, 9x9");
				d = scan.next();
				try {
					if (!Dificultat.esValida(d)) throw (new ExcepcionDificultatInvalida());
					else {
						Partida p = new Partida(u,d);
						CP = new CtrlPartida(p);
						CP.play();
					}
				} catch (ExcepcionDificultatInvalida e) {
					System.err.println(e.getMessage());
				}		
				break;
			default:
				System.err.println("Opcio incorrecte");
			}
			System.out.println();
			mostrarOpcions();
		}
		System.out.println("Fi del programa");
	}
}