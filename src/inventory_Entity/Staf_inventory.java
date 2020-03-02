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
public class Staf_inventory {
    public class Staf_Inventory {
//      public static Object getSessionFactory() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
    private Integer id_staf;
    private String nip;
    private String nama;
    private String username;
    private String password;

        public Integer getId_staf() {
            return id_staf;
        }

        public void setId_staf(Integer id_staf) {
            this.id_staf = id_staf;
        }

        public Integer getAutentikasi_id() {
            return autentikasi_id;
        }

        public void setAutentikasi_id(Integer autentikasi_id) {
            this.autentikasi_id = autentikasi_id;
        }
    private Integer autentikasi_id;
    
    public Staf_Inventory(){
        
    }
    
    public Staf_Inventory(Integer id_staf, String nip, String nama, String username, String password,Integer autentikasi_id){
        this.id_staf = id_staf;
        this.nama = nama;
        this.nip = nip;
        this.username = username;
        this.password = password;
        this.autentikasi_id = autentikasi_id;
    }

    public Integer getId_user() {
        return id_staf;
    }

    public void setId_user(Integer id_user) {
        this.id_staf = id_staf;
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

}
