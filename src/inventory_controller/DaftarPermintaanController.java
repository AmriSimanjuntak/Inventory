/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventory_controller;

import inventory_Entity.Barang;
import inventory_KoneksiDatabase.KoneksiDB;
import java.io.IOException;
import java.net.URL;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Amri Simanjuntak;
 */
public class DaftarPermintaanController implements Initializable {

    @FXML
    private AnchorPane pane;
    @FXML
    private TableView<?> tabelview;
    @FXML
    private TableColumn<?, ?> tnomor;
    @FXML
    private TableColumn<?, ?> tkode;
    @FXML
    private TableColumn<?, ?> tstatus;
    @FXML
    private Button detail;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    


    @FXML
    void detailAction(ActionEvent event) throws IOException {
        AnchorPane panes = FXMLLoader.load(getClass().getResource("/inventory_Interface/DetailBarang.fxml"));
        pane.getChildren().setAll(panes);
    }
  

  
    
}
