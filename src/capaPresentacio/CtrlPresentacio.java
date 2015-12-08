/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capaPresentacio;

import capaDomini.CtrlDomini;
import capaDomini.Ranking.Tupla;
import capaDomini.Utils.*;
import capaDomini.Usuari.*;
import java.util.Scanner;
/**
 *
 * @author Oriolcapo
 */
public class CtrlPresentacio {
    
    private CtrlDomini CD;
    
    public CtrlPresentacio() {
        iniciaCtrls();
        System.out.println("Carregant interfície");
        PantallaInici PI = new PantallaInici(this);
    }
    
    private void iniciaCtrls() {
        Scanner sn = new Scanner(System.in);
        CD = new CtrlDomini(sn);
    }    
    
    public boolean comprovarUsuari(String u, String p) {
        return CD.comprovarUsuari(u,p);
    }
    
    public boolean existeixUsuari (String u) {
        return CD.existeixUsuari(u);
    }
    
    public void changePassword(String u, String newPwd) {
        CD.changePassword(u,newPwd);
    }
    
    public double obtenirPistesRP (String u) {
        return CD.obtenirPistesRP(u);
    }
    
    public double obtenirTempsRP (String u, String diff) {
        return CD.obtenirTempsRP(u,diff);
    }
    
    public int obtenirResoltsRP (String u) {
        return CD.obtenirResoltsRP(u);
    }
    
    public int jocsRG() {
        return CD.jocsRG();
    }
    
    public int partidesRG() {
        return CD.partidesRG();
    }
    
    public int usuarisRG() {
        return CD.usuarisRG();
    }
    
    public String popularRG() {
        return CD.popularRG();
    }
    
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
    
}
