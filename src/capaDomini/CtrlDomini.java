/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capaDomini;

import capaDomini.Algoritmes.KenKenGenerator;
import capaDomini.Algoritmes.KenKenGenerator1;
import capaDomini.Algoritmes.KenKenSolver;
import capaDomini.Usuari.CtrlUser;
import capaDomini.Utils.TaulerKenKen;
import capaDomini.Ranking.RankingGeneral;
import capaDomini.Ranking.RankingPerTipus;
import capaDomini.Ranking.RankingPersonal;
import capaPersistencia.CtrlPersistencia;
import capaDomini.Ranking.Tupla;
import capaDomini.Utils.CtrlJoc;
import capaDomini.Utils.CtrlPartida;
import capaDomini.Utils.Partida;
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
    private CtrlJoc CJ;
    private TaulerKenKen K;
    
    /* Mètode Constructor */
    public CtrlDomini(Scanner sn) {
        this.sn = sn;
        CP = new CtrlPersistencia();
        CP.setSeparator(" ");
        System.out.println("Iniciant controlador de persistència...");
        CU = new CtrlUser();
        CJ = new CtrlJoc();
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
    
    /* Mètodes per Partida */
    /**
     * Mètode per carregar una partida guardada
     * @param u Usuari
     * @return El controlador associat a la partida
     */
    public CtrlPartida crearPartida(String u) {
        Partida P = CJ.loadPartidaGuardada(u);
        CtrlPartida CPart = new CtrlPartida(P);
        return CPart;
    }
    
    public CtrlPartida crearPartida(String u, String d) {
        Partida P = new Partida(u,d);
        CtrlPartida CPart = new CtrlPartida(P);
        return CPart;
    }
    
    public CtrlPartida crearPartida(String u, String d, String id) {
        Partida P = new Partida(u,d,id);
        CtrlPartida CPart = new CtrlPartida(P);
        return CPart;
    }
    
    /* ---------------------------------------------------------------------- */

    
    /* Mètodes KenKen BD */
    
    public String obtenirIdJoc (String d) {
        String s = CJ.mostrarIdTaulers(d);
        return s;
    }
    
    /* ---------------------------------------------------------------------- */

    public Boolean validaKenKen (int[][] mat, ArrayList<String> ops) {
        K = KenKenGenerator1.generateKenKenbyUser(mat, ops);
        return KenKenSolver.comprovaSol(K);
    }
    
    public int crearTauler() {
        int id = CJ.guardarTauler(K);
        return id;
    }
    
}
