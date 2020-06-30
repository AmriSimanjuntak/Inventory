/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventory_controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Amri Simanjuntak;
 */
public class MenuUtamaAdminController implements Initializable {

    @FXML
    private Button ShowPermintaan;
    @FXML
    private Button ShowBarang;
    //private AnchorPane pane;
    @FXML
    private Button btnlgn;
    @FXML
    private AnchorPane rootpane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ShowPermintaan(ActionEvent event) throws IOException {
        AnchorPane panes = FXMLLoader.load(getClass().getResource("/inventory_Interface/DaftarPermintaan.fxml"));
            rootpane.getChildren().setAll(panes);
    }

    @FXML
    private void ShowBarang(ActionEvent event) throws IOException {
        AnchorPane panes = FXMLLoader.load(getClass().getResource("/inventory_Interface/BarangInterface.fxml"));
            rootpane.getChildren().setAll(panes);
    }

    @FXML
    private void backlgn(ActionEvent event)  throws IOException {
         AnchorPane pane = FXMLLoader.load(getClass().getResource("/inventory_Interface/Login.fxml"));
        rootpane.getChildren().setAll(pane);
    }
    
}
