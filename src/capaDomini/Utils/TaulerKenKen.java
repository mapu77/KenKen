package capaDomini.Utils;

import java.util.*;

public class TaulerKenKen extends Tauler {

	private static final long serialVersionUID = 1000L;
	private Vector<RegioKenKen> VR;
	private String autor;
	
	public TaulerKenKen() {
		super(0,0);
	}
	
	public TaulerKenKen(int n) {
		super(n, n);
		this.autor = "Sistema";
		VR = new Vector<RegioKenKen>();
	}
	
	public TaulerKenKen(int n, String autor) {
		super(n, n);
		this.autor = autor;
		VR = new Vector<RegioKenKen>();
	}

	public int nRegio(int x, int y) {
		for (int i=0; i<VR.size(); ++i) {
			for (int j=0; j<VR.get(i).getNumCeldas(); ++j) {
				Cella aux = VR.get(i).getCella(j);
				if (this.getCella(x, y).getX()==aux.getX() && this.getCella(x, y).getY()==aux.getY()) {
					return VR.get(i).getId();	
				}
			}
		}
		return -1;
	}
	
	/* Retorna si x és un nombre valid per la fila r */
	public boolean checkFila(int fila, int x) {
		for (int col=0; col<getAncho(); ++col) {
			if (getCella(fila, col).getNumero() == x) return false;
		}
		return true;
	}
	
	/* Retorna si x és un nombre vàlid per la columna c */
	public boolean checkCol(int col, int x) {
		for (int fila = 0; fila < getAlto(); ++fila) {
			if (getCella(fila, col).getNumero() == x) return false;
		}
		return true;
	}
	
	public void afegeixRegio (RegioKenKen r) {
		VR.add(r);
	}
	
	public RegioKenKen getRegio (int id) {
		return VR.get(id);
	}
	
	public int getNRegio() {
		return VR.size();
	}
	
	public RegioKenKen getRegioIJ (int x, int y) {
		for (int i=0; i<VR.size(); ++i) {
			RegioKenKen r = VR.get(i);
			for (int j=0; j<r.getNumCeldas(); ++j) {
				if (r.getCella(j).getX()==x && r.getCella(j).getY()==y) {
					return r;
				}
			}
		}
		return new RegioKenKen(0);
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
	
	private class RegioComparator implements Comparator<RegioKenKen> {
		public int compare (RegioKenKen r1, RegioKenKen r2) {
			return Integer.compare(r1.getId(), r2.getId());
		}
	}
	
	public void OrdenaVR () {
		Collections.sort(VR, new RegioComparator());
	}
	
	public void PrintaKenKen () {
		String[][] mat = new String[getAlto()*2+1][getAncho()*2+1];
		String[][] matR = new String[getAlto()*2+1][getAlto()*2+1];
		ModificaMatrius (mat,matR);
		// Printa el taulell per regions
		System.out.print("Configuracio del KenKen per regions");
		System.out.print("\n");
		for (int i=0; i<=2*getAlto(); ++i) {
			for (int j=0; j<=2*getAncho(); ++j) {
				System.out.print(matR[i][j]);
			}
			System.out.print("\n");
		}
		// Printa la solucio proposada per l'usuari
		System.out.println("\nEstat del KenKen");
		for (int i=0; i<=2*getAlto(); ++i) {
			for (int j=0; j<=2*getAncho(); ++j) {
				System.out.print(mat[i][j]);
			}
			System.out.print("\n");
		}
		// Printa l'operacio i resultat de cada regio
		System.out.println("Informacio de les regions");
		for (int k=0; k<VR.size(); ++k) {
			System.out.println("Regio num" + VR.get(k).getId() + " -> Operacio: " + VR.get(k).getOperation() +
								", Resultat: " + VR.get(k).getResult());
		}
	}
	
	public void PrintaSolucio() {
		String[][] mat = new String[getAlto()*2+1][getAncho()*2+1];
		String[][] matR = new String[getAlto()*2+1][getAlto()*2+1];
		ModificaMatrius (mat,matR);
		// Printa la solucio proposada per l'usuari
		System.out.println("\nEstat del KenKen");
		for (int i=0; i<=2*getAlto(); ++i) {
			for (int j=0; j<=2*getAncho(); ++j) {
				System.out.print(mat[i][j]);
			}
			System.out.print("\n");
		}
		System.out.println("Informacio de les regions");
		// Printa l'operacio i resultat de cada regio
		for (int k=0; k<VR.size(); ++k) {
			System.out.println("Regio num" + VR.get(k).getId() + " -> Operacio: " + VR.get(k).getOperation() +
								", Resultat: " + VR.get(k).getResult());
		}
	}
	
	public void PrintaRegioKenKen () {
		String[][] mat = new String[getAlto()*2+1][getAncho()*2+1];
		String[][] matR = new String[getAlto()*2+1][getAlto()*2+1];
		ModificaMatrius (mat,matR);
		// Printa el taulell per regions
		System.out.print("Configuracio del KenKen per regions");
		System.out.print("\n");
		for (int i=0; i<=2*getAlto(); ++i) {
			for (int j=0; j<=2*getAncho(); ++j) {
				System.out.print(matR[i][j]);
			}
			System.out.print("\n");
		}
		// Printa l'operacio i resultat de cada regio
		System.out.println("Informacio de les regions");
		for (int k=0; k<VR.size(); ++k) {
			System.out.println("Regio num " + VR.get(k).getId() + " -> Operacio: " + VR.get(k).getOperation() +
								", Resultat: " + VR.get(k).getResult());
		}
	}
	
	public void ModificaMatrius (String[][] mat, String[][] matR) {
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
	}
}
