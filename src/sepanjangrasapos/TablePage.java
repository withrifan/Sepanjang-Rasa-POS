package sepanjangrasapos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class TablePage extends javax.swing.JFrame {

    public TablePage() {
        initComponents();
        setTime();
        setImg();
        setIconBtn();
        loadDataMeja();
        setExtendedState(Manage.MAXIMIZED_BOTH);
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
        MethodClass.setIconBtn(OrderPageBtn, "/components/logoOrder2.png");
        MethodClass.setIconBtn(TablePageBtn, "/components/logoTable1.png");
        MethodClass.setIconBtn(ManagePageBtn, "/components/logoStaff2.png");
        MethodClass.setIconBtn(btnLogout, "/components/logoutIcon.png");
    }

    public void resetField() {
        inIdMeja.setText("");
        inNamaMeja.setText("");
        inKapasitasMejaCombo.getSelectedItem();
        inLokasiMejaCombo.getSelectedItem();
        inStatusMejaCombo.getSelectedItem();
    }

    // Metode untuk memuat data dari database ke JTable
    private void loadDataMeja() {
        DefaultTableModel model = new DefaultTableModel(
                new String[]{"Id Meja", "Nama", "Kapasitas", "Lokasi", "Status"}, 0
        );
        jTableMeja.setModel(model);

        model.setRowCount(0); // Reset data tabel

        try {
            String query = "SELECT * FROM tb_meja";
            Connection conn = DBConnection.getConnection();
            PreparedStatement pst = conn.prepareStatement(query);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getInt("id_meja"),
                    rs.getString("nama"),
                    rs.getString("kapasitas"),
                    rs.getString("lokasi"),
                    rs.getString("status"),
                });
            }
            rs.close();
            pst.close();
            conn.close();
        } catch (SQLException e) {
            System.err.println("Gagal memuat data: " + e.getMessage());
        }
    }

    private void addDataMeja() {
        String id = inIdMeja.getText();
        String nama = inNamaMeja.getText();
        String kapasitas = inKapasitasMejaCombo.getSelectedItem().toString();
        String lokasi = inLokasiMejaCombo.getSelectedItem().toString();
        String status = inStatusMejaCombo.getSelectedItem().toString();

        String query = "INSERT INTO tb_meja (id_meja, nama, kapasitas, lokasi, status) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection(); PreparedStatement pstmt = conn.prepareStatement(query)) {

            // Mengatur parameter dalam query
            pstmt.setString(1, id);
            pstmt.setString(2, nama);
            pstmt.setString(3, kapasitas);
            pstmt.setString(4, lokasi);
            pstmt.setString(5, status);

            pstmt.executeUpdate(); // Eksekusi query INSERT
            JOptionPane.showMessageDialog(this, "Data berhasil disimpan!", "Sukses", JOptionPane.INFORMATION_MESSAGE);
            loadDataMeja(); // Refresh JTable setelah menyimpan data
            resetField();

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this,
                    "Error saving data: " + e.getMessage(),
                    "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void updateDataMeja() {
        try {
            String query = "UPDATE tb_meja SET nama = ?, kapasitas = ?, lokasi = ?, status = ? WHERE id_meja = ?";
            Connection conn = DBConnection.getConnection();
            PreparedStatement pst = conn.prepareStatement(query);

            pst.setString(1, inNamaMeja.getText());    
            pst.setString(2, inKapasitasMejaCombo.getSelectedItem().toString());
            pst.setString(3, inLokasiMejaCombo.getSelectedItem().toString());
            pst.setString(4, inStatusMejaCombo.getSelectedItem().toString());
            pst.setInt(5, Integer.parseInt(inIdMeja.getText()));

            int rowsUpdated = pst.executeUpdate();
            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(this, "Data berhasil diupdate.");
                loadDataMeja(); // Refresh tabel setelah update
            }
            pst.close();
            conn.close();
            resetField();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Gagal mengupdate data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "ID Meja harus berupa angka: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void deleteDataMeja() {
        int selectedRow = jTableMeja.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "pilih baris yang akan di hapus");
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(this, "Yakin hapus data ini?", "konfirmasi", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            String id = jTableMeja.getValueAt(selectedRow, 0).toString();

            try {
                String query = "DELETE FROM tb_meja WHERE id_meja=?";
                Connection conn = DBConnection.getConnection();
                PreparedStatement pst = conn.prepareStatement(query);
                pst.setString(1, id);

                int rowDelete = pst.executeUpdate();
                if (rowDelete > 0) {
                    JOptionPane.showMessageDialog(this, "Data berhasil dihapus");

                }
                pst.close();
                loadDataMeja(); // Refresh JTable setelah menyimpan data
                resetField();
            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this,
                        "Error delete data: " + e.getMessage(),
                        "Database Error", JOptionPane.ERROR_MESSAGE);
            }
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
        panelLeftOrderPage = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        HomePageBtn = new custom.button();
        jLabel5 = new javax.swing.JLabel();
        OrderPageBtn = new custom.button();
        ManagePageBtn = new custom.button();
        jLabel6 = new javax.swing.JLabel();
        btnLogout = new custom.button();
        jLabel7 = new javax.swing.JLabel();
        TablePageBtn = new custom.button();
        jLabel8 = new javax.swing.JLabel();
        panel1 = new custom.panel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableMeja = new javax.swing.JTable();
        panel2 = new custom.panel();
        btnAddTable = new custom.button();
        btnUpdateTable = new custom.button();
        btnDeleteTable = new custom.button();
        panel3 = new custom.panel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        inKapasitasMejaCombo = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        inLokasiMejaCombo = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        inStatusMejaCombo = new javax.swing.JComboBox<>();
        inIdMeja = new javax.swing.JTextField();
        inNamaMeja = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Reports - Sepanjang Rasa");
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/components/iconSR.png")).getImage());
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        bgOrderPage.setBackground(new java.awt.Color(255, 242, 232));

        panelTopOrderPage.setBackground(new java.awt.Color(255, 255, 255));
        panelTopOrderPage.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(159, 159, 158)));
        panelTopOrderPage.setPreferredSize(new java.awt.Dimension(1527, 80));

        Waktu.setFont(new java.awt.Font("Poppins SemiBold", 0, 14)); // NOI18N
        Waktu.setForeground(new java.awt.Color(159, 159, 158));
        Waktu.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        Tanggal.setFont(new java.awt.Font("Poppins SemiBold", 0, 12)); // NOI18N
        Tanggal.setForeground(new java.awt.Color(159, 159, 158));
        Tanggal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout panelTopOrderPageLayout = new javax.swing.GroupLayout(panelTopOrderPage);
        panelTopOrderPage.setLayout(panelTopOrderPageLayout);
        panelTopOrderPageLayout.setHorizontalGroup(
            panelTopOrderPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTopOrderPageLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(LogoTop, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 1169, Short.MAX_VALUE)
                .addGroup(panelTopOrderPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Tanggal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Waktu, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
        );
        panelTopOrderPageLayout.setVerticalGroup(
            panelTopOrderPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(LogoTop, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelTopOrderPageLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(Waktu, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(Tanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
        );

        panelLeftOrderPage.setBackground(new java.awt.Color(255, 255, 255));
        panelLeftOrderPage.setPreferredSize(new java.awt.Dimension(65, 710));

        jLabel1.setFont(new java.awt.Font("Poppins SemiBold", 0, 10)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Home");

        HomePageBtn.setColorBorder(new java.awt.Color(255, 255, 255));
        HomePageBtn.setColorClick(new java.awt.Color(204, 204, 204));
        HomePageBtn.setColorOver(new java.awt.Color(245, 245, 245));
        HomePageBtn.setPreferredSize(new java.awt.Dimension(35, 35));
        HomePageBtn.setRadius(8);
        HomePageBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HomePageBtnActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Poppins SemiBold", 0, 10)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Order");

        OrderPageBtn.setColorBorder(new java.awt.Color(255, 255, 255));
        OrderPageBtn.setColorClick(new java.awt.Color(204, 204, 204));
        OrderPageBtn.setColorOver(new java.awt.Color(245, 245, 245));
        OrderPageBtn.setPreferredSize(new java.awt.Dimension(35, 35));
        OrderPageBtn.setRadius(8);
        OrderPageBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OrderPageBtnActionPerformed(evt);
            }
        });

        ManagePageBtn.setColorBorder(new java.awt.Color(255, 255, 255));
        ManagePageBtn.setColorClick(new java.awt.Color(204, 204, 204));
        ManagePageBtn.setColorOver(new java.awt.Color(245, 245, 245));
        ManagePageBtn.setPreferredSize(new java.awt.Dimension(35, 35));
        ManagePageBtn.setRadius(8);
        ManagePageBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ManagePageBtnActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Poppins SemiBold", 0, 10)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Staff");

        btnLogout.setColorBorder(new java.awt.Color(255, 255, 255));
        btnLogout.setColorClick(new java.awt.Color(204, 204, 204));
        btnLogout.setColorOver(new java.awt.Color(245, 245, 245));
        btnLogout.setPreferredSize(new java.awt.Dimension(35, 35));
        btnLogout.setRadius(8);
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Poppins SemiBold", 0, 10)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(231, 43, 43));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Logout");

        TablePageBtn.setColorBorder(new java.awt.Color(255, 255, 255));
        TablePageBtn.setColorClick(new java.awt.Color(204, 204, 204));
        TablePageBtn.setColorOver(new java.awt.Color(245, 245, 245));
        TablePageBtn.setPreferredSize(new java.awt.Dimension(35, 35));
        TablePageBtn.setRadius(8);
        TablePageBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TablePageBtnActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Poppins SemiBold", 0, 10)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(252, 128, 25));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Table");

        javax.swing.GroupLayout panelLeftOrderPageLayout = new javax.swing.GroupLayout(panelLeftOrderPage);
        panelLeftOrderPage.setLayout(panelLeftOrderPageLayout);
        panelLeftOrderPageLayout.setHorizontalGroup(
            panelLeftOrderPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLeftOrderPageLayout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addGroup(panelLeftOrderPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLeftOrderPageLayout.createSequentialGroup()
                        .addComponent(HomePageBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLeftOrderPageLayout.createSequentialGroup()
                        .addComponent(btnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15))))
            .addGroup(panelLeftOrderPageLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(panelLeftOrderPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(OrderPageBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ManagePageBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TablePageBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelLeftOrderPageLayout.setVerticalGroup(
            panelLeftOrderPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLeftOrderPageLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(HomePageBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel1)
                .addGap(30, 30, 30)
                .addComponent(OrderPageBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel5)
                .addGap(30, 30, 30)
                .addComponent(TablePageBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel8)
                .addGap(30, 30, 30)
                .addComponent(ManagePageBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnLogout, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel7)
                .addGap(30, 30, 30))
        );

        panel1.setBackground(new java.awt.Color(255, 255, 255));
        panel1.setRoundBottomLeft(8);
        panel1.setRoundBottomRight(8);
        panel1.setRoundTopLeft(8);
        panel1.setRoundTopRight(8);

        jLabel2.setFont(new java.awt.Font("Poppins Black", 0, 30)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(252, 128, 25));
        jLabel2.setText("Daftar Meja");

        jTableMeja.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Id Meja", "Nama", "Kapasitas", "Lokasi", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableMeja.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableMejaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableMeja);

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGap(429, 429, 429)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(panel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1)
                .addGap(20, 20, 20))
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 577, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        panel2.setBackground(new java.awt.Color(255, 255, 255));

        btnAddTable.setBackground(new java.awt.Color(102, 102, 255));
        btnAddTable.setForeground(new java.awt.Color(255, 255, 255));
        btnAddTable.setText("Save");
        btnAddTable.setColor(new java.awt.Color(102, 102, 255));
        btnAddTable.setColorBorder(new java.awt.Color(102, 102, 255));
        btnAddTable.setColorClick(new java.awt.Color(32, 32, 186));
        btnAddTable.setColorOver(new java.awt.Color(32, 32, 186));
        btnAddTable.setFont(new java.awt.Font("Poppins SemiBold", 1, 14)); // NOI18N
        btnAddTable.setPreferredSize(new java.awt.Dimension(90, 30));
        btnAddTable.setRadius(8);
        btnAddTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddTableActionPerformed(evt);
            }
        });

        btnUpdateTable.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdateTable.setText("UPDATE");
        btnUpdateTable.setColor(new java.awt.Color(9, 170, 41));
        btnUpdateTable.setColorBorder(new java.awt.Color(9, 170, 41));
        btnUpdateTable.setColorClick(new java.awt.Color(15, 111, 34));
        btnUpdateTable.setColorOver(new java.awt.Color(96, 29, 163));
        btnUpdateTable.setFont(new java.awt.Font("Poppins SemiBold", 1, 14)); // NOI18N
        btnUpdateTable.setPreferredSize(new java.awt.Dimension(90, 30));
        btnUpdateTable.setRadius(8);
        btnUpdateTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateTableActionPerformed(evt);
            }
        });

        btnDeleteTable.setForeground(new java.awt.Color(255, 255, 255));
        btnDeleteTable.setText("DELETE");
        btnDeleteTable.setColor(new java.awt.Color(255, 9, 9));
        btnDeleteTable.setColorBorder(new java.awt.Color(255, 9, 9));
        btnDeleteTable.setColorClick(new java.awt.Color(171, 14, 14));
        btnDeleteTable.setColorOver(new java.awt.Color(171, 14, 14));
        btnDeleteTable.setFocusable(false);
        btnDeleteTable.setFont(new java.awt.Font("Poppins SemiBold", 1, 14)); // NOI18N
        btnDeleteTable.setPreferredSize(new java.awt.Dimension(90, 30));
        btnDeleteTable.setRadius(8);
        btnDeleteTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteTableActionPerformed(evt);
            }
        });

        panel3.setBackground(new java.awt.Color(245, 245, 245));
        panel3.setRoundBottomLeft(8);
        panel3.setRoundBottomRight(8);
        panel3.setRoundTopLeft(8);
        panel3.setRoundTopRight(8);

        jLabel3.setFont(new java.awt.Font("Poppins SemiBold", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(252, 128, 25));
        jLabel3.setText("Detail Meja");

        javax.swing.GroupLayout panel3Layout = new javax.swing.GroupLayout(panel3);
        panel3.setLayout(panel3Layout);
        panel3Layout.setHorizontalGroup(
            panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel3Layout.createSequentialGroup()
                .addGap(98, 98, 98)
                .addComponent(jLabel3)
                .addGap(98, 98, 98))
        );
        panel3Layout.setVerticalGroup(
            panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel3Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );

        jLabel4.setFont(new java.awt.Font("Poppins SemiBold", 0, 14)); // NOI18N
        jLabel4.setText("ID Meja");

        jLabel10.setFont(new java.awt.Font("Poppins SemiBold", 0, 14)); // NOI18N
        jLabel10.setText("Nama Meja");

        jLabel12.setFont(new java.awt.Font("Poppins SemiBold", 0, 14)); // NOI18N
        jLabel12.setText("Kapasitas Meja");

        inKapasitasMejaCombo.setFont(new java.awt.Font("Poppins Medium", 0, 13)); // NOI18N
        inKapasitasMejaCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2", "4", "8", "12", " " }));
        inKapasitasMejaCombo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(159, 159, 158)));

        jLabel13.setFont(new java.awt.Font("Poppins SemiBold", 0, 14)); // NOI18N
        jLabel13.setText("Lokasi Meja");

        inLokasiMejaCombo.setFont(new java.awt.Font("Poppins Medium", 0, 13)); // NOI18N
        inLokasiMejaCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Lantai 1", "Lantai 2", "Area luar", "Area VIP" }));
        inLokasiMejaCombo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(159, 159, 158)));

        jLabel14.setFont(new java.awt.Font("Poppins SemiBold", 0, 14)); // NOI18N
        jLabel14.setText("Status Meja");

        inStatusMejaCombo.setFont(new java.awt.Font("Poppins Medium", 0, 13)); // NOI18N
        inStatusMejaCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "0" }));
        inStatusMejaCombo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(159, 159, 158)));
        inStatusMejaCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inStatusMejaComboActionPerformed(evt);
            }
        });

        inIdMeja.setFont(new java.awt.Font("Poppins", 0, 13)); // NOI18N
        inIdMeja.setPreferredSize(new java.awt.Dimension(64, 30));

        inNamaMeja.setFont(new java.awt.Font("Poppins", 0, 13)); // NOI18N
        inNamaMeja.setPreferredSize(new java.awt.Dimension(64, 30));

        javax.swing.GroupLayout panel2Layout = new javax.swing.GroupLayout(panel2);
        panel2.setLayout(panel2Layout);
        panel2Layout.setHorizontalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel2Layout.createSequentialGroup()
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panel2Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panel2Layout.createSequentialGroup()
                                .addComponent(btnAddTable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(btnUpdateTable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnDeleteTable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panel2Layout.createSequentialGroup()
                                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(inKapasitasMejaCombo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(inNamaMeja, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(inIdMeja, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(panel2Layout.createSequentialGroup()
                                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(inStatusMejaCombo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(inLokasiMejaCombo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(panel2Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(panel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(22, 22, 22))
        );
        panel2Layout.setVerticalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel2Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(panel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(inIdMeja, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(25, 25, 25)
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inNamaMeja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(inKapasitasMejaCombo, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(25, 25, 25)
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inLokasiMejaCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inStatusMejaCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 213, Short.MAX_VALUE)
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAddTable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnUpdateTable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDeleteTable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(88, 88, 88))
        );

        javax.swing.GroupLayout bgOrderPageLayout = new javax.swing.GroupLayout(bgOrderPage);
        bgOrderPage.setLayout(bgOrderPageLayout);
        bgOrderPageLayout.setHorizontalGroup(
            bgOrderPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgOrderPageLayout.createSequentialGroup()
                .addGroup(bgOrderPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(bgOrderPageLayout.createSequentialGroup()
                        .addComponent(panelLeftOrderPage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addComponent(panel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(25, 25, 25)
                        .addComponent(panel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(panelTopOrderPage, javax.swing.GroupLayout.PREFERRED_SIZE, 1536, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        bgOrderPageLayout.setVerticalGroup(
            bgOrderPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgOrderPageLayout.createSequentialGroup()
                .addComponent(panelTopOrderPage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(bgOrderPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bgOrderPageLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                        .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25))
                    .addGroup(bgOrderPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(panel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(panelLeftOrderPage, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 717, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bgOrderPage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bgOrderPage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        setExtendedState(TablePage.MAXIMIZED_BOTH);// mengatur agar frame ditampilkan fullscreen 
    }//GEN-LAST:event_formComponentShown

    private void homePageBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homePageBtnActionPerformed

    }//GEN-LAST:event_homePageBtnActionPerformed

    private void orderPageBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_orderPageBtnActionPerformed

    }//GEN-LAST:event_orderPageBtnActionPerformed

    private void reportsPageBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reportsPageBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_reportsPageBtnActionPerformed

    private void mngStaffPagebtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mngStaffPagebtnActionPerformed

    }//GEN-LAST:event_mngStaffPagebtnActionPerformed

    private void ManagePageBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ManagePageBtnActionPerformed
        String role = Session.getLoggedInStaffRole();
        if ("Admin".equalsIgnoreCase(role) || "Manager".equalsIgnoreCase(role)) {
            new Manage().setVisible(true);
        } else {
            JOptionPane.showMessageDialog(TablePage.this, "Anda tidak memiliki akses ke management staff. Hanya Admin dan Manager yang meiliki akses!", "Akses Ditolak", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_ManagePageBtnActionPerformed

    private void HomePageBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HomePageBtnActionPerformed
        new HomePage().setVisible(true);
        dispose();
    }//GEN-LAST:event_HomePageBtnActionPerformed

    private void OrderPageBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OrderPageBtnActionPerformed
        new OrderPage().setVisible(true);
        dispose();
    }//GEN-LAST:event_OrderPageBtnActionPerformed

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed
        LoginPage loginPage = new LoginPage();
        loginPage.setLocationRelativeTo(null);
        loginPage.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void TablePageBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TablePageBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TablePageBtnActionPerformed

    private void btnUpdateTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateTableActionPerformed
        updateDataMeja();
    }//GEN-LAST:event_btnUpdateTableActionPerformed

    private void btnAddTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddTableActionPerformed
        addDataMeja();
    }//GEN-LAST:event_btnAddTableActionPerformed

    private void btnDeleteTableActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteTableActionPerformed
        deleteDataMeja();
    }//GEN-LAST:event_btnDeleteTableActionPerformed

    private void jTableMejaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableMejaMouseClicked
        int selectedRow = jTableMeja.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) jTableMeja.getModel();

        inIdMeja.setText(model.getValueAt(selectedRow, 0).toString());
        inNamaMeja.setText(model.getValueAt(selectedRow, 1).toString());
        inKapasitasMejaCombo.setSelectedItem(model.getValueAt(selectedRow, 2).toString());
        inLokasiMejaCombo.setSelectedItem(model.getValueAt(selectedRow, 3).toString());
        inStatusMejaCombo.setSelectedItem(model.getValueAt(selectedRow, 4).toString());
    }//GEN-LAST:event_jTableMejaMouseClicked

    private void inStatusMejaComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inStatusMejaComboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inStatusMejaComboActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(() -> {
            new TablePage().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private custom.button HomePageBtn;
    private javax.swing.JLabel LogoTop;
    private custom.button ManagePageBtn;
    private custom.button OrderPageBtn;
    private custom.button TablePageBtn;
    private javax.swing.JLabel Tanggal;
    private javax.swing.JLabel Waktu;
    private javax.swing.JPanel bgOrderPage;
    private custom.button btnAddTable;
    private custom.button btnDeleteTable;
    private custom.button btnLogout;
    private custom.button btnUpdateTable;
    private javax.swing.JTextField inIdMeja;
    private javax.swing.JComboBox<String> inKapasitasMejaCombo;
    private javax.swing.JComboBox<String> inLokasiMejaCombo;
    private javax.swing.JTextField inNamaMeja;
    private javax.swing.JComboBox<String> inStatusMejaCombo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableMeja;
    private custom.panel panel1;
    private custom.panel panel2;
    private custom.panel panel3;
    private javax.swing.JPanel panelLeftOrderPage;
    private javax.swing.JPanel panelTopOrderPage;
    // End of variables declaration//GEN-END:variables
}
