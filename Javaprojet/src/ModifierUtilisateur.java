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

public class ModifierUtilisateur extends Frame implements ActionListener{
   
	JFrame modifUtilisateur=new JFrame();
	JPanel panelText=new JPanel(new GridLayout(7,1));
	JPanel panelButton=new JPanel();
	JLabel ID=new JLabel("rentrez l'id de l'utilisateur que vous souhaitez modifier : ");
	JTextField wID=new JTextField(20);
        JLabel Nom=new JLabel("rentrez le nouveau Nom :");
	JTextField wNom =new JTextField(20);
        JLabel Prenom=new JLabel("rentrez le nouveau PrÃ©nom :");
	JTextField wPrenom =new JTextField(20);
        JLabel Mail=new JLabel("rentrez le nouveau Mail :");
	JTextField wMail =new JTextField(20);
        JLabel Mdp=new JLabel("rentrez le nouveau mdp :");
	JTextField wMdp =new JTextField(20);
        JLabel Droits=new JLabel("rentrez les nouveaux Droits :");
	JTextField wDroits =new JTextField(20);
	
	JButton valider=new JButton("Valider");
	JButton annuler=new JButton("Annuler");
	JLabel Titre=new JLabel("Modifier l'utilisateur");
	
        
	public ModifierUtilisateur()
	{
		super("Modifier un utilisateur :");
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
        
	@Override
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
                                        
                        
					stm.executeUpdate("update utilisateur set Nom = '"+Nom1+"'where ID ='"+IDs+"'"); 
                                        stm.executeUpdate("update utilisateur set Prenom = '"+Prenom1+"'where ID ='"+IDs+"'");
                                        stm.executeUpdate("update utilisateur set Mail = '"+Mail1+"'where ID ='"+IDs+"'");
                                        stm.executeUpdate("update utilisateur set Mdp = '"+Mdp1+"'where ID ='"+IDs+"'");
                                        
                                        
				stm.close();
				cnx.close ();
				//JOptionPane.showMessageDialog(AjouteSeance, "seance ajoutÃ© avec succÃ©", "Ajouter",JOptionPane.INFORMATION_MESSAGE) ;
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