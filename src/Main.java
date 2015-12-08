
import capaPresentacio.CtrlPresentacio;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Oriolcapo
 */
public class Main {
    private static CtrlPresentacio CP;
        public static void main (String[] args) throws Exception {
        // Inicializaciones generales, etc
        System.out.println("Iniciant controlador de presentació...");
        CP = new CtrlPresentacio();
    }
}
