package Ranking;

public class Tupla { //Tupla d'Usuari + Temps per a RankingPerTipus
	private String user;
	private Double temps;
	
	public Tupla(){
	}
	
	public Tupla(String user, Double temps){ 
		this.user=user;
		this.temps=temps;
	}
	
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public Double getTemps() {
		return temps;
	}
	public void setTemps(Double temps) {
		this.temps = temps;
	}
	
	
}
