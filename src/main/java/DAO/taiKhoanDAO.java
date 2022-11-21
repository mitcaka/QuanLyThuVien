/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import ConnectDB.ConnectDB;
import Models.TaiKhoan;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author ADMIN
 */
public class taiKhoanDAO {
    
    public TaiKhoan GetTaiKhoan(String TK, String MK){
        TaiKhoan td = null;
        try{
            String sql = "Select idNhanVien, password, phanquyen From Nhanvien Where  idNhanVien= '"+TK+"' and password= '"+MK+"'";
            Connection conn = ConnectDB.getConnection();
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
               td  = new TaiKhoan(rs.getString(1), rs.getString(2),rs.getInt(3));
            }
            conn.close();
            st.close();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "lỗi !");
        }
        return td;
    }
}
