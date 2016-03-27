/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package verzamelappfx;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;


/**
 *
 * @author Mastermouse
 */


public class FXMLDocumentController implements Initializable {
    
    
   private Inventaris inv; 
    
    //@FXML
    // private ListView<Voorwerp> test = (ListView<Voorwerp>) inv.getVoorwerpen();
    @FXML
    private Button bottonAddBier;
    @FXML
    private Button bottonAddZegel;
    
    
   public void pressButtonAddBier(ActionEvent event) throws Exception {               
        try {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AddBier.fxml"));
                Parent root = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root));  
                stage.show();
        } catch(Exception e) {
           e.printStackTrace();
          }
    }
   
   public void pressButtonAddZegel(ActionEvent event) throws Exception {               
        try {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AddPostzegel.fxml"));
                Parent root = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root));  
                stage.show();
        } catch(Exception e) {
           e.printStackTrace();
          }
}
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
    }    
       
           
}

