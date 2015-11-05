package capaDomini;

import java.util.*;

public class TaulerKenKen extends Tauler {

	private Vector<RegioKenKen> VR;
	
	public TaulerKenKen(int n) {
		super(n, n);
		VR = new Vector<RegioKenKen>();
	}
	
	public int nRegio(int x, int y) {
		for (int i=0; i<VR.size(); ++i) {
			for (int j=0; j<VR.get(i).getNumCeldas(); ++j) {
				Cella aux = VR.get(i).getCella(j);
				if (aux.getX() == x && aux.getY() == y) return VR.get(i).getId();	
			}
		}
		return 0;
	}
	
	public RegioKenKen getRegio(int index) {
		return VR.get(index);
	}
	
	
	public void afegeixRegio (RegioKenKen r) {
		VR.add(r);
	}

	public void PrintaKenKen () {
		String[][] mat;
		mat = new String[alto*2+1][ancho*2+1];
		int r1,r2;
		for (int i=0; i<=alto*2; ++i) {
			for (int j=0; j<=ancho*2; ++j) {
				if ((i == 0 || i == alto*2) && !(j == 0 || j == 2*ancho)) mat[i][j] = "-";
				else if ((j == 0 || j == ancho*2) && !(i == 0 || i == 2*alto)) mat[i][j] = "|";
				else if ((i==0 && (j==0 || j==2*ancho)) || (i==2*alto && (j==0 || j==2*ancho))) mat[i][j] = " ";
				else {
					if (i%2 != 0 && j%2 != 0) {
						mat[i][j] = Integer.toString(this.getNumero(i/2, j/2));
						if (j+2 < 2*ancho) {
							r1 = this.nRegio(i/2, j/2);
							r2 = this.nRegio(i/2, (j/2)+1);
							if (r1 != r2) {
								mat[i][j+1] = "|";
							}
							else {
								mat[i][j+1] = " ";
							}
						}
						if (i+2 < 2*alto) {
							r1 = this.nRegio(i/2, j/2);
							r2 = this.nRegio((i/2)+1, j/2);
							if (r1 != r2) {
								mat[i+1][j] = "-";
							}
							else {
								mat[i+1][j] = " ";
							}
						}
					}
					else if (i%2 == 0 && j%2 == 0) mat[i][j] = "+";
				}
			}
		}
		System.out.print("\n");
		for (int i=0; i<=2*alto; ++i) {
			for (int j=0; j<=2*ancho; ++j) {
				System.out.print(mat[i][j]);
			}
			System.out.print("\n");
		}
	}
}
