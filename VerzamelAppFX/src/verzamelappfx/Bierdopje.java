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
public class Bierdopje extends Voorwerp{
    
    private String merk;

    public Bierdopje(String merk, String naam, int jaar) {
        super(naam, jaar);
        this.merk = merk;       
    }
    
   @Override
    public String toString() {
        return "Bierdopje:" + getNaam() + " - " + getJaarVanUitgave() + merk;
    }
}
