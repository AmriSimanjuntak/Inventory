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
public class Autentikasi {
   private Integer autentikasi_id;
   private String username;
   private String password;
   private Integer role_id;
   
   public Autentikasi(){
       
   }
   
   public Autentikasi(Integer autentikasi_id, String username, String password, Integer role_id){
       this.autentikasi_id = autentikasi_id;
       this.username = username;
       this.password = password;
       this.role_id = role_id;
   }

    public Integer getAutentikasi_id() {
        return autentikasi_id;
    }

    public void setAutentikasi_id(Integer autentikasi_id) {
        this.autentikasi_id = autentikasi_id;
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

    public Integer getRole_id() {
        return role_id;
    }

    public void setRole_id(Integer role_id) {
        this.role_id = role_id;
    }
}
