package capaDomini.Utils;

import java.util.*;
import capaPersistencia.*;
import java.io.*;
import capaDomini.*;

public class Kenken extends Joc {
	
	public static void menuIntro(){
		System.out.print("OPCIONS \n"
				+ " 0 Sortir \n"
				+ " 1 Crear Usuari \n"
				+ " 2 Accedir amb Usuari creat");
	}
	public static void menuPrincipal(){
		System.out.print("MENÚ PRINCIPAL \n"
				+ " 0 Sortir \n"
				+ " 1 Crear Kenken"
				+ " 2 Jugar al Kenken"
				+ " 3 Gestió d'Usuari"
				+ " 4 Consultar Ranking"
				);
	}
	public static void menuKenken(){
		System.out.print("MENÚ KENKEN \n"
				+ " 0 Sortir \n"
				+ " 1 Crear Kenken per usuari"
				+ " 2 Crear Kenken per parametre");
	}
	public static void menuGestioUsuari(){
		System.out.print("GESTIÓ USUARI \n"
				+ " 0 Sortir \n"
				+ " 1 Modificar usuari"
				+ " 2 Modificar contrasenya");
	}
	public static void menuJugaKenken(){
		System.out.print("JUGAR KENKEN \n"
				+ " 0 Sortir \n"
				+ " 1 Continuar Partida"
				+ " 2 Seleccionar Kenken creat"
				+ " 3 Generar Kenken aleatori");
	}
	public static void menuRanking(){
		System.out.println("MENU RANKING \n"
				+ " 0 Sortir \n"
				+ " 1 Consulta Ranking General"
				+ " 2 Consulta Ranking per Tipus"
				+ " 3 Consulta Ranking Personal");
	}
	public static void crearUsuari(CtrlUser ctrlu, Scanner sn){
	System.out.println("Introdueix el nom d'usuari");
	String username = sn.next();
	User u = new User(username,null);
	boolean si = CtrlUser.afegeixUsuari(u);
	while (!si) {
		System.out.println("L'usuari ja existeix");
		System.out.println("Torna a introduir un nou nom d'usuari");
		username = sn.next();
		u = new User(username,null);
	}
	System.out.println("Introdueix la constrasenya");
	String password = sn.next();
	System.out.println("Torna a introduir la contrasenya");
	String psw2 = sn.next();
	while (!password.equals(psw2)) {
		System.out.println("Les contrasenyes no coincideixen");
		System.out.println("Introdueix la nova contrasenya");
		password = sn.next();
		System.out.println("Torna a introduir la nova contrasenya");
		psw2 = sn.next();
	}
	u.setPassword(password);
	si = CtrlUser.afegeixUsuari(u);
	CtrlUser.end();
	}
	public static void accedirAmbUsuari(CtrlUser ctrlu, Scanner sn){
		System.out.println("Introdueix el teu usuari");
		String username = sn.next();
		User user = CtrlUser.getUsuari(username);
		if (user == null) {
			System.out.println("L'usuari no existeix");
		}
		else {
			System.out.println("Introdueix la contrasenya");
			String password = sn.next();
			int i = 3;
			while (i > 0 && ! user.testPassword(password)) {
				System.out.println("Contrasenya incorrecte");
				System.out.println("Torna a introduir la contrasenya");
				password = sn.next();
				--i;
			}
			if (i > 0 && ! user.testPassword(password)) {
				System.out.println("Log-in correctament");
			}
		}
	}
	public static void gestionarUsuari(CtrlUser ctrlu, Scanner sn, String password){
		System.out.println("Introdueix la teva contrasenya");
		String password2= sn.next();
			if(password2.equals(password)){
				System.out.println("Què vols modificar? \n"
						+ " 1 Modificar el nom"
						+ " 2 Modificar contrasenya");
				int opt=sn.nextInt();
					if(opt==1){
						System.out.println("Introdueix el nom d'usuari");
						String username = sn.next();
						User u = new User(username,null);
						boolean si = CtrlUser.afegeixUsuari(u);
							while (!si) {
								System.out.println("L'usuari ja existeix");
								System.out.println("Torna a introduir un nou nom d'usuari");
								username = sn.next();
								u = new User(username,null);
					}
					if(opt==2){
						System.out.println("Introdueix la nova constrasenya");
						password = sn.next();
						System.out.println("Torna a introduir la contrasenya");
						String psw2 = sn.next();
							while (!password.equals(psw2)) {
								System.out.println("Les contrasenyes no coincideixen");
								System.out.println("Introdueix la nova contrasenya");
								password = sn.next();
								System.out.println("Torna a introduir la nova contrasenya");
								psw2 = sn.next();
							}
					u.setPassword(password);
					si = CtrlUser.afegeixUsuari(u);
					CtrlUser.end();
					}
					else{
						System.out.println("Error: Opció no valida");
					}
					}
		
			}
	}
	public static void crearKenkenUser(){
		
	}
	public static void main(String[] args) {
		

	}

}