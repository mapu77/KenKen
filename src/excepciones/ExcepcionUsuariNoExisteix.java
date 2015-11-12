package excepciones;

public class ExcepcionUsuariNoExisteix extends Exception {
	public static final long serialVersionUID = 701L;

	@Override
	public String getMessage() {
		return "L'usuari no existeix";
	}
	
}
