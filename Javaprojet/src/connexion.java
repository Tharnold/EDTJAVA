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
    public static void main(String[] args) {
        // TODO code application logic here
        
         //AjouterP(100,"AAAA",50.50,15,"Informatique",1);
        
        //SupprimerParID(3);
        
        //recherchePparLibelle("SOURIS11");
        
    System.out.println("Driver oki 1");
        
                
          try{
      
              cnx=connecterDB(); 
            
              st=cnx.createStatement();
        
              rst=st.executeQuery("SELECT * FROM cours");
              
              while(rst.next()){
               
                  System.out.print(rst.getInt("ID")+"\t");
                  System.out.print(rst.getString("nom")+"\t");
                
                  System.out.println();
              }
          }catch(Exception ex){
              ex.printStackTrace();
          } 
     
    }
    
  
    
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

