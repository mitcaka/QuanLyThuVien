/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author ADMIN
 */
public class DanhMuc {
    private int MaDanhMuc;
    private String TenDanhMuc;

    public DanhMuc(int MaDanhMuc, String TenDanhMuc) {
        this.MaDanhMuc = MaDanhMuc;
        this.TenDanhMuc = TenDanhMuc;
    }
    
    public DanhMuc() {
        this.MaDanhMuc = 0;
        this.TenDanhMuc = "";
    }

    public int getMaDanhMuc() {
        return MaDanhMuc;
    }

    public String getTenDanhMuc() {
        return TenDanhMuc;
    }

    public void setMaDanhMuc(int MaDanhMuc) {
        this.MaDanhMuc = MaDanhMuc;
    }

    public void setTenDanhMuc(String TenDanhMuc) {
        this.TenDanhMuc = TenDanhMuc;
    }

    @Override
    public String toString() {
        return this.TenDanhMuc;
    }
    
    
}
