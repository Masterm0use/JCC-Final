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
public class Postzegel extends Voorwerp {
    
    private int breedte;
    private int lengte;
    
    
    public Postzegel (int breedte, int lengte, String naam, int jaar) {
        super (naam, jaar);    
        
        this.breedte = breedte;
        this.lengte = lengte;
    }
    
    @Override
    public String toString() {
        return "Postzegel: " + getNaam() + " - " + getJaarVanUitgave() + " br: " + breedte + " le: "+lengte;
    }
}