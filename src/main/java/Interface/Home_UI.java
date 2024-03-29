/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interface;

import com.mycompany.testmysql.Run;
import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author ADMIN
 */
public class Home_UI extends javax.swing.JFrame {

    /**
     * Creates new form Home_UI
     */
    public Home_UI() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        title = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        btn_muonSach = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btn_docGia = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btn_qlSach = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btn_nhanVien = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        btn_caiDat = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        btn_dangXuat = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));

        title.setBackground(new java.awt.Color(0, 153, 153));
        title.setFont(new java.awt.Font("Segoe UI Light", 0, 36)); // NOI18N
        title.setForeground(new java.awt.Color(255, 255, 255));
        title.setText("                              Phần mềm quản lý thư viện Bee");
        title.setOpaque(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new java.awt.GridLayout(2, 3, 80, 80));

        btn_muonSach.setBackground(new java.awt.Color(255, 255, 255));
        btn_muonSach.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        btn_muonSach.setPreferredSize(new java.awt.Dimension(120, 120));
        btn_muonSach.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_muonSachMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_muonSachMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_muonSachMouseExited(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_book_reading_64px.png"))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        jLabel4.setText(" Mượn sách");

        javax.swing.GroupLayout btn_muonSachLayout = new javax.swing.GroupLayout(btn_muonSach);
        btn_muonSach.setLayout(btn_muonSachLayout);
        btn_muonSachLayout.setHorizontalGroup(
            btn_muonSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_muonSachLayout.createSequentialGroup()
                .addGroup(btn_muonSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(btn_muonSachLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel2))
                    .addGroup(btn_muonSachLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        btn_muonSachLayout.setVerticalGroup(
            btn_muonSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_muonSachLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jPanel1.add(btn_muonSach);

        btn_docGia.setBackground(new java.awt.Color(255, 255, 255));
        btn_docGia.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        btn_docGia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_docGiaMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_docGiaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_docGiaMouseExited(evt);
            }
        });

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_user_64px.png"))); // NOI18N

        jLabel6.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        jLabel6.setText("Độc giả");

        javax.swing.GroupLayout btn_docGiaLayout = new javax.swing.GroupLayout(btn_docGia);
        btn_docGia.setLayout(btn_docGiaLayout);
        btn_docGiaLayout.setHorizontalGroup(
            btn_docGiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_docGiaLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(btn_docGiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        btn_docGiaLayout.setVerticalGroup(
            btn_docGiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_docGiaLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jPanel1.add(btn_docGia);

        btn_qlSach.setBackground(new java.awt.Color(255, 255, 255));
        btn_qlSach.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        btn_qlSach.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_qlSachMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_qlSachMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_qlSachMouseExited(evt);
            }
        });

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_books_64px.png"))); // NOI18N

        jLabel8.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        jLabel8.setText("Quản lý sách");

        javax.swing.GroupLayout btn_qlSachLayout = new javax.swing.GroupLayout(btn_qlSach);
        btn_qlSach.setLayout(btn_qlSachLayout);
        btn_qlSachLayout.setHorizontalGroup(
            btn_qlSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btn_qlSachLayout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
            .addGroup(btn_qlSachLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        btn_qlSachLayout.setVerticalGroup(
            btn_qlSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_qlSachLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jPanel1.add(btn_qlSach);

        btn_nhanVien.setBackground(new java.awt.Color(255, 255, 255));
        btn_nhanVien.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        btn_nhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_nhanVienMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_nhanVienMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_nhanVienMouseExited(evt);
            }
        });

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_name_tag_64px.png"))); // NOI18N

        jLabel10.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        jLabel10.setText(" Nhân viên");

        javax.swing.GroupLayout btn_nhanVienLayout = new javax.swing.GroupLayout(btn_nhanVien);
        btn_nhanVien.setLayout(btn_nhanVienLayout);
        btn_nhanVienLayout.setHorizontalGroup(
            btn_nhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_nhanVienLayout.createSequentialGroup()
                .addGroup(btn_nhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(btn_nhanVienLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel9))
                    .addGroup(btn_nhanVienLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        btn_nhanVienLayout.setVerticalGroup(
            btn_nhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_nhanVienLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jPanel1.add(btn_nhanVien);

        btn_caiDat.setBackground(new java.awt.Color(255, 255, 255));
        btn_caiDat.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        btn_caiDat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_caiDatMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_caiDatMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_caiDatMouseExited(evt);
            }
        });

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_statistics_64px.png"))); // NOI18N

        jLabel12.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        jLabel12.setText("Thống kê");

        javax.swing.GroupLayout btn_caiDatLayout = new javax.swing.GroupLayout(btn_caiDat);
        btn_caiDat.setLayout(btn_caiDatLayout);
        btn_caiDatLayout.setHorizontalGroup(
            btn_caiDatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_caiDatLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(btn_caiDatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        btn_caiDatLayout.setVerticalGroup(
            btn_caiDatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_caiDatLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jPanel1.add(btn_caiDat);

        btn_dangXuat.setBackground(new java.awt.Color(255, 255, 255));
        btn_dangXuat.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        btn_dangXuat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_dangXuatMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_dangXuatMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_dangXuatMouseExited(evt);
            }
        });

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_Logout_64px.png"))); // NOI18N

        jLabel14.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        jLabel14.setText("  Đăng xuất");

        javax.swing.GroupLayout btn_dangXuatLayout = new javax.swing.GroupLayout(btn_dangXuat);
        btn_dangXuat.setLayout(btn_dangXuatLayout);
        btn_dangXuatLayout.setHorizontalGroup(
            btn_dangXuatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_dangXuatLayout.createSequentialGroup()
                .addGroup(btn_dangXuatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(btn_dangXuatLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel13))
                    .addGroup(btn_dangXuatLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        btn_dangXuatLayout.setVerticalGroup(
            btn_dangXuatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_dangXuatLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel14)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jPanel1.add(btn_dangXuat);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main_images/logo.png"))); // NOI18N

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/main_images/book1.png"))); // NOI18N
        jLabel3.setText("jLabel3");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(title, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(46, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 63, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(41, 41, 41))))
        );

        getContentPane().add(jPanel3, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_muonSachMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_muonSachMouseClicked

        if(Run.tk.getPhanQuyen()==1){
            this.setVisible(false);
            Run.QLMuon();
        }else{
            JOptionPane.showMessageDialog(null, "Bạn không có quyền truy cập !!!");
        }
    }//GEN-LAST:event_btn_muonSachMouseClicked

    private void btn_docGiaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_docGiaMouseClicked

        if(Run.tk.getPhanQuyen()==1){
            this.setVisible(false);
            Run.QLDG();
        }else{
            JOptionPane.showMessageDialog(null, "Bạn không có quyền truy cập !!!");
        }
    }//GEN-LAST:event_btn_docGiaMouseClicked

    private void btn_qlSachMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_qlSachMouseClicked

        if(Run.tk.getPhanQuyen()==1){
            this.setVisible(false);
            Run.qlui();
        }else{
            JOptionPane.showMessageDialog(null, "Bạn không có quyền truy cập !!!");
        }
    }//GEN-LAST:event_btn_qlSachMouseClicked

    private void btn_nhanVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_nhanVienMouseClicked
        if(Run.tk.getPhanQuyen()==0){
            Run.QLNV();
            this.setVisible(false);
        }else{
            JOptionPane.showMessageDialog(null, "Bạn không có quyền truy cập !!!");
        }
    }//GEN-LAST:event_btn_nhanVienMouseClicked

    private void btn_caiDatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_caiDatMouseClicked

        if(Run.tk.getPhanQuyen()==1){
            this.setVisible(false);
            Run.ThongKe();
        }else{
            JOptionPane.showMessageDialog(null, "Bạn không có quyền truy cập !!!");
        }
    }//GEN-LAST:event_btn_caiDatMouseClicked

    private void btn_dangXuatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_dangXuatMouseClicked
        System.exit(0);
    }//GEN-LAST:event_btn_dangXuatMouseClicked

    private void btn_muonSachMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_muonSachMouseEntered
        setColorHome(btn_muonSach);
    }//GEN-LAST:event_btn_muonSachMouseEntered

    private void btn_muonSachMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_muonSachMouseExited
        resetColorHome(btn_muonSach);
    }//GEN-LAST:event_btn_muonSachMouseExited

    private void btn_docGiaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_docGiaMouseEntered
        setColorHome(btn_docGia);
    }//GEN-LAST:event_btn_docGiaMouseEntered

    private void btn_docGiaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_docGiaMouseExited
        resetColorHome(btn_docGia);
    }//GEN-LAST:event_btn_docGiaMouseExited

    private void btn_qlSachMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_qlSachMouseEntered
        setColorHome(btn_qlSach);
    }//GEN-LAST:event_btn_qlSachMouseEntered

    private void btn_qlSachMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_qlSachMouseExited
        resetColorHome(btn_qlSach);
    }//GEN-LAST:event_btn_qlSachMouseExited

    private void btn_nhanVienMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_nhanVienMouseEntered
        setColorHome(btn_nhanVien);
    }//GEN-LAST:event_btn_nhanVienMouseEntered

    private void btn_nhanVienMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_nhanVienMouseExited
        resetColorHome(btn_nhanVien);
    }//GEN-LAST:event_btn_nhanVienMouseExited

    private void btn_caiDatMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_caiDatMouseEntered
        setColorHome(btn_caiDat);
    }//GEN-LAST:event_btn_caiDatMouseEntered

    private void btn_caiDatMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_caiDatMouseExited
        resetColorHome(btn_caiDat);
    }//GEN-LAST:event_btn_caiDatMouseExited

    private void btn_dangXuatMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_dangXuatMouseEntered
        setColorHome(btn_dangXuat);
    }//GEN-LAST:event_btn_dangXuatMouseEntered

    private void btn_dangXuatMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_dangXuatMouseExited
        resetColorHome(btn_dangXuat);
    }//GEN-LAST:event_btn_dangXuatMouseExited

    /**
     * @param args the command line arguments
     */

    public void setColorHome(JPanel panel){
        panel.setBackground(new Color(153,255,255));
    }
    
    public void resetColorHome(JPanel panel){
        panel.setBackground(Color.white);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel btn_caiDat;
    private javax.swing.JPanel btn_dangXuat;
    private javax.swing.JPanel btn_docGia;
    private javax.swing.JPanel btn_muonSach;
    private javax.swing.JPanel btn_nhanVien;
    private javax.swing.JPanel btn_qlSach;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables
}
