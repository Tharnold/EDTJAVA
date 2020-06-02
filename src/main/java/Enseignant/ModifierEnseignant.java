/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Enseignant;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
public class ModifierEnseignant extends JFrame implements ActionListener{
	Icon vlid=new ImageIcon("C:/Users/MOSLEM/Desktop/EmploiDetemps/bin/image/tick.png");
	Icon annl=new ImageIcon("C:/Users/MOSLEM/Desktop/EmploiDetemps/bin/image/publish_r.png");
	JFrame FenetreRech=new JFrame();
	JLabel lab=new JLabel("DOnner le CIN de L'ensegniant");
	JTextField t=new JTextField(20);
	JPanel pan=new JPanel();
	
	JPanel pan2=new JPanel();
	
	JButton confRech=new JButton("Modifier",vlid);
	JButton annRech=new JButton("Annuler",annl);
	
	JFrame FenetreModifEnseniant=new JFrame();
	JPanel panelText=new JPanel(new GridLayout(7,1));
	JPanel panelText2=new JPanel(new GridLayout(7,1));
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
	/***************************************************/
	JLabel Nom2=new JLabel("Nom");
	JTextField ChNom2=new JTextField(20);
	JLabel Prenom2=new JLabel("Prénom");
	JTextField ChPrenom2=new JTextField(20);
	JLabel alias2=new JLabel("Alias");
	JTextField Chalias2=new JTextField(20);
	JLabel CIN2=new JLabel("CIN");
	JTextField ChCIN2=new JTextField(20);
	JLabel affectation2=new JLabel("Affectation");
	JTextField ChAffectation2=new JTextField(20);
	JLabel Grade2=new JLabel("Grade");
	JTextField ChGrade2=new JTextField(20);
	JLabel Charge2=new JLabel("Charge");
	JTextField Chcharge2=new JTextField(20);
	/*************************************************/
	JButton valider=new JButton("Valider",vlid);
	JButton annuler=new JButton("Annuler",annl);
	JLabel Titre=new JLabel("Modifier Enseignant");
	JPanel droit=new JPanel(new BorderLayout());
	JPanel gauch=new JPanel(new BorderLayout());
	public ModifierEnseignant()
	{
		
		FenetreRech.setTitle("Recherche De L'ensegniant a modifier");
		pan.add(lab);pan.add(t);pan2.add(confRech);pan2.add(annRech);
		FenetreRech.add(pan,BorderLayout.NORTH);
		FenetreRech.add(pan2,BorderLayout.CENTER);
		confRech.addActionListener(this);
		annRech.addActionListener(this);
		
		FenetreModifEnseniant.setLayout(new BorderLayout());
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
		droit.add(panelText,BorderLayout.CENTER);
		
		/***************************************************/
		//panelText.add(Nom);panelText.add(ChNom);
		JPanel p12=new JPanel(new GridLayout(1,2));
		p12.add(Nom2);p12.add(ChNom2);ChNom2.setEditable(false);
		//panelText.add(Prenom);panelText.add(ChPrenom);
		JPanel p22=new JPanel(new GridLayout(1,2));
		p22.add(Prenom2);p22.add(ChPrenom2);ChPrenom2.setEditable(false);
		//panelText.add(alias);panelText.add(Chalias);
		JPanel p32=new JPanel(new GridLayout(1,2));
		p32.add(alias2);p32.add(Chalias2);Chalias2.setEditable(false);
		//panelText.add(CIN);panelText.add(ChCIN);
		JPanel p42=new JPanel(new GridLayout(1,2));
		p42.add(CIN2);p42.add(ChCIN2);ChCIN2.setEditable(false);
		//panelText.add(affectation);panelText.add(ChAffectation);
		JPanel p52=new JPanel(new GridLayout(1,2));
		p52.add(affectation2);p52.add(ChAffectation2);ChAffectation2.setEditable(false);
		//panelText.add(Grade);panelText.add(ChGrade);
		JPanel p62=new JPanel(new GridLayout(1,2));
		p62.add(Grade2);p62.add(ChGrade2);ChGrade2.setEditable(false);
		//panelText.add(Charge);panelText.add(Chcharge);
		JPanel p72=new JPanel(new GridLayout(1,2));
		p72.add(Charge2);p72.add(Chcharge2);Chcharge2.setEditable(false);
		panelText2.add(p12);panelText2.add(p22);
		panelText2.add(p32);panelText2.add(p42);
		panelText2.add(p52);panelText2.add(p62);panelText2.add(p72);
		gauch.add(panelText2,BorderLayout.CENTER);
		/****************************************************/
		Titre.setForeground(Color.RED);Titre.setSize(50,50);
		JPanel ptitre=new JPanel();
		ptitre.add(Titre,BorderLayout.CENTER);
		FenetreModifEnseniant.add(ptitre,BorderLayout.NORTH);
		FenetreModifEnseniant.add(droit,BorderLayout.EAST);
		FenetreModifEnseniant.add(gauch,BorderLayout.WEST);
		panelButton.add(valider);panelButton.add(annuler);
		FenetreModifEnseniant.add(panelButton,BorderLayout.SOUTH);
		FenetreModifEnseniant.setVisible(true);
		FenetreModifEnseniant.pack();
		
		valider.addActionListener(this);
		annuler.addActionListener(this);
		
		FenetreModifEnseniant.disable();FenetreModifEnseniant.setSize(1000,250);FenetreModifEnseniant.setResizable(false);
		FenetreRech.setVisible(true);
		FenetreRech.pack();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==confRech)
		{	
			try
			{
				Class.forName("oracle.jdbc.OracleDriver");
			}
			catch(Exception ee)
			{
				System.out.println ("le pilote n'a pu être chargé");
			}
			try
			{
			int ci=new Integer(t.getText());
			String url ="jdbc:oracle:thin:@197.6.70.161:1521:hakimm";
			Connection con= DriverManager.getConnection(url,"system","hakim");
			Statement stm=con.createStatement ();
			ResultSet result =stm.executeQuery ("select cin,nom,prenom,alias,affectation,grad,charge from ensegniant where cin="+ci+"");
			while(result.next())
			{
				String nom,prenom,alias,affectation,grad;
				int charge;int restcharge=0;int cin;String cinn;
				nom=result.getString(2);
				prenom=result.getString(3);
				alias=result.getString(4);
				cin=result.getInt(1);
				affectation=result.getString(5);
				grad=result.getString(6);
				charge=result.getInt(7);
				
				ChNom2.setText(nom);
				
				ChPrenom2.setText(prenom);
				
				Chalias2.setText(alias);
				
				ChCIN2.setText(""+cin);
				
				ChAffectation2.setText(affectation);;
				
				ChGrade2.setText(grad);
				Chcharge2.setText(""+charge);
				FenetreModifEnseniant.enable();
				FenetreRech.dispose();
			}
			stm.close();	
			con.close ();
			}
			catch(Exception eE)
			{
			JOptionPane.showMessageDialog(FenetreRech, "CIN incorrect", "Erreur",JOptionPane.ERROR_MESSAGE) ;
			}
			
			
			
		}
		if(e.getSource()==annRech)
		{
			FenetreRech.dispose();
			FenetreModifEnseniant.dispose();
			
			
		}
		if(e.getSource()==annuler)
		{
			FenetreModifEnseniant.dispose();
		}
		if(e.getSource()==valider)
		{	
				String nom,prenom,alias,affectation,grad;
				int charge;int restcharge=0;int cin;
				nom=ChNom.getText().toString();
				prenom=ChPrenom.getText().toString();
				alias=Chalias.getText().toString();
				affectation=ChAffectation.getText().toString();
				grad=ChGrade.getText().toString();

				restcharge=0;
				try
				{
					Class.forName("oracle.jdbc.OracleDriver");
				}
				catch(Exception ex)
				{
					JOptionPane.showMessageDialog(FenetreModifEnseniant, "le pilote n'a pu être chargé", "Erreur",JOptionPane.ERROR_MESSAGE) ;
				}
				try
				{
					cin=(new Integer(ChCIN.getText()));
					charge=(new Integer(Chcharge.getText()));
					String url ="jdbc:oracle:thin:@197.6.70.161:1521:hakimm";
					Connection con= DriverManager.getConnection(url,"system","hakim");
					Statement stm=con.createStatement ();
					stm.executeUpdate("update ensegniant set cin="+cin+",nom='"+nom+"',prenom='"+prenom+"',alias='"+alias+"',affectation='"+affectation+"',grad='"+grad+"',charge="+charge+" where cin="+(new Integer(t.getText()))+"");       
				stm.close();
				con.close ();
				JOptionPane.showMessageDialog(FenetreModifEnseniant, "Modification terminer avec succé", "Modification terminer avec succé",JOptionPane.INFORMATION_MESSAGE) ;
				FenetreModifEnseniant.dispose();
				}
				catch(Exception ex)
				{
					JOptionPane.showMessageDialog(FenetreModifEnseniant, "Erreur  de modification verifier les champs", "Erreur",JOptionPane.ERROR_MESSAGE) ;
				}
				
			
		}
		
	}

}