package capaDomini.Algoritmes;

import capaDomini.Utils.*;

public class KenKenCheck {
	private TaulerKenKen t1;
	
	public KenKenCheck(TaulerKenKen T) {
		this.t1 = T;
	}
	
	private boolean ctrlFilaAndCol (Cella c) {
		boolean repeat = false;
		int i = c.getX();
		int j = c.getY();
		int incr = 1;
		while((j+incr < t1.getAncho() || i+incr < t1.getAlto()) && !repeat) {
			if (j+incr < t1.getAncho()) {
				repeat = (c.getNumero() == t1.getNumero(i, j+incr));
				if (repeat) {
					System.out.println("La cella ("+i+","+(j+incr)+") esta repetida a la seva fila");
				}
			}
			if (i+incr < t1.getAncho() && !repeat) {
				repeat = (c.getNumero() == t1.getNumero(i+incr, j));
				if (repeat) {
					System.out.println("La cella ("+(i+incr)+","+j+") esta repetida a la seva columna");
				}
			}
			incr++;
		}
		return repeat;
	}
	
	private boolean ctrlRegio (TaulerKenKen T) {
		T.PrintaKenKen();
		int i = 0;
		boolean mistake = false;
		while (i < T.getNRegio() && !mistake) {
			if (!(T.getRegio(i).checkRegionC())) {
				mistake = true;
				System.out.println("No es compleix el calcul de la regio "+i);
			}
			i++;
		}
		return mistake;
	}
	
	public boolean checkKenKen() {
		t1.PrintaKenKen();
		boolean error = false;
		int i = 0;
		while (i < t1.getAlto() && !error) {
			int j = 0;
			while (j < t1.getAncho() && !error) {
				error = ctrlFilaAndCol(t1.getCella(i, j));
				j++;
			}
			i++;
		}
		if (!error) error = ctrlRegio(t1);
		return error;
	}
}