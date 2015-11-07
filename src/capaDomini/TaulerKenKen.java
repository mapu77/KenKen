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
	
	public void afegeixRegio (RegioKenKen r) {
		VR.add(r);
	}

	public RegioKenKen getRegio (int id) {
		return VR.get(id);
	}
	
	public void setNumeroRegio (int x, int y, int value) {
		for (int i=0; i<VR.size(); ++i) {
			for (int j=0; j<this.getRegio(i).getNumCeldas(); ++j) {
				Cella c = this.getRegio(i).getCella(j);
				if (c.getX()==x && c.getY()==y) {
					c.setNumero(value);
				}
			}
		}
	}
	
	public void PrintaKenKen () {
		String[][] mat, matR;
		mat = new String[getAlto()*2+1][getAncho()*2+1];
		matR = new String[getAlto()*2+1][getAlto()*2+1];
		int r1,r2;
		for (int i=0; i<=getAlto()*2; ++i) {
			for (int j=0; j<=getAncho()*2; ++j) {
				if ((i == 0 || i == getAlto()*2) && !(j == 0 || j == 2*getAncho())) { 
					mat[i][j] = matR[i][j] = "-"; 
				}
				else if ((j == 0 || j == getAncho()*2) && !(i == 0 || i == 2*getAlto())) {
					mat[i][j] = matR[i][j] = "|";
				}
				else if ((i==0 && (j==0 || j==2*getAncho())) || (i==2*getAlto() && (j==0 || j==2*getAncho()))) {
					mat[i][j] = matR[i][j] = "+";
				}
				else {
					if (i%2 != 0 && j%2 != 0) {
						mat[i][j] = Integer.toString(this.getNumero(i/2, j/2));
						matR[i][j] = Integer.toString(this.nRegio(i/2, j/2));
						if (j+2 < 2*getAncho()) {
							r1 = this.nRegio(i/2, j/2);
							r2 = this.nRegio(i/2, (j/2)+1);
							if (r1 != r2) {
								mat[i][j+1] = matR[i][j+1] = "|";
							}
							else {
								mat[i][j+1] = matR[i][j+1] = " ";
							}
						}
						if (i+2 < 2*getAlto()) {
							r1 = this.nRegio(i/2, j/2);
							r2 = this.nRegio((i/2)+1, j/2);
							if (r1 != r2) {
								mat[i+1][j] = matR[i+1][j] = "-";
							}
							else {
								mat[i+1][j] = matR[i+1][j] = " ";
							}
						}
					}
					else if (i%2 == 0 && j%2 == 0) {
						mat[i][j] = matR[i][j] = "+";
					}
				}
			}
		}
		// Printa el taulell per regions
		System.out.print("\n");
		for (int i=0; i<=2*getAlto(); ++i) {
			for (int j=0; j<=2*getAncho(); ++j) {
				System.out.print(matR[i][j]);
			}
			System.out.print("\n");
		}
		// Printa la soluci� proposada per l'usuari
		System.out.println("\\\\\\\\\\\\\\\\\\\\\\\\\\\\");
		for (int i=0; i<=2*getAlto(); ++i) {
			for (int j=0; j<=2*getAncho(); ++j) {
				System.out.print(mat[i][j]);
			}
			System.out.print("\n");
		}
		// Printa l'operaci� i resultat de cada regi�
		for (int k=0; k<VR.size(); ++k) {
			System.out.println("Regio num" + VR.get(k).getId() + " -> Operacio: " + VR.get(k).getOperation() +
								", Resultat: " + VR.get(k).getResult());
		}
	}
}
