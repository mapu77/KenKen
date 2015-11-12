package capaDomini.Algoritmes;

//import java.util.*;
import capaDomini.Utils.*;

public class KenKenCheck {
	private boolean controlrepeat(TaulerKenKen T, Cella c) {
		boolean repeat = false;
		//comprovem columna
		int i = c.getX() + 1;
		int j = c.getY();
		while (i < T.getAlto() && !repeat) {
			repeat = (c.getNumero() == T.getNumero(i, j));
			i++;
		}
		//comprovem fila
		i = c.getX();
		j += 1;
		while (j < T.getAncho() && !repeat) {
			repeat = (c.getNumero() == T.getNumero(i, j));
			j++;
		}
		return repeat;
	}	
	
	public boolean checkKenKen(TaulerKenKen T) {
		int i = 0;
		boolean error = false;
		while (i<T.getNRegio() && error==false) {
			if (T.getRegio(i).checkRegionC() || T.getRegio(i).checkRegionI()) {
				i++;	
			}
			else {
				error = true;
			}
		}
		int j;
		i = j = 0;
		while (i < T.getAlto() && error==false) {
			while (j < T.getAlto() && error==false) {
				error = controlrepeat(T,T.getCella(i, j));
				j++;
			}
			i++;
		}
		return error;
	}
}