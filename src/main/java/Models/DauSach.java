/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author ADMIN
 */
public class DauSach {
    private String MaSach;
    private int MaDanhMuc;
    private String TenSach;
    private String TacGia;
    private String NamXuatBan;
    private String NhaXuatBan;
    private int SoLuong;
    private String MoTa;

    public DauSach(String MaSach, int MaDanhMuc, String TenSach, String TacGia, String NamXuatBan, String NhaXuatBan, int SoLuong, String MoTa) {
        this.MaSach = MaSach;
        this.MaDanhMuc = MaDanhMuc;
        this.TenSach = TenSach;
        this.TacGia = TacGia;
        this.NamXuatBan = NamXuatBan;
        this.NhaXuatBan = NhaXuatBan;
        this.SoLuong = SoLuong;
        this.MoTa = MoTa;
    }



    public String getNhaXuatBan() {
        return NhaXuatBan;
    }

    public void setNhaXuatBan(String NhaXuatBan) {
        this.NhaXuatBan = NhaXuatBan;
    }

    
    public String getNamXuatBan() {
        return NamXuatBan;
    }

    public void setNamXuatBan(String NamXuatBan) {
        this.NamXuatBan = NamXuatBan;
    }

   

    public DauSach() {
    }

    public String getMaSach() {
        return MaSach;
    }

    public int getMaDanhMuc() {
        return MaDanhMuc;
    }

    public String getTenSach() {
        return TenSach;
    }

    public String getTacGia() {
        return TacGia;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public String getMoTa() {
        return MoTa;
    }

    public void setMaSach(String MaSach) {
        this.MaSach = MaSach;
    }

    public void setMaDanhMuc(int MaDanhMuc) {
        this.MaDanhMuc = MaDanhMuc;
    }

    public void setTenSach(String TenSach) {
        this.TenSach = TenSach;
    }

    public void setTacGia(String TacGia) {
        this.TacGia = TacGia;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    public void setMoTa(String MoTa) {
        this.MoTa = MoTa;
    }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
        return sdf.format(NamXuatBan);
    }
    
    
    
    
}
