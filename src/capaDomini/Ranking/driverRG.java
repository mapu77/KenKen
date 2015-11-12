package capaDomini.Ranking;

public class driverRG {

	public static void mostraRankingGeneral() {
		RankingFactory RF = new RankingFactory();
		RankingGeneral rg = RF.generarRankingGeneral();
		System.out.println ("Ranquing General:");
		System.out.println ("----------------");
		System.out.println ("Nombre de jocs:\t\t\t" + rg.getnJocs());
		System.out.println ("Nombre d'usuaris:\t\t" + rg.getnUsuaris());
		System.out.println ("Nombre de partides jugades:\t" + rg.getnPartides());
		System.out.println ("Joc més popular:\t\t" + rg.getPopular());
	}
}