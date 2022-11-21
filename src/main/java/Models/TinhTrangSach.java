/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

/**
 *
 * @author ADMIN
 */
public class TinhTrangSach {
    private String idDS;
    private String Tensach;
    private int TrangThaiChoMuon;
    private int TrangThaiChuaMuon;
    public TinhTrangSach() {
    }

    public TinhTrangSach(String idDS, String Tensach, int TrangThaiChoMuon, int TrangThaiChuaMuon) {
        this.idDS = idDS;
        this.Tensach = Tensach;
        this.TrangThaiChoMuon = TrangThaiChoMuon;
        this.TrangThaiChuaMuon = TrangThaiChuaMuon;
    }

    public String getIdDS() {
        return idDS;
    }

    public void setIdDS(String idDS) {
        this.idDS = idDS;
    }

    public String getTensach() {
        return Tensach;
    }

    public void setTensach(String Tensach) {
        this.Tensach = Tensach;
    }

    public int getTrangThaiChoMuon() {
        return TrangThaiChoMuon;
    }

    public void setTrangThaiChoMuon(int TrangThaiChoMuon) {
        this.TrangThaiChoMuon = TrangThaiChoMuon;
    }

    public int getTrangThaiChuaMuon() {
        return TrangThaiChuaMuon;
    }

    public void setTrangThaiChuaMuon(int TrangThaiChuaMuon) {
        this.TrangThaiChuaMuon = TrangThaiChuaMuon;
    }
}
