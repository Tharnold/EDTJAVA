/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author thoma
 */


package Enseignant;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.*;
public class AjouterEnseignant extends Frame implements ActionListener {
	
        JTextField wIDcours =new JTextField(20);
        JLabel IDUtilisateur=new JLabel("ID Utilisateur :");
        JTextField wIDUtilisateur =new JTextField(20);
	JButton valider=new JButton("Valider");
	JButton annuler=new JButton("Annuler");
	JLabel Titre=new JLabel("Ajouter un enseignant");
        
	public AjouterEnseignant()
	{
		super("Ajouter Un Nouvel Enseignant");
                 
                wIDcours.addActionListener(this);
                wIDUtilisateur.addActionListener(this);
               
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
        }}