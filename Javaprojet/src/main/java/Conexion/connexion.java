/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package controleur;
import java.sql.*;
/**
 *
 * @author mathi
 */
public class connexion {
static Connection cnx;
 static Statement st;
 static ResultSet rst;
  
    /**
     * @param args the command line arguments
     */
 
    
  
    
    public static Connection  connecterDB(){
        try{
             
             Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver bien ouvert");
            String url="jdbc:mysql://localhost:3305/edt";
            String user="root";
            String password="";
         
           Connection cnx=DriverManager.getConnection(url,user,password);
          
            return cnx;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
    
}

