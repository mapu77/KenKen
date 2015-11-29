/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capaPresentacio;

import capaDomini.Usuari.CtrlUser;
import capaDomini.Utils.*;
import capaPersistencia.*;
import java.util.Scanner;
/**
 *
 * @author Oriolcapo
 */
public class CtrlPresentacio {
    
    private CtrlDomini CD;
    private PantallaInici PI;
    
    public CtrlPresentacio() {}
    
    public void iniciaCtrls() {
        Scanner sn = new Scanner(System.in);
        CD = new CtrlDomini(sn);
        PI = new PantallaInici();
    }    
}
