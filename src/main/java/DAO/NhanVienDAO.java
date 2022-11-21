/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import ConnectDB.ConnectDB;
import Models.NhanVien;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author ADMIN
 */
public class NhanVienDAO {
    public boolean insert (NhanVien NV) throws Exception
    {    
        
        
            String sql = " insert into NhanVien(idNhanVien, password, HoTenNV, NgaySinh, DiaChi, SDT,  PhanQuyen) values (?,?,?,?,?,?,1)";
            Connection conn = ConnectDB.getConnection();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, NV.getIdNhanVien());
            st.setString(2, NV.getPassword());
            st.setString(3, NV.getHoTenNV());
            st.setDate(4, new java.sql.Date(NV.getNgaySinh().getTime()));
            st.setString(5, NV.getDiaChi());
            st.setString(6,  NV.getSDT());
            int check = st.executeUpdate();
            conn.close();
            st.close();
            return check > 0;          
        

    }
    public boolean update (NhanVien NV)
    {
        
        try {
            String sql = " update NhanVien set password = ?, HoTenNV= ?, NgaySinh= ?, DiaChi= ?, SDT= ?where idNhanVien = ?";
            Connection conn = ConnectDB.getConnection();
            PreparedStatement st = conn.prepareStatement(sql);
            
            
            st.setString(6, NV.getIdNhanVien());
            st.setString(1, NV.getPassword());
            st.setString(2, NV.getHoTenNV());
            st.setDate(3, new java.sql.Date(NV.getNgaySinh().getTime()));
            st.setString(4, NV.getDiaChi());
            st.setString(5,  NV.getSDT());
            int check = st.executeUpdate();
            conn.close();
            st.close();
            
            return check > 0;
            
        } catch (Exception e) {
            System.out.println("Loi ket noi"+ e.getMessage());
        }
        return false;
    }
    public boolean delete (String idNhanVien)
    {
        
        try {
            String sql = " delete from NhanVien where idNhanVien = ?";
            Connection conn = ConnectDB.getConnection();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1,idNhanVien);
            int check = st.executeUpdate();
            conn.close();
            st.close();
            
            return check > 0;
            
        } catch (Exception e) {
            System.out.println("Loi ket noi"+ e.getMessage());
        }
        return false;
    }
    public java.util.List<NhanVien> Search (String idNhanVien)
    {
        java.util.List<NhanVien> DG = new ArrayList<NhanVien>();
        String sql = "select * from NhanVien where idNhanVien = ?";
        try {
            Connection conn = ConnectDB.getConnection();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, idNhanVien);
            ResultSet rs = st.executeQuery();
            while(rs.next())
            {
                NhanVien obj = new NhanVien();
                obj.setIdNhanVien(rs.getString("idNhanVien"));
                obj.setHoTenNV(rs.getString("HoTenNV"));
                obj.setNgaySinh(rs.getDate("NgaySinh"));
                obj.setDiaChi(rs.getString("DiaChi"));
                obj.setSDT(rs.getString("SDT"));
                DG.add(obj);
            }
            return DG;
        } catch (Exception e) {
            System.out.println("Loi ket noi"+ e.getMessage());
        }
        return null;
        
    }
    public java.util.List<NhanVien> getNhanVien(){
    
        try {
            java.util.List<NhanVien> lst = new ArrayList<NhanVien>();
            String sql = "select * from NhanVien";
            Connection conn = ConnectDB.getConnection();
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while(rs.next())
            {
                String idNhanVien = rs.getString("idNhanVien");
                String password = rs.getString("password");
                String HoTenNV = rs.getString("HoTenNV");
                Date NgaySinh = rs.getDate("NgaySinh");
                String DiaChi = rs.getString("DiaChi");
                String SDT = rs.getString("SDT");
                int PhanQuyen = rs.getInt("PhanQuyen");
                
                NhanVien obj = new NhanVien(idNhanVien, password, HoTenNV, NgaySinh, DiaChi, SDT, PhanQuyen);
                lst.add(obj);
            }
            conn.close();
            st.close();
            return lst;
            
        } catch (Exception e) {
        }
        return null;
    }
    
    public NhanVien getNhanVienByMa(String ma){
    
        try {
            NhanVien lst = new NhanVien();
            String sql = "select * from NhanVien where idNhanVien = '"+ma+" '";
            Connection conn = ConnectDB.getConnection();
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while(rs.next())
            {
                lst.setIdNhanVien(rs.getString("idNhanVien"));
                lst.setPassword(rs.getString("password"));
                lst.setHoTenNV(rs.getString("HoTenNV"));
                lst.setNgaySinh(rs.getDate("NgaySinh"));
                lst.setDiaChi(rs.getString("DiaChi"));
                lst.setSDT(rs.getString("SDT"));
                lst.setPhanQuyen(rs.getInt("PhanQuyen"));
            }
            conn.close();
            st.close();
            return lst;
            
        } catch (Exception e) {
        }
        return null;
    }
}
