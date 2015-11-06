package Ranking;

public class driverRG {

	public static void main(String[] args) {
		RankingGeneral rg = new RankingGeneral();		
		System.out.println ("Rànquing General:");
		System.out.println ("nJocs: " + rg.getnJocs());
		System.out.println ("nUsuaris: " + rg.getnUsuaris());
		System.out.println ("nPartides: " + rg.getnPartides());
		System.out.println ("Popular: " + rg.getPopular());
	}
}