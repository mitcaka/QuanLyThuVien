/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import ConnectDB.ConnectDB;
import Models.*;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class DocGiaDAO {
    public boolean insert (DocGia dg) throws Exception
    {    
        
        
            String sql = " insert into DocGia(idDocGia, HoTen, DiaChi, Email, SDT, NgaySinh) values (?,?,?,?,?,?)";
            Connection conn = ConnectDB.getConnection();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, dg.getMaDocGia());
            st.setString(2, dg.getHoTen());
            st.setString(3, dg.getDiaChi());
            st.setString(4, dg.getEmail());
            st.setString(5, dg.getSDT());
            st.setDate(6, new java.sql.Date(dg.getNgaySinh().getTime()));
            int check = st.executeUpdate();
            conn.close();
            st.close();
            return check > 0;          
        
    }
    public boolean update (DocGia dg)
    {
        
        try {
            String sql = " update DocGia set HoTen= ?, DiaChi= ?, Email= ?, SDT = ?, NgaySinh= ? where idDocGia = ?";
            Connection conn = ConnectDB.getConnection();
            PreparedStatement st = conn.prepareStatement(sql);
            
            
            st.setString(6, dg.getMaDocGia());
            st.setString(1, dg.getHoTen());
            st.setString(2, dg.getDiaChi());
            st.setString(3, dg.getEmail());
            st.setString(4, dg.getSDT());
            st.setDate(5, new java.sql.Date(dg.getNgaySinh().getTime()));
            int check = st.executeUpdate();
            conn.close();
            st.close();
            
            return check > 0;
            
        } catch (Exception e) {
            System.out.println("Loi ket noi"+ e.getMessage());
        }
        return false;
    }
    public boolean delete (String idDocGia)
    {
        
        try {
            String sql = " delete from DocGia where idDocGia = ?";
            Connection conn = ConnectDB.getConnection();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1,idDocGia);
            int check = st.executeUpdate();
            conn.close();
            st.close();
            
            return check > 0;
            
        } catch (Exception e) {
            System.out.println("Loi ket noi"+ e.getMessage());
        }
        return false;
    }
    public java.util.List<DocGia> SearchByName (String TenDG)
    {
        java.util.List<DocGia> Sa = new ArrayList<DocGia>();
        String sql = "select * from docgia where HoTen LIKE '%"+TenDG+"%' ";
        
        try {
            Connection conn = ConnectDB.getConnection();
            PreparedStatement st = conn.prepareStatement(sql);        
            ResultSet rs = st.executeQuery();
            while(rs.next())
            {
                DocGia bk = new DocGia();
                bk.setMaDocGia(rs.getString("idDocGia"));
                bk.setHoTen(rs.getString("HoTen"));
                bk.setDiaChi(rs.getString("DiaChi"));
                bk.setEmail(rs.getString("Email"));
                bk.setSDT(rs.getString("SDT"));
                bk.setNgaySinh(rs.getDate("NgaySinh"));
                Sa.add(bk);
            }
            return Sa;
        } catch (Exception e) {
            System.out.println("Loi ket noi"+ e.getMessage());
        }
        return null;
        
    }
    
    public java.util.List<DocGia> SearchDG (String MaDG,String TenDG, String DiaChi, String Email, String SDT)
    {
        java.util.List<DocGia> Sa = new ArrayList<DocGia>();
        String qrSearch = "";
        String qrMa = "";        
        String qrTen = "";        
        String qrdiaChi = "";        
        String qremail = "";        
        String qrsdt = "";
        String qrngaysinh = "";

        if(MaDG != ""){
            qrMa += "idDocGia LIKE \'%" + MaDG + "%\'"; 
            if(qrSearch != ""){
                qrSearch += " AND " +qrMa;
            }
            qrSearch += qrMa;
        }
        
        if(TenDG != ""){
            qrTen += "HoTen LIKE \'%"+TenDG+"%\'"; 
            if(qrSearch != ""){
                qrSearch += " AND " +qrTen;
            }else{
                qrSearch += qrTen;
            }
        }
        
        if(DiaChi != ""){
            qrdiaChi += "DiaChi LIKE \'%"+DiaChi+"%\'"; 
            if(qrSearch != ""){
                qrSearch += " AND " +qrdiaChi;
            }else{
                qrSearch += qrdiaChi;
            }
        }
        
        if(Email != ""){
            qremail += "Email LIKE \'%"+Email+"%\'"; 
            if(qrSearch != ""){
                qrSearch += " AND " +qremail;
            }else{
                qrSearch += qremail;
            }
        }
        
        if(SDT != ""){
            qrsdt += "SDT LIKE \'%"+SDT+"%\'"; 
            if(qrSearch != ""){
                qrSearch += " AND " +qrsdt;
            }else{
                qrSearch += qrsdt;
            }
        }
        
//        if(NgaySinh != ""){
//            qrngaysinh += "NgaySinh LIKE \'%\""+NgaySinh+"\"%\'"; 
//            if(qrSearch != ""){
//                qrSearch += " AND " +qrngaysinh;
//            }else{
//                qrSearch += qrngaysinh;
//            }
//        }
        String sql = "select * from docgia where " + qrSearch;
        System.out.println(sql);
        try {
            Connection conn = ConnectDB.getConnection();
            PreparedStatement st = conn.prepareStatement(sql);        
            ResultSet rs = st.executeQuery();
            while(rs.next())
            {
                DocGia bk = new DocGia();
                bk.setMaDocGia(rs.getString("idDocGia"));
                bk.setHoTen(rs.getString("HoTen"));
                bk.setDiaChi(rs.getString("DiaChi"));
                bk.setEmail(rs.getString("Email"));
                bk.setSDT(rs.getString("SDT"));
                bk.setNgaySinh(rs.getDate("NgaySinh"));
                Sa.add(bk);
            }
            return Sa;
        } catch (Exception e) {
            System.out.println("Loi ket noi"+ e.getMessage());
        }
        return null;
        
    }
    public java.util.List<DocGia> getAllDocGia(){
    
        try {
            java.util.List<DocGia> lst = new ArrayList<DocGia>();
            String sql = "select * from docgia";
            Connection conn = ConnectDB.getConnection();
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while(rs.next())
            {
                String idDG = rs.getString("idDocGia");
                String TenDG = rs.getString("HoTen");
                String DiaChi = rs.getString("DiaChi");
                String Email = rs.getString("Email");                
                String SDT = rs.getString("SDT");
                Date NgaySinh = rs.getDate("NgaySinh");
                DocGia obj = new DocGia(idDG,TenDG,DiaChi,Email,NgaySinh,SDT);
                lst.add(obj);
            }
            conn.close();
            st.close();
            return lst;
            
        } catch (Exception e) {
        }
        return null;
    }
    
    public DocGia getDocGiaByMa(String ma){
    
        try {
            DocGia obj = new DocGia();
            String sql = "select * from docgia where idDocGia = '" + ma+"' ";
            Connection conn = ConnectDB.getConnection();
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while(rs.next())
            {
                obj.setMaDocGia(rs.getString("idDocGia"));
                obj.setHoTen(rs.getString("HoTen"));
                obj.setDiaChi(rs.getString("DiaChi"));
                obj.setEmail(rs.getString("Email"));                
                obj.setSDT(rs.getString("SDT"));
                obj.setNgaySinh(rs.getDate("NgaySinh"));
            }
            conn.close();
            st.close();
            return obj;
            
        } catch (Exception e) {
        }
        return null;
    }

    
}
