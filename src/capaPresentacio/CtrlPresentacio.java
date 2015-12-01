/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capaPresentacio;

import capaDomini.CtrlDomini;
import capaDomini.Utils.*;
import java.util.Scanner;
/**
 *
 * @author Oriolcapo
 */
public class CtrlPresentacio {
    
    private CtrlDomini CD;
    
    public CtrlPresentacio() {}
    
    public void iniciaCtrls() {
        Scanner sn = new Scanner(System.in);
        CD = new CtrlDomini(sn);
        PantallaInici PI = new PantallaInici(this);
    }    
    
    public boolean comprovarUsuari(String u, String p) {
        return CD.comprovarUsuari(u,p);
    }
}
