/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author ADMIN
 */
public class Sach {
    private String MaDS;
    private int MaS;
    private int TrangThai;

    public Sach() {
    }

    public Sach(String MaDS, int MaS, int TrangThai) {
        this.MaDS = MaDS;
        this.MaS = MaS;
        this.TrangThai = TrangThai;
    }

    public String getMaDS() {
        return MaDS;
    }

    public int getMaS() {
        return MaS;
    }

    public int getTrangThai() {
        return TrangThai;
    }

    public void setMaDS(String MaDS) {
        this.MaDS = MaDS;
    }

    public void setMaS(int MaS) {
        this.MaS = MaS;
    }

    public void setTrangThai(int TrangThai) {
        this.TrangThai = TrangThai;
    }
    
    
}
