package capaDomini.Algoritmes;

import capaDomini.Utils.*;

public class KenKenCheck {
	TaulerKenKen t1;
	
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
			}
			if (i+incr < t1.getAncho() && !repeat) {
				repeat = (c.getNumero() == t1.getNumero(i+incr, j));
			}
			incr++;
		}
		return repeat;
	}
	
	private boolean ctrlRegio () {
		int i = 0;
		boolean mistake = false;
		while (i < t1.getNRegio() && !mistake) {
			//mistake = (t1.getRegio(i).checkRegionC());
			if (t1.getRegio(i).checkRegionC()) {
				mistake = false;
			}
			else {
				mistake = true;
			}
			i++;
		}
		return mistake;
	}
	
	public boolean checkKenKen() {
		boolean error = ctrlRegio();
		if (!error) {
			int i = 0;
			while (i < t1.getAlto() && !error) {
				int j = 0;
				while (j < t1.getAncho() && !error) {
					error = ctrlFilaAndCol(t1.getCella(i, j));
					j++;
				}
				++i;
			}
		}
		return error;
	}
}