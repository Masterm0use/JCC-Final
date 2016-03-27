/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package verzamelappfx;

/**
 *
 * @author joel
 */
public class Voorwerp implements Comparable<Voorwerp>{
    private int jaarVanUitgave;
    public int getJaarVanUitgave() {
        return jaarVanUitgave;
    }
   
    private String naam;
    public String getNaam() {
        return naam;
    }
    
    public Voorwerp(String naam, int jaar)
    {
        jaarVanUitgave = jaar;
        this.naam = naam;
    }
    
    @Override
    public int compareTo(Voorwerp o2) {
        if (this.jaarVanUitgave > o2.getJaarVanUitgave())
        {
            return 1;
        }
        else if (this.jaarVanUitgave < o2.getJaarVanUitgave())
        {
            return -1;
        }
        else return 0;
    }
    
}

