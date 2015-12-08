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
import capaDomini.Ranking.Tupla;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Oriolcapo
 */
public class CtrlDomini {
    
    private static Scanner sn;
    private CtrlPersistencia CP;
    private CtrlUser CU;
    
    /* Mètode Constructor */
    public CtrlDomini(Scanner sn) {
        this.sn = sn;
        CP = new CtrlPersistencia();
        CP.setSeparator(" ");
        System.out.println("Iniciant controlador de persistència...");
        CU = new CtrlUser();
    }
    /* Mètodes per Gestió d'Usuari */
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
    /* ---------------------------------------------------------------------- */
    
    /* Mètodes Creació KenKen */
    public TaulerKenKen generaKenkenAleatori (int N) {
        KenKenGenerator KG = new KenKenGenerator(sn);
        return KG.generateRandomly(N);
    }
    
    /* ----------------------------------------------------------------------- */
    
    /* Mètodes per al Ranking */
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
    
    public Tupla obtenirRxT(String d, int e, int i) {
        RankingPerTipus RT = new RankingPerTipus(d,e);
        ArrayList<Tupla> v = RT.getTempsJugador();
        if (i >= v.size()) return null;
        else {
            Tupla t = new Tupla();
            t.setId(v.get(i).getId());
            t.setUser(v.get(i).getUser());
            t.setTemps(v.get(i).getTemps());
            return t;
        }
    }
    /* ---------------------------------------------------------------------- */
}
