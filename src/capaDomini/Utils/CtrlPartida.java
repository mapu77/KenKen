package capaDomini.Utils;

import java.io.*;
import java.nio.file.Paths;
import java.util.*;

import capaDomini.Algoritmes.KenKenCheck;
import capaDomini.Algoritmes.KenKenUserSolver;
import capaPersistencia.*;

public class CtrlPartida {
	
	private Partida P;
	private boolean FI;
	private long initialTime;
	private long currentTime = 0;
	private CtrlPersistencia CP;
	private String pathPartides = "./data/Partides.txt";
	private String pathGuardats = "./data/Saved/";
	private ArrayList<ArrayList<String>> Info;
	
	public CtrlPartida(Partida p) {
		this.P = p;
		this.currentTime = p.getTime();
		this.FI = false;
		CP = new CtrlPersistencia();
		CtrlPersistencia.setSeparator(" ");
		try {
			Info = CtrlPersistencia.loadTable(pathPartides);
		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
	}
	
	/* Guarda a la BD una partida acabada */
	public void save() {
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

	/* Guarda a la BD l'estat de la partida */
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
			Scanner sn = new Scanner (System.in);
			String op = sn.next();
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
		this.initialTime = System.nanoTime();
		int option;
		P.getK().PrintaKenKen();
		Scanner ns = new Scanner(System.in);
		TaulerKenKen K = new TaulerKenKen(P.getK().getAlto());
		KenKenUserSolver KUS = new KenKenUserSolver(P.getK(),K);
		KenKenCheck KC = new KenKenCheck(P.getK());
		KUS.combinarTaulers();
		KUS.resolPerPista();
		mostrarOpcions();
		while (!FI && (option=ns.nextInt()) != 0) {
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
				KUS.getPista();
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
			/* Pausar partida */
			case 4:
				this.pause();
				while (ns.nextInt()!= 1);
				this.resume();
				break;
			/* Guardar l'estat de la partida */
			case 5:
				this.savePartida();
				break;
			/* Reiniciar partida */
			case 6:
				KUS.reinicia();
			}
			mostrarOpcions();
		}
		System.out.println("Sortint del programa...");
		if (FI) this.save();
		else {
			/* Guardar estat tauler */
			/* o marxar */
		}
	}

	public void pause() {
		this.currentTime += System.nanoTime() - initialTime;
	}
	
	public void resume() {
		this.initialTime = System.nanoTime();
	}
		
	public long getcurrentTime() {
		currentTime += System.nanoTime() - initialTime;
		return currentTime;
	}
}
