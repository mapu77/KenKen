package capaDomini.Algoritmes;

import java.util.*;

import capaDomini.Utils.*;
import excepciones.*;


public class KenKenUserSolver {
	
	private TaulerKenKen t1;
	private TaulerKenKen t2;
	private TaulerKenKen t3;
	private Stack<Cella> s = new Stack<Cella>();
	private int pistes_demanades = 0;
	private Scanner ns = new Scanner(System.in);
	
	public KenKenUserSolver() {}

	public KenKenUserSolver(TaulerKenKen T1, TaulerKenKen T2, TaulerKenKen T3) {
		this.t1 = T1;
		this.t2 = T2;
		this.t3 = T3;
	}
	
	public void entraCella() {
		System.out.println("Indica les coordenades(format: x y)");
		try {
			int x = ns.nextInt();
			int y = ns.nextInt();
			if ((x<0 || x>=t1.getAlto()) || (y<0 || y>=t1.getAncho())) throw (new ExcepcionPosicionFueraRango());
			System.out.println("Indica el valor a afegir");
			int val = ns.nextInt();
			if (val<=0 || val>t1.getAlto()) throw (new ExcepcionValorFueraRango());
			if (t2.getNumCeldasRellenas() == t2.getNumCeldas()) {
				introdueixvalor(t1,x,y,val);
				t1.PrintaKenKen();
			}
			else {
				introdueixvalor(t3,x,y,val);
				t3.PrintaRegioKenKen();
				t3.PrintaSolucio();
			}
		} catch (ExcepcionPosicionFueraRango e) {
			System.out.println(e.getMessage());
		} catch (ExcepcionValorFueraRango e) {
			System.out.println(e.getMessage());
		}
	}
	
	private void introdueixvalor(TaulerKenKen T, int x, int y, int val) {
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
	
	public void undo() {
		if (s.empty()) {System.out.println("No es pot tirar mes endarrere");}
		else {
			if (t2.getNumCeldas() == t2.getNumCeldasRellenas()) {
				Cella top = s.peek();
				if (top.getNumero() != -1) {
					t1.setNumero(top.getX(), top.getY(), top.getNumero());
				}
				else { t1.borra(top.getX(), top.getY()); }
				s.pop();
				t1.PrintaKenKen();
			}
			else {
				Cella top = s.peek();
				if (top.getNumero() != -1) {
					t3.setNumero(top.getX(), top.getY(), top.getNumero());
				}
				else { t3.borra(top.getX(), top.getY()); }
				s.pop();
				t1.PrintaRegioKenKen();
				t3.PrintaSolucio();	
			}	
		}
	}
	
	public void getPista() {
		if (t1.getNumCeldasRellenas() < t1.getNumCeldas()) {
			if (t2.getNumCeldasRellenas() != t2.getNumCeldas()) {
				System.out.println("Aplicant la pista. Aquesta accio pot trigar una estona");
				System.out.println("Presiona 1 si vols triar una altra opcio");
				while (t2.getNumCeldasRellenas() != t2.getNumCeldas() && ns.nextInt() != 1);
			}
			else {
				if (pistes_demanades < t1.getAlto()-2) {
					Cella ret = new Cella();
					findcellabuida(t1,ret);
					System.out.println("Pista a les coordenades (" + ret.getX() + "," + ret.getY() + ") amb valor " 
							+ t2.getNumero(ret.getX(), ret.getY()));
					t1.setNumero(ret.getX(), ret.getY(), t2.getNumero(ret.getX(), ret.getY()));
					t1.PrintaKenKen();
					++pistes_demanades;
				}
				else { System.out.println("Ja has demanat el maxim de pistes permeses"); }
			}
		}
		else { System.out.println("El taulell ja esta ple"); }
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
	
	public void reinicia() {
		for (int i = 0; i < t1.getAlto(); i++) {
			for (int j = 0; j < t1.getAncho(); j++) {
				if (!(t1.getCella(i, j).estaVacia())) {
					t1.borra(i, j);
				}
			}
		}
		t1.PrintaKenKen();
		pistes_demanades = 0;
	}
	
	/*public void run() {
		KenKenSolver KS = new KenKenSolver();
		KS.backtrackingSolver(t1);
		System.out.println("Ja es pot utilitzar la opcio \"Demanar Pista\"");
		KenKenCopy(t1,t2,t3);
	}*/
	
	private void KenKenCopy(TaulerKenKen sol, TaulerKenKen copia, TaulerKenKen aux) {
		for (int i = 0; i < sol.getAlto(); i++) {
			for (int j = 0; j < sol.getAncho(); j++) {
				copia.setNumero(i, j, sol.getNumero(i, j));
				sol.borra(i, j);
			}
		}
		for (int i = 0; i < sol.getAlto(); i++) {
			for (int j = 0; j < sol.getAncho(); j++) {
				if (!aux.estaVacia(i,j)) {
					sol.setNumero(i, j, aux.getNumero(i, j));
				}
			}
		}
	}
	
	public void combinarTaulers() {
		for (int i=0; i < t1.getNRegio(); i++) {
			Vector <Cella> vc = new Vector<Cella>();
			for (int j=0; j < t1.getRegio(i).getNumCeldas(); j++) {
				Cella c = new Cella();
				c.setX(t1.getRegio(i).getCella(j).getX());
				c.setY(t1.getRegio(i).getCella(j).getY());
				vc.add(c);
			}
			RegioKenKen r = new RegioKenKen(t1.getRegio(i).getNumCeldas(),vc,t1.getRegio(i).getOperation(),
					t1.getRegio(i).getResult(),i);
			t3.afegeixRegio(r);
		}
		t3.PrintaKenKen();
	}
	
		/*KenKenUserSolver p = new KenKenUserSolver(T,K,auxiliar);
		new Thread(p).start();*/
}
