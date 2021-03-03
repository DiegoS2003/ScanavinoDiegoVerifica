
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.*;

public class DialogDocente extends JDialog implements ActionListener{
	private JLabel cognome, nome, codiceFiscale, annoNascita, classe;
	private JTextField insCognome, insNome, insCodiceFiscale, insAnnoNascita, insClasse;
	private JButton aggiungi;
	Elenco el;
	
	public void initComponents() {
		this.setLayout(new GridLayout(2,6));
		cognome=new JLabel("Cognome");
		nome=new JLabel("Nome");
		codiceFiscale=new JLabel("Codice fiscale");
		annoNascita=new JLabel("Anno di nascita");
		classe=new JLabel("Classe di concorso");
		
		insCognome=new JTextField(15);
		insNome=new JTextField(15);
		insCodiceFiscale=new JTextField(15);
		insAnnoNascita=new JTextField(15);
		insClasse=new JTextField(15);
		
		aggiungi=new JButton("Aggiungi");
		aggiungi.addActionListener(this);
		
		this.add(cognome);
		this.add(insCognome);
		this.add(nome);
		this.add(insNome);
		this.add(codiceFiscale);
		this.add(insCodiceFiscale);
		this.add(annoNascita);
		this.add(insAnnoNascita);
		this.add(classe);
		this.add(insClasse);
		this.add(aggiungi);
	}
	
	public DialogDocente(JFrame finestra, boolean modal, Elenco el ) {
		super(finestra, modal);	
		this.el=el;
		initComponents();
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(aggiungi)) {
			el.add(new Docente(insCognome.getText(),insNome.getText(), insCodiceFiscale.getText(),Integer.parseInt(insAnnoNascita.getText()), insClasse.getText()));
			this.dispose();
		}
	}
}
