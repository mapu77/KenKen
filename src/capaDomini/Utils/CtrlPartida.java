package capaDomini.Utils;

import java.io.*;
import java.util.*;
import capaPersistencia.*;

public class CtrlPartida {
	
	private Partida P;
	private long initialTime;
	private long currentTime = 0;
	private CtrlPersistencia CP;
	private String pathPartides = "/data/Partides.txt";
	private String pathGuardats = "/data/Saved/";
	private ArrayList<ArrayList<String>> Info;
	
	public CtrlPartida(Partida p) {
		this.P = p;
		CP = new CtrlPersistencia();
		CtrlPersistencia.setSeparator(" ");
		try {
			Info = CP.loadTable(pathPartides);
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
			CP.storeTable(pathPartides,Info);
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
	
	public void play() {
		this.initialTime = System.nanoTime();
	}

	public void stop() {
		this.currentTime += System.nanoTime() - initialTime;
	}
	
	public void resume() {
		this.initialTime = System.nanoTime();
	}
		
	public long getcurrentTime() {
		currentTime = System.nanoTime() - initialTime;
		return currentTime;
	}	
}
