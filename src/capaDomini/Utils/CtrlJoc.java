package capaDomini.Utils;

import java.io.*;
import capaPersistencia.*;

public class CtrlJoc {
	
	private CtrlPersistencia CP;
	private String pathTaulers = "/data/Taulers/";
	
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
		return null;
	}

	public boolean existeixPartidaGuardada() {

		return false;
	}

	public TaulerKenKen loadPartidaGuardada() {

		return null;
	}
}
