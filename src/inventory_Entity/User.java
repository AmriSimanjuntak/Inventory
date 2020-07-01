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
public class User {

    public static Object getSessionFactory() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    private Integer id_user;
    private String nip;
    private String nama;
    private String username;
    private String password;
    private Integer autentikasi_id;
    
    public User(){
        
    }
    
    public User(Integer id_user, String nip, String nama, String username, String password, Integer autentikasi_id){
        this.id_user = id_user;
        this.nama = nama;
        this.nip = nip;
        this.username = username;
        this.password = password;
        this.autentikasi_id = autentikasi_id;
    }

    public Integer getAutentikasi_id() {
        return autentikasi_id;
    }

    public void setAutentikasi_id(Integer autentikasi_id) {
        this.autentikasi_id = autentikasi_id;
    }

    public Integer getId_user() {
        return id_user;
    }

    public void setId_user(Integer id_user) {
        this.id_user = id_user;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
}

