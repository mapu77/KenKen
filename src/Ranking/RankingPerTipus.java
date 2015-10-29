package Ranking;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class RankingPerTipus extends Ranking {
	private Dificultat d;
	private String usuari;
	private int nEntrades;
	
	
	public RankingPerTipus (Dificultat d, int nEntrades){
		this.nEntrades=nEntrades;
		this.d=d;
	}
	

	public void setnEntrades(int nEntrades) {
		this.nEntrades = nEntrades;
	}
	
	public int getnEntrades() {
		try {
			this.nEntrades = 0;
			// Obrim l'arxiu
            FileInputStream fstream = new FileInputStream("C:\\Users\\Jordi\\workspace\\KenKenP\\src\\Ranking\\Jocs.txt");
            // Creem l'objecte d'entrada
            DataInputStream entrada = new DataInputStream(fstream);
            // Creem el buffer de lectura
            BufferedReader buffer = new BufferedReader(new InputStreamReader(entrada));
            // Llegim l'arxiu línia per línia
            while (buffer.readLine() != null)   {
                // Incrementem nJocs
                this.nEntrades++;
            }
            // Tanquem l'arxiu
            entrada.close();
        }
		catch (Exception e){ //Catch d'excepcions
            System.err.println("Hi ha hagut un error: " + e.getMessage());
        }
		return this.nEntrades;
	}

	public Dificultat getd() {
		return d;
	}
	
	


	
	
	
}
