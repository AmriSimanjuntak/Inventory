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
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author Amri Simanjuntak;
 */
public class DetailBarangController implements Initializable {

    @FXML
    private Label kode;
    @FXML
    private Label nama;
    @FXML
    private Label lokasi;
    @FXML
    private Label kondisi;
    @FXML
    private Label jumlah;
    @FXML
    private Label jenis;
    @FXML
    private Label tanggal;
    @FXML
    private Label masa;
    @FXML
    private AnchorPane pane;

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
    private Button kembail;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        addData();
    }    
    
    public void addData(){
        this.id_barang2 = BarangController.id_barang2;
        this.kode_barang2 = BarangController.kode_barang2;
        this.nama_barang2 = BarangController.nama_barang2;
        this.kondisi_barang2 = BarangController.kondisi_barang2;
        this.jenis_barang2 = BarangController.jenis_barang2;
        this.lokasi_barang2 = BarangController.lokasi_barang2;
        this.jumlah_barang2 = BarangController.jumlah_barang2;
        this.tanggal_masuk2 = BarangController.tanggal_masuk2;
        this.masa_berlaku2 = BarangController.masa_berlaku2;
        
        
        kode.setText(kode_barang2);
        nama.setText(nama_barang2);     
        kondisi.setText(kondisi_barang2);
        jenis.setText(jenis_barang2);
        lokasi.setText(lokasi_barang2);     
        jumlah.setText(jumlah_barang2);
        tanggal.setText(tanggal_masuk2);
        masa.setText(masa_berlaku2);
        
      
        
    }
    @FXML
    private void kembaliAction(ActionEvent event) throws IOException {
        AnchorPane panes = FXMLLoader.load(getClass().getResource("/inventory_Interface/BarangInterface.fxml"));
            pane.getChildren().setAll(panes);
    }
    
}
