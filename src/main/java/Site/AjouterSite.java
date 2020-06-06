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
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;





public class AjouterSite extends Frame implements ActionListener{
   
	JFrame AjouteSite=new JFrame();
	JPanel panelText=new JPanel(new GridLayout(7,1));
	JPanel panelButton=new JPanel();
	
	JLabel ID=new JLabel("ID :");
	JTextField wID=new JTextField(20);
	JLabel Nom=new JLabel("Nom :");
	JTextField wNom=new JTextField(20);	
  
	JButton valider=new JButton("Valider");
	JButton annuler=new JButton("Annuler");
	JLabel Titre=new JLabel("Ajouter un site ");
	
	public AjouterSite()
	{
		super("Ajouter un nouveau site:");
		AjouteSite.setLayout(new BorderLayout());
		//panelText.add(Nom);panelText.add(ChNom);
		JPanel p5=new JPanel(new GridLayout(1,2));
		p5.add(ID);p5.add(wID);
                JPanel p6=new JPanel(new GridLayout(1,2));
		p6.add(Nom);p6.add(wNom);
		
                panelText.add(p5);
		
                panelText.add(p6);
		Titre.setForeground(Color.RED);Titre.setSize(50,50);
		JPanel ptitre=new JPanel();
		ptitre.add(Titre,BorderLayout.CENTER);
		AjouteSite.add(ptitre,BorderLayout.NORTH);
		AjouteSite.add(panelText,BorderLayout.CENTER);
		panelButton.add(valider);panelButton.add(annuler);
		AjouteSite.add(panelButton,BorderLayout.SOUTH);
		AjouteSite.setVisible(true);
		AjouteSite.pack();
		
		valider.addActionListener(this);
		annuler.addActionListener(this);
		
		wID.addActionListener(this);
                wNom.addActionListener(this);
	}
        
    
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		if(e.getSource()==valider)
		{	
                                int ID,Nom; 
				
				ID=(new Integer(wID.getText()));
                                Nom=(new Integer(wNom.getText()));
                               
				
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
			
					stm.executeUpdate("insert into site values("+ID+",'"+Nom+")");       
				stm.close();
				cnx.close ();
				//JOptionPane.showMessageDialog(AjouteSeance, "seance ajouté avec succé", "Ajouter",JOptionPane.INFORMATION_MESSAGE) ;
				AjouteSite.dispose();
				}
				catch(Exception ex)
				{
					JOptionPane.showMessageDialog(AjouteSite, "Erreur d'ajout verifier les champs", "Erreur",JOptionPane.ERROR_MESSAGE) ;
				}
				
		}
		if(e.getSource()==annuler){
			AjouteSite.dispose();
		}
		
	}
}