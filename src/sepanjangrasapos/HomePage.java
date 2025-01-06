package sepanjangrasapos;

import java.awt.Color;
import java.awt.print.PrinterException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.text.MessageFormat; 
import javax.swing.JTextArea;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.text.SimpleDateFormat;
import java.util.Date;

public class HomePage extends javax.swing.JFrame {

    private int subtotal = 0;
    private int x = 0;
    private double pajak = 0;
    int PPN = 0;
    private int total = 0;
    private int tunai = 0;
    private int kembali = 0;
    private int qty = 0;
    //private int idStaff; // Simpan ID Staff yang login

    public HomePage() {
        // this.idStaff = idStaff; // Simpan ID Staff
        initComponents();
        setTime();
        setImg();
        setIconBtn();
    }

    public void setImg() {
        // Menggunakan MethodClass untuk mengatur ikon pada JLabel
        MethodClass.setIconLabel(LogoTop, "/components/LogoSepanjangRasa2.png");
        MethodClass.setIconLabel(picMenu1, "/components/1chickensteak.jpg");
        MethodClass.setIconLabel(picMenu2, "/components/1chickencombo.jpg");
        MethodClass.setIconLabel(picMenu3, "/components/1combomeals.jpg");
        MethodClass.setIconLabel(picMenu4, "/components/1Tbone.jpg");
        MethodClass.setIconLabel(picMenu5, "/components/1ribeye.jpg");
        MethodClass.setIconLabel(picMenu8, "/components/1steak.jpg");
        MethodClass.setIconLabel(picMenu9, "/components/1tenderloin.jpg");
        MethodClass.setIconLabel(picMenu10, "/components/1tomahwak.jpg");
        MethodClass.setIconLabel(picMenu11, "/components/2Expresso.jpg");
        MethodClass.setIconLabel(picMenu12, "/components/2Lemoncucumber.jpg");
        MethodClass.setIconLabel(picMenu13, "/components/2perrier.jpg");
        MethodClass.setIconLabel(picMenu14, "/components/2strawberrylemonade.jpeg");
        MethodClass.setIconLabel(picMenu15, "/components/2virginmojito.jpg");
        MethodClass.setIconLabel(picMenu16, "/components/3applecrumble.jpg");
        MethodClass.setIconLabel(picMenu17, "/components/3cheesecake.jpeg");
        MethodClass.setIconLabel(picMenu18, "/components/3chocolateLavaCake.jpg");
        MethodClass.setIconLabel(picMenu19, "/components/3tiramisu.jpg");
        MethodClass.setIconLabel(picMenu20, "/components/3cremebrulee.jpg");
    }

    private void setIconBtn() {
        // Menggunakan MethodClass untuk mengatur ikon pada JButton
        MethodClass.setIconBtn(HomePageBtn, "/components/logoHome1.png");
        MethodClass.setIconBtn(OrderPageBtn, "/components/logoOrder2.png");
        MethodClass.setIconBtn(ReportsPageBtn, "/components/logoReport2.png");
        MethodClass.setIconBtn(ManagePageBtn, "/components/logoStaff2.png");
    }

    public void setTime() {
        // Menggunakan MethodClass untuk memperbarui waktu dan tanggal secara real-time
        MethodClass.setTime(Waktu, Tanggal);
    }

    public void hitung() {
        //Method yang digunakan untukmenghitung nilai dari subtotal, pajak, dan total
        pajak = subtotal * 0.12;
        PPN = (int) Math.round(pajak);
        total = subtotal + PPN;
        outputSubtotal.setText("Rp. " + String.valueOf(subtotal));
        outputPPN.setText("Rp. " + String.valueOf(PPN));
        outputTotal.setText("Rp. " + String.valueOf(total));
    }

    public void reset() {
        //Method yang digunakan untuk mereset semua nilai yang ada
        x = 0;
        subtotal = 0;
        pajak = 0.0;
        PPN = 0;
        total = 0;
        tunai = 0;
        kembali = 0;
        qtyMenu1.setValue(0);
        qtyMenu2.setValue(0);
        qtyMenu3.setValue(0);
        qtyMenu4.setValue(0);
        qtyMenu5.setValue(0);
        qtyMenu8.setValue(0);
        qtyMenu9.setValue(0);
        qtyMenu10.setValue(0);
        qtyMenu11.setValue(0);
        qtyMenu12.setValue(0);
        qtyMenu18.setValue(0);
        qtyMenu16.setValue(0);
        qtyMenu15.setValue(0);
        qtyMenu17.setValue(0);
        qtyMenu14.setValue(0);
        qtyMenu13.setValue(0);
        qtyMenu19.setValue(0);
        qtyMenu20.setValue(0);
        outputSubtotal.setText("");
        outputPPN.setText("");
        outputTotal.setText("");
        outputKembali.setText("");
        inputTunai.setText("");
        jTextAreaOrder.setText("");
        addMenu1.setSelected(false);
        addMenu2.setSelected(false);
        addMenu3.setSelected(false);
        addMenu4.setSelected(false);
        addMenu5.setSelected(false);
        addMenu8.setSelected(false);
        addMenu9.setSelected(false);
        addMenu10.setSelected(false);
        addMenu11.setSelected(false);
        addMenu12.setSelected(false);
        addMenu18.setSelected(false);
        addMenu16.setSelected(false);
        addMenu15.setSelected(false);
        addMenu17.setSelected(false);
        addMenu14.setSelected(false);
        addMenu13.setSelected(false);
        addMenu19.setSelected(false);
        addMenu20.setSelected(false);
        btnBayar.setEnabled(true);
    }

    public void orderList() {
        //Method yang digunakan untuk mencetak teks di JTextArea
        jTextAreaOrder.setText("******************* Sepanjang Rasa *******************\n"
                + "Time: " + Waktu.getText() + " Date: " + Tanggal.getText() + "\n"
                + "******************************************************" + "\n"
                + String.format("%-25s%5s%15s", "   Produk", "jumlah", "Total") + "\n");
    }

    private List<Map<String, Object>> orders = new ArrayList<>();

    public void prosesOrder(JSpinner qtyMenu, JCheckBox addMenu, JLabel lblMenu, JComboBox<String> opsiMenu, int idProduk) {
        int qty = Integer.parseInt(qtyMenu.getValue().toString());

        if (qty > 0 && addMenu.isSelected()) {
            try (Connection conn = DBConnection.getConnection()) {
                String querySelect = "SELECT stok, harga, nama FROM tb_produk WHERE id_produk = ?";
                PreparedStatement stmtSelect = conn.prepareStatement(querySelect);
                stmtSelect.setInt(1, idProduk);

                ResultSet rs = stmtSelect.executeQuery();

                if (rs.next()) {
                    int stok = rs.getInt("stok");
                    int harga = rs.getInt("harga");
                    String namaProduk = rs.getString("nama");

                    // Cek stok, tapi tidak mengurangi stok langsung
                    if (stok >= qty) {
                        int price = qty * harga;
                        subtotal += price;
                        x++;
                        if (x == 1) {
                            orderList();
                        }

                        // Simpan data pesanan sementara
                        Map<String, Object> order = new HashMap<>();
                        order.put("id_produk", idProduk);
                        order.put("nama", namaProduk);
                        order.put("qty", qty);
                        order.put("price", price);
                        order.put("stok_akhir", stok - qty);
                        orders.add(order);

                        String formattedText = String.format(
                                "%-3d%-22s%4d%17d\n %3s\n",
                                x, namaProduk, qty, price, "  " + opsiMenu.getSelectedItem()
                        );
                        jTextAreaOrder.setText(jTextAreaOrder.getText() + formattedText);

                        hitung();
                    } else {
                        JOptionPane.showMessageDialog(null, "Stok tidak mencukupi untuk " + namaProduk, "Stok Tidak Cukup", JOptionPane.ERROR_MESSAGE);
                        addMenu.setSelected(false);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Produk tidak ditemukan di database!", "Error", JOptionPane.ERROR_MESSAGE);
                    addMenu.setSelected(false);
                }
            } catch (SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Terjadi kesalahan pada database: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            addMenu.setSelected(false);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        layerDasarHome = new javax.swing.JPanel();
        topPanel = new javax.swing.JPanel();
        Waktu = new javax.swing.JLabel();
        Tanggal = new javax.swing.JLabel();
        LogoTop = new javax.swing.JLabel();
        leftPanel = new javax.swing.JPanel();
        HomePageBtn = new custom.button();
        OrderPageBtn = new custom.button();
        ReportsPageBtn = new custom.button();
        ManagePageBtn = new custom.button();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        menuPanel = new javax.swing.JPanel();
        rightPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaOrder = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        inputTunai = new javax.swing.JTextField();
        outputKembali = new javax.swing.JTextField();
        btnReset = new custom.button();
        btnPrint = new custom.button();
        btnBayar = new custom.button();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        outputSubtotal = new javax.swing.JTextField();
        outputPPN = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        outputTotal = new javax.swing.JTextField();
        inputNamaPel = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        inputMeja = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        sesiIDStaff = new javax.swing.JTextField();
        PanelMenu1 = new custom.panel();
        addMenu1 = new javax.swing.JCheckBox();
        qtyMenu1 = new javax.swing.JSpinner();
        lblVarian1 = new javax.swing.JLabel();
        lblMenu1 = new javax.swing.JLabel();
        picMenu1 = new javax.swing.JLabel();
        opsiMenu1 = new javax.swing.JComboBox<>();
        PanelMenu2 = new custom.panel();
        addMenu2 = new javax.swing.JCheckBox();
        qtyMenu2 = new javax.swing.JSpinner();
        lblVarian2 = new javax.swing.JLabel();
        lblMenu2 = new javax.swing.JLabel();
        picMenu2 = new javax.swing.JLabel();
        opsiMenu2 = new javax.swing.JComboBox<>();
        PanelMenu3 = new custom.panel();
        addMenu3 = new javax.swing.JCheckBox();
        qtyMenu3 = new javax.swing.JSpinner();
        lblVarian3 = new javax.swing.JLabel();
        lblMenu3 = new javax.swing.JLabel();
        picMenu3 = new javax.swing.JLabel();
        opsiMenu3 = new javax.swing.JComboBox<>();
        PanelMenu4 = new custom.panel();
        addMenu4 = new javax.swing.JCheckBox();
        qtyMenu4 = new javax.swing.JSpinner();
        lblVarian4 = new javax.swing.JLabel();
        lblMenu4 = new javax.swing.JLabel();
        picMenu4 = new javax.swing.JLabel();
        opsiMenu4 = new javax.swing.JComboBox<>();
        PanelMenu5 = new custom.panel();
        addMenu5 = new javax.swing.JCheckBox();
        qtyMenu5 = new javax.swing.JSpinner();
        lblVarian5 = new javax.swing.JLabel();
        lblMenu5 = new javax.swing.JLabel();
        picMenu5 = new javax.swing.JLabel();
        opsiMenu5 = new javax.swing.JComboBox<>();
        PanelMenu8 = new custom.panel();
        addMenu8 = new javax.swing.JCheckBox();
        qtyMenu8 = new javax.swing.JSpinner();
        lblVarian8 = new javax.swing.JLabel();
        lblMenu8 = new javax.swing.JLabel();
        picMenu8 = new javax.swing.JLabel();
        opsiMenu8 = new javax.swing.JComboBox<>();
        PanelMenu9 = new custom.panel();
        addMenu9 = new javax.swing.JCheckBox();
        qtyMenu9 = new javax.swing.JSpinner();
        lblVarian9 = new javax.swing.JLabel();
        lblMenu9 = new javax.swing.JLabel();
        picMenu9 = new javax.swing.JLabel();
        opsiMenu9 = new javax.swing.JComboBox<>();
        PanelMenu10 = new custom.panel();
        addMenu10 = new javax.swing.JCheckBox();
        qtyMenu10 = new javax.swing.JSpinner();
        lblVarian10 = new javax.swing.JLabel();
        lblMenu10 = new javax.swing.JLabel();
        picMenu10 = new javax.swing.JLabel();
        opsiMenu10 = new javax.swing.JComboBox<>();
        PanelMenu11 = new custom.panel();
        addMenu11 = new javax.swing.JCheckBox();
        qtyMenu11 = new javax.swing.JSpinner();
        lblMenu11 = new javax.swing.JLabel();
        picMenu11 = new javax.swing.JLabel();
        opsiMenu11 = new javax.swing.JComboBox<>();
        lblVarian11 = new javax.swing.JLabel();
        PanelMenu12 = new custom.panel();
        addMenu12 = new javax.swing.JCheckBox();
        qtyMenu12 = new javax.swing.JSpinner();
        lblMenu12 = new javax.swing.JLabel();
        picMenu12 = new javax.swing.JLabel();
        lblVarian12 = new javax.swing.JLabel();
        opsiMenu12 = new javax.swing.JComboBox<>();
        PanelMenu13 = new custom.panel();
        addMenu13 = new javax.swing.JCheckBox();
        qtyMenu13 = new javax.swing.JSpinner();
        lblMenu13 = new javax.swing.JLabel();
        picMenu13 = new javax.swing.JLabel();
        lblVarian13 = new javax.swing.JLabel();
        opsiMenu13 = new javax.swing.JComboBox<>();
        PanelMenu14 = new custom.panel();
        addMenu14 = new javax.swing.JCheckBox();
        qtyMenu14 = new javax.swing.JSpinner();
        lblMenu14 = new javax.swing.JLabel();
        picMenu14 = new javax.swing.JLabel();
        opsiMenu14 = new javax.swing.JComboBox<>();
        lblVarian14 = new javax.swing.JLabel();
        PanelMenu15 = new custom.panel();
        addMenu15 = new javax.swing.JCheckBox();
        qtyMenu15 = new javax.swing.JSpinner();
        lblMenu15 = new javax.swing.JLabel();
        picMenu15 = new javax.swing.JLabel();
        lblVarian15 = new javax.swing.JLabel();
        opsiMenu15 = new javax.swing.JComboBox<>();
        PanelMenu16 = new custom.panel();
        addMenu16 = new javax.swing.JCheckBox();
        qtyMenu16 = new javax.swing.JSpinner();
        lblMenu16 = new javax.swing.JLabel();
        picMenu16 = new javax.swing.JLabel();
        lblVarian16 = new javax.swing.JLabel();
        opsiMenu16 = new javax.swing.JComboBox<>();
        PanelMenu17 = new custom.panel();
        addMenu17 = new javax.swing.JCheckBox();
        qtyMenu17 = new javax.swing.JSpinner();
        lblMenu17 = new javax.swing.JLabel();
        picMenu17 = new javax.swing.JLabel();
        opsiMenu17 = new javax.swing.JComboBox<>();
        lblVarian17 = new javax.swing.JLabel();
        PanelMenu18 = new custom.panel();
        addMenu18 = new javax.swing.JCheckBox();
        qtyMenu18 = new javax.swing.JSpinner();
        lblMenu18 = new javax.swing.JLabel();
        picMenu18 = new javax.swing.JLabel();
        lblVarian18 = new javax.swing.JLabel();
        opsiMenu18 = new javax.swing.JComboBox<>();
        PanelMenu19 = new custom.panel();
        addMenu19 = new javax.swing.JCheckBox();
        qtyMenu19 = new javax.swing.JSpinner();
        lblMenu19 = new javax.swing.JLabel();
        picMenu19 = new javax.swing.JLabel();
        lblVarian19 = new javax.swing.JLabel();
        opsiMenu19 = new javax.swing.JComboBox<>();
        PanelMenu20 = new custom.panel();
        addMenu20 = new javax.swing.JCheckBox();
        qtyMenu20 = new javax.swing.JSpinner();
        lblMenu20 = new javax.swing.JLabel();
        picMenu20 = new javax.swing.JLabel();
        opsiMenu20 = new javax.swing.JComboBox<>();
        lblVarian20 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Home - Sepanjang Rasa");
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/components/iconSR.jpg")).getImage());
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        layerDasarHome.setBackground(new java.awt.Color(245, 245, 245));

        topPanel.setBackground(new java.awt.Color(255, 255, 255));
        topPanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(159, 159, 158), 1, true));
        topPanel.setPreferredSize(new java.awt.Dimension(1536, 80));
        topPanel.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                topPanelMouseDragged(evt);
            }
        });

        Waktu.setFont(new java.awt.Font("Poppins Medium", 0, 15)); // NOI18N
        Waktu.setForeground(new java.awt.Color(159, 159, 158));
        Waktu.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        Waktu.setPreferredSize(new java.awt.Dimension(150, 25));

        Tanggal.setFont(new java.awt.Font("Poppins Medium", 0, 13)); // NOI18N
        Tanggal.setForeground(new java.awt.Color(159, 159, 158));
        Tanggal.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        Tanggal.setPreferredSize(new java.awt.Dimension(150, 25));

        javax.swing.GroupLayout topPanelLayout = new javax.swing.GroupLayout(topPanel);
        topPanel.setLayout(topPanelLayout);
        topPanelLayout.setHorizontalGroup(
            topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(topPanelLayout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addComponent(LogoTop, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 1218, Short.MAX_VALUE)
                .addGroup(topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Waktu, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Tanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        topPanelLayout.setVerticalGroup(
            topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(topPanelLayout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addComponent(Waktu, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(Tanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(10, Short.MAX_VALUE))
            .addComponent(LogoTop, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        leftPanel.setBackground(new java.awt.Color(255, 255, 255));
        leftPanel.setPreferredSize(new java.awt.Dimension(65, 710));

        HomePageBtn.setColorBorder(new java.awt.Color(255, 255, 255));
        HomePageBtn.setColorClick(new java.awt.Color(204, 204, 204));
        HomePageBtn.setColorOver(new java.awt.Color(245, 245, 245));
        HomePageBtn.setIconTextGap(8);
        HomePageBtn.setPreferredSize(new java.awt.Dimension(35, 35));
        HomePageBtn.setRadius(8);
        HomePageBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HomePageBtnActionPerformed(evt);
            }
        });

        OrderPageBtn.setColorBorder(new java.awt.Color(255, 255, 255));
        OrderPageBtn.setColorClick(new java.awt.Color(204, 204, 204));
        OrderPageBtn.setColorOver(new java.awt.Color(245, 245, 245));
        OrderPageBtn.setIconTextGap(8);
        OrderPageBtn.setPreferredSize(new java.awt.Dimension(35, 35));
        OrderPageBtn.setRadius(8);
        OrderPageBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OrderPageBtnActionPerformed(evt);
            }
        });

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

        jLabel6.setFont(new java.awt.Font("Poppins SemiBold", 0, 11)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(252, 128, 25));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Home");

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Poppins SemiBold", 0, 11)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(23, 24, 38));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Order");

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Poppins SemiBold", 0, 11)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(23, 24, 38));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Report");

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("Poppins SemiBold", 0, 11)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(23, 24, 38));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Staff");

        javax.swing.GroupLayout leftPanelLayout = new javax.swing.GroupLayout(leftPanel);
        leftPanel.setLayout(leftPanelLayout);
        leftPanelLayout.setHorizontalGroup(
            leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(leftPanelLayout.createSequentialGroup()
                .addGroup(leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(leftPanelLayout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(leftPanelLayout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(leftPanelLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(HomePageBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(leftPanelLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(leftPanelLayout.createSequentialGroup()
                        .addGap(0, 2, Short.MAX_VALUE)
                        .addGroup(leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(OrderPageBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ReportsPageBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(ManagePageBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
        );
        leftPanelLayout.setVerticalGroup(
            leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(leftPanelLayout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(HomePageBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel6)
                .addGap(30, 30, 30)
                .addComponent(OrderPageBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel7)
                .addGap(30, 30, 30)
                .addComponent(ReportsPageBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel8)
                .addGap(30, 30, 30)
                .addComponent(ManagePageBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel9)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        menuPanel.setBackground(new java.awt.Color(255, 242, 232));

        rightPanel.setBackground(new java.awt.Color(255, 242, 232));
        rightPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(159, 159, 158)));

        jTextAreaOrder.setColumns(20);
        jTextAreaOrder.setFont(new java.awt.Font("Consolas", 0, 12)); // NOI18N
        jTextAreaOrder.setRows(5);
        jTextAreaOrder.setBorder(null);
        jScrollPane1.setViewportView(jTextAreaOrder);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setFont(new java.awt.Font("Poppins Medium", 1, 13)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("Tunai");
        jLabel4.setPreferredSize(new java.awt.Dimension(55, 25));

        jLabel5.setFont(new java.awt.Font("Poppins Medium", 1, 13)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("Kembali");
        jLabel5.setPreferredSize(new java.awt.Dimension(55, 25));

        inputTunai.setFont(new java.awt.Font("Poppins Medium", 1, 13)); // NOI18N
        inputTunai.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        inputTunai.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(159, 159, 158), 1, true));
        inputTunai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputTunaiActionPerformed(evt);
            }
        });

        outputKembali.setEditable(false);
        outputKembali.setFont(new java.awt.Font("Poppins Medium", 1, 13)); // NOI18N
        outputKembali.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        outputKembali.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(159, 159, 158), 1, true));
        outputKembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                outputKembaliActionPerformed(evt);
            }
        });

        btnReset.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnReset.setForeground(new java.awt.Color(255, 255, 255));
        btnReset.setText("Reset");
        btnReset.setColor(new java.awt.Color(51, 120, 229));
        btnReset.setColorBorder(new java.awt.Color(51, 120, 229));
        btnReset.setColorClick(new java.awt.Color(51, 8, 172));
        btnReset.setColorOver(new java.awt.Color(4, 144, 250));
        btnReset.setFont(new java.awt.Font("Poppins Medium", 1, 14)); // NOI18N
        btnReset.setPreferredSize(new java.awt.Dimension(95, 30));
        btnReset.setRadius(10);
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        btnPrint.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnPrint.setForeground(new java.awt.Color(255, 255, 255));
        btnPrint.setText("Print");
        btnPrint.setColor(new java.awt.Color(9, 170, 41));
        btnPrint.setColorBorder(new java.awt.Color(9, 170, 41));
        btnPrint.setColorClick(new java.awt.Color(0, 102, 0));
        btnPrint.setColorOver(new java.awt.Color(51, 255, 51));
        btnPrint.setFont(new java.awt.Font("Poppins Medium", 1, 14)); // NOI18N
        btnPrint.setPreferredSize(new java.awt.Dimension(95, 30));
        btnPrint.setRadius(10);
        btnPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintActionPerformed(evt);
            }
        });

        btnBayar.setBackground(new java.awt.Color(252, 128, 25));
        btnBayar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnBayar.setForeground(new java.awt.Color(255, 255, 255));
        btnBayar.setText("Bayar");
        btnBayar.setColor(new java.awt.Color(252, 128, 25));
        btnBayar.setColorBorder(new java.awt.Color(252, 128, 25));
        btnBayar.setColorClick(new java.awt.Color(252, 86, 16));
        btnBayar.setColorOver(new java.awt.Color(252, 170, 125));
        btnBayar.setFont(new java.awt.Font("Poppins Medium", 1, 14)); // NOI18N
        btnBayar.setPreferredSize(new java.awt.Dimension(95, 30));
        btnBayar.setRadius(10);
        btnBayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBayarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE))
                        .addGap(63, 63, 63)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(inputTunai)
                            .addComponent(outputKembali)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23)
                        .addComponent(btnBayar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23)
                        .addComponent(btnPrint, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(6, 6, 6))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputTunai, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(outputKembali, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBayar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("Subtotal");
        jLabel1.setPreferredSize(new java.awt.Dimension(55, 25));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("PPN 12%");
        jLabel2.setPreferredSize(new java.awt.Dimension(55, 25));

        outputSubtotal.setBackground(new java.awt.Color(255, 242, 232));
        outputSubtotal.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        outputSubtotal.setBorder(null);

        outputPPN.setBackground(new java.awt.Color(255, 242, 232));
        outputPPN.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        outputPPN.setBorder(null);

        jLabel3.setFont(new java.awt.Font("Poppins Medium", 1, 13)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("Total");
        jLabel3.setPreferredSize(new java.awt.Dimension(55, 25));

        outputTotal.setBackground(new java.awt.Color(255, 242, 232));
        outputTotal.setFont(new java.awt.Font("Poppins Medium", 1, 13)); // NOI18N
        outputTotal.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        outputTotal.setBorder(null);
        outputTotal.setPreferredSize(new java.awt.Dimension(181, 25));

        inputNamaPel.setFont(new java.awt.Font("Poppins Medium", 1, 13)); // NOI18N
        inputNamaPel.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        inputNamaPel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(159, 159, 158), 1, true));
        inputNamaPel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputNamaPelActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Poppins Medium", 1, 13)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel10.setText("Nama Pelanggan");
        jLabel10.setPreferredSize(new java.awt.Dimension(55, 25));

        jLabel11.setFont(new java.awt.Font("Poppins Medium", 1, 13)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel11.setText("No Meja");
        jLabel11.setPreferredSize(new java.awt.Dimension(55, 25));

        inputMeja.setFont(new java.awt.Font("Poppins Medium", 1, 13)); // NOI18N
        inputMeja.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        inputMeja.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(159, 159, 158), 1, true));
        inputMeja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputMejaActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Poppins Medium", 1, 13)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel12.setText("ID Staff");
        jLabel12.setPreferredSize(new java.awt.Dimension(55, 25));

        sesiIDStaff.setEditable(false);
        sesiIDStaff.setFont(new java.awt.Font("Poppins Medium", 1, 13)); // NOI18N
        sesiIDStaff.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        sesiIDStaff.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(159, 159, 158), 1, true));
        sesiIDStaff.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sesiIDStaffActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout rightPanelLayout = new javax.swing.GroupLayout(rightPanel);
        rightPanel.setLayout(rightPanelLayout);
        rightPanelLayout.setHorizontalGroup(
            rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(rightPanelLayout.createSequentialGroup()
                .addGroup(rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(rightPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1))
                    .addGroup(rightPanelLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(outputPPN)
                            .addComponent(outputSubtotal)
                            .addComponent(outputTotal, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE)))
                    .addGroup(rightPanelLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(rightPanelLayout.createSequentialGroup()
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(inputNamaPel, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(rightPanelLayout.createSequentialGroup()
                                .addGroup(rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(rightPanelLayout.createSequentialGroup()
                                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(inputMeja, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(rightPanelLayout.createSequentialGroup()
                                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(sesiIDStaff, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(77, 77, 77)))))
                .addContainerGap())
        );
        rightPanelLayout.setVerticalGroup(
            rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rightPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputNamaPel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputMeja, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sesiIDStaff, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(outputSubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(outputPPN, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(outputTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );

        PanelMenu1.setBackground(new java.awt.Color(255, 255, 255));
        PanelMenu1.setPreferredSize(new java.awt.Dimension(160, 215));
        PanelMenu1.setRoundBottomLeft(8);
        PanelMenu1.setRoundBottomRight(8);
        PanelMenu1.setRoundTopLeft(8);
        PanelMenu1.setRoundTopRight(8);

        addMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addMenu1ActionPerformed(evt);
            }
        });

        qtyMenu1.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        qtyMenu1.setBorder(null);
        qtyMenu1.setPreferredSize(new java.awt.Dimension(65, 23));
        qtyMenu1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                qtyMenu1StateChanged(evt);
            }
        });

        lblVarian1.setFont(new java.awt.Font("Poppins Light", 1, 12)); // NOI18N
        lblVarian1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblVarian1.setText("Varian");

        lblMenu1.setFont(new java.awt.Font("Poppins SemiBold", 0, 14)); // NOI18N
        lblMenu1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblMenu1.setText("Chicken Steak");
        lblMenu1.setPreferredSize(new java.awt.Dimension(135, 20));

        picMenu1.setPreferredSize(new java.awt.Dimension(144, 100));

        opsiMenu1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Rare", "Medium rare", "Medium", "Medium well", "Welldone" }));
        opsiMenu1.setBorder(null);
        opsiMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opsiMenu1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelMenu1Layout = new javax.swing.GroupLayout(PanelMenu1);
        PanelMenu1.setLayout(PanelMenu1Layout);
        PanelMenu1Layout.setHorizontalGroup(
            PanelMenu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelMenu1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(qtyMenu1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(addMenu1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(PanelMenu1Layout.createSequentialGroup()
                .addContainerGap(8, Short.MAX_VALUE)
                .addComponent(picMenu1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(8, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelMenu1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelMenu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblMenu1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(PanelMenu1Layout.createSequentialGroup()
                        .addComponent(lblVarian1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)
                        .addComponent(opsiMenu1, 0, 1, Short.MAX_VALUE)))
                .addContainerGap())
        );
        PanelMenu1Layout.setVerticalGroup(
            PanelMenu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelMenu1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(picMenu1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblMenu1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addGroup(PanelMenu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblVarian1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(opsiMenu1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(PanelMenu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(addMenu1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(qtyMenu1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(16, 16, 16))
        );

        PanelMenu2.setBackground(new java.awt.Color(255, 255, 255));
        PanelMenu2.setPreferredSize(new java.awt.Dimension(160, 215));
        PanelMenu2.setRoundBottomLeft(8);
        PanelMenu2.setRoundBottomRight(8);
        PanelMenu2.setRoundTopLeft(8);
        PanelMenu2.setRoundTopRight(8);

        addMenu2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addMenu2ActionPerformed(evt);
            }
        });

        qtyMenu2.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        qtyMenu2.setBorder(null);
        qtyMenu2.setPreferredSize(new java.awt.Dimension(65, 23));
        qtyMenu2.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                qtyMenu2StateChanged(evt);
            }
        });

        lblVarian2.setFont(new java.awt.Font("Poppins Light", 1, 12)); // NOI18N
        lblVarian2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblVarian2.setText("Varian");

        lblMenu2.setFont(new java.awt.Font("Poppins SemiBold", 0, 14)); // NOI18N
        lblMenu2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblMenu2.setText("Chicken Combo");
        lblMenu2.setPreferredSize(new java.awt.Dimension(135, 20));

        picMenu2.setPreferredSize(new java.awt.Dimension(144, 100));

        opsiMenu2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Rare", "Medium rare", "Medium", "Medium well", "Welldone" }));
        opsiMenu2.setBorder(null);
        opsiMenu2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opsiMenu2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelMenu2Layout = new javax.swing.GroupLayout(PanelMenu2);
        PanelMenu2.setLayout(PanelMenu2Layout);
        PanelMenu2Layout.setHorizontalGroup(
            PanelMenu2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelMenu2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(qtyMenu2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(addMenu2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(PanelMenu2Layout.createSequentialGroup()
                .addContainerGap(8, Short.MAX_VALUE)
                .addComponent(picMenu2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(8, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelMenu2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelMenu2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblMenu2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(PanelMenu2Layout.createSequentialGroup()
                        .addComponent(lblVarian2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)
                        .addComponent(opsiMenu2, 0, 1, Short.MAX_VALUE)))
                .addContainerGap())
        );
        PanelMenu2Layout.setVerticalGroup(
            PanelMenu2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelMenu2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(picMenu2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblMenu2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addGroup(PanelMenu2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblVarian2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(opsiMenu2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(PanelMenu2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(addMenu2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(qtyMenu2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(16, 16, 16))
        );

        PanelMenu3.setBackground(new java.awt.Color(255, 255, 255));
        PanelMenu3.setPreferredSize(new java.awt.Dimension(160, 215));
        PanelMenu3.setRoundBottomLeft(8);
        PanelMenu3.setRoundBottomRight(8);
        PanelMenu3.setRoundTopLeft(8);
        PanelMenu3.setRoundTopRight(8);

        addMenu3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addMenu3ActionPerformed(evt);
            }
        });

        qtyMenu3.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        qtyMenu3.setBorder(null);
        qtyMenu3.setPreferredSize(new java.awt.Dimension(65, 23));
        qtyMenu3.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                qtyMenu3StateChanged(evt);
            }
        });

        lblVarian3.setFont(new java.awt.Font("Poppins Light", 1, 12)); // NOI18N
        lblVarian3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblVarian3.setText("Varian");

        lblMenu3.setFont(new java.awt.Font("Poppins SemiBold", 0, 14)); // NOI18N
        lblMenu3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblMenu3.setText("Combo  Meals");
        lblMenu3.setPreferredSize(new java.awt.Dimension(135, 20));

        picMenu3.setPreferredSize(new java.awt.Dimension(144, 100));

        opsiMenu3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Rare", "Medium rare", "Medium", "Medium well", "Welldone" }));
        opsiMenu3.setBorder(null);
        opsiMenu3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opsiMenu3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelMenu3Layout = new javax.swing.GroupLayout(PanelMenu3);
        PanelMenu3.setLayout(PanelMenu3Layout);
        PanelMenu3Layout.setHorizontalGroup(
            PanelMenu3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelMenu3Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(qtyMenu3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(addMenu3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(PanelMenu3Layout.createSequentialGroup()
                .addContainerGap(8, Short.MAX_VALUE)
                .addComponent(picMenu3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(8, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelMenu3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelMenu3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblMenu3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(PanelMenu3Layout.createSequentialGroup()
                        .addComponent(lblVarian3, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)
                        .addComponent(opsiMenu3, 0, 1, Short.MAX_VALUE)))
                .addContainerGap())
        );
        PanelMenu3Layout.setVerticalGroup(
            PanelMenu3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelMenu3Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(picMenu3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblMenu3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addGroup(PanelMenu3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblVarian3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(opsiMenu3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(PanelMenu3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(addMenu3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(qtyMenu3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16))
        );

        PanelMenu4.setBackground(new java.awt.Color(255, 255, 255));
        PanelMenu4.setPreferredSize(new java.awt.Dimension(160, 215));
        PanelMenu4.setRoundBottomLeft(8);
        PanelMenu4.setRoundBottomRight(8);
        PanelMenu4.setRoundTopLeft(8);
        PanelMenu4.setRoundTopRight(8);

        addMenu4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addMenu4ActionPerformed(evt);
            }
        });

        qtyMenu4.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        qtyMenu4.setBorder(null);
        qtyMenu4.setPreferredSize(new java.awt.Dimension(65, 23));
        qtyMenu4.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                qtyMenu4StateChanged(evt);
            }
        });

        lblVarian4.setFont(new java.awt.Font("Poppins Light", 1, 12)); // NOI18N
        lblVarian4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblVarian4.setText("Varian");

        lblMenu4.setFont(new java.awt.Font("Poppins SemiBold", 0, 14)); // NOI18N
        lblMenu4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblMenu4.setText("T-Bone Steak");
        lblMenu4.setPreferredSize(new java.awt.Dimension(135, 20));

        picMenu4.setPreferredSize(new java.awt.Dimension(144, 100));

        opsiMenu4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Rare", "Medium rare", "Medium", "Medium well", "Welldone" }));
        opsiMenu4.setBorder(null);
        opsiMenu4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opsiMenu4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelMenu4Layout = new javax.swing.GroupLayout(PanelMenu4);
        PanelMenu4.setLayout(PanelMenu4Layout);
        PanelMenu4Layout.setHorizontalGroup(
            PanelMenu4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelMenu4Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(qtyMenu4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(addMenu4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(PanelMenu4Layout.createSequentialGroup()
                .addContainerGap(8, Short.MAX_VALUE)
                .addComponent(picMenu4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(8, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelMenu4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelMenu4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblMenu4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(PanelMenu4Layout.createSequentialGroup()
                        .addComponent(lblVarian4, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)
                        .addComponent(opsiMenu4, 0, 1, Short.MAX_VALUE)))
                .addContainerGap())
        );
        PanelMenu4Layout.setVerticalGroup(
            PanelMenu4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelMenu4Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(picMenu4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblMenu4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addGroup(PanelMenu4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblVarian4, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(opsiMenu4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(PanelMenu4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(addMenu4, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(qtyMenu4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16))
        );

        PanelMenu5.setBackground(new java.awt.Color(255, 255, 255));
        PanelMenu5.setPreferredSize(new java.awt.Dimension(160, 215));
        PanelMenu5.setRoundBottomLeft(8);
        PanelMenu5.setRoundBottomRight(8);
        PanelMenu5.setRoundTopLeft(8);
        PanelMenu5.setRoundTopRight(8);

        addMenu5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addMenu5ActionPerformed(evt);
            }
        });

        qtyMenu5.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        qtyMenu5.setBorder(null);
        qtyMenu5.setPreferredSize(new java.awt.Dimension(65, 23));
        qtyMenu5.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                qtyMenu5StateChanged(evt);
            }
        });

        lblVarian5.setFont(new java.awt.Font("Poppins Light", 1, 12)); // NOI18N
        lblVarian5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblVarian5.setText("Varian");

        lblMenu5.setFont(new java.awt.Font("Poppins SemiBold", 0, 14)); // NOI18N
        lblMenu5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblMenu5.setText("Rib Eye Steak");
        lblMenu5.setPreferredSize(new java.awt.Dimension(135, 20));

        picMenu5.setPreferredSize(new java.awt.Dimension(144, 100));

        opsiMenu5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Rare", "Medium rare", "Medium", "Medium well", "Welldone" }));
        opsiMenu5.setBorder(null);
        opsiMenu5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opsiMenu5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelMenu5Layout = new javax.swing.GroupLayout(PanelMenu5);
        PanelMenu5.setLayout(PanelMenu5Layout);
        PanelMenu5Layout.setHorizontalGroup(
            PanelMenu5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelMenu5Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(qtyMenu5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(addMenu5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(PanelMenu5Layout.createSequentialGroup()
                .addContainerGap(8, Short.MAX_VALUE)
                .addComponent(picMenu5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(8, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelMenu5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelMenu5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblMenu5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(PanelMenu5Layout.createSequentialGroup()
                        .addComponent(lblVarian5, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)
                        .addComponent(opsiMenu5, 0, 1, Short.MAX_VALUE)))
                .addContainerGap())
        );
        PanelMenu5Layout.setVerticalGroup(
            PanelMenu5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelMenu5Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(picMenu5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblMenu5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addGroup(PanelMenu5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblVarian5, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(opsiMenu5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(PanelMenu5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(addMenu5, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(qtyMenu5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16))
        );

        PanelMenu8.setBackground(new java.awt.Color(255, 255, 255));
        PanelMenu8.setPreferredSize(new java.awt.Dimension(160, 215));
        PanelMenu8.setRoundBottomLeft(8);
        PanelMenu8.setRoundBottomRight(8);
        PanelMenu8.setRoundTopLeft(8);
        PanelMenu8.setRoundTopRight(8);

        addMenu8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addMenu8ActionPerformed(evt);
            }
        });

        qtyMenu8.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        qtyMenu8.setBorder(null);
        qtyMenu8.setPreferredSize(new java.awt.Dimension(65, 23));
        qtyMenu8.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                qtyMenu8StateChanged(evt);
            }
        });

        lblVarian8.setFont(new java.awt.Font("Poppins Light", 1, 12)); // NOI18N
        lblVarian8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblVarian8.setText("Varian");

        lblMenu8.setFont(new java.awt.Font("Poppins SemiBold", 0, 14)); // NOI18N
        lblMenu8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblMenu8.setText("Sirloin Steak");
        lblMenu8.setPreferredSize(new java.awt.Dimension(135, 20));

        picMenu8.setPreferredSize(new java.awt.Dimension(144, 100));

        opsiMenu8.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Rare", "Medium rare", "Medium", "Medium well", "Welldone" }));
        opsiMenu8.setBorder(null);
        opsiMenu8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opsiMenu8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelMenu8Layout = new javax.swing.GroupLayout(PanelMenu8);
        PanelMenu8.setLayout(PanelMenu8Layout);
        PanelMenu8Layout.setHorizontalGroup(
            PanelMenu8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelMenu8Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(qtyMenu8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(addMenu8)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(PanelMenu8Layout.createSequentialGroup()
                .addContainerGap(8, Short.MAX_VALUE)
                .addComponent(picMenu8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(8, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelMenu8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelMenu8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblMenu8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(PanelMenu8Layout.createSequentialGroup()
                        .addComponent(lblVarian8, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)
                        .addComponent(opsiMenu8, 0, 1, Short.MAX_VALUE)))
                .addContainerGap())
        );
        PanelMenu8Layout.setVerticalGroup(
            PanelMenu8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelMenu8Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(picMenu8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblMenu8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addGroup(PanelMenu8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblVarian8, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(opsiMenu8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(PanelMenu8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(addMenu8, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(qtyMenu8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16))
        );

        PanelMenu9.setBackground(new java.awt.Color(255, 255, 255));
        PanelMenu9.setPreferredSize(new java.awt.Dimension(160, 215));
        PanelMenu9.setRoundBottomLeft(8);
        PanelMenu9.setRoundBottomRight(8);
        PanelMenu9.setRoundTopLeft(8);
        PanelMenu9.setRoundTopRight(8);

        addMenu9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addMenu9ActionPerformed(evt);
            }
        });

        qtyMenu9.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        qtyMenu9.setBorder(null);
        qtyMenu9.setPreferredSize(new java.awt.Dimension(65, 23));
        qtyMenu9.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                qtyMenu9StateChanged(evt);
            }
        });

        lblVarian9.setFont(new java.awt.Font("Poppins Light", 1, 12)); // NOI18N
        lblVarian9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblVarian9.setText("Varian");

        lblMenu9.setFont(new java.awt.Font("Poppins SemiBold", 0, 14)); // NOI18N
        lblMenu9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblMenu9.setText("Tenderloin Steak");
        lblMenu9.setPreferredSize(new java.awt.Dimension(135, 20));

        picMenu9.setPreferredSize(new java.awt.Dimension(144, 100));

        opsiMenu9.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Rare", "Medium rare", "Medium", "Medium well", "Welldone" }));
        opsiMenu9.setBorder(null);
        opsiMenu9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opsiMenu9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelMenu9Layout = new javax.swing.GroupLayout(PanelMenu9);
        PanelMenu9.setLayout(PanelMenu9Layout);
        PanelMenu9Layout.setHorizontalGroup(
            PanelMenu9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelMenu9Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(qtyMenu9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(addMenu9)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(PanelMenu9Layout.createSequentialGroup()
                .addContainerGap(8, Short.MAX_VALUE)
                .addComponent(picMenu9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(8, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelMenu9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelMenu9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblMenu9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(PanelMenu9Layout.createSequentialGroup()
                        .addComponent(lblVarian9, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)
                        .addComponent(opsiMenu9, 0, 1, Short.MAX_VALUE)))
                .addContainerGap())
        );
        PanelMenu9Layout.setVerticalGroup(
            PanelMenu9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelMenu9Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(picMenu9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblMenu9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addGroup(PanelMenu9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblVarian9, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(opsiMenu9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(PanelMenu9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(addMenu9, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(qtyMenu9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16))
        );

        PanelMenu10.setBackground(new java.awt.Color(255, 255, 255));
        PanelMenu10.setPreferredSize(new java.awt.Dimension(160, 215));
        PanelMenu10.setRoundBottomLeft(8);
        PanelMenu10.setRoundBottomRight(8);
        PanelMenu10.setRoundTopLeft(8);
        PanelMenu10.setRoundTopRight(8);

        addMenu10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addMenu10ActionPerformed(evt);
            }
        });

        qtyMenu10.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        qtyMenu10.setBorder(null);
        qtyMenu10.setPreferredSize(new java.awt.Dimension(65, 23));
        qtyMenu10.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                qtyMenu10StateChanged(evt);
            }
        });

        lblVarian10.setFont(new java.awt.Font("Poppins Light", 1, 12)); // NOI18N
        lblVarian10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblVarian10.setText("Varian");

        lblMenu10.setFont(new java.awt.Font("Poppins SemiBold", 0, 14)); // NOI18N
        lblMenu10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblMenu10.setText("Tomahawk Steak");
        lblMenu10.setPreferredSize(new java.awt.Dimension(135, 20));

        picMenu10.setPreferredSize(new java.awt.Dimension(144, 100));

        opsiMenu10.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Rare", "Medium rare", "Medium", "Medium well", "Welldone" }));
        opsiMenu10.setBorder(null);
        opsiMenu10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opsiMenu10ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelMenu10Layout = new javax.swing.GroupLayout(PanelMenu10);
        PanelMenu10.setLayout(PanelMenu10Layout);
        PanelMenu10Layout.setHorizontalGroup(
            PanelMenu10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelMenu10Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(qtyMenu10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(addMenu10)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(PanelMenu10Layout.createSequentialGroup()
                .addContainerGap(8, Short.MAX_VALUE)
                .addComponent(picMenu10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(8, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelMenu10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelMenu10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblMenu10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(PanelMenu10Layout.createSequentialGroup()
                        .addComponent(lblVarian10, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)
                        .addComponent(opsiMenu10, 0, 1, Short.MAX_VALUE)))
                .addContainerGap())
        );
        PanelMenu10Layout.setVerticalGroup(
            PanelMenu10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelMenu10Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(picMenu10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblMenu10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addGroup(PanelMenu10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblVarian10, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(opsiMenu10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(PanelMenu10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(addMenu10, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(qtyMenu10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16))
        );

        PanelMenu11.setBackground(new java.awt.Color(255, 255, 255));
        PanelMenu11.setPreferredSize(new java.awt.Dimension(160, 215));
        PanelMenu11.setRoundBottomLeft(8);
        PanelMenu11.setRoundBottomRight(8);
        PanelMenu11.setRoundTopLeft(8);
        PanelMenu11.setRoundTopRight(8);

        addMenu11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addMenu11ActionPerformed(evt);
            }
        });

        qtyMenu11.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        qtyMenu11.setBorder(null);
        qtyMenu11.setPreferredSize(new java.awt.Dimension(65, 23));
        qtyMenu11.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                qtyMenu11StateChanged(evt);
            }
        });

        lblMenu11.setFont(new java.awt.Font("Poppins SemiBold", 0, 14)); // NOI18N
        lblMenu11.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblMenu11.setText("Espresso");
        lblMenu11.setPreferredSize(new java.awt.Dimension(135, 20));

        picMenu11.setPreferredSize(new java.awt.Dimension(144, 100));

        opsiMenu11.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sugar", "Less Sugar" }));
        opsiMenu11.setBorder(null);
        opsiMenu11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opsiMenu11ActionPerformed(evt);
            }
        });

        lblVarian11.setFont(new java.awt.Font("Poppins Light", 1, 12)); // NOI18N
        lblVarian11.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblVarian11.setText("Varian");

        javax.swing.GroupLayout PanelMenu11Layout = new javax.swing.GroupLayout(PanelMenu11);
        PanelMenu11.setLayout(PanelMenu11Layout);
        PanelMenu11Layout.setHorizontalGroup(
            PanelMenu11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelMenu11Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(qtyMenu11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(addMenu11)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(PanelMenu11Layout.createSequentialGroup()
                .addContainerGap(8, Short.MAX_VALUE)
                .addComponent(picMenu11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(8, Short.MAX_VALUE))
            .addGroup(PanelMenu11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelMenu11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblMenu11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(PanelMenu11Layout.createSequentialGroup()
                        .addComponent(lblVarian11, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)
                        .addComponent(opsiMenu11, 0, 1, Short.MAX_VALUE)))
                .addContainerGap())
        );
        PanelMenu11Layout.setVerticalGroup(
            PanelMenu11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelMenu11Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(picMenu11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblMenu11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelMenu11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblVarian11, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(opsiMenu11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addGroup(PanelMenu11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(addMenu11, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(qtyMenu11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16))
        );

        PanelMenu12.setBackground(new java.awt.Color(255, 255, 255));
        PanelMenu12.setPreferredSize(new java.awt.Dimension(160, 215));
        PanelMenu12.setRoundBottomLeft(8);
        PanelMenu12.setRoundBottomRight(8);
        PanelMenu12.setRoundTopLeft(8);
        PanelMenu12.setRoundTopRight(8);

        addMenu12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addMenu12ActionPerformed(evt);
            }
        });

        qtyMenu12.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        qtyMenu12.setBorder(null);
        qtyMenu12.setPreferredSize(new java.awt.Dimension(65, 23));
        qtyMenu12.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                qtyMenu12StateChanged(evt);
            }
        });

        lblMenu12.setFont(new java.awt.Font("Poppins SemiBold", 0, 14)); // NOI18N
        lblMenu12.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblMenu12.setText("Lemon Cucumber");
        lblMenu12.setPreferredSize(new java.awt.Dimension(135, 20));

        picMenu12.setPreferredSize(new java.awt.Dimension(144, 100));

        lblVarian12.setFont(new java.awt.Font("Poppins Light", 1, 12)); // NOI18N
        lblVarian12.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblVarian12.setText("Varian");

        opsiMenu12.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sugar", "Less Sugar" }));
        opsiMenu12.setBorder(null);
        opsiMenu12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opsiMenu12ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelMenu12Layout = new javax.swing.GroupLayout(PanelMenu12);
        PanelMenu12.setLayout(PanelMenu12Layout);
        PanelMenu12Layout.setHorizontalGroup(
            PanelMenu12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelMenu12Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(qtyMenu12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(addMenu12)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(PanelMenu12Layout.createSequentialGroup()
                .addContainerGap(8, Short.MAX_VALUE)
                .addComponent(picMenu12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(8, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelMenu12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelMenu12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblMenu12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelMenu12Layout.createSequentialGroup()
                        .addComponent(lblVarian12, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)
                        .addComponent(opsiMenu12, 0, 1, Short.MAX_VALUE)))
                .addContainerGap())
        );
        PanelMenu12Layout.setVerticalGroup(
            PanelMenu12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelMenu12Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(picMenu12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblMenu12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelMenu12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblVarian12, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(opsiMenu12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addGroup(PanelMenu12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(addMenu12, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(qtyMenu12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16))
        );

        PanelMenu13.setBackground(new java.awt.Color(255, 255, 255));
        PanelMenu13.setPreferredSize(new java.awt.Dimension(160, 215));
        PanelMenu13.setRoundBottomLeft(8);
        PanelMenu13.setRoundBottomRight(8);
        PanelMenu13.setRoundTopLeft(8);
        PanelMenu13.setRoundTopRight(8);

        addMenu13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addMenu13ActionPerformed(evt);
            }
        });

        qtyMenu13.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        qtyMenu13.setBorder(null);
        qtyMenu13.setPreferredSize(new java.awt.Dimension(65, 23));
        qtyMenu13.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                qtyMenu13StateChanged(evt);
            }
        });

        lblMenu13.setFont(new java.awt.Font("Poppins SemiBold", 0, 14)); // NOI18N
        lblMenu13.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblMenu13.setText("Perrier");
        lblMenu13.setPreferredSize(new java.awt.Dimension(135, 20));

        picMenu13.setPreferredSize(new java.awt.Dimension(144, 100));

        lblVarian13.setFont(new java.awt.Font("Poppins Light", 1, 12)); // NOI18N
        lblVarian13.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblVarian13.setText("Varian");

        opsiMenu13.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sugar", "Less Sugar" }));
        opsiMenu13.setBorder(null);
        opsiMenu13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opsiMenu13ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelMenu13Layout = new javax.swing.GroupLayout(PanelMenu13);
        PanelMenu13.setLayout(PanelMenu13Layout);
        PanelMenu13Layout.setHorizontalGroup(
            PanelMenu13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelMenu13Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(qtyMenu13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(addMenu13)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(PanelMenu13Layout.createSequentialGroup()
                .addContainerGap(8, Short.MAX_VALUE)
                .addComponent(picMenu13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(8, Short.MAX_VALUE))
            .addGroup(PanelMenu13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelMenu13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblMenu13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(PanelMenu13Layout.createSequentialGroup()
                        .addComponent(lblVarian13, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)
                        .addComponent(opsiMenu13, 0, 1, Short.MAX_VALUE)))
                .addContainerGap())
        );
        PanelMenu13Layout.setVerticalGroup(
            PanelMenu13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelMenu13Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(picMenu13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblMenu13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addGroup(PanelMenu13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblVarian13, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(opsiMenu13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelMenu13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(addMenu13, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(qtyMenu13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16))
        );

        PanelMenu14.setBackground(new java.awt.Color(255, 255, 255));
        PanelMenu14.setPreferredSize(new java.awt.Dimension(160, 215));
        PanelMenu14.setRoundBottomLeft(8);
        PanelMenu14.setRoundBottomRight(8);
        PanelMenu14.setRoundTopLeft(8);
        PanelMenu14.setRoundTopRight(8);

        addMenu14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addMenu14ActionPerformed(evt);
            }
        });

        qtyMenu14.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        qtyMenu14.setBorder(null);
        qtyMenu14.setPreferredSize(new java.awt.Dimension(65, 23));
        qtyMenu14.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                qtyMenu14StateChanged(evt);
            }
        });

        lblMenu14.setFont(new java.awt.Font("Poppins SemiBold", 0, 14)); // NOI18N
        lblMenu14.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblMenu14.setText("Strawberry Lemon");
        lblMenu14.setPreferredSize(new java.awt.Dimension(135, 20));

        picMenu14.setPreferredSize(new java.awt.Dimension(144, 100));

        opsiMenu14.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sugar", "Less Sugar" }));
        opsiMenu14.setBorder(null);
        opsiMenu14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opsiMenu14ActionPerformed(evt);
            }
        });

        lblVarian14.setFont(new java.awt.Font("Poppins Light", 1, 12)); // NOI18N
        lblVarian14.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblVarian14.setText("Varian");

        javax.swing.GroupLayout PanelMenu14Layout = new javax.swing.GroupLayout(PanelMenu14);
        PanelMenu14.setLayout(PanelMenu14Layout);
        PanelMenu14Layout.setHorizontalGroup(
            PanelMenu14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelMenu14Layout.createSequentialGroup()
                .addGroup(PanelMenu14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelMenu14Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(PanelMenu14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblMenu14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(PanelMenu14Layout.createSequentialGroup()
                                .addComponent(lblVarian14, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(16, 16, 16)
                                .addComponent(opsiMenu14, 0, 89, Short.MAX_VALUE))))
                    .addGroup(PanelMenu14Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(qtyMenu14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(addMenu14)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(PanelMenu14Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(picMenu14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        PanelMenu14Layout.setVerticalGroup(
            PanelMenu14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelMenu14Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(picMenu14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblMenu14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addGroup(PanelMenu14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblVarian14, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(opsiMenu14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelMenu14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(addMenu14, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(qtyMenu14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16))
        );

        PanelMenu15.setBackground(new java.awt.Color(255, 255, 255));
        PanelMenu15.setPreferredSize(new java.awt.Dimension(160, 215));
        PanelMenu15.setRoundBottomLeft(8);
        PanelMenu15.setRoundBottomRight(8);
        PanelMenu15.setRoundTopLeft(8);
        PanelMenu15.setRoundTopRight(8);

        addMenu15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addMenu15ActionPerformed(evt);
            }
        });

        qtyMenu15.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        qtyMenu15.setBorder(null);
        qtyMenu15.setPreferredSize(new java.awt.Dimension(65, 23));
        qtyMenu15.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                qtyMenu15StateChanged(evt);
            }
        });

        lblMenu15.setFont(new java.awt.Font("Poppins SemiBold", 0, 14)); // NOI18N
        lblMenu15.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblMenu15.setText("Virgin Mojito");
        lblMenu15.setPreferredSize(new java.awt.Dimension(135, 20));

        picMenu15.setPreferredSize(new java.awt.Dimension(144, 100));

        lblVarian15.setFont(new java.awt.Font("Poppins Light", 1, 12)); // NOI18N
        lblVarian15.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblVarian15.setText("Varian");

        opsiMenu15.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sugar", "Less Sugar" }));
        opsiMenu15.setBorder(null);
        opsiMenu15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opsiMenu15ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelMenu15Layout = new javax.swing.GroupLayout(PanelMenu15);
        PanelMenu15.setLayout(PanelMenu15Layout);
        PanelMenu15Layout.setHorizontalGroup(
            PanelMenu15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelMenu15Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(qtyMenu15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(addMenu15)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(PanelMenu15Layout.createSequentialGroup()
                .addContainerGap(8, Short.MAX_VALUE)
                .addComponent(picMenu15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(8, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelMenu15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelMenu15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblMenu15, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelMenu15Layout.createSequentialGroup()
                        .addComponent(lblVarian15, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)
                        .addComponent(opsiMenu15, 0, 1, Short.MAX_VALUE)))
                .addContainerGap())
        );
        PanelMenu15Layout.setVerticalGroup(
            PanelMenu15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelMenu15Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(picMenu15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblMenu15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addGroup(PanelMenu15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblVarian15, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(opsiMenu15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelMenu15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(addMenu15, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(qtyMenu15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16))
        );

        PanelMenu16.setBackground(new java.awt.Color(255, 255, 255));
        PanelMenu16.setPreferredSize(new java.awt.Dimension(160, 215));
        PanelMenu16.setRoundBottomLeft(8);
        PanelMenu16.setRoundBottomRight(8);
        PanelMenu16.setRoundTopLeft(8);
        PanelMenu16.setRoundTopRight(8);

        addMenu16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addMenu16ActionPerformed(evt);
            }
        });

        qtyMenu16.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        qtyMenu16.setBorder(null);
        qtyMenu16.setPreferredSize(new java.awt.Dimension(65, 23));
        qtyMenu16.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                qtyMenu16StateChanged(evt);
            }
        });

        lblMenu16.setFont(new java.awt.Font("Poppins SemiBold", 0, 14)); // NOI18N
        lblMenu16.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblMenu16.setText("Apple Crumble");
        lblMenu16.setPreferredSize(new java.awt.Dimension(135, 20));

        picMenu16.setPreferredSize(new java.awt.Dimension(144, 100));

        lblVarian16.setFont(new java.awt.Font("Poppins Light", 1, 12)); // NOI18N
        lblVarian16.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblVarian16.setText("Varian");

        opsiMenu16.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sugar", "Less Sugar" }));
        opsiMenu16.setBorder(null);
        opsiMenu16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opsiMenu16ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelMenu16Layout = new javax.swing.GroupLayout(PanelMenu16);
        PanelMenu16.setLayout(PanelMenu16Layout);
        PanelMenu16Layout.setHorizontalGroup(
            PanelMenu16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelMenu16Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(qtyMenu16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(addMenu16)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(PanelMenu16Layout.createSequentialGroup()
                .addContainerGap(8, Short.MAX_VALUE)
                .addComponent(picMenu16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(8, Short.MAX_VALUE))
            .addGroup(PanelMenu16Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelMenu16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblMenu16, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(PanelMenu16Layout.createSequentialGroup()
                        .addComponent(lblVarian16, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)
                        .addComponent(opsiMenu16, 0, 1, Short.MAX_VALUE)))
                .addContainerGap())
        );
        PanelMenu16Layout.setVerticalGroup(
            PanelMenu16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelMenu16Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(picMenu16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblMenu16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addGroup(PanelMenu16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblVarian16, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(opsiMenu16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelMenu16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(addMenu16, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(qtyMenu16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16))
        );

        PanelMenu17.setBackground(new java.awt.Color(255, 255, 255));
        PanelMenu17.setPreferredSize(new java.awt.Dimension(160, 215));
        PanelMenu17.setRoundBottomLeft(8);
        PanelMenu17.setRoundBottomRight(8);
        PanelMenu17.setRoundTopLeft(8);
        PanelMenu17.setRoundTopRight(8);

        addMenu17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addMenu17ActionPerformed(evt);
            }
        });

        qtyMenu17.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        qtyMenu17.setBorder(null);
        qtyMenu17.setPreferredSize(new java.awt.Dimension(65, 23));
        qtyMenu17.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                qtyMenu17StateChanged(evt);
            }
        });

        lblMenu17.setFont(new java.awt.Font("Poppins SemiBold", 0, 14)); // NOI18N
        lblMenu17.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblMenu17.setText("Cheesecake");
        lblMenu17.setPreferredSize(new java.awt.Dimension(135, 20));

        picMenu17.setPreferredSize(new java.awt.Dimension(144, 100));

        opsiMenu17.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sugar", "Less Sugar" }));
        opsiMenu17.setBorder(null);
        opsiMenu17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opsiMenu17ActionPerformed(evt);
            }
        });

        lblVarian17.setFont(new java.awt.Font("Poppins Light", 1, 12)); // NOI18N
        lblVarian17.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblVarian17.setText("Varian");

        javax.swing.GroupLayout PanelMenu17Layout = new javax.swing.GroupLayout(PanelMenu17);
        PanelMenu17.setLayout(PanelMenu17Layout);
        PanelMenu17Layout.setHorizontalGroup(
            PanelMenu17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelMenu17Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(qtyMenu17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(addMenu17)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(PanelMenu17Layout.createSequentialGroup()
                .addContainerGap(8, Short.MAX_VALUE)
                .addComponent(picMenu17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(8, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelMenu17Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelMenu17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblMenu17, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelMenu17Layout.createSequentialGroup()
                        .addComponent(lblVarian17, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)
                        .addComponent(opsiMenu17, 0, 1, Short.MAX_VALUE)))
                .addContainerGap())
        );
        PanelMenu17Layout.setVerticalGroup(
            PanelMenu17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelMenu17Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(picMenu17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblMenu17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addGroup(PanelMenu17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblVarian17, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(opsiMenu17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelMenu17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(addMenu17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(qtyMenu17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(16, 16, 16))
        );

        PanelMenu18.setBackground(new java.awt.Color(255, 255, 255));
        PanelMenu18.setPreferredSize(new java.awt.Dimension(160, 215));
        PanelMenu18.setRoundBottomLeft(8);
        PanelMenu18.setRoundBottomRight(8);
        PanelMenu18.setRoundTopLeft(8);
        PanelMenu18.setRoundTopRight(8);

        addMenu18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addMenu18ActionPerformed(evt);
            }
        });

        qtyMenu18.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        qtyMenu18.setBorder(null);
        qtyMenu18.setPreferredSize(new java.awt.Dimension(65, 23));
        qtyMenu18.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                qtyMenu18StateChanged(evt);
            }
        });

        lblMenu18.setFont(new java.awt.Font("Poppins SemiBold", 0, 14)); // NOI18N
        lblMenu18.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblMenu18.setText("Chocolate Lava Cake");
        lblMenu18.setPreferredSize(new java.awt.Dimension(135, 20));

        picMenu18.setPreferredSize(new java.awt.Dimension(144, 100));

        lblVarian18.setFont(new java.awt.Font("Poppins Light", 1, 12)); // NOI18N
        lblVarian18.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblVarian18.setText("Varian");

        opsiMenu18.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sugar", "Less Sugar" }));
        opsiMenu18.setBorder(null);
        opsiMenu18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opsiMenu18ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelMenu18Layout = new javax.swing.GroupLayout(PanelMenu18);
        PanelMenu18.setLayout(PanelMenu18Layout);
        PanelMenu18Layout.setHorizontalGroup(
            PanelMenu18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelMenu18Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(qtyMenu18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(addMenu18)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(PanelMenu18Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(picMenu18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelMenu18Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelMenu18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblMenu18, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelMenu18Layout.createSequentialGroup()
                        .addComponent(lblVarian18, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)
                        .addComponent(opsiMenu18, 0, 1, Short.MAX_VALUE)))
                .addContainerGap())
        );
        PanelMenu18Layout.setVerticalGroup(
            PanelMenu18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelMenu18Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(picMenu18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblMenu18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addGroup(PanelMenu18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblVarian18, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(opsiMenu18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelMenu18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(addMenu18, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(qtyMenu18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16))
        );

        PanelMenu19.setBackground(new java.awt.Color(255, 255, 255));
        PanelMenu19.setPreferredSize(new java.awt.Dimension(160, 215));
        PanelMenu19.setRoundBottomLeft(8);
        PanelMenu19.setRoundBottomRight(8);
        PanelMenu19.setRoundTopLeft(8);
        PanelMenu19.setRoundTopRight(8);

        addMenu19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addMenu19ActionPerformed(evt);
            }
        });

        qtyMenu19.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        qtyMenu19.setBorder(null);
        qtyMenu19.setPreferredSize(new java.awt.Dimension(65, 23));
        qtyMenu19.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                qtyMenu19StateChanged(evt);
            }
        });

        lblMenu19.setFont(new java.awt.Font("Poppins SemiBold", 0, 14)); // NOI18N
        lblMenu19.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblMenu19.setText("Tiramisu");
        lblMenu19.setPreferredSize(new java.awt.Dimension(135, 20));

        picMenu19.setPreferredSize(new java.awt.Dimension(144, 100));

        lblVarian19.setFont(new java.awt.Font("Poppins Light", 1, 12)); // NOI18N
        lblVarian19.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblVarian19.setText("Varian");

        opsiMenu19.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sugar", "Less Sugar" }));
        opsiMenu19.setBorder(null);
        opsiMenu19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opsiMenu19ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelMenu19Layout = new javax.swing.GroupLayout(PanelMenu19);
        PanelMenu19.setLayout(PanelMenu19Layout);
        PanelMenu19Layout.setHorizontalGroup(
            PanelMenu19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelMenu19Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(qtyMenu19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(addMenu19)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(PanelMenu19Layout.createSequentialGroup()
                .addContainerGap(8, Short.MAX_VALUE)
                .addComponent(picMenu19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(8, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelMenu19Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelMenu19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblMenu19, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelMenu19Layout.createSequentialGroup()
                        .addComponent(lblVarian19, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)
                        .addComponent(opsiMenu19, 0, 1, Short.MAX_VALUE)))
                .addContainerGap())
        );
        PanelMenu19Layout.setVerticalGroup(
            PanelMenu19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelMenu19Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(picMenu19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblMenu19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addGroup(PanelMenu19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblVarian19, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(opsiMenu19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelMenu19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(addMenu19, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(qtyMenu19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16))
        );

        PanelMenu20.setBackground(new java.awt.Color(255, 255, 255));
        PanelMenu20.setPreferredSize(new java.awt.Dimension(160, 215));
        PanelMenu20.setRoundBottomLeft(8);
        PanelMenu20.setRoundBottomRight(8);
        PanelMenu20.setRoundTopLeft(8);
        PanelMenu20.setRoundTopRight(8);

        addMenu20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addMenu20ActionPerformed(evt);
            }
        });

        qtyMenu20.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        qtyMenu20.setBorder(null);
        qtyMenu20.setPreferredSize(new java.awt.Dimension(65, 23));
        qtyMenu20.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                qtyMenu20StateChanged(evt);
            }
        });

        lblMenu20.setFont(new java.awt.Font("Poppins SemiBold", 0, 14)); // NOI18N
        lblMenu20.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblMenu20.setText("Creme Brulee");
        lblMenu20.setPreferredSize(new java.awt.Dimension(135, 20));

        picMenu20.setPreferredSize(new java.awt.Dimension(144, 100));

        opsiMenu20.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sugar", "Less Sugar" }));
        opsiMenu20.setBorder(null);
        opsiMenu20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opsiMenu20ActionPerformed(evt);
            }
        });

        lblVarian20.setFont(new java.awt.Font("Poppins Light", 1, 12)); // NOI18N
        lblVarian20.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblVarian20.setText("Varian");

        javax.swing.GroupLayout PanelMenu20Layout = new javax.swing.GroupLayout(PanelMenu20);
        PanelMenu20.setLayout(PanelMenu20Layout);
        PanelMenu20Layout.setHorizontalGroup(
            PanelMenu20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelMenu20Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(qtyMenu20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(addMenu20)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(PanelMenu20Layout.createSequentialGroup()
                .addContainerGap(8, Short.MAX_VALUE)
                .addComponent(picMenu20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(8, Short.MAX_VALUE))
            .addGroup(PanelMenu20Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelMenu20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblMenu20, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(PanelMenu20Layout.createSequentialGroup()
                        .addComponent(lblVarian20, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)
                        .addComponent(opsiMenu20, 0, 1, Short.MAX_VALUE)))
                .addContainerGap())
        );
        PanelMenu20Layout.setVerticalGroup(
            PanelMenu20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelMenu20Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(picMenu20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblMenu20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addGroup(PanelMenu20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblVarian20, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(opsiMenu20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelMenu20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(addMenu20, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(qtyMenu20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16))
        );

        javax.swing.GroupLayout menuPanelLayout = new javax.swing.GroupLayout(menuPanel);
        menuPanel.setLayout(menuPanelLayout);
        menuPanelLayout.setHorizontalGroup(
            menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuPanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(menuPanelLayout.createSequentialGroup()
                        .addComponent(PanelMenu1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(PanelMenu2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(PanelMenu3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(PanelMenu4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(PanelMenu5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(PanelMenu8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(menuPanelLayout.createSequentialGroup()
                        .addComponent(PanelMenu9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(PanelMenu10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(PanelMenu11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(PanelMenu12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(PanelMenu13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(PanelMenu14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(menuPanelLayout.createSequentialGroup()
                        .addComponent(PanelMenu15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(PanelMenu16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(PanelMenu17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(PanelMenu18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(PanelMenu19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(PanelMenu20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(20, 20, 20)
                .addComponent(rightPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        menuPanelLayout.setVerticalGroup(
            menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuPanelLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PanelMenu8, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PanelMenu5, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PanelMenu4, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PanelMenu3, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PanelMenu2, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PanelMenu1, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PanelMenu9, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PanelMenu10, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PanelMenu11, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PanelMenu12, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PanelMenu13, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PanelMenu14, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PanelMenu15, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PanelMenu16, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PanelMenu17, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PanelMenu18, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PanelMenu19, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PanelMenu20, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(menuPanelLayout.createSequentialGroup()
                .addComponent(rightPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 718, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layerDasarHomeLayout = new javax.swing.GroupLayout(layerDasarHome);
        layerDasarHome.setLayout(layerDasarHomeLayout);
        layerDasarHomeLayout.setHorizontalGroup(
            layerDasarHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layerDasarHomeLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(layerDasarHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layerDasarHomeLayout.createSequentialGroup()
                        .addComponent(leftPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(menuPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(topPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0))
        );
        layerDasarHomeLayout.setVerticalGroup(
            layerDasarHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layerDasarHomeLayout.createSequentialGroup()
                .addComponent(topPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layerDasarHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(menuPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(leftPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 718, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(layerDasarHome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(layerDasarHome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addMenu1ActionPerformed
        prosesOrder(qtyMenu1, addMenu1, lblMenu1, opsiMenu1, 105);
    }//GEN-LAST:event_addMenu1ActionPerformed

    private void opsiMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opsiMenu1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_opsiMenu1ActionPerformed

    private void outputKembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_outputKembaliActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_outputKembaliActionPerformed

    private void inputTunaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputTunaiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputTunaiActionPerformed

    private void topPanelMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_topPanelMouseDragged
        // TODO add your handling code here:
    }//GEN-LAST:event_topPanelMouseDragged

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        setExtendedState(HomePage.MAXIMIZED_BOTH);
    }//GEN-LAST:event_formComponentShown

    private void qtyMenu1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_qtyMenu1StateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_qtyMenu1StateChanged

    private void OrderPageBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OrderPageBtnActionPerformed
        new OrderPage().setVisible(true);
        dispose();
    }//GEN-LAST:event_OrderPageBtnActionPerformed

    private void ReportsPageBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReportsPageBtnActionPerformed
        new Reports().setVisible(true);
        dispose();
    }//GEN-LAST:event_ReportsPageBtnActionPerformed

    private void ManagePageBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ManagePageBtnActionPerformed
        new Manage().setVisible(true);
        dispose();
    }//GEN-LAST:event_ManagePageBtnActionPerformed

    private void addMenu2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addMenu2ActionPerformed
        prosesOrder(qtyMenu2, addMenu2, lblMenu2, opsiMenu2, 106);
    }//GEN-LAST:event_addMenu2ActionPerformed

    private void qtyMenu2StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_qtyMenu2StateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_qtyMenu2StateChanged

    private void opsiMenu2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opsiMenu2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_opsiMenu2ActionPerformed

    private void addMenu3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addMenu3ActionPerformed
        prosesOrder(qtyMenu3, addMenu3, lblMenu3, opsiMenu3, 107);
    }//GEN-LAST:event_addMenu3ActionPerformed

    private void qtyMenu3StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_qtyMenu3StateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_qtyMenu3StateChanged

    private void opsiMenu3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opsiMenu3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_opsiMenu3ActionPerformed

    private void addMenu4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addMenu4ActionPerformed
        prosesOrder(qtyMenu4, addMenu4, lblMenu4, opsiMenu4, 103);
    }//GEN-LAST:event_addMenu4ActionPerformed

    private void qtyMenu4StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_qtyMenu4StateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_qtyMenu4StateChanged

    private void opsiMenu4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opsiMenu4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_opsiMenu4ActionPerformed

    private void addMenu5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addMenu5ActionPerformed
        prosesOrder(qtyMenu5, addMenu5, lblMenu5, opsiMenu5, 100);
    }//GEN-LAST:event_addMenu5ActionPerformed

    private void qtyMenu5StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_qtyMenu5StateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_qtyMenu5StateChanged

    private void opsiMenu5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opsiMenu5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_opsiMenu5ActionPerformed

    private void addMenu8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addMenu8ActionPerformed
        prosesOrder(qtyMenu8, addMenu8, lblMenu8, opsiMenu8, 101);
    }//GEN-LAST:event_addMenu8ActionPerformed

    private void qtyMenu8StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_qtyMenu8StateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_qtyMenu8StateChanged

    private void opsiMenu8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opsiMenu8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_opsiMenu8ActionPerformed

    private void addMenu9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addMenu9ActionPerformed
        prosesOrder(qtyMenu9, addMenu9, lblMenu9, opsiMenu9, 102);
    }//GEN-LAST:event_addMenu9ActionPerformed

    private void qtyMenu9StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_qtyMenu9StateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_qtyMenu9StateChanged

    private void opsiMenu9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opsiMenu9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_opsiMenu9ActionPerformed

    private void addMenu10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addMenu10ActionPerformed
        prosesOrder(qtyMenu10, addMenu10, lblMenu10, opsiMenu10, 104);
    }//GEN-LAST:event_addMenu10ActionPerformed

    private void qtyMenu10StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_qtyMenu10StateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_qtyMenu10StateChanged

    private void opsiMenu10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opsiMenu10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_opsiMenu10ActionPerformed

    private void addMenu11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addMenu11ActionPerformed
        prosesOrder(qtyMenu11, addMenu11, lblMenu11, opsiMenu11, 53);
    }//GEN-LAST:event_addMenu11ActionPerformed

    private void qtyMenu11StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_qtyMenu11StateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_qtyMenu11StateChanged

    private void addMenu12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addMenu12ActionPerformed
        prosesOrder(qtyMenu12, addMenu12, lblMenu12, opsiMenu12, 54);
    }//GEN-LAST:event_addMenu12ActionPerformed

    private void qtyMenu12StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_qtyMenu12StateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_qtyMenu12StateChanged

    private void addMenu13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addMenu13ActionPerformed
        prosesOrder(qtyMenu13, addMenu13, lblMenu13, opsiMenu13, 55);
    }//GEN-LAST:event_addMenu13ActionPerformed

    private void qtyMenu13StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_qtyMenu13StateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_qtyMenu13StateChanged

    private void addMenu14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addMenu14ActionPerformed
        prosesOrder(qtyMenu14, addMenu14, lblMenu14, opsiMenu14, 52);
    }//GEN-LAST:event_addMenu14ActionPerformed

    private void qtyMenu14StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_qtyMenu14StateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_qtyMenu14StateChanged

    private void addMenu15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addMenu15ActionPerformed
        prosesOrder(qtyMenu15, addMenu15, lblMenu15, opsiMenu15, 51);
    }//GEN-LAST:event_addMenu15ActionPerformed

    private void qtyMenu15StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_qtyMenu15StateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_qtyMenu15StateChanged

    private void addMenu16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addMenu16ActionPerformed
        prosesOrder(qtyMenu16, addMenu16, lblMenu16, opsiMenu16, 15);
    }//GEN-LAST:event_addMenu16ActionPerformed

    private void qtyMenu16StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_qtyMenu16StateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_qtyMenu16StateChanged

    private void addMenu17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addMenu17ActionPerformed
        prosesOrder(qtyMenu17, addMenu17, lblMenu17, opsiMenu17, 12);
    }//GEN-LAST:event_addMenu17ActionPerformed

    private void qtyMenu17StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_qtyMenu17StateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_qtyMenu17StateChanged

    private void addMenu18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addMenu18ActionPerformed
        prosesOrder(qtyMenu18, addMenu18, lblMenu18, opsiMenu18, 11);
    }//GEN-LAST:event_addMenu18ActionPerformed

    private void qtyMenu18StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_qtyMenu18StateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_qtyMenu18StateChanged

    private void addMenu19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addMenu19ActionPerformed
        prosesOrder(qtyMenu19, addMenu19, lblMenu19, opsiMenu19, 13);
    }//GEN-LAST:event_addMenu19ActionPerformed

    private void qtyMenu19StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_qtyMenu19StateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_qtyMenu19StateChanged

    private void addMenu20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addMenu20ActionPerformed
        prosesOrder(qtyMenu20, addMenu20, lblMenu20, opsiMenu20, 14);
    }//GEN-LAST:event_addMenu20ActionPerformed

    private void qtyMenu20StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_qtyMenu20StateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_qtyMenu20StateChanged

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        reset();
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintActionPerformed
        try {
            JTextArea printTextArea = new JTextArea();
            printTextArea.setText(jTextAreaOrder.getText());
            printTextArea.setFont(new java.awt.Font("Consolas", java.awt.Font.PLAIN, 9));
            
            printTextArea.print();
        } catch (PrinterException ex) {
            Logger.getLogger(HomePage.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnPrintActionPerformed


    private void btnBayarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBayarActionPerformed
        int tunai = Integer.parseInt(inputTunai.getText());
        kembali = tunai - total;

        if (tunai == 0) {
            JOptionPane.showMessageDialog(null, "Masukkan nominal tunai");
            return;
        } else if (kembali < 0) {
            JOptionPane.showMessageDialog(null, "Uang tunai tidak mencukupi");
            return;
        }

        String inputMeja = this.inputMeja.getText().trim(); // Ambil input No Meja
        String namaPelanggan = this.inputNamaPel.getText().trim(); // Ambil input Nama Pelanggan

        if (inputMeja.isEmpty() || namaPelanggan.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Harap lengkapi semua input (No Meja, Nama Pelanggan)!");
            return;
        }

        // Ambil ID Staff dari session
        String inputIDStaff = Session.getLoggedInStaffID();

        if (inputIDStaff == null || inputIDStaff.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Sesi ID Staff tidak ditemukan. Harap login ulang.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Set nilai ID Staff ke kolom output
        sesiIDStaff.setText(String.valueOf(inputIDStaff));

        try (Connection conn = DBConnection.getConnection()) {
            // Validasi ID Staff
            String queryStaff = "SELECT * FROM tb_staff WHERE id_staff = ?";
            PreparedStatement stmtStaff = conn.prepareStatement(queryStaff);
            stmtStaff.setString(1, inputIDStaff);

            ResultSet rsStaff = stmtStaff.executeQuery();
            if (!rsStaff.next()) {
                JOptionPane.showMessageDialog(null, "ID Staff tidak valid!");
                return;
            }
            String namaStaff = rsStaff.getString("nama");

            // Validasi Meja
            String queryMeja = "SELECT * FROM tb_meja WHERE id_meja = ?";
            PreparedStatement stmtMeja = conn.prepareStatement(queryMeja);
            stmtMeja.setString(1, inputMeja);

            ResultSet rsMeja = stmtMeja.executeQuery();

            if (rsMeja.next()) {
                int statusMeja = rsMeja.getInt("status");
                String namaMeja = rsMeja.getString("nama");

                if (statusMeja == 0) {
                    JOptionPane.showMessageDialog(null, "Meja tidak tersedia!");
                    return;
                }

                // Totalkan qty untuk semua pesanan
                int totalQty = 0;
                for (Map<String, Object> order : orders) {
                    totalQty += (int) order.get("qty");
                }

                // Format tanggal dan waktu untuk ID Transaksi
                SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyyyHHmm");
                Date date = new Date(); // Tanggal dan waktu saat ini
                String idTransaksi = "TRX" + formatter.format(date); // Gabungkan prefix dengan tanggal-waktu

                // Tambahkan transaksi ke database tb_transaksi untuk setiap produk
                String queryInsertTransaksi = "INSERT INTO tb_transaksi (id_transaksi, id_staff, id_produk, id_meja, nama_pel, tgl_transaksi, qty, subtotal, ppn, total_harga, tunai, kembalian, status) VALUES (?, ?, ?, ?, ?, NOW(), ?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement stmtInsertTransaksi = conn.prepareStatement(queryInsertTransaksi);

                for (Map<String, Object> order : orders) {
                    stmtInsertTransaksi.setString(1, idTransaksi); // Menggunakan ID Transaksi yang sama
                    stmtInsertTransaksi.setString(2, inputIDStaff); // ID Staff dari sesi
                    stmtInsertTransaksi.setInt(3, (int) order.get("id_produk")); // ID Produk
                    stmtInsertTransaksi.setString(4, inputMeja); // ID Meja
                    stmtInsertTransaksi.setString(5, namaPelanggan); // Nama Pelanggan
                    stmtInsertTransaksi.setInt(6, (int) order.get("qty")); // Qty
                    stmtInsertTransaksi.setInt(7, subtotal); // Subtotal
                    stmtInsertTransaksi.setInt(8, PPN); // PPN
                    stmtInsertTransaksi.setInt(9, total); // Total Harga
                    stmtInsertTransaksi.setInt(10, tunai); // Tunai
                    stmtInsertTransaksi.setInt(11, kembali); // Kembalian
                    stmtInsertTransaksi.setInt(12, 0); // Status
                    stmtInsertTransaksi.executeUpdate();
                }

                // Update status meja menjadi tidak tersedia
                String queryUpdateMeja = "UPDATE tb_meja SET status = 0 WHERE id_meja = ?";
                PreparedStatement stmtUpdateMeja = conn.prepareStatement(queryUpdateMeja);
                stmtUpdateMeja.setString(1, inputMeja);
                stmtUpdateMeja.executeUpdate();

                // Update status transaksi menjadi selesai
                String queryUpdateStatus = "UPDATE tb_transaksi SET status = 1 WHERE id_transaksi = ?";
                PreparedStatement stmtUpdateStatus = conn.prepareStatement(queryUpdateStatus);
                stmtUpdateStatus.setString(1, idTransaksi);
                stmtUpdateStatus.executeUpdate();

                // Set nilai kembalian ke kolom output
                outputKembali.setText(String.valueOf(kembali));

                // Kurangi stok produk di database
                for (Map<String, Object> order : orders) {
                    String queryUpdateStok = "UPDATE tb_produk SET stok = ? WHERE id_produk = ?";
                    PreparedStatement stmtUpdateStok = conn.prepareStatement(queryUpdateStok);
                    stmtUpdateStok.setInt(1, (int) order.get("stok_akhir"));
                    stmtUpdateStok.setInt(2, (int) order.get("id_produk"));
                    stmtUpdateStok.executeUpdate();
                }

                JOptionPane.showMessageDialog(null, "Transaksi berhasil!");

                // Reset pesanan setelah pembayaran
                orders.clear();
                jTextAreaOrder.setText(jTextAreaOrder.getText() + "\n\n****************************************************\n"
                        + "id: " + idTransaksi + "\n"
                        + "Meja: " + inputMeja + " (" + namaMeja + ")\n"
                        + "Staff: " + namaStaff + "\n"
                        + "Pelanggan: " + namaPelanggan + "\n"
                        + "Total Qty: " + totalQty + "\n"
                        + "\nSubtotal: \t\t\t\t" + subtotal + "\nPajak 12%: \t\t\t\t" + PPN + "\nTotal: \t\t\t\t\t" + total + "\nTunai: \t\t\t\t\t" + tunai + "\nKembali: \t\t\t\t" + kembali
                        + "\n********************* Thank You *********************\n");
                btnBayar.setEnabled(false);
                btnPrint.setEnabled(true);

            } else {
                JOptionPane.showMessageDialog(null, "Nomor meja tidak ditemukan!");
            }

            rsStaff.close();
            stmtStaff.close();
            rsMeja.close();
            stmtMeja.close();

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Terjadi kesalahan saat memproses transaksi: " + e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnBayarActionPerformed

    private void opsiMenu11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opsiMenu11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_opsiMenu11ActionPerformed

    private void opsiMenu12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opsiMenu12ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_opsiMenu12ActionPerformed

    private void opsiMenu13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opsiMenu13ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_opsiMenu13ActionPerformed

    private void opsiMenu14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opsiMenu14ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_opsiMenu14ActionPerformed

    private void opsiMenu15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opsiMenu15ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_opsiMenu15ActionPerformed

    private void opsiMenu16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opsiMenu16ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_opsiMenu16ActionPerformed

    private void opsiMenu17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opsiMenu17ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_opsiMenu17ActionPerformed

    private void opsiMenu18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opsiMenu18ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_opsiMenu18ActionPerformed

    private void opsiMenu19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opsiMenu19ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_opsiMenu19ActionPerformed

    private void opsiMenu20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opsiMenu20ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_opsiMenu20ActionPerformed

    private void inputNamaPelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputNamaPelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputNamaPelActionPerformed

    private void inputMejaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputMejaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputMejaActionPerformed

    private void HomePageBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HomePageBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_HomePageBtnActionPerformed

    private void sesiIDStaffActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sesiIDStaffActionPerformed

    }//GEN-LAST:event_sesiIDStaffActionPerformed

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
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                HomePage homepage = new HomePage();
                homepage.pack(); // Menyusun ukuran jendela agar sesuai dengan komponen yang ada
                homepage.setLocationRelativeTo(null); // Menempatkan jendela di tengah layar
                homepage.setVisible(true); // Menampilkan jendela
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private custom.button HomePageBtn;
    private javax.swing.JLabel LogoTop;
    private custom.button ManagePageBtn;
    private custom.button OrderPageBtn;
    private custom.panel PanelMenu1;
    private custom.panel PanelMenu10;
    private custom.panel PanelMenu11;
    private custom.panel PanelMenu12;
    private custom.panel PanelMenu13;
    private custom.panel PanelMenu14;
    private custom.panel PanelMenu15;
    private custom.panel PanelMenu16;
    private custom.panel PanelMenu17;
    private custom.panel PanelMenu18;
    private custom.panel PanelMenu19;
    private custom.panel PanelMenu2;
    private custom.panel PanelMenu20;
    private custom.panel PanelMenu3;
    private custom.panel PanelMenu4;
    private custom.panel PanelMenu5;
    private custom.panel PanelMenu8;
    private custom.panel PanelMenu9;
    private custom.button ReportsPageBtn;
    private javax.swing.JLabel Tanggal;
    private javax.swing.JLabel Waktu;
    private javax.swing.JCheckBox addMenu1;
    private javax.swing.JCheckBox addMenu10;
    private javax.swing.JCheckBox addMenu11;
    private javax.swing.JCheckBox addMenu12;
    private javax.swing.JCheckBox addMenu13;
    private javax.swing.JCheckBox addMenu14;
    private javax.swing.JCheckBox addMenu15;
    private javax.swing.JCheckBox addMenu16;
    private javax.swing.JCheckBox addMenu17;
    private javax.swing.JCheckBox addMenu18;
    private javax.swing.JCheckBox addMenu19;
    private javax.swing.JCheckBox addMenu2;
    private javax.swing.JCheckBox addMenu20;
    private javax.swing.JCheckBox addMenu3;
    private javax.swing.JCheckBox addMenu4;
    private javax.swing.JCheckBox addMenu5;
    private javax.swing.JCheckBox addMenu8;
    private javax.swing.JCheckBox addMenu9;
    private custom.button btnBayar;
    private custom.button btnPrint;
    private custom.button btnReset;
    private javax.swing.JTextField inputMeja;
    private javax.swing.JTextField inputNamaPel;
    private javax.swing.JTextField inputTunai;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextAreaOrder;
    private javax.swing.JPanel layerDasarHome;
    private javax.swing.JLabel lblMenu1;
    private javax.swing.JLabel lblMenu10;
    private javax.swing.JLabel lblMenu11;
    private javax.swing.JLabel lblMenu12;
    private javax.swing.JLabel lblMenu13;
    private javax.swing.JLabel lblMenu14;
    private javax.swing.JLabel lblMenu15;
    private javax.swing.JLabel lblMenu16;
    private javax.swing.JLabel lblMenu17;
    private javax.swing.JLabel lblMenu18;
    private javax.swing.JLabel lblMenu19;
    private javax.swing.JLabel lblMenu2;
    private javax.swing.JLabel lblMenu20;
    private javax.swing.JLabel lblMenu3;
    private javax.swing.JLabel lblMenu4;
    private javax.swing.JLabel lblMenu5;
    private javax.swing.JLabel lblMenu8;
    private javax.swing.JLabel lblMenu9;
    private javax.swing.JLabel lblVarian1;
    private javax.swing.JLabel lblVarian10;
    private javax.swing.JLabel lblVarian11;
    private javax.swing.JLabel lblVarian12;
    private javax.swing.JLabel lblVarian13;
    private javax.swing.JLabel lblVarian14;
    private javax.swing.JLabel lblVarian15;
    private javax.swing.JLabel lblVarian16;
    private javax.swing.JLabel lblVarian17;
    private javax.swing.JLabel lblVarian18;
    private javax.swing.JLabel lblVarian19;
    private javax.swing.JLabel lblVarian2;
    private javax.swing.JLabel lblVarian20;
    private javax.swing.JLabel lblVarian3;
    private javax.swing.JLabel lblVarian4;
    private javax.swing.JLabel lblVarian5;
    private javax.swing.JLabel lblVarian8;
    private javax.swing.JLabel lblVarian9;
    private javax.swing.JPanel leftPanel;
    private javax.swing.JPanel menuPanel;
    private javax.swing.JComboBox<String> opsiMenu1;
    private javax.swing.JComboBox<String> opsiMenu10;
    private javax.swing.JComboBox<String> opsiMenu11;
    private javax.swing.JComboBox<String> opsiMenu12;
    private javax.swing.JComboBox<String> opsiMenu13;
    private javax.swing.JComboBox<String> opsiMenu14;
    private javax.swing.JComboBox<String> opsiMenu15;
    private javax.swing.JComboBox<String> opsiMenu16;
    private javax.swing.JComboBox<String> opsiMenu17;
    private javax.swing.JComboBox<String> opsiMenu18;
    private javax.swing.JComboBox<String> opsiMenu19;
    private javax.swing.JComboBox<String> opsiMenu2;
    private javax.swing.JComboBox<String> opsiMenu20;
    private javax.swing.JComboBox<String> opsiMenu3;
    private javax.swing.JComboBox<String> opsiMenu4;
    private javax.swing.JComboBox<String> opsiMenu5;
    private javax.swing.JComboBox<String> opsiMenu8;
    private javax.swing.JComboBox<String> opsiMenu9;
    private javax.swing.JTextField outputKembali;
    private javax.swing.JTextField outputPPN;
    private javax.swing.JTextField outputSubtotal;
    private javax.swing.JTextField outputTotal;
    private javax.swing.JLabel picMenu1;
    private javax.swing.JLabel picMenu10;
    private javax.swing.JLabel picMenu11;
    private javax.swing.JLabel picMenu12;
    private javax.swing.JLabel picMenu13;
    private javax.swing.JLabel picMenu14;
    private javax.swing.JLabel picMenu15;
    private javax.swing.JLabel picMenu16;
    private javax.swing.JLabel picMenu17;
    private javax.swing.JLabel picMenu18;
    private javax.swing.JLabel picMenu19;
    private javax.swing.JLabel picMenu2;
    private javax.swing.JLabel picMenu20;
    private javax.swing.JLabel picMenu3;
    private javax.swing.JLabel picMenu4;
    private javax.swing.JLabel picMenu5;
    private javax.swing.JLabel picMenu8;
    private javax.swing.JLabel picMenu9;
    private javax.swing.JSpinner qtyMenu1;
    private javax.swing.JSpinner qtyMenu10;
    private javax.swing.JSpinner qtyMenu11;
    private javax.swing.JSpinner qtyMenu12;
    private javax.swing.JSpinner qtyMenu13;
    private javax.swing.JSpinner qtyMenu14;
    private javax.swing.JSpinner qtyMenu15;
    private javax.swing.JSpinner qtyMenu16;
    private javax.swing.JSpinner qtyMenu17;
    private javax.swing.JSpinner qtyMenu18;
    private javax.swing.JSpinner qtyMenu19;
    private javax.swing.JSpinner qtyMenu2;
    private javax.swing.JSpinner qtyMenu20;
    private javax.swing.JSpinner qtyMenu3;
    private javax.swing.JSpinner qtyMenu4;
    private javax.swing.JSpinner qtyMenu5;
    private javax.swing.JSpinner qtyMenu8;
    private javax.swing.JSpinner qtyMenu9;
    private javax.swing.JPanel rightPanel;
    private javax.swing.JTextField sesiIDStaff;
    private javax.swing.JPanel topPanel;
    // End of variables declaration//GEN-END:variables
}
