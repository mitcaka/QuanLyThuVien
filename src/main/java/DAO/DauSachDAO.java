/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import ConnectDB.ConnectDB;
import Models.DauSach;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
/**
 *
 * @author ADMIN
 */
public class DauSachDAO {
    public boolean insert (DauSach DS) throws Exception
    {    
            String sql = " insert into DauSach(idDS, idDM, TenSach, TacGia,NhaXuatBan, NamXuatBan, SoLuong, MoTa) values (?,?,?,?,?,?,?,?)";
            Connection conn = ConnectDB.getConnection();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, DS.getMaSach());
            st.setInt(2, DS.getMaDanhMuc());
            st.setString(3, DS.getTenSach());
            st.setString(4, DS.getTacGia());
            st.setString(5, DS.getNhaXuatBan());
            st.setString(6, DS.getNamXuatBan());
            st.setInt(7, DS.getSoLuong());
            st.setString(8, DS.getMoTa());
            int check = st.executeUpdate();
            conn.close();
            st.close();
            return check > 0;          
    }
    public boolean update (DauSach DS)
    {
        
        try {
            String sql = " UPDATE dausach SET idDM = ? ,TenSach = ?, TacGia= ?, NhaXuatBan= ?, NamXuatBan= ?, SoLuong= ?, MoTa= ? Where idDS = ?";
            Connection conn = ConnectDB.getConnection();
            PreparedStatement st = conn.prepareStatement(sql);
            
            st.setInt(1, DS.getMaDanhMuc());
            st.setString(2, DS.getTenSach());
            st.setString(3, DS.getTacGia());
            st.setString(4, DS.getNhaXuatBan());
            st.setString(5, DS.getNamXuatBan());
            st.setInt(6, DS.getSoLuong());
            st.setString(7, DS.getMoTa());
            st.setString(8, DS.getMaSach());
            int check = st.executeUpdate();
            conn.close();
            st.close();
            return check > 0;
            
        } catch (Exception e) {
            System.out.println("Loi ket noi"+ e.getMessage());
        }
        return false;
    }
    public boolean delete (String MaSach)
    {
        
        try {
            String sql = " delete from DauSach where idDS = ?";
            Connection conn = ConnectDB.getConnection();
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1,MaSach);
            int check = st.executeUpdate();
            conn.close();
            st.close();
            
            return check > 0;
            
        } catch (Exception e) {
            System.out.println("Loi ket noi"+ e.getMessage());
        }
        return false;
    }
    public java.util.List<DauSach> Search (String TenSach)
    {
        java.util.List<DauSach> Sa = new ArrayList<DauSach>();
        String sql = "select * from DauSach where TenSach = '" + TenSach+"'";
        
        try {
            Connection conn = ConnectDB.getConnection();
            PreparedStatement st = conn.prepareStatement(sql);
            
            
            ResultSet rs = st.executeQuery();
            if(rs.next())
            {
                DauSach bk = new DauSach();
                bk.setMaSach(rs.getString("idDS"));
                bk.setMaDanhMuc(rs.getInt("idDM"));
                bk.setTenSach(rs.getString("TenSach"));
                bk.setTacGia(rs.getString("TacGia"));
                bk.setNhaXuatBan(rs.getString("NhaXuatBan"));
                bk.setNamXuatBan(rs.getString("NamXuatBan"));
                bk.setSoLuong(rs.getInt("SoLuong"));
                bk.setMoTa(rs.getString("MoTa"));
                Sa.add(bk);
            }
            return Sa;
        } catch (Exception e) {
            System.out.println("Loi ket noi"+ e.getMessage());
        }
        return null;
        
    }
    
    public java.util.List<DauSach> SearchDS (String MaDS,String TenDS, String MoTa, String TacGia, String NhaXuatBan,String NamXuatBan)
    {
        java.util.List<DauSach> Sa = new ArrayList<DauSach>();
        String qrSearch = "";
        String qrMa = "";        
        String qrTen = "";        
        String qrdiaChi = "";        
        String qremail = "";        
        String qrsdt = "";
        String qrngaysinh = "";

        if(MaDS != ""){
            qrMa += "idDS LIKE \'%" + MaDS + "%\'"; 
            if(qrSearch != ""){
                qrSearch += " AND " +qrMa;
            }
            qrSearch += qrMa;
        }
        
        if(TenDS != ""){
            qrTen += "TenSach LIKE \'%"+TenDS+"%\'"; 
            if(qrSearch != ""){
                qrSearch += " AND " +qrTen;
            }else{
                qrSearch += qrTen;
            }
        }
        
        if(MoTa != ""){
            qrdiaChi += "MoTa LIKE \'%"+MoTa+"%\'"; 
            if(qrSearch != ""){
                qrSearch += " AND " +qrdiaChi;
            }else{
                qrSearch += qrdiaChi;
            }
        }
        
        if(TacGia != ""){
            qremail += "TacGia LIKE \'%"+TacGia+"%\'"; 
            if(qrSearch != ""){
                qrSearch += " AND " +qremail;
            }else{
                qrSearch += qremail;
            }
        }
        
        if(NhaXuatBan != ""){
            qrsdt += "NhaXuatBan LIKE \'%"+NhaXuatBan+"%\'"; 
            if(qrSearch != ""){
                qrSearch += " AND " +qrsdt;
            }else{
                qrSearch += qrsdt;
            }
        }
        
        if(NamXuatBan != ""){
            qrngaysinh += "NamXuatBan LIKE \'%"+NamXuatBan+"%\'"; 
            if(qrSearch != ""){
                qrSearch += " AND " +qrngaysinh;
            }else{
                qrSearch += qrngaysinh;
            }
        }
        String sql = "select * from dausach where " + qrSearch;
        System.out.println(sql);
        try {
            Connection conn = ConnectDB.getConnection();
            PreparedStatement st = conn.prepareStatement(sql);        
            ResultSet rs = st.executeQuery();
            while(rs.next())
            {
                DauSach bk = new DauSach();
                bk.setMaSach(rs.getString("idDS"));
                bk.setMaDanhMuc(rs.getInt("idDM"));
                bk.setTenSach(rs.getString("TenSach"));
                bk.setTacGia(rs.getString("TacGia"));
                bk.setNhaXuatBan(rs.getString("NhaXuatBan"));
                bk.setNamXuatBan(rs.getString("NamXuatBan"));
                bk.setSoLuong(rs.getInt("SoLuong"));
                bk.setMoTa(rs.getString("MoTa"));
                Sa.add(bk);
            }
            return Sa;
        } catch (Exception e) {
            System.out.println("Loi ket noi"+ e.getMessage());
        }
        return null;
        
    }
    
    public java.util.List<DauSach> getDauSach(){
    
        try {
            java.util.List<DauSach> lst = new ArrayList<DauSach>();
            String sql = "select * from DauSach";
            Connection conn = ConnectDB.getConnection();
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while(rs.next())
            {
                String IdDS = rs.getString("idDS");
                int IdDM = rs.getInt("idDM");
                String TenSach = rs.getString("TenSach");
                String TacGia = rs.getString("TacGia");
                String NhaXuatBan = rs.getString("NhaXuatBan");
                String NamXuatBan = rs.getString("NamXuatBan");
                int SoLuong = rs.getInt("SoLuong");
                String MoTa = rs.getString("MoTa");
                DauSach obj = new DauSach(IdDS, IdDM, TenSach, TacGia, NamXuatBan, NhaXuatBan, SoLuong, MoTa);
                lst.add(obj);
            }
            conn.close();
            st.close();
            return lst;
            
        } catch (Exception e) {
        }
        return null;
    }
    
    public java.util.List<DauSach> getDauSachByMaDM(int ma){
    
        try {
            java.util.List<DauSach> lst = new ArrayList<DauSach>();
            String sql = "select * from DauSach where idDM = '"+ma+"' ";
            Connection conn = ConnectDB.getConnection();
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while(rs.next())
            {
                String IdDS = rs.getString("idDS");
                int IdDM = rs.getInt("idDM");
                String TenSach = rs.getString("TenSach");
                String TacGia = rs.getString("TacGia");
                String NhaXuatBan = rs.getString("NhaXuatBan");
                String NamXuatBan = rs.getString("NamXuatBan");
                int SoLuong = rs.getInt("SoLuong");
                String MoTa = rs.getString("MoTa");
                DauSach obj = new DauSach(IdDS, IdDM, TenSach, TacGia, NamXuatBan, NhaXuatBan, SoLuong, MoTa);
                lst.add(obj);
            }
            conn.close();
            st.close();
            return lst;
            
        } catch (Exception e) {
        }
        return null;
    }
    
    public DauSach getDauSachByMa(String ma){
    
        try {
            DauSach lst = new DauSach();
            String sql = "select * from DauSach where idDS = '"+ma+"' ";
            Connection conn = ConnectDB.getConnection();
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while(rs.next())
            {
                lst.setMaSach(rs.getString("idDS"));
                lst.setMaDanhMuc(rs.getInt("idDM"));
                lst.setTenSach(rs.getString("TenSach"));
                lst.setTacGia(rs.getString("TacGia"));
                lst.setNhaXuatBan(rs.getString("NhaXuatBan"));
                lst.setNamXuatBan(rs.getString("NamXuatBan"));
                lst.setSoLuong(rs.getInt("SoLuong"));
                lst.setMoTa(rs.getString("MoTa"));
            }
            conn.close();
            st.close();
            return lst;
            
        } catch (Exception e) {
        }
        return null;
    }
    
    public java.util.List<DauSach> TimDauSachByTen(String ten){
        java.util.List<DauSach> Sa = new ArrayList<DauSach>();
        String sql = "select * from dausach where TenSach LIKE '%"+ten+"%'";
        try {
            Connection conn = ConnectDB.getConnection();
            PreparedStatement st = conn.prepareStatement(sql);        
            ResultSet rs = st.executeQuery();
            while(rs.next())
            {
                String IdDS = rs.getString("idDS");
                int IdDM = rs.getInt("idDM");
                String TenSach = rs.getString("TenSach");
                String TacGia = rs.getString("TacGia");
                String NhaXuatBan = rs.getString("NhaXuatBan");
                String NamXuatBan = rs.getString("NamXuatBan");
                int SoLuong = rs.getInt("SoLuong");
                String MoTa = rs.getString("MoTa");
                DauSach obj = new DauSach(IdDS, IdDM, TenSach, TacGia, NamXuatBan, NhaXuatBan, SoLuong, MoTa);
                Sa.add(obj);
            }
            return Sa;

        } catch (Exception e) {
            System.out.println("Loi ket noi"+ e.getMessage());
        }
        return null;
    }
}
