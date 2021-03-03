import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Window extends JFrame implements ActionListener{
	private Elenco el;
	private DefaultTableModel dft;
	private JTable tab;
	private JScrollPane pane;
	private JComboBox box;
	private JMenuBar bar;
	private JMenu menu;
	private JMenuItem addAlunno, addDocente, addATA, esporta, importa;
	
	
	public void initComponents() {
		this.setLayout(new GridLayout());
		Object[][] data= {};
		String[]columnNames= {"Tipologia","Cognome","Nome","Codice fiscale","Anno di nascita","Altro"};
		dft=new DefaultTableModel(data, columnNames);
		tab=new JTable(dft);
		pane=new JScrollPane(tab);
		
		bar=new JMenuBar();
		menu=new JMenu("File");
		addAlunno=new JMenuItem("Aggiungi alunno");
		addAlunno.addActionListener(this);
		addDocente=new JMenuItem("Aggiungi docente");
		addDocente.addActionListener(this);
		addATA=new JMenuItem("Aggiungi ATA");
		addATA.addActionListener(this);
		esporta=new JMenuItem("Esporta");
		esporta.addActionListener(this);
		importa=new JMenuItem("Importa");
		importa.addActionListener(this);
		
		menu.add(addAlunno);
		menu.add(addDocente);
		menu.add(addATA);
		menu.add(esporta);
		menu.add(importa);
		
		bar.add(menu);
		
		box=new JComboBox();
		box.addItem("Alunno");
		box.addItem("Docente");
		box.addItem("ATA");
		box.setSelectedItem(null);
		box.addActionListener(this);
		
		this.add(bar);
		this.add(pane);
		this.add(box);
		
	}
	/*public void updateTabella(String s) {
		dft.setRowCount(0);
		String[]row=null;
		for(int j=0; j<el.size();j++) {
			//row= {el.get(j).getCognome(), el.get(j).getNome(),el.get(j).getCodiceFiscale(),el.get(j).getAnnoNascita(), "altro"};
		dft.addRow(row);
	}*/
	
	public Window() {
		initComponents();
	}
	
	public static void main(String[]args) {
		Window w=new Window();
		w.setSize(800,600);
		w.setTitle("Personale Liceo Cocito");
		w.setVisible(true);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(addAlunno)) {
			DialogAlunno da=new DialogAlunno(this,true,el);
			da.setSize(600,800);
			da.setVisible(true);
		}
		if(e.getSource().equals(addDocente)) {
			DialogDocente da=new DialogDocente(this,true,el);
			da.setSize(600,800);
			da.setVisible(true);
		}
		if(e.getSource().equals(addATA)) {
			DialogATA da=new DialogATA(this,true,el);
			da.setSize(600,800);
			da.setVisible(true);
		}
		if(e.getSource().equals(importa)) {
			try {
				el.scriviTxt(this);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if(e.getSource().equals(esporta)) {
			try {
				el.leggiSerializzabile(this);
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
}
