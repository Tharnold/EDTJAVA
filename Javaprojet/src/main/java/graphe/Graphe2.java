import org.jfree.chart.JFreeChart;
import org.jfree.chart.ChartFactory;
import org.jfree.data.jdbc.JDBCCategoryDataset;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.ChartFrame;
/*
 * To change this license
header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mathi
 */
public class Graphe2  {
    
    
    public static void main(String[] args){
     try{
         String query = "select nom,droit from utilisateur";
         JDBCCategoryDataset dataset= new JDBCCategoryDataset(connexion.connecterDB(), query);
         JFreeChart chart = ChartFactory.createLineChart("notre graphe","nom","droit de l'utilisateur", dataset, PlotOrientation.VERTICAL, false, true, true);
        // ChartUtilities.saveChartAsJPEG(new File("C:/Users/mathi/Documents/imgfinalPieChat.jpeg"), chart, 500, 300);
 ChartFrame b = new ChartFrame("Query Chart", chart);
 b.setLocation(350,300);
 b.setVisible(true);
 b.setSize (600,400);
     }catch(Exception e){
         System.out.println("erreur");
     }

    }}
