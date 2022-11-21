/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import ConnectDB.ConnectDB;
import Models.ChiTietPhieuMuon;
import Models.ChiTietPhieuMuon;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
public class ChiTietPhieuMuonDAO {
    public boolean insert (ChiTietPhieuMuon ctpm)
    {    
        
        try {
            String sql = " insert into ChiTietPhieuMuon(idSach, idPhieuMuon, NgayTra, TinhTrangSach, MucPhat) values (?,?,?,?,?)";
            Connection conn = ConnectDB.getConnection();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1, ctpm.getIdSach());
            st.setInt(2, ctpm.getIdPhieuMuon());
            st.setDate(3, (Date) ctpm.getNgayTra());
            st.setString(4, ctpm.getTinhTrangSach());
            st.setFloat(5, ctpm.getMucPhat());
            int check = st.executeUpdate();
            conn.close();
            st.close();
            return check > 0;          
        } catch (Exception e) {
            System.out.println("Loi ket noi"+ e.getMessage());
        }
        return false;
    }
    public boolean update (ChiTietPhieuMuon ctpm)
    {
        
        try {
            String sql = " update ChiTietPhieuMuon set NgayTra = ?, TinhTrangSach= ?, MucPhat = ? where idPhieuMuon = ? AND idSach = ?";
            Connection conn = ConnectDB.getConnection();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setDate(1,new java.sql.Date(ctpm.getNgayTra().getTime()));
            st.setString(2, ctpm.getTinhTrangSach());
            st.setFloat(3, ctpm.getMucPhat());
            st.setInt(4, ctpm.getIdPhieuMuon());
            st.setInt(5, ctpm.getIdSach());
            int check = st.executeUpdate();
            conn.close();
            st.close();
            return check > 0;
            
        } catch (Exception e) {
            System.out.println("Loi ket noi"+ e.getMessage());
        }
        return false;
    }
    public boolean delete (int IdPhieuMuon)
    {
        
        try {
            String sql = " delete from ChiTietPhieuMuon where idPhieuMuon = ?";
            Connection conn = ConnectDB.getConnection();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1,IdPhieuMuon);
            int check = st.executeUpdate();
            conn.close();
            st.close();
            
            return check > 0;
            
        } catch (Exception e) {
            System.out.println("Loi ket noi"+ e.getMessage());
        }
        return false;
    }
    public java.util.List<ChiTietPhieuMuon> Search (int IdPhieuMuon)
    {
        java.util.List<ChiTietPhieuMuon> DM = new ArrayList<ChiTietPhieuMuon>();
        String sql = "select * from ChiTietPhieuMuon where idPhieuMuon = ?";
        
        try {
            Connection conn = ConnectDB.getConnection();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1, IdPhieuMuon);
            ResultSet rs = st.executeQuery();
            if(rs.next())
            {
                ChiTietPhieuMuon obj = new ChiTietPhieuMuon();
                obj.setIdSach(rs.getInt("idSach"));
                obj.setIdPhieuMuon(rs.getInt("idPhieuMuon"));
                obj.setNgayTra(rs.getDate("NgayTra"));
                obj.setTinhTrangSach(rs.getString("TinhTrangSach"));
                obj.setMucPhat(rs.getInt("MucPhat"));
                DM.add(obj);
                return DM;
            }
        } catch (Exception e) {
            System.out.println("Loi ket noi"+ e.getMessage());
        }
        return null;
        
    }
    
    public ChiTietPhieuMuon SearchByMaDGAndMaPhieu (int idSach,int IdPhieuMuon)
    {
        ChiTietPhieuMuon obj = new ChiTietPhieuMuon();
        String sql = "select * from ChiTietPhieuMuon where idPhieuMuon = ? And idSach = ?";
        
        try {
            Connection conn = ConnectDB.getConnection();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1, IdPhieuMuon);            
            st.setInt(2, idSach);

            ResultSet rs = st.executeQuery();
            if(rs.next())
            {
                obj.setIdSach(rs.getInt("idSach"));
                obj.setIdPhieuMuon(rs.getInt("idPhieuMuon"));
                obj.setNgayTra(rs.getDate("NgayTra"));
                obj.setTinhTrangSach(rs.getString("TinhTrangSach"));
                obj.setMucPhat(rs.getInt("MucPhat"));
                return obj;
            }
        } catch (Exception e) {
            System.out.println("Loi ket noi"+ e.getMessage());
        }
        return null;
        
    }
    public java.util.List<ChiTietPhieuMuon> getChiTietPhieuMuon(){
        try {
            java.util.List<ChiTietPhieuMuon> lst = new ArrayList<ChiTietPhieuMuon>();
            String sql = "select * from chitietphieumuon";
            Connection conn = ConnectDB.getConnection();
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while(rs.next())
            {
                int IdSach = rs.getInt("idSach");
                int IdPhieuMuon = rs.getInt("idPhieuMuon");
                Date NgayTra = rs.getDate("NgayTra");
                String TinhTrangSach = rs.getString("TinhTrangSach");
                float MucPhat = rs.getFloat("MucPhat");
                ChiTietPhieuMuon obj = new ChiTietPhieuMuon();
                obj.setIdPhieuMuon(IdPhieuMuon);
                obj.setIdSach(IdSach);
                obj.setMucPhat(MucPhat);
                obj.setTinhTrangSach(TinhTrangSach);
                lst.add(obj);
            }
            conn.close();
            st.close();
            return lst;
            
        } catch (Exception e) {
            System.out.println("Loi : " + e.getMessage());
        }
        return null;
    }
}
