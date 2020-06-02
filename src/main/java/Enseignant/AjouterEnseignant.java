/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author thoma
 */


package Enseignant;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.*;
public class AjouterEnseignant extends Frame implements ActionListener {
	JFrame FenetreAjoutEnseniant=new JFrame();
	JPanel panelText=new JPanel(new GridLayout(7,1));
	JPanel panelButton=new JPanel();
	JLabel Nom=new JLabel("Nom");
	JTextField ChNom=new JTextField(20);
	JLabel Prenom=new JLabel("Prénom");
	JTextField ChPrenom=new JTextField(20);
	JLabel alias=new JLabel("Alias");
	JTextField Chalias=new JTextField(20);
	JLabel CIN=new JLabel("CIN");
	JTextField ChCIN=new JTextField(20);
	JLabel affectation=new JLabel("Affectation");
	JTextField ChAffectation=new JTextField(20);
	JLabel Grade=new JLabel("Grade");
	JTextField ChGrade=new JTextField(20);
	JLabel Charge=new JLabel("Charge");
	JTextField Chcharge=new JTextField(20);
	Icon vlid=new ImageIcon("C:/Users/MOSLEM/Desktop/EmploiDetemps/bin/image/tick.png");
	Icon annl=new ImageIcon("C:/Users/MOSLEM/Desktop/EmploiDetemps/bin/image/publish_r.png");
	JButton valider=new JButton("Valider",vlid);
	JButton annuler=new JButton("Annuler",annl);
	JLabel Titre=new JLabel("Ajouter Ensegniant");
	String []tab={"0","1","2","3","4","5","6","7","8","9"};
	public AjouterEnseignant()
	{
		super("Ajouter Un Nouveaux Ensegniant");
		FenetreAjoutEnseniant.setLayout(new BorderLayout());
		//panelText.add(Nom);panelText.add(ChNom);
		JPanel p1=new JPanel(new GridLayout(1,2));
		p1.add(Nom);p1.add(ChNom);
		//panelText.add(Prenom);panelText.add(ChPrenom);
		JPanel p2=new JPanel(new GridLayout(1,2));
		p2.add(Prenom);p2.add(ChPrenom);
		//panelText.add(alias);panelText.add(Chalias);
		JPanel p3=new JPanel(new GridLayout(1,2));
		p3.add(alias);p3.add(Chalias);
		//panelText.add(CIN);panelText.add(ChCIN);
		JPanel p4=new JPanel(new GridLayout(1,2));
		p4.add(CIN);p4.add(ChCIN);
		//panelText.add(affectation);panelText.add(ChAffectation);
		JPanel p5=new JPanel(new GridLayout(1,2));
		p5.add(affectation);p5.add(ChAffectation);
		//panelText.add(Grade);panelText.add(ChGrade);
		JPanel p6=new JPanel(new GridLayout(1,2));
		p6.add(Grade);p6.add(ChGrade);
		//panelText.add(Charge);panelText.add(Chcharge);
		JPanel p7=new JPanel(new GridLayout(1,2));
		p7.add(Charge);p7.add(Chcharge);
		panelText.add(p1);panelText.add(p2);
		panelText.add(p3);panelText.add(p4);
		panelText.add(p5);panelText.add(p6);panelText.add(p7);
		Titre.setForeground(Color.RED);Titre.setSize(50,50);
		JPanel ptitre=new JPanel();
		ptitre.add(Titre,BorderLayout.CENTER);
		FenetreAjoutEnseniant.add(ptitre,BorderLayout.NORTH);
		FenetreAjoutEnseniant.add(panelText,BorderLayout.CENTER);
		panelButton.add(valider);panelButton.add(annuler);
		FenetreAjoutEnseniant.add(panelButton,BorderLayout.SOUTH);
		FenetreAjoutEnseniant.setVisible(true);
		FenetreAjoutEnseniant.pack();
		
		valider.addActionListener(this);
		annuler.addActionListener(this);
		ChNom.addActionListener(this);
		ChPrenom.addActionListener(this);
		Chalias.addActionListener(this);
		ChCIN.addActionListener(this);
		ChGrade.addActionListener(this);
		ChAffectation.addActionListener(this);
		Chcharge.addActionListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		if(e.getSource()==valider)
		{	
		
				String nom,prenom,alias,affectation,grad;
				int charge;int restcharge=0;int cin;
				nom=ChNom.getText().toString();
				prenom=ChPrenom.getText().toString();
				alias=Chalias.getText().toString();
				cin=(new Integer(ChCIN.getText()));
				affectation=ChAffectation.getText().toString();
				grad=ChGrade.getText().toString();
				charge=(new Integer(Chcharge.getText()));
				restcharge=0;
				try
				{
					Class.forName("oracle.jdbc.OracleDriver");
				}
				catch(Exception ex)
				{
					System.out.println ("le pilote n'a pu être chargé");
				}
				try
				{
					String url ="jdbc:oracle:thin:@197.6.70.161:1521:hakimm";
					Connection con= DriverManager.getConnection(url,"system","hakim");
					Statement stm=con.createStatement ();
			
					stm.executeUpdate("insert into ensegniant(cin,nom,prenom,alias,affectation,grad,charge,restcharge)values("+cin+",'"+nom+"','"+prenom+"','"+alias+"','"+affectation+"','"+grad+"',"+charge+","+restcharge+")");       
				stm.close();
				con.close ();
				JOptionPane.showMessageDialog(FenetreAjoutEnseniant, "Enseignant ajouté avec succé", "Enseignant ajouté avec succé",JOptionPane.INFORMATION_MESSAGE) ;
				FenetreAjoutEnseniant.dispose();
				}
				catch(Exception ex)
				{
					JOptionPane.showMessageDialog(FenetreAjoutEnseniant, "Erreur d'ajout verifier les champs", "Erreur",JOptionPane.ERROR_MESSAGE) ;
				}
				
		}
		if(e.getSource()==annuler){
			FenetreAjoutEnseniant.dispose();
		}
		
	}
}
