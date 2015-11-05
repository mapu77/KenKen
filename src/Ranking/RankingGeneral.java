package Ranking;

import java.util.*;

public class RankingGeneral extends Ranking {
	int nJocs;
	int nUsuaris;
	int nPartides;
	String popular;

	public RankingGeneral() {
		this.nJocs = 0;
		this.nUsuaris = 0;
		this.nPartides = 0;
		this.popular = "-";
		inicialitza();
	}
	
	public void inicialitza() {
		//nombre de jocs
		CTRLRanking.carregar(this, "Jocs");
		ArrayList<Integer> cont = new ArrayList<Integer>(Info.size());
		this.nJocs = Info.size();
		//nombre d'usuaris
		CTRLRanking.carregar(this, "Usuaris");
		this.nUsuaris = Info.size();
		//nombre de partides
		CTRLRanking.carregar(this,  "Partides");
		this.nPartides = Info.size();
		//joc més popular
		for (int i = 0; i < cont.size(); ++i) cont.add(i, 0);
		
		CTRLRanking.carregar(this, "Partides");
		for (int i = 0; i < Info.size(); ++i) {
			ArrayList<String> s = Info.get(i);
			String id = s.get(1);
			int posicio = Integer.parseInt(id)-1;
			int valor = cont.get(posicio);
			cont.add(posicio, ++valor);
		}
		
		int max = cont.get(0);
    	this.popular = Integer.toString(1);
    	for (int i = 1; i < cont.size(); ++i) {
    		if (max < cont.get(i)) {
    			max = cont.get(i);
    			this.popular = Integer.toString(i+1);
    		}
    	}
	}
	
	public int getnJocs() {					
		return this.nJocs;
    }
	
	public int getnUsuaris() {
		return this.nUsuaris;
	}
	
	public int getnPartides() {
		return this.nPartides;
	}
	
	public String getPopular() {	
    	return this.popular;
	}
}
	
/*------------------------------------------------------------------------
	
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
	
	*/