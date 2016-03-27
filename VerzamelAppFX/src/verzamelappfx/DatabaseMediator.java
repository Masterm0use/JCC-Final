/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package verzamelappfx;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Properties;

/**
 *
 * @author ruud
 */
public class DatabaseMediator 
{
    private Properties props;
    private Connection conn;
    
    
    
    
    public DatabaseMediator(Properties props)
    {
        configure(props);
        
    }
    
    public final boolean configure(Properties props) 
    {
        this.props = props;
        try {
            initConnection();
            return true;
            } catch (SQLException ex) {
            System.err.println(ex.getMessage());
            this.props = null;
            return false;
        } finally {
            closeConnection();
        }
    }
    
     private void initConnection() throws SQLException 
     {
        String driver = props.getProperty("driver");
        if (driver != null) {
            System.setProperty("jdbc.drivers", driver);
        }
        String url = props.getProperty("url");
        String username = props.getProperty("username");
        String password = props.getProperty("password");

        conn = DriverManager.getConnection(url, username, password);
        conn.setAutoCommit(true);
    }
     private void closeConnection() 
     {
        try {
            conn.close();
            conn = null;
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
     
     public ArrayList<Voorwerp> loadItems() throws IOException, SQLException{
       ArrayList<Voorwerp> voorwerpen = new ArrayList<>();
          try {
            initConnection();
            Statement stat = conn.createStatement();
            Statement stat1 = conn.createStatement();
            // EERSTE RONDE
            ResultSet rs = stat.executeQuery("SELECT * FROM Bierdop");
            
            Voorwerp vw = null;
            while (rs.next()) {
                int id = rs.getInt("id");
                String merk = rs.getString("merk");
                ResultSet rs2 = stat1.executeQuery("Select * FROM Voorwerp WHERE id =" + id);
                while(rs2.next()){
                    String naam = rs2.getString("naam");
                    int jaar = rs2.getInt("jaarVanUitgave");
                    vw = new Bierdopje(merk,naam,jaar);
                }
                rs2.close();
                voorwerpen.add(vw);
            }
            rs.close();
            vw = null;
            Statement statP = conn.createStatement();
            Statement statP1 = conn.createStatement();
            ResultSet rsP = statP.executeQuery("SELECT * FROM Postzegel");
            while(rsP.next()){
                int id = rsP.getInt("id");
                int breedte = rsP.getInt("Breedte");
                int lengte = rsP.getInt("lengte");
                ResultSet rsP2 = statP1.executeQuery("Select * FROM Voorwerp WHERE id =" + id);
                while(rsP2.next()){
                    String naam = rsP2.getString("naam");
                    int jaar = rsP2.getInt("jaarVanUitgave");
                    vw = new Postzegel(breedte,lengte,naam,jaar);
                }
                voorwerpen.add(vw);
            }
            
            } catch (SQLException exc) {
            System.err.println(exc.getMessage());
        } finally {
            closeConnection();
        }
         return voorwerpen;  
     }
     public ArrayList<Set> loadSets(ArrayList<Voorwerp> voorwerpen) throws SQLException{
         ArrayList<Set> sets = new ArrayList<>();
          try {
            initConnection();
            Statement stat = conn.createStatement();
            Statement stat1 = conn.createStatement();
            // EERSTE RONDE
            ResultSet rs = stat.executeQuery("SELECT * FROM Sets");
            
            Set set = null;
            while (rs.next()) {
                int id = rs.getInt("id");
                String naam = rs.getString("naam");
                set = new Set(naam, 2016);
               
                sets.add(set);
            }
          }catch (SQLException exc) {
            System.err.println(exc.getMessage());
        } finally {
            closeConnection();
        }        
         return sets;
     }
     public void save(Inventaris inv) throws SQLException{
     int i = 0;    
         
     initConnection();
     Statement stat = conn.createStatement();
     Statement stat2 = conn.createStatement();
     stat.executeUpdate("DELETE FROM Voorwerp");
     stat2.executeUpdate("DELETE FROM Sets");
     
     PreparedStatement psVullenVoorwerp = conn.prepareStatement(
                "INSERT INTO Voorwerp (id,naam,jaarVanUitgave) VALUES(?,?,?)");
     
        for (Voorwerp vw : inv.getVoorwerpen() ) {
             psVullenVoorwerp.setInt(1, i);
             psVullenVoorwerp.setString(2, "derp");
             psVullenVoorwerp.setInt(3, 1900);
              psVullenVoorwerp.executeUpdate();
             i += 1;
             
         }

     closeConnection();
     
     }
     
}
