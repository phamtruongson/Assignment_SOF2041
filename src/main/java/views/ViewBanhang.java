package views;

import domainmodels.ChiTietSP;
import domainmodels.HoaDon;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import services.ChiTietSPService;
import services.HoaDonChiTietService;
import services.HoaDonService;
import services.impl.ChiTietSPServiceImpl;
import services.impl.HoaDonServiceImpl;
import viewmodels.SaleViewHoaDonChiTietResponse;
import viewmodels.SaleViewSanPhamResponse;
import services.impl.HoaDonChiTietServiceImpl;
import utils.HibernateUtil;
import viewmodels.SaleViewHoaDonResponse;

/**
 *
 * @author sonpt_ph19600
 */
public class ViewBanhang extends javax.swing.JFrame {

    private final DefaultTableModel modelSanPham;
    private final DefaultTableModel modelGioHang;
    private final DefaultTableModel modelHoaDon;
    private final ChiTietSPService chiTietSanPhamService;
    private final HoaDonService hoaDonService;
    private final HoaDonChiTietService hoaDonChiTietService;
    private List<SaleViewSanPhamResponse> listSanPhamResponse;
    private Map<UUID, SaleViewHoaDonChiTietResponse> mapGioHang;
    private List<SaleViewHoaDonResponse> listHoaDonResponse;

    public ViewBanhang() {
        initComponents();
        setLocationRelativeTo(null);
        modelSanPham = (DefaultTableModel) tblSanPham.getModel();
        modelGioHang = (DefaultTableModel) tblGioHang.getModel();
        modelHoaDon = (DefaultTableModel) tblHoaDon.getModel();
        chiTietSanPhamService = new ChiTietSPServiceImpl();
        hoaDonService = new HoaDonServiceImpl();
        hoaDonChiTietService = new HoaDonChiTietServiceImpl();
        mapGioHang = new HashMap<>();
        listHoaDonResponse = hoaDonService.getAll();
        loadTableHoaDon(listHoaDonResponse);
        loadTableChiTietSP();
    }

    private void loadTableChiTietSP() {
        modelSanPham.setRowCount(0);
        int index = 1;
        listSanPhamResponse = chiTietSanPhamService.findAllByName(txtTimKiem.getText());
        for (SaleViewSanPhamResponse sp : listSanPhamResponse) {
            modelSanPham.addRow(sp.toDataRow(index));
            index++;
        }
    }

    private void loadTableHoaDon(List<SaleViewHoaDonResponse> list) {
        modelHoaDon.setRowCount(0);
        int index = 1;
        for (SaleViewHoaDonResponse hd : list) {
            modelHoaDon.addRow(hd.toDataRow(index));
            index++;
        }
    }

    private void loadTableGioHang() {
        modelGioHang.setRowCount(0);
        int index = 1;
        for (Map.Entry<UUID, SaleViewHoaDonChiTietResponse> entry : mapGioHang.entrySet()) {
            SaleViewHoaDonChiTietResponse value = entry.getValue();
            modelGioHang.addRow(value.toDataRow(index));
            index++;
        }

    }

    //H??m t??nh to??n t???ng ti???n h??a ????n
    private void tinhTongTien() {
        int size = tblGioHang.getRowCount();
        BigDecimal tong = new BigDecimal(0);
        for (int i = 0; i < size; i++) {
            BigDecimal thanhTien = new BigDecimal(tblGioHang.getValueAt(i, 5) + "");
            tong = tong.add(thanhTien);
        }
        txtTongTien.setText(tong.toString());
    }

    //H??m load d??? li???u form h??a ????n
    private void loadFormHoaDon(int row) {
        txtMaHD.setText(tblHoaDon.getValueAt(row, 1) + "");
        txtNgayTao.setText(tblHoaDon.getValueAt(row, 2) + "");
        txtTenNV.setText(tblHoaDon.getValueAt(row, 3) + "");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblHoaDon = new javax.swing.JTable();
        btnTaoHoaDon = new javax.swing.JButton();
        rdoChoThanhToan = new javax.swing.JRadioButton();
        rdoTatCa = new javax.swing.JRadioButton();
        rdoDaHuy = new javax.swing.JRadioButton();
        rdoDaThanhToan = new javax.swing.JRadioButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtMaHD = new javax.swing.JTextField();
        txtNgayTao = new javax.swing.JTextField();
        txtTenNV = new javax.swing.JTextField();
        txtTongTien = new javax.swing.JTextField();
        txtTienKhachDua = new javax.swing.JTextField();
        txtTienThua = new javax.swing.JTextField();
        btnThanhToan = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblGioHang = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblSanPham = new javax.swing.JTable();
        txtTimKiem = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("FpolyShop");

        tblHoaDon.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tblHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "M?? H??", "Ng??y t???o", "T??n NV", "T??nh Tr???ng"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHoaDonMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblHoaDon);
        if (tblHoaDon.getColumnModel().getColumnCount() > 0) {
            tblHoaDon.getColumnModel().getColumn(0).setPreferredWidth(15);
        }

        btnTaoHoaDon.setBackground(new java.awt.Color(1, 181, 204));
        btnTaoHoaDon.setFont(new java.awt.Font("Nunito", 1, 14)); // NOI18N
        btnTaoHoaDon.setForeground(new java.awt.Color(255, 255, 255));
        btnTaoHoaDon.setText("T???o h??a ????n");
        btnTaoHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaoHoaDonActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdoChoThanhToan);
        rdoChoThanhToan.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rdoChoThanhToan.setText("Ch??? thanh to??n");
        rdoChoThanhToan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rdoChoThanhToanMouseClicked(evt);
            }
        });

        buttonGroup1.add(rdoTatCa);
        rdoTatCa.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rdoTatCa.setSelected(true);
        rdoTatCa.setText("T???t c???");
        rdoTatCa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rdoTatCaMouseClicked(evt);
            }
        });

        buttonGroup1.add(rdoDaHuy);
        rdoDaHuy.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rdoDaHuy.setText("???? h???y");
        rdoDaHuy.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rdoDaHuyMouseClicked(evt);
            }
        });

        buttonGroup1.add(rdoDaThanhToan);
        rdoDaThanhToan.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rdoDaThanhToan.setText("???? thanh to??n");
        rdoDaThanhToan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rdoDaThanhToanMouseClicked(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "H??a ????n", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N
        jPanel1.setToolTipText("");
        jPanel1.setFocusable(false);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("M?? H??");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Ng??y t???o");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("T??n NV");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("T???ng ti???n");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Ti???n kh??ch ????a");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Ti???n th???a");

        txtMaHD.setEditable(false);
        txtMaHD.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        txtMaHD.setForeground(new java.awt.Color(255, 102, 0));

        txtNgayTao.setEditable(false);
        txtNgayTao.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtTenNV.setEditable(false);
        txtTenNV.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtTongTien.setEditable(false);
        txtTongTien.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txtTongTien.setForeground(new java.awt.Color(255, 0, 0));

        txtTienKhachDua.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtTienKhachDua.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtTienKhachDuaCaretUpdate(evt);
            }
        });

        txtTienThua.setEditable(false);
        txtTienThua.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        btnThanhToan.setBackground(new java.awt.Color(255, 51, 51));
        btnThanhToan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnThanhToan.setForeground(new java.awt.Color(255, 255, 255));
        btnThanhToan.setText("Thanh to??n");
        btnThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThanhToanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTienKhachDua, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTenNV, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNgayTao, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTienThua, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(125, 125, 125)
                .addComponent(btnThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNgayTao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtTenNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtTienKhachDua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtTienThua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(btnThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Gi??? h??ng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N

        jScrollPane3.setForeground(new java.awt.Color(255, 102, 102));

        tblGioHang.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tblGioHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "M?? SP", "T??n SP", "S??? l?????ng", "????n gi??", "Th??nh ti???n"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblGioHang.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblGioHang.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblGioHang.getTableHeader().setReorderingAllowed(false);
        tblGioHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblGioHangMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblGioHang);
        if (tblGioHang.getColumnModel().getColumnCount() > 0) {
            tblGioHang.getColumnModel().getColumn(0).setPreferredWidth(15);
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 664, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "S???n ph???m", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N

        tblSanPham.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tblSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "M?? SP", "T??n SP", "N??m BH", "M?? t???", "SL SP t???n", "Gi?? nh???p", "Gi?? b??n"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblSanPham.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblSanPham.getTableHeader().setReorderingAllowed(false);
        tblSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSanPhamMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblSanPham);
        if (tblSanPham.getColumnModel().getColumnCount() > 0) {
            tblSanPham.getColumnModel().getColumn(0).setPreferredWidth(15);
        }

        txtTimKiem.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtTimKiem.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtTimKiemCaretUpdate(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 781, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnTaoHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(rdoChoThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(rdoTatCa, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(rdoDaHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(rdoDaThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdoChoThanhToan)
                    .addComponent(rdoTatCa)
                    .addComponent(rdoDaHuy)
                    .addComponent(rdoDaThanhToan))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnTaoHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel1.getAccessibleContext().setAccessibleName("");
        jPanel2.getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtTimKiemCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtTimKiemCaretUpdate
        try {
            loadTableChiTietSP();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_txtTimKiemCaretUpdate

    private void tblSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSanPhamMouseClicked
        //Table s???n ph???m Click
        int rowHoaDon = tblHoaDon.getSelectedRow();
        if (rowHoaDon == -1 || txtMaHD.getText().equals("")) {
            JOptionPane.showMessageDialog(this,
                    "M???i t???o h??a ????n ho???c ch???n m???t h??a ????n ????? th??m s???n ph???m");
            return;
        }
        SaleViewHoaDonResponse hoaDon = listHoaDonResponse.get(rowHoaDon);
        if (hoaDon.getTinhTrang() == 1) {
            JOptionPane.showMessageDialog(this, "H??a ????n n??y ???? ???????c thanh to??n");
            return;
        }
        if (hoaDon.getTinhTrang() == -1) {
            JOptionPane.showMessageDialog(this, "H??a ????n n??y ???? b??? h???y");
            return;
        }
        int row = tblSanPham.getSelectedRow();
        tblSanPham.clearSelection();
        SaleViewSanPhamResponse sanPham = listSanPhamResponse.get(row);
        SaleViewHoaDonChiTietResponse hoaDonChiTiet = mapGioHang.get(sanPham.getId());
        String inputSoLuongStr = "";
        int loaiSuaSL = -1;
        if (hoaDonChiTiet != null) {
            loaiSuaSL = JOptionPane.showOptionDialog(this, "S???n ph???m ???? t???n t???i trong gi??? h??ng. B???n mu???n?",
                    "Confirm", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE,
                    null, new Object[]{"Th??m SL", "Gi???m SL", "Cancel"}, 0);
            if (loaiSuaSL == -1 || loaiSuaSL == 2) {
                return;
            }
        }

        inputSoLuongStr = JOptionPane.showInputDialog(this, "Nh???p s??? l?????ng", "0");
        if (inputSoLuongStr == null) {
            return;
        }
        int inputSoLuong = -1;
        if (inputSoLuongStr.trim().equals("")) {
            JOptionPane.showMessageDialog(this, "S??? l?????ng kh??ng ???????c ????? tr???ng");
            return;
        }
        try {
            inputSoLuong = Integer.parseInt(inputSoLuongStr.trim());
            if (inputSoLuong <= 0) {
                JOptionPane.showMessageDialog(this, "S??? l?????ng ph???i l???n h??n 0");
                return;
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "S??? l?????ng ph???i l?? s???");
            return;
        }

        if (hoaDonChiTiet == null) {
            if (inputSoLuong > sanPham.getSoLuongSPTon()) {
                JOptionPane.showMessageDialog(this, "V?????t qu?? s??? l?????ng t???n");
                return;
            }
            UUID idHoaDon = listHoaDonResponse.get(tblHoaDon.getSelectedRow()).getId();
            hoaDonChiTiet = new SaleViewHoaDonChiTietResponse();
            hoaDonChiTiet.setIdHoaDon(idHoaDon);
            hoaDonChiTiet.setIdChiTietSP(sanPham.getId());
            hoaDonChiTiet.setMaSP(sanPham.getMaSP());
            hoaDonChiTiet.setTenSP(sanPham.getTenSP());
            hoaDonChiTiet.setSoLuongSP(inputSoLuong);
            hoaDonChiTiet.setDonGia(sanPham.getGiaBan());
            mapGioHang.put(sanPham.getId(), hoaDonChiTiet);
        } else {
            int tongSoLuong = 0;
            if (loaiSuaSL == 0) {
                tongSoLuong = hoaDonChiTiet.getSoLuongSP() + inputSoLuong;
            } else if (loaiSuaSL == 1) {
                tongSoLuong = hoaDonChiTiet.getSoLuongSP() - inputSoLuong;
            }
            if (tongSoLuong == 0) {
                mapGioHang.remove(hoaDonChiTiet.getIdChiTietSP());
                loadTableGioHang();
                tinhTongTien();
            }
            if (tongSoLuong > sanPham.getSoLuongSPTon()) {
                JOptionPane.showMessageDialog(this, "V?????t qu?? s??? l?????ng t???n");
                return;
            }
            hoaDonChiTiet.setSoLuongSP(tongSoLuong);
            mapGioHang.replace(hoaDonChiTiet.getIdChiTietSP(), hoaDonChiTiet);
        }
        loadTableGioHang();
        tinhTongTien();
    }//GEN-LAST:event_tblSanPhamMouseClicked

    private void tblGioHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblGioHangMouseClicked
        //Table gi??? h??ng Click

    }//GEN-LAST:event_tblGioHangMouseClicked

    private void btnTaoHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaoHoaDonActionPerformed
        //BTN t???o h??a ????n
        HoaDon hoaDonMoi = hoaDonService.createBill();
        if (hoaDonMoi == null) {
            JOptionPane.showMessageDialog(this, "L???i! T???o h??a ????n th???t b???i");
        } else {
            JOptionPane.showMessageDialog(this, "T???o h??a ????n th??nh c??ng");
        }
        mapGioHang.clear();
        loadTableGioHang();
        listHoaDonResponse = hoaDonService.getAll();
        loadTableHoaDon(listHoaDonResponse);
        int size = listHoaDonResponse.size();
        for (int i = 0; i < size; i++) {
            SaleViewHoaDonResponse hoaDon = listHoaDonResponse.get(i);
            if (hoaDon.getId().compareTo(hoaDonMoi.getId()) == 0) {
                tblHoaDon.addRowSelectionInterval(i, i);
                loadFormHoaDon(i);
            }
        }
    }//GEN-LAST:event_btnTaoHoaDonActionPerformed

    private void btnThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanhToanActionPerformed
        //BTN Thanh To??n
        int rowHoaDon = tblHoaDon.getSelectedRow();
        if (rowHoaDon == -1) {
            JOptionPane.showMessageDialog(this, "M???i ch???n h??a ????n ????? thanh to??n");
            return;
        }

        SaleViewHoaDonResponse hoaDon = listHoaDonResponse.get(rowHoaDon);
        if (hoaDon.getTinhTrang() == 1) {
            JOptionPane.showMessageDialog(this, "H??a ????n ???? ???????c thanh to??n");
            return;
        }
        if (hoaDon.getTinhTrang() == -1) {
            JOptionPane.showMessageDialog(this, "H??a ????n ???? b??? h???y");
            return;
        }
        if (modelGioHang.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "M???i th??m s???n ph???m ????? thanh to??n");
            return;
        }
        String tienKhacDuaStr = txtTienKhachDua.getText().trim();
        if (tienKhacDuaStr.equals("")) {
            JOptionPane.showMessageDialog(this, "M???i nh???p ti???n kh??ch ????a");
            return;
        }
        BigDecimal tienKhachDua = new BigDecimal(tienKhacDuaStr);
        BigDecimal tongTien = new BigDecimal(txtTongTien.getText());
        if (tienKhachDua.compareTo(tongTien) == -1) {
            JOptionPane.showMessageDialog(this, "S??? ti???n kh??ch ????a kh??ng ?????");
            return;
        }
        String result = hoaDonChiTietService.pay(new ArrayList<>(mapGioHang.values()));
        loadTableChiTietSP();
        mapGioHang.clear();
        loadTableGioHang();
        listHoaDonResponse = hoaDonService.getAll();
        loadTableHoaDon(listHoaDonResponse);
        txtMaHD.setText("");
        txtTenNV.setText("");
        txtNgayTao.setText("");
        txtTongTien.setText("");
        txtTienKhachDua.setText("");
        txtTienThua.setText("");
        tblHoaDon.clearSelection();
        JOptionPane.showMessageDialog(this, result);
    }//GEN-LAST:event_btnThanhToanActionPerformed

    private void tblHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHoaDonMouseClicked
        //Table H??a ????n Click
        int row = tblHoaDon.getSelectedRow();
        loadFormHoaDon(row);
        mapGioHang.clear();
        List<SaleViewHoaDonChiTietResponse> list = hoaDonChiTietService.
                search(listHoaDonResponse.get(row).getId());
        for (SaleViewHoaDonChiTietResponse hdct : list) {
            mapGioHang.put(hdct.getIdChiTietSP(), hdct);
        }
        loadTableGioHang();
        tinhTongTien();
    }//GEN-LAST:event_tblHoaDonMouseClicked

    private void rdoDaHuyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdoDaHuyMouseClicked
        //Radio L???c ???? h???y
        listHoaDonResponse = hoaDonService.search(-1);
        loadTableHoaDon(listHoaDonResponse);
    }//GEN-LAST:event_rdoDaHuyMouseClicked

    private void rdoDaThanhToanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdoDaThanhToanMouseClicked
        //Radio l???c ???? thanh to??n
        listHoaDonResponse = hoaDonService.search(1);
        loadTableHoaDon(listHoaDonResponse);
    }//GEN-LAST:event_rdoDaThanhToanMouseClicked

    private void rdoTatCaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdoTatCaMouseClicked
        //Radio l???c t???t c???
        listHoaDonResponse = hoaDonService.getAll();
        loadTableHoaDon(listHoaDonResponse);
    }//GEN-LAST:event_rdoTatCaMouseClicked

    private void rdoChoThanhToanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdoChoThanhToanMouseClicked
        //Radio l???c ch??? thanh to??n
        listHoaDonResponse = hoaDonService.search(0);
        loadTableHoaDon(listHoaDonResponse);
    }//GEN-LAST:event_rdoChoThanhToanMouseClicked

    private void txtTienKhachDuaCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtTienKhachDuaCaretUpdate
        //txtTienKhachDua type
        int rowHoaDon = tblHoaDon.getSelectedRow();
        if (txtMaHD.getText().equals("") || rowHoaDon == -1) {
            return;
        }
        if (listHoaDonResponse.get(rowHoaDon).getTinhTrang() != 0) {
            return;
        }
        String tienKhachDuaStr = txtTienKhachDua.getText();
        if (tienKhachDuaStr.equals("")) {
            txtTienThua.setText("");
            return;
        }
        BigDecimal tienKhachDua = null;
        try {
            tienKhachDua = new BigDecimal(tienKhachDuaStr);
            if (tienKhachDua.compareTo(BigDecimal.ZERO) == -1) {
                JOptionPane.showMessageDialog(this, "Ti???n kh??ch ????a ph???i l???n h??n 0");
                return;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Ti???n kh??ch ????a l?? s???");
            e.printStackTrace();
            return;
        }
        String tongTienStr = txtTongTien.getText();
        if (tongTienStr.equals("") || tongTienStr.equals("0")) {
            return;
        }
        BigDecimal tongTien = new BigDecimal(tongTienStr);
        BigDecimal tienThua = tienKhachDua.subtract(tongTien);
        if (tienThua.compareTo(BigDecimal.ZERO) == 1) {
            DecimalFormat format = new DecimalFormat("#,###");
            txtTienThua.setText(format.format(tienThua));
        }       
    }//GEN-LAST:event_txtTienKhachDuaCaretUpdate

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ViewBanhang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewBanhang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewBanhang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewBanhang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewBanhang().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnTaoHoaDon;
    private javax.swing.JButton btnThanhToan;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JRadioButton rdoChoThanhToan;
    private javax.swing.JRadioButton rdoDaHuy;
    private javax.swing.JRadioButton rdoDaThanhToan;
    private javax.swing.JRadioButton rdoTatCa;
    private javax.swing.JTable tblGioHang;
    private javax.swing.JTable tblHoaDon;
    private javax.swing.JTable tblSanPham;
    private javax.swing.JTextField txtMaHD;
    private javax.swing.JTextField txtNgayTao;
    private javax.swing.JTextField txtTenNV;
    private javax.swing.JTextField txtTienKhachDua;
    private javax.swing.JTextField txtTienThua;
    private javax.swing.JTextField txtTimKiem;
    private javax.swing.JTextField txtTongTien;
    // End of variables declaration//GEN-END:variables

}
