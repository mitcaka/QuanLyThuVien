/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.util.Date;

/**
 *
 * @author ADMIN
 */
public class NhanVien {
    private String idNhanVien;
    private String password;
    private String HoTenNV;
    private Date NgaySinh;
    private String DiaChi;
    private String SDT;
    private int PhanQuyen;

    public NhanVien() {
    }

    public NhanVien(String idNhanVien, String password, String HoTenNV, Date NgaySinh, String DiaChi, String SDT, int PhanQuyen) {
        this.idNhanVien = idNhanVien;
        this.password = password;
        this.HoTenNV = HoTenNV;
        this.NgaySinh = NgaySinh;
        this.DiaChi = DiaChi;
        this.SDT = SDT;
        this.PhanQuyen = PhanQuyen;
    }

    public String getIdNhanVien() {
        return idNhanVien;
    }

    public void setIdNhanVien(String idNhanVien) {
        this.idNhanVien = idNhanVien;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getHoTenNV() {
        return HoTenNV;
    }

    public void setHoTenNV(String HoTenNV) {
        this.HoTenNV = HoTenNV;
    }

    public Date getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(Date NgaySinh) {
        this.NgaySinh = NgaySinh;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public int getPhanQuyen() {
        return PhanQuyen;
    }

    public void setPhanQuyen(int PhanQuyen) {
        this.PhanQuyen = PhanQuyen;
    }
}
