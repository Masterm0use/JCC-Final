/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package verzamelappfx;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Mastermouse
 */
public class AddBierController implements Initializable {

    private Inventaris inv; 
    
    @FXML
    private Button bottonBierToevoegen;
    @FXML
    private TextField bierNaam;
    @FXML
    private TextField bierJaar;
    @FXML
    private TextField bierMerk;
    @FXML
    private TextField postzegelNaam;
    @FXML
    private TextField postzegelJaar;
    @FXML
    private TextField postzegelLengte;
    @FXML
    private TextField postzegelBreedte;
    @FXML
    private Button buttonPostzegelToevoegen;
    @FXML
    private Button buttonSetToevoegen;
    @FXML
    private TextField setNaam;
    @FXML
    private TextField setJaar;
    
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
        int l = Integer.parseInt(bierJaar.getText());
        int b = Integer.parseInt(bierJaar.getText());
        int pjaarint = Integer.parseInt(postzegelJaar.getText());
        
        Voorwerp p1;
            p1 = new Postzegel(b, l, postzegelJaar.getText(), pjaarint);
        inv.add(p1);

        } catch(Exception e) {
           e.printStackTrace();
          }
    }    
    
       
    public void pressToevoegenBier(ActionEvent event) throws Exception { 
        try {
        int bierjaarint = Integer.parseInt(bierJaar.getText());
        Voorwerp v1 = new Bierdopje(bierMerk.getText(), bierNaam.getText(), bierjaarint);
        inv.add(v1);

        } catch(Exception e) {
           e.printStackTrace();
          }
        Stage stage = (Stage) bottonBierToevoegen.getScene().getWindow();
        stage.close();
}
    
    public void pressToevoegenPostzegel(ActionEvent event) throws Exception { 
        try {
        int lengte = Integer.parseInt(postzegelLengte.getText());
        int breedte = Integer.parseInt(postzegelBreedte.getText());
        int jaar = Integer.parseInt(postzegelJaar.getText());
        
        Voorwerp p1 = new Postzegel(lengte, breedte, postzegelNaam.getText(), jaar);
        inv.add(p1);

        } catch(Exception e) {
           e.printStackTrace();
          }
        Stage stage = (Stage) buttonPostzegelToevoegen.getScene().getWindow();
        stage.close();
}
    
    public void pressToevoegenSet(ActionEvent event) throws Exception { 
        try {
        String naam;
        int jaar;
        jaar = Integer.parseInt(setJaar.getText());
        naam = setNaam.getText();
        inv.add(new Set(naam, jaar));
        } catch(Exception e) {
           e.printStackTrace();
          }
        Stage stage = (Stage) buttonSetToevoegen.getScene().getWindow();
        stage.close();
}
}
