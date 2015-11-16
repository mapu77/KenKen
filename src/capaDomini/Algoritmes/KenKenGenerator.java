package capaDomini.Algoritmes;

import java.util.*;

import capaDomini.Dificultat.Dificultat;
import capaDomini.Utils.*;
import excepciones.ExcepcionDificultatInvalida;

public class KenKenGenerator {
	
	private static TaulerKenKen K;
	private int n;
	private static boolean fi;
	private int X[] = {1,0,-1,0};
	private int Y[] = {0,1,0,-1};
	private static double probStop;
	private static Scanner sn;
	
	public KenKenGenerator(Scanner sn) {
		this.sn = sn;
	}

	private void backtrackingGenerateNumbers(int i, int j) {
		if (i == K.getAlto()) {
			fi = true;
		}
		else {
			Vector<Boolean> used = new Vector<Boolean>();
			for (int k=0; k<=K.getAncho();++k) used.add(k,false); //initialization used
			int rand = new Random().nextInt(n)+1;
			for (int ii=0; ii<K.getAncho() && !fi; ++ii) {
				while (used.get(rand)) { rand = new Random().nextInt(n)+1; }
				used.set(rand, true);
				if (K.checkFila(i,rand) && K.checkCol(j,rand)) {
					K.setNumero(i, j, rand);
					if (j+1 == K.getAncho()) {
						backtrackingGenerateNumbers(i+1,0);
					}
					else {
						backtrackingGenerateNumbers(i,j+1);
					}
				}
			}
			if (!fi) { K.getCella(i, j).borra(); }
		}
	}
	
	private boolean contains(Vector<Cella> v, Cella c) {
		for (int i=0; i<v.size(); ++i) {
			if (v.get(i).getX()==c.getX() && v.get(i).getY()==c.getY()) return true;
		}
		return false;
	}
	
	private void regions1C (int iniX) {
		int nr = -2;
		for (int i=0; i<iniX; ++i) {
			int x = new Random().nextInt(n);
			int y = new Random().nextInt(n);
			while (K.nRegio(x, y) != -1) {
				x = new Random().nextInt(n);
				y = new Random().nextInt(n);
			}
			Cella c = K.getCella(x,y);
			Vector<Cella> vc = new Vector<Cella>();
			vc.add(c);
			RegioKenKen r = new RegioKenKen(1,vc,"+",c.getNumero(),nr);
			--nr;
			K.afegeixRegio(r);
		}
	}
	
	private void generateRegions() {
		int reg_count = 0;
		for (int i=0; i<K.getAncho(); ++i) {
			for (int j=0; j<K.getAlto(); ++j) {
				if (K.nRegio(i,j) == -1) { // no te regio
					Stack<Cella> s = new Stack<Cella>();
					Vector<Cella> vc = new Vector<Cella>();
					probStop = 0.0;
					Cella c = K.getCella(i,j);
					vc.add(c);
					s.push(c);
					while ((new Random().nextDouble() > probStop) && vc.size() <= 4) { //No parem
						int rand = new Random().nextInt(4);
						int ii = s.peek().getX()+Y[rand];
						int jj = s.peek().getY()+X[rand];
						if (ii >= 0 && ii < K.getAncho() && jj >= 0 && jj < K.getAlto() && K.nRegio(ii,jj) == -1){
							Cella aux = K.getCella(ii,jj);
							if (!contains(vc,aux)) {
								vc.add(aux);
								s.push(aux);
							}
						}
						probStop += 0.05; 
					}
					RegioKenKen r = new RegioKenKen(vc.size(), vc, "+", 0, reg_count);
					++reg_count;
					K.afegeixRegio(r);
				}
				else if (K.nRegio(i, j) < -1) {
					K.getRegioIJ(i, j).setId(reg_count);
					++reg_count;
				}
					
			}
		}
	}
	
	private int comprovaOp (String[] vOps, String op) {
		for (int i=0; i<vOps.length; ++i) {
			if (vOps[i] == op) return i;
		}
		return -1;
	}
	private int comprovaDiv (RegioKenKen r) {
		int res1 = r.getCella(0).getNumero();
		int res2 = r.getCella(1).getNumero();
		int op1 = res1/res2;
		int op2 = res2/res1;
		if (op1 >= 1 && res1%res2 == 0) {
			return op1;
		}
		else if (op1 < 1 && res2%res1 ==0) {
			return op2;
		}
		return -1;
	}
	
	public void generateRegionSolutionByOps (String[] vOps) {
		boolean hi_es;
		boolean pot;
		int rand;
		for (int i=0; i<K.getNRegio(); ++i) {
			RegioKenKen r = K.getRegio(i);
			if (vOps.length == 1 || r.getNumCeldas() == 1) {
				r.setOperation("+");
				r.setResult(r.calculaRegioSuma());
			}
			else {
				switch (r.getNumCeldas()) {
				case 2:
					switch (vOps.length){
					case 2:
						if (comprovaOp(vOps,"/") != -1) {
							if (comprovaDiv(r) != -1 && new Random().nextBoolean()) {
								r.setOperation("/");
								r.setResult(r.calculaRegioDiv());
							}
							else {
								r.setOperation("+");
								r.setResult(r.calculaRegioSuma());
							}
						}
						else {
							rand = new Random().nextInt(2);
							r.setOperation(vOps[rand]);
							if (vOps[rand].equals("*")) r.setResult(r.calculaRegioMult());
							else if (vOps[rand].equals("-")) r.setResult(r.calculaRegioResta());
							else if (vOps[rand].equals("+")) r.setResult(r.calculaRegioSuma());
						}
						break;
					case 3:
						hi_es = comprovaOp(vOps,"/") != -1;
						pot = (hi_es && comprovaDiv(r) != -1);
						if (! hi_es) {
							rand = new Random().nextInt(3);
							r.setOperation(vOps[rand]);
							if (vOps[rand].equals("*")) r.setResult(r.calculaRegioMult());
							else if (vOps[rand].equals("-")) r.setResult(r.calculaRegioResta());
							else if (vOps[rand].equals("+")) r.setResult(r.calculaRegioSuma());
						}
						else {
							rand = new Random().nextInt(3);
							while (vOps[rand].equals("/") && !pot) rand = new Random().nextInt(3); 
							r.setOperation(vOps[rand]);
							if (vOps[rand].equals("*")) r.setResult(r.calculaRegioMult());
							else if (vOps[rand].equals("-")) r.setResult(r.calculaRegioResta());
							else if (vOps[rand].equals("+")) r.setResult(r.calculaRegioSuma());
							else if (vOps[rand].equals("/")) r.setResult(r.calculaRegioDiv());
						}
						break;
					case 4:
						pot = (comprovaDiv(r) != -1);
						rand = new Random().nextInt(4);
						while (vOps[rand].equals("/") && !pot) rand = new Random().nextInt(4);
						r.setOperation(vOps[rand]);
						if (vOps[rand].equals("*")) r.setResult(r.calculaRegioMult());
						else if (vOps[rand].equals("-")) r.setResult(r.calculaRegioResta());
						else if (vOps[rand].equals("+")) r.setResult(r.calculaRegioSuma());
						else if (vOps[rand].equals("/")) r.setResult(r.calculaRegioDiv());
						break;
					}
					break;
				case 3: case 4:
					if (comprovaOp(vOps,"*") != -1 && new Random().nextBoolean()) {
						r.setOperation("*");
						r.setResult(r.calculaRegioMult());
					}
					else {
						r.setOperation("+");
						r.setResult(r.calculaRegioSuma());
					}
					break;
				case 5:
					r.setOperation("+");
					r.setResult(r.calculaRegioSuma());
					break;
				}
			}
		}
		
		// Traiem els numeros del tauler
		for (int i=0; i<K.getAlto(); ++i) {
			for (int j=0; j<K.getAncho(); ++j) {
				K.borra(i,j);
			}
		}
	}
	
	public void generateRegionSolution() {
		for (int i=0; i<K.getNRegio(); ++i) {
			RegioKenKen r = K.getRegio(i);
			switch (r.getNumCeldas()) {
			case 1:
				r.setOperation("+");
				r.setResult(r.getNumero(0));
				break;
			case 2:
				int res1 = r.getCella(0).getNumero();
				int res2 = r.getCella(1).getNumero();
				int op1 = res1/res2;
				int op2 = res2/res1;
				if (op1 >= 1 && res1%res2 == 0) {
					r.setOperation("/");		
					r.setResult(op1);
				}
				else if (op1 < 1 && res2%res1 ==0) {
					r.setOperation("/");		
					r.setResult(op2);
				}
				else {
					r.setOperation("-");
					r.setResult(r.calculaRegioResta());
				}
				break;
			case 3: case 4:
				Boolean suma = new Random().nextBoolean();
				if (suma) {
					r.setOperation("+");
					r.setResult(r.calculaRegioSuma());
				}
				else {
					r.setOperation("*");
					r.setResult(r.calculaRegioMult());
				}
				break;
			default:
				r.setOperation("+");
				r.setResult(r.calculaRegioSuma());
			}
		}
		
		// Traiem els numeros del tauler
		for (int i=0; i<K.getAlto(); ++i) {
			for (int j=0; j<K.getAncho(); ++j) {
				K.borra(i,j);
			}
		}
	}
	
	public TaulerKenKen generateRandomly(int size) {
		n = size;
		fi = false;
		K = new TaulerKenKen(n);
		backtrackingGenerateNumbers(0,0);
		generateRegions();
		generateRegionSolution();
		return K;
	}
	
	public TaulerKenKen generateKenKenbyParameters() { //(int size, int iniX, String[] vOps) {
		fi = false;
		System.out.println("Mida del KenKen?");
		System.out.println("Opcions: 3x3, 4x4, 5x5, 6x6, 7x7, 8x8, 9x9");
		String d = null;
		if (sn.hasNext()) d = sn.next();
		try {
			if (Dificultat.esValida(d)) {
				n = Dificultat.toInt(d);
				K = new TaulerKenKen(n);
				backtrackingGenerateNumbers(0,0);
				System.out.println("Nombre inicial minim de regions d'una cel.la:");
				int iniX = 0;
				if (sn.hasNextInt()) iniX = sn.nextInt();
				else System.err.println("valor incorrecte");
				regions1C (iniX);
				generateRegions();
				K.OrdenaVR();
				System.out.println("Nombre de diferents operacions (minim 1, maxim 4):");
				int nOps = 0;
				if (sn.hasNextInt()) nOps = sn.nextInt();
				else System.err.println("valor incorrecte");
				System.out.println("Selecciona les " + (nOps-1) + " operacions restants (\"+\" ja s'inclou per defecte):");
				System.out.println("\"-\",\"*\",\"/\"");
				String[] vOps = new String[nOps];
				int i=1;
				vOps[0] = "+";
				while (i < nOps) {
					vOps[i] = null;
					if (sn.hasNext()) vOps[i] = sn.next();
					else System.err.println("informacio incorrecta");
					++i;
				}
				generateRegionSolutionByOps (vOps);
				return K;
			}
			else throw (new ExcepcionDificultatInvalida());
		}
		catch (ExcepcionDificultatInvalida e) {
			K = null;
			System.err.println(e.getMessage());
		}
		return K;
	}
	
	public TaulerKenKen generateKenKenbyUser() {
		System.out.println("Mida del KenKen?");
		System.out.println("Opcions: 3x3, 4x4, 5x5, 6x6, 7x7, 8x8, 9x9");
		String d = null;
		if (sn.hasNext()) d = sn.next();
		int n;
		try { 
			if (Dificultat.esValida(d)) {
				n=Dificultat.toInt(d);
				K = new TaulerKenKen(n);
				System.out.println("Nombre regions");
				int nr = 0;
				if (sn.hasNextInt()) nr = sn.nextInt();
				else System.err.println("valor incorrecte");
				for (int i=0; i<nr; ++i) {
					Vector<Cella> VC = new Vector<Cella>();
					System.out.println("Nombre de cel.les de la regio " + i);
					int nc = 0;
					if (sn.hasNextInt()) nc = sn.nextInt();
					else System.err.println("valor incorrecte");
					for (int j=0; j<nc; ++j) {
						System.out.println("Cordenades cel.la " + j + " de la regio " + i);
						int x = 0;
						int y = 0;
						if (sn.hasNextInt()) x = sn.nextInt();
						else System.err.println("valor incorrecte");
						if (sn.hasNextInt()) y = sn.nextInt();
						else System.err.println("valor incorrecte");
						Cella c = K.getCella(x,y);
						VC.add(c);
					}
					System.out.println("Operacio de la regio " + i);
					String op = null;
					if (sn.hasNext()) op = sn.next();
					else System.err.println("operacio incorrecta");
					System.out.println("Resultat de la regio " + i);
					int res = 0;
					if (sn.hasNextInt()) res = sn.nextInt();
					else System.err.println("valor incorrecte");
					RegioKenKen r = new RegioKenKen(nc,VC,op,res,i);
					K.afegeixRegio(r);
				}
				return K;
			}
			else throw (new ExcepcionDificultatInvalida());
		}
		catch (ExcepcionDificultatInvalida e) {
			K = null;
			System.err.println(e.getMessage());
		}
		return K;
	}
	
}