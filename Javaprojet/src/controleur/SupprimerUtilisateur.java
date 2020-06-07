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

/**
 *
 * @author mathi
 */

public class SupprimerUtilisateur extends Frame implements ActionListener{
   JFrame modifUtilisateur=new JFrame();
   JFrame modifUtilisateur1=new JFrame();
	JFrame modifUtilisateur2=new JFrame();
	JPanel panelText=new JPanel(new GridLayout(7,1));
	JPanel panelButton=new JPanel();
        JPanel panelText1=new JPanel(new GridLayout(7,1));
	JPanel panelButton1=new JPanel();
        JPanel panelText2=new JPanel(new GridLayout(7,1));
	JPanel panelButton3=new JPanel();
	JLabel ID=new JLabel("ID de l'utilisateur que vous souhaitez supprimer: ");
	JTextField wID=new JTextField(20);
        JLabel Droit=new JLabel("Droit de l'utilisateur : ");
	JTextField wDroit=new JTextField(20);
       
	JButton valider=new JButton("Valider");
	JButton annuler=new JButton("Annuler");
       
	JLabel Titre=new JLabel("Ajouter un utilisateur");
	
        
	public SupprimerUtilisateur()
	{
		super("Ajouter un utilisateur :");
		modifUtilisateur.setLayout(new BorderLayout());
		
		JPanel p1=new JPanel(new GridLayout(1,2));
		p1.add(ID);p1.add(wID);
                JPanel p2=new JPanel(new GridLayout(1,2));
		p2.add(Droit);p2.add(wDroit);
		
		
		
		
		panelText.add(p1);panelText.add(p2);
               
		Titre.setForeground(Color.RED);Titre.setSize(50,50);
		JPanel ptitre=new JPanel();
		ptitre.add(Titre,BorderLayout.CENTER);
		modifUtilisateur.add(ptitre,BorderLayout.NORTH);
		modifUtilisateur.add(panelText,BorderLayout.CENTER);
		panelButton.add(valider);panelButton.add(annuler);
		modifUtilisateur.add(panelButton,BorderLayout.SOUTH);
		modifUtilisateur.setVisible(true);
		modifUtilisateur.pack();
		
		valider.addActionListener(this);
		annuler.addActionListener(this);
              
		wID.addActionListener(this);
		
	}
             
	
	public void actionPerformed(ActionEvent e) {
		
		
		if(e.getSource()==valider)
		{	
                               
				int IDs=(new Integer(wID.getText()));
                                int Droit1=(new Integer(wDroit.getText()));
                                
				
				
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
                                stm.executeUpdate("delete  from utilisateur WHERE ID="+IDs+"");
                                if ( Droit1 == 3){
                                 stm.executeUpdate("delete  from enseignant WHERE IDutilisateur ="+IDs+""); 
                                }
                                if ( Droit1 == 4){
                                 stm.executeUpdate("delete  from etudiant WHERE IDutilisateur ="+IDs+""); 
                                }
                                stm.close();
				cnx.close ();
                                modifUtilisateur.dispose();
                                }
				catch(Exception ex)
				{
					JOptionPane.showMessageDialog(modifUtilisateur, "Erreur d'ajout verifier les champs", "Erreur",JOptionPane.ERROR_MESSAGE) ;
				}
				
		}
		if(e.getSource()==annuler){
			modifUtilisateur.dispose();
		}
		
	}
        
}
       