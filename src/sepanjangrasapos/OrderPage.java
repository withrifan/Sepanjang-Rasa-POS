package sepanjangrasapos;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import java.sql.*;
import javax.swing.table.DefaultTableModel;

public class OrderPage extends javax.swing.JFrame {

    public OrderPage() {
        initComponents();
        setTime();
        setImg();
        setIconBtn();
        setExtendedState(Manage.MAXIMIZED_BOTH);
        loadRiwayatPesanan(); // Muat data ke tabel 
    }

    public void setTime() {
        // Menggunakan MethodClass untuk memperbarui waktu dan tanggal secara real-time
        MethodClass.setTime(Waktu, Tanggal);
    }

    public void setImg() {
        MethodClass.setIconLabel(LogoTop, "/components/LogoSepanjangRasa2.png");
    }

    private void setIconBtn() {
        // Menggunakan MethodClass untuk mengatur ikon pada tombol
        MethodClass.setIconBtn(HomePageBtn, "/components/logoHome2.png");
        MethodClass.setIconBtn(OrderPageBtn, "/components/logoOrder1.png");
        MethodClass.setIconBtn(TablePageBtn, "/components/logoTable2.png");
        MethodClass.setIconBtn(ReportsPageBtn, "/components/logoReport2.png");
        MethodClass.setIconBtn(ManagePageBtn, "/components/logoStaff2.png");
    }

    private void loadRiwayatPesanan() {
        DefaultTableModel model = (DefaultTableModel) jTableRiwayatPesanan.getModel();
        model.setRowCount(0); // Reset data tabel

        try (Connection conn = DBConnection.getConnection()) {
            String query = "SELECT t.id_transaksi, t.tgl_transaksi, GROUP_CONCAT(t.id_produk SEPARATOR ', ') AS produk, SUM(t.qty) AS qty, t.id_meja, t.total_harga, t.tunai, t.kembalian, h.status "
                    + "FROM tb_transaksi t "
                    + "JOIN tb_history h ON t.id_transaksi = h.id_transaksi "
                    + "GROUP BY t.id_transaksi";
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Object[] row = new Object[9];
                row[0] = rs.getString("id_transaksi"); // ID Pesanan
                row[1] = rs.getTimestamp("tgl_transaksi"); // Tanggal
                row[2] = rs.getString("produk"); // Produk
                row[3] = rs.getInt("qty"); // Qty
                row[4] = rs.getString("id_meja"); // Meja
                row[5] = rs.getInt("total_harga"); // Total
                row[6] = rs.getInt("tunai"); // Tunai
                row[7] = rs.getInt("kembalian"); // Kembalian
                row[8] = rs.getInt("status") == 1; // Status (Boolean untuk checkbox)
                model.addRow(row);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Gagal memuat riwayat pesanan: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgOrderPage = new javax.swing.JPanel();
        panelTopOrderPage = new javax.swing.JPanel();
        LogoTop = new javax.swing.JLabel();
        Waktu = new javax.swing.JLabel();
        Tanggal = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextAreaDetailPesanan = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        outSubtotal = new javax.swing.JTextField();
        outPajak = new javax.swing.JTextField();
        outTotal = new javax.swing.JTextField();
        outTunai = new javax.swing.JTextField();
        outKembalian = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        btnStatusSelesai = new custom.button();
        panel1 = new custom.panel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableRiwayatPesanan = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        HomePageBtn = new custom.button();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        OrderPageBtn = new custom.button();
        TablePageBtn = new custom.button();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        ReportsPageBtn = new custom.button();
        ManagePageBtn = new custom.button();
        jLabel13 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Order - Sepanjang Rasa");
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/components/iconSR.jpg")).getImage());
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        bgOrderPage.setBackground(new java.awt.Color(255, 242, 232));

        panelTopOrderPage.setBackground(new java.awt.Color(255, 255, 255));
        panelTopOrderPage.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(159, 159, 158)));
        panelTopOrderPage.setPreferredSize(new java.awt.Dimension(1536, 80));

        LogoTop.setPreferredSize(new java.awt.Dimension(135, 80));

        Waktu.setFont(new java.awt.Font("Poppins Medium", 0, 15)); // NOI18N
        Waktu.setForeground(new java.awt.Color(159, 159, 158));
        Waktu.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        Tanggal.setFont(new java.awt.Font("Poppins Medium", 0, 13)); // NOI18N
        Tanggal.setForeground(new java.awt.Color(159, 159, 158));
        Tanggal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout panelTopOrderPageLayout = new javax.swing.GroupLayout(panelTopOrderPage);
        panelTopOrderPage.setLayout(panelTopOrderPageLayout);
        panelTopOrderPageLayout.setHorizontalGroup(
            panelTopOrderPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTopOrderPageLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(LogoTop, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelTopOrderPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Tanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Waktu, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
        );
        panelTopOrderPageLayout.setVerticalGroup(
            panelTopOrderPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTopOrderPageLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Waktu, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(Tanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
            .addComponent(LogoTop, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(159, 159, 158)));

        jLabel2.setFont(new java.awt.Font("Poppins Medium", 1, 30)); // NOI18N
        jLabel2.setText("Detail Pesanan");

        jTextAreaDetailPesanan.setBackground(new java.awt.Color(255, 255, 255));
        jTextAreaDetailPesanan.setColumns(20);
        jTextAreaDetailPesanan.setFont(new java.awt.Font("Consolas", 0, 14)); // NOI18N
        jTextAreaDetailPesanan.setRows(5);
        jTextAreaDetailPesanan.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jTextAreaDetailPesanan.setEnabled(false);
        jTextAreaDetailPesanan.setSelectedTextColor(new java.awt.Color(0, 0, 0));
        jScrollPane2.setViewportView(jTextAreaDetailPesanan);

        jLabel4.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel4.setText("Pajak 12%");
        jLabel4.setPreferredSize(new java.awt.Dimension(54, 22));

        jLabel5.setFont(new java.awt.Font("Poppins SemiBold", 0, 12)); // NOI18N
        jLabel5.setText("Total");

        jLabel6.setFont(new java.awt.Font("Poppins SemiBold", 0, 12)); // NOI18N
        jLabel6.setText("Tunai");

        jLabel7.setFont(new java.awt.Font("Poppins SemiBold", 0, 12)); // NOI18N
        jLabel7.setText("Kembalian");

        outSubtotal.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        outSubtotal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        outSubtotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                outSubtotalActionPerformed(evt);
            }
        });

        outPajak.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        outPajak.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        outTotal.setFont(new java.awt.Font("Poppins SemiBold", 0, 12)); // NOI18N
        outTotal.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        outTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                outTotalActionPerformed(evt);
            }
        });

        outTunai.setFont(new java.awt.Font("Poppins SemiBold", 0, 12)); // NOI18N
        outTunai.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        outKembalian.setFont(new java.awt.Font("Poppins SemiBold", 0, 12)); // NOI18N
        outKembalian.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jLabel12.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel12.setText("Subtotal");
        jLabel12.setPreferredSize(new java.awt.Dimension(45, 22));

        btnStatusSelesai.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnStatusSelesai.setForeground(new java.awt.Color(255, 255, 255));
        btnStatusSelesai.setText("Selesai");
        btnStatusSelesai.setColor(new java.awt.Color(9, 170, 41));
        btnStatusSelesai.setColorBorder(new java.awt.Color(9, 170, 41));
        btnStatusSelesai.setColorClick(new java.awt.Color(0, 102, 0));
        btnStatusSelesai.setColorOver(new java.awt.Color(51, 255, 51));
        btnStatusSelesai.setFont(new java.awt.Font("Poppins Medium", 1, 14)); // NOI18N
        btnStatusSelesai.setPreferredSize(new java.awt.Dimension(95, 30));
        btnStatusSelesai.setRadius(10);
        btnStatusSelesai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStatusSelesaiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(outTunai, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(outTotal, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(outPajak, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(outSubtotal, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(outKembalian, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnStatusSelesai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addComponent(jScrollPane2)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnStatusSelesai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 467, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(outSubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(outPajak, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(outTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(outTunai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(outKembalian, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        panel1.setBackground(new java.awt.Color(255, 255, 255));
        panel1.setRoundBottomLeft(12);
        panel1.setRoundBottomRight(12);
        panel1.setRoundTopLeft(12);
        panel1.setRoundTopRight(12);

        jTableRiwayatPesanan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Id Transaksi", "Tanggal", "Produk", "Qty", "Meja", "Total", "Tunai", "Kembalian", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableRiwayatPesanan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableRiwayatPesananMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableRiwayatPesanan);

        jLabel1.setFont(new java.awt.Font("Poppins Black", 1, 28)); // NOI18N
        jLabel1.setText("Riwayat Pesanan");

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(324, 324, 324)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 993, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 593, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        HomePageBtn.setColorBorder(new java.awt.Color(255, 255, 255));
        HomePageBtn.setColorClick(new java.awt.Color(204, 204, 204));
        HomePageBtn.setColorOver(new java.awt.Color(245, 245, 245));
        HomePageBtn.setIconTextGap(0);
        HomePageBtn.setPreferredSize(new java.awt.Dimension(35, 35));
        HomePageBtn.setRadius(8);
        HomePageBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HomePageBtnActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Poppins SemiBold", 0, 11)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Home");

        jLabel9.setFont(new java.awt.Font("Poppins SemiBold", 0, 11)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(252, 128, 25));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Order");

        OrderPageBtn.setColorBorder(new java.awt.Color(255, 255, 255));
        OrderPageBtn.setColorClick(new java.awt.Color(204, 204, 204));
        OrderPageBtn.setColorOver(new java.awt.Color(245, 245, 245));
        OrderPageBtn.setIconTextGap(0);
        OrderPageBtn.setPreferredSize(new java.awt.Dimension(35, 35));
        OrderPageBtn.setRadius(8);

        TablePageBtn.setColorBorder(new java.awt.Color(255, 255, 255));
        TablePageBtn.setColorClick(new java.awt.Color(204, 204, 204));
        TablePageBtn.setColorOver(new java.awt.Color(245, 245, 245));
        TablePageBtn.setIconTextGap(8);
        TablePageBtn.setPreferredSize(new java.awt.Dimension(35, 35));
        TablePageBtn.setRadius(8);
        TablePageBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TablePageBtnActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Poppins SemiBold", 0, 11)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Table");

        jLabel11.setFont(new java.awt.Font("Poppins SemiBold", 0, 11)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Report");

        ReportsPageBtn.setColorBorder(new java.awt.Color(255, 255, 255));
        ReportsPageBtn.setColorClick(new java.awt.Color(204, 204, 204));
        ReportsPageBtn.setColorOver(new java.awt.Color(245, 245, 245));
        ReportsPageBtn.setIconTextGap(8);
        ReportsPageBtn.setPreferredSize(new java.awt.Dimension(35, 35));
        ReportsPageBtn.setRadius(8);
        ReportsPageBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReportsPageBtnActionPerformed(evt);
            }
        });

        ManagePageBtn.setColorBorder(new java.awt.Color(255, 255, 255));
        ManagePageBtn.setColorClick(new java.awt.Color(204, 204, 204));
        ManagePageBtn.setColorOver(new java.awt.Color(245, 245, 245));
        ManagePageBtn.setIconTextGap(8);
        ManagePageBtn.setPreferredSize(new java.awt.Dimension(35, 35));
        ManagePageBtn.setRadius(8);
        ManagePageBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ManagePageBtnActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Poppins SemiBold", 0, 11)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Staff");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(HomePageBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(15, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(OrderPageBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TablePageBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ReportsPageBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ManagePageBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(HomePageBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel8)
                .addGap(30, 30, 30)
                .addComponent(OrderPageBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel9)
                .addGap(30, 30, 30)
                .addComponent(TablePageBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel10)
                .addGap(30, 30, 30)
                .addComponent(ReportsPageBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel11)
                .addGap(30, 30, 30)
                .addComponent(ManagePageBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel13)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout bgOrderPageLayout = new javax.swing.GroupLayout(bgOrderPage);
        bgOrderPage.setLayout(bgOrderPageLayout);
        bgOrderPageLayout.setHorizontalGroup(
            bgOrderPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgOrderPageLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(bgOrderPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelTopOrderPage, javax.swing.GroupLayout.DEFAULT_SIZE, 1535, Short.MAX_VALUE)
                    .addGroup(bgOrderPageLayout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        bgOrderPageLayout.setVerticalGroup(
            bgOrderPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(bgOrderPageLayout.createSequentialGroup()
                .addComponent(panelTopOrderPage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(bgOrderPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bgOrderPageLayout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(bgOrderPageLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bgOrderPage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(bgOrderPage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void outSubtotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_outSubtotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_outSubtotalActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        setExtendedState(OrderPage.MAXIMIZED_BOTH);
    }//GEN-LAST:event_formComponentShown

    private void ReportsPageBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReportsPageBtnActionPerformed
        new Reports().setVisible(true);
        dispose();
    }//GEN-LAST:event_ReportsPageBtnActionPerformed

    private void TablePageBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TablePageBtnActionPerformed
        new TablePage().setVisible(true);
        dispose();
    }//GEN-LAST:event_TablePageBtnActionPerformed

    private void HomePageBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HomePageBtnActionPerformed
        new HomePage().setVisible(true);
        dispose();
    }//GEN-LAST:event_HomePageBtnActionPerformed

    private void outTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_outTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_outTotalActionPerformed


    private void jTableRiwayatPesananMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableRiwayatPesananMouseClicked
        int selectedRow = jTableRiwayatPesanan.getSelectedRow();
        if (selectedRow != -1) {
            String idTransaksi = jTableRiwayatPesanan.getValueAt(selectedRow, 0).toString();

            try (Connection conn = DBConnection.getConnection()) {
                String query = "SELECT t.id_transaksi, t.tgl_transaksi, t.id_staff, s.nama, "
                        + "p.nama AS nama_produk, t.qty, t.id_meja, t.nama_pel, "
                        + "t.subtotal, t.ppn, t.total_harga, t.tunai, t.kembalian, t.status "
                        + "FROM tb_transaksi t "
                        + "JOIN tb_produk p ON t.id_produk = p.id_produk "
                        + "JOIN tb_staff s ON t.id_staff = s.id_staff "
                        + "WHERE t.id_transaksi = ?";
                PreparedStatement stmt = conn.prepareStatement(query);
                stmt.setString(1, idTransaksi);
                ResultSet rs = stmt.executeQuery();

                StringBuilder detailProduk = new StringBuilder();
                String tglTransaksi = "";
                String idMeja = "";
                String namaPelanggan = "";
                String namaStaff = "";
                int subtotal = 0;
                int ppn = 0;
                int totalHarga = 0;
                int tunai = 0;
                int kembalian = 0;
                int status = 0;
                int nomorUrut = 1;

                while (rs.next()) {
                    tglTransaksi = rs.getString("tgl_transaksi");
                    idMeja = rs.getString("id_meja");
                    namaPelanggan = rs.getString("nama_pel");
                    namaStaff = rs.getString("nama");
                    subtotal = rs.getInt("subtotal");
                    ppn = rs.getInt("ppn");
                    totalHarga = rs.getInt("total_harga");
                    tunai = rs.getInt("tunai");
                    kembalian = rs.getInt("kembalian");
                    status = rs.getInt("status");

                    String namaProduk = rs.getString("nama_produk");
                    int qty = rs.getInt("qty");
                    detailProduk.append(String.format("%d. %-25s %4d\n", nomorUrut++, namaProduk, qty));
                }

                String statusText = (status == 1) ? "Selesai" : "Proses";
                String detailPesanan = String.format(
                        "***********************************\n"
                        + "ID     : %s\nTanggal: %s\nStaff  : %s\n"
                        + "***********************************\n"
                        + "Produk                         Qty\n%s"
                        + "***********************************\n"
                        + "Nomor Meja: %s\nPelanggan : %s\nStatus    : %s\n"
                        + "***********************************",
                        idTransaksi, tglTransaksi, namaStaff, detailProduk.toString(), idMeja, namaPelanggan, statusText
                );

                jTextAreaDetailPesanan.setText(detailPesanan);

                outSubtotal.setText(String.format("Rp%,d", subtotal));
                outPajak.setText(String.format("Rp%,d", ppn));
                outTotal.setText(String.format("Rp%,d", totalHarga));
                outTunai.setText(String.format("Rp%,d", tunai));
                outKembalian.setText(String.format("Rp%,d", kembalian));

                if (status == 1) {
                    jTableRiwayatPesanan.setValueAt(true, selectedRow, 8);
                } else {
                    jTableRiwayatPesanan.setValueAt(false, selectedRow, 8);
                }

            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
            }
        }

    }//GEN-LAST:event_jTableRiwayatPesananMouseClicked

    private void btnStatusSelesaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStatusSelesaiActionPerformed
        int selectedRow = jTableRiwayatPesanan.getSelectedRow();
        if (selectedRow != -1) {
            // Ambil id_transaksi dari baris yang dipilih
            String idTransaksi = jTableRiwayatPesanan.getValueAt(selectedRow, 0).toString();

            // Update status transaksi menjadi "selesai" (1)
            try (Connection conn = DBConnection.getConnection()) {
                String updateStatusQuery = "UPDATE tb_transaksi SET status = 1 WHERE id_transaksi = ?";
                PreparedStatement stmtUpdateStatus = conn.prepareStatement(updateStatusQuery);
                stmtUpdateStatus.setString(1, idTransaksi);
                stmtUpdateStatus.executeUpdate();

                // Perbarui status di jTableRiwayatPesanan
                jTableRiwayatPesanan.setValueAt(true, selectedRow, 8);  // Centang kolom status
                JOptionPane.showMessageDialog(this, "Status transaksi berhasil diperbarui menjadi selesai.");
            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this, "Error saat memperbarui status: " + e.getMessage());
            }
        }
    }//GEN-LAST:event_btnStatusSelesaiActionPerformed

    private void ManagePageBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ManagePageBtnActionPerformed
        new Manage().setVisible(true);
        dispose();
    }//GEN-LAST:event_ManagePageBtnActionPerformed
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
            java.util.logging.Logger.getLogger(OrderPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OrderPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OrderPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OrderPage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                OrderPage orderpage = new OrderPage();
                orderpage.pack(); // Menyusun ukuran jendela agar sesuai dengan komponen yang ada
                orderpage.setLocationRelativeTo(null); // Menempatkan jendela di tengah layar
                orderpage.setVisible(true); // Menampilkan jendela
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private custom.button HomePageBtn;
    private javax.swing.JLabel LogoTop;
    private custom.button ManagePageBtn;
    private custom.button OrderPageBtn;
    private custom.button ReportsPageBtn;
    private custom.button TablePageBtn;
    private javax.swing.JLabel Tanggal;
    private javax.swing.JLabel Waktu;
    private javax.swing.JPanel bgOrderPage;
    private custom.button btnStatusSelesai;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableRiwayatPesanan;
    private javax.swing.JTextArea jTextAreaDetailPesanan;
    private javax.swing.JTextField outKembalian;
    private javax.swing.JTextField outPajak;
    private javax.swing.JTextField outSubtotal;
    private javax.swing.JTextField outTotal;
    private javax.swing.JTextField outTunai;
    private custom.panel panel1;
    private javax.swing.JPanel panelTopOrderPage;
    // End of variables declaration//GEN-END:variables
}
