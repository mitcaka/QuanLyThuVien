/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interface;

import DAO.DanhMucDAO;
import DAO.DauSachDAO;
import DAO.SachDAO;
import Models.DanhMuc;
import Models.DauSach;
import Models.Sach;
import Models.TinhTrangSach;
import com.mycompany.testmysql.Run;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.KeyEvent;
import static java.lang.Thread.sleep;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

/**
 *
 * @author ADMIN
 */
public class QuanLySach_UI extends javax.swing.JFrame {
    private final DefaultTableModel tbModelDanhMuc = new DefaultTableModel();
    private final DefaultTableModel tbModelDauSach = new DefaultTableModel();
    private final DefaultTableModel tbModelTinhTrangSach = new DefaultTableModel();
    /**
     * Creates new form Quanly_UI
     */
    public QuanLySach_UI() {
        initComponents();
        
        //Set tên NV
        String text = "Xin chào,"+Run.tk.getHoTenNV();
        lblQTV.setText(text);
        //Set thời gian
        Clock clock= new Clock(); 
        clock.start();
        
        ShowdataDanhMuc();
        LoadComboBox();
        ShowdataDauSach();
        btnLuuDS.setEnabled(false);
        btnLuu.setEnabled(false);
        ShowdataTinhTrangSach();
        
        tbDauSach.getColumnModel().getColumn(1).setMinWidth(0);
        tbDauSach.getColumnModel().getColumn(1).setMaxWidth(0);        
        tbDauSach.getColumnModel().getColumn(1).setPreferredWidth(0);
        
        setFontTable(tbDanhMuc);
        setFontTable(tbDauSach);
        setFontTable(tbTinhTrangSach);
    }
    
    SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss a");
    public class Clock extends Thread{ 
    public Clock(){    } 
    @Override
    public void run(){ 
        while(true){ 
            Calendar calendar = Calendar.getInstance();                
            String str;  
            str= sdf.format(calendar.getTime()); 
            lblTime.setText(str); 
        try{ 
            sleep(1000); 
          } catch(Exception e){ 
             System.out.println(e); 
            } 
      } 
    }
    }
    
    public void LoadComboBox(){
        DanhMucDAO dm = new DanhMucDAO();
        Vector result = dm.getDM();
        if(result != null){
            DefaultComboBoxModel cbbmodel = new DefaultComboBoxModel(result);
            cbbDanhMuc.setModel(cbbmodel);    
        }else{
            JOptionPane.showMessageDialog(this, "Không có danh mục nào");
        }
    }
    public void cleardataDanhMuc()
    {
        while (tbModelDanhMuc.getRowCount()>0) {
            tbModelDanhMuc.removeRow(0);
            
        }
    }
    public void ShowdataDanhMuc()
    {
        String[] tencot = {"Mã Danh Mục", "Tên Danh Mục"};
        tbModelDanhMuc.setColumnIdentifiers(tencot);
        tbDanhMuc.setModel(tbModelDanhMuc);
        cleardataDanhMuc();
        DanhMucDAO dm = new DanhMucDAO();
        List<DanhMuc> data = dm.getDanhMuc();
        for (int i = 0; i < data.size(); i++) {
            String[] row = {
                String.valueOf(data.get(i).getMaDanhMuc()),
                data.get(i).getTenDanhMuc(),
                
            };
            tbModelDanhMuc.addRow(row);
            
        }
    }
    public void cleardataDauSach()
    {
        while (tbModelDauSach.getRowCount()>0) {
            tbModelDauSach.removeRow(0);
            
        }
    }
    public void ShowdataDauSach()
    {
       
        String[] tencot = {"Mã Dầu Sách","Tên danh mục", "Tên Sach", "Tác Giả", "Nhà Xuât Bản", "Năm Xuất Bản", "Số Lượng", "Mô Tả"};
        tbModelDauSach.setColumnIdentifiers(tencot);
        tbDauSach.setModel(tbModelDauSach);
        cleardataDauSach();
        DauSachDAO ds = new DauSachDAO();
        DanhMucDAO dm = new DanhMucDAO();
        List<DauSach> data = ds.getDauSach();
        for (int i = 0; i < data.size(); i++) {
            String[] row = {
                data.get(i).getMaSach(),
                String.valueOf(data.get(i).getMaDanhMuc()),
                data.get(i).getTenSach(),
                data.get(i).getTacGia(),
                data.get(i).getNhaXuatBan(),
                data.get(i).getNamXuatBan(),
                String.valueOf(data.get(i).getSoLuong()),
                data.get(i).getMoTa(),
            };
            tbModelDauSach.addRow(row);
            
        }
    }
    public void cleardataTinhTrangSach()
    {
        while (tbModelTinhTrangSach.getRowCount()>0) {
            tbModelTinhTrangSach.removeRow(0);
            
        }
    }
    public void ShowdataTinhTrangSach()
    {
        String[] tencot = {"Mã Sách", "Tên Sách", "Đã cho mượn", "Có Thể mượn"};
        tbModelTinhTrangSach.setColumnIdentifiers(tencot);
        tbTinhTrangSach.setModel(tbModelTinhTrangSach);
        cleardataTinhTrangSach();
        SachDAO sach = new SachDAO();
        List<TinhTrangSach> data = sach.getTinhTrangSach();
        for (int i = 0; i < data.size(); i++) {
            String[] row = {
                data.get(i).getIdDS(),
                data.get(i).getTensach(),
                String.valueOf(data.get(i).getTrangThaiChoMuon()),
                String.valueOf(data.get(i).getTrangThaiChuaMuon()),
            };
            tbModelTinhTrangSach.addRow(row);
            
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel2 = new javax.swing.JPanel();
        jTabbedPaneMenu = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtMaDm = new javax.swing.JTextField();
        txtTenDM = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnXoa = new javax.swing.JButton();
        btnLuu = new javax.swing.JButton();
        btnLamMoi = new javax.swing.JButton();
        btnTimKiem = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbDanhMuc = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtMaDS = new javax.swing.JTextField();
        txtTenDS = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtTacGia = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtNhaXuatBan = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        taraMoTa = new javax.swing.JTextArea();
        txtSoLuong = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        cbbDanhMuc = new javax.swing.JComboBox<>();
        txtNamXuatBan = new javax.swing.JTextField();
        jPanel13 = new javax.swing.JPanel();
        btnThemDS = new javax.swing.JButton();
        btnSuaDS = new javax.swing.JButton();
        btnXoaDS = new javax.swing.JButton();
        btnTimKiemDS = new javax.swing.JButton();
        btnLamMoiDS = new javax.swing.JButton();
        btnLuuDS = new javax.swing.JButton();
        jPanel12 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbDauSach = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tbTinhTrangSach = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        lblQTV = new javax.swing.JLabel();
        lblTime = new javax.swing.JLabel();
        btnHome = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(102, 102, 102)));
        jPanel2.setPreferredSize(new java.awt.Dimension(1313, 775));
        jPanel2.setLayout(new java.awt.BorderLayout());

        jTabbedPaneMenu.setBackground(new java.awt.Color(0, 153, 153));
        jTabbedPaneMenu.setForeground(new java.awt.Color(255, 255, 255));
        jTabbedPaneMenu.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        jTabbedPaneMenu.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        jTabbedPaneMenu.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTabbedPaneMenu.setFocusCycleRoot(true);
        jTabbedPaneMenu.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
        jTabbedPaneMenu.setInheritsPopupMenu(true);
        jTabbedPaneMenu.setMinimumSize(new java.awt.Dimension(57, 40));
        jTabbedPaneMenu.setName(""); // NOI18N
        jTabbedPaneMenu.setOpaque(true);
        jTabbedPaneMenu.setVerifyInputWhenFocusTarget(false);
        jTabbedPaneMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTabbedPaneMenuMouseClicked(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jPanel3.setLayout(new java.awt.BorderLayout());

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        jLabel2.setText("Quản lý danh mục sách");

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        jLabel6.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        jLabel6.setText("Tên danh mục :");

        jLabel7.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        jLabel7.setText("Mã danh mục :");

        txtMaDm.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N

        txtTenDM.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(149, 149, 149)
                .addComponent(txtMaDm, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(txtTenDM, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel6Layout.createSequentialGroup()
                    .addGap(25, 25, 25)
                    .addComponent(jLabel7)
                    .addContainerGap(605, Short.MAX_VALUE)))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMaDm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txtTenDM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel6Layout.createSequentialGroup()
                    .addGap(25, 25, 25)
                    .addComponent(jLabel7)
                    .addContainerGap(22, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap(185, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(135, 135, 135))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(296, 296, 296))))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(29, 29, 29)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel3.add(jPanel7, java.awt.BorderLayout.NORTH);

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setLayout(new java.awt.BorderLayout());

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setLayout(new java.awt.GridBagLayout());

        btnThem.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_plus_+_30px_1.png"))); // NOI18N
        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(12, 12, 12, 12);
        jPanel9.add(btnThem, gridBagConstraints);

        btnSua.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btnSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_edit_file_30px.png"))); // NOI18N
        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(12, 12, 12, 12);
        jPanel9.add(btnSua, gridBagConstraints);

        btnXoa.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_cancel_30px.png"))); // NOI18N
        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(12, 12, 12, 12);
        jPanel9.add(btnXoa, gridBagConstraints);

        btnLuu.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btnLuu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_save_close_30px.png"))); // NOI18N
        btnLuu.setText("Lưu");
        btnLuu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuuActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(12, 12, 12, 12);
        jPanel9.add(btnLuu, gridBagConstraints);

        btnLamMoi.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btnLamMoi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_reset_30px.png"))); // NOI18N
        btnLamMoi.setText("Làm mới");
        btnLamMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(12, 12, 12, 12);
        jPanel9.add(btnLamMoi, gridBagConstraints);

        btnTimKiem.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btnTimKiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_search_30px.png"))); // NOI18N
        btnTimKiem.setText("Tìm kiếm");
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });
        jPanel9.add(btnTimKiem, new java.awt.GridBagConstraints());

        jPanel8.add(jPanel9, java.awt.BorderLayout.NORTH);

        jScrollPane3.setBackground(new java.awt.Color(255, 255, 255));

        tbDanhMuc.setFont(new java.awt.Font("Segoe UI Semilight", 0, 18)); // NOI18N
        tbDanhMuc.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null}
            },
            new String [] {
                "Mã danh mục", "Tên danh mục"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbDanhMuc.setMinimumSize(new java.awt.Dimension(20, 20));
        tbDanhMuc.setRowHeight(25);
        tbDanhMuc.setSelectionBackground(new java.awt.Color(0, 255, 204));
        tbDanhMuc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbDanhMucMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tbDanhMuc);

        jPanel8.add(jScrollPane3, java.awt.BorderLayout.CENTER);

        jPanel3.add(jPanel8, java.awt.BorderLayout.CENTER);

        jTabbedPaneMenu.addTab("Quản lý danh mục sách", new javax.swing.ImageIcon(getClass().getResource("/images/icons8_list_20px.png")), jPanel3); // NOI18N

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new java.awt.BorderLayout());

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setLayout(new java.awt.BorderLayout());

        jLabel8.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        jLabel8.setText("                                                                   Quản lý đầu sách");
        jPanel10.add(jLabel8, java.awt.BorderLayout.NORTH);

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));
        jPanel11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        jLabel9.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        jLabel9.setText("Danh mục :");

        jLabel10.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        jLabel10.setText("Mã đầu sách :");

        txtMaDS.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtMaDS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaDSActionPerformed(evt);
            }
        });
        txtMaDS.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtMaDSKeyPressed(evt);
            }
        });

        txtTenDS.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtTenDS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenDSActionPerformed(evt);
            }
        });
        txtTenDS.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTenDSKeyPressed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        jLabel11.setText("Tên đầu sách :");

        jLabel12.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        jLabel12.setText("Tác giả :");

        txtTacGia.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtTacGia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTacGiaKeyPressed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        jLabel13.setText("Nhà xuất bản :");

        txtNhaXuatBan.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtNhaXuatBan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNhaXuatBanKeyPressed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        jLabel14.setText("Năm xuất bản :");

        jLabel15.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        jLabel15.setText("Mô tả :");

        taraMoTa.setColumns(20);
        taraMoTa.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        taraMoTa.setLineWrap(true);
        taraMoTa.setRows(5);
        taraMoTa.setWrapStyleWord(true);
        taraMoTa.setAutoscrolls(false);
        taraMoTa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                taraMoTaKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(taraMoTa);

        txtSoLuong.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        txtSoLuong.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSoLuongKeyPressed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Segoe UI Semibold", 0, 16)); // NOI18N
        jLabel16.setText("Số lượng:");

        cbbDanhMuc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbDanhMuc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbDanhMucActionPerformed(evt);
            }
        });

        txtNamXuatBan.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNamXuatBanKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtMaDS)
                    .addComponent(txtTenDS)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                    .addComponent(txtSoLuong))
                .addGap(64, 64, 64)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(63, 63, 63)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtNamXuatBan)
                    .addComponent(txtNhaXuatBan, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                    .addComponent(txtTacGia, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                    .addComponent(cbbDanhMuc, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(61, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMaDS)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(cbbDanhMuc, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txtTenDS)
                    .addComponent(txtTacGia)
                    .addComponent(jLabel12))
                .addGap(9, 9, 9)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNhaXuatBan)
                            .addComponent(jLabel15)
                            .addComponent(jLabel13))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(txtNamXuatBan))))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28))
        );

        jPanel10.add(jPanel11, java.awt.BorderLayout.CENTER);

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));
        jPanel13.setLayout(new java.awt.GridBagLayout());

        btnThemDS.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btnThemDS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_plus_+_30px_1.png"))); // NOI18N
        btnThemDS.setText("Thêm");
        btnThemDS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemDSActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(12, 12, 12, 12);
        jPanel13.add(btnThemDS, gridBagConstraints);

        btnSuaDS.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btnSuaDS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_edit_file_30px.png"))); // NOI18N
        btnSuaDS.setText("Sửa");
        btnSuaDS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaDSActionPerformed(evt);
            }
        });
        jPanel13.add(btnSuaDS, new java.awt.GridBagConstraints());

        btnXoaDS.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btnXoaDS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_cancel_30px.png"))); // NOI18N
        btnXoaDS.setText("Xóa");
        btnXoaDS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaDSActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(12, 12, 12, 12);
        jPanel13.add(btnXoaDS, gridBagConstraints);

        btnTimKiemDS.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btnTimKiemDS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_search_30px.png"))); // NOI18N
        btnTimKiemDS.setText("Tìm kiếm");
        btnTimKiemDS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemDSActionPerformed(evt);
            }
        });
        jPanel13.add(btnTimKiemDS, new java.awt.GridBagConstraints());

        btnLamMoiDS.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btnLamMoiDS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_reset_30px.png"))); // NOI18N
        btnLamMoiDS.setText("Làm mới");
        btnLamMoiDS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLamMoiDSActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(12, 12, 12, 12);
        jPanel13.add(btnLamMoiDS, gridBagConstraints);

        btnLuuDS.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btnLuuDS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_save_close_30px.png"))); // NOI18N
        btnLuuDS.setText("Lưu");
        btnLuuDS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuuDSActionPerformed(evt);
            }
        });
        jPanel13.add(btnLuuDS, new java.awt.GridBagConstraints());

        jPanel10.add(jPanel13, java.awt.BorderLayout.SOUTH);

        jPanel4.add(jPanel10, java.awt.BorderLayout.NORTH);

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));
        jPanel12.setLayout(new java.awt.BorderLayout());

        jScrollPane4.setBackground(new java.awt.Color(255, 255, 255));

        tbDauSach.setFont(new java.awt.Font("Segoe UI Semilight", 0, 18)); // NOI18N
        tbDauSach.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã đầu sách", "Mã danh mục", "Tên đầu sách", "Tác giả", "Nhà xuất bản", "Năm xuất bản", "Số lượng", "Mô tả"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbDauSach.setMinimumSize(new java.awt.Dimension(20, 20));
        tbDauSach.setRowHeight(25);
        tbDauSach.setSelectionBackground(new java.awt.Color(0, 255, 204));
        tbDauSach.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbDauSachMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tbDauSach);

        jPanel12.add(jScrollPane4, java.awt.BorderLayout.CENTER);

        jPanel4.add(jPanel12, java.awt.BorderLayout.CENTER);

        jTabbedPaneMenu.addTab("Quản lý đầu sách           ", new javax.swing.ImageIcon(getClass().getResource("/images/icons8_book_20px.png")), jPanel4); // NOI18N

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jLabel5.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        jLabel5.setText("Kiểm tra tình trạng sách");

        jScrollPane5.setBackground(new java.awt.Color(255, 255, 255));

        tbTinhTrangSach.setFont(new java.awt.Font("Segoe UI Semilight", 0, 18)); // NOI18N
        tbTinhTrangSach.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tbTinhTrangSach.setMinimumSize(new java.awt.Dimension(20, 20));
        tbTinhTrangSach.setRowHeight(25);
        tbTinhTrangSach.setSelectionBackground(new java.awt.Color(0, 255, 204));
        tbTinhTrangSach.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbTinhTrangSachMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tbTinhTrangSach);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(272, 272, 272))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 1064, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 519, Short.MAX_VALUE)
                .addGap(153, 153, 153))
        );

        jTabbedPaneMenu.addTab("Kiểm tra tình trạng sách", new javax.swing.ImageIcon(getClass().getResource("/images/icons8_folder_20px.png")), jPanel5); // NOI18N

        jPanel2.add(jTabbedPaneMenu, java.awt.BorderLayout.CENTER);

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTitle.setFont(new java.awt.Font("Segoe UI Semibold", 0, 24)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(255, 255, 255));
        lblTitle.setText("Quản lý sách");
        jPanel1.add(lblTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 10, 148, 47));

        lblQTV.setFont(new java.awt.Font("Segoe UI Light", 3, 14)); // NOI18N
        lblQTV.setForeground(new java.awt.Color(255, 255, 255));
        lblQTV.setText("Xin chào");
        jPanel1.add(lblQTV, new org.netbeans.lib.awtextra.AbsoluteConstraints(1004, 6, -1, -1));

        lblTime.setFont(new java.awt.Font("Segoe UI Light", 1, 14)); // NOI18N
        lblTime.setForeground(new java.awt.Color(255, 255, 255));
        lblTime.setText("jLabel5");
        jPanel1.add(lblTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(1004, 32, 210, -1));

        btnHome.setBackground(new java.awt.Color(0, 153, 153));
        btnHome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnHomeMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnHomeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnHomeMouseExited(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI Semibold", 0, 20)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Trang chủ");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_home_40px.png"))); // NOI18N

        javax.swing.GroupLayout btnHomeLayout = new javax.swing.GroupLayout(btnHome);
        btnHome.setLayout(btnHomeLayout);
        btnHomeLayout.setHorizontalGroup(
            btnHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnHomeLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addGap(15, 15, 15))
        );
        btnHomeLayout.setVerticalGroup(
            btnHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnHomeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(btnHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(btnHome, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 155, -1));

        jPanel2.add(jPanel1, java.awt.BorderLayout.PAGE_START);

        getContentPane().add(jPanel2, java.awt.BorderLayout.PAGE_START);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
        // TODO add your handling code here:
        txtMaDm.setEnabled(false);
        StringBuilder sb = new StringBuilder();
        if(txtTenDM.getText().equals("")){
        
            JOptionPane.showMessageDialog(this, "Tên danh mục không được trống");
            
        }
        try {
            DanhMucDAO dao = new DanhMucDAO();
            List<DanhMuc> data = dao.Search(txtTenDM.getText());
            DefaultTableModel tableModel = new DefaultTableModel();
            tableModel.addColumn("Mã Danh Mục");        
            tableModel.addColumn("Tên Danh Mục");        
        for(DanhMuc sp : data){
            tableModel.addRow(new Object[]{sp.getMaDanhMuc(),sp.getTenDanhMuc()});
            System.out.println(sp.getTenDanhMuc());
        }
        tbDanhMuc.setModel(tableModel);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(this, "Tên Danh Muc Khong Ton Tai");
        }
        btnLuu.setEnabled(false);
        btnXoa.setEnabled(true);
        btnThem.setEnabled(false);
        btnSua.setEnabled(true);
    }//GEN-LAST:event_btnTimKiemActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        // TODO add your handling code here:
        btnSua.setEnabled(false);
        btnXoa.setEnabled(false);
        btnTimKiem.setEnabled(false);
        txtMaDm.setEnabled(false);
        btnLuu.setEnabled(true);
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
        btnTimKiem.setEnabled(false);
        btnXoa.setEnabled(false);
        btnThem.setEnabled(false);
        btnLuu.setEnabled(true);
        btnLuu.setEnabled(true);
    }//GEN-LAST:event_btnSuaActionPerformed

    private void tbDanhMucMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbDanhMucMouseClicked
        // TODO add your handling code here:
        int row = tbDanhMuc.getSelectedRow();
        if(row >= 0)
        {
            txtMaDm.setText(tbDanhMuc.getValueAt(row, 0).toString());
            txtTenDM.setText(tbDanhMuc.getValueAt(row, 1).toString());
        }
    }//GEN-LAST:event_tbDanhMucMouseClicked

    private void btnLamMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiActionPerformed
        // TODO add your handling code here:
        txtMaDm.setEnabled(true);
        txtMaDm.setText("");
        txtTenDM.setText("");
        btnSua.setEnabled(true);
        btnXoa.setEnabled(true);
        btnThem.setEnabled(true);
        btnTimKiem.setEnabled(true);
        btnLuu.setEnabled(false);
        ShowdataDanhMuc();
        txtMaDm.setBackground(Color.white);
    }//GEN-LAST:event_btnLamMoiActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        // TODO add your handling code here:
        btnSua.setEnabled(false);
        btnTimKiem.setEnabled(false);
        btnThem.setEnabled(false);
        btnLuu.setEnabled(true);
    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnLuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuuActionPerformed
        // TODO add your handling code here:
        if(btnThem.isEnabled())
        {
            
            try {
                
                DanhMuc dm = new DanhMuc();
                dm.setTenDanhMuc(txtTenDM.getText());
                DanhMucDAO na = new DanhMucDAO();
                na.insert(dm);
                JOptionPane.showMessageDialog(this, "Thêm mới thành công");
                ShowdataDanhMuc();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
        }else if(btnSua.isEnabled()){
            StringBuffer sb = new StringBuffer();
            if(txtMaDm.getText().equals("")){
                sb.append("Mã danh mục không được trống");
                txtMaDm.setBackground(Color.red);
            }
            if(sb.length()>0){
                JOptionPane.showMessageDialog(this, sb);
            }
            try {
                DanhMuc dm = new DanhMuc();
                dm.setMaDanhMuc(Integer.parseInt(txtMaDm.getText()));
                dm.setTenDanhMuc(txtTenDM.getText());
                DanhMucDAO na = new DanhMucDAO();
                na.update(dm);
                JOptionPane.showMessageDialog(this, "Sửa thành công");
                ShowdataDanhMuc();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
        }else if(btnXoa.isEnabled()){
            String ml = txtMaDm.getText();
            StringBuilder sb = new StringBuilder();
            if(ml.equals("")){
                JOptionPane.showMessageDialog(this, "Mã danh mục không được trống");
                txtMaDm.setBackground(Color.red);
            }
            else{
                DanhMucDAO na = new DanhMucDAO();
                boolean kt = na.delete(Integer.parseInt(ml));
                if(kt==true)
                {
                    JOptionPane.showMessageDialog(this, "Xóa thành công");
                }else{
                    JOptionPane.showMessageDialog(this, "Xóa thất bại");
                }
                ShowdataDanhMuc();
            }
        }
    }//GEN-LAST:event_btnLuuActionPerformed

    private void btnThemDSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemDSActionPerformed
        // TODO add your handling code here:
        
        btnSuaDS.setEnabled(false);
        btnTimKiemDS.setEnabled(false);
        btnXoaDS.setEnabled(false);
        txtMaDS.setEnabled(true);
        btnLuuDS.setEnabled(true);
        btnLuuDS.setEnabled(true);
    }//GEN-LAST:event_btnThemDSActionPerformed

    private void txtTenDSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenDSActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenDSActionPerformed

    private void btnSuaDSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaDSActionPerformed
        // TODO add your handling code here:
         btnThemDS.setEnabled(false);
        btnTimKiemDS.setEnabled(false);
        btnXoaDS.setEnabled(false);
        txtMaDS.setEnabled(false);
        btnLuuDS.setEnabled(true);
    }//GEN-LAST:event_btnSuaDSActionPerformed

    private void btnXoaDSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaDSActionPerformed
        // TODO add your handling code here:
        btnSuaDS.setEnabled(false);
        btnTimKiemDS.setEnabled(false);
        btnThemDS.setEnabled(false);
        txtMaDS.setEnabled(false);
        btnLuuDS.setEnabled(true);
    }//GEN-LAST:event_btnXoaDSActionPerformed

    private void btnTimKiemDSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemDSActionPerformed
        // TODO add your handling code here:
        btnSuaDS.setEnabled(true);
        btnXoaDS.setEnabled(true);
        btnThemDS.setEnabled(false);
        btnLuuDS.setEnabled(true);
        if(txtMaDS.getText().equals("") &&txtTenDS.getText().equals("") &&txtNamXuatBan.getText().equals("") && txtNhaXuatBan.getText().equals("") && txtTacGia.getText().equals("")&& taraMoTa.getText().equals("")){
                JOptionPane.showMessageDialog(this, "Nhập ít nhất 1 thông tin tìm kiếm");
            }else{
                try {
                    cleardataDauSach();
                    DauSachDAO dao = new DauSachDAO();
                    List<DauSach> dataDS = dao.SearchDS(txtMaDS.getText().toString(),txtTenDS.getText().toString(),taraMoTa.getText().toString(), txtTacGia.getText().toString(),txtNhaXuatBan.getText().toString(),txtNamXuatBan.getText().toString());
                    for (int i = 0; i < dataDS.size(); i++) {
                        String[] row = {
                        String.valueOf(dataDS.get(i).getMaSach()),
                        String.valueOf(dataDS.get(i).getMaDanhMuc()),
                        dataDS.get(i).getTenSach(),
                        dataDS.get(i).getTacGia(),
                        dataDS.get(i).getNhaXuatBan(),
                        String.valueOf(dataDS.get(i).getNamXuatBan()),
                        String.valueOf(dataDS.get(i).getSoLuong()),
                        dataDS.get(i).getMoTa(),
                    };
                    tbModelDauSach.addRow(row);

                }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    JOptionPane.showMessageDialog(this, "Không có kết quả phù hợp");

                }
            }
    }//GEN-LAST:event_btnTimKiemDSActionPerformed

    private void btnLamMoiDSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLamMoiDSActionPerformed
        // TODO add your handling code here:
        txtSoLuong.setEnabled(true);
        txtMaDS.setText("");
        txtTenDS.setText("");
        txtTacGia.setText("");
        txtNamXuatBan.setText("");
        txtNhaXuatBan.setText("");
        taraMoTa.setText("");
        txtSoLuong.setText("");
        btnThemDS.setEnabled(true);
        btnSuaDS.setEnabled(true);
        btnXoaDS.setEnabled(true);
        btnTimKiemDS.setEnabled(true);
        txtMaDS.setEnabled(true);
        btnLuuDS.setEnabled(true);
        btnLuuDS.setEnabled(false);
        txtMaDS.setBackground(Color.white);
        ShowdataDauSach();
    }//GEN-LAST:event_btnLamMoiDSActionPerformed

    private void btnLuuDSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuuDSActionPerformed
        // TODO add your handling code here:
        
        
        if(btnThemDS.isEnabled())
        {        
            String data = txtNamXuatBan.getText();
            try {
                int x = Integer.parseInt(data);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập lại Năm Xuất Bản VD: 2022");
            }
            try {
                StringBuffer sb = new StringBuffer();
                if(txtMaDS.getText().equals("")){
                    sb.append("Mã đầu sách không được trống");
                }
                if(sb.length()>0){
                    JOptionPane.showMessageDialog(this, sb);
                }
                try {
                    int i = Integer.parseInt(txtNamXuatBan.getText());
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "Nhập lại năm xuất bản");
                    return;
                }
                DauSach ds = new DauSach();
                int maDM = ((DanhMuc)cbbDanhMuc.getSelectedItem()).getMaDanhMuc();
                ds.setMaSach(txtMaDS.getText());
                ds.setMaDanhMuc(maDM);                
                ds.setTenSach(txtTenDS.getText());
                ds.setTacGia(txtTacGia.getText());
                ds.setNhaXuatBan(txtNhaXuatBan.getText());
                ds.setNamXuatBan(txtNamXuatBan.getText());
                ds.setSoLuong(Integer.parseInt(txtSoLuong.getText()));
                ds.setMoTa(taraMoTa.getText());
                DauSachDAO na = new DauSachDAO();
                na.insert(ds);
                JOptionPane.showMessageDialog(this, "Thêm mới thành công");
                ShowdataDauSach();
                ShowdataTinhTrangSach();
                
            } catch (Exception e) {
                if(e.getMessage().equals("Duplicate entry '"+txtMaDS.getText()+"' for key 'PRIMARY'")){
                    JOptionPane.showMessageDialog(this, "Mã sách đã tồn tại vui lòng nhập lại");
                }
            }
        }else if(btnSuaDS.isEnabled()){
            StringBuffer sb = new StringBuffer();
            String data = txtNamXuatBan.getText();
            try {
                int x = Integer.parseInt(data);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập lại Năm Xuất Bản VD: 2022");
            }
            if(txtMaDS.getText().equals("")){
                sb.append("Mã đầu sách không được trống");
            }
            if(sb.length()>0){
                JOptionPane.showMessageDialog(this, sb);
            }
            try {
                DauSach ds = new DauSach();
                int maDM = ((DanhMuc)cbbDanhMuc.getSelectedItem()).getMaDanhMuc();
                ds.setMaSach(txtMaDS.getText());
                ds.setMaDanhMuc(maDM);                
                ds.setTenSach(txtTenDS.getText());
                ds.setTacGia(txtTacGia.getText());
                ds.setNhaXuatBan(txtNhaXuatBan.getText());
                ds.setNamXuatBan(txtNamXuatBan.getText());
                ds.setSoLuong(Integer.parseInt(txtSoLuong.getText()));
                ds.setMoTa(taraMoTa.getText());
                DauSachDAO na = new DauSachDAO();
                na.update(ds);
                JOptionPane.showMessageDialog(this, "Sửa thành công");
                ShowdataDauSach();
                ShowdataTinhTrangSach();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
        }else if(btnXoaDS.isEnabled()){
            String ml = txtMaDS.getText();
            StringBuilder sb = new StringBuilder();
            if(ml.equals("")){
                JOptionPane.showMessageDialog(this, "Mã đầu sách không được trống");
            }
            else{
                DauSachDAO na = new DauSachDAO();
                boolean kt = na.delete(txtMaDS.getText());
                if(kt==true)
                {
                    JOptionPane.showMessageDialog(this, "Xóa thành công");
                }else{
                    JOptionPane.showMessageDialog(this, "Xóa thất bại");
                }
                ShowdataDauSach();
                ShowdataTinhTrangSach();
            }
        }
        
    }//GEN-LAST:event_btnLuuDSActionPerformed

    private void cbbDanhMucActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbDanhMucActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_cbbDanhMucActionPerformed

    private void tbDauSachMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbDauSachMouseClicked
        // TODO add your handling code here:
        int row = tbDauSach.getSelectedRow();
        if(row >= 0)
        {
            txtMaDS.setText(tbDauSach.getValueAt(row, 0).toString());
            cbbDanhMuc.setSelectedIndex(Integer.valueOf(tbDauSach.getValueAt(row, 1).toString())-1);
            txtTenDS.setText(tbDauSach.getValueAt(row, 2).toString());
            txtTacGia.setText(tbDauSach.getValueAt(row, 3).toString());
            txtNhaXuatBan.setText(tbDauSach.getValueAt(row, 4).toString());
            txtNamXuatBan.setText(tbDauSach.getValueAt(row, 5).toString());
            txtSoLuong.setText(tbDauSach.getValueAt(row, 6).toString());
            taraMoTa.setText(tbDauSach.getValueAt(row, 7).toString());
        }
    }//GEN-LAST:event_tbDauSachMouseClicked

    private void btnHomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHomeMouseClicked
        setColorHome(btnHome);
        this.setVisible(false);
        Run.Home();
    }//GEN-LAST:event_btnHomeMouseClicked

    private void btnHomeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHomeMouseEntered
        setColorHome(btnHome);
    }//GEN-LAST:event_btnHomeMouseEntered

    private void btnHomeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHomeMouseExited
        resetColorHome(btnHome);
    }//GEN-LAST:event_btnHomeMouseExited

    private void txtMaDSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaDSActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaDSActionPerformed

    private void tbTinhTrangSachMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbTinhTrangSachMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tbTinhTrangSachMouseClicked

    private void jTabbedPaneMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTabbedPaneMenuMouseClicked
        // TODO add your handling code here:
        LoadComboBox();
    }//GEN-LAST:event_jTabbedPaneMenuMouseClicked

    private void txtMaDSKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMaDSKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            txtTenDS.requestFocus();
        }
    }//GEN-LAST:event_txtMaDSKeyPressed

    private void txtTenDSKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTenDSKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            txtSoLuong.requestFocus();
        }
    }//GEN-LAST:event_txtTenDSKeyPressed

    private void txtSoLuongKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSoLuongKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            taraMoTa.requestFocus();
        }
    }//GEN-LAST:event_txtSoLuongKeyPressed

    private void taraMoTaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_taraMoTaKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            txtTacGia.requestFocus();
        }
    }//GEN-LAST:event_taraMoTaKeyPressed

    private void txtTacGiaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTacGiaKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            txtNhaXuatBan.requestFocus();
        }
    }//GEN-LAST:event_txtTacGiaKeyPressed

    private void txtNhaXuatBanKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNhaXuatBanKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            txtNamXuatBan.requestFocus();
        }
    }//GEN-LAST:event_txtNhaXuatBanKeyPressed

    private void txtNamXuatBanKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNamXuatBanKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
            btnLuuDS.requestFocus();
        }
    }//GEN-LAST:event_txtNamXuatBanKeyPressed
    
    /**
     * @param args the command line arguments
     */
    
    public void setColorHome(JPanel panel){
        panel.setBackground(new Color(153,255,255));
    }
    
    public void resetColorHome(JPanel panel){
         panel.setBackground(new Color(0,153,153));
    }
    
        private void setFontTable(JTable t){
        Font myFont = new Font("Serif", Font.PLAIN, 16);
        JTableHeader hd1 = t.getTableHeader();
        hd1.setFont(myFont);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel btnHome;
    private javax.swing.JButton btnLamMoi;
    private javax.swing.JButton btnLamMoiDS;
    private javax.swing.JButton btnLuu;
    private javax.swing.JButton btnLuuDS;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnSuaDS;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnThemDS;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JButton btnTimKiemDS;
    private javax.swing.JButton btnXoa;
    private javax.swing.JButton btnXoaDS;
    private javax.swing.JComboBox<String> cbbDanhMuc;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPaneMenu;
    private javax.swing.JLabel lblQTV;
    private javax.swing.JLabel lblTime;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTextArea taraMoTa;
    private javax.swing.JTable tbDanhMuc;
    private javax.swing.JTable tbDauSach;
    private javax.swing.JTable tbTinhTrangSach;
    private javax.swing.JTextField txtMaDS;
    private javax.swing.JTextField txtMaDm;
    private javax.swing.JTextField txtNamXuatBan;
    private javax.swing.JTextField txtNhaXuatBan;
    private javax.swing.JTextField txtSoLuong;
    private javax.swing.JTextField txtTacGia;
    private javax.swing.JTextField txtTenDM;
    private javax.swing.JTextField txtTenDS;
    // End of variables declaration//GEN-END:variables
}
