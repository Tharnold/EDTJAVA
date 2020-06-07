
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mathi
 */
public class connecterEDT  extends JFrame implements ActionListener{
	//private int ID;
	private Container c;
	private JPanel imagePanel;
	private String image1="C:/Users/mathi/Documents/NetBeansProjects/Javaprojet/img/client.png";

	
	JLabel message=new JLabel("");
	JLabel l=new JLabel("Mot de passe :");
	JTextField mdp=new JPasswordField(10);
	JLabel l2=new JLabel("Adresse mail :");
	JTextField email=new JTextField(10);
        
	JButton valider=new JButton("Se connecter");
	JButton annuler=new JButton("Annuler");
	JPanel p=new JPanel(new BorderLayout());
	JPanel p1=new JPanel(new FlowLayout(FlowLayout.RIGHT));
	JPanel p2=new JPanel(new FlowLayout(FlowLayout.RIGHT));
	JPanel p3=new JPanel(new GridLayout(3,1));
	JPanel p4=new JPanel(new FlowLayout(FlowLayout.LEFT));
	public connecterEDT()  
	{	
		this.setLocation(350,300);
		p1.add(l);p1.add(mdp);mdp.setBackground(Color.WHITE);
		p2.add(l2);p2.add(email);email.setBackground(Color.WHITE);
		p3.add(p2);p3.add(p1);p3.add(message);
		p3.setBackground(Color.WHITE);p2.setBackground(Color.WHITE);p1.setBackground(Color.WHITE);
		p4.add(valider);p4.add(annuler);
		valider.setBackground(Color.WHITE);
		annuler.setBackground(Color.WHITE);
		p4.setBackground(Color.WHITE);
		p.add(p3,BorderLayout.CENTER);p.add(p4,BorderLayout.SOUTH);
		p.setBackground(Color.WHITE);
		add(p,BorderLayout.EAST);
		afficher();
		setSize(500,300);
		setVisible(true);
		setBackground(Color.WHITE);
		
		valider.addActionListener((ActionListener) this);
		annuler.addActionListener((ActionListener) this);
	}
	private void afficher() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		c = getContentPane();
		c.setBackground(Color.WHITE);
		imagePanel = new JPanel() {

			public void paint(Graphics g) {
				try {
					BufferedImage image = ImageIO.read(new File(image1));
                                
					g.drawImage(image, 0, 0, null);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		};
		imagePanel.setPreferredSize(new Dimension(170, 210));
		c.add(imagePanel);
	}
	public static void main(String[]args)
	{       
		new connecterEDT();
	}
	public void actionPerformed(ActionEvent ee) {
		// TODO Auto-generated method stub
		if(ee.getSource()==valider)
		{
			String log=email.getText().toString();
			String mdp1=mdp.getText().toString();
			String logverif=null;
			String mdpverif=null;
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
			}
			catch(Exception e)
			{
				System.out.println ("le driver n'a pu être chargé");
			}
			try
			{String url ="jdbc:mysql://localhost:3305/edt";
				String user="root";
                                String password="";
         
                        Connection cnx=DriverManager.getConnection(url,user,password);
			Statement stm=cnx.createStatement ();
			
                        ResultSet result =stm.executeQuery ("SELECT email,password FROM utilisateur where email='"+log+"' and password='"+mdp1+"'");
                       // ResultSet id= stm.executeQuery ("SELECT ID FROM utilisateur where email='"+log+"' and password='"+mdp1+"'");
                         
				while(result.next())
				{
					
					logverif=result.getString(1);
					mdpverif=result.getString(2);
				}
				if((logverif != null)&&(mdpverif != null))
				{
					new EDT();
				}
				else
				{
					message.setText("Adresse mail ou mot de passe invalides");
					message.setForeground(Color.RED);
				}
				stm.close();
				cnx.close ();
			}
			catch(Exception e)
			{
				e.printStackTrace ();
			}
		}
		if(ee.getSource()==annuler){
			System.exit(1);
		}
                
	}



}


