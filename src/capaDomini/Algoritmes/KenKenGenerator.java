package capaDomini.Algoritmes;

import java.util.*;

import capaDomini.Utils.*;
import java.util.Random;

public class KenKenGenerator {
	
	private static TaulerKenKen K;
        private static TaulerKenKen t2;
	private int n;
	private static boolean fi;
	private int X[] = {1,0,-1,0};
	private int Y[] = {0,1,0,-1};
	private static double probStop;
	
	public KenKenGenerator() {
            
	}

	private void backtrackingGenerateNumbers(int i, int j) {
		if (i == K.getAlto()) {
			fi = true;
		}
		else {
			Vector<Boolean> used = new Vector<>();
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
			if (vOps[i].equals(op)) return i;
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
                                t2.setNumero(i, j, K.getNumero(i, j));
                                //t2.PrintaKenKen();
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
                            t2.setNumero(i, j, K.getNumero(i, j));
                            K.borra(i,j);
			}
		}
	}
	
	public TaulerKenKen generateRandomly(int size) {
            n = size;
            fi = false;
            K = new TaulerKenKen(n);
            t2 = new TaulerKenKen(n);
            backtrackingGenerateNumbers(0,0);
            generateRegions();
            generateRegionSolution();
            return K;
	}
        
        public TaulerKenKen solution() {
            return t2;
        }
	
	public TaulerKenKen generateKenKenbyParameters(int size, int iniX, ArrayList<String> vOps) {
            fi = false;
            n = size;
            K = new TaulerKenKen(n);
            t2 = new TaulerKenKen(n);
            backtrackingGenerateNumbers(0,0);
            regions1C (iniX);
            generateRegions();
            K.OrdenaVR();
            String[] Vops = new String[vOps.size()];
            for (int i=0; i<vOps.size(); ++i) Vops[i] = vOps.get(i);
            generateRegionSolutionByOps (Vops);
            return K;
	}
	
	public static TaulerKenKen generateKenKenbyUser(int[][] mat, ArrayList<String> ops) {
            int N = mat.length;
            K = new TaulerKenKen(N);
            t2 = new TaulerKenKen(N);
            Vector<Vector<Cella>> Vvc = new Vector<>();
            for (int i=0; i<ops.size();++i) Vvc.add(new Vector<>());
            
            for (int i=0; i<N; i++) {
                for (int j=0; j<N; j++) {
                    Cella c = K.getCella(i, j);
                    Vvc.get(mat[i][j]).add(c);
                }
            }
            
            for (int i=0; i<ops.size(); i++) {
                String op = ops.get(i).substring(0, 1);
                String res = ops.get(i).substring(1);
                RegioKenKen r = new RegioKenKen(Vvc.get(i).size(),Vvc.get(i),op,Integer.parseInt(res),i);
                K.afegeixRegio(r);
            }
            return K;
	}
	
}