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
		stubCTRLRankingJocs.carregar(this, "Jocs");
		this.nJocs = Info.size();
		
		//nombre d'usuaris
		stubCTRLRankingUsuaris.carregar(this, "Usuaris");
		this.nUsuaris = Info.size();
		
		//nombre de partides
		stubCTRLRankingPartides.carregar(this, "Partides");
		this.nPartides = Info.size();
		
		//joc més popular
		Map<String,Integer> cont = new HashMap<>();
		stubCTRLRankingPartides.carregar(this, "Partides");
		for (int i = 0; i < Info.size(); ++i) {	//presència d'un joc a Partides
			ArrayList<String> s = Info.get(i);	//agafem línia per línia la informació Info
			String id = s.get(1);	//prenem el valor identificador que ens interessa
			if (!(cont.containsKey(id))) {	//no havia aparegut
				cont.put(id,1);	//afegim <Key = id, value = 1> a la primera posició lliure
			}
			else {	//ja havia aparegut
				int value = cont.get(id);	//consultem el valor del Key = id
				cont.put(id,++value);	//afegim <value += 1> a la posició de Key = id
			}
		}
		Map.Entry<String,Integer> entry;
		int max = -1;	//assignem valor a max
		int visitats = 0;	//posicions visitades
    	while (visitats <= cont.size()) {
    		entry = cont.entrySet().iterator().next();	//prenem els valors de la primera posició
    		if (max < entry.getValue()) {
    			max = entry.getValue();
    			this.popular = entry.getKey();
    		}
    		++visitats;
    		cont.remove(entry.getKey());
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