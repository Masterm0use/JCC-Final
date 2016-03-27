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
    public String getNaam(){return naam;}
    public void setNaam(String value)
    {naam = value;}
    private int jaar;
    public int getJaar() {
        return jaar;
    }
    public void setJaar(int jaar) {
        this.jaar = jaar;
    }
    
    private ArrayList<Voorwerp> voorwerpen;
    public ArrayList getVoorwerpen() {
        return voorwerpen;
    }
    
    public Set(String naam, int jaar) {
        this.naam = naam;
        this.jaar = jaar;
        this.voorwerpen = new ArrayList<>();
    }
    
    public void add(Voorwerp item){
        voorwerpen.add(item);
    }
}
