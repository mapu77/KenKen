/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capaPresentacio;

import capaDomini.CtrlDomini;
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
}
