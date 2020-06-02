/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilisateur;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author thoma
 */

public class AjouterUtilisateur extends Frame implements ActionListener {
	
        
        JLabel IDUtilisateur=new JLabel("ID Utilisateur :");
        JTextField wIDUtilisateur =new JTextField(20);
        JTextField wNom =new JTextField(20);
        JTextField wPrenom =new JTextField(20);
        JTextField wMail =new JTextField(20);
        JTextField wMdp =new JTextField(20);
        JTextField wDroits =new JTextField(20);
	JButton valider=new JButton("Valider");
	JButton annuler=new JButton("Annuler");
	JLabel Titre=new JLabel("Ajouter un Utilisateur");
        
	public AjouterUtilisateur()
	{
		super("Ajouter Un Nouvel Utilisateur");
                 
                
                wIDUtilisateur.addActionListener(this);
                wNom.addActionListener(this);
                wPrenom.addActionListener(this);
                wMail.addActionListener(this);
                wMdp.addActionListener(this);
                wDroits.addActionListener(this);
                
              
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
        }}