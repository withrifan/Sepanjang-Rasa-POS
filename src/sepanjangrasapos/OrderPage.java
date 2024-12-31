package sepanjangrasapos;

import java.awt.Image;
import javax.swing.ImageIcon;

public class OrderPage extends javax.swing.JFrame {

    public OrderPage() {
        initComponents();
        setTime();
        setImg();
        setIconBtn();
    }
    
    public void setTime() {
        // Menggunakan MethodClass untuk memperbarui waktu dan tanggal secara real-time
        MethodClass.setTime(Waktu, Tanggal);
    }
    
    public void setImg(){
        MethodClass.setIconLabel(LogoTop, "/BahanSteak/LogoSepanjangRasa2.png");
    }

    private void setIconBtn() {
        // Menggunakan MethodClass untuk mengatur ikon pada tombol
        MethodClass.setIconBtn(HomePageBtn, "/BahanSteak/logoHome2.png");
        MethodClass.setIconBtn(OrderPageBtn, "/BahanSteak/logoOrder1.png");
        MethodClass.setIconBtn(ReportsPageBtn, "/BahanSteak/logoReport2.png");
        MethodClass.setIconBtn(ManagePageBtn, "/BahanSteak/logoStaff2.png");  
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
        HomePageBtn = new custom.Button();
        jLabel8 = new javax.swing.JLabel();
        OrderPageBtn = new custom.Button();
        jLabel9 = new javax.swing.JLabel();
        ReportsPageBtn = new custom.Button();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        ManagePageBtn = new custom.Button();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        outSubtotal = new javax.swing.JTextField();
        outPajak = new javax.swing.JTextField();
        outTotal = new javax.swing.JTextField();
        outTunai = new javax.swing.JTextField();
        outStatus = new javax.swing.JTextField();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Order - Sepanjang Rasa");
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/BahanSteak/iconSR.jpg")).getImage());
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
                .addGap(3, 3, 3)
                .addComponent(Tanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(LogoTop, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
        );

        panelLeftOrderPage.setBackground(new java.awt.Color(255, 255, 255));
        panelLeftOrderPage.setPreferredSize(new java.awt.Dimension(65, 710));

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

        OrderPageBtn.setColorBorder(new java.awt.Color(255, 255, 255));
        OrderPageBtn.setColorClick(new java.awt.Color(204, 204, 204));
        OrderPageBtn.setColorOver(new java.awt.Color(245, 245, 245));
        OrderPageBtn.setIconTextGap(0);
        OrderPageBtn.setPreferredSize(new java.awt.Dimension(35, 35));
        OrderPageBtn.setRadius(8);

        jLabel9.setFont(new java.awt.Font("Poppins SemiBold", 0, 11)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(252, 128, 25));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Order");

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

        jLabel10.setFont(new java.awt.Font("Poppins SemiBold", 0, 11)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Report");

        jLabel11.setFont(new java.awt.Font("Poppins SemiBold", 0, 11)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Staff");

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

        javax.swing.GroupLayout panelLeftOrderPageLayout = new javax.swing.GroupLayout(panelLeftOrderPage);
        panelLeftOrderPage.setLayout(panelLeftOrderPageLayout);
        panelLeftOrderPageLayout.setHorizontalGroup(
            panelLeftOrderPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLeftOrderPageLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10))
            .addGroup(panelLeftOrderPageLayout.createSequentialGroup()
                .addGroup(panelLeftOrderPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLeftOrderPageLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(panelLeftOrderPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(HomePageBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(OrderPageBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ReportsPageBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ManagePageBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelLeftOrderPageLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelLeftOrderPageLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelLeftOrderPageLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(9, Short.MAX_VALUE))
        );
        panelLeftOrderPageLayout.setVerticalGroup(
            panelLeftOrderPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLeftOrderPageLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(HomePageBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel8)
                .addGap(30, 30, 30)
                .addComponent(OrderPageBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel9)
                .addGap(30, 30, 30)
                .addComponent(ReportsPageBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel10)
                .addGap(30, 30, 30)
                .addComponent(ManagePageBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel11)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Poppins Black", 1, 28)); // NOI18N
        jLabel1.setText("Riwayat Pesanan");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Id Pesanan", "Tanggal", "Meja", "Total", "Tunai", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Double.class, java.lang.Double.class, java.lang.Boolean.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(159, 159, 158)));

        jLabel2.setFont(new java.awt.Font("Poppins Medium", 1, 24)); // NOI18N
        jLabel2.setText("Detail Pesanan");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane2.setViewportView(jTextArea1);

        jLabel3.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel3.setText("Subtotal");
        jLabel3.setPreferredSize(new java.awt.Dimension(45, 22));

        jLabel4.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel4.setText("Pajak 12%");
        jLabel4.setPreferredSize(new java.awt.Dimension(54, 22));

        jLabel5.setFont(new java.awt.Font("Poppins SemiBold", 0, 12)); // NOI18N
        jLabel5.setText("Total");

        jLabel6.setFont(new java.awt.Font("Poppins SemiBold", 0, 12)); // NOI18N
        jLabel6.setText("Tunai");

        jLabel7.setFont(new java.awt.Font("Poppins SemiBold", 0, 12)); // NOI18N
        jLabel7.setText("Status");

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

        outStatus.setFont(new java.awt.Font("Poppins SemiBold", 0, 12)); // NOI18N
        outStatus.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        jTextField1.setFont(new java.awt.Font("Poppins SemiBold", 0, 13)); // NOI18N
        jTextField1.setText("ID : 261224001");
        jTextField1.setBorder(null);
        jTextField1.setCaretColor(new java.awt.Color(255, 255, 255));
        jTextField1.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        jTextField1.setDoubleBuffered(true);

        jTextField2.setFont(new java.awt.Font("Poppins SemiBold", 0, 13)); // NOI18N
        jTextField2.setText("Take way");
        jTextField2.setBorder(null);
        jTextField2.setCaretColor(new java.awt.Color(255, 255, 255));
        jTextField2.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        jTextField2.setDoubleBuffered(true);
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jTextField3.setFont(new java.awt.Font("Poppins Medium", 0, 13)); // NOI18N
        jTextField3.setText("41");
        jTextField3.setBorder(null);
        jTextField3.setCaretColor(new java.awt.Color(255, 255, 255));
        jTextField3.setDisabledTextColor(new java.awt.Color(255, 255, 255));
        jTextField3.setDoubleBuffered(true);
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 160, Short.MAX_VALUE)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(outTunai, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
                            .addComponent(outTotal, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(outPajak, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(outSubtotal, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(outStatus))
                        .addGap(20, 20, 20))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 581, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(outSubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                    .addComponent(outStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8))
        );

        javax.swing.GroupLayout bgOrderPageLayout = new javax.swing.GroupLayout(bgOrderPage);
        bgOrderPage.setLayout(bgOrderPageLayout);
        bgOrderPageLayout.setHorizontalGroup(
            bgOrderPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgOrderPageLayout.createSequentialGroup()
                .addGroup(bgOrderPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bgOrderPageLayout.createSequentialGroup()
                        .addComponent(panelLeftOrderPage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(bgOrderPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(bgOrderPageLayout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1055, Short.MAX_VALUE)
                                .addGap(15, 15, 15))
                            .addGroup(bgOrderPageLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(panelTopOrderPage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );
        bgOrderPageLayout.setVerticalGroup(
            bgOrderPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgOrderPageLayout.createSequentialGroup()
                .addComponent(panelTopOrderPage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(bgOrderPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(bgOrderPageLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 754, Short.MAX_VALUE)
                        .addGap(6, 6, 6))
                    .addComponent(panelLeftOrderPage, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 816, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(bgOrderPage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bgOrderPage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        getAccessibleContext().setAccessibleName("Order - Sepanjang Rasa");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void outSubtotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_outSubtotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_outSubtotalActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        setExtendedState(OrderPage.MAXIMIZED_BOTH);
    }//GEN-LAST:event_formComponentShown

    private void ManagePageBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ManagePageBtnActionPerformed
        new Manage().setVisible(true);   
        dispose();
    }//GEN-LAST:event_ManagePageBtnActionPerformed

    private void ReportsPageBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReportsPageBtnActionPerformed
        new Reports().setVisible(true);   
        dispose();
    }//GEN-LAST:event_ReportsPageBtnActionPerformed

    private void HomePageBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HomePageBtnActionPerformed
        new HomePage().setVisible(true);   
        dispose();
    }//GEN-LAST:event_HomePageBtnActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void outTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_outTotalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_outTotalActionPerformed

    /**
     * @param args the command line arguments
     */
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
        
         /* Create and display the form */
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
    private custom.Button HomePageBtn;
    private javax.swing.JLabel LogoTop;
    private custom.Button ManagePageBtn;
    private custom.Button OrderPageBtn;
    private custom.Button ReportsPageBtn;
    private javax.swing.JLabel Tanggal;
    private javax.swing.JLabel Waktu;
    private javax.swing.JPanel bgOrderPage;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
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
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField outPajak;
    private javax.swing.JTextField outStatus;
    private javax.swing.JTextField outSubtotal;
    private javax.swing.JTextField outTotal;
    private javax.swing.JTextField outTunai;
    private javax.swing.JPanel panelLeftOrderPage;
    private javax.swing.JPanel panelTopOrderPage;
    // End of variables declaration//GEN-END:variables
}
