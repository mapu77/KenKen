package capaDomini.Utils;

import java.util.*;
import capaDomini.Algoritmes.*;

public class driverEntraKenKen {
	
	public static void main(String[] args) {
		System.out.println("KenKen");
		System.out.println("Options:");
		System.out.println("0. Sortir");
		System.out.println("1. Maquina genera KenKen");
		System.out.println("2. Usuari genera KenKen");
		Scanner sn = new Scanner(System.in);
		int option;
		KenKenGenerator KG = new KenKenGenerator();
		while ((option = sn.nextInt()) != 0) {
			TaulerKenKen K;
			switch (option) {
			case 1:
				System.out.println("Generador aleatori");
				System.out.println("Dificultat del KenKen?");
				int n = sn.nextInt();
				K = KG.generateRandomly(n);
				K.PrintaRegioKenKen();
				break;
			case 2:
				System.out.println("Generador per l'usuari");
				K = KG.generateKenKenbyUser();
				K.PrintaRegioKenKen();
				break;
			default:
				K = new TaulerKenKen(4);
					
			}
			System.out.println("1.Soluciona maquina");
			System.out.println("2. Soluciona usuari");
			int op2 = sn.nextInt();
			if (op2 == 1) {
				KenKenSolver KS = new KenKenSolver();
				long time = KS.intelligentSolver(K);
				System.out.println("Temps emprat: " + time + " segons");
				K.PrintaKenKen();
			}
			System.out.println("KenKen");
			System.out.println("Options:");
			System.out.println("0. Sortir");
			System.out.println("1. Maquina genera KenKen");
			System.out.println("2. Usuari genera KenKen");
		}
		sn.close();
		System.out.println("Fi Programa");
	}
}