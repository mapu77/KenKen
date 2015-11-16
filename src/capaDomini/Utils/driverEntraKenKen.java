package capaDomini.Utils;

import java.util.*;
import capaDomini.Algoritmes.*;
import capaDomini.Dificultat.Dificultat;
import excepciones.ExcepcionDificultatInvalida;

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
				System.out.println("Mida del KenKen?");
				System.out.println("Opcions: 3x3, 4x4, 5x5, 6x6, 7x7, 8x8, 9x9");
				String d = sn.next();
				int n;
				try { 
					if (Dificultat.esValida(d)) {
						n=Dificultat.toInt(d);
						K = KG.generateRandomly(n);
						K.PrintaRegioKenKen();
					}
					else throw (new ExcepcionDificultatInvalida());
				}
				catch (ExcepcionDificultatInvalida e) {
					K = null;
					resoluble=false;
					System.err.println(e.getMessage());
				}
				break;
			case 2:
				System.out.println("Generador per l'usuari");
				System.out.println("1-Generador KenKen per l'usuari");
				System.out.println("2-Generar KenKen a partir d'una serie de parametres");
				option = sn.nextInt();
				switch (option) {
				case 1:
					K = KG.generateKenKenbyUser();
					if (K==null || K.getAlto()==0) resoluble=false;
					else { 
						KenKenSolver KS = new KenKenSolver();
						resoluble = KS.comprovaSol(K);
						if (! resoluble) {
							System.out.println("KenKen irresoluble");
						}
					}
					break;
				case 2:
					K = KG.generateKenKenbyParameters();
					if (K==null || K.getAlto() == 0) resoluble=false;
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
				System.out.println("3.Guardar KenKen a la BD");
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
				else if (op2 == 3) {
					CtrlJoc JC = new CtrlJoc();
					int id = JC.guardarTauler(K);
					System.out.println("Tauler guardat amb identificador " + id);
					System.out.println("Vols resoldre el KenKen?");
					System.out.println("1-Si\n2-No");
					op2 = sn.nextInt();
					if (op2 == 1) {
						System.out.println("1.Soluciona algoritme backtracking");
						System.out.println("2.Soluciona algoritme IA");
						op2 = sn.nextInt();
						if (op2 == 1) {
							KenKenSolver KS = new KenKenSolver();
							double time = KS.backtrackingSolver(K);
							System.out.println("Temps emprat: " + time + " segons");
						}
						else if (op2 == 2) {
							KenKenSolver KS = new KenKenSolver();
							double time = KS.intelligentSolver(K);
						}
						K.PrintaSolucio();
					}
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
