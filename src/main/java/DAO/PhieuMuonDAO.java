/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import ConnectDB.ConnectDB;
import Models.PhieuMuon;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author ADMIN
 */
public class PhieuMuonDAO {

    public boolean insert (PhieuMuon pmt)
    {    
        
        try {
            String sql = " insert into PhieuMuonTra(idDocGia,idPhieuMuon,idNhanVien,HanMuon,NgayMuon,GhiChu,TrangThai) values (?,?,?,?,?,?,?)";
            Connection conn = ConnectDB.getConnection();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, pmt.getMaDocGia());
            st.setInt(2, pmt.getMaPhieuMuon());
            st.setString(3, pmt.getMaNV());
            st.setInt(4, pmt.getHanMuon() );
            st.setDate(5, new java.sql.Date(pmt.getNgayMuon().getTime()));
            st.setString(6, pmt.getGhiChu());
            st.setInt(7, pmt.getTrangThai());
            int check = st.executeUpdate();
            conn.close();
            st.close();
            return check > 0;          
        } catch (Exception e) {
            System.out.println("Loi ket noi"+ e.getMessage());
        }
        return false;
    }
    public boolean update (PhieuMuon pmt)
    {
        
        try {
            String sql = " update PhieuMuonTra set idDocGia = ?, idNhanVien= ?, NgayMuon= ?, HanMuon= ?, GhiChu= ? , TrangThai = ? where idPhieuMuon = ?";
            Connection conn = ConnectDB.getConnection();
            PreparedStatement st = conn.prepareStatement(sql);
            
            st.setString(1, pmt.getMaDocGia());
            st.setString(2, pmt.getMaNV());
            st.setDate(3, new java.sql.Date(pmt.getNgayMuon().getTime()));
            st.setInt(4, pmt.getHanMuon() );
            st.setString(5, pmt.getGhiChu());
            st.setInt(6, pmt.getTrangThai());
            st.setInt(7, pmt.getMaPhieuMuon());

            int check = st.executeUpdate();
            conn.close();
            st.close();
            
            return check > 0;
            
        } catch (Exception e) {
            System.out.println("Loi ket noi"+ e.getMessage());
        }
        return false;
    }
    public boolean delete (int MaPhieuMuon)
    {
        
        try {
            String sql = " delete from PhieuMuonTra where idPhieuMuon = ?";
            Connection conn = ConnectDB.getConnection();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1,MaPhieuMuon);
            int check = st.executeUpdate();
            conn.close();
            st.close();
            
            return check > 0;
            
        } catch (Exception e) {
            System.out.println("Loi ket noi"+ e.getMessage());
        }
        return false;
    }
    
    public java.util.List<PhieuMuon> getPhieuMuon(){
    
        try {
            java.util.List<PhieuMuon> lst = new ArrayList<PhieuMuon>();
            String sql = "select * from PhieuMuonTra order by idPhieuMuon DESC";
            Connection conn = ConnectDB.getConnection();
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while(rs.next())
            {
                int MaPhieuMuon = rs.getInt("idPhieuMuon");
                String MaNV = rs.getString("idNhanVien");
                String MaDocGia = rs.getString("idDocGia");
                Date NgayMuon = rs.getDate("NgayMuon");
                int HanMuon = rs.getInt("HanMuon");
                String GhiChu = rs.getString("GhiChu");
                int TrangThai = rs.getInt("TrangThai");
                PhieuMuon obj = new PhieuMuon(MaPhieuMuon,MaDocGia,MaNV, NgayMuon, HanMuon,  TrangThai,GhiChu);
                lst.add(obj);
            }
            conn.close();
            st.close();
            return lst;
            
        } catch (Exception e) {
        }
        return null;
    }
    
    public java.util.List<PhieuMuon> getPhieuMuonDateToDate(String d1,String d2){
    
        try {
            java.util.List<PhieuMuon> lst = new ArrayList<PhieuMuon>();
            String sql = "select * from PhieuMuonTra where NgayMuon >= '"+d1+"' AND NgayMuon <= '"+d2+"' order by NgayMuon DESC";
            Connection conn = ConnectDB.getConnection();
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while(rs.next())
            {
                int MaPhieuMuon = rs.getInt("idPhieuMuon");
                String MaNV = rs.getString("idNhanVien");
                String MaDocGia = rs.getString("idDocGia");
                Date NgayMuon = rs.getDate("NgayMuon");
                int HanMuon = rs.getInt("HanMuon");
                String GhiChu = rs.getString("GhiChu");
                int TrangThai = rs.getInt("TrangThai");
                PhieuMuon obj = new PhieuMuon(MaPhieuMuon,MaDocGia,MaNV, NgayMuon, HanMuon,  TrangThai,GhiChu);
                lst.add(obj);
            }
            conn.close();
            st.close();
            return lst;
            
        } catch (Exception e) {
        }
        return null;
    }
    
    public boolean deletePhieuByMaDG (String MaDG)
    {
        
        try {
            String sql = " delete from PhieuMuonTra where idDocGia = ? AND TrangThai = 0";
            Connection conn = ConnectDB.getConnection();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1,MaDG);
            int check = st.executeUpdate();
            conn.close();
            st.close();
            return check > 0;
            
        } catch (Exception e) {
            System.out.println("Loi ket noi"+ e.getMessage());
        }
        return false;
    }
    
    public PhieuMuon SearchPhieuByMaDG (String MaDG)
    {
        PhieuMuon obj = new PhieuMuon();
        String sql = "select * from PhieuMuonTra where idDocGia = ? AND TrangThai = 0";
        
        try {
            Connection conn = ConnectDB.getConnection();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, MaDG);
            ResultSet rs = st.executeQuery();
            if(rs.next())
            {
                obj.setMaPhieuMuon(rs.getInt("idPhieuMuon"));
                obj.setMaDocGia(rs.getString("idDocGia"));                
                obj.setMaNV(rs.getString("idNhanVien"));
                obj.setHanMuon(rs.getInt("HanMuon"));
                obj.setNgayMuon(rs.getDate("NgayMuon"));
                obj.setGhiChu(rs.getString("GhiChu"));
                obj.setTrangThai(rs.getInt("TrangThai"));
                
            }
            return obj;
        } catch (Exception e) {
            System.out.println("Loi ket noi "+ e.getMessage());
        }
        return null;
        
    }
    
    public PhieuMuon SearchPhieuByMa (int MaPhieuMuon)
    {
        PhieuMuon obj = new PhieuMuon();
        String sql = "select * from PhieuMuonTra where idPhieuMuon = ? AND TrangThai = 1";
        
        try {
            Connection conn = ConnectDB.getConnection();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1, MaPhieuMuon);
            ResultSet rs = st.executeQuery();
            if(rs.next())
            {
                obj.setMaPhieuMuon(rs.getInt("idPhieuMuon"));
                obj.setMaDocGia(rs.getString("idDocGia"));                
                obj.setMaNV(rs.getString("idNhanVien"));
                obj.setHanMuon(rs.getInt("HanMuon"));
                obj.setNgayMuon(rs.getDate("NgayMuon"));
                obj.setGhiChu(rs.getString("GhiChu"));
                obj.setTrangThai(rs.getInt("TrangThai"));
                
            }
            return obj;
        } catch (Exception e) {
            System.out.println("Loi ket noi "+ e.getMessage());
        }
        return null;
        
    }
    
    public PhieuMuon getAllPhieuByMa (int MaPhieuMuon)
    {
        PhieuMuon obj = new PhieuMuon();
        String sql = "select * from PhieuMuonTra where idPhieuMuon = ?";
        
        try {
            Connection conn = ConnectDB.getConnection();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1, MaPhieuMuon);
            ResultSet rs = st.executeQuery();
            if(rs.next())
            {
                obj.setMaPhieuMuon(rs.getInt("idPhieuMuon"));
                obj.setMaDocGia(rs.getString("idDocGia"));                
                obj.setMaNV(rs.getString("idNhanVien"));
                obj.setHanMuon(rs.getInt("HanMuon"));
                obj.setNgayMuon(rs.getDate("NgayMuon"));
                obj.setGhiChu(rs.getString("GhiChu"));
                obj.setTrangThai(rs.getInt("TrangThai"));
                
            }
            return obj;
        } catch (Exception e) {
            System.out.println("Loi ket noi "+ e.getMessage());
        }
        return null;
        
    }
    
    public java.util.List<PhieuMuon> getPhieuMuonByMaDG(String ma){
    
        try {
            java.util.List<PhieuMuon> lst = new ArrayList<PhieuMuon>();
            String sql = "select * from PhieuMuonTra where idDocGia = '"+ma+"' AND TrangThai = 1 ORDER BY NgayMuon DESC";
            Connection conn = ConnectDB.getConnection();
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while(rs.next())
            {
                int MaPhieuMuon = rs.getInt("idPhieuMuon");
                String MaNV = rs.getString("idNhanVien");
                String MaDocGia = rs.getString("idDocGia");
                Date NgayMuon = rs.getDate("NgayMuon");
                int HanMuon = rs.getInt("HanMuon");
                String GhiChu = rs.getString("GhiChu");
                int TrangThai = rs.getInt("TrangThai");
                PhieuMuon obj = new PhieuMuon(MaPhieuMuon,MaDocGia,MaNV, NgayMuon, HanMuon,  TrangThai,GhiChu);
                lst.add(obj);
            }
            conn.close();
            st.close();
            return lst;
            
        } catch (Exception e) {
        }
        return null;
    }
    
    public java.util.List<PhieuMuon> getPhieuMuonByMaDGNgayMuon(String ma,String ngay){
    
        try {
            java.util.List<PhieuMuon> lst = new ArrayList<PhieuMuon>();
            String sql = "select * from PhieuMuonTra where idDocGia = '"+ma+"' AND TrangThai = 1 AND NgayMuon ='"+ngay+"' ";
            Connection conn = ConnectDB.getConnection();
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while(rs.next())
            {
                int MaPhieuMuon = rs.getInt("idPhieuMuon");
                String MaNV = rs.getString("idNhanVien");
                String MaDocGia = rs.getString("idDocGia");
                Date NgayMuon = rs.getDate("NgayMuon");
                int HanMuon = rs.getInt("HanMuon");
                String GhiChu = rs.getString("GhiChu");
                int TrangThai = rs.getInt("TrangThai");
                PhieuMuon obj = new PhieuMuon(MaPhieuMuon,MaDocGia,MaNV, NgayMuon, HanMuon,  TrangThai,GhiChu);
                lst.add(obj);
            }
            conn.close();
            st.close();
            return lst;
            
        } catch (Exception e) {
        }
        return null;
    }
    
    public boolean UpdateTrangThaiHoanThanh (int MaPhieuMuon)
    {
        try {
            String sql = " update PhieuMuonTra set TrangThai = 2 where idPhieuMuon = ?";
            Connection conn = ConnectDB.getConnection();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1,MaPhieuMuon);
            int check = st.executeUpdate();
            conn.close();
            st.close();
            
            return check > 0;
            
        } catch (Exception e) {
            System.out.println("Loi ket noi"+ e.getMessage());
        }
        return false;
    }
    
    public boolean UpdateGhiChu (int MaPhieuMuon,String ghiChu)
    {
        try {
            String sql = " update PhieuMuonTra set GhiChu = ? where idPhieuMuon = ?";
            Connection conn = ConnectDB.getConnection();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1,ghiChu);
            st.setInt(2,MaPhieuMuon);
            int check = st.executeUpdate();
            conn.close();
            st.close();
            
            return check > 0;
            
        } catch (Exception e) {
            System.out.println("Loi ket noi"+ e.getMessage());
        }
        return false;
    }
}
