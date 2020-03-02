/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventory_controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Januar Tampubolon
 */
public class FormPermintaanBarangController implements Initializable {

    @FXML
    private AnchorPane rootPane;
    @FXML
    private TextField tfNamaBarang;
    @FXML
    private TextField tfNamaBarang1;
    @FXML
    private ImageView lihatGambar;
    @FXML
    private TextField tfNamaBarang2;
    @FXML
    private ImageView lihatGambar1;
    @FXML
    private TextField tfjlhBarang2;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void pilihGambar(MouseEvent event) {
    }
    
}
