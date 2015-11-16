package capaDomini.Utils;

import java.util.Scanner;

import capaDomini.Algoritmes.KenKenGenerator;
import capaDomini.Dificultat.Dificultat;
import excepciones.ExcepcionDificultatInvalida;

public class driverguardar {

	private static CtrlJoc CJ;
	
	private static void carregarKenKen() {
		TaulerKenKen K = CJ.llegirTauler("4","3x3");
		K.PrintaKenKen();
	}
	
	private static void guardarKenKen() {
		System.out.println("Dificultat KenKen");
		System.out.println("3x3, 4x4, 5x5, 6x6, 7x7, 8x8, 9x9");
		String d = new Scanner(System.in).next();
		try {
			if (!Dificultat.esValida(d)) throw (new ExcepcionDificultatInvalida());
			else {
				int n = Dificultat.toInt(d);
				TaulerKenKen K = new KenKenGenerator().generateRandomly(n);
				K.PrintaKenKen();
				CJ.guardarTauler(K);	
			}
		} catch (ExcepcionDificultatInvalida e) {
			System.err.println(e.getMessage());
		}
	}
	
	private static void guardarPartida() {
		Partida p = new Partida();
		p.setD("4x4");
		p.setIdJoc("2");
		p.setPistes(2);
		p.setUsuari("Nou");
		CtrlPartida CP = new CtrlPartida(p);
		CP.save();
		System.out.println("Hem guardat la partida");
	}
	
	public static void main(String[] args) {
		Partida p = new Partida("ocapo","4x4");
		CtrlPartida cp = new CtrlPartida(p);
		cp.play();
		//carregarKenKen();
		//guardarPartida();
	}
}
