package controleur;
import modele.*;
import vue.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mathi
 */
public class AjouterSeance extends Frame implements ActionListener{
   
	JFrame AjouteSeance=new JFrame();
	JPanel panelText=new JPanel(new GridLayout(7,1));
	JPanel panelButton=new JPanel();
	JLabel ID=new JLabel("ID :");
	JTextField wID=new JTextField(20);
	JLabel semaine=new JLabel("semaine :");
	JTextField wSemaine=new JTextField(20);
	JLabel date=new JLabel("date :");
	JTextField wDate=new JTextField(20);
	JLabel heureD=new JLabel("heure du début :");
	JTextField wHeureD=new JTextField(20);
	JLabel heureF=new JLabel("heure de fin :");
	JTextField wHeureF =new JTextField(20);
	JLabel etat=new JLabel("etat :");
	JTextField wEtat=new JTextField(20);
	JLabel IDcours=new JLabel("ID du cours :");
	JTextField wIDcours =new JTextField(20);
        JLabel IDtype=new JLabel("ID du type :");
	JTextField wIDtype =new JTextField(20);
	JButton valider=new JButton("Valider");
	JButton annuler=new JButton("Annuler");
	JLabel Titre=new JLabel("Ajouter seance");
	
	public AjouterSeance()
	{
		super("Ajouter une nouvelle seance :");
		AjouteSeance.setLayout(new BorderLayout());
		JPanel p1=new JPanel(new GridLayout(1,2));
		p1.add(ID);p1.add(wID);
		JPanel p2=new JPanel(new GridLayout(1,2));
		p2.add(semaine);p2.add(wSemaine);
		JPanel p3=new JPanel(new GridLayout(1,2));
		p3.add(date);p3.add(wDate);
		JPanel p4=new JPanel(new GridLayout(1,2));
		p4.add(heureD);p4.add(wHeureD);
		JPanel p5=new JPanel(new GridLayout(1,2));
		p5.add(heureF);p5.add(wHeureF);
		JPanel p6=new JPanel(new GridLayout(1,2));
		p6.add(etat);p6.add(wEtat);
		JPanel p7=new JPanel(new GridLayout(1,2));
		p7.add(IDcours);p7.add(wIDcours);
                JPanel p8=new JPanel(new GridLayout(1,2));
		p8.add(IDtype);p8.add(wIDtype);
		panelText.add(p1);panelText.add(p2);
		panelText.add(p3);panelText.add(p4);
		panelText.add(p5);panelText.add(p6);panelText.add(p7);
                panelText.add(p8);
		Titre.setForeground(Color.RED);Titre.setSize(50,50);
		JPanel ptitre=new JPanel();
		ptitre.add(Titre,BorderLayout.CENTER);
		AjouteSeance.add(ptitre,BorderLayout.NORTH);
		AjouteSeance.add(panelText,BorderLayout.CENTER);
		panelButton.add(valider);panelButton.add(annuler);
		AjouteSeance.add(panelButton,BorderLayout.SOUTH);
		AjouteSeance.setVisible(true);
		AjouteSeance.pack();
		
		valider.addActionListener(this);
		annuler.addActionListener(this);
		wID.addActionListener(this);
		wSemaine.addActionListener(this);
		wDate.addActionListener(this);
		wHeureD.addActionListener(this);
		wHeureF.addActionListener(this);
		wEtat.addActionListener(this);
		wIDcours.addActionListener(this);
                wIDtype.addActionListener(this);
	}
        
    
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		if(e.getSource()==valider)
		{	
                                int ID, semaine,Etat,IDcours,IDtype;
				
				ID=(new Integer(wID.getText()));
				semaine=(new Integer(wSemaine.getText()));
                               String date=wDate.getText().toString();
                               String heureD=wHeureD.getText().toString();
                               String heureF=wHeureF.getText().toString();
				Etat=(new Integer(wEtat.getText()));
				IDcours=(new Integer(wIDcours.getText()));
                                IDtype=(new Integer(wIDtype.getText()));
				
				try
				{
					Class.forName("com.mysql.jdbc.Driver");
				}
				catch(Exception ex)
				{
					System.out.println ("le driver n'a pu être chargé");
				}
				try
				{
					String url ="jdbc:mysql://localhost:3305/edt";
				String user="root";
                                String password="";
         
                        Connection cnx=DriverManager.getConnection(url,user,password);
			Statement stm=cnx.createStatement ();
			
					stm.executeUpdate("insert into seance(ID,semaine,date,heure_debut,heure_fin,etat,IDcours,IDtype)values("+ID+",'"+semaine+"','"+date+"','"+heureF+"','"+heureD+"','"+Etat+"',"+IDcours+","+IDtype+")");       
				stm.close();
				cnx.close ();
				//JOptionPane.showMessageDialog(AjouteSeance, "seance ajouté avec succé", "Ajouter",JOptionPane.INFORMATION_MESSAGE) ;
				AjouteSeance.dispose();
				}
				catch(Exception ex)
				{
					JOptionPane.showMessageDialog(AjouteSeance, "Erreur d'ajout verifier les champs", "Erreur",JOptionPane.ERROR_MESSAGE) ;
				}
				
		}
		if(e.getSource()==annuler){
			AjouteSeance.dispose();
		}
		
	}
         public static void main(String[]args)
	{       
		new AjouterSeance();
	}
       
}
