/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SEANCES_GROUPE;

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


public class AjouterSeanceGroupe extends Frame implements ActionListener{
   
	JFrame AjouteSeanceGroupe=new JFrame();
	JPanel panelText=new JPanel(new GridLayout(7,1));
	JPanel panelButton=new JPanel();
	
	JLabel IDséance=new JLabel("ID de la séance :");
	JTextField wIDséance =new JTextField(20);
        JLabel IDgroupe=new JLabel("ID du groupe :");
	JTextField wIDgroupe =new JTextField(20);
	JButton valider=new JButton("Valider");
	JButton annuler=new JButton("Annuler");
	JLabel Titre=new JLabel("Ajouter seance");
	
	public AjouterSeanceGroupe()
	{
		super("Ajouter une nouvelle seance à un groupe :");
		AjouteSeanceGroupe.setLayout(new BorderLayout());
		//panelText.add(Nom);panelText.add(ChNom);
		
		JPanel p7=new JPanel(new GridLayout(1,2));
		p7.add(IDséance);p7.add(wIDséance);
                JPanel p8=new JPanel(new GridLayout(1,2));
		p8.add(IDgroupe);p8.add(wIDgroupe);
		panelText.add(p7);
                panelText.add(p8);
		Titre.setForeground(Color.RED);Titre.setSize(50,50);
		JPanel ptitre=new JPanel();
		ptitre.add(Titre,BorderLayout.CENTER);
		AjouteSeanceGroupe.add(ptitre,BorderLayout.NORTH);
		AjouteSeanceGroupe.add(panelText,BorderLayout.CENTER);
		panelButton.add(valider);panelButton.add(annuler);
		AjouteSeanceGroupe.add(panelButton,BorderLayout.SOUTH);
		AjouteSeanceGroupe.setVisible(true);
		AjouteSeanceGroupe.pack();
		
		valider.addActionListener(this);
		annuler.addActionListener(this);
		
		wIDséance.addActionListener(this);
                wIDgroupe.addActionListener(this);
	}
        
    
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		if(e.getSource()==valider)
		{	
                                int IDséance,IDgroupe; 
				
				IDséance=(new Integer(wIDséance.getText()));
                                IDgroupe=(new Integer(wIDgroupe.getText()));
				
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
			
					stm.executeUpdate("insert into seance_groupe(IDséance,IDgroupe)values("+IDséance+",'"+IDgroupe+")");       
				stm.close();
				cnx.close ();
				//JOptionPane.showMessageDialog(AjouteSeance, "seance ajouté avec succé", "Ajouter",JOptionPane.INFORMATION_MESSAGE) ;
				AjouteSeanceGroupe.dispose();
				}
				catch(Exception ex)
				{
					JOptionPane.showMessageDialog(AjouteSeanceGroupe, "Erreur d'ajout verifier les champs", "Erreur",JOptionPane.ERROR_MESSAGE) ;
				}
				
		}
		if(e.getSource()==annuler){
			AjouteSeanceGroupe.dispose();
		}
		
	}
}