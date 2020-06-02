/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Enseignant;
import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import static javax.swing.text.html.HTML.Attribute.ID;
/**
 *
 * @author thoma
 */

public class SupprimerEnseignant extends Frame implements ActionListener{
    JFrame SupprEnseignant=new JFrame();
    

	public SupprimerEnseignant()
	{
		super("Ajouter une nouvelle seance :");
                this.setLocation(350,300);
		SupprEnseignant.setLayout(new BorderLayout());
		//panelText.add(Nom);panelText.add(ChNom);
		JPanel p1=new JPanel(new GridLayout(1,2));
		p1.add(ID);p1.add(wID);
		//panelText.add(Prenom);panelText.add(ChPrenom);
		
		panelText.add(p1);
		
		
		Titre.setForeground(Color.RED);Titre.setSize(50,50);
		JPanel ptitre=new JPanel();
		ptitre.add(Titre,BorderLayout.CENTER);
                panelText.add(p1);
		SupprEnseignant.add(ptitre,BorderLayout.NORTH);
		SupprEnseignant.add(panelText,BorderLayout.CENTER);
		SupprEnseignant.add(valider);panelButton.add(annuler);
                
        public class SupprimerEnseignant extends Frame implements ActionListener{
		wID.addActionListener(this);
		
	}
	@Override
	
       
	public void actionPerformed(ActionEvent e) {
		
		
        public class supprimerSeance extends Frame implements ActionListener{
				}
				try
				{
				String url ="jdbc:mysql://localhost:3305/edt";
                                String url ="jdbc:mysql://localhost:3305/edt";
				String user="root";
                                String password="";
         
     
                        Connection cnx=DriverManager.getConnection(url,user,password);
			Statement stm=cnx.createStatement ();
			
					stm.executeUpdate("delete * from enseignant WHERE ID=IDs");       
			    System.out.println ("le driver n'a pu être chargé");
					stm.executeUpdate("delete  from enseignant WHERE ID="+IDs+""); 
                                        System.out.println ("le driver n'a pu être chargé 2");
				stm.close();
				cnx.close ();
		
                                }}}}		//JOptionPane.showMessageDialog(AjouteSeance, "seance ajouté avec succé", "Ajouter",JOptionPane.INFORMATION_MESSAGE) ;