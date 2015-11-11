package capaDomini.Ranking;

public class driverRG {

	public static void main(String[] args) {
		RankingFactory RF = new RankingFactory();
		RankingGeneral rg = RF.generarRankingGeneral();
		System.out.println ("R�nquing General:");
		System.out.println ("nJocs: " + rg.getnJocs());
		System.out.println ("nUsuaris: " + rg.getnUsuaris());
		System.out.println ("nPartides: " + rg.getnPartides());
		System.out.println ("Popular: " + rg.getPopular());
	}
}