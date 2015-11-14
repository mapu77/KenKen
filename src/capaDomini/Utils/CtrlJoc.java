package capaDomini.Utils;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Vector;

import capaPersistencia.*;

public class CtrlJoc {
	
	private CtrlPersistencia CP;
	private String pathTaulers = "data/Taulells/";
	private String pathGuardats = "data/Saved/";
	private ArrayList<ArrayList<String>> T;
	private String lastId;
	
	public CtrlJoc() {
		CtrlPersistencia.setSeparator(" ");
		CP = new CtrlPersistencia();
	}
	
	public TaulerKenKen llegirTauler(String id, String D) {
		String path = Paths.get(pathTaulers + D + "/" + id + ".txt").toAbsolutePath().toString();
		try {
			T = CtrlPersistencia.loadTable(path);
			int n = Integer.parseInt(T.get(0).get(0));
			System.out.println(n);
			TaulerKenKen K = new TaulerKenKen(n);
			int nr = Integer.parseInt(T.get(1).get(0));
			System.out.println(nr);
			for (int i=2; i<nr+2; ++i) {
				Vector<Cella> VC = new Vector<Cella>();
				int nc = Integer.parseInt(T.get(i).get(0));
				System.out.println(nc);
				int j;
				for (j=1; j<2*nc; j+=2) {
					int x = Integer.parseInt(T.get(i).get(j));
					int y = Integer.parseInt(T.get(i).get(j+1));
					System.out.println(x + "," + y);
					Cella c = new Cella(x,y);
					VC.add(c);
				}
				String op = T.get(i).get(j);
				System.out.println(op);
				int res = Integer.parseInt(T.get(i).get(j+1));
				System.out.println(res);
				RegioKenKen r = new RegioKenKen(nc,VC,op,res,i-2);
				K.afegeixRegio(r);
			}
			return K;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public boolean existeixPartidaGuardada() {

		return false;
	}

	/* S'asumeix que existeix partida del usuari u */
	public TaulerKenKen loadPartidaGuardada(String u) {
		TaulerKenKen K = null;
		try {
			FileInputStream fileIn = new FileInputStream(pathGuardats + "/" + u + ".ser");
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

	public void guardarTauler(TaulerKenKen K) {
		int i = 1;
		String path = Paths.get(pathTaulers + "/" + K.getAlto() + "x" + K.getAlto() + "/" + i + ".txt").toAbsolutePath().toString();
		File file = new File(path);
		while (file.exists()) {
			++i;
			path = Paths.get(pathTaulers + "/" + K.getAlto() + "x" + K.getAlto() + "/" + i + ".txt").toAbsolutePath().toString();
			file = new File(path);
		}
		ArrayList<ArrayList<String>> T = new ArrayList<ArrayList<String>>();
		int n = K.getAlto();
		System.out.println(n);
		ArrayList<String> fila = new ArrayList<String>();
		fila.add(String.valueOf(n));
		T.add(fila);
		fila = new ArrayList<String>();
		int nr = K.getNRegio();
		System.out.println(nr);
		fila.add(String.valueOf(nr));
		T.add(fila);
		fila = new ArrayList<String>();
		for (int j=2; j<nr+2;++j) {
			int nc = K.getRegio(j-2).getNumCeldas();
			System.out.println(nc);
			fila.add(String.valueOf(nc));
			for (int k=0; k<nc; ++k) {
				int x = K.getRegio(j-2).getCella(k).getX();
				int y = K.getRegio(j-2).getCella(k).getY();
				System.out.println(x + "," + y);
				fila.add(String.valueOf(x));
				fila.add(String.valueOf(y));
			}
			String op = K.getRegio(j-2).getOperation();
			int res = K.getRegio(j-2).getResult();
			System.out.println(op + " " + res);
			fila.add(op);
			fila.add(String.valueOf(res));
			T.add(fila);
			fila = new ArrayList<String>();
		}
		System.out.println(T);
		try {
			CtrlPersistencia.storeTable(path,T);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
