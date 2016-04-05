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
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.Callback;


/**
 *
 * @author Mastermouse
 */

public class FXMLDocumentController implements Initializable {
    
    
   private Inventaris inv; 
   List<String> voorwerpUI;
   List<String> setsUI;
    
    @FXML
    private ListView<String> voorwerpenPre;
    @FXML
    private ListView<String> setsPre;
    @FXML
    private Button buttonAddBier;
    @FXML
    private Button buttonAddZegel;
    @FXML
    private TextField txtNaam;
    @FXML
    private TextField txtJaar;
    @FXML
    private TextField txtJaarMerk;
    @FXML
    private TextField txtLengte;
    @FXML
    private TextField setNaam;
    @FXML
    private TextField setJaar;
    @FXML
    private CheckBox cbPostzegel;
    @FXML
    private CheckBox cbBierdopje;
    @FXML
    private Label lbBreedte;

    public FXMLDocumentController() throws IOException, FileNotFoundException, SQLException {
        voorwerpenPre = new ListView<>();
        setsPre = new ListView<>();
        inv = new Inventaris();
        
        voorwerpUI = new ArrayList<String>();
        setsUI = new ArrayList<String>();
    }
    
    public void setList(){
         voorwerpUI.clear();
         voorwerpUI = voorwerpenPre.getItems();
         setsUI.clear();
         setsUI = setsPre.getItems();
        
        for (Voorwerp vw : inv.getVoorwerpen() ) {
           voorwerpUI.add(vw.toString());
        }
        voorwerpenPre.setItems(FXCollections.observableList(voorwerpUI));
        
        for (Set s : inv.getSets()){
            setsUI.add(s.toString());
        }
        setsPre.setItems(FXCollections.observableList(setsUI));
    }
       
     public void pressToevoegenBier(ActionEvent event) throws Exception { 
       
        int bierjaarint = Integer.parseInt(txtJaar.getText());
        Voorwerp v1 = new Bierdopje(txtJaarMerk.getText(), txtNaam.getText(), bierjaarint);
        inv.add(v1);
        setList();
        clearTxt();
}
    
    public void pressToevoegenPostzegel(ActionEvent event) throws Exception { 
       
        int lengte = Integer.parseInt(txtLengte.getText());
        int breedte = Integer.parseInt(txtJaarMerk.getText());
        int jaar = Integer.parseInt(txtJaar.getText());
        String naamPostzegel = txtNaam.getText();
        
        Voorwerp p1 = new Postzegel(lengte, breedte, naamPostzegel, jaar);
        inv.add(p1);
        setList();
        clearTxt();
}
    
    public void pressToevoegenSet(ActionEvent event) throws SQLException{ 
       
        String naam;
        int jaar;
        jaar = Integer.parseInt(setJaar.getText());
        naam = setNaam.getText();
        inv.add(new Set(naam, jaar));
        setList();
        clearTxt();
    }
    
     public void checked(ActionEvent event) throws SQLException{ 
       
        if(cbPostzegel.isSelected() == true){
            cbBierdopje.setSelected(false);
            lbBreedte.setText("Breedte:");
            txtLengte.setDisable(false);
            buttonAddBier.setDisable(true);
            buttonAddZegel.setDisable(false);
            
        } 
        if(cbBierdopje.isSelected() == true){
            cbPostzegel.setSelected(false);
            lbBreedte.setText("Merk:");
            txtLengte.setDisable(true);
            buttonAddZegel.setDisable(true);
            buttonAddBier.setDisable(false);
        }
    }

    public void clearTxt(){
        txtLengte.clear();
        txtJaar.clear();
        txtJaarMerk.clear();
        txtNaam.clear();
        setNaam.clear();
        setJaar.clear();
    }
     
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        setList();
    }    
}

