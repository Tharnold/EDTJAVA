/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Site;

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


public class ModifierSite extends Frame implements ActionListener{
   
	JFrame modifSite=new JFrame();
	JPanel panelText=new JPanel(new GridLayout(7,1));
	JPanel panelButton=new JPanel();
	JLabel ID=new JLabel("rentrez l'id du site que vous souhaitez modifier : :");
	JTextField wID=new JTextField(20);
	JLabel IDsite=new JLabel("rentrez le nouvel ID du site :");
	JTextField wIDsite =new JTextField(20);
        JLabel Nom=new JLabel("rentrez le nouveau nom du site :");
	JTextField wNom =new JTextField(20);
  
	
	JButton valider=new JButton("Valider");
	JButton annuler=new JButton("Annuler");
	JLabel Titre=new JLabel("Modifier Le site");
	
	public ModifierSite()
	{
		super("Modifier un nouveau site :");
		modifSite.setLayout(new BorderLayout());
		
		JPanel p1=new JPanel(new GridLayout(1,2));
		p1.add(ID);p1.add(wID);
                JPanel p6=new JPanel(new GridLayout(1,2));
		p6.add(Nom);p6.add(wNom);
		JPanel p7=new JPanel(new GridLayout(1,2));
		p7.add(IDsite);p7.add(wIDsite);
               
		panelText.add(p1);panelText.add(p7);
               
		Titre.setForeground(Color.RED);Titre.setSize(50,50);
		JPanel ptitre=new JPanel();
		ptitre.add(Titre,BorderLayout.CENTER);
		modifSite.add(ptitre,BorderLayout.NORTH);
		modifSite.add(panelText,BorderLayout.CENTER);
		panelButton.add(valider);panelButton.add(annuler);
		modifSite.add(panelButton,BorderLayout.SOUTH);
		modifSite.setVisible(true);
		modifSite.pack();
		
		valider.addActionListener(this);
		annuler.addActionListener(this);
		wID.addActionListener(this);
		
                wIDsite.addActionListener(this);
                wNom.addActionListener(this);
	}
             
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		if(e.getSource()==valider)
		{	
                                int IDs,IDsite1, Nom1;
				
				IDs=(new Integer(wID.getText()));
				
				
                                IDsite1=(new Integer(wIDsite.getText()));
                                Nom1=(new Integer(wNom.getText()));
				
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
                                        stm.executeUpdate("update site set Nom = '"+Nom1+"'  where ID ='"+IDs+"'");  
					
                                        stm.executeUpdate("update site set IDsite = '"+IDsite1+"'  where ID ='"+IDs+"'");  
				stm.close();
				cnx.close ();
				//JOptionPane.showMessageDialog(AjouteSeance, "seance ajouté avec succé", "Ajouter",JOptionPane.INFORMATION_MESSAGE) ;
				modifSite.dispose();
				}
				catch(Exception ex)
				{
					JOptionPane.showMessageDialog(modifSite, "Erreur d'ajout verifier les champs", "Erreur",JOptionPane.ERROR_MESSAGE) ;
				}
				
		}
		if(e.getSource()==annuler){
			modifSite.dispose();
		}
		
	}}

