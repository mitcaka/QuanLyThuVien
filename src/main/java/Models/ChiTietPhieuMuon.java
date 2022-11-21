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
public class ChiTietPhieuMuon {
    private int idSach;
    private int idPhieuMuon;
    private Date NgayTra;
    private String TinhTrangSach;
    private float MucPhat;

    public int getIdSach() {
        return idSach;
    }

    public void setIdSach(int idSach) {
        this.idSach = idSach;
    }

    public int getIdPhieuMuon() {
        return idPhieuMuon;
    }

    public void setIdPhieuMuon(int idPhieuMuon) {
        this.idPhieuMuon = idPhieuMuon;
    }

    public Date getNgayTra() {
        return NgayTra;
    }

    public void setNgayTra(Date NgayTra) {
        this.NgayTra = NgayTra;
    }

    public String getTinhTrangSach() {
        return TinhTrangSach;
    }

    public void setTinhTrangSach(String TinhTrangSach) {
        this.TinhTrangSach = TinhTrangSach;
    }

    public float getMucPhat() {
        return MucPhat;
    }

    public void setMucPhat(float MucPhat) {
        this.MucPhat = MucPhat;
    }

    public ChiTietPhieuMuon(int idSach, int idPhieuMuon, Date NgayTra, String TinhTrangSach, float MucPhat) {
        this.idSach = idSach;
        this.idPhieuMuon = idPhieuMuon;
        this.NgayTra = NgayTra;
        this.TinhTrangSach = TinhTrangSach;
        this.MucPhat = MucPhat;
    }

    
    public ChiTietPhieuMuon() {
        this.idSach = 0;
        this.idPhieuMuon = 0;
        NgayTra = null;
        TinhTrangSach = "";
        MucPhat = 0;
    }
}
