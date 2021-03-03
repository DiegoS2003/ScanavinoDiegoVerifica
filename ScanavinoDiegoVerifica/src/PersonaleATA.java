
public class PersonaleATA extends Persona{
	private String mansione;
	public String getMansione() {
		return mansione;
	}
	public void setMansione(String mansione) {
		this.mansione = mansione;
	}
	public PersonaleATA(String cognome, String nome, String codiceFiscale, int annoNascita, String mansione) {
		super(cognome, nome, codiceFiscale, annoNascita);
		this.mansione=mansione;
		// TODO Auto-generated constructor stub
		
	}

}
