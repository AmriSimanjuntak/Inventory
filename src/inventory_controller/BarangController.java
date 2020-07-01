/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventory_controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import inventory_Entity.Barang;
import javafx.collections.FXCollections;
import javafx.event.EventHandler;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import com.mysql.jdbc.Connection;
import inventory_KoneksiDatabase.KoneksiDB;
import java.sql.Statement;
import java.util.ArrayList;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;


/**
 * FXML Controller class
 * 
 * 
 *
 * @author Amri Simanjuntak;
 */
public class BarangController implements Initializable {
    
    private int id=-1;
    
    @FXML   
    private AnchorPane pane;

    @FXML
    private Button tambah;
    @FXML
    private TableView<Barang> tabelview;    

    ObservableList<Barang> data;

    private Object value = null;
    @FXML
    private TableColumn<Barang, Integer> tnomor;
    @FXML
    private TableColumn<Barang, String> tkode;
    @FXML
    private TableColumn<Barang, String> tnama;
    @FXML
    private TableColumn<Barang, String> tlokasi;
    @FXML
    private TableColumn<Barang, String>  tkondisi;
    private Connection connection;
    private Statement stmt;
    @FXML
    private Button hapusbtn;
    
    public static Integer id_barang2;
    public static String kode_barang2;
    public static String nama_barang2;
    public static String kondisi_barang2;
    public static String jenis_barang2;
    public static String lokasi_barang2;
    public static String jumlah_barang2;
    public static String tanggal_masuk2;
    public static String masa_berlaku2;
    @FXML
    private Button detail;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tnomor.setCellValueFactory(new PropertyValueFactory<Barang, Integer>("id_barang"));
        tkode.setCellValueFactory(new PropertyValueFactory<Barang, String>("kode_barang"));
        tnama.setCellValueFactory(new PropertyValueFactory<Barang, String>("nama_barang"));
        tlokasi.setCellValueFactory(new PropertyValueFactory<Barang, String>("lokasi_barang"));
        tkondisi.setCellValueFactory(new PropertyValueFactory<Barang, String>("kondisi_barang"));
        data = FXCollections.observableArrayList();
        tabelview.setItems(data);
        
        tampil();
    }    
    
    public void tampil(){
        showAllBarang();
    }
    public void showAllBarang(){
        ArrayList<Barang> allData = getShowAllBarang();        
        for(int i=0; i<allData.size(); i++){
            setShowAllBarang(allData, i);
        }   
    }
    public ArrayList<Barang> getShowAllBarang(){
        KoneksiDB db = new KoneksiDB();
        ArrayList<Barang> allProduct = db.getAllBarang();      
        return allProduct;
    }
    public void setShowAllBarang(ArrayList<Barang> allProduct, int i){
        Barang score = new Barang();
        
        score.setId_barang(allProduct.get(i).getId_barang());
        score.setKode_barang(allProduct.get( i).getKode_barang());
        score.setNama_barang(allProduct.get(i).getNama_barang());
        score.setLokasi_barang(allProduct.get( i).getLokasi_barang());
         score.setKondisi_barang(allProduct.get( i).getKondisi_barang());
        data.add(score);
        
        tabelview.setItems(data);
        tabelview.setOnMouseClicked(new EventHandler<MouseEvent>(){

            @Override
            public void handle(MouseEvent event) {
                onClick();
            }
            
        });
    }
    
    @FXML
   void tambahAction(ActionEvent event) throws IOException {
        AnchorPane panes = FXMLLoader.load(getClass().getResource("/inventory_Interface/TambahBarang.fxml"));
            pane.getChildren().setAll(panes);
    }

    @FXML
    void hapus(ActionEvent event) {
        if(id == -1){
            Alert eAlert = new Alert(Alert.AlertType.WARNING);
            eAlert.setHeaderText(null);
            eAlert.setContentText("Tidak ada Row yang di pilih");
            eAlert.showAndWait();   
        }else{
            KoneksiDB db = new KoneksiDB();
            db.openConnection();
            String Query = "DELETE FROM barang where id_barang = "+id;
            try{
                Statement st = connection.createStatement();
                st.executeUpdate(Query);
                st.close();
                this.id = -1;
                showAllBarang();
            }catch(Exception e){};
        }
        
    }

    private void hapusIsiTable(){
        for(int i=0 ; i<tabelview.getItems().size();i++){
            tabelview.getItems().clear();
        }
    }

   public void onClick(){
        if(tabelview.getSelectionModel().getSelectedItem() != null){
        Barang barangSelect = tabelview.getSelectionModel().getSelectedItem();
        this.id_barang2 = (barangSelect.getId_barang());
        this.kode_barang2 = barangSelect.getKode_barang();
        this.nama_barang2 =barangSelect.getNama_barang();
        this.kondisi_barang2 = barangSelect.getKondisi_barang();
        this.jenis_barang2 = barangSelect.getJenis_barang();
        this.lokasi_barang2 = barangSelect.getLokasi_barang();
        this.jumlah_barang2 = barangSelect.getJumlah_barang();
        this.tanggal_masuk2 = barangSelect.getTanggal_masuk();
        this.masa_berlaku2 = barangSelect.getMasa_berlaku();
        }  

    }

    @FXML
    void detailAction(ActionEvent event) throws IOException {
        AnchorPane panes = FXMLLoader.load(getClass().getResource("/inventory_Interface/DetailBarang.fxml"));
        pane.getChildren().setAll(panes);
    }
   
}