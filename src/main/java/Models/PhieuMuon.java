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
public class PhieuMuon {
    private int MaPhieuMuon;
    private String MaDocGia;    
    private String MaNV;
    private Date NgayMuon;
    private int HanMuon;    
    private int TrangThai;
    private String GhiChu;

    public PhieuMuon(){
        this.MaPhieuMuon = 0;
        this.MaDocGia = "";
        this.MaNV = "";
        NgayMuon = null;
        this.HanMuon = 0;
        this.GhiChu = "";
        this.TrangThai = 0;
    }

    public PhieuMuon(int MaPhieuMuon, String MaDocGia, String MaNV, Date NgayMuon, int HanMuon, int TrangThai, String GhiChu) {
        this.MaPhieuMuon = MaPhieuMuon;
        this.MaDocGia = MaDocGia;
        this.MaNV = MaNV;
        this.NgayMuon = NgayMuon;
        this.HanMuon = HanMuon;
        this.TrangThai = TrangThai;
        this.GhiChu = GhiChu;
    }

    public int getMaPhieuMuon() {
        return MaPhieuMuon;
    }

    public String getMaDocGia() {
        return MaDocGia;
    }

    public String getMaNV() {
        return MaNV;
    }

    public Date getNgayMuon() {
        return NgayMuon;
    }

    public int getHanMuon() {
        return HanMuon;
    }

    public int getTrangThai() {
        return TrangThai;
    }

    public String getGhiChu() {
        return GhiChu;
    }

    public void setMaPhieuMuon(int MaPhieuMuon) {
        this.MaPhieuMuon = MaPhieuMuon;
    }

    public void setMaDocGia(String MaDocGia) {
        this.MaDocGia = MaDocGia;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public void setNgayMuon(Date NgayMuon) {
        this.NgayMuon = NgayMuon;
    }

    public void setHanMuon(int HanMuon) {
        this.HanMuon = HanMuon;
    }

    public void setTrangThai(int TrangThai) {
        this.TrangThai = TrangThai;
    }

    public void setGhiChu(String GhiChu) {
        this.GhiChu = GhiChu;
    }

    @Override
    public String toString() {
        return "PhieuMuon{" + "MaPhieuMuon=" + MaPhieuMuon + ", MaDocGia=" + MaDocGia + ", MaNV=" + MaNV + ", NgayMuon=" + NgayMuon + ", HanMuon=" + HanMuon + ", TrangThai=" + TrangThai + ", GhiChu=" + GhiChu + '}';
    }

    
    
    
}
