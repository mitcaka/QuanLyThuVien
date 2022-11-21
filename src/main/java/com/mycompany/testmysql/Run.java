/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.testmysql;

import DAO.DocGiaDAO;
import Interface.*;
import Models.*;
import com.mysql.cj.util.TestUtils;
import java.util.List;



/**
 *
 * @author ADMIN
 */
public class Run {
public static Login_UI lg_ui;
public static Home_UI hm_ui;
public static NhanVien tk;
public static QuanLySach_UI ql_ui;
public static QuanLyMuonSach_UI ql_muon;
public static QuanLyDocGia_UI ql_dg;
public static QuanLyNhanVien_UI ql_nv;
public static ThongKe_UI thongke_ui;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {  
        Login();
    }
    
    public static void Login(){
        lg_ui = new Login_UI();
        lg_ui.setVisible(true);
    }
    public static void qlui(){
        ql_ui = new QuanLySach_UI();
        ql_ui.setVisible(true);
    }
    public static void Home(){
        hm_ui = new Home_UI();
        hm_ui.setVisible(true);
    }
    
    public static void QLMuon(){
        ql_muon = new QuanLyMuonSach_UI();
        ql_muon.setVisible(true);
    }
    
    public static void QLDG(){
        ql_dg = new QuanLyDocGia_UI();
        ql_dg.setVisible(true);
    }
    
    public static void QLNV(){
        ql_nv = new QuanLyNhanVien_UI();
        ql_nv.setVisible(true);
    }
    
    public static void ThongKe(){
        thongke_ui = new ThongKe_UI();
        thongke_ui.setVisible(true);
    }

}
