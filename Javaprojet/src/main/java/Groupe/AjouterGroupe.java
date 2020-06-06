/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Groupe;

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

/**
 *
 * @author thoma
 */




public class AjouterGroupe extends Frame implements ActionListener{
   
	JFrame AjouteGroupe=new JFrame();
	JPanel panelText=new JPanel(new GridLayout(7,1));
	JPanel panelButton=new JPanel();
	
	JLabel ID=new JLabel("ID :");
	JTextField wID=new JTextField(20);
	JLabel Nom=new JLabel("Nom :");
	JTextField wNom=new JTextField(20);	
        JLabel IDpromotion=new JLabel("ID de la promotion :");
	JTextField wIDpromotion =new JTextField(20);
	JButton valider=new JButton("Valider");
	JButton annuler=new JButton("Annuler");
	JLabel Titre=new JLabel("Ajouter un groupe");
	public AjouterGroupe()
	{
		super("Ajouter un nouveau groupe:");
		AjouteGroupe.setLayout(new BorderLayout());
		//panelText.add(Nom);panelText.add(ChNom);
		JPanel p5=new JPanel(new GridLayout(1,2));
		p5.add(ID);p5.add(wID);
                JPanel p6=new JPanel(new GridLayout(1,2));
		p6.add(Nom);p6.add(wNom);
		JPanel p7=new JPanel(new GridLayout(1,2));
		p7.add(IDpromotion);p7.add(wIDpromotion);
                panelText.add(p5);
		panelText.add(p7);
                panelText.add(p6);
		Titre.setForeground(Color.RED);Titre.setSize(50,50);
		JPanel ptitre=new JPanel();
		ptitre.add(Titre,BorderLayout.CENTER);
		AjouteGroupe.add(ptitre,BorderLayout.NORTH);
		AjouteGroupe.add(panelText,BorderLayout.CENTER);
		panelButton.add(valider);panelButton.add(annuler);
		AjouteGroupe.add(panelButton,BorderLayout.SOUTH);
		AjouteGroupe.setVisible(true);
		AjouteGroupe.pack();
		
		valider.addActionListener(this);
		annuler.addActionListener(this);
		wIDpromotion.addActionListener(this);
		wID.addActionListener(this);
                wNom.addActionListener(this);
	}
        
    
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		if(e.getSource()==valider)
		{	
                                int ID,Nom,IDpromotion; 
				
				ID=(new Integer(wID.getText()));
                                Nom=(new Integer(wNom.getText()));
                                IDpromotion=(new Integer(wIDpromotion.getText()));
				
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
			
					stm.executeUpdate("insert into groupe(IDséance,IDgroupe)values("+ID+",'"+Nom+",'"+IDpromotion+")");       
				stm.close();
				cnx.close ();
				//JOptionPane.showMessageDialog(AjouteSeance, "seance ajouté avec succé", "Ajouter",JOptionPane.INFORMATION_MESSAGE) ;
				AjouteGroupe.dispose();
				}
				catch(Exception ex)
				{
					JOptionPane.showMessageDialog(AjouteGroupe, "Erreur d'ajout verifier les champs", "Erreur",JOptionPane.ERROR_MESSAGE) ;
				}
				
		}
		if(e.getSource()==annuler){
			AjouteGroupe.dispose();
		}
		
	}
}