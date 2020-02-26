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
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Amri Simanjuntak;
 */
public class TambahBarangController implements Initializable {

    @FXML
    private TextField kode_barang;
    @FXML
    private TextField nama_barang;
   
    @FXML
    private TextField kondisi_barang;
    @FXML
    private TextField jenis_barang;
     @FXML
    private TextField lokasi_barang;
    @FXML
    private TextField jumlah_barang;
    @FXML
    private TextField tanggal_masuk;
    @FXML
    private TextField masa_berlaku;
    @FXML
    private Button btnview;
    @FXML
    private Button brnclear;
    @FXML
    private Button btnback;
    @FXML
    private Button btnsave;
   
    @FXML
    private Text alert;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

     
    @FXML
    private void save(ActionEvent event) {
        Barang score = new Barang();
        
        score.setKode_barang(kode_barang.getText());
        score.setNama_barang(nama_barang.getText());
        score.setKondisi_barang(kondisi_barang.getText());
        score.setJenis_barang(jenis_barang.getText());
        score.setLokasi_barang(lokasi_barang.getText());
        score.setJumlah_barang(jumlah_barang.getText());
        score.setTanggal_masuk(tanggal_masuk.getText());
        score.setMasa_berlaku(masa_berlaku.getText());
       
        KoneksiDB dm = new KoneksiDB();
        if(!dm.addBarang(score)){
            alert.setText("Data Tidak Berhasil Ditambah");
        }else{
            alert.setText("Data Berhasil Ditambah");
        }
        
    }
    
    
      @FXML
    private void view(ActionEvent event) throws IOException {
         Stage stage = new Stage();
        ((Node) (event.getSource())).getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("/inventory_Interface/BarangInterface.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void clear(ActionEvent event) {
        kode_barang.clear();
        nama_barang.clear();
        kondisi_barang.clear();
        jenis_barang.clear();
        lokasi_barang.clear();
        jumlah_barang.clear();
        tanggal_masuk.clear();
        masa_berlaku.clear();

       }

    @FXML
    private void back(ActionEvent event) throws IOException {
        Stage stage = new Stage();
        ((Node) (event.getSource())).getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("/inventory_Interface/BarangInterface.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }
}


