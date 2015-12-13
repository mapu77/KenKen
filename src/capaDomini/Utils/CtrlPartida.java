package capaDomini.Utils;

import java.io.*;
import java.nio.file.Paths;
import java.util.*;

import capaDomini.Algoritmes.KenKenCheck;
import capaDomini.Algoritmes.KenKenSolver;
import capaDomini.Algoritmes.KenKenUserSolver;
import capaDomini.Dificultat.Dificultat;
import capaPersistencia.*;

public class CtrlPartida {
	
	private Partida P;
	private boolean FI;
	private boolean guardada;
	private long initialTime;
	private long currentTime = 0;
	private CtrlPersistencia CP;
	private String pathPartides = "./data/Partides.txt";
	private String pathGuardats = "./data/Saved/";
	private ArrayList<ArrayList<String>> Info;
        private Stack<Cella> pila;
        private TaulerKenKen p2;
        private KenKenCheck KC;
        private int pistaX, pistaY, pistaN;
	Scanner s;
	
        /**
         * Constructor del Controlador de partida
         * @param p Partida
         */
        public CtrlPartida(Partida p) {
            this.P = p;
            this.currentTime = p.getTime();
            this.FI = false;
            this.guardada = false;
            this.pila = new Stack<Cella>();
            if (P.getSol() != null) {
                this.p2 = P.getSol();
                p2.PrintaKenKen();
            }
            else this.p2 = new TaulerKenKen(P.getK().getAlto());
            KC = new KenKenCheck(P.getK());
            try {
                    Info = CtrlPersistencia.loadTable(pathPartides);
            } catch (IOException e) {
                    System.err.println(e.getMessage());
            }
            
	}
	/**
         * Guarda a la BD una partida acabada 
         */
	public void save() {
		ArrayList<String> fila = new ArrayList<String>();
		fila.add(P.getUsuari());
		fila.add(P.getIdJoc());
		fila.add(P.getD());
		fila.add(String.valueOf((double)currentTime/(double)Math.pow(10,9)));
		fila.add(String.valueOf(P.getPistes()));
		Info.add(fila);
		try {
			CtrlPersistencia.storeTable(pathPartides,Info);
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
	}

	/**
         * Guarda a la BD l'estat de la partida 
         */ 
	public void savePartida() {
		boolean guarda = true;
		String u = P.getUsuari();
		String path = Paths.get(pathGuardats + "/" + u + ".txt").toAbsolutePath().toString();
		File file = new File(path);
		if (file.exists()) {
			System.out.println("Ja existeix una partida guardada per aquest usuari");
			System.out.println("Vols sobreescriure la partida?");
			System.out.println("1-Si");
			System.out.println("2-No");
			String op = null;
			if (s.hasNext()) {
				op = s.next();
			}
			else System.out.println("no existeix op");
			if (op.equals("2")) {
				guarda = false;
			}
		}
		if (guarda) {
			ArrayList<ArrayList<String>> T = new ArrayList<ArrayList<String>>();
			for (int i=0; i<7+P.getK().getNRegio(); ++i) {
				T.add(new ArrayList<String>());
			}
			T.get(0).add(u);							//user
			T.get(1).add(String.valueOf(P.getIdJoc())); //IdTauler
			T.get(2).add(P.getD());						//Dificultat
			T.get(3).add(String.valueOf(P.getPistes()));//NumPistes
			T.get(4).add(String.valueOf(currentTime));	//CurrentTime
			//A partir d'aqui es guarda la conf del tauler
			TaulerKenKen K = P.getK();
			T.get(5).add(String.valueOf(K.getAlto()));	//N
			int nr = K.getNRegio();
			T.get(6).add(String.valueOf(nr));			//NR
			for (int i=7; i<nr+7;++i) {
				int nc = K.getRegio(i-7).getNumCeldas();//NC
				T.get(i).add(String.valueOf(nc));
				for (int k=0; k<nc; ++k) {
					int x = K.getRegio(i-7).getCella(k).getX();
					int y = K.getRegio(i-7).getCella(k).getY();
					int val = K.getRegio(i-7).getCella(k).getNumero();
					T.get(i).add(String.valueOf(x));
					T.get(i).add(String.valueOf(y));
					T.get(i).add(String.valueOf(val));
				}
				String op = K.getRegio(i-7).getOperation();
				int res = K.getRegio(i-7).getResult();
				T.get(i).add(op);
				T.get(i).add(String.valueOf(res));
			}
			try {
				CtrlPersistencia.storeTable(path,T);
				System.out.println("Partida guardada");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	private static void mostrarOpcions() {
		System.out.println("Opcions");
		System.out.println("1. Introduir numero \t 2. Undo \t\t 3. Demanar Pista");
		System.out.println("4. Pausa \t\t 5. Guardar Partida \t 6. Reiniciar Partida");
		System.out.println("0. Sortir");
	}
	
	public void play() {
		int option;
		P.getK().PrintaKenKen();
		TaulerKenKen K = new TaulerKenKen(P.getK().getAlto());
		KenKenUserSolver KUS = new KenKenUserSolver(P.getK(),K,s,P.getPistes());
		KenKenCheck KC = new KenKenCheck(P.getK());
		KUS.combinarTaulers();
		KUS.resolPerPista(K);
		mostrarOpcions();
		this.initialTime = System.nanoTime();
		while (!FI && !guardada && (s.hasNextInt()) && (option=s.nextInt()) != 0) {
			switch (option) {
			/* Introduir valor */
			case 1:
				KUS.entraCella();
				if (P.getK().getNumCeldas() == P.getK().getNumCeldasRellenas()) {	//tauler resolt
					if (!KC.checkKenKen()) {
						FI = true;
						System.out.println("Enhorabona! La solucio es correcta");
					}
					else {
						System.out.println("Aquesta solucio no es correcta");
					}
				}
				break;
			/* Undo */
			case 2:
				KUS.undo();
				break;
			/* Demanar pista */
			case 3:
				this.pause();
				int before = P.getK().getNumCeldasRellenas();
				KUS.getPista();
				int after = P.getK().getNumCeldasRellenas();
				if (after > before) P.setPistes(P.getPistes()+1);
				if (P.getK().getNumCeldas() == P.getK().getNumCeldasRellenas()) {	//tauler resolt
					if (!KC.checkKenKen()) {
						FI = true;
						System.out.println("Enhorabona! La solucio es correcta");
					}
					else {
						System.out.println("Aquesta solucio no es correcta");
					}
				}
				this.resume();
				break;
			/* Pausar partida */
			case 4:
				this.pause();
				System.out.println("Premeu 1 per continuar");
				while (s.hasNextInt() && s.nextInt()!= 1);
				this.resume();
				break;
			/* Guardar l'estat de la partida */
			case 5:
				this.pause();
				guardada = true;
				break;
			/* Reiniciar partida */
			case 6:
				KUS.reinicia();
			}		
			System.out.println("Temps jugant: " + this.getcurrentTime());
			if (!FI || !guardada) mostrarOpcions();
		}
		if (FI) this.save();
		else {
			System.out.println("Vols guardar la partida?");
			System.out.println("1-Si");
			System.out.println("2-No");
			option = 0;
			if (s.hasNextInt()) option = s.nextInt();
			else System.out.println("no hi ha option");
			if (option == 1) { 
				this.savePartida(); 
			}
		}
	}

	public void pause() {
		this.currentTime += System.nanoTime() - initialTime;
	}
	
	public void resume() {
		this.initialTime = System.nanoTime();
	}
		
        public long getTime() {
            return currentTime;
        }
        
	public double getcurrentTime() {
		currentTime += System.nanoTime() - initialTime;
		return (double)currentTime/Math.pow(10,9);
	}
        public void setcurrentTime(long t) {
            currentTime = t;
        }
        /* ------------------------------------------------------------------ */
        public void reset(){
            for (int i = 0; i < P.getK().getAlto(); i++) {
			for (int j = 0; j < P.getK().getAncho(); j++) {
				if (!(P.getK().getCella(i, j).estaVacia())) {
					P.getK().borra(i, j);
				}
			}
		}
		P.setPistes(0);
		while (!pila.empty()) pila.pop();
        }
        
        public int getNRegio() {
            return P.getK().getNRegio();
        }
        
        public int nRegio(int i, int j) {
            return P.getK().nRegio(i, j);
        }
        
        public int getRegioIJResult(int i, int j) {
            return P.getK().getRegioIJ(i, j).getResult();
        }
        
        public String getRegioIJOperation(int i, int j) {
            return P.getK().getRegioIJ(i, j).getOperation();
        }
        
        public String getStringDificultat() {
            return P.getD();
        }
        
        public int getIntDificultat() {
            return Dificultat.toInt(P.getD());
        }
        
        public int getValor(int i, int j) {
            return P.getK().getNumero(i, j);
        }
        
        public int getValorSolved(int i, int j) {
            return p2.getNumero(i,j);
        }
        
        public boolean setValor(int i, int j, int val) {
            Cella c = new Cella(i,j);
            c.setNumero(P.getK().getNumero(i, j));
            pila.addElement(c);
            P.getK().setNumero(i, j, val);
            P.getK().PrintaKenKen();
            return this.finished();
        }
        
        public boolean finished() {
            return P.getK().getNumCeldas() == P.getK().getNumCeldasRellenas();
        } 
        
        public boolean correct() {
            return !KC.checkKenKen();
        }
        
        public int undoX() {
            if (!pila.empty()) {
                Cella aux = pila.peek();
                return aux.getX();
            }
            return -1;
        }
        
        public int undoY() {
            if (!pila.empty()) {
                Cella aux = pila.peek();
                return aux.getY();
            }
            return -1;
        }
        public int undoN() {
            Cella aux = pila.pop();
            if (aux.getNumero() != -1) {
                P.getK().setNumero(aux.getX(), aux.getY(), aux.getNumero());
            }
            else { 
                P.getK().borra(aux.getX(), aux.getY()); 
            }
            P.getK().PrintaKenKen();
            return aux.getNumero();
        }
        
        public void saveToRank() {
		ArrayList<String> fila = new ArrayList<String>();
		fila.add(P.getUsuari());
		fila.add(P.getIdJoc());
		fila.add(P.getD());
		fila.add(String.valueOf(currentTime));
		fila.add(String.valueOf(P.getPistes()));
		Info.add(fila);
		try {
			CtrlPersistencia.storeTable(pathPartides,Info);
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
	}
        
        public void saveState() {
            String u = P.getUsuari();
            String path = Paths.get(pathGuardats + "/" + u + ".txt").toAbsolutePath().toString();
            ArrayList<ArrayList<String>> T = new ArrayList<ArrayList<String>>();
            for (int i=0; i<7+P.getK().getNRegio(); ++i) {
                    T.add(new ArrayList<String>());
            }
            T.get(0).add(u);							//user
            T.get(1).add(String.valueOf(P.getIdJoc())); //IdTauler
            T.get(2).add(P.getD());						//Dificultat
            T.get(3).add(String.valueOf(P.getPistes()));//NumPistes
            T.get(4).add(String.valueOf(currentTime));	//CurrentTime
            //A partir d'aqui es guarda la conf del tauler
            TaulerKenKen K = P.getK();
            T.get(5).add(String.valueOf(K.getAlto()));	//N
            int nr = K.getNRegio();
            T.get(6).add(String.valueOf(nr));			//NR
            for (int i=7; i<nr+7;++i) {
                    int nc = K.getRegio(i-7).getNumCeldas();//NC
                    T.get(i).add(String.valueOf(nc));
                    for (int k=0; k<nc; ++k) {
                            int x = K.getRegio(i-7).getCella(k).getX();
                            int y = K.getRegio(i-7).getCella(k).getY();
                            int val = K.getRegio(i-7).getCella(k).getNumero();
                            T.get(i).add(String.valueOf(x));
                            T.get(i).add(String.valueOf(y));
                            T.get(i).add(String.valueOf(val));
                    }
                    String op = K.getRegio(i-7).getOperation();
                    int res = K.getRegio(i-7).getResult();
                    T.get(i).add(op);
                    T.get(i).add(String.valueOf(res));
            }
            try {
                    CtrlPersistencia.storeTable(path,T);
                    System.out.println("Partida guardada");
            } catch (IOException e) {
                    e.printStackTrace();
            }
        }
        
        public void clonarTauler() {
            for (int i=0; i < P.getK().getNRegio(); i++) {
                Vector <Cella> vc = new Vector<>();
                for (int j=0; j < P.getK().getRegio(i).getNumCeldas(); j++) {
                        Cella c1 = P.getK().getRegio(i).getCella(j);
                        Cella c2 = p2.getCella(c1.getX(), c1.getY());
                        c2.setNumero(c1.getNumero());
                        vc.add(c2);
                }
                RegioKenKen r = new RegioKenKen(P.getK().getRegio(i).getNumCeldas(),vc,P.getK().getRegio(i).getOperation(),
                                P.getK().getRegio(i).getResult(),i);
                p2.afegeixRegio(r);
            }
        }
         
        public void resoldrePerPista() {
            if (!(p2.getNumCeldasRellenas() == p2.getNumCeldas())) {
                KenKenSolver KS = new KenKenSolver();
                KS.backtrackingSolver(p2);
            }
        }
        
        public boolean resolem() {
            return (p2.getNumCeldasRellenas() != p2.getNumCeldas());
        }
        
        public boolean getPista() {
            int randx = new Random().nextInt(P.getK().getAlto());
            int randy = new Random().nextInt(P.getK().getAncho());
            if (p2.getNumero(randx, randy) != P.getK().getNumero(randx, randy)) {
                P.getK().setNumero(randx, randy, p2.getNumero(randx,randy));
                pistaX = randx;
                pistaY = randy;
                pistaN = p2.getNumero(randx, randy);
            }
            else getPista();
            return finished();
        }
        
        public int getPistaX() {
            return  pistaX;
        }
        
        public int getPistaY() {
            return pistaY;
        }
        
        public int getPistaN() {
            P.setPistes(P.getPistes()+1);
            return pistaN;
        }
        
        public void borrar(int i, int j) {
            Cella c = new Cella(i,j);
            c.setNumero(P.getK().getNumero(i, j));
            pila.addElement(c);
            P.getK().borra(i, j);
            P.getK().PrintaKenKen();
        }
        
        public int getNPistes() {
            return P.getPistes();
        }
}
