/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Salle;

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


public class ModifierSalle extends Frame implements ActionListener{
   
	JFrame modifSalle=new JFrame();
	JPanel panelText=new JPanel(new GridLayout(7,1));
	JPanel panelButton=new JPanel();
	JLabel ID=new JLabel("rentrez l'id de la Salle que vous souhaitez modifier : :");
	JTextField wID=new JTextField(20);
	JLabel IDsalle=new JLabel("rentrez le nouvel ID de la salle :");
	JTextField wIDsalle =new JTextField(20);
        JLabel Nom=new JLabel("rentrez le nouveau nom de la salle :");
	JTextField wNom =new JTextField(20);
        JLabel Capacité=new JLabel("rentrez la nouvelle capacité de la salle :");
	JTextField wCapacité =new JTextField(20);
        JLabel IDSite=new JLabel("rentrez le nouveau site de la salle :");
	JTextField wIDSite =new JTextField(20);
	
	JButton valider=new JButton("Valider");
	JButton annuler=new JButton("Annuler");
	JLabel Titre=new JLabel("Modifier seance");
	
	public ModifierSalle()
	{
		super("Modifier une nouvelle seance :");
		modifSalle.setLayout(new BorderLayout());
		
		JPanel p1=new JPanel(new GridLayout(1,2));
		p1.add(ID);p1.add(wID);
                JPanel p6=new JPanel(new GridLayout(1,2));
		p6.add(Nom);p6.add(wNom);
		JPanel p7=new JPanel(new GridLayout(1,2));
		p7.add(IDsalle);p7.add(wIDsalle);
                JPanel p9=new JPanel(new GridLayout(1,2));
		p9.add(Capacité);p9.add(wCapacité);
                JPanel p8=new JPanel(new GridLayout(1,2));
		p8.add(IDSite);p8.add(wIDSite);
		panelText.add(p1);panelText.add(p7);
                panelText.add(p8);panelText.add(p9);
		Titre.setForeground(Color.RED);Titre.setSize(50,50);
		JPanel ptitre=new JPanel();
		ptitre.add(Titre,BorderLayout.CENTER);
		modifSalle.add(ptitre,BorderLayout.NORTH);
		modifSalle.add(panelText,BorderLayout.CENTER);
		panelButton.add(valider);panelButton.add(annuler);
		modifSalle.add(panelButton,BorderLayout.SOUTH);
		modifSalle.setVisible(true);
		modifSalle.pack();
		
		valider.addActionListener(this);
		annuler.addActionListener(this);
		wID.addActionListener(this);
		wIDSite.addActionListener(this);
                wIDsalle.addActionListener(this);
                wNom.addActionListener(this);
                wCapacité.addActionListener(this);
	}
             
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		if(e.getSource()==valider)
		{	
                                int IDs,IDSite1,IDsalle1, Nom1, Capacité1;
				
				IDs=(new Integer(wID.getText()));
				
				IDSite1=(new Integer(wIDSite.getText()));
                                IDsalle1=(new Integer(wIDsalle.getText()));
                                Nom1=(new Integer(wNom.getText()));
                                Capacité1=(new Integer(wCapacité.getText()));
				
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
                                        stm.executeUpdate("update salle set Nom = '"+Nom1+"'  where ID ='"+IDs+"'");  
                                        stm.executeUpdate("update salle seCapacité = '"+Capacité1+"'  where ID ='"+IDs+"'"); 
					stm.executeUpdate("update salle set IDSite = '"+IDSite1+"'where ID ='"+IDs+"'"); 
                                        stm.executeUpdate("update salle set IDsalle = '"+IDsalle1+"'  where ID ='"+IDs+"'");  
				stm.close();
				cnx.close ();
				//JOptionPane.showMessageDialog(AjouteSeance, "seance ajouté avec succé", "Ajouter",JOptionPane.INFORMATION_MESSAGE) ;
				modifSalle.dispose();
				}
				catch(Exception ex)
				{
					JOptionPane.showMessageDialog(modifSalle, "Erreur d'ajout verifier les champs", "Erreur",JOptionPane.ERROR_MESSAGE) ;
				}
				
		}
		if(e.getSource()==annuler){
			modifSalle.dispose();
		}
		
	}}
