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
public class DocGia {
    private String MaDocGia;
    private String HoTen;
    private String DiaChi;
    private String Email;
    private Date NgaySinh;
    private String SDT;

    public DocGia() {
    }

    public DocGia(String MaDocGia, String HoTen, String DiaChi, String Email, Date NgaySinh, String SDT) {
        this.MaDocGia = MaDocGia;
        this.HoTen = HoTen;
        this.DiaChi = DiaChi;
        this.Email = Email;
        this.NgaySinh = NgaySinh;
        this.SDT = SDT;
    }

    public String getMaDocGia() {
        return MaDocGia;
    }

    public String getHoTen() {
        return HoTen;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public String getEmail() {
        return Email;
    }

    public Date getNgaySinh() {
        return NgaySinh;
    }

    public void setMaDocGia(String MaDocGia) {
        this.MaDocGia = MaDocGia;
    }

    public void setHoTen(String HoTen) {
        this.HoTen = HoTen;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public void setNgaySinh(Date NgaySinh) {
        this.NgaySinh = NgaySinh;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }
    
    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.format(NgaySinh);
    }
}
