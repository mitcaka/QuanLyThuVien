/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;


import DAO.ChiTietPhieuMuonDAO;
import DAO.DauSachDAO;
import DAO.DocGiaDAO;
import DAO.PhieuMuonDAO;
import DAO.SachDAO;
import Models.ChiTietPhieuMuon;
import Models.DauSach;
import Models.DocGia;
import Models.PhieuMuon;
import Models.Sach;
import Models.SachMuon;
import com.google.protobuf.StringValue;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ASUS
 */
public class DLChiTietMuon extends javax.swing.JDialog {
    DocGiaDAO dgDAO = new DocGiaDAO();
    SachDAO sDAO = new SachDAO();
    PhieuMuonDAO pmDAO = new PhieuMuonDAO();
    ChiTietPhieuMuonDAO ctDAO = new ChiTietPhieuMuonDAO();
    int sl = 0;
    String maDG;
    int maPhieu;
    DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
    NumberFormat chuyentien = new DecimalFormat("#,###,###");
    DefaultTableModel tableModelPhieu;
    /**
     * Creates new form NewJDialog
     */
    
    /**
     * Creates new form NewJDialog
     */
    public DLChiTietMuon(java.awt.Frame parent, boolean modal, String MaDG,int MaPhieu) {
        super(parent, modal);
        initComponents();
        
        maDG = MaDG;
        maPhieu = MaPhieu;
        
        Fill();
    }
    private void Fill(){
        lblMaDG.setText(maDG);
        PhieuMuon pm = pmDAO.getAllPhieuByMa(maPhieu);
        lblHanMuon.setText(String.valueOf(pm.getHanMuon()));
        lblNgayMuon.setText(dateFormat.format(pm.getNgayMuon()));
        lblMaNV.setText(pm.getMaNV());
        txtGhiChu.setText(pm.getGhiChu());
        
        List<DocGia> lstDG = dgDAO.getAllDocGia();
        for(DocGia dg : lstDG){
            if(dg.getMaDocGia().equals(maDG)){
                lblTenDG.setText(dg.getHoTen());
            }
        }
        
        List<SachMuon> lstSM = sDAO.LoadSachByIdPhieuMuon(maPhieu);
        tableModelPhieu = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) {
             return false;               
            }  
        };
        
        tableModelPhieu.addColumn("Mã đầu sách");     
        tableModelPhieu.addColumn("Mã sách"); 
        tableModelPhieu.addColumn("Tên sách");        
        tableModelPhieu.addColumn("Tác giả");          
        tableModelPhieu.addColumn("Ngày trả"); 
        tableModelPhieu.addColumn("Tình trạng sách"); 
        tableModelPhieu.addColumn("Mức phạt");

        for(SachMuon s : lstSM){
            ChiTietPhieuMuon p = ctDAO.SearchByMaDGAndMaPhieu(s.getMaSach(), maPhieu);
            String NgayTra ="";
            if(p.getNgayTra()==null){
                NgayTra = "Chưa trả";
                lblNgayTra.setText("Chưa trả");
            }else{
                lblNgayTra.setText(dateFormat.format(p.getNgayTra()));
                NgayTra = dateFormat.format(p.getNgayTra());
            }
            
            tableModelPhieu.addRow(new Object[]{s.getMaDS(),s.getMaSach(),s.getTenSach(),s.getTacGia(),NgayTra,p.getTinhTrangSach(),chuyentien.format(p.getMucPhat())});
        }
        tblChiTietPhieuMuon.setModel(tableModelPhieu);
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        lblTenMon = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lblNgayMuon = new javax.swing.JLabel();
        lblTenDG = new javax.swing.JLabel();
        lblMaDG = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lblMaNV = new javax.swing.JLabel();
        lblHanMuon = new javax.swing.JLabel();
        lblNgayTra = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtGhiChu = new javax.swing.JTextArea();
        jButton2 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane11 = new javax.swing.JScrollPane();
        tblChiTietPhieuMuon = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setLocation(new java.awt.Point(500, 200));
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel2.setBackground(new java.awt.Color(0, 153, 255));

        lblTenMon.setFont(new java.awt.Font("Segoe UI Semibold", 0, 20)); // NOI18N
        lblTenMon.setForeground(new java.awt.Color(255, 255, 255));
        lblTenMon.setText("Chi tiết phiếu mượn");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(261, 261, 261)
                .addComponent(lblTenMon)
                .addContainerGap(237, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTenMon)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Mã độc giả :");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Tên độc giả :");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Ngày mượn :");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Ghi chú :");

        lblNgayMuon.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblNgayMuon.setText("DS0001");

        lblTenDG.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblTenDG.setText("DS0001");

        lblMaDG.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblMaDG.setText("DS0001");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Mã nhân viên :");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Hạn mượn :");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Ngày trả :");

        lblMaNV.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblMaNV.setText("xxxxxxxxxxxxxxxx");

        lblHanMuon.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblHanMuon.setText("xxxxxxxxxxxxxxxx");

        lblNgayTra.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblNgayTra.setText("xxxxxxxxxxxxxxxx");

        txtGhiChu.setEditable(false);
        txtGhiChu.setBackground(new java.awt.Color(255, 255, 255));
        txtGhiChu.setColumns(20);
        txtGhiChu.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtGhiChu.setLineWrap(true);
        txtGhiChu.setRows(5);
        jScrollPane1.setViewportView(txtGhiChu);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel3)
                                .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING))
                            .addComponent(jLabel2)
                            .addComponent(jLabel7))
                        .addGap(12, 12, 12)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNgayTra, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(lblNgayMuon, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                                .addComponent(lblTenDG, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblMaDG, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(lblHanMuon, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(27, 27, 27)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel8)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(lblMaDG)
                    .addComponent(jLabel5)
                    .addComponent(lblMaNV))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lblTenDG)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(lblNgayMuon))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(lblNgayTra))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(lblHanMuon)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButton2.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_cancel_35px.png"))); // NOI18N
        jButton2.setText("Thoát");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Chi tiết sách mượn", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N

        jScrollPane11.setBackground(new java.awt.Color(255, 255, 255));

        tblChiTietPhieuMuon.setFont(new java.awt.Font("Segoe UI Semilight", 0, 16)); // NOI18N
        tblChiTietPhieuMuon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã đầu sách", "Mã sách", "Tên sách", "Tác giả", "Tình trạng", "Tiền phạt", "Check"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Float.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblChiTietPhieuMuon.setMinimumSize(new java.awt.Dimension(20, 20));
        tblChiTietPhieuMuon.setRowHeight(25);
        tblChiTietPhieuMuon.setSelectionBackground(new java.awt.Color(0, 255, 204));
        jScrollPane11.setViewportView(tblChiTietPhieuMuon);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 620, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 608, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 253, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(284, 284, 284)
                .addComponent(jButton2))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JLabel lblHanMuon;
    private javax.swing.JLabel lblMaDG;
    private javax.swing.JLabel lblMaNV;
    private javax.swing.JLabel lblNgayMuon;
    private javax.swing.JLabel lblNgayTra;
    private javax.swing.JLabel lblTenDG;
    private javax.swing.JLabel lblTenMon;
    private javax.swing.JTable tblChiTietPhieuMuon;
    private javax.swing.JTextArea txtGhiChu;
    // End of variables declaration//GEN-END:variables
}
