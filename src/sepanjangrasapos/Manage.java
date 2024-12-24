package sepanjangrasapos;

import java.awt.Image;
import java.awt.Menu;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
import java.sql.*;
import javax.swing.table.DefaultTableModel;

public class Manage extends javax.swing.JFrame {

    public Manage() {
        initComponents();
        setTime();
        setImg();
        setIconBtn();
        loadStaffData(); // Panggil metode untuk memuat data
        setExtendedState(Manage.MAXIMIZED_BOTH);// mengatur agar frame ditampilkan fullscreen  
    }
    
    public void setTime(){
        new Thread(new Runnable(){
            @Override
            public void run(){
                while (true){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    Date date = new Date();
                    SimpleDateFormat tf = new SimpleDateFormat("h:mm:ss aa");
                    SimpleDateFormat df = new SimpleDateFormat("EEEE, dd-MM-yyyy");
                    String time = tf.format(date);
                    Waktu.setText(time.split(" ")[0]+" "+time.split(" ")[1]);
                    Tanggal.setText(df.format(date));
                }
            }
        }).start();
    }
    
    public void setImg(){
        ImageIcon icon = new ImageIcon(getClass().getResource("/BahanSteak/LogoSepanjangRasa2.png"));
        Image img = icon.getImage().getScaledInstance(LogoTop.getWidth(),LogoTop.getHeight(), Image.SCALE_SMOOTH);
        LogoTop.setIcon(new ImageIcon(img));
    } 
    
    public void setIconBtn(){
        //Set icon homePageBtn
        ImageIcon icon1 = new ImageIcon(getClass().getResource("/BahanSteak/logoHome2.png"));
        Image img1 = icon1.getImage().getScaledInstance(HomePageBtn.getWidth(),HomePageBtn.getHeight(), Image.SCALE_SMOOTH);
        HomePageBtn.setIcon(new ImageIcon(img1));
        //Set icon orderPageBtn
        ImageIcon icon2 = new ImageIcon(getClass().getResource("/BahanSteak/logoOrder2.png"));
        Image img2 = icon2.getImage().getScaledInstance(OrderPageBtn.getWidth(),OrderPageBtn.getHeight(), Image.SCALE_SMOOTH);
        OrderPageBtn.setIcon(new ImageIcon(img2));
        //Set icon reportsPageBtn
        ImageIcon icon3 = new ImageIcon(getClass().getResource("/BahanSteak/logoReport2.png"));
        Image img3 = icon3.getImage().getScaledInstance(ReportsPageBtn.getWidth(),ReportsPageBtn.getHeight(), Image.SCALE_SMOOTH);
        ReportsPageBtn.setIcon(new ImageIcon(img3));
        //Set icon ManagePageBtn
        ImageIcon icon4 = new ImageIcon(getClass().getResource("/BahanSteak/logoStaff1.png"));
        Image img4 = icon4.getImage().getScaledInstance(ManagePageBtn.getWidth(),ManagePageBtn.getHeight(), Image.SCALE_SMOOTH);
        ManagePageBtn.setIcon(new ImageIcon(img4));
    }
    
    // Metode untuk memuat data dari database ke JTable
    private void loadStaffData() {
        //DefaultTableModel model = (DefaultTableModel) jTableManageStaff.getModel();
        DefaultTableModel model = new DefaultTableModel(
            new String[]{"ID Staff", "Nama", "Jabatan", "Jenis Kelamin", "Telpon", "Email", "Password", "Alamat"}, 0
        );
        jTableManageStaff.setModel(model);
        
        model.setRowCount(0); // Reset data tabel
      
        try {
            String query = "SELECT * FROM tb_staff";
            Connection conn = DBConnection.getConnection();
            PreparedStatement pst = conn.prepareStatement(query);
            ResultSet rs = pst.executeQuery();

        while (rs.next()) {
            model.addRow(new Object[]{
                rs.getInt("id_staff"),
                rs.getString("nama"),
                rs.getString("jabatan"),
                rs.getString("jk"),
                rs.getString("telpon"),
                rs.getString("email"),
                rs.getString("password"),
                rs.getString("alamat")
            });
        }
        rs.close();
        pst.close();
        conn.close();
    } catch (SQLException e) {
        System.err.println("Gagal memuat data: " + e.getMessage());
    }
}
    
    private void saveStaffData() {
        String id = idstaff_Field.getText();
        String nama = nama_Field.getText();
        String jabatan = jabatan_FieldCombo.getSelectedItem().toString();
        String jk = jeniskelamin_FieldCombo.getSelectedItem().toString();
        String telpon = telpon_Field.getText();
        String email = email_Field.getText();
        String password = password_Field.getText();
        String alamat = alamat_Field.getText();
        
        String query = "INSERT INTO tb_staff (id_staff, nama, jabatan, jk, telpon, email, password, alamat) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            
            // Mengatur parameter dalam query
            pstmt.setString(1, id);
            pstmt.setString(2, nama);
            pstmt.setString(3, jabatan);
            pstmt.setString(4, jk);
            pstmt.setString(5, telpon);
            pstmt.setString(6, email);
            pstmt.setString(7, password);
            pstmt.setString(8, alamat);

            pstmt.executeUpdate(); // Eksekusi query INSERT
            JOptionPane.showMessageDialog(this, "Data berhasil disimpan!", "Sukses", JOptionPane.INFORMATION_MESSAGE);
            loadStaffData(); // Refresh JTable setelah menyimpan data

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, 
                "Error saving data: " + e.getMessage(),
                "Database Error", JOptionPane.ERROR_MESSAGE);
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
        HomePageBtn = new button.custom();
        jLabel1 = new javax.swing.JLabel();
        OrderPageBtn = new button.custom();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        ReportsPageBtn = new button.custom();
        jLabel4 = new javax.swing.JLabel();
        ManagePageBtn = new button.custom();
        manageStaff_Label = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        idstaff_Label = new javax.swing.JLabel();
        idstaff_Field = new javax.swing.JTextField();
        jeniskelamin_Label = new javax.swing.JLabel();
        jeniskelamin_FieldCombo = new javax.swing.JComboBox<>();
        alamat_Label = new javax.swing.JLabel();
        alamat_Field = new javax.swing.JTextField();
        telpon_Label = new javax.swing.JLabel();
        telpon_Field = new javax.swing.JTextField();
        jabatan_Label = new javax.swing.JLabel();
        jabatan_FieldCombo = new javax.swing.JComboBox<>();
        password_Label = new javax.swing.JLabel();
        password_Field = new javax.swing.JPasswordField();
        simpanButton = new javax.swing.JButton();
        updateButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        detailStaff_Label = new javax.swing.JLabel();
        email_Field = new javax.swing.JTextField();
        email_Label = new javax.swing.JLabel();
        nama_Label = new javax.swing.JLabel();
        nama_Field = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableManageStaff = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/BahanSteak/iconSR.jpg")).getImage());
        setPreferredSize(new java.awt.Dimension(1530, 845));

        bgOrderPage.setBackground(new java.awt.Color(245, 245, 245));
        bgOrderPage.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                bgOrderPageComponentShown(evt);
            }
        });

        panelTopOrderPage.setBackground(new java.awt.Color(255, 255, 255));
        panelTopOrderPage.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(159, 159, 158), 2));
        panelTopOrderPage.setPreferredSize(new java.awt.Dimension(1536, 80));

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
                .addComponent(LogoTop, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelTopOrderPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Waktu, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Tanggal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
        );
        panelTopOrderPageLayout.setVerticalGroup(
            panelTopOrderPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTopOrderPageLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelTopOrderPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelTopOrderPageLayout.createSequentialGroup()
                        .addGap(0, 14, Short.MAX_VALUE)
                        .addComponent(Waktu, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(Tanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(LogoTop, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        panelLeftOrderPage.setBackground(new java.awt.Color(255, 255, 255));
        panelLeftOrderPage.setPreferredSize(new java.awt.Dimension(80, 710));

        HomePageBtn.setColorBorder(new java.awt.Color(255, 255, 255));
        HomePageBtn.setColorClick(new java.awt.Color(204, 204, 204));
        HomePageBtn.setColorOver(new java.awt.Color(245, 245, 245));
        HomePageBtn.setRadius(8);
        HomePageBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HomePageBtnActionPerformed(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Poppins SemiBold", 0, 11)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Home");

        OrderPageBtn.setColorBorder(new java.awt.Color(255, 255, 255));
        OrderPageBtn.setColorClick(new java.awt.Color(204, 204, 204));
        OrderPageBtn.setColorOver(new java.awt.Color(245, 245, 245));
        OrderPageBtn.setRadius(8);
        OrderPageBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OrderPageBtnActionPerformed(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Poppins SemiBold", 0, 11)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Order");

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Poppins SemiBold", 0, 11)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Report");

        ReportsPageBtn.setColorBorder(new java.awt.Color(255, 255, 255));
        ReportsPageBtn.setColorClick(new java.awt.Color(204, 204, 204));
        ReportsPageBtn.setColorOver(new java.awt.Color(245, 245, 245));
        ReportsPageBtn.setRadius(8);
        ReportsPageBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReportsPageBtnActionPerformed(evt);
            }
        });

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Poppins SemiBold", 0, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(252, 128, 25));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Staff");

        ManagePageBtn.setColorBorder(new java.awt.Color(255, 255, 255));
        ManagePageBtn.setColorClick(new java.awt.Color(204, 204, 204));
        ManagePageBtn.setColorOver(new java.awt.Color(245, 245, 245));
        ManagePageBtn.setRadius(8);

        javax.swing.GroupLayout panelLeftOrderPageLayout = new javax.swing.GroupLayout(panelLeftOrderPage);
        panelLeftOrderPage.setLayout(panelLeftOrderPageLayout);
        panelLeftOrderPageLayout.setHorizontalGroup(
            panelLeftOrderPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLeftOrderPageLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(panelLeftOrderPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(HomePageBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(OrderPageBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ReportsPageBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ManagePageBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE))
                .addGap(17, 17, 17))
        );
        panelLeftOrderPageLayout.setVerticalGroup(
            panelLeftOrderPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLeftOrderPageLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(HomePageBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel1)
                .addGap(40, 40, 40)
                .addComponent(OrderPageBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel2)
                .addGap(40, 40, 40)
                .addComponent(ReportsPageBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel3)
                .addGap(40, 40, 40)
                .addComponent(ManagePageBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        manageStaff_Label.setFont(new java.awt.Font("Poppins Black", 1, 28)); // NOI18N
        manageStaff_Label.setText("Manage Staff");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(159, 159, 158), 2));
        jPanel1.setPreferredSize(new java.awt.Dimension(340, 500));
        jPanel1.setRequestFocusEnabled(false);

        idstaff_Label.setFont(new java.awt.Font("Poppins SemiBold", 0, 14)); // NOI18N
        idstaff_Label.setText("ID Staff");

        idstaff_Field.setFont(new java.awt.Font("Poppins", 0, 13)); // NOI18N
        idstaff_Field.setPreferredSize(new java.awt.Dimension(64, 30));

        jeniskelamin_Label.setFont(new java.awt.Font("Poppins SemiBold", 0, 14)); // NOI18N
        jeniskelamin_Label.setText("Jenis kelamin");

        jeniskelamin_FieldCombo.setFont(new java.awt.Font("Poppins", 0, 13)); // NOI18N
        jeniskelamin_FieldCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Laki-Laki", "Perempuan" }));
        jeniskelamin_FieldCombo.setPreferredSize(new java.awt.Dimension(150, 30));
        jeniskelamin_FieldCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jeniskelamin_FieldComboActionPerformed(evt);
            }
        });

        alamat_Label.setFont(new java.awt.Font("Poppins SemiBold", 0, 14)); // NOI18N
        alamat_Label.setText("Alamat");

        alamat_Field.setFont(new java.awt.Font("Poppins", 0, 13)); // NOI18N
        alamat_Field.setPreferredSize(new java.awt.Dimension(64, 30));
        alamat_Field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                alamat_FieldActionPerformed(evt);
            }
        });

        telpon_Label.setFont(new java.awt.Font("Poppins SemiBold", 0, 14)); // NOI18N
        telpon_Label.setText("Telpon");

        telpon_Field.setFont(new java.awt.Font("Poppins", 0, 13)); // NOI18N
        telpon_Field.setPreferredSize(new java.awt.Dimension(64, 30));
        telpon_Field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                telpon_FieldActionPerformed(evt);
            }
        });

        jabatan_Label.setFont(new java.awt.Font("Poppins SemiBold", 0, 14)); // NOI18N
        jabatan_Label.setText("Jabatan");

        jabatan_FieldCombo.setFont(new java.awt.Font("Poppins", 0, 13)); // NOI18N
        jabatan_FieldCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Manager", "Chef", "Kasir", "Cleaner", "Admin" }));
        jabatan_FieldCombo.setPreferredSize(new java.awt.Dimension(150, 30));
        jabatan_FieldCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jabatan_FieldComboActionPerformed(evt);
            }
        });

        password_Label.setFont(new java.awt.Font("Poppins SemiBold", 0, 14)); // NOI18N
        password_Label.setText("Password");

        password_Field.setFont(new java.awt.Font("Poppins", 0, 13)); // NOI18N
        password_Field.setPreferredSize(new java.awt.Dimension(314, 30));

        simpanButton.setBackground(new java.awt.Color(91, 121, 255));
        simpanButton.setFont(new java.awt.Font("Poppins SemiBold", 0, 16)); // NOI18N
        simpanButton.setForeground(new java.awt.Color(255, 255, 255));
        simpanButton.setText("Save");
        simpanButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simpanButtonActionPerformed(evt);
            }
        });

        updateButton.setBackground(new java.awt.Color(9, 170, 41));
        updateButton.setFont(new java.awt.Font("Poppins SemiBold", 0, 16)); // NOI18N
        updateButton.setForeground(new java.awt.Color(255, 255, 255));
        updateButton.setText("Update");
        updateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateButtonActionPerformed(evt);
            }
        });

        deleteButton.setBackground(new java.awt.Color(255, 9, 9));
        deleteButton.setFont(new java.awt.Font("Poppins SemiBold", 0, 16)); // NOI18N
        deleteButton.setForeground(new java.awt.Color(255, 255, 255));
        deleteButton.setText("Delete");

        detailStaff_Label.setFont(new java.awt.Font("Poppins", 1, 27)); // NOI18N
        detailStaff_Label.setText("Detail staff");

        email_Field.setFont(new java.awt.Font("Poppins", 0, 13)); // NOI18N
        email_Field.setPreferredSize(new java.awt.Dimension(314, 30));
        email_Field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                email_FieldActionPerformed(evt);
            }
        });

        email_Label.setFont(new java.awt.Font("Poppins SemiBold", 0, 14)); // NOI18N
        email_Label.setText("Email");

        nama_Label.setFont(new java.awt.Font("Poppins SemiBold", 0, 14)); // NOI18N
        nama_Label.setText("Nama");

        nama_Field.setFont(new java.awt.Font("Poppins", 0, 13)); // NOI18N
        nama_Field.setPreferredSize(new java.awt.Dimension(64, 30));
        nama_Field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nama_FieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(alamat_Label, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(alamat_Field, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jeniskelamin_Label, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jeniskelamin_FieldCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(idstaff_Label, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(idstaff_Field, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(telpon_Label, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(telpon_Field, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(simpanButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(updateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(detailStaff_Label, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nama_Label, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nama_Field, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jabatan_Label, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jabatan_FieldCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(email_Field, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(email_Label, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(password_Label, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(password_Field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(11, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {nama_Field, nama_Label});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {idstaff_Field, idstaff_Label});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jeniskelamin_FieldCombo, jeniskelamin_Label});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {alamat_Field, alamat_Label, telpon_Field, telpon_Label});

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {email_Field, email_Label, password_Field, password_Label});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(detailStaff_Label, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(idstaff_Label, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(idstaff_Field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(nama_Label, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(nama_Field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jabatan_Label, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jabatan_FieldCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jeniskelamin_Label, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jeniskelamin_FieldCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(telpon_Label, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(telpon_Field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(email_Label, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(email_Field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(password_Label, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(password_Field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(alamat_Label, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(alamat_Field, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(simpanButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(updateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {email_Field, password_Field});

        jTableManageStaff.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID Staff", "Nama", "Jabatan", "Jenis Kelamin", "Telpon", "Email", "Password", "Alamat"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTableManageStaff);

        javax.swing.GroupLayout bgOrderPageLayout = new javax.swing.GroupLayout(bgOrderPage);
        bgOrderPage.setLayout(bgOrderPageLayout);
        bgOrderPageLayout.setHorizontalGroup(
            bgOrderPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgOrderPageLayout.createSequentialGroup()
                .addComponent(panelLeftOrderPage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(bgOrderPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bgOrderPageLayout.createSequentialGroup()
                        .addGap(435, 435, 435)
                        .addComponent(manageStaff_Label, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 463, Short.MAX_VALUE))
                    .addGroup(bgOrderPageLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jScrollPane1)
                        .addGap(12, 12, 12)))
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(panelTopOrderPage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        bgOrderPageLayout.setVerticalGroup(
            bgOrderPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bgOrderPageLayout.createSequentialGroup()
                .addComponent(panelTopOrderPage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(bgOrderPageLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(bgOrderPageLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(manageStaff_Label, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 681, Short.MAX_VALUE))
                    .addGroup(bgOrderPageLayout.createSequentialGroup()
                        .addGap(0, 0, 0)
                        .addComponent(panelLeftOrderPage, javax.swing.GroupLayout.DEFAULT_SIZE, 725, Short.MAX_VALUE))
                    .addGroup(bgOrderPageLayout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(jScrollPane1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bgOrderPageLayout.createSequentialGroup()
                        .addGap(0, 0, 0)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 725, Short.MAX_VALUE)))
                .addContainerGap())
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

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void simpanButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpanButtonActionPerformed
        saveStaffData();
    }//GEN-LAST:event_simpanButtonActionPerformed

    private void jeniskelamin_FieldComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jeniskelamin_FieldComboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jeniskelamin_FieldComboActionPerformed

    private void alamat_FieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_alamat_FieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_alamat_FieldActionPerformed

    private void nama_FieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nama_FieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nama_FieldActionPerformed

    private void jabatan_FieldComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jabatan_FieldComboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jabatan_FieldComboActionPerformed

    private void telpon_FieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_telpon_FieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_telpon_FieldActionPerformed

    private void email_FieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_email_FieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_email_FieldActionPerformed

    private void updateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_updateButtonActionPerformed

    private void bgOrderPageComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_bgOrderPageComponentShown
    }//GEN-LAST:event_bgOrderPageComponentShown

    private void HomePageBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HomePageBtnActionPerformed
        new HomePage().setVisible(true);   
        dispose();
    }//GEN-LAST:event_HomePageBtnActionPerformed

    private void OrderPageBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OrderPageBtnActionPerformed
        new OrderPage().setVisible(true);   
        dispose();
    }//GEN-LAST:event_OrderPageBtnActionPerformed

    private void ReportsPageBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReportsPageBtnActionPerformed
        new Reports().setVisible(true);   
        dispose();
    }//GEN-LAST:event_ReportsPageBtnActionPerformed


    public static void main(String args[]) {
               
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                Manage manage = new Manage();
                manage.pack(); // Menyusun ukuran jendela agar sesuai dengan komponen yang ada
                manage.setLocationRelativeTo(null); // Menempatkan jendela di tengah layar
                manage.setVisible(true); // Menampilkan jendela
            }
        });
       
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private button.custom HomePageBtn;
    private javax.swing.JLabel LogoTop;
    private button.custom ManagePageBtn;
    private button.custom OrderPageBtn;
    private button.custom ReportsPageBtn;
    private javax.swing.JLabel Tanggal;
    private javax.swing.JLabel Waktu;
    private javax.swing.JTextField alamat_Field;
    private javax.swing.JLabel alamat_Label;
    private javax.swing.JPanel bgOrderPage;
    private javax.swing.JButton deleteButton;
    private javax.swing.JLabel detailStaff_Label;
    private javax.swing.JTextField email_Field;
    private javax.swing.JLabel email_Label;
    private javax.swing.JTextField idstaff_Field;
    private javax.swing.JLabel idstaff_Label;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableManageStaff;
    private javax.swing.JComboBox<String> jabatan_FieldCombo;
    private javax.swing.JLabel jabatan_Label;
    private javax.swing.JComboBox<String> jeniskelamin_FieldCombo;
    private javax.swing.JLabel jeniskelamin_Label;
    private javax.swing.JLabel manageStaff_Label;
    private javax.swing.JTextField nama_Field;
    private javax.swing.JLabel nama_Label;
    private javax.swing.JPanel panelLeftOrderPage;
    private javax.swing.JPanel panelTopOrderPage;
    private javax.swing.JPasswordField password_Field;
    private javax.swing.JLabel password_Label;
    private javax.swing.JButton simpanButton;
    private javax.swing.JTextField telpon_Field;
    private javax.swing.JLabel telpon_Label;
    private javax.swing.JButton updateButton;
    // End of variables declaration//GEN-END:variables
}
