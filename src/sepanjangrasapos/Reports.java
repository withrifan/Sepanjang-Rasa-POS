package sepanjangrasapos;

public class Reports extends javax.swing.JFrame {

    public Reports() {
        initComponents();
        setTime();
        setImg();
        setIconBtn();
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
        MethodClass.setIconBtn(TablePageBtn, "/components/logoTable2.png");
        MethodClass.setIconBtn(ReportsPageBtn, "/components/logoReport1.png");
        MethodClass.setIconBtn(ManagePageBtn, "/components/logoStaff2.png");
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
        TablePageBtn = new custom.button();
        jLabel6 = new javax.swing.JLabel();
        ReportsPageBtn = new custom.button();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        ManagePageBtn = new custom.button();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Reports - Sepanjang Rasa");
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/components/iconSR.jpg")).getImage());
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        bgOrderPage.setBackground(new java.awt.Color(245, 245, 245));

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
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(LogoTop, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1169, 1169, 1169)
                .addGroup(panelTopOrderPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Tanggal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Waktu, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
        );
        panelTopOrderPageLayout.setVerticalGroup(
            panelTopOrderPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(LogoTop, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
            .addGroup(panelTopOrderPageLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(Waktu, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(Tanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

        jLabel6.setFont(new java.awt.Font("Poppins SemiBold", 0, 10)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Table");

        ReportsPageBtn.setColorBorder(new java.awt.Color(255, 255, 255));
        ReportsPageBtn.setColorClick(new java.awt.Color(204, 204, 204));
        ReportsPageBtn.setColorOver(new java.awt.Color(245, 245, 245));
        ReportsPageBtn.setPreferredSize(new java.awt.Dimension(35, 35));
        ReportsPageBtn.setRadius(8);
        ReportsPageBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReportsPageBtnActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Poppins SemiBold", 0, 10)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(252, 128, 25));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Report");

        jLabel8.setFont(new java.awt.Font("Poppins SemiBold", 0, 10)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Staff");

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

        javax.swing.GroupLayout panelLeftOrderPageLayout = new javax.swing.GroupLayout(panelLeftOrderPage);
        panelLeftOrderPage.setLayout(panelLeftOrderPageLayout);
        panelLeftOrderPageLayout.setHorizontalGroup(
            panelLeftOrderPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelLeftOrderPageLayout.createSequentialGroup()
                .addGroup(panelLeftOrderPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLeftOrderPageLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(panelLeftOrderPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(HomePageBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TablePageBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ReportsPageBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(OrderPageBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(panelLeftOrderPageLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(ManagePageBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(15, Short.MAX_VALUE))
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
                .addComponent(jLabel6)
                .addGap(30, 30, 30)
                .addComponent(ReportsPageBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel7)
                .addGap(30, 30, 30)
                .addComponent(ManagePageBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel8)
                .addContainerGap(295, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout bgOrderPageLayout = new javax.swing.GroupLayout(bgOrderPage);
        bgOrderPage.setLayout(bgOrderPageLayout);
        bgOrderPageLayout.setHorizontalGroup(
            bgOrderPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgOrderPageLayout.createSequentialGroup()
                .addGroup(bgOrderPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelLeftOrderPage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelTopOrderPage, javax.swing.GroupLayout.PREFERRED_SIZE, 1537, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0))
        );
        bgOrderPageLayout.setVerticalGroup(
            bgOrderPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgOrderPageLayout.createSequentialGroup()
                .addComponent(panelTopOrderPage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(panelLeftOrderPage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
        setExtendedState(Reports.MAXIMIZED_BOTH);// mengatur agar frame ditampilkan fullscreen 
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

    private void TablePageBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TablePageBtnActionPerformed
        new TablePage().setVisible(true);
        dispose();
    }//GEN-LAST:event_TablePageBtnActionPerformed

    private void HomePageBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HomePageBtnActionPerformed
        new HomePage().setVisible(true);
        dispose();
    }//GEN-LAST:event_HomePageBtnActionPerformed

    private void OrderPageBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OrderPageBtnActionPerformed
        new OrderPage().setVisible(true);
        dispose();
    }//GEN-LAST:event_OrderPageBtnActionPerformed

    private void ReportsPageBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReportsPageBtnActionPerformed
        
    }//GEN-LAST:event_ReportsPageBtnActionPerformed

    private void ManagePageBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ManagePageBtnActionPerformed
        new Manage().setVisible(true);
        dispose();
    }//GEN-LAST:event_ManagePageBtnActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(() -> {
            new Reports().setVisible(true);
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel panelLeftOrderPage;
    private javax.swing.JPanel panelTopOrderPage;
    // End of variables declaration//GEN-END:variables
}
