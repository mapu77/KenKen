package capaDomini.Utils;

import java.io.*;
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

	/* Guarda a la BD l'estat del KenKen */
	public void saveKenKen() {
		
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
		Scanner ns = new Scanner(System.in);
		TaulerKenKen K = new TaulerKenKen(P.getK().getAlto());
		TaulerKenKen aux = new TaulerKenKen(P.getK().getAlto());
		KenKenUserSolver KUS = new KenKenUserSolver(P.getK(),K,aux);
		KUS.combinarTaulers();
		mostrarOpcions();
		while ((option=ns.nextInt()) != 0 && !FI) {
			switch (option) {
			/* Introduir valor */
			case 1:	//funciona
				KUS.entraCella();
				/*if () {
					if () {
						FI = true;	
					}
				}*/
				break;
			/* Undo */
			case 2:	//funciona
				KUS.undo();
				break;
			/* Demanar pista */
			case 3:	//funciona
				KUS.getPista();
				break;
			/* Pausar partida */
			case 4:
				this.pause();
				while (ns.nextInt()!= 1);
				this.resume();
				break;
			/* Guardar l'estat de la partida */
			case 5:
				this.saveKenKen();
				break;
			/* Reiniciar partida */
			case 6:	//funciona
				KUS.reinicia();
			}
			System.out.println("Opcions");
			System.out.println("1. Introduir numero \t 2. Undo \t\t 3. Demanar Pista");
			System.out.println("4. Pausa \t\t 5. Guardar Partida \t 6. Reiniciar Partida");
			System.out.println("0. Sortir");
		}
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
