package capaDomini.Utils;

import java.io.*;
import java.util.*;

import capaDomini.Algoritmes.KenKenCheck;
import capaDomini.Algoritmes.KenKenUserSolver;
import capaPersistencia.*;

public class CtrlPartida {
	
	private Partida P;
	private long initialTime;
	private long currentTime = 0;
	private CtrlPersistencia CP;
	private String pathPartides = "./data/Partides.txt";
	private String pathGuardats = "./data/Saved/";
	private ArrayList<ArrayList<String>> Info;
	
	public CtrlPartida(Partida p) {
		this.P = p;
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
		try {
	         FileOutputStream fileOut = new FileOutputStream(pathGuardats + P.getUsuari() + ".txt");
	         ObjectOutputStream out = new ObjectOutputStream(fileOut);
	         out.writeObject(P.getK());
	         out.close();
	         fileOut.close();
	         System.out.printf("Serialized data is saved in " + pathGuardats + P.getUsuari() + ".txt");
	    } catch(IOException i) {
	    	System.err.println(i.getMessage());
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
		Scanner ns = new Scanner(System.in);
		KenKenUserSolver KUS = new KenKenUserSolver();
		mostrarOpcions();
		while ((option=ns.nextInt()) != 0 && option != 5) {
			switch (option) {
			case 1:	//funciona
				KUS.entraCella();
				break;
			case 2:	//funciona
				KUS.undo();
				break;
			case 3:	//funciona
				KUS.getPista();
				break;
			/* Pausar partida */
			case 4:
				this.pause();
				while (ns.nextInt()!= 1);
				this.resume();
				break;
			case 5:
				this.saveKenKen();
				break;
			case 6:	//funciona
				KUS.reinicia();
			}
			System.out.println("Opcions");
			System.out.println("1. Introduir numero \t 2. Undo \t\t 3. Demanar Pista");
			System.out.println("4. Pausa \t\t 5. Guardar Partida \t 6. Reiniciar Partida");
			System.out.println("0. Sortir");
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
