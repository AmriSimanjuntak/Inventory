/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventory_controller;

import inventory_KoneksiDatabase.KoneksiDB;
import java.sql.Connection;
import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javax.management.Query;
import javafx.stage.Stage;
import javafx.scene.Scene;
import inventory_Entity.User;
import inventory_Entity.Autentikasi;
import java.sql.SQLException;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author TA-D3TI-01
 */
public class LoginController implements Initializable {

    @FXML
    private AnchorPane rootPane;
    @FXML
    private TextField username;
    @FXML
    private TextField password;
    
    Stage dialogStage = new Stage();
    Scene scene;
    
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    //PreparedStatement ps;
    public LoginController() {
     connection = KoneksiDB.connectdb();
     //Connection connection;
     
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //conn = new SQLConnection()
    }    
    
//    public String usernameAdmin = "admin";
//    public String passwordAdmin = "admin";
//    
    public String savedUsername;
    public String savedPassword;
    private static String QUERY_LOGIN = "select * from autentikasi a where a.username like '";
    
    
    private void runLogin() throws SQLException, IOException{
         executeSQLQuery(QUERY_LOGIN + username.getText() + "'");
    }
    
     private void executeSQLQuery(String sql) throws SQLException, IOException{
         User user = null;
         Autentikasi autentikasi = null;
         ResultSet rs = null;
         try{
         Statement stmt = connection.createStatement();
          //System.out.println("Disini");
         rs = stmt.executeQuery(sql);
         rs.next();
         autentikasi = new Autentikasi(rs.getInt("autentikasi_id"),rs.getString("username"),rs.getString("password"),rs.getInt("role_id"));
         String usersql = "select * from user where autentikasi_id = " + autentikasi.getAutentikasi_id();
//         rs = stmt.executeQuery(usersql);
//         rs.next();
//         user  = new User(rs.getInt("id_user"), rs.getString("nip"), rs.getString("nama"), rs.getString ("username"), rs.getString("password"),rs.getInt("autentikasi_id"));
         
         //user = new User(rs.getInt("id_user"),rs.getString("nama"),rs.getString("nip"),rs.getString("username"),rs.getString("Password"));
             System.out.println(autentikasi.getRole_id());
         //rs.close();
         stmt.close();
         }catch(SQLException ex){
                System.out.println("SQLException: " + ex.getMessage());
                System.out.println("SQLState: " + ex.getSQLState());
                System.out.println("VendorError: " + ex.getErrorCode());        
        }
         
//         if(rs==null){
//             System.out.println("Invalide Username or Paswword2");
//         } 
//         System.out.println(autentikasi.getPassword()+" ssss");
         if(autentikasi.getPassword().equals(password.getText())){
             //System.out.println(autentikasi.getRole_id()+ " ssss");
             if(autentikasi.getRole_id() == 1){
                //System.out.println("1");
                AnchorPane pane = FXMLLoader.load(getClass().getResource("/inventory_Interface/MenuUtamaUser.fxml"));
                rootPane.getChildren().setAll(pane);
             }else if(autentikasi.getRole_id() == 2){
                 //System.out.println("2");
                 AnchorPane pane = FXMLLoader.load(getClass().getResource("/inventory_Interface/MenuUtamaAdmin.fxml"));
                 rootPane.getChildren().setAll(pane); 
             }
          
         
         
   //      Koneksi db = new Koneksi();
   //connection = Koneksi.connectdb();
   //ps = connection.prepareStatement("SELECT Username, Password FROM User WHERE Username = ? AND Password = ?");
     //ps.setString(1, savedUsername);
     //ps.setString(2, savedUsername);
//  ResultSet result = ps.executeQuery();
//   if(result.next()){
//        System.out.println("Login Successesfully");
//     
//
//      }
//        else{
//            System.out.println("Invalide Username Or Password");
//        }
   }    else{
//                System.out.println("Invalide Username Or Password");
            Alert alert = new Alert(Alert.AlertType.NONE, "Invalid Username Or Password", ButtonType.OK);
            alert.setTitle("Kesalahan pada Login");
            alert.showAndWait();
         }
         
     }
   
     
     

    @FXML
    private void btnLogin(ActionEvent event) throws SQLException, IOException {
        runLogin();
    }

//    @FXML
//    private void btnRegister(ActionEvent event) throws IOException {
//         AnchorPane pane = FXMLLoader.load(getClass().getResource("/Views/Register.fxml"));
//        rootPane.getChildren().setAll(pane);
//    }

    private void infoBox(String please_enter_correct_Username_and_Password, Object object, String failed) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
