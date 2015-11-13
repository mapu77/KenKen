package excepciones;

public class ExcepcionNoExistePartidaGuardada extends Exception {
	public static final long serialVersionUID = 702L;

	@Override
	public String getMessage() {
		return "No tens cap partida guardada";
	}
}
