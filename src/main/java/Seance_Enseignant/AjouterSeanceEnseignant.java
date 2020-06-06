/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Seance_Enseignant;

/**
 *
 * @author thoma
 */
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


public class AjouterSeanceEnseignant extends Frame implements ActionListener{
   
	JFrame AjouteSeanceEnseignant=new JFrame();
	JPanel panelText=new JPanel(new GridLayout(7,1));
	JPanel panelButton=new JPanel();
	
	JLabel IDséance=new JLabel("ID de la séance :");
	JTextField wIDséance =new JTextField(20);
        JLabel IDEnseignant=new JLabel("ID de l'enseignant :");
	JTextField wIDEnseignant =new JTextField(20);
	JButton valider=new JButton("Valider");
	JButton annuler=new JButton("Annuler");
	JLabel Titre=new JLabel("Ajouter l'enseignant à la séance");
	
	public AjouterSeanceEnseignant()
	{
		super("Ajouter un enseignant à une séance :");
		AjouteSeanceEnseignant.setLayout(new BorderLayout());
		//panelText.add(Nom);panelText.add(ChNom);
		
		JPanel p7=new JPanel(new GridLayout(1,2));
		p7.add(IDséance);p7.add(wIDséance);
                JPanel p8=new JPanel(new GridLayout(1,2));
		p8.add(IDEnseignant);p8.add(wIDEnseignant);
		panelText.add(p7);
                panelText.add(p8);
		Titre.setForeground(Color.RED);Titre.setSize(50,50);
		JPanel ptitre=new JPanel();
		ptitre.add(Titre,BorderLayout.CENTER);
		AjouteSeanceEnseignant.add(ptitre,BorderLayout.NORTH);
		AjouteSeanceEnseignant.add(panelText,BorderLayout.CENTER);
		panelButton.add(valider);panelButton.add(annuler);
		AjouteSeanceEnseignant.add(panelButton,BorderLayout.SOUTH);
		AjouteSeanceEnseignant.setVisible(true);
		AjouteSeanceEnseignant.pack();
		
		valider.addActionListener(this);
		annuler.addActionListener(this);
		
		wIDséance.addActionListener(this);
                wIDEnseignant.addActionListener(this);
	}
        
    
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		if(e.getSource()==valider)
		{	
                                int IDséance,IDEnseignant; 
				
				IDséance=(new Integer(wIDséance.getText()));
                                IDEnseignant=(new Integer(wIDEnseignant.getText()));
				
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
			
					stm.executeUpdate("insert into seance_enseignant(IDséance,IDenseignant)values("+IDséance+",'"+IDEnseignant+")");       
				stm.close();
				cnx.close ();
				//JOptionPane.showMessageDialog(AjouteSeance, "seance ajouté avec succé", "Ajouter",JOptionPane.INFORMATION_MESSAGE) ;
				AjouteSeanceEnseignant.dispose();
				}
				catch(Exception ex)
				{
					JOptionPane.showMessageDialog(AjouteSeanceEnseignant, "Erreur d'ajout verifier les champs", "Erreur",JOptionPane.ERROR_MESSAGE) ;
				}
				
		}
		if(e.getSource()==annuler){
			AjouteSeanceEnseignant.dispose();
		}
		
	}
}