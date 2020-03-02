/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventory_controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ShowBarang(ActionEvent event) {
    }

    @FXML
    private void ShowPermintaan(ActionEvent event) {
    }
    
}
