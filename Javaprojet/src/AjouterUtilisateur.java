/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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

/**
 *
 * @author thoma
 */

public class AjouterUtilisateur extends Frame implements ActionListener{
   
	JFrame A=new JFrame();
	JPanel panelText=new JPanel(new GridLayout(7,1));
	JPanel panelButton=new JPanel();
	JLabel IDUtilisateur=new JLabel("rentrez le ID de l'utilisateur :");
	JTextField wIDUtilisateur =new JTextField(20);
        JLabel Nom=new JLabel("rentrez le Nom :");
	JTextField wNom =new JTextField(20);
        JLabel Prenom=new JLabel("rentrez le Prénom :");
	JTextField wPrenom =new JTextField(20);
        JLabel Mail=new JLabel("rentrez le Mail :");
	JTextField wMail =new JTextField(20);
        JLabel Mdp=new JLabel("rentrez le mdp :");
	JTextField wMdp =new JTextField(20);
        JLabel Droits=new JLabel("rentrez les Droits :");
	JTextField wDroits =new JTextField(20);
	
	JButton valider=new JButton("Valider");
	JButton annuler=new JButton("Annuler");
	JLabel Titre=new JLabel("Ajouter l'utilisateur");
	
        
	public AjouterUtilisateur()
	{
		super("Ajouter un utilisateur :");
		A.setLayout(new BorderLayout());
		
		
		JPanel p2=new JPanel(new GridLayout(1,2));
		p2.add(Nom);p2.add(wNom);
                JPanel p3=new JPanel(new GridLayout(1,2));
		p3.add(Prenom);p3.add(wPrenom);
                JPanel p4=new JPanel(new GridLayout(1,2));
		p4.add(Mail);p4.add(wMail);
                JPanel p5=new JPanel(new GridLayout(1,2));
		p5.add(Mdp);p5.add(wMdp);
                JPanel p7=new JPanel(new GridLayout(1,2));
		p7.add(Droits);p7.add(wDroits);
                JPanel p8=new JPanel(new GridLayout(1,2));
		p8.add(IDUtilisateur);p8.add(wIDUtilisateur);
		panelText.add(p2);
                panelText.add(p3);panelText.add(p4);
                panelText.add(p5);panelText.add(p7);
                panelText.add(p8);
		Titre.setForeground(Color.RED);Titre.setSize(50,50);
		JPanel ptitre=new JPanel();
		ptitre.add(Titre,BorderLayout.CENTER);
		A.add(ptitre,BorderLayout.NORTH);
		A.add(panelText,BorderLayout.CENTER);
		panelButton.add(valider);panelButton.add(annuler);
		A.add(panelButton,BorderLayout.SOUTH);
		A.setVisible(true);
		A.pack();
		
		valider.addActionListener(this);
		annuler.addActionListener(this);
		
		wNom.addActionListener(this);
                wIDUtilisateur.addActionListener(this);
                wPrenom.addActionListener(this);
                wMail.addActionListener(this);
                wDroits.addActionListener(this);
                wMdp.addActionListener(this);
	}
             public static void main(String[]args)
	{       
		new AjouterUtilisateur();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		if(e.getSource()==valider)
		{	
                                int IDs,Droits1;
				
				IDs=(new Integer(wIDUtilisateur.getText()));
				 String Nom1=wNom.getText().toString();
                                String Prenom1=wPrenom.getText().toString();
                                 String Mail1=wMail.getText().toString();
                                  String Mdp1=wMdp.getText().toString();
                                   
                                  Droits1=(new Integer(wDroits.getText()));
				
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
			
	stm.executeUpdate("insert into utilisateur(ID,nom,prenom,email,password,droit)values('"+IDs+"','"+Nom1+"','"+Prenom1+"','"+Mail1+"','"+Mdp1+"','"+Droits1+"')");     
                                      
                                        
				stm.close();
				cnx.close ();
				//JOptionPane.showMessageDialog(AjouteSeance, "seance ajouté avec succé", "Ajouter",JOptionPane.INFORMATION_MESSAGE) ;
				A.dispose();
				}
				catch(Exception ex)
				{
					JOptionPane.showMessageDialog(A, "Erreur d'ajout verifier les champs", "Erreur",JOptionPane.ERROR_MESSAGE) ;
				}
				
		}
		if(e.getSource()==annuler){
			A.dispose();
		}
		
	}
}