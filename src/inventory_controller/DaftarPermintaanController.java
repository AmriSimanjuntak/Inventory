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
import inventory_Entity.Permintaan_barang;
import inventory_KoneksiDatabase.KoneksiDB;
import java.sql.Connection;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Amri Simanjuntak;
 */
public class DaftarPermintaanController implements Initializable {

    @FXML
    private AnchorPane pane;
    @FXML
    private TableView<Permintaan_barang> tabelview;
    @FXML
    private TableColumn<Permintaan_barang,Integer> tnomor;
    @FXML
    private TableColumn<Permintaan_barang, String> tkode;
    @FXML
    private TableColumn<Permintaan_barang, String> tstatus;
    @FXML
    private Button detail;
     ObservableList<Permintaan_barang> data;
    private Connection connection;
    
    public Integer id_detail_permintaan;
    public String kode_permintaan_barang;
    public String status_request;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        tnomor.setCellValueFactory(new PropertyValueFactory<Permintaan_barang, Integer>("id_detail_permintaan"));
        tkode.setCellValueFactory(new PropertyValueFactory<Permintaan_barang, String>("kode_permintaan_barang"));
        tstatus.setCellValueFactory(new PropertyValueFactory<Permintaan_barang, String>("status_request"));
        data = FXCollections.observableArrayList();
        tabelview.setItems(data);
        
        tampil();
    }    
    public void tampil(){
        showAllPermintaan_barang();
    }


    @FXML
    void detailAction(ActionEvent event) throws IOException {
        AnchorPane panes = FXMLLoader.load(getClass().getResource("/inventory_Interface/DetailBarang.fxml"));
        pane.getChildren().setAll(panes);
    }

    private void showAllPermintaan_barang() {
       ArrayList<Permintaan_barang> allData = getShowAllPermintaan_barang();        
        for(int i=0; i<allData.size(); i++){
            setShowAllPermintaan_barang(allData, i);
           
        } 
    }
    
     public void setShowAllPermintaan_barang(ArrayList<Permintaan_barang> allProduct, int i){
        Permintaan_barang score = new Permintaan_barang();
        
        score.setId_detail_permintaan(allProduct.get(i).getId_detail_permintaan());
        score.setKode_permintaan_barang(allProduct.get( i).getKode_permintaan_barang());
        score.setStatus_request(allProduct.get(i).getStatus_request());
//        score.setLokasi_barang(allProduct.get( i).getLokasi_barang());
//         score.setKondisi_barang(allProduct.get( i).getKondisi_barang());
        data.add(score);
        
        tabelview.setItems(data);
        tabelview.setOnMouseClicked(new EventHandler<MouseEvent>(){

            @Override
            public void handle(MouseEvent event) {
//                onClick();
            }
            
        });
    }
    
      public ArrayList<Permintaan_barang> getShowAllPermintaan_barang(){
        KoneksiDB db = new KoneksiDB();
        ArrayList<Permintaan_barang> allProduct = db.getAllPermintaan_barang();      
        return allProduct;
    }
  

  
    
}
