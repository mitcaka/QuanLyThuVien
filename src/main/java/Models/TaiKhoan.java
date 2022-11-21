/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author ADMIN
 */
public class TaiKhoan {
    private String Username;
    private String Password;
    private int lv;

    public TaiKhoan(String Username, String Password, int lv) {
        this.Username = Username;
        this.Password = Password;
        this.lv = lv;
    }

    public TaiKhoan() {
    }

    public String getUsername() {
        return Username;
    }

    public String getPassword() {
        return Password;
    }

    public int getLv() {
        return lv;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public void setLv(int lv) {
        this.lv = lv;
    }
    
    
}
