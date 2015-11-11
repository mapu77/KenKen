package capaDomini.Algoritmes;

import java.util.*;
import capaDomini.Utils.*;

public class KenKenUserSolver {
	
	private static void findcellavacia(TaulerKenKen T, Cella c) {
		int randx = new Random().nextInt(T.getAlto());
		int randy = new Random().nextInt(T.getAlto());
		if (!(T.estaVacia(randx,randy))) { findcellavacia(T,c); }
		else {
			c.setX(randx);
			c.setY(randy);
		}
	}
	
	private static void KenKenClone(TaulerKenKen T, TaulerKenKen K) {
		for (int i = 0; i < T.getNRegio(); i++) {
			Vector<Cella> v = new Vector<Cella>();
			for (int j =  0; j < T.getRegio(i).getNumCeldas(); j++) {
				Cella C = new Cella(T.getRegio(i).getCella(j).getX(),T.getRegio(i).getCella(j).getY());
				v.add(C);
			}
			RegioKenKen R = new RegioKenKen(T.getRegio(i).getNumCeldas(),v, T.getRegio(i).getOperation(), 
					T.getRegio(i).getResult(),i);
			K.afegeixRegio(R);
		}
	}
	
	public void usersolver(TaulerKenKen T) {
		Scanner sn = new Scanner(System.in);
		System.out.println("Opcions");
		System.out.println("1. Introduir numero");
		System.out.println("2. Undo");
		System.out.println("3. Demanar Pista");
		System.out.println("4. Pausa");
		System.out.println("5.Guardar partida");
		System.out.println("6.Reiniciar partida");
		System.out.println("0. Sortir");
		int option = sn.nextInt();
		int pistes_demanades = 0;
		Stack<Cella> s = new Stack<Cella>();
		while (option!= 0 || option != 5) {
			switch (option) {
			case 1:	//funciona
				System.out.println("Indica les coordenades(format: x y)");
				int x = sn.nextInt();
				int y = sn.nextInt();
				System.out.println("Indica el valor a afegir");
				int val = sn.nextInt();
				if (val > T.getAlto() || val < 1) {
					System.out.println("El valor es  un numero entre "+ 1 + " i " + T.getAlto());
					break;
				}
				Cella c = T.getCella(x, y);
				Cella copia = new Cella();
				copia.setX(c.getX());
				copia.setY(c.getY());
				copia.setNumero(c.getNumero());
				if (c.estaVacia()) {
					s.addElement(copia);
					T.setNumero(x, y, val);

				}
				else {
					System.out.println("Aquesta cel·la ja conte el valor "+ c.getNumero() + ". Voleu substituir-lo?");
					System.out.println("1. Si // 2. No");
					if (sn.nextInt() == 1) {
						s.addElement(copia);
						T.setNumero(x, y, val);
					}
				}
				T.PrintaKenKen();
				break;
			case 2:	//funciona
				if (s.empty()) {System.out.println("No es pot tirar mes endarrere");}
				else {
					Cella top = s.peek();
					if (top.getNumero() != -1) {
						T.setNumero(top.getX(), top.getY(), top.getNumero());
					}
					else { T.borra(top.getX(), top.getY()); }
					s.pop();
					T.PrintaKenKen();
				}
				break;
			case 3:	//funciona
				if (T.getNumCeldasRellenas() < T.getNumCeldas()) {
					if (pistes_demanades < T.getAlto()-2) {
						
						TaulerKenKen K = new TaulerKenKen(T.getAlto());
						KenKenClone(T,K);
						KenKenSolver KS = new KenKenSolver();
						KS.backtrackingSolver(K);
						Cella ret = new Cella();
						findcellavacia(T,ret);
						System.out.println("Pista a les coordenades (" + ret.getX() + "," + ret.getY() + ") amb valor " 
								+ K.getNumero(ret.getX(), ret.getY()));
						T.setNumero(ret.getX(), ret.getY(), K.getNumero(ret.getX(), ret.getY()));
						T.PrintaKenKen();
						++pistes_demanades;
					}
					else { System.out.println("Ja has demanat el maxim de pistes permeses"); }
				}
				else { System.out.println("El taulell ja està ple"); }
				break;
			case 4:
				/* 
				 * Es para el temps de la partida
				 * System.out.println("Prem 1 per continuar la partida");
				 * while (sn.nextInt()!= 1){}
				 * Es torna a iniciar el temps de la partida
				 */
				break;
			case 6:	//funciona
				for (int i = 0; i < T.getAlto(); i++) {
					for (int j = 0; j < T.getAncho(); j++) {
						if (!(T.getCella(i, j).estaVacia())) {
							T.borra(i, j);
						}
					}
				}
				T.PrintaKenKen();
				pistes_demanades = 0;
				break;
			}
			System.out.println("Opcions");
			System.out.println("1. Introduir numero");
			System.out.println("2. Undo");
			System.out.println("3. Demanar Pista");
			System.out.println("4. Pausa");
			System.out.println("5.Guardar partida");
			System.out.println("6.Reiniciar partida");
			System.out.println("0. Sortir");
			option = sn.nextInt();
		}
		if (option == 5) {
		/*
		 * Es guarda l'estat actual de la partida (valors introduits i temps jugat)
		 * P.guardarKenKenKen();
		 */
		}
		else {System.out.println("Estas sortint de la partida..."); }
		sn.close();
	}
}