package capaDomini.Algoritmes;

import java.util.*;
import capaDomini.Utils.*;


public class KenKenUserSolver implements Runnable {
	
	TaulerKenKen t1;
	TaulerKenKen t2;
	TaulerKenKen t3;
	
	public KenKenUserSolver() {}
	public KenKenUserSolver(TaulerKenKen T1, TaulerKenKen T2, TaulerKenKen T3) {
		this.t1 = T1;
		this.t2 = T2;
		this.t3 = T3;
	}
	
	private void findcellabuida(TaulerKenKen T, Cella c) {
		int randx = new Random().nextInt(T.getAlto());
		int randy = new Random().nextInt(T.getAlto());
		if (!(T.estaVacia(randx,randy))) { findcellabuida(T,c); }
		else {
			c.setX(randx);
			c.setY(randy);
		}
	}
	
	private void KenKenClone(TaulerKenKen sol, TaulerKenKen copia, TaulerKenKen aux) {
		//Stack<Cella> s = new Stack <Cella>();
		/*for (int i = 0; i < sol.getAlto(); i++) {
			for (int j = 0; j < sol.getAncho(); j++) {
				if (!sol.estaVacia(i, j)) {
					Cella c = new Cella();
					c.setX(i); c.setY(j); c.setNumero(sol.getNumero(i, j));
					s.addElement(c);
				}
			}
		}*/
		//KenKenSolver KS = new KenKenSolver();
		//System.out.println("Afegint pista. Aquesta accio pot trigar una estona");
		//KS.backtrackingSolver(sol);
		//sol.PrintaKenKen();
		for (int i = 0; i < sol.getAlto(); i++) {
			for (int j = 0; j < sol.getAncho(); j++) {
				copia.setNumero(i, j, sol.getNumero(i, j));
				sol.borra(i, j);
			}
		}
		/*while (!s.empty()) {
			sol.setNumero(s.peek().getX(), s.peek().getY(), s.peek().getNumero());
			s.pop();
		}*/
		for (int i = 0; i < sol.getAlto(); i++) {
			for (int j = 0; j < sol.getAncho(); j++) {
				if (!aux.estaVacia(i,j)) {
					sol.setNumero(i, j, aux.getNumero(i, j));
				}
			}
		}
	}
	
	public void run() {
		KenKenSolver KS = new KenKenSolver();
		KS.backtrackingSolver(t1);
		System.out.println("Ja es pot utilitzar la opcio \"Demanar Pista\"");
		KenKenClone(t1,t2,t3);
	}
	
	private void introdueixvalor(TaulerKenKen T, int x, int y, int val, Stack<Cella> s, Scanner ns ) {
		if (val > T.getAlto() || val < 1) {
			System.out.println("El valor es  un numero entre "+ 1 + " i " + T.getAlto());
		}
		else {
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
				System.out.println("Aquesta cella ja conte el valor "+ c.getNumero() + ". Voleu substituir-lo?");
				System.out.println("1. Si // 2. No");
				if (ns.nextInt() == 1) {
					s.addElement(copia);
					T.setNumero(x, y, val);
				}
			}
		}
	}
	
	public void usersolver(TaulerKenKen T) {
		Scanner ns = new Scanner(System.in);
		System.out.println("Opcions");
		System.out.println("1. Introduir numero \t 2. Undo \t\t 3. Demanar Pista");
		System.out.println("4. Pausa \t\t 5. Guardar Partida \t 6. Reiniciar Partida");
		System.out.println("0. Sortir");
		int option;
		int pistes_demanades = 0;
		//boolean solucionat = false;
		Stack<Cella> s = new Stack<Cella>();
		TaulerKenKen K = new TaulerKenKen(T.getAlto());
		TaulerKenKen auxiliar = new TaulerKenKen(T.getAlto());
		KenKenUserSolver p = new KenKenUserSolver(T,K,auxiliar);
		new Thread(p).start();
		while ((option=ns.nextInt()) != 0 && option != 5) {
			switch (option) {
			case 1:	//funciona
				System.out.println("Indica les coordenades(format: x y)");
				int x = ns.nextInt();
				int y = ns.nextInt();
				System.out.println("Indica el valor a afegir");
				int val = ns.nextInt();
				if (K.getNumCeldasRellenas() == K.getNumCeldas()) {
					introdueixvalor(T,x,y,val,s,ns);
					T.PrintaKenKen();
				}
				else {
					introdueixvalor(auxiliar,x,y,val,s,ns);
					T.PrintaRegioKenKen();
					auxiliar.PrintaSolucio();
				}
				
				if (T.getNumCeldasRellenas() == T.getNumCeldas() &&
						K.getNumCeldasRellenas() == K.getNumCeldas()) {
					KenKenCheck KC = new KenKenCheck();
					if (!KC.checkKenKen(T)) {
						System.out.println("Enhorabona! La solucio es correcta");
					}
					else {
						System.out.println("Aquesta solucio no es correcta");
					}
				}
				break;
			case 2:	//funciona
				if (s.empty()) {System.out.println("No es pot tirar mes endarrere");}
				else {
					if (K.getNumCeldas() == K.getNumCeldasRellenas()) {
						Cella top = s.peek();
						if (top.getNumero() != -1) {
							T.setNumero(top.getX(), top.getY(), top.getNumero());
						}
						else { T.borra(top.getX(), top.getY()); }
						s.pop();
						T.PrintaKenKen();
					}
					else {
						Cella top = s.peek();
						if (top.getNumero() != -1) {
							auxiliar.setNumero(top.getX(), top.getY(), top.getNumero());
						}
						else { auxiliar.borra(top.getX(), top.getY()); }
						s.pop();
						T.PrintaRegioKenKen();
						auxiliar.PrintaSolucio();	
					}
						
				}
				break;
			case 3:	//funciona
				if (T.getNumCeldasRellenas() < T.getNumCeldas()) {
					if (K.getNumCeldasRellenas() != K.getNumCeldas()) {
						System.out.println("Aplicant la pista. Aquesta acci� pot trigar una estona");
						System.out.println("Presiona 1 si vols triar una altra opcio");
						while (K.getNumCeldasRellenas() != K.getNumCeldas() && ns.nextInt() != 1);
					}
					else {
						if (pistes_demanades < T.getAlto()-2) {
							Cella ret = new Cella();
							findcellabuida(T,ret);
							System.out.println("Pista a les coordenades (" + ret.getX() + "," + ret.getY() + ") amb valor " 
									+ K.getNumero(ret.getX(), ret.getY()));
							T.setNumero(ret.getX(), ret.getY(), K.getNumero(ret.getX(), ret.getY()));
							T.PrintaKenKen();
							++pistes_demanades;
							if (T.getNumCeldasRellenas() == T.getNumCeldas()) {
								KenKenCheck KC = new KenKenCheck();
								if (KC.checkKenKen(T)) {
									System.out.println("Enhorabona! La solucio es correcta");
								}
								else {
									System.out.println("Aquesta solucio no es correcta");
								}
							}
						}
						else { System.out.println("Ja has demanat el maxim de pistes permeses"); }
					}
				}
				else { System.out.println("El taulell ja esta� ple"); }
				break;
			/* Pausar partida */
			case 4:
				/* 
				 * Es para el temps de la partida
				 * System.out.println("Prem 1 per continuar la partida");
				 * while (ns.nextInt()!= 1){}
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
				break;/*
				 * Es guarda l'estat actual de la partida (valors introduits i temps jugat)
				 * P.guardarKenKenKen();
				 */
			case 7:
				if (T.getNumCeldasRellenas() == T.getNumCeldas()) {
					KenKenCheck KC = new KenKenCheck();
					if (!KC.checkKenKen(T)) {
						System.out.println("Enhorabona! La solucio es correcta");
					}
					else {
						System.out.println("Aquesta solucio no es correcta");
					}
				}
			}
			System.out.println("Opcions");
			System.out.println("1. Introduir numero \t 2. Undo \t\t 3. Demanar Pista");
			System.out.println("4. Pausa \t\t 5. Guardar Partida \t 6. Reiniciar Partida");
			System.out.println("0. Sortir");
		}
		if (option == 5) {
		/*
		 * Es guarda l'estat actual de la partida (valors introduits i temps jugat)
		 * P.guardarKenKenKen();
		 */
			System.out.println("Partida guardada"); 

		}
		System.out.println("Estas sortint de la partida..."); 
	}
}
