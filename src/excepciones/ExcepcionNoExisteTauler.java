package excepciones;

public class ExcepcionNoExisteTauler extends Exception {
	public static final long serialVersionUID = 703L;

	@Override
	public String getMessage() {
		return "No existeix aquest tauler";
	}
}
