/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package verzamelappfx;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.collections.FXCollections;
import static javafx.collections.FXCollections.observableArrayList;
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
import javafx.scene.control.TextField;
import javafx.stage.Stage;


/**
 *
 * @author Mastermouse
 */

public class FXMLDocumentController implements Initializable {
    
    
   private Inventaris inv; 
   ObservableList<String> rekt;
    
    
    @FXML
    private ListView<String> test;
    @FXML
    private Button bottonAddBier;
    @FXML
    private Button bottonAddZegel;
    @FXML
    private Button bottonAddSet;
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

    public FXMLDocumentController() throws IOException, FileNotFoundException, SQLException {
        test = new ListView<>();
        inv = new Inventaris();
//        rekt = test.getItems();
//        
//        
//        
//        for (Voorwerp vw : inv.getVoorwerpen() ) {
//           rekt.add(vw.toString());
//        }
//        
//        test.setItems(rekt);
    }
         //= FXCollections.observableArrayList(inv.getVoorwerpen());
        //test.setItems(kut);
    
     public void pressToevoegenBier(ActionEvent event) throws Exception { 
       
        int bierjaarint = Integer.parseInt(bierJaar.getText());
        Voorwerp v1 = new Bierdopje(bierMerk.getText(), bierNaam.getText(), bierjaarint);
        inv.add(v1);

//        } catch(Exception e) {
//           e.printStackTrace();
//          }
//        Stage stage = (Stage) bottonBierToevoegen.getScene().getWindow();
//        stage.close();
}
    
    public void pressToevoegenPostzegel(ActionEvent event) throws Exception { 
       
        int lengte = Integer.parseInt(postzegelLengte.getText());
        int breedte = Integer.parseInt(postzegelBreedte.getText());
        int jaar = Integer.parseInt(postzegelJaar.getText());
        String naamPostzegel = postzegelNaam.getText();
        
        Voorwerp p1 = new Postzegel(lengte, breedte, naamPostzegel, jaar);
        inv.add(p1);

//        } catch(Exception e) {
//           e.printStackTrace();
//          }
//        Stage stage = (Stage) buttonPostzegelToevoegen.getScene().getWindow();
//        stage.close();
}
    
    public void pressToevoegenSet(ActionEvent event) throws SQLException{ 
       
        String naam;
        int jaar;
        jaar = Integer.parseInt(setJaar.getText());
        naam = setNaam.getText();
        inv.add(new Set(naam, jaar));
    }
//        } catch(Exception e) {
//           e.printStackTrace();
//          }
//        Stage stage = (Stage) buttonSetToevoegen.getScene().getWindow();
//        stage.close();
//}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    //public void pressButtonAddBier(ActionEvent event) throws Exception {               
//        try {
//        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AddBier.fxml"));
//                Parent root = (Parent) fxmlLoader.load();
//                Stage stage = new Stage();
//                stage.setScene(new Scene(root));  
//                stage.show();
//        } catch(Exception e) {
//           e.printStackTrace();
//          }
//    }
//   
//   public void pressButtonAddZegel(ActionEvent event) throws Exception {               
//        try {
//        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AddPostzegel.fxml"));
//                Parent root = (Parent) fxmlLoader.load();
//                Stage stage = new Stage();
//                stage.setScene(new Scene(root));  
//                stage.show();
//        } catch(Exception e) {
//           e.printStackTrace();
//          }
//}
//    
//   public void pressButtonAddSet(ActionEvent event) throws Exception {               
//        try {
//        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AddSet.fxml"));
//                Parent root = (Parent) fxmlLoader.load();
//                Stage stage = new Stage();
//                stage.setScene(new Scene(root));  
//                stage.show();
//        } catch(Exception e) {
//           e.printStackTrace();
//          }
//}
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
}

