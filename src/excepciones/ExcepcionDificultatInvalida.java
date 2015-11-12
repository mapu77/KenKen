package excepciones;

public class ExcepcionDificultatInvalida extends Exception {
	public static final long serialVersionUID = 700L;

	@Override
	public String getMessage() {
		return "La dificultat no es valida";
	}
}
