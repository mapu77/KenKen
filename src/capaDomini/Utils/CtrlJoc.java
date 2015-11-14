package capaDomini.Utils;

import java.io.*;
import capaPersistencia.*;

public class CtrlJoc {
	
	private CtrlPersistencia CP;
	private String pathTaulers = "./data/Taulers/";
	private String pathGuardats = "./data/Saved/";
	
	public CtrlJoc() {
		CP = new CtrlPersistencia();
	}
	
	public TaulerKenKen llegeixTauler(String id, String D) {
		TaulerKenKen K = null;
		try {
			FileInputStream fileIn = new FileInputStream(pathTaulers + D + "/" + id + ".txt");
	        ObjectInputStream in = new ObjectInputStream(fileIn);
	        K = (TaulerKenKen) in.readObject();
	        in.close();
	        fileIn.close();
		}
		catch(IOException i) {
	         i.printStackTrace();
	         return K;
	    }
		catch (ClassNotFoundException c) {
	         System.err.println("No existeix Tauler");
	         c.printStackTrace();
	         return K;
	    }
		return K;
	}

	public boolean existeixPartidaGuardada() {

		return false;
	}

	/* S'asumeix que existeix partida del usuari u */
	public TaulerKenKen loadPartidaGuardada(String u) {
		TaulerKenKen K = null;
		try {
			FileInputStream fileIn = new FileInputStream(pathGuardats + "/" + u + ".txt");
	        ObjectInputStream in = new ObjectInputStream(fileIn);
	        K = (TaulerKenKen) in.readObject();
	        in.close();
	        fileIn.close();
		} catch (IOException i) {
			i.printStackTrace();
			return K;
		} catch (ClassNotFoundException c) {
			System.err.println("Ha anat malament");
	         c.printStackTrace();
	         return K;
		}
		return K;
	}
}
