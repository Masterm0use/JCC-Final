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
    
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
    
    
    
    public void pressToevoegenBier(ActionEvent event) throws Exception { 
        try {
        int bierjaarint = Integer.parseInt(bierJaar.getText());
        Voorwerp heinekendop = new Bierdopje(bierMerk.getText(), bierNaam.getText(), bierjaarint);
        inv.add(heinekendop);

        } catch(Exception e) {
           e.printStackTrace();
          }
}
}
