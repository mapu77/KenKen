package capaDomini;

import java.util.*;

public class TaulerKenKen extends Tauler {

	private Vector<RegioKenKen> VR;
	
	public TaulerKenKen(int m, int n) {
		super(m, n);
		VR = new Vector<RegioKenKen>();
	}
	
	public int nRegio(Cella c) {
		for (int i=0; i<VR.size(); ++i) {
			for (int j=0; j<VR.get(i).getNumCeldas(); ++j) {
				Cella aux = VR.get(i).getCella(j);
				if (aux.getX() == c.getX() && aux.getY() == c.getY()) return VR.get(i).getId();	
			}
		}
		return 0;
	}
	
	public void afegeixRegio (RegioKenKen r) {
		VR.add(r);
	}

	public void PrintaKenKen () {
	/*	for (int i=-1; i<=alto; ++i) {
			for (int j=-1; j<=ancho; ++j) {
				if (i == -1 || i == alto) System.out.print("- ");
				else if (j == -1 || j == alto) System.out.print("|");
				else System.out.print(this.getNumero(i,j) + " ");
			}
			System.out.println(" ");
		}*/
		//Vector<Vector<String> > mat = new Vector<Vector<String> >();
		String[][] mat;
		mat = new String[alto*2+1][ancho*2+1];
		for (int i=0; i<=alto*2; ++i) {
			for (int j=0; j<=ancho*2; ++j) {
				if ((i == 0 || i == alto*2) && !(j == 0 || j == 2*ancho)) mat[i][j] = "-";
				else if ((j == 0 || j == ancho*2) && !(i == 0 || i == 2*alto)) mat[i][j] = "|";
				else if ((i==0 && (j==0 || j==2*ancho)) || (i==2*alto && (j==0 || j==2*ancho))) mat[i][j] = " ";
				else {
					if (i%2 != 0 && j%2 != 0) {
						
						mat[i][j] = Integer.toString(this.getNumero(i/2, j/2));
						if (j+2 < 2*ancho) {
							int r1 = this.nRegio(this.getCella(i/2, j/2));
							int r2 = this.nRegio(this.getCella(i/2, j/2+1));
							System.out.print(r1 + "-" + r2 + " ");
							//if (r1 != r2) mat[i][j+1] = "|";
							//else mat[i][j] = " ";
						}/*
						if (i+2 < 2*alto) {
							int r1 = this.nRegio(this.getCella(i/2, j/2));
							int r2 = this.nRegio(this.getCella(i/2+1, j/2));
							if (r1 != r2) mat[i+1][j] = "-";
							else mat[i][j] = " ";
						}*/
					}
					else { mat[i][j] = "+"; }
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
