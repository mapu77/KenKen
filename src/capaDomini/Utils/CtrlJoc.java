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
	private ArrayList<ArrayList<String>> TaulaJocs;
	
	public CtrlJoc() {
		CtrlPersistencia.setSeparator(" ");
		CP = new CtrlPersistencia();
	}
	
	public TaulerKenKen llegirTauler(String id, String D) {
		String path = Paths.get(pathTaulers + D + "/" + id + ".txt").toAbsolutePath().toString();
		try {
			T = CtrlPersistencia.loadTable(path);
			int n = Integer.parseInt(T.get(0).get(0));
			TaulerKenKen K = new TaulerKenKen(n);
			int nr = Integer.parseInt(T.get(1).get(0));
			for (int i=2; i<nr+2; ++i) {
				Vector<Cella> VC = new Vector<Cella>();
				int nc = Integer.parseInt(T.get(i).get(0));
				int j;
				for (j=1; j<2*nc; j+=2) {
					int x = Integer.parseInt(T.get(i).get(j));
					int y = Integer.parseInt(T.get(i).get(j+1));
					Cella c = new Cella(x,y);
					VC.add(c);
				}
				String op = T.get(i).get(j);
				int res = Integer.parseInt(T.get(i).get(j+1));
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

	
	public boolean existeixTauler(String id, String d) {
		boolean trobat = false;
		String path = Paths.get(pathTaulers + d).toAbsolutePath().toString();
		File directori = new File(path);
		String vs[] = directori.list();
		for (int i=0; i<vs.length; ++i) {
			if (vs[i].equals(id+".txt")) return true;
		}
		return false;
	}
	
	public boolean existeixPartidaGuardada(String u) {
		String path = Paths.get(pathGuardats + "/" + u + ".txt").toAbsolutePath().toString();
		File file = new File(path);
		if (file.exists()) return true;
		return false;
	}

	/* S'asumeix que existeix partida del usuari u */
	public Partida loadPartidaGuardada(String u) {
		String path = Paths.get(pathGuardats + "/" + u + ".txt").toAbsolutePath().toString();
		try {
			T = CtrlPersistencia.loadTable(path);
			Partida p = new Partida();
			p.setUsuari(T.get(0).get(0));
			p.setIdJoc(T.get(1).get(0));
			p.setD(T.get(2).get(0));
			p.setPistes(Integer.parseInt(T.get(3).get(0)));
			p.setTime(Long.parseLong(T.get(4).get(0)));
			int n = Integer.parseInt(T.get(5).get(0));
			TaulerKenKen K = new TaulerKenKen(n);
			int nr = Integer.parseInt(T.get(6).get(0));
			for (int i=7; i<nr+7; ++i) {
				Vector<Cella> VC = new Vector<Cella>();
				int nc = Integer.parseInt(T.get(i).get(0));
				int j;
				for (j=1; j<3*nc; j+=3) {
					int x = Integer.parseInt(T.get(i).get(j));
					int y = Integer.parseInt(T.get(i).get(j+1));
					int v = Integer.parseInt(T.get(i).get(j+2));
					Cella c = K.getCella(x,y);
					if (v != -1) c.setNumero(v);
					VC.add(c);
				}
				String op = T.get(i).get(j);
				int res = Integer.parseInt(T.get(i).get(j+1));
				RegioKenKen r = new RegioKenKen(nc,VC,op,res,i-7);
				K.afegeixRegio(r);
			}
			p.setK(K);
			return p;
			
		} catch (IOException e) {
			System.out.println("No existeix cap partida guardada per aquest usuari");
			e.printStackTrace();
		}
		return null;		
	}

	public int guardarTauler(TaulerKenKen K) {
		try {
			TaulaJocs = CtrlPersistencia.loadTable("data/Jocs.txt");
		} catch (IOException e1) {
			e1.printStackTrace();
		}
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
		ArrayList<String> fila = new ArrayList<String>();
		fila.add(String.valueOf(n));
		T.add(fila);
		fila = new ArrayList<String>();
		int nr = K.getNRegio();
		fila.add(String.valueOf(nr));
		T.add(fila);
		fila = new ArrayList<String>();
		for (int j=2; j<nr+2;++j) {
			int nc = K.getRegio(j-2).getNumCeldas();
			fila.add(String.valueOf(nc));
			for (int k=0; k<nc; ++k) {
				int x = K.getRegio(j-2).getCella(k).getX();
				int y = K.getRegio(j-2).getCella(k).getY();
				fila.add(String.valueOf(x));
				fila.add(String.valueOf(y));
			}
			String op = K.getRegio(j-2).getOperation();
			int res = K.getRegio(j-2).getResult();
			fila.add(op);
			fila.add(String.valueOf(res));
			T.add(fila);
			fila = new ArrayList<String>();
		}
		try {
			CtrlPersistencia.storeTable(path,T);
			fila.add(Paths.get(pathTaulers + "/" + K.getAlto() + "x" + K.getAlto() + "/" + i + ".txt").toString());
			TaulaJocs.add(fila);
			CtrlPersistencia.storeTable("data/Jocs.txt", TaulaJocs);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return i;
	}
	
	public String mostrarIdTaulers(String d) {
		String s = new String();
		String path = Paths.get(pathTaulers + d).toAbsolutePath().toString();
		File directori = new File(path);
		String vs[] = directori.list();
		for (int i=0; i<vs.length; ++i) {
			s += vs[i] + "\t";
		}
		return s;
	}
}
