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
			switch(op) {
			case 1:
				CtrlJoc CJ = new CtrlJoc();
				if (CJ.existeixPartidaGuardada()) {
					TaulerKenKen K = CJ.loadPartidaGuardada(u);
					K.PrintaKenKen();
				}
				break;
			case 2:
				break;
			case 3:
				System.out.println("Mida KenKen:");
				System.out.println("3x3, 4x4, 5x5, 6x6, 7x7, 8x8, 9x9");
				String d = scan.next();
				try {
					int n;
					if (!Dificultat.esValida(d)) throw (new ExcepcionDificultatInvalida());
					else {
						n = Dificultat.toInt(d);
						Partida p = new Partida(u,d);
						CtrlPartida CP = new CtrlPartida(p);
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