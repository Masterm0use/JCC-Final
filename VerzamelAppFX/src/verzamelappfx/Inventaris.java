/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package verzamelappfx;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.*;

/**
 *
 * @author ruud
 */
public final class Inventaris {
    
    private ArrayList<Voorwerp> voorwerpen;
    private ArrayList<Set> sets;
    private DatabaseMediator DM;
     
   
    public List<Voorwerp> getVoorwerpen() {
        return (List<Voorwerp>) Collections.unmodifiableList(voorwerpen);
    }
     
    public List<Set> getSets() {
        return (List<Set>) Collections.unmodifiableList(sets);
    }

    public Inventaris() throws FileNotFoundException, IOException, SQLException {
        voorwerpen = new ArrayList<>();
        sets = new ArrayList<>();
        Properties props = new Properties();
        try{        File f = new File("properties.properties");
        InputStream is = new FileInputStream(f);
        props.load(is);
        System.out.println(props.getProperty("username"));
        }
         catch(FileNotFoundException ex){
         System.err.println(ex.getMessage());
        }   
      
        Voorwerp heinekendop = new Bierdopje("Heineken", "Heineken Special", 2015);
        Voorwerp nlpostzegel = new Postzegel(20, 60, "Wilhelmina3", 1990);
        Voorwerp nlpostzegel2 = new Postzegel(20, 60, "Wilhelmina2", 1980);
        Voorwerp nlpostzegel3 = new Postzegel(20, 60, "Wilhelmina1", 1970);
        
        Set test1 = new Set("Test", 2016);
        Set test2 = new Set("subTest", 20140);
        test2.add(nlpostzegel3);
        test2.add(heinekendop);
        test1.add(nlpostzegel);
        sets.add(test1);
        test1.addSet(test2);
        System.out.println("aantal voorwerpen:"+ test1.countVoorwerpen());
        
        voorwerpen.add(heinekendop);
        voorwerpen.add(nlpostzegel);
        voorwerpen.add(nlpostzegel2);
        voorwerpen.add(nlpostzegel3);
        
        DM = new DatabaseMediator(props);
        //open();
        //DM.save(this);
    }
    
    public void add(Voorwerp item) throws SQLException{
        voorwerpen.add(item);
        DM.save(this);
    }
    
    public void add(Set item) throws SQLException{
        sets.add(item);
        DM.save(this);
    }
    
    public void wisVoorwerp(int index)
    {
        voorwerpen.remove(index);
    }
    
    public void wisSet(int index)
    {
        sets.remove(index);
    }
    
    public boolean open() throws SQLException, IOException{
        voorwerpen = DM.loadItems();
        sets = DM.loadSets(voorwerpen);
        return true;
    }
    
    public Set getSet(int i)
    {
        return sets.get(i);
    }
}
