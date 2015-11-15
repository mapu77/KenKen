package capaDomini.Algoritmes;

import java.util.*;

import capaDomini.Utils.*;
import excepciones.*;


public class KenKenUserSolver {
	
	private TaulerKenKen t1;
	private TaulerKenKen t2;
	private Stack<Cella> s = new Stack<Cella>();
	private int pistes_demanades = 0;
	private Scanner ns = new Scanner(System.in);
	
	public KenKenUserSolver() {}

	public KenKenUserSolver(TaulerKenKen T1, TaulerKenKen T2) {
		this.t1 = T1;
		this.t2 = T2;
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
			introdueixvalor(t1,x,y,val);
			t1.PrintaKenKen();
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
			Cella top = s.peek();
			if (top.getNumero() != -1) {
				t1.setNumero(top.getX(), top.getY(), top.getNumero());
			}
			else { t1.borra(top.getX(), top.getY()); }
			s.pop();
			t1.PrintaKenKen();	
		}
	}
	
	public void getPista() {
		if (t1.getNumCeldasRellenas() < t1.getNumCeldas()) {
			if (pistes_demanades == 0) {
				System.out.println("Tingues en compte que la solucio dun KenKen no es unica.\n"
						+ "El fet de demanar una pista pot alterar la teva solucio proposada.\n"
						+ "Presiona 1 si vols rebre una pista, 0 en cas contrari.");
			}
			if (pistes_demanades > 0 || ns.nextInt() == 1) 	{		
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
	
	public void resolPerPista() {
		KenKenSolver KS = new KenKenSolver();
		KS.backtrackingSolver(t2);
		System.out.println("Ja es pot utilitzar la opcio \"Demanar Pista\"");
	}
	
	public void combinarTaulers() {
		for (int i=0; i < t1.getNRegio(); i++) {
			Vector <Cella> vc = new Vector<Cella>();
			for (int j=0; j < t1.getRegio(i).getNumCeldas(); j++) {
				Cella c1 = t1.getRegio(i).getCella(j);
				Cella c2 = t2.getCella(c1.getX(), c1.getY());
				c2.setNumero(c1.getNumero());
				vc.add(c2);
			}
			RegioKenKen r = new RegioKenKen(t1.getRegio(i).getNumCeldas(),vc,t1.getRegio(i).getOperation(),
					t1.getRegio(i).getResult(),i);
			t2.afegeixRegio(r);
		}
	}
	
		/*KenKenUserSolver p = new KenKenUserSolver(T,K,auxiliar);
		new Thread(p).start();*/
}
