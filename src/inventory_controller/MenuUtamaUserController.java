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
 * @author Januar Tampubolon
 */
public class MenuUtamaUserController implements Initializable {

    @FXML
    private AnchorPane rootPane;
    @FXML
    private Button ShowRiwayat;
    @FXML
    private Button buatForm;
    @FXML
    private Button btnlgn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ShowBarang(ActionEvent event) throws IOException {
        AnchorPane panes = FXMLLoader.load(getClass().getResource("/inventory_Interface/RiwayatPermintaan.fxml"));
            rootPane.getChildren().setAll(panes);
    }

    @FXML
    private void ShowPermintaan(ActionEvent event) throws IOException {
        AnchorPane panes = FXMLLoader.load(getClass().getResource("/inventory_Interface/FormPermintaanBarang.fxml"));
            rootPane.getChildren().setAll(panes);
    }

    @FXML
    private void backlgn(ActionEvent event)  throws IOException {
         AnchorPane pane = FXMLLoader.load(getClass().getResource("/inventory_Interface/Login.fxml"));
        rootPane.getChildren().setAll(pane);
    }
}
    
