/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventory_KoneksiDatabase;

import com.mysql.jdbc.Connection;
import inventory_Entity.Barang;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Amri Simanjuntak;
 */
public class KoneksiDB {
//    private static Connection connection;
//    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
//    private static final String DB_URL = "jdbc:mysql://localhost:3306/db_inventory";
//    private static final String DB_USERNAME = "root";
//    private static final String DB_PASSWORD = "";
 public static Connection con;
    public static Statement stm;
    public static Connection connectdb()
    {
        try
        {
           String url = "jdbc:mysql://localhost:3306/db_inventori?zeroDateTimeBehavior=convertToNull";
           String user = "root";
           String pass= "";
           Class.forName("com.mysql.jdbc.Driver");
           con =(Connection) DriverManager.getConnection(url,user,pass);
           //stm = con.createStatement();
            System.out.println("Koneksi berhasil;");
            return con;
        }
        catch(Exception e)
        {
            System.err.println("koneksi gagal" +e.getMessage());
            //return null;
        }
        return null;
    }    

 
    //private Statement stmt;

     public KoneksiDB() {
        openConnection();
    }
     public void openConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //con =DriverManager.getConnection(url,user,pass);
            stm = con.createStatement();
        } catch (Exception ex) {
        }
    }
     
     public boolean addBarang(Barang rank) {      
        System.out.println(rank.toString());
        try {
            String sql = "INSERT INTO barang(kode_barang, nama_barang, kondisi_barang, jenis_barang, lokasi_barang, jumlah_barang, tanggal_masuk, masa_berlaku) VALUES ('" + rank.getKode_barang()+ "', '"
            + rank.getNama_barang()+"', '"+rank.getKondisi_barang()+"', '"+rank.getJenis_barang()+"', '"+rank.getLokasi_barang()+"', '"+rank.getJumlah_barang()+"', '"+rank.getTanggal_masuk()+"', '"+rank.getMasa_berlaku()+"')";
           java.sql.PreparedStatement stmt = con.prepareStatement(sql);
            stmt.execute();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(KoneksiDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
     
     
     public void removeBarang(String keyword) {
        try {
            String sql = "DELETE FROM barang where id_barang =  '" + keyword + "'";
            stm.execute(sql);
        } catch (SQLException ex) {
            Logger.getLogger(KoneksiDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
    public ArrayList<Barang> getAllBarang() {
          ArrayList<Barang> arr = new ArrayList<>();
        try {
            //con = (Connection) DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            stm = con.createStatement();
            String sql = "SELECT * FROM barang";
            ResultSet rs =  stm.executeQuery(sql);

            while (rs.next()) {
                Barang score = new Barang();
                score.setId_barang(rs.getInt("id_barang"));
                score.setKode_barang(rs.getString("kode_barang"));
                score.setNama_barang(rs.getString("nama_barang"));
                score.setLokasi_barang(rs.getString("lokasi_barang"));
                score.setKondisi_barang(rs.getString("kondisi_barang"));
                score.setJenis_barang(rs.getString("jenis_barang"));
                score.setTanggal_masuk(rs.getString("tanggal_masuk"));
                score.setMasa_berlaku(rs.getString("masa_berlaku"));
                
                arr.add(score);
            }
            return arr;
        } catch (SQLException ex) {
            Logger.getLogger(KoneksiDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;
}
    
}

