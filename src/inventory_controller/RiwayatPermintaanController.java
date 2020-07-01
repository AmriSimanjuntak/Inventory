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
 * @author Januar Tampubolon
 */
public class RiwayatPermintaanController implements Initializable {

    @FXML
    private TableView<Permintaan_barang> tabelview;
    @FXML
    private TableColumn<Permintaan_barang, Integer> tnomor;
    @FXML
    private TableColumn<Permintaan_barang, String> ttanggal;
    @FXML
    private TableColumn<Permintaan_barang, String> taction;
    @FXML
    private AnchorPane rootPane;
    
    ObservableList<Permintaan_barang> data;
    private Connection connection;
    
    public Integer id_detail_permintaan;
    public String tanggal_permintaan;
    public String status_request;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        tnomor.setCellValueFactory(new PropertyValueFactory<Permintaan_barang, Integer>("id_detail_permintaan"));
        ttanggal.setCellValueFactory(new PropertyValueFactory<Permintaan_barang, String>("tanggal_permintaan"));
        taction.setCellValueFactory(new PropertyValueFactory<Permintaan_barang, String>("status_request"));
        data = FXCollections.observableArrayList();
        tabelview.setItems(data);
        
        tampil();

    }    
   
     public void tampil(){
        showAllPermintaan_barang();
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
        score.setTanggal_permintaan(allProduct.get( i).getTanggal_permintaan());
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
    

    @FXML
    private void btnback(ActionEvent event) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/inventory_Interface/MenuUtamaUser.fxml"));
        rootPane.getChildren().setAll(pane);
    }
 
}
