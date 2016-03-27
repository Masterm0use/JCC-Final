/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package verzamelappfx;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
    import javafx.stage.Stage;

/**
 *
 * @author Mastermouse
 */
public class VerzamelAppFX extends Application {
    
    public Inventaris inventaris;
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, FileNotFoundException, SQLException {
        
        VerzamelAppFX verzamelAppfx = new VerzamelAppFX();
        verzamelAppfx.setInventaris();
        launch(args);
    }
    
     private void setInventaris() throws IOException, FileNotFoundException, SQLException {
        inventaris = new Inventaris();
    }
    
}
