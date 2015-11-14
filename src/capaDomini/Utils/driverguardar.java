package capaDomini.Utils;

import capaDomini.Algoritmes.KenKenGenerator;

public class driverguardar {

	private static CtrlJoc CJ;
	
	private static void carregar() {
		TaulerKenKen K = CJ.llegirTauler("4","3x3");
		K.PrintaKenKen();
	}
	
	private static void guardar() {
		TaulerKenKen K = new KenKenGenerator().generateRandomly(3);
		K.PrintaKenKen();
		CJ.guardarTauler(K);
	}
	
	public static void main(String[] args) {		
		CJ = new CtrlJoc();
		guardar();
		carregar();
	}
}
