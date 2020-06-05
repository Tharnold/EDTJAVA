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
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class ModifierSeanceEnseignant extends Frame implements ActionListener{
   
	JFrame modifSeanceEnseignant=new JFrame();
	JPanel panelText=new JPanel(new GridLayout(7,1));
	JPanel panelButton=new JPanel();
	JLabel ID=new JLabel("rentrez l'id de la salle que vous souhaitez modifier : :");
	JTextField wID=new JTextField(20);
	JLabel IDEnseignant=new JLabel("rentrez le nouvel ID de la salle:");
	JTextField wIDEnseignant =new JTextField(20);
        JLabel IDséance=new JLabel("rentrez le nouvel ID du séance :");
	JTextField wIDséance =new JTextField(20);
	
	JButton valider=new JButton("Valider");
	JButton annuler=new JButton("Annuler");
	JLabel Titre=new JLabel("Modifier seance");
	
	public ModifierSeanceEnseignant()
	{
		super("Modifier l'affectation d'un enseignant à une seance :");
		modifSeanceEnseignant.setLayout(new BorderLayout());
		
		JPanel p1=new JPanel(new GridLayout(1,2));
		p1.add(ID);p1.add(wID);
		JPanel p7=new JPanel(new GridLayout(1,2));
		p7.add(IDséance);p7.add(wIDséance);
                JPanel p8=new JPanel(new GridLayout(1,2));
		p8.add(IDEnseignant);p8.add(wIDEnseignant);
		panelText.add(p1);panelText.add(p7);
                panelText.add(p8);
		Titre.setForeground(Color.RED);Titre.setSize(50,50);
		JPanel ptitre=new JPanel();
		ptitre.add(Titre,BorderLayout.CENTER);
		modifSeanceEnseignant.add(ptitre,BorderLayout.NORTH);
		modifSeanceEnseignant.add(panelText,BorderLayout.CENTER);
		panelButton.add(valider);panelButton.add(annuler);
		modifSeanceEnseignant.add(panelButton,BorderLayout.SOUTH);
		modifSeanceEnseignant.setVisible(true);
		modifSeanceEnseignant.pack();
		
		valider.addActionListener(this);
		annuler.addActionListener(this);
		wID.addActionListener(this);
		wIDséance.addActionListener(this);
                wIDEnseignant.addActionListener(this);
	}
             
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		if(e.getSource()==valider)
		{	
                                int IDs,IDséance1,IDEnseignant1;
				
				IDs=(new Integer(wID.getText()));
				
				IDséance1=(new Integer(wIDséance.getText()));
                                IDEnseignant1=(new Integer(wIDEnseignant.getText()));
				
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
			
					stm.executeUpdate("update seance_enseignant set IDséance = '"+IDséance1+"'where ID ='"+IDs+"'"); 
                                        stm.executeUpdate("update seance_enseignant set IDenseignant = '"+IDEnseignant1+"'  where ID ='"+IDs+"'");  
				stm.close();
				cnx.close ();
				//JOptionPane.showMessageDialog(AjouteSeance, "seance ajouté avec succé", "Ajouter",JOptionPane.INFORMATION_MESSAGE) ;
				modifSeanceEnseignant.dispose();
				}
				catch(Exception ex)
				{
					JOptionPane.showMessageDialog(modifSeanceEnseignant, "Erreur d'ajout verifier les champs", "Erreur",JOptionPane.ERROR_MESSAGE) ;
				}
				
		}
		if(e.getSource()==annuler){
			modifSeanceEnseignant.dispose();
		}
		
	}}