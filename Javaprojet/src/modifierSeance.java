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
         JLabel semaine=new JLabel("rentrez la nouvelle semaine :");
	JTextField wSemaine =new JTextField(20);
         JLabel date=new JLabel("rentrez la nouvelle date :");
	JTextField wDate =new JTextField(20);
         JLabel HD=new JLabel("rentrez l'heure de début :");
	JTextField wHD =new JTextField(20);
         JLabel HF=new JLabel("rentrez l'heure de fin :");
	JTextField wHF =new JTextField(20);
	
	JButton valider=new JButton("Valider");
	JButton annuler=new JButton("Annuler");
	JLabel Titre=new JLabel("Modifier seance");
	
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
                 JPanel p9=new JPanel(new GridLayout(1,2));
		p9.add(semaine);p9.add(wSemaine);
                 JPanel p12=new JPanel(new GridLayout(1,2));
		p12.add(date);p12.add(wDate);
                 JPanel p10=new JPanel(new GridLayout(1,2));
		p10.add(HD);p10.add(wHD);
                 JPanel p11=new JPanel(new GridLayout(1,2));
		p11.add(HF);p11.add(wHF);
		panelText.add(p1);panelText.add(p7);
                panelText.add(p8); panelText.add(p9);
                 panelText.add(p11); panelText.add(p10);
                 panelText.add(p12);
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
             
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		if(e.getSource()==valider)
		{	
                                int IDs,IDcours1,IDtype1;
				
				IDs=(new Integer(wID.getText()));
				String date=wDate.getText().toString();
                               String heureD=wHD.getText().toString();
                               String heureF=wHF.getText().toString();
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
			
					stm.executeUpdate("update seance set IDcours = '"+IDcours1+"'where ID ='"+IDs+"'"); 
                                        stm.executeUpdate("update seance set IDtype = '"+IDtype1+"'  where ID ='"+IDs+"'"); 
                                        stm.executeUpdate("update seance set date = '"+IDtype1+"'  where ID ='"+IDs+"'");  
                                        stm.executeUpdate("update seance set heure_debut = '"+heureD+"'  where ID ='"+IDs+"'");  
                                        stm.executeUpdate("update seance set heure_fin = '"+heureF+"'  where ID ='"+IDs+"'");  
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
        public static void main(String[]args)
	{       
		new modifierSeance();
	}
}
