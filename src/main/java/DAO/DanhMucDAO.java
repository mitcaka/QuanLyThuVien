/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import ConnectDB.ConnectDB;
import Models.DanhMuc;
import com.mysql.cj.xdevapi.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JOptionPane;

/**
 *
 * @author ADMIN
 */
public class DanhMucDAO {
    public boolean insert (DanhMuc DM)
    {    
        
        try {
            String sql = " insert into DanhMuc(TenDanhMuc) values (?)";
            Connection conn = ConnectDB.getConnection();
            PreparedStatement st = conn.prepareStatement(sql);
            
            st.setString(1, DM.getTenDanhMuc());
            int check = st.executeUpdate();
            conn.close();
            st.close();
            return check > 0;          
        } catch (Exception e) {
            System.out.println("Loi ket noi"+ e.getMessage());
        }
        return false;
    }
    public boolean update (DanhMuc DM)
    {
        
        try {
            String sql = " update DanhMuc set TenDanhMuc= ? where idDM = ?";
            Connection conn = ConnectDB.getConnection();
            PreparedStatement st = conn.prepareStatement(sql);
            
            
            st.setInt(2, DM.getMaDanhMuc());
            st.setString(1, DM.getTenDanhMuc());
            int check = st.executeUpdate();
            conn.close();
            st.close();
            
            return check > 0;
            
        } catch (Exception e) {
            System.out.println("Loi ket noi"+ e.getMessage());
        }
        return false;
    }
    public boolean delete (int MaDanhMuc)
    {
        
        try {
            String sql = " delete from DanhMuc where idDM = ?";
            Connection conn = ConnectDB.getConnection();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1,MaDanhMuc);
            int check = st.executeUpdate();
            conn.close();
            st.close();
            
            return check > 0;
            
        } catch (Exception e) {
            System.out.println("Loi ket noi"+ e.getMessage());
        }
        return false;
    }
    public java.util.List<DanhMuc> Search (String TenDM)
    {
        java.util.List<DanhMuc> DM = new ArrayList<DanhMuc>();
        String sql = "select * from DanhMuc where TenDanhMuc LIKE '%"+TenDM+"%'";
        
        try {
            Connection conn = ConnectDB.getConnection();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, TenDM);
            ResultSet rs = st.executeQuery();
            while(rs.next())
            {
                DanhMuc obj = new DanhMuc();
                obj.setMaDanhMuc(rs.getInt("idDM"));
                obj.setTenDanhMuc(rs.getString("TenDanhMuc"));
                DM.add(obj);
            }
            return DM;
        } catch (Exception e) {
            System.out.println("Loi ket noi"+ e.getMessage());
        }
        return null;
        
    }
    public String SearchMa (int MaDM)
    {
        java.util.List<DanhMuc> DM = new ArrayList<DanhMuc>();
        String sql = "select * from DanhMuc where idDM = ?";
        String TenDM = null;
        try {
            Connection conn = ConnectDB.getConnection();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setInt(1, MaDM);
            ResultSet rs = st.executeQuery();
            while(rs.next())
            {
                TenDM = rs.getString("TenDanhMuc");
            }
            return TenDM;
        } catch (Exception e) {
            System.out.println("Loi ket noi"+ e.getMessage());
        }
        return null;
        
    }
    public java.util.List<DanhMuc> getDanhMuc(){
    
        try {
            java.util.List<DanhMuc> lst = new ArrayList<DanhMuc>();
            String sql = "select * from DanhMuc";
            Connection conn = ConnectDB.getConnection();
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while(rs.next())
            {
                int MaDanhMuc = rs.getInt("idDM");
                String TenDanhMuc = rs.getString("TenDanhMuc");
                
                DanhMuc obj = new DanhMuc(MaDanhMuc, TenDanhMuc);
                lst.add(obj);
            }
            conn.close();
            st.close();
            return lst;
            
        } catch (Exception e) {
        }
        return null;
    }
    public Vector getDM(){
    
        Vector lst = null;
        String sql = "SELECT * FROM danhmuc";       
        try {
            Connection conn = ConnectDB.getConnection();
            PreparedStatement st = conn.prepareStatement(sql);
            lst = new Vector();
            ResultSet rs = st.executeQuery();
            while(rs.next())
            {                 
                int MaDanhMuc = rs.getInt("idDM");
                String TenDanhMuc = rs.getString("TenDanhMuc");
                DanhMuc obj = new DanhMuc(MaDanhMuc, TenDanhMuc);
                lst.add(obj);
            }
        } catch (Exception e) {
        }
        return lst;
        

    }
    
}
