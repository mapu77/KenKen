package KenKen;
import java.io.*;
import java.util.*;

public class RankingGeneral extends Ranking {
	int nJocs;
	int nUsuaris;
	int nPartides;
	String popular;
		
	public int getnJocs() {
		try {
			this.nJocs = 0;
			// Obrim l'arxiu
            FileInputStream fstream = new FileInputStream("C:\\Users\\Jan\\Programes\\eclipse\\eclipse-epsilon-1.2-win32\\workspace\\KenKen_PROP\\Jocs.txt");
            // Creem l'objecte d'entrada
            DataInputStream entrada = new DataInputStream(fstream);
            // Creem el buffer de lectura
            BufferedReader buffer = new BufferedReader(new InputStreamReader(entrada));
            // Llegim l'arxiu línia per línia
            while (buffer.readLine() != null)   {
                // Incrementem nJocs
                this.nJocs++;
            }
            // Tanquem l'arxiu
            entrada.close();
        }
		catch (Exception e){ //Catch d'excepcions
            System.err.println("Hi ha hagut un error: " + e.getMessage());
        }
		return this.nJocs;
    }
	
	public int getnUsuaris() {
		try {
			this.nUsuaris = 0;
			// Obrim l'arxiu
            FileInputStream fstream = new FileInputStream("C:\\Users\\Jan\\Programes\\eclipse\\eclipse-epsilon-1.2-win32\\workspace\\KenKen_PROP\\Usuaris.txt");
            // Creem l'objecte d'entrada
            DataInputStream entrada = new DataInputStream(fstream);
            // Creem el buffer de lectura
            BufferedReader buffer = new BufferedReader(new InputStreamReader(entrada));
            // Llegim l'arxiu línia per línia
            while (buffer.readLine() != null)   {
                // Incrementem nUsuaris
                this.nUsuaris++;
            }
            // Tanquem l'arxiu
            entrada.close();
        }
		catch (Exception e){ //Catch d'excepcions
            System.err.println("Hi ha hagut un error: " + e.getMessage());
        }
		return this.nUsuaris;
	}
	
	public int getnPartides() {
		try {
			this.nPartides = 0;
			// Obrim l'arxiu
            FileInputStream fstream = new FileInputStream("C:\\Users\\Jan\\Programes\\eclipse\\eclipse-epsilon-1.2-win32\\workspace\\KenKen_PROP\\Partides.txt");
            // Creem l'objecte d'entrada
            DataInputStream entrada = new DataInputStream(fstream);
            // Creem el buffer de lectura
            BufferedReader buffer = new BufferedReader(new InputStreamReader(entrada));
            // Llegim l'arxiu línia per línia
            while (buffer.readLine() != null)   {
                // Incrementem nPartides
                this.nPartides++;
            }
            // Tanquem l'arxiu
            entrada.close();
        }
		catch (Exception e){ //Catch d'excepcions
            System.err.println("Hi ha hagut un error: " + e.getMessage());
        }
		return this.nPartides;
	}

	public String getPopular(int N) {
		try {
			// Obrim l'arxiu
            FileInputStream fstream = new FileInputStream("C:\\Users\\Jan\\Programes\\eclipse\\eclipse-epsilon-1.2-win32\\workspace\\KenKen_PROP\\Partides.txt");
            // Creem l'objecte d'entrada
            DataInputStream entrada = new DataInputStream(fstream);
            // Creem el buffer de lectura
            BufferedReader buffer = new BufferedReader(new InputStreamReader(entrada));
            //Creem vector de popularitat
            ArrayList<Integer> cont = new ArrayList<Integer>(N);
            //Inicialitzem cont a 0
            for (int i = 0; i < N; ++i) {
        		cont.add(0);
        	}
            // Llegim l'arxiu línia per línia
            String linea;
        	while ((linea = buffer.readLine()) != null) {
        		//Dividim l'string a cada espai
        		String[] s = linea.split(" ");
        		int posicio = Integer.parseInt(s[1]) - 1;
        		int valor = cont.get(posicio);
        		cont.add(posicio, ++valor);
        	}
        	int max = cont.get(0);
        	this.popular = Integer.toString(1);
        	for (int i = 1; i < N; ++i) {
        		if (max < cont.get(i)) {
        			max = cont.get(i);
        			this.popular = Integer.toString(i+1);
        		}
        	}
            // Tanquem l'arxiu
            entrada.close();
        }
		catch (Exception e){ //Catch d'excepcions
            System.err.println("Hi ha hagut un error: " + e.getMessage());
        }
		return this.popular;
	}
}
