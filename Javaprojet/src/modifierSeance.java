/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mathi
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mathi
 */
public class modifierSeance extends Frame implements ActionListener{
   
	JFrame modifSeance=new JFrame();
	JPanel panelText=new JPanel(new GridLayout(7,1));
	JPanel panelButton=new JPanel();
	JLabel ID=new JLabel("rentrez l'id de la séance que vous souhaitez modifier : :");
	JTextField wID=new JTextField(20);
	JLabel IDcours=new JLabel("rentrez le nouvel ID du cours :");
	JTextField wIDcours =new JTextField(20);
        JLabel IDtype=new JLabel("rentrez le nouvel ID du type :");
	JTextField wIDtype =new JTextField(20);
	
	JButton valider=new JButton("Valider");
	JButton annuler=new JButton("Annuler");
	JLabel Titre=new JLabel("Ajouter seance");
	String []tab={"0","1","2","3","4","5","6","7","8","9"};
	public modifierSeance()
	{
		super("Modifier une nouvelle seance :");
		modifSeance.setLayout(new BorderLayout());
		
		JPanel p1=new JPanel(new GridLayout(1,2));
		p1.add(ID);p1.add(wID);
		JPanel p7=new JPanel(new GridLayout(1,2));
		p7.add(IDcours);p7.add(wIDcours);
                JPanel p8=new JPanel(new GridLayout(1,2));
		p8.add(IDtype);p8.add(wIDtype);
		panelText.add(p1);panelText.add(p7);
                panelText.add(p8);
		Titre.setForeground(Color.RED);Titre.setSize(50,50);
		JPanel ptitre=new JPanel();
		ptitre.add(Titre,BorderLayout.CENTER);
		modifSeance.add(ptitre,BorderLayout.NORTH);
		modifSeance.add(panelText,BorderLayout.CENTER);
		panelButton.add(valider);panelButton.add(annuler);
		modifSeance.add(panelButton,BorderLayout.SOUTH);
		modifSeance.setVisible(true);
		modifSeance.pack();
		
		valider.addActionListener(this);
		annuler.addActionListener(this);
		wID.addActionListener(this);
		wIDcours.addActionListener(this);
                wIDtype.addActionListener(this);
	}
             public static void main(String[]args)
	{       
		new modifierSeance();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		if(e.getSource()==valider)
		{	
                                int IDs,IDcours1,IDtype1;
				
				IDs=(new Integer(wID.getText()));
				
				IDcours1=(new Integer(wIDcours.getText()));
                                IDtype1=(new Integer(wIDtype.getText()));
				
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
			
					stm.executeUpdate("update seance set IDcours = "+IDcours1+""); 
                                        stm.executeUpdate("update seance set IDtype = "+IDtype1+"");  
				stm.close();
				cnx.close ();
				//JOptionPane.showMessageDialog(AjouteSeance, "seance ajouté avec succé", "Ajouter",JOptionPane.INFORMATION_MESSAGE) ;
				modifSeance.dispose();
				}
				catch(Exception ex)
				{
					JOptionPane.showMessageDialog(modifSeance, "Erreur d'ajout verifier les champs", "Erreur",JOptionPane.ERROR_MESSAGE) ;
				}
				
		}
		if(e.getSource()==annuler){
			modifSeance.dispose();
		}
		
	}
}
