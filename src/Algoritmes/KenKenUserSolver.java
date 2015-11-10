package Algoritmes;

import java.util.*;

import capaDomini.*;

public class KenKenUserSolver {

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
		int option;
		Stack<Cella> s = new Stack<Cella>();
		while ((option = sn.nextInt())!= 0) {
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
			case 3:	//no funciona -> clonar taulell
				int randx = new Random().nextInt(T.getAlto());
				int randy = new Random().nextInt(T.getAlto());
				while (!(T.getCella(randx, randy).estaVacia()));
				TaulerKenKen K = T;
				KenKenSolver KS = new KenKenSolver();
				KS.backtrackingSolver(K);
				T.setNumero(randx, randy, K.getNumero(randx, randy));
				T.PrintaKenKen();
				break;
			case 4:
				break;
			case 5:
				break;
			case 6:	//funciona
				for (int i = 0; i < T.getAlto(); i++) {
					for (int j = 0; j < T.getAncho(); j++) {
						if (!(T.getCella(i, j).estaVacia())) 
							T.borra(i, j);
					}
				}
				T.PrintaKenKen();
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
		}
		sn.close();
	}
}