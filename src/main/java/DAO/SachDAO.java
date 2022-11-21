/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import ConnectDB.ConnectDB;
import Models.DauSach;
import Models.Sach;
import Models.SachMuon;
import Models.TinhTrangSach;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
public class SachDAO {
    public java.util.List<Sach> getSachTrangThai1ByMaDS(String ma){
        try {
            java.util.List<Sach> lst = new ArrayList<Sach>();
            String sql = "select * from Sach where idDS = '"+ma+"' AND TrangThai = 1";
            Connection conn = ConnectDB.getConnection();
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while(rs.next())
            {
                String IdDS = rs.getString("idDS");
                int IdSach = rs.getInt("idSach");
                int TrangThai = rs.getInt("TrangThai");
                Sach s = new Sach(IdDS,IdSach,TrangThai);
                lst.add(s);
            }
            conn.close();
            st.close();
            return lst;
            
        } catch (Exception e) {
        }
        return null;
    }
    
    public boolean OffSach(int ma){
        try {
            String sql = " update Sach set TrangThai = 0 where idSach = ?";
            Connection conn = ConnectDB.getConnection();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1,ma);
            int check = st.executeUpdate();
            conn.close();
            st.close();
            
            return check > 0;
            
        } catch (Exception e) {
            System.out.println("Loi ket noi"+ e.getMessage());
        }
        return false;
    }
    
    public boolean OnSach(int ma){
        try {
            String sql = " update Sach set TrangThai = 1 where idSach = ?";
            Connection conn = ConnectDB.getConnection();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1,ma);
            int check = st.executeUpdate();
            conn.close();
            st.close();
            
            return check > 0;
            
        } catch (Exception e) {
            System.out.println("Loi ket noi"+ e.getMessage());
        }
        return false;
    }
    
    public java.util.List<SachMuon> LoadSachByIdPhieuMuon(int id){
        try {
            java.util.List<SachMuon> lst = new ArrayList<SachMuon>();
            String sql = "Select dausach.idDS, Sach.idSach, dausach.TenSach, dausach.TacGia from dausach INNER JOIN Sach ON dausach.idDS = Sach.idDS INNER JOIN Chitietphieumuon ON Chitietphieumuon.idSach = Sach.idSach where Chitietphieumuon.idPhieuMuon = '"+id+"'";
            Connection conn = ConnectDB.getConnection();
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while(rs.next())
            {
                String MaDS = rs.getString("idDS");
                int MaSach = rs.getInt("idSach");
                String TenSach = rs.getString("TenSach");                
                String TacGia = rs.getString("TacGia");

                SachMuon s = new SachMuon();
                s.setMaDS(MaDS);
                s.setMaSach(MaSach);
                s.setTacGia(TacGia);
                s.setTenSach(TenSach);
                lst.add(s);
            }
            conn.close();
            st.close();
            return lst;
            
        } catch (Exception e) {
        }
        return null;
    }
    
    public java.util.List<SachMuon> LoadSachMuonNhieu(){
        try {
            java.util.List<SachMuon> lst = new ArrayList<SachMuon>();
            String sql = "Select dausach.idDS, dausach.TenSach, dausach.TacGia, COUNT(Chitietphieumuon.idSach) from dausach INNER JOIN Sach ON dausach.idDS = Sach.idDS INNER JOIN Chitietphieumuon ON Chitietphieumuon.idSach = Sach.idSach Group By dausach.idDS ORDER BY COUNT(Chitietphieumuon.idSach) DESC;";
            Connection conn = ConnectDB.getConnection();
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while(rs.next())
            {
                String MaDS = rs.getString("idDS");
                int MaSach = rs.getInt("COUNT(Chitietphieumuon.idSach)");
                String TenSach = rs.getString("TenSach");                
                String TacGia = rs.getString("TacGia");

                SachMuon s = new SachMuon();
                s.setMaDS(MaDS);
                s.setMaSach(MaSach);
                s.setTacGia(TacGia);
                s.setTenSach(TenSach);
                lst.add(s);
            }
            conn.close();
            st.close();
            return lst;
            
        } catch (Exception e) {
        }
        return null;
    }
    
    public java.util.List<SachMuon> LoadSachMuonNhieuDateToDate(String d1,String d2){
        try {
            java.util.List<SachMuon> lst = new ArrayList<SachMuon>();
            String sql = "Select dausach.idDS, dausach.TenSach, dausach.TacGia, COUNT(Chitietphieumuon.idSach) from dausach INNER JOIN Sach ON dausach.idDS = Sach.idDS INNER JOIN Chitietphieumuon ON Chitietphieumuon.idSach = Sach.idSach Where NgayTra >= '"+d1+"' AND NgayTra <= '"+d2+"' Group By dausach.idDS Order by COUNT(Chitietphieumuon.idSach) DESC;";
            Connection conn = ConnectDB.getConnection();
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while(rs.next())
            {
                String MaDS = rs.getString("idDS");
                int MaSach = rs.getInt("COUNT(Chitietphieumuon.idSach)");
                String TenSach = rs.getString("TenSach");                
                String TacGia = rs.getString("TacGia");

                SachMuon s = new SachMuon();
                s.setMaDS(MaDS);
                s.setMaSach(MaSach);
                s.setTacGia(TacGia);
                s.setTenSach(TenSach);
                lst.add(s);
            }
            conn.close();
            st.close();
            return lst;
            
        } catch (Exception e) {
        }
        return null;
    }
    
    public java.util.List<Sach> getSach(){
        try {
            java.util.List<Sach> lst = new ArrayList<Sach>();
            String sql = "select * from Sach";
            Connection conn = ConnectDB.getConnection();
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while(rs.next())
            {
                int TrangThai = rs.getInt("idSach");
                String MaDS = rs.getString("idDS");
                int MaSach = rs.getInt("TrangThai");
                Sach obj = new Sach();
                lst.add(obj);
            }
            conn.close();
            st.close();
            return lst;
            
        } catch (Exception e) {
        }
        return null;
    }
    public java.util.List<TinhTrangSach> getTinhTrangSach(){
    
        try {
            java.util.List<TinhTrangSach> lst = new ArrayList<TinhTrangSach>();
            String sql = "SELECT sach.idDS, TenSach, COUNT(sach.idDS) AS chuamuon , (dausach.Soluong-COUNT(sach.idDS)) as dachomuon FROM sach, dausach WHERE sach.idDS = dausach.idDS AND TrangThai = 1\n" +
"GROUP BY sach.idDS, TenSach";
            Connection conn = ConnectDB.getConnection();
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while(rs.next())
            {
                String IdDS = rs.getString("sach.idDS");
                String TenSach = rs.getString("TenSach");
                int SachChoMuon = rs.getInt("dachomuon");
                int SachChuaMuon = rs.getInt("chuamuon");
                TinhTrangSach sa = new TinhTrangSach(IdDS, TenSach, SachChoMuon, SachChuaMuon);
                lst.add(sa);
            }
            conn.close();
            st.close();
            return lst;
            
        } catch (Exception e) {
        }
        return null;
    }
}
