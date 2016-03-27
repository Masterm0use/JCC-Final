/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package verzamelapp;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.*;

/**
 *
 * @author joel
 */
public class VerzamelApp {

    /**
     * @param args the command line arguments
     */
    public Inventaris inventaris;

    public static void main(String[] args) throws IOException, FileNotFoundException, SQLException {

        VerzamelApp verzamelApp = new VerzamelApp();

        verzamelApp.setInventaris();

        Set setbier = new Set("Goedbier", 2015);
        Set setpost = new Set("Oude Postzegels", 1980);
        

     //   verzamelApp.inventaris.add(setbier);
    //    verzamelApp.inventaris.add(setpost);
        //verzamelApp.inventaris.add(heinekendop);
      //  verzamelApp.inventaris.add(nlpostzegel);
      // verzamelApp.inventaris.add(nlpostzegel3);
       // verzamelApp.inventaris.add(nlpostzegel2);

    //    setbier.add(heinekendop);
    //    setbier.add(nlpostzegel);

        for (int i = 0; i > -1; i++) {
            System.out.println("druk op 1 voor nieuw object.");
            System.out.println("druk op 2 voor nieuwe set.");
            System.out.println("druk op 3 voor alle objecten in de inventaris.");
            System.out.println("druk op 4 voor alle sets.");
            System.out.println("druk op 5 om te stoppen.");

            Scanner input = new Scanner(System.in, "UTF-8");
            int antwoord = input.nextInt();
            switch (antwoord) {
                case 1:
                    verzamelApp.nieuwObject();
                    break;
                case 2:
                    verzamelApp.nieuwSet();
                    break;
                case 3:
                    verzamelApp.showList(verzamelApp.inventaris.getVoorwerpen());
                    break;
                case 4:
                    verzamelApp.showListSets(verzamelApp.inventaris.getSets());
                    break;
                case 5:
                    break;
                default:
                    break;
            }
        }

    }

    private void setInventaris() throws IOException, FileNotFoundException, SQLException {
        inventaris = new Inventaris();
    }

    public void showList(List<Voorwerp> lijst) {
        int i = 0;
        for (Voorwerp v : lijst) {

            System.out.println(i + " : " + v.getNaam());
            i += 1;
        }

        System.out.println("Type nummer om te wissen");
        System.out.println("Type -1 om terug te gaan");
        System.out.println("Type -2 om te sorteren op jaar");

        Scanner input = new Scanner(System.in, "UTF-8");
        int antwoord = input.nextInt();

        if (antwoord == -1) {

        } else if (antwoord == -2) {
            List<Voorwerp> a = new ArrayList<Voorwerp>(lijst);
            Collections.sort(a);
               i = 0;
            for (Voorwerp v : a) {

                System.out.println(i + " : " + v.getNaam());
                i += 1;
            }
        } else {
            inventaris.wisVoorwerp(antwoord);
        }
    }

    public void showListSets(List<Set> lijst) {
        int i = 0;
        for (Set s : lijst) {

            System.out.println(i + " : " + s.getNaam());
            i += 1;
        }

        System.out.println("Type nummer om te bekijken");
        System.out.println("Type -1 om terug te gaan");

        Scanner input = new Scanner(System.in,"UTF-8");
        int antwoord = input.nextInt();

        if (antwoord < 0) {

        } else {
            showList(inventaris.getSet(antwoord).getVoorwerpen());
        }
    }

    public void nieuwSet() {
        String naam;
        int jaar;

        System.out.println("naam?");
        Scanner input = new Scanner(System.in,"UTF-8");
        naam = input.nextLine();
        System.out.println("jaar?");
        jaar = input.nextInt();

        inventaris.add(new Set(naam, jaar));
    }

    public void nieuwObject() {
        String naam;
        int jaar;

        System.out.println("druk op 1 voor Bierdop.");
        System.out.println("druk op 2 voor Postzegel.");
        Scanner input = new Scanner(System.in,"UTF-8");
        int antwoord = input.nextInt();
        input.nextLine();
        System.out.println("Naam van nieuwe object?");
        naam = input.nextLine();
        System.out.println("jaar?");
        jaar = input.nextInt();

        switch (antwoord) {
            case 1:
                nieuwDopje(jaar, naam);
                break;
            case 2:
                nieuwZegel(jaar, naam);
                break;
            default:
                break;
        }

    }

    public void nieuwDopje(int jaar, String naam) {
        String merk;

        System.out.println("Merk?");
        Scanner input = new Scanner(System.in,"UTF-8");
        merk = input.nextLine();

        inventaris.add(new Bierdopje(merk, naam, jaar));

    }

    public void nieuwZegel(int jaar, String naam) {
        int breedte;
        int lengte;

        System.out.println("breedte?");
        Scanner input = new Scanner(System.in,"UTF-8");
        breedte = input.nextInt();
        System.out.println("lengte?");
        lengte = input.nextInt();
        inventaris.add(new Postzegel(breedte, lengte, naam, jaar));
    }

}
