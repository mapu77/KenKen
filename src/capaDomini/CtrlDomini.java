/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capaDomini;

import capaDomini.Algoritmes.KenKenGenerator;
import capaDomini.Usuari.CtrlUser;
import capaDomini.Usuari.User;
import capaDomini.Utils.TaulerKenKen;
import capaDomini.Ranking.RankingGeneral;
import capaDomini.Ranking.RankingPerTipus;
import capaDomini.Ranking.RankingPersonal;
import capaPersistencia.CtrlPersistencia;
import java.util.Scanner;

/**
 *
 * @author Oriolcapo
 */
public class CtrlDomini {
    
    private static Scanner sn;
    private CtrlPersistencia CP;
    private CtrlUser CU;
    
    public CtrlDomini(Scanner sn) {
        this.sn = sn;
        CP = new CtrlPersistencia();
        CP.setSeparator(" ");
        CU = new CtrlUser();
    }
    
    public boolean comprovarUsuari(String u, String p) {
        return CtrlUser.comprovaPwd(u,p);
    }
    
    public boolean existeixUsuari (String u) {
        if (CtrlUser.getUsuari(u) != null) return true;
        return false;
    }
    
    public void changePassword(String u, String pwd) {
        CtrlUser.getUsuari(u).setPassword(pwd);
    }
    
    public TaulerKenKen generaKenkenAleatori (int N) {
        KenKenGenerator KG = new KenKenGenerator(sn);
        return KG.generateRandomly(N);
    }
    
    public double obtenirTempsRP (String u, String diff) {
        RankingPersonal RP = new RankingPersonal(u);
        return RP.getBestTime(diff);
    }
    
    public double obtenirPistesRP (String u) {
        RankingPersonal RP = new RankingPersonal(u);
        return RP.getPistes();
    }
    
    public int obtenirResoltsRP (String u) {
        RankingPersonal RP = new RankingPersonal(u);
        return RP.getResolts();
    }
    
    public int jocsRG () {
        RankingGeneral RG = new RankingGeneral();
        return RG.getnJocs();
    }
    
    public int partidesRG () {
        RankingGeneral RG = new RankingGeneral();
        return RG.getnPartides();
    }
    
    public int usuarisRG () {
        RankingGeneral RG = new RankingGeneral();
        return RG.getnUsuaris();
    }
    
    public String popularRG () {
        RankingGeneral RG = new RankingGeneral();
        return RG.getPopular();
    }
}
