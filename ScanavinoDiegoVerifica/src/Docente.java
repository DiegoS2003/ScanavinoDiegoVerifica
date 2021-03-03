
public class Docente extends Persona{
	private String classeConcorso;
	public Docente(String cognome, String nome, String codiceFiscale, int annoNascita, String classeConcorso) {
		super(cognome, nome, codiceFiscale, annoNascita);
		// TODO Auto-generated constructor stub
		this.classeConcorso=classeConcorso;
	}
	public String getClasseConcorso() {
		return classeConcorso;
	}
	public void setClasseConcorso(String classeConcorso) {
		this.classeConcorso = classeConcorso;
	}

}
