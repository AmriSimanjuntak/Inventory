/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventory_controller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ResourceBundle;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javax.imageio.ImageIO;
import inventory_Entity.Permintaan_barang;
import inventory_KoneksiDatabase.KoneksiDB;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author Januar Tampubolon
 */
public class FormPermintaanBarangController implements Initializable {

    private FileChooser fileChooser;
    private File file;
    private Path copy,files;
    private String gambar; 
    
    @FXML
    private AnchorPane rootPane;
    @FXML
    private TextField tfNamaBarang;
    @FXML
    private ImageView lihatGambar;
    @FXML
    private TextField tfNamaBarang2;
    @FXML
    private ImageView lihatGambar1;
    @FXML
    private TextField tfjlhBarang2;
    @FXML
    private Button btnselect;
    @FXML
    private Button btnselect2;
    @FXML
    private Button btnsave;
    @FXML
    private TextField tfjlhBarang1;
    @FXML
    private Button clear;
    @FXML
    private Text alert;
    @FXML
    private TextField tfkodeper;
    @FXML
    private TextField tftanggalper;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().addAll(
        new FileChooser.ExtensionFilter("Image Files", "*.png","*.jpg","*jpeg","*.bmp")
    );
        
    }    
    public String image1;
            
    @FXML
    private void pilihGambar(MouseEvent event) {
         try{
            file =  fileChooser.showOpenDialog(null);
        
            if(file != null){
                try {
                    String namaFoto;
                    //namaFoto = tfNamaBarang.getText();
                    BufferedImage bufferedImage = ImageIO.read(file);
                    Image image = SwingFXUtils.toFXImage(bufferedImage, null);
                    lihatGambar.setFitWidth(180);
                    lihatGambar.setFitHeight(110);
                    lihatGambar.setPreserveRatio(true);
                    lihatGambar.setImage(image);
                    gambar = file.getName();
                    files = Paths.get(file.toURI());
                    image1=gambar;
                    System.out.println(gambar);
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    @FXML
    private void pilihGambar2(MouseEvent event) {
         try{
            file =  fileChooser.showOpenDialog(null);
        
            if(file != null){
                try {
                    String namaFoto;
                    //namaFoto = tfNamaBarang.getText();
                    BufferedImage bufferedImage = ImageIO.read(file);
                    Image image = SwingFXUtils.toFXImage(bufferedImage, null);
                    lihatGambar1.setFitWidth(180);
                    lihatGambar1.setFitHeight(110);
                    lihatGambar1.setPreserveRatio(true);
                    lihatGambar1.setImage(image);
                    gambar = file.getName();
                    files = Paths.get(file.toURI());
                    
                    System.out.println(gambar);
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    @FXML
    private void plhgbr(ActionEvent event) {
    }

    @FXML
    private void plhgbr2(ActionEvent event) {
    }

    @FXML
    private void save(ActionEvent event) {
//        if (tfNamaBarang.getText().equals("") || tfjlhBarang1.getText().equals("") || lihatGambar.equals("") || tfNamaBarang2.getText().equals("") || 
//            tfjlhBarang2.getText().equals("") || lihatGambar1.equals("")) {
//            Alert alert = new Alert(Alert.AlertType.NONE, "Semua field harus di isi", ButtonType.OK);
//            alert.setTitle("Gagal");
//            alert.showAndWait();
//            } else {
//                
//                saveImage();
//                //executeSQLQueryInsert();
//            }
        Permintaan_barang score = new Permintaan_barang();
        
        score.setNama_barang(tfNamaBarang.getText());
        score.setJumlah_permintaan(tfjlhBarang1.getText());
        score.setGambar_barang(image1);
        score.setKode_permintaan_barang(tfkodeper.getText());
        score.setTanggal_permintaan(tftanggalper.getText());
        score.setStatus_request("Menunggu");
        
        //score.setGambar_barang(gambar_masuk.getText());
        //score.setKeterangan_barang(keterangan_barang.getText());
       
        KoneksiDB dm = new KoneksiDB();
        if(!dm.addForm(score)){
            alert.setText("Data Tidak Berhasil Ditambah");
        }else{
            alert.setText("Data Berhasil Ditambah");
        }
    }
    
    
    private void saveImage(){
         if (gambar != null) {
            try {
                File dir = new File(System.getProperty("user.dir"));
                copy = Paths.get(dir+"/src/Image/"+gambar);
                CopyOption[] options = new CopyOption[]{
                        StandardCopyOption.REPLACE_EXISTING,
                        StandardCopyOption.COPY_ATTRIBUTES
                };
                Files.copy(files, copy,options);
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
            
        }
     }


    @FXML
    private void back(ActionEvent event) throws IOException {
         AnchorPane pane = FXMLLoader.load(getClass().getResource("/inventory_Interface/MenuUtamaUser.fxml"));
        rootPane.getChildren().setAll(pane);
    }

    @FXML
    private void clear(ActionEvent event) {
        tfNamaBarang.clear();
        tfjlhBarang1.clear();
        //lihatGambar.clear();
        tfNamaBarang2.clear();
        tfjlhBarang2.clear();
        tfkodeper.clear();
        
        
    }
    
}
