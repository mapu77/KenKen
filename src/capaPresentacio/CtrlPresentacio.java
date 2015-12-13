/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capaPresentacio;

import capaDomini.CtrlDomini;
import capaDomini.Utils.*;
import java.util.ArrayList;
/**
 *
 * @author PROP 12 - KenKen
 */
public class CtrlPresentacio {
    
    private CtrlDomini CD;
    
    /**
     * Constructor del Controlador de Presentació.
     */
    public CtrlPresentacio() {
        iniciaCtrls();
        System.out.println("Carregant interfície...");
        PantallaInici PI = new PantallaInici(this);
    }
    
    /**
     * Inicialitzador dels controladors
     * En particular instancia el Controlador del Domini
     */
    private void iniciaCtrls() {
        System.out.println("Iniciant controlador de domini...");
        CD = new CtrlDomini();
    }    
    
    /**
     * Mètode consultor.
     * Comprova que l'usuari u tingui per password p.
     * 
     * @param u Usuari
     * @param p Password
     * @return Cert si l'identificació és correcte. Fals, altrament.
     */
    public boolean comprovarUsuari(String u, String p) {
        return CD.comprovarUsuari(u,p);
    }
    
    /**
     * Mètode consultor.
     * Comprova si existeix l'usuari u
     * 
     * @param u Usuari
     * @return Cert si existeix. Fals, altrament.
     */
    public boolean existeixUsuari (String u) {
        return CD.existeixUsuari(u);
    }
    
    /**
     * Mètode modificador.
     * Canviar el password del usuari u per newPwd.
     * 
     * @param u Usuari
     * @param newPwd Nova password
     */
    public void changePassword(String u, String newPwd) {
        CD.changePassword(u,newPwd);
    }
    
    /**
     * Mètode consultor.
     * Consulta al RankingPersonal el nombre de pistes del usuari u
     * 
     * @param u Usuari
     * @return Nombre de pistes en mitjana
     */
    public double obtenirPistesRP (String u) {
        return CD.obtenirPistesRP(u);
    }
    
    /**
     * Mètode consultor.
     * Consulta el millor temps del usuari u per a la dificultat diff
     * 
     * @param u - Usuari
     * @param diff - Dificultat
     * @return Millor temps per a la dificultat diff
     */
    public double obtenirTempsRP (String u, String diff) {
        return CD.obtenirTempsRP(u,diff);
    }
    
    /**
     * Mètode consultor.
     * Consulta el nombre de jocs resolts del usuari u
     * 
     * @param u Usuari
     * @return Nombre de jocs resolts
     */
    public int obtenirResoltsRP (String u) {
        return CD.obtenirResoltsRP(u);
    }
    
    /**
     * Mètode consultor.
     * Consulta el nombre de jocs en el sistema
     * 
     * @return Nombre de jocs
     */
    public int jocsRG() {
        return CD.jocsRG();
    }
    
    /**
     * Mètode consultor.
     * Consulta el nombre de partides jugades en el sistema
     * 
     * @return Nombre de partides jugades
     */
    public int partidesRG() {
        return CD.partidesRG();
    }
    
    /**
     * Mètode consultor.
     * Consulta el nombre de usuaris en el sistema
     * 
     * @return Nombre d'usuaris
     */
    public int usuarisRG() {
        return CD.usuarisRG();
    }
    
    /**
     * Mètode consultor.
     * Consulta el joc més popular en el sistema
     * 
     * @return Joc més popular
     */
    public String popularRG() {
        return CD.popularRG();
    }
    
    /**
     * Mètode consultor.
     * Conuslta
     * @param d
     * @param e
     * @param i
     * @return 
     */
    public String obtenirUserRT (String d, int e, int i) {
        if (CD.obtenirRxT(d,e,i) != null) return CD.obtenirRxT(d,e,i).getUser();
        return null;
    }
    
    public double obtenirTimeRT (String d, int e, int i) {
        if (CD.obtenirRxT(d,e,i) != null) return CD.obtenirRxT(d,e,i).getTemps();
        return -1;
    }
    
    public String obtenirIdRT (String d, int e, int i) {
        if (CD.obtenirRxT(d,e,i) != null) return CD.obtenirRxT(d,e,i).getId();
        return null;
    }
    
    /**
     * Creador de partides amb KenKens aleatoris
     * 
     * @param user Usuari
     * @param d Dificultat
     * @return El controlador associat a la partida creada
     */
    public CtrlPartida crearPartida(String user, String d) {
        return CD.crearPartida(user,d);
    }
     
    /**
     * Creador de partides amb KenKens carregats de la Base de Dades
     * 
     * @param user Usuari
     * @param d Dificultat
     * @param id Identificador
     * @return El controlador associat a la partida creada
     */
    public CtrlPartida crearPartida(String user, String d, String id) {
        return CD.crearPartida(user,d, id);
    }    
    
    /**
     * Creador de partides guardades
     * 
     * @param user Usuari
     * @return El controlador associat a la partida carregada
     */
    public CtrlPartida crearPartida(String user) {
        return CD.crearPartida(user);
    }
    
    /**
     * Mètode consultor.
     * Consulta el identificador del joc amb dificultat d
     * 
     * @param d Dificultat
     * @return Identificador del joc
     */
    public String obtenirIdJoc (String d) {
        return CD.obtenirIdJoc(d);
    }
    
    /**
     * Validar KenKens.
     * Valida si el KenKen representat per mat i ops es correcte
     * 
     * @param mat
     * @param ops
     * @return Cert si el KenKen es vàlid. Fals, altrament
     */
    public Boolean validaKenKen (int[][] mat, ArrayList<String> ops) {
        return CD.validaKenKen(mat,ops);
    }
    
    public int crearTauler() {
        return CD.crearTauler();
    }
    
    public int[][] generaKenkenPerParametres (int N, int iniX, ArrayList<String> vOps) {
        return CD.generaKenkenPerParametres (N, iniX, vOps);
    }
    
    public int[][] taulerBBDD (String id, String D,ArrayList<String> vOps) {
        return CD.taulerBBDD(id, D, vOps);
    }
}
