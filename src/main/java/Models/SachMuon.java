/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author ADMIN
 */
public class SachMuon {
   private String MaDS;
   private int MaSach;
   private String TenSach;
   private String TacGia;

    public SachMuon() {
    }

    public SachMuon(String MaDS, int MaSach, String TenSach) {
        this.MaDS = MaDS;
        this.MaSach = MaSach;
        this.TenSach = TenSach;
    }

    public SachMuon(String MaDS, int MaSach, String TenSach, String TacGia) {
        this.MaDS = MaDS;
        this.MaSach = MaSach;
        this.TenSach = TenSach;
        this.TacGia = TacGia;
    }
    
    public String getTacGia() {
        return TacGia;
    }

    public void setTacGia(String TacGia) {
        this.TacGia = TacGia;
    }
    
    public String getMaDS() {
        return MaDS;
    }

    public int getMaSach() {
        return MaSach;
    }

    public String getTenSach() {
        return TenSach;
    }

    public void setMaDS(String MaDS) {
        this.MaDS = MaDS;
    }

    public void setMaSach(int MaSach) {
        this.MaSach = MaSach;
    }

    public void setTenSach(String TenSach) {
        this.TenSach = TenSach;
    }

    @Override
    public String toString() {
        return "" + "" + MaDS + "_" + MaSach + "        " + TenSach;
    }
   
    
}
