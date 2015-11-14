package capaDomini.Algoritmes;

//import java.util.*;
import capaDomini.Utils.*;

public class KenKenCheck {
	/*public KenKenCheck(TaulerKenken T) {
		
	}*/
	
	private boolean ctrlFilaAndCol (TaulerKenKen T, Cella c) {
		boolean repeat = false;
		int i = c.getX();
		int j = c.getY();
		int incr = 1;
		while((j+incr < T.getAncho() || i+incr < T.getAlto()) && !repeat) {
			if (j+incr < T.getAncho()) {
				repeat = (c.getNumero() == T.getNumero(i, j+incr));
			}
			if (i+incr < T.getAncho() && !repeat) {
				repeat = (c.getNumero() == T.getNumero(i+incr, j));
			}
			incr++;
		}
		return repeat;
	}
	
	private boolean ctrlRegio (TaulerKenKen T) {
		int i = 0;
		boolean mistake = false;
		while (i < T.getNRegio() && !mistake) {
			mistake = (T.getRegio(i).checkRegionC());
			i++;
		}
		return mistake;
	}
	
	public boolean checkKenKen(TaulerKenKen T) {
		boolean error = ctrlRegio(T);
		if (!error) {
			int i;
			int j;
			i = j = 0;
			while (i < T.getAlto() && !error) {
				while (j < T.getAncho() && !error) {
					error = ctrlFilaAndCol(T,T.getCella(i, j));
				}
			}
		}
		return error;
	}
}