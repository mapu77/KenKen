package capaDomini.Utils;
import java.io.IOException;
import java.util.*;
import capaPersistencia.CtrlPersistencia;
import capaDomini.Usuari.*;

public class CtrlJoc {

	public static void main(String[] args) throws IOException {
		CtrlPersistencia.setSeparator(" ");
		System.out.println("Benvingut a KenKen");
		System.out.println("0-Sortir");
		System.out.println("1-Identificar-se");
		System.out.println("2-Crear un nou usuari");
		Scanner sn = new Scanner(System.in);
		int op;
		while ((op = sn.nextInt()) != 0) {
			CtrlUser ctrlu = new CtrlUser();
			String password;
			String username;
			switch (op) {
			case 1:
				System.out.println("Introdueix el teu username");
				username = sn.next();
				User user = ctrlu.getUsuari(username);
				if (user == null) {
					System.out.println("L'usuari no existeix");
				}
				else {
					System.out.println("Introdueix el password");
					password = sn.next();
					int i = 3;
					while (i > 0 && ! user.testPassword(password)) {
						System.out.println("Password incorrecte");
						System.out.println("Torna a introdu�r el password");
						password = sn.next();
						--i;
					}
					if (i > 0 && ! user.testPassword(password)) {
						System.out.println("Log-in correctament");
					}
				}
				break;
			case 2:
				System.out.println("Introdueix el username");
				username = sn.next();
				User u = new User(username,null);
				boolean si = ctrlu.afegeixUsuari(u);
				while (!si) {
					System.out.println("L'usuari ja existeix");
					System.out.println("Torna a introduir un nou username");
					username = sn.next();
					u = new User(username,null);
				}
				System.out.println("Introueix el nou password");
				password = sn.next();
				System.out.println("Torna a introduir el password");
				String psw2 = sn.next();
				while (!password.equals(psw2)) {
					System.out.println("Els passwords no coincideixen");
					System.out.println("Introueix el nou password");
					password = sn.next();
					System.out.println("Torna a introduir el password");
					psw2 = sn.next();
				}
				u.setPassword(password);
				si = ctrlu.afegeixUsuari(u);
				ctrlu.end();
				break;

			default:
			}
			System.out.println("Menu:");
			System.out.println("0-Sortir");
			System.out.println("1-Identificar-se");
			System.out.println("2-Crear un nou usuari");
		}
		sn.close();
	}

}
