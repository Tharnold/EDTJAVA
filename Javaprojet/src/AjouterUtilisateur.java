

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

public class AjouterUtilisateur extends Frame implements ActionListener{
   JFrame modifUtilisateur=new JFrame();
   JFrame modifUtilisateur1=new JFrame();
	JFrame modifUtilisateur2=new JFrame();
	JPanel panelText=new JPanel(new GridLayout(7,1));
	JPanel panelButton=new JPanel();
        JPanel panelText1=new JPanel(new GridLayout(7,1));
	JPanel panelButton1=new JPanel();
        JPanel panelText2=new JPanel(new GridLayout(7,1));
	JPanel panelButton3=new JPanel();
	JLabel ID=new JLabel("ID : ");
	JTextField wID=new JTextField(20);
        JLabel Nom=new JLabel("Nom :");
	JTextField wNom =new JTextField(20);
        JLabel Prenom=new JLabel("Prénom :");
	JTextField wPrenom =new JTextField(20);
        JLabel Mail=new JLabel("Mail :");
	JTextField wMail =new JTextField(20);
        JLabel Mdp=new JLabel("Password :");
	JTextField wMdp =new JTextField(20);
        JLabel Droits=new JLabel(" Droits :");
	JTextField wDroits =new JTextField(20);
	
	JButton valider=new JButton("Valider");
	JButton annuler=new JButton("Annuler");
       
	JLabel Titre=new JLabel("Ajouter un utilisateur");
	
        
	public AjouterUtilisateur()
	{
		super("Ajouter un utilisateur :");
		modifUtilisateur.setLayout(new BorderLayout());
		
		JPanel p1=new JPanel(new GridLayout(1,2));
		p1.add(ID);p1.add(wID);
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
		
		panelText.add(p1);panelText.add(p2);
                panelText.add(p3);panelText.add(p4);
                panelText.add(p5);panelText.add(p7);
               
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
		wNom.addActionListener(this);
                wPrenom.addActionListener(this);
                wMail.addActionListener(this);
                wDroits.addActionListener(this);
                wMdp.addActionListener(this);
	}
      
	
	public void actionPerformed(ActionEvent e) {
		
		
		if(e.getSource()==valider)
		{	
                               
				int IDs=(new Integer(wID.getText()));
				String Nom1=wNom.getText().toString();
                                String Prenom1=wPrenom.getText().toString();
                                String Mail1=wMail.getText().toString();
                                String Mdp1=wMdp.getText().toString();
                                int Droits1=(new Integer(wDroits.getText()));
				
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
					stm.executeUpdate("insert into utilisateur(ID,nom,prenom,email,password,droit)values("+IDs+",'"+Nom1+"','"+Prenom1+"','"+Mail1+"','"+Mdp1+"',"+Droits1+")");  
                                stm.close();
				cnx.close ();
                                modifUtilisateur.dispose();
                                if (Droits1 ==3){
				
                                new AjouterEnseignant();
                                    
				}
                                if (Droits1 == 4){
                                    
                                    new AjouterEtudiant();
           
                                }
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
       