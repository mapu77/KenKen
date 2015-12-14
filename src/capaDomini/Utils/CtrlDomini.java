/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package capaDomini.Utils;

import capaDomini.Algoritmes.KenKenGenerator;
import capaDomini.Usuari.CtrlUser;
import capaPersistencia.CtrlPersistencia;
import java.util.Scanner;

/**
 *
 * @author Oriolcapo
 */
public class CtrlDomini {
    
    private CtrlPersistencia CP;
    private CtrlUser CU;
    
    public CtrlDomini() {
        CP = new CtrlPersistencia();
        CP.setSeparator(" ");
        CU = new CtrlUser();
        generaKenkenAleatori (4);
    }
    
    public TaulerKenKen generaKenkenAleatori (int N) {
        KenKenGenerator KG = new KenKenGenerator();
        return KG.generateRandomly(N);
    }
}
