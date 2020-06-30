/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventory_Entity;

/**
 *
 * @author Januar Tampubolon
 */
public class Permintaan_barang {
    private int id_detail_permintaan;
    private String nama_barang;
    private String jumlah_permintaan;
    private String gambar_barang;
    private String kode_permintaan_barang;
    private String status_request;
    private String tanggal_permintaan;
    
    public Permintaan_barang(){
        
    }
    
    public Permintaan_barang(Integer id_detail_permintaan, String nama_barang, String jumlah_permintaan, String gambar_barang, String keterangan_barang, String kode_permintaan_barang, String tanggal_permintaan){
        this.id_detail_permintaan = id_detail_permintaan;
        this.nama_barang = nama_barang;
        this.jumlah_permintaan = jumlah_permintaan;
        this.gambar_barang = gambar_barang;
        this.kode_permintaan_barang = kode_permintaan_barang;
        this.tanggal_permintaan = tanggal_permintaan;
        this.status_request = status_request;
       
    }

    public String getTanggal_permintaan() {
        return tanggal_permintaan;
    }

    public void setTanggal_permintaan(String tanggal_permintaan) {
        this.tanggal_permintaan = tanggal_permintaan;
    }

    public String getStatus_request() {
        return status_request;
    }

    public void setStatus_request(String status_request) {
        this.status_request = status_request;
    }

    public String getKode_permintaan_barang() {
        return kode_permintaan_barang;
    }

    public void setKode_permintaan_barang(String kode_permintaan_barang) {
        this.kode_permintaan_barang = kode_permintaan_barang;
    }

    public int getId_detail_permintaan() {
        return id_detail_permintaan;
    }

    public void setId_detail_permintaan(int id_detail_permintaan) {
        this.id_detail_permintaan = id_detail_permintaan;
    }

    public String getNama_barang() {
        return nama_barang;
    }

    public void setNama_barang(String nama_barang) {
        this.nama_barang = nama_barang;
    }

    public String getJumlah_permintaan() {
        return jumlah_permintaan;
    }

    public void setJumlah_permintaan(String jumlah_permintaan) {
        this.jumlah_permintaan = jumlah_permintaan;
    }

    public String getGambar_barang() {
        return gambar_barang;
    }

    public void setGambar_barang(String gambar_barang) {
        this.gambar_barang = gambar_barang;
    }

   

    

}
