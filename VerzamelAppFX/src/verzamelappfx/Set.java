/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package verzamelappfx;
import java.util.*;
/**
 *
 * @author ruud
 */
public class Set {
    
    private String naam;
    private ArrayList<Set> subSets;
    private ArrayList<Voorwerp> voorwerpen;
    
    public String getNaam(){ return naam; }
    
    public void setNaam(String value)
    { naam = value; }
   
    private int jaar;
    
    public int getJaar() {
        return jaar;
    }
    
    public void setJaar(int jaar) {
        this.jaar = jaar;
    }  
   
    public ArrayList getVoorwerpen() {
        return voorwerpen;
    }
    
    public Set(String naam, int jaar) {
        this.naam = naam;
        this.jaar = jaar;
        this.voorwerpen = new ArrayList<>();
        this.subSets = new ArrayList<>();
    }
    
    public void add(Voorwerp item){
        voorwerpen.add(item);
    }
    
    public Voorwerp FindVoorwerp(String naam){
        for (Voorwerp voor : voorwerpen) {
            if(voor.getNaam()==naam){
            return voor;
            }
            else{
                for (Set subSet : subSets) {
                    if(subSet.FindVoorwerp(naam) != null){
                        return subSet.FindVoorwerp(naam);
                    }
                }
            }
        }
    return null;
    }
    
    @Override
    public String toString() {
        return "Set: " + getNaam() + " - " + getJaar() + " Voorwerpen: " + getVoorwerpen();
    }
}
