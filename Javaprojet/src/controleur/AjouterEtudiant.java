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
public class AjouterEtudiant extends Frame implements ActionListener{
    
   
   JFrame modifUtilisateur=new JFrame();
   JFrame modifUtilisateur1=new JFrame();
	JFrame modifUtilisateur2=new JFrame();
	JPanel panelText=new JPanel(new GridLayout(7,1));
	JPanel panelButton=new JPanel();
        JPanel panelText1=new JPanel(new GridLayout(7,1));
	JPanel panelButton1=new JPanel();
        JPanel panelText2=new JPanel(new GridLayout(7,1));
	JPanel panelButton3=new JPanel();
        JLabel ID=new JLabel("Rentrez l'id  :");
	JTextField IDe =new JTextField(20);
	 JLabel num=new JLabel("Numero de l'étudiant : ");
	JTextField wnum=new JTextField(20);
        JLabel IDgroupe=new JLabel("ID du groupe :");
	JTextField wIDgroupe =new JTextField(20);
        
	
	JButton valider=new JButton("Valider");
	JButton annuler=new JButton("Annuler");
	JLabel Titre=new JLabel("Modifier l'utilisateur");

public AjouterEtudiant()
	{          JPanel p11=new JPanel(new GridLayout(1,2));
		p11.add(ID);p11.add(IDe);
                JPanel p9=new JPanel(new GridLayout(1,2));
		p9.add(num);p9.add(wnum);
		JPanel p10=new JPanel(new GridLayout(1,2));
		p10.add(IDgroupe);p10.add(wIDgroupe);
               
               panelText1.add(p11); panelText1.add(p9);panelText1.add(p10);
                Titre.setForeground(Color.RED);Titre.setSize(50,50);
		JPanel ptitre=new JPanel();
		ptitre.add(Titre,BorderLayout.CENTER);
		modifUtilisateur1.add(ptitre,BorderLayout.NORTH);
		modifUtilisateur1.add(panelText1,BorderLayout.CENTER);
		panelButton1.add(valider);panelButton1.add(annuler);
		modifUtilisateur1.add(panelButton1,BorderLayout.SOUTH);
		modifUtilisateur1.setVisible(true);
		modifUtilisateur1.pack();
                valider.addActionListener(this);
		annuler.addActionListener(this);
       
        }

  
public void actionPerformed(ActionEvent e) {
		
		
		if(e.getSource()==valider)
		{int numero1=(new Integer(wnum.getText()));
                     int IDgroupe1=(new Integer(wIDgroupe.getText()));
                     int IDs =(new Integer(IDe.getText()));
                    try
				{
					Class.forName("com.mysql.jdbc.Driver");
				}
				catch(Exception ex)
				{
					System.out.println ("le driver n'a pu Ãªtre chargÃ©");
				}
				try
				{
					String url ="jdbc:mysql://localhost:3305/edt";
				String user="root";
                                String password="";
         
                        Connection cnx=DriverManager.getConnection(url,user,password);
			Statement stm=cnx.createStatement ();
                        stm.executeUpdate("insert into etudiant(IDutilisateur,numero,IDgroupe)values("+IDs+",'"+numero1+"',"+IDgroupe1+")");
                                  modifUtilisateur1.dispose();
                                }
				catch(Exception ex)
				{
					JOptionPane.showMessageDialog(modifUtilisateur, "Erreur d'ajout verifier les champs", "Erreur",JOptionPane.ERROR_MESSAGE) ;
				}
				
		}
		if(e.getSource()==annuler){
			modifUtilisateur1.dispose();
		}
    
}
}
        
