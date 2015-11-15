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
		boolean resoluble;
		KenKenGenerator KG = new KenKenGenerator();
		while ((option = sn.nextInt()) != 0) {
			resoluble = true;
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
				System.out.println("1-Generador KenKen per l'usuari");
				System.out.println("2-Generar KenKen a partir d'una serie de parametres");
				option = sn.nextInt();
				switch (option) {
				case 1:
					K = KG.generateKenKenbyUser("Sistema");
					KenKenSolver KS = new KenKenSolver();
					resoluble = KS.comprovaSol(K);
					if (! resoluble) {
						System.out.println("KenKen irresoluble");
					}
					break;
				case 2:
					K = KG.generateKenKenbyParameters("Sistema");
					break;
				default:
					K = new TaulerKenKen(0);
					break;
				}
				if (resoluble) K.PrintaRegioKenKen();
				break;
			default:
				K = new TaulerKenKen(4);
					
			}
			
			if (resoluble) {
				System.out.println("1.Soluciona algoritme backtracking");
				System.out.println("2.Soluciona algoritme IA");
				int op2 = sn.nextInt();
				if (op2 == 1) {
					KenKenSolver KS = new KenKenSolver();
					double time = KS.backtrackingSolver(K);
					System.out.println("Temps emprat: " + time + " segons");
					K.PrintaSolucio();
				}
				else if (op2 == 2) {
					KenKenSolver KS = new KenKenSolver();
					double time = KS.intelligentSolver(K);
					System.out.println("Temps emprat: " + time + " segons");
					K.PrintaSolucio();
				}
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
