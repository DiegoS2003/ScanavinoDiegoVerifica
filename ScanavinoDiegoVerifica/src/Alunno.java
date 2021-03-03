
public class Alunno extends Persona{
	private String classe;
	public String getClasse() {
		return classe;
	}
	public void setClasse(String classe) {
		this.classe = classe;
	}
	public Alunno(String cognome, String nome, String codiceFiscale, int annoNascita, String classe) {
		super(cognome, nome, codiceFiscale, annoNascita);
		this.classe=classe;
		// TODO Auto-generated constructor stub
	}
	
}
