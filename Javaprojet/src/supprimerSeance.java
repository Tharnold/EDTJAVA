
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mathi
 */
public class supprimerSeance extends Frame implements ActionListener{
   
	JFrame supprSeance=new JFrame();
	JPanel panelText=new JPanel(new GridLayout(7,1));
	JPanel panelButton=new JPanel();
	JLabel ID=new JLabel("veuillez rentre l'ID de la séance à supprimer:");
	JTextField wID=new JTextField(20);
	Icon vlid=new ImageIcon("C:/Users/MOSLEM/Desktop/EmploiDetemps/bin/image/tick.png");
	Icon annl=new ImageIcon("C:/Users/MOSLEM/Desktop/EmploiDetemps/bin/image/publish_r.png");
	JButton valider=new JButton("Valider",vlid);
	JButton annuler=new JButton("Annuler",annl);
	JLabel Titre=new JLabel("Supprimer seance");
	
	public supprimerSeance()
	{
		super("Ajouter une nouvelle seance :");
                this.setLocation(350,300);
		supprSeance.setLayout(new BorderLayout());
		//panelText.add(Nom);panelText.add(ChNom);
		JPanel p1=new JPanel(new GridLayout(1,2));
		p1.add(ID);p1.add(wID);
		//panelText.add(Prenom);panelText.add(ChPrenom);
		
		
		
		Titre.setForeground(Color.RED);Titre.setSize(50,50);
		JPanel ptitre=new JPanel();
		ptitre.add(Titre,BorderLayout.CENTER);
                panelText.add(p1);
		supprSeance.add(ptitre,BorderLayout.NORTH);
		supprSeance.add(panelText,BorderLayout.CENTER);
		panelButton.add(valider);panelButton.add(annuler);
		supprSeance.add(panelButton,BorderLayout.SOUTH);
		supprSeance.setVisible(true);
		supprSeance.pack();
		
		valider.addActionListener(this);
		annuler.addActionListener(this);
		wID.addActionListener(this);
		
	}
	
       
	public void actionPerformed(ActionEvent e) {
		
		
		if(e.getSource()==valider)
		{	
                                int IDs;
				
				IDs=(new Integer(wID.getText()));
				
				
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
			    
					stm.executeUpdate("delete  from seance WHERE ID="+IDs+""); 
                                        
                                      
				stm.close();
				cnx.close ();
				//JOptionPane.showMessageDialog(AjouteSeance, "seance ajouté avec succé", "Ajouter",JOptionPane.INFORMATION_MESSAGE) ;
				supprSeance.dispose();
				}
				catch(Exception ex)
				{
					JOptionPane.showMessageDialog(supprSeance, "Erreur d'ajout verifier les champs", "Erreur",JOptionPane.ERROR_MESSAGE) ;
				}
				
		}
		if(e.getSource()==annuler){
			supprSeance.dispose();
		}
		
	}
}
