
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.JFrame;

public class Elenco extends ArrayList<Persona>{
	public Elenco() {
		super();
	}
	
	public String creaCsv() {
		String csv=null;
		for(int i=0;i<this.size();i++) {
			if(this.get(i) instanceof Alunno) {
				Alunno a=(Alunno) this.get(i);
				csv+="Alunno"+";"+a.getCognome()+";"+a.getNome()+";"+a.getCodiceFiscale()+";"+String.valueOf(a.getAnnoNascita())+";"+a.getClasse()+"\n";
			}
			if(this.get(i) instanceof PersonaleATA) {
				PersonaleATA pa=(PersonaleATA) this.get(i);
				csv+="Personale ATA"+";"+pa.getCognome()+";"+pa.getNome()+";"+pa.getCodiceFiscale()+";"+String.valueOf(pa.getAnnoNascita())+";"+pa.getMansione()+"\n";
			}
			if(this.get(i) instanceof PersonaleATA) {
				Docente d=(Docente) this.get(i);
				csv+="Alunno"+";"+d.getCognome()+";"+d.getNome()+";"+d.getCodiceFiscale()+";"+String.valueOf(d.getAnnoNascita())+";"+d.getClasseConcorso()+"\n";
			}
		}
		return csv;
	}
	
	public void scriviTxt(JFrame finestra) throws IOException {
		String csv=this.creaCsv();
		JFileChooser jfc=new JFileChooser();
		jfc.setFileFilter(new TxtFileFilter());
		int n=jfc.showSaveDialog(finestra);
		if(n==JFileChooser.APPROVE_OPTION) {
			File f=jfc.getSelectedFile();
			FileWriter fw= new FileWriter(f);
			fw.write(csv);
			fw.flush();
			fw.close();
		}
	}
	
	public Elenco leggiSerializzabile(JFrame finestra) throws IOException, ClassNotFoundException {
		JFileChooser jfc=new JFileChooser();
		jfc.setFileFilter(new BinFileFilter());
		int n=jfc.showSaveDialog(finestra);
		if(n==JFileChooser.APPROVE_OPTION) {
			File f=jfc.getSelectedFile();
			FileInputStream fis=new FileInputStream (f);
			ObjectInputStream ois=new ObjectInputStream(fis);
			return (Elenco) ois.readObject();
		}
		return null;
	}
}
