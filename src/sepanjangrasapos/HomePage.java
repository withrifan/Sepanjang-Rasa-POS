package sepanjangrasapos;

import java.awt.Image;
import java.awt.Menu;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class HomePage extends javax.swing.JFrame {

    private double subtotal = 0.0;
    private int x=0;
    private double pajak = 0.0;
    private double total = 0.0;
    private double tunai = 0.0;
    private double kembali = 0.0;
    
    
    public HomePage() {
        initComponents();
        setTime();
        setImg();
    }
    
    //mengecek nilai dari qty
    public boolean qtyIsZero(int qty){
        if(qty == 0){
            JOptionPane.showMessageDialog(null, "Tolong tambahkan jumlah produk terlebih dahulu");
            return false;
        }
        return true;
    }
    
    //set gambar ke JLabel
    public void setImg(){
        ImageIcon icon = new ImageIcon(getClass().getResource("/BahanSteak/LogoSepanjangRasa2.png"));
        ImageIcon icon1 = new ImageIcon(getClass().getResource("/BahanSteak/1chickensteak.jpg"));
        ImageIcon icon2 = new ImageIcon(getClass().getResource("/BahanSteak/1chickencombo.jpg"));
        ImageIcon icon3 = new ImageIcon(getClass().getResource("/BahanSteak/1combomeals.jpg"));
        ImageIcon icon4 = new ImageIcon(getClass().getResource("/BahanSteak/1Tbone.jpg"));
        ImageIcon icon5 = new ImageIcon(getClass().getResource("/BahanSteak/1ribeye.jpg"));
        ImageIcon icon6 = new ImageIcon(getClass().getResource("/BahanSteak/1steak.jpg"));
        ImageIcon icon7 = new ImageIcon(getClass().getResource("/BahanSteak/1tenderloin.jpg"));
        ImageIcon icon8 = new ImageIcon(getClass().getResource("/BahanSteak/1tomahwak.jpg"));
        ImageIcon icon9 = new ImageIcon(getClass().getResource("/BahanSteak/2Expresso.jpg"));
        ImageIcon icon10 = new ImageIcon(getClass().getResource("/BahanSteak/2Lemoncucumber.jpg"));
        ImageIcon icon11 = new ImageIcon(getClass().getResource("/BahanSteak/2perrier.jpg"));
        ImageIcon icon12 = new ImageIcon(getClass().getResource("/BahanSteak/2strawberrylemonade.jpeg"));
        ImageIcon icon13 = new ImageIcon(getClass().getResource("/BahanSteak/2virginmojito.jpg"));
        ImageIcon icon14 = new ImageIcon(getClass().getResource("/BahanSteak/3applecrumble.jpg"));
        ImageIcon icon15 = new ImageIcon(getClass().getResource("/BahanSteak/3cheesecake.jpeg"));
        ImageIcon icon16 = new ImageIcon(getClass().getResource("/BahanSteak/3chocolateLavaCake.jpg"));
        ImageIcon icon17 = new ImageIcon(getClass().getResource("/BahanSteak/3tiramisu.jpg"));
        ImageIcon icon18 = new ImageIcon(getClass().getResource("/BahanSteak/3crèmebrûlée.jpg"));
       
        Image img = icon.getImage().getScaledInstance(LogoTop.getWidth(),LogoTop.getHeight(), Image.SCALE_SMOOTH);
        Image img1 = icon1.getImage().getScaledInstance(picMenu1.getWidth(),picMenu1.getHeight(), Image.SCALE_SMOOTH);
        Image img2 = icon2.getImage().getScaledInstance(picMenu2.getWidth(),picMenu2.getHeight(), Image.SCALE_SMOOTH);
        Image img3 = icon3.getImage().getScaledInstance(picMenu3.getWidth(),picMenu3.getHeight(), Image.SCALE_SMOOTH);
        Image img4 = icon4.getImage().getScaledInstance(picMenu4.getWidth(),picMenu4.getHeight(), Image.SCALE_SMOOTH);
        Image img5 = icon5.getImage().getScaledInstance(picMenu5.getWidth(),picMenu5.getHeight(), Image.SCALE_SMOOTH);
        Image img6 = icon6.getImage().getScaledInstance(picMenu6.getWidth(),picMenu6.getHeight(), Image.SCALE_SMOOTH);
        Image img7 = icon7.getImage().getScaledInstance(picMenu7.getWidth(),picMenu7.getHeight(), Image.SCALE_SMOOTH);
        Image img8 = icon8.getImage().getScaledInstance(picMenu8.getWidth(),picMenu8.getHeight(), Image.SCALE_SMOOTH);
        Image img9 = icon9.getImage().getScaledInstance(picMenu9.getWidth(),picMenu9.getHeight(), Image.SCALE_SMOOTH);
        Image img10 = icon10.getImage().getScaledInstance(picMenu10.getWidth(),picMenu10.getHeight(), Image.SCALE_SMOOTH);
        Image img11 = icon11.getImage().getScaledInstance(picMenu11.getWidth(),picMenu11.getHeight(), Image.SCALE_SMOOTH);
        Image img12 = icon12.getImage().getScaledInstance(picMenu12.getWidth(),picMenu12.getHeight(), Image.SCALE_SMOOTH);
        Image img13 = icon13.getImage().getScaledInstance(picMenu13.getWidth(),picMenu13.getHeight(), Image.SCALE_SMOOTH);
        Image img14 = icon14.getImage().getScaledInstance(picMenu14.getWidth(),picMenu14.getHeight(), Image.SCALE_SMOOTH);
        Image img15 = icon15.getImage().getScaledInstance(picMenu15.getWidth(),picMenu15.getHeight(), Image.SCALE_SMOOTH);
        Image img16 = icon16.getImage().getScaledInstance(picMenu16.getWidth(),picMenu16.getHeight(), Image.SCALE_SMOOTH);
        Image img17 = icon17.getImage().getScaledInstance(picMenu17.getWidth(),picMenu17.getHeight(), Image.SCALE_SMOOTH);
        Image img18 = icon18.getImage().getScaledInstance(picMenu18.getWidth(),picMenu18.getHeight(), Image.SCALE_SMOOTH);
        
        LogoTop.setIcon(new ImageIcon(img));
        picMenu1.setIcon(new ImageIcon(img1));
        picMenu2.setIcon(new ImageIcon(img2));
        picMenu3.setIcon(new ImageIcon(img3));
        picMenu4.setIcon(new ImageIcon(img4));
        picMenu5.setIcon(new ImageIcon(img5));
        picMenu6.setIcon(new ImageIcon(img6));
        picMenu7.setIcon(new ImageIcon(img7));
        picMenu8.setIcon(new ImageIcon(img8));
        picMenu9.setIcon(new ImageIcon(img9));
        picMenu10.setIcon(new ImageIcon(img10));
        picMenu11.setIcon(new ImageIcon(img11));
        picMenu12.setIcon(new ImageIcon(img12));
        picMenu13.setIcon(new ImageIcon(img13));
        picMenu14.setIcon(new ImageIcon(img14));
        picMenu15.setIcon(new ImageIcon(img15));
        picMenu16.setIcon(new ImageIcon(img16));
        picMenu17.setIcon(new ImageIcon(img17));
        picMenu18.setIcon(new ImageIcon(img18));
    }
    
    //mengatur waktu dan tanggal
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
    
    //menghitung nilai dari subtotal, pajak, dan total
    public void hitung(){
        pajak = subtotal*0.12;
        total = subtotal+pajak;
        outputSubtotal.setText(String.valueOf(subtotal));
        outputPPN.setText(String.valueOf(pajak));
        outputTotal.setText(String.valueOf(total));
    }
    
    //mereset semua nilai yang ada
    public void reset(){
        x = 0;
        subtotal = 0.0;
        pajak = 0.0;
        total = 0.0;
        tunai = 0.0;
        kembali = 0.0;
        qtyMenu1.setValue(0);
        qtyMenu2.setValue(0);
        qtyMenu3.setValue(0);
        qtyMenu4.setValue(0);
        qtyMenu5.setValue(0);
        qtyMenu6.setValue(0);
        qtyMenu7.setValue(0);
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
        addMenu6.setSelected(false);
        addMenu7.setSelected(false);
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
        btnBayar.setEnabled(true);
        btnPrint.setEnabled(true);
    }
    
    //mencetak teks di JTextArea
    public void orderList(){
        jTextAreaOrder.setText("************************ Sepanjang Rasa ***********************\n"
                + "Time: " + Waktu.getText()+ " Date: " + Tanggal.getText()+ "\n"
                + "******************************************************************" + "\n"
                + "Produk"+"\t\t"+"jumlah"+"\t"+"Total"+"\n");
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
        menuPanel = new javax.swing.JPanel();
        panelMenu1 = new javax.swing.JPanel();
        picMenu1 = new javax.swing.JLabel();
        lblMenu1 = new javax.swing.JLabel();
        lblVarian1 = new javax.swing.JLabel();
        opsiMenu1 = new javax.swing.JComboBox<>();
        qtyMenu1 = new javax.swing.JSpinner();
        addMenu1 = new javax.swing.JCheckBox();
        panelMenu2 = new javax.swing.JPanel();
        picMenu2 = new javax.swing.JLabel();
        lblMenu2 = new javax.swing.JLabel();
        lblVarian2 = new javax.swing.JLabel();
        opsiMenu2 = new javax.swing.JComboBox<>();
        qtyMenu2 = new javax.swing.JSpinner();
        addMenu2 = new javax.swing.JCheckBox();
        panelMenu3 = new javax.swing.JPanel();
        picMenu3 = new javax.swing.JLabel();
        lblMenu3 = new javax.swing.JLabel();
        lblVarian3 = new javax.swing.JLabel();
        opsiMenu3 = new javax.swing.JComboBox<>();
        qtyMenu3 = new javax.swing.JSpinner();
        addMenu3 = new javax.swing.JCheckBox();
        panelMenu4 = new javax.swing.JPanel();
        picMenu4 = new javax.swing.JLabel();
        lblMenu4 = new javax.swing.JLabel();
        lblVarian4 = new javax.swing.JLabel();
        opsiMenu4 = new javax.swing.JComboBox<>();
        qtyMenu4 = new javax.swing.JSpinner();
        addMenu4 = new javax.swing.JCheckBox();
        panelMenu5 = new javax.swing.JPanel();
        picMenu5 = new javax.swing.JLabel();
        lblMenu5 = new javax.swing.JLabel();
        lblVarian5 = new javax.swing.JLabel();
        opsiMenu5 = new javax.swing.JComboBox<>();
        qtyMenu5 = new javax.swing.JSpinner();
        addMenu5 = new javax.swing.JCheckBox();
        panelMenu6 = new javax.swing.JPanel();
        picMenu6 = new javax.swing.JLabel();
        lblMenu6 = new javax.swing.JLabel();
        lblVarian6 = new javax.swing.JLabel();
        opsiMenu6 = new javax.swing.JComboBox<>();
        qtyMenu6 = new javax.swing.JSpinner();
        addMenu6 = new javax.swing.JCheckBox();
        panelMenu7 = new javax.swing.JPanel();
        picMenu7 = new javax.swing.JLabel();
        lblMenu7 = new javax.swing.JLabel();
        lblVarian7 = new javax.swing.JLabel();
        opsiMenu7 = new javax.swing.JComboBox<>();
        qtyMenu7 = new javax.swing.JSpinner();
        addMenu7 = new javax.swing.JCheckBox();
        panelMenu8 = new javax.swing.JPanel();
        picMenu8 = new javax.swing.JLabel();
        lblMenu8 = new javax.swing.JLabel();
        lblVarian8 = new javax.swing.JLabel();
        opsiMenu8 = new javax.swing.JComboBox<>();
        qtyMenu8 = new javax.swing.JSpinner();
        addMenu8 = new javax.swing.JCheckBox();
        panelMenu9 = new javax.swing.JPanel();
        picMenu9 = new javax.swing.JLabel();
        lblMenu9 = new javax.swing.JLabel();
        lblVarian9 = new javax.swing.JLabel();
        opsiMenu9 = new javax.swing.JComboBox<>();
        qtyMenu9 = new javax.swing.JSpinner();
        addMenu9 = new javax.swing.JCheckBox();
        panelMenu10 = new javax.swing.JPanel();
        picMenu10 = new javax.swing.JLabel();
        lblMenu10 = new javax.swing.JLabel();
        lblVarian10 = new javax.swing.JLabel();
        opsiMenu10 = new javax.swing.JComboBox<>();
        qtyMenu10 = new javax.swing.JSpinner();
        addMenu10 = new javax.swing.JCheckBox();
        panelMenu11 = new javax.swing.JPanel();
        picMenu11 = new javax.swing.JLabel();
        lblMenu11 = new javax.swing.JLabel();
        lblVarian11 = new javax.swing.JLabel();
        opsiMenu11 = new javax.swing.JComboBox<>();
        qtyMenu11 = new javax.swing.JSpinner();
        addMenu11 = new javax.swing.JCheckBox();
        panelMenu12 = new javax.swing.JPanel();
        picMenu12 = new javax.swing.JLabel();
        lblMenu12 = new javax.swing.JLabel();
        lblVarian12 = new javax.swing.JLabel();
        opsiMenu12 = new javax.swing.JComboBox<>();
        qtyMenu12 = new javax.swing.JSpinner();
        addMenu12 = new javax.swing.JCheckBox();
        panelMenu18 = new javax.swing.JPanel();
        picMenu18 = new javax.swing.JLabel();
        lblMenu18 = new javax.swing.JLabel();
        lblVarian18 = new javax.swing.JLabel();
        opsiMenu18 = new javax.swing.JComboBox<>();
        qtyMenu18 = new javax.swing.JSpinner();
        addMenu18 = new javax.swing.JCheckBox();
        panelMenu16 = new javax.swing.JPanel();
        picMenu16 = new javax.swing.JLabel();
        lblMenu16 = new javax.swing.JLabel();
        lblVarian16 = new javax.swing.JLabel();
        opsiMenu16 = new javax.swing.JComboBox<>();
        qtyMenu16 = new javax.swing.JSpinner();
        addMenu16 = new javax.swing.JCheckBox();
        panelMenu15 = new javax.swing.JPanel();
        picMenu15 = new javax.swing.JLabel();
        lblMenu15 = new javax.swing.JLabel();
        lblVarian15 = new javax.swing.JLabel();
        opsiMenu15 = new javax.swing.JComboBox<>();
        qtyMenu15 = new javax.swing.JSpinner();
        addMenu15 = new javax.swing.JCheckBox();
        panelMenu17 = new javax.swing.JPanel();
        picMenu17 = new javax.swing.JLabel();
        lblMenu17 = new javax.swing.JLabel();
        lblVarian17 = new javax.swing.JLabel();
        opsiMenu17 = new javax.swing.JComboBox<>();
        qtyMenu17 = new javax.swing.JSpinner();
        addMenu17 = new javax.swing.JCheckBox();
        panelMenu14 = new javax.swing.JPanel();
        picMenu14 = new javax.swing.JLabel();
        lblMenu14 = new javax.swing.JLabel();
        lblVarian14 = new javax.swing.JLabel();
        opsiMenu14 = new javax.swing.JComboBox<>();
        qtyMenu14 = new javax.swing.JSpinner();
        addMenu14 = new javax.swing.JCheckBox();
        panelMenu13 = new javax.swing.JPanel();
        picMenu13 = new javax.swing.JLabel();
        lblMenu13 = new javax.swing.JLabel();
        lblVarian13 = new javax.swing.JLabel();
        opsiMenu13 = new javax.swing.JComboBox<>();
        qtyMenu13 = new javax.swing.JSpinner();
        addMenu13 = new javax.swing.JCheckBox();
        rightPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaOrder = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        inputTunai = new javax.swing.JTextField();
        outputKembali = new javax.swing.JTextField();
        btnPrint = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        btnBayar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        outputSubtotal = new javax.swing.JTextField();
        outputPPN = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        outputTotal = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sepanjang Rasa");

        layerDasarHome.setBackground(new java.awt.Color(245, 245, 245));

        topPanel.setBackground(new java.awt.Color(255, 255, 255));
        topPanel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(159, 159, 158), 2, true));
        topPanel.setPreferredSize(new java.awt.Dimension(1536, 80));

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
                .addContainerGap()
                .addComponent(LogoTop, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 1208, Short.MAX_VALUE)
                .addGroup(topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Waktu, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Tanggal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10))
        );
        topPanelLayout.setVerticalGroup(
            topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(topPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(topPanelLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(Waktu, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)
                        .addComponent(Tanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(LogoTop, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8))
        );

        leftPanel.setBackground(new java.awt.Color(255, 255, 255));
        leftPanel.setPreferredSize(new java.awt.Dimension(80, 710));

        javax.swing.GroupLayout leftPanelLayout = new javax.swing.GroupLayout(leftPanel);
        leftPanel.setLayout(leftPanelLayout);
        leftPanelLayout.setHorizontalGroup(
            leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 80, Short.MAX_VALUE)
        );
        leftPanelLayout.setVerticalGroup(
            leftPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        menuPanel.setBackground(new java.awt.Color(245, 245, 245));

        panelMenu1.setBackground(new java.awt.Color(255, 255, 255));

        lblMenu1.setFont(new java.awt.Font("Poppins SemiBold", 0, 14)); // NOI18N
        lblMenu1.setText("Chicken Steak");
        lblMenu1.setPreferredSize(new java.awt.Dimension(135, 20));

        lblVarian1.setFont(new java.awt.Font("Poppins Light", 1, 12)); // NOI18N
        lblVarian1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblVarian1.setText("Varian");

        opsiMenu1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        opsiMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opsiMenu1ActionPerformed(evt);
            }
        });

        qtyMenu1.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        qtyMenu1.setPreferredSize(new java.awt.Dimension(65, 22));

        addMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addMenu1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelMenu1Layout = new javax.swing.GroupLayout(panelMenu1);
        panelMenu1.setLayout(panelMenu1Layout);
        panelMenu1Layout.setHorizontalGroup(
            panelMenu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMenu1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelMenu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelMenu1Layout.createSequentialGroup()
                        .addGroup(panelMenu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelMenu1Layout.createSequentialGroup()
                                .addComponent(qtyMenu1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(addMenu1)
                                .addGap(14, 14, 14))
                            .addGroup(panelMenu1Layout.createSequentialGroup()
                                .addComponent(lblVarian1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(opsiMenu1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 18, Short.MAX_VALUE))
                    .addComponent(picMenu1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblMenu1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelMenu1Layout.setVerticalGroup(
            panelMenu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMenu1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(picMenu1, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblMenu1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelMenu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(opsiMenu1)
                    .addComponent(lblVarian1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(13, 13, 13)
                .addGroup(panelMenu1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(qtyMenu1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(addMenu1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(15, 15, 15))
        );

        panelMenu2.setBackground(new java.awt.Color(255, 255, 255));

        lblMenu2.setFont(new java.awt.Font("Poppins SemiBold", 0, 14)); // NOI18N
        lblMenu2.setText("Chicken Combo");
        lblMenu2.setPreferredSize(new java.awt.Dimension(135, 20));

        lblVarian2.setFont(new java.awt.Font("Poppins Light", 1, 12)); // NOI18N
        lblVarian2.setText("Varian");

        opsiMenu2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        opsiMenu2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opsiMenu2ActionPerformed(evt);
            }
        });

        qtyMenu2.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        qtyMenu2.setPreferredSize(new java.awt.Dimension(65, 22));

        addMenu2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addMenu2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelMenu2Layout = new javax.swing.GroupLayout(panelMenu2);
        panelMenu2.setLayout(panelMenu2Layout);
        panelMenu2Layout.setHorizontalGroup(
            panelMenu2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMenu2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelMenu2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelMenu2Layout.createSequentialGroup()
                        .addGroup(panelMenu2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelMenu2Layout.createSequentialGroup()
                                .addComponent(qtyMenu2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(addMenu2)
                                .addGap(8, 8, 8))
                            .addGroup(panelMenu2Layout.createSequentialGroup()
                                .addComponent(lblVarian2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(opsiMenu2, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 18, Short.MAX_VALUE))
                    .addComponent(picMenu2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblMenu2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelMenu2Layout.setVerticalGroup(
            panelMenu2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMenu2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(picMenu2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblMenu2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelMenu2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(opsiMenu2)
                    .addComponent(lblVarian2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(13, 13, 13)
                .addGroup(panelMenu2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(qtyMenu2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(addMenu2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(15, 15, 15))
        );

        panelMenu3.setBackground(new java.awt.Color(255, 255, 255));

        lblMenu3.setFont(new java.awt.Font("Poppins SemiBold", 0, 14)); // NOI18N
        lblMenu3.setText("Combo Sharing Meals");
        lblMenu3.setPreferredSize(new java.awt.Dimension(135, 20));

        lblVarian3.setFont(new java.awt.Font("Poppins Light", 1, 12)); // NOI18N
        lblVarian3.setText("Varian");

        opsiMenu3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        opsiMenu3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opsiMenu3ActionPerformed(evt);
            }
        });

        qtyMenu3.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        qtyMenu3.setPreferredSize(new java.awt.Dimension(65, 22));

        addMenu3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addMenu3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelMenu3Layout = new javax.swing.GroupLayout(panelMenu3);
        panelMenu3.setLayout(panelMenu3Layout);
        panelMenu3Layout.setHorizontalGroup(
            panelMenu3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMenu3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelMenu3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelMenu3Layout.createSequentialGroup()
                        .addGroup(panelMenu3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelMenu3Layout.createSequentialGroup()
                                .addComponent(qtyMenu3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(addMenu3)
                                .addGap(14, 14, 14))
                            .addGroup(panelMenu3Layout.createSequentialGroup()
                                .addComponent(lblVarian3, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(opsiMenu3, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 24, Short.MAX_VALUE))
                    .addComponent(picMenu3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblMenu3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        panelMenu3Layout.setVerticalGroup(
            panelMenu3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMenu3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(picMenu3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblMenu3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelMenu3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(opsiMenu3)
                    .addComponent(lblVarian3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(13, 13, 13)
                .addGroup(panelMenu3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(qtyMenu3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(addMenu3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(15, 15, 15))
        );

        panelMenu4.setBackground(new java.awt.Color(255, 255, 255));

        lblMenu4.setFont(new java.awt.Font("Poppins SemiBold", 0, 14)); // NOI18N
        lblMenu4.setText("T-Bone Steak");
        lblMenu4.setPreferredSize(new java.awt.Dimension(135, 20));

        lblVarian4.setFont(new java.awt.Font("Poppins Light", 1, 12)); // NOI18N
        lblVarian4.setText("Varian");

        opsiMenu4.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        opsiMenu4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opsiMenu4ActionPerformed(evt);
            }
        });

        qtyMenu4.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        qtyMenu4.setPreferredSize(new java.awt.Dimension(65, 22));

        addMenu4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addMenu4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelMenu4Layout = new javax.swing.GroupLayout(panelMenu4);
        panelMenu4.setLayout(panelMenu4Layout);
        panelMenu4Layout.setHorizontalGroup(
            panelMenu4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMenu4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelMenu4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelMenu4Layout.createSequentialGroup()
                        .addGroup(panelMenu4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelMenu4Layout.createSequentialGroup()
                                .addComponent(qtyMenu4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(addMenu4)
                                .addGap(14, 14, 14))
                            .addGroup(panelMenu4Layout.createSequentialGroup()
                                .addComponent(lblVarian4, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(opsiMenu4, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 18, Short.MAX_VALUE))
                    .addComponent(picMenu4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblMenu4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelMenu4Layout.setVerticalGroup(
            panelMenu4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMenu4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(picMenu4, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblMenu4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelMenu4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(opsiMenu4)
                    .addComponent(lblVarian4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(13, 13, 13)
                .addGroup(panelMenu4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(qtyMenu4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(addMenu4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(15, 15, 15))
        );

        panelMenu5.setBackground(new java.awt.Color(255, 255, 255));

        lblMenu5.setFont(new java.awt.Font("Poppins SemiBold", 0, 14)); // NOI18N
        lblMenu5.setText("Rib Eye Steak");
        lblMenu5.setPreferredSize(new java.awt.Dimension(135, 20));

        lblVarian5.setFont(new java.awt.Font("Poppins Light", 1, 12)); // NOI18N
        lblVarian5.setText("Varian");

        opsiMenu5.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        opsiMenu5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opsiMenu5ActionPerformed(evt);
            }
        });

        qtyMenu5.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        qtyMenu5.setPreferredSize(new java.awt.Dimension(65, 22));

        addMenu5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addMenu5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelMenu5Layout = new javax.swing.GroupLayout(panelMenu5);
        panelMenu5.setLayout(panelMenu5Layout);
        panelMenu5Layout.setHorizontalGroup(
            panelMenu5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMenu5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelMenu5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelMenu5Layout.createSequentialGroup()
                        .addGroup(panelMenu5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelMenu5Layout.createSequentialGroup()
                                .addComponent(qtyMenu5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(addMenu5)
                                .addGap(14, 14, 14))
                            .addGroup(panelMenu5Layout.createSequentialGroup()
                                .addComponent(lblVarian5, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(opsiMenu5, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 19, Short.MAX_VALUE))
                    .addComponent(picMenu5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblMenu5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelMenu5Layout.setVerticalGroup(
            panelMenu5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMenu5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(picMenu5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblMenu5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelMenu5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(opsiMenu5)
                    .addComponent(lblVarian5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(13, 13, 13)
                .addGroup(panelMenu5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(qtyMenu5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(addMenu5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(15, 15, 15))
        );

        panelMenu6.setBackground(new java.awt.Color(255, 255, 255));

        lblMenu6.setFont(new java.awt.Font("Poppins SemiBold", 0, 14)); // NOI18N
        lblMenu6.setText("Sirloin Steak");
        lblMenu6.setPreferredSize(new java.awt.Dimension(135, 20));

        lblVarian6.setFont(new java.awt.Font("Poppins Light", 1, 12)); // NOI18N
        lblVarian6.setText("Varian");

        opsiMenu6.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        opsiMenu6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opsiMenu6ActionPerformed(evt);
            }
        });

        qtyMenu6.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        qtyMenu6.setPreferredSize(new java.awt.Dimension(65, 22));

        addMenu6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addMenu6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelMenu6Layout = new javax.swing.GroupLayout(panelMenu6);
        panelMenu6.setLayout(panelMenu6Layout);
        panelMenu6Layout.setHorizontalGroup(
            panelMenu6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMenu6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelMenu6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelMenu6Layout.createSequentialGroup()
                        .addGroup(panelMenu6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelMenu6Layout.createSequentialGroup()
                                .addComponent(qtyMenu6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(addMenu6)
                                .addGap(14, 14, 14))
                            .addGroup(panelMenu6Layout.createSequentialGroup()
                                .addComponent(lblVarian6, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(opsiMenu6, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 21, Short.MAX_VALUE))
                    .addComponent(picMenu6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblMenu6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelMenu6Layout.setVerticalGroup(
            panelMenu6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMenu6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(picMenu6, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblMenu6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelMenu6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(opsiMenu6)
                    .addComponent(lblVarian6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(13, 13, 13)
                .addGroup(panelMenu6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(qtyMenu6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(addMenu6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(15, 15, 15))
        );

        panelMenu7.setBackground(new java.awt.Color(255, 255, 255));

        lblMenu7.setFont(new java.awt.Font("Poppins SemiBold", 0, 14)); // NOI18N
        lblMenu7.setText("Tenderloin Steak");
        lblMenu7.setPreferredSize(new java.awt.Dimension(135, 20));

        lblVarian7.setFont(new java.awt.Font("Poppins Light", 1, 12)); // NOI18N
        lblVarian7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblVarian7.setText("Varian");

        opsiMenu7.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        opsiMenu7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opsiMenu7ActionPerformed(evt);
            }
        });

        qtyMenu7.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        qtyMenu7.setPreferredSize(new java.awt.Dimension(65, 22));

        addMenu7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addMenu7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelMenu7Layout = new javax.swing.GroupLayout(panelMenu7);
        panelMenu7.setLayout(panelMenu7Layout);
        panelMenu7Layout.setHorizontalGroup(
            panelMenu7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMenu7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelMenu7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelMenu7Layout.createSequentialGroup()
                        .addGroup(panelMenu7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelMenu7Layout.createSequentialGroup()
                                .addComponent(qtyMenu7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(addMenu7)
                                .addGap(14, 14, 14))
                            .addGroup(panelMenu7Layout.createSequentialGroup()
                                .addComponent(lblVarian7, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(opsiMenu7, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 18, Short.MAX_VALUE))
                    .addComponent(picMenu7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblMenu7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelMenu7Layout.setVerticalGroup(
            panelMenu7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMenu7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(picMenu7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblMenu7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelMenu7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(opsiMenu7)
                    .addComponent(lblVarian7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(13, 13, 13)
                .addGroup(panelMenu7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(qtyMenu7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(addMenu7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(15, 15, 15))
        );

        panelMenu8.setBackground(new java.awt.Color(255, 255, 255));

        lblMenu8.setFont(new java.awt.Font("Poppins SemiBold", 0, 14)); // NOI18N
        lblMenu8.setText("Tomahawk Steak");
        lblMenu8.setPreferredSize(new java.awt.Dimension(135, 20));

        lblVarian8.setFont(new java.awt.Font("Poppins Light", 1, 12)); // NOI18N
        lblVarian8.setText("Varian");

        opsiMenu8.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        opsiMenu8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opsiMenu8ActionPerformed(evt);
            }
        });

        qtyMenu8.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        qtyMenu8.setPreferredSize(new java.awt.Dimension(65, 22));

        addMenu8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addMenu8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelMenu8Layout = new javax.swing.GroupLayout(panelMenu8);
        panelMenu8.setLayout(panelMenu8Layout);
        panelMenu8Layout.setHorizontalGroup(
            panelMenu8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMenu8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelMenu8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelMenu8Layout.createSequentialGroup()
                        .addGroup(panelMenu8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelMenu8Layout.createSequentialGroup()
                                .addComponent(qtyMenu8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(addMenu8)
                                .addGap(8, 8, 8))
                            .addGroup(panelMenu8Layout.createSequentialGroup()
                                .addComponent(lblVarian8, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(opsiMenu8, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 18, Short.MAX_VALUE))
                    .addComponent(picMenu8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblMenu8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelMenu8Layout.setVerticalGroup(
            panelMenu8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMenu8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(picMenu8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblMenu8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelMenu8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(opsiMenu8)
                    .addComponent(lblVarian8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(13, 13, 13)
                .addGroup(panelMenu8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(qtyMenu8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(addMenu8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(15, 15, 15))
        );

        panelMenu9.setBackground(new java.awt.Color(255, 255, 255));

        lblMenu9.setFont(new java.awt.Font("Poppins SemiBold", 0, 14)); // NOI18N
        lblMenu9.setText("Expresso Coffe");
        lblMenu9.setPreferredSize(new java.awt.Dimension(135, 20));

        lblVarian9.setFont(new java.awt.Font("Poppins Light", 1, 12)); // NOI18N
        lblVarian9.setText("Varian");

        opsiMenu9.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        opsiMenu9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opsiMenu9ActionPerformed(evt);
            }
        });

        qtyMenu9.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        qtyMenu9.setPreferredSize(new java.awt.Dimension(65, 22));

        addMenu9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addMenu9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelMenu9Layout = new javax.swing.GroupLayout(panelMenu9);
        panelMenu9.setLayout(panelMenu9Layout);
        panelMenu9Layout.setHorizontalGroup(
            panelMenu9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMenu9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelMenu9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelMenu9Layout.createSequentialGroup()
                        .addGroup(panelMenu9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelMenu9Layout.createSequentialGroup()
                                .addComponent(qtyMenu9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(addMenu9)
                                .addGap(14, 14, 14))
                            .addGroup(panelMenu9Layout.createSequentialGroup()
                                .addComponent(lblVarian9, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(opsiMenu9, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 18, Short.MAX_VALUE))
                    .addComponent(picMenu9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblMenu9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelMenu9Layout.setVerticalGroup(
            panelMenu9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMenu9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(picMenu9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblMenu9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelMenu9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(opsiMenu9)
                    .addComponent(lblVarian9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(13, 13, 13)
                .addGroup(panelMenu9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(qtyMenu9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(addMenu9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(15, 15, 15))
        );

        panelMenu10.setBackground(new java.awt.Color(255, 255, 255));

        lblMenu10.setFont(new java.awt.Font("Poppins SemiBold", 0, 14)); // NOI18N
        lblMenu10.setText("Lemon Cucumber");
        lblMenu10.setPreferredSize(new java.awt.Dimension(135, 20));

        lblVarian10.setFont(new java.awt.Font("Poppins Light", 1, 12)); // NOI18N
        lblVarian10.setText("Varian");

        opsiMenu10.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        opsiMenu10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opsiMenu10ActionPerformed(evt);
            }
        });

        qtyMenu10.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        qtyMenu10.setPreferredSize(new java.awt.Dimension(65, 22));

        addMenu10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addMenu10ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelMenu10Layout = new javax.swing.GroupLayout(panelMenu10);
        panelMenu10.setLayout(panelMenu10Layout);
        panelMenu10Layout.setHorizontalGroup(
            panelMenu10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMenu10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelMenu10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelMenu10Layout.createSequentialGroup()
                        .addGroup(panelMenu10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelMenu10Layout.createSequentialGroup()
                                .addComponent(qtyMenu10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(addMenu10)
                                .addGap(14, 14, 14))
                            .addGroup(panelMenu10Layout.createSequentialGroup()
                                .addComponent(lblVarian10, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(opsiMenu10, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 18, Short.MAX_VALUE))
                    .addComponent(picMenu10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblMenu10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelMenu10Layout.setVerticalGroup(
            panelMenu10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMenu10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(picMenu10, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblMenu10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelMenu10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(opsiMenu10)
                    .addComponent(lblVarian10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(13, 13, 13)
                .addGroup(panelMenu10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(qtyMenu10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(addMenu10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(15, 15, 15))
        );

        panelMenu11.setBackground(new java.awt.Color(255, 255, 255));

        lblMenu11.setFont(new java.awt.Font("Poppins SemiBold", 0, 14)); // NOI18N
        lblMenu11.setText("Perrier");
        lblMenu11.setPreferredSize(new java.awt.Dimension(135, 20));

        lblVarian11.setFont(new java.awt.Font("Poppins Light", 1, 12)); // NOI18N
        lblVarian11.setText("Varian");

        opsiMenu11.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        opsiMenu11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opsiMenu11ActionPerformed(evt);
            }
        });

        qtyMenu11.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        qtyMenu11.setPreferredSize(new java.awt.Dimension(65, 22));

        addMenu11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addMenu11ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelMenu11Layout = new javax.swing.GroupLayout(panelMenu11);
        panelMenu11.setLayout(panelMenu11Layout);
        panelMenu11Layout.setHorizontalGroup(
            panelMenu11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMenu11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelMenu11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelMenu11Layout.createSequentialGroup()
                        .addGroup(panelMenu11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelMenu11Layout.createSequentialGroup()
                                .addComponent(qtyMenu11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(addMenu11)
                                .addGap(14, 14, 14))
                            .addGroup(panelMenu11Layout.createSequentialGroup()
                                .addComponent(lblVarian11, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(opsiMenu11, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 19, Short.MAX_VALUE))
                    .addComponent(picMenu11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblMenu11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelMenu11Layout.setVerticalGroup(
            panelMenu11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMenu11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(picMenu11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblMenu11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelMenu11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(opsiMenu11)
                    .addComponent(lblVarian11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(13, 13, 13)
                .addGroup(panelMenu11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(qtyMenu11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(addMenu11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(15, 15, 15))
        );

        panelMenu12.setBackground(new java.awt.Color(255, 255, 255));

        lblMenu12.setFont(new java.awt.Font("Poppins SemiBold", 0, 14)); // NOI18N
        lblMenu12.setText("Strawberry Lemonade");
        lblMenu12.setPreferredSize(new java.awt.Dimension(135, 20));

        lblVarian12.setFont(new java.awt.Font("Poppins Light", 1, 12)); // NOI18N
        lblVarian12.setText("Varian");

        opsiMenu12.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        opsiMenu12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opsiMenu12ActionPerformed(evt);
            }
        });

        qtyMenu12.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        qtyMenu12.setPreferredSize(new java.awt.Dimension(65, 22));

        addMenu12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addMenu12ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelMenu12Layout = new javax.swing.GroupLayout(panelMenu12);
        panelMenu12.setLayout(panelMenu12Layout);
        panelMenu12Layout.setHorizontalGroup(
            panelMenu12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMenu12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelMenu12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelMenu12Layout.createSequentialGroup()
                        .addGroup(panelMenu12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelMenu12Layout.createSequentialGroup()
                                .addComponent(qtyMenu12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(addMenu12)
                                .addGap(14, 14, 14))
                            .addGroup(panelMenu12Layout.createSequentialGroup()
                                .addComponent(lblVarian12, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(opsiMenu12, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 24, Short.MAX_VALUE))
                    .addComponent(picMenu12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblMenu12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelMenu12Layout.setVerticalGroup(
            panelMenu12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMenu12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(picMenu12, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblMenu12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelMenu12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(opsiMenu12)
                    .addComponent(lblVarian12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(13, 13, 13)
                .addGroup(panelMenu12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(qtyMenu12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(addMenu12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(15, 15, 15))
        );

        panelMenu18.setBackground(new java.awt.Color(255, 255, 255));

        lblMenu18.setFont(new java.awt.Font("Poppins SemiBold", 0, 14)); // NOI18N
        lblMenu18.setText("Creme Crumble");
        lblMenu18.setPreferredSize(new java.awt.Dimension(135, 20));

        lblVarian18.setFont(new java.awt.Font("Poppins Light", 1, 12)); // NOI18N
        lblVarian18.setText("Varian");

        opsiMenu18.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        opsiMenu18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opsiMenu18ActionPerformed(evt);
            }
        });

        qtyMenu18.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        qtyMenu18.setPreferredSize(new java.awt.Dimension(65, 22));

        addMenu18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addMenu18ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelMenu18Layout = new javax.swing.GroupLayout(panelMenu18);
        panelMenu18.setLayout(panelMenu18Layout);
        panelMenu18Layout.setHorizontalGroup(
            panelMenu18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMenu18Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelMenu18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelMenu18Layout.createSequentialGroup()
                        .addGroup(panelMenu18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelMenu18Layout.createSequentialGroup()
                                .addComponent(qtyMenu18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(addMenu18)
                                .addGap(14, 14, 14))
                            .addGroup(panelMenu18Layout.createSequentialGroup()
                                .addComponent(lblVarian18, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(opsiMenu18, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 18, Short.MAX_VALUE))
                    .addComponent(picMenu18, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblMenu18, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelMenu18Layout.setVerticalGroup(
            panelMenu18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMenu18Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(picMenu18, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblMenu18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelMenu18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(opsiMenu18)
                    .addComponent(lblVarian18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(13, 13, 13)
                .addGroup(panelMenu18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(qtyMenu18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(addMenu18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(15, 15, 15))
        );

        panelMenu16.setBackground(new java.awt.Color(255, 255, 255));

        lblMenu16.setFont(new java.awt.Font("Poppins SemiBold", 0, 14)); // NOI18N
        lblMenu16.setText("Chocolate Lava Cake");
        lblMenu16.setPreferredSize(new java.awt.Dimension(135, 20));

        lblVarian16.setFont(new java.awt.Font("Poppins Light", 1, 12)); // NOI18N
        lblVarian16.setText("Varian");

        opsiMenu16.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        opsiMenu16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opsiMenu16ActionPerformed(evt);
            }
        });

        qtyMenu16.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        qtyMenu16.setPreferredSize(new java.awt.Dimension(65, 22));

        addMenu16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addMenu16ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelMenu16Layout = new javax.swing.GroupLayout(panelMenu16);
        panelMenu16.setLayout(panelMenu16Layout);
        panelMenu16Layout.setHorizontalGroup(
            panelMenu16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMenu16Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelMenu16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelMenu16Layout.createSequentialGroup()
                        .addGroup(panelMenu16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelMenu16Layout.createSequentialGroup()
                                .addComponent(qtyMenu16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(addMenu16)
                                .addGap(14, 14, 14))
                            .addGroup(panelMenu16Layout.createSequentialGroup()
                                .addComponent(lblVarian16, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(opsiMenu16, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 18, Short.MAX_VALUE))
                    .addComponent(picMenu16, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblMenu16, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelMenu16Layout.setVerticalGroup(
            panelMenu16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMenu16Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(picMenu16, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblMenu16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelMenu16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(opsiMenu16)
                    .addComponent(lblVarian16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(13, 13, 13)
                .addGroup(panelMenu16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(qtyMenu16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(addMenu16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(15, 15, 15))
        );

        panelMenu15.setBackground(new java.awt.Color(255, 255, 255));

        lblMenu15.setFont(new java.awt.Font("Poppins SemiBold", 0, 14)); // NOI18N
        lblMenu15.setText("Cheesecake");
        lblMenu15.setPreferredSize(new java.awt.Dimension(135, 20));

        lblVarian15.setFont(new java.awt.Font("Poppins Light", 1, 12)); // NOI18N
        lblVarian15.setText("Varian");

        opsiMenu15.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        opsiMenu15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opsiMenu15ActionPerformed(evt);
            }
        });

        qtyMenu15.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        qtyMenu15.setPreferredSize(new java.awt.Dimension(65, 22));

        addMenu15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addMenu15ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelMenu15Layout = new javax.swing.GroupLayout(panelMenu15);
        panelMenu15.setLayout(panelMenu15Layout);
        panelMenu15Layout.setHorizontalGroup(
            panelMenu15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMenu15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelMenu15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelMenu15Layout.createSequentialGroup()
                        .addGroup(panelMenu15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelMenu15Layout.createSequentialGroup()
                                .addComponent(qtyMenu15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(addMenu15)
                                .addGap(14, 14, 14))
                            .addGroup(panelMenu15Layout.createSequentialGroup()
                                .addComponent(lblVarian15, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(opsiMenu15, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 18, Short.MAX_VALUE))
                    .addComponent(picMenu15, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblMenu15, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelMenu15Layout.setVerticalGroup(
            panelMenu15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMenu15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(picMenu15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblMenu15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelMenu15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(opsiMenu15)
                    .addComponent(lblVarian15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(13, 13, 13)
                .addGroup(panelMenu15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(qtyMenu15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(addMenu15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(15, 15, 15))
        );

        panelMenu17.setBackground(new java.awt.Color(255, 255, 255));

        lblMenu17.setFont(new java.awt.Font("Poppins SemiBold", 0, 14)); // NOI18N
        lblMenu17.setText("Tiramisu");
        lblMenu17.setPreferredSize(new java.awt.Dimension(135, 20));

        lblVarian17.setFont(new java.awt.Font("Poppins Light", 1, 12)); // NOI18N
        lblVarian17.setText("Varian");

        opsiMenu17.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        opsiMenu17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opsiMenu17ActionPerformed(evt);
            }
        });

        qtyMenu17.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        qtyMenu17.setPreferredSize(new java.awt.Dimension(65, 22));

        addMenu17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addMenu17ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelMenu17Layout = new javax.swing.GroupLayout(panelMenu17);
        panelMenu17.setLayout(panelMenu17Layout);
        panelMenu17Layout.setHorizontalGroup(
            panelMenu17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMenu17Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelMenu17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelMenu17Layout.createSequentialGroup()
                        .addGroup(panelMenu17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelMenu17Layout.createSequentialGroup()
                                .addComponent(qtyMenu17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(addMenu17)
                                .addGap(14, 14, 14))
                            .addGroup(panelMenu17Layout.createSequentialGroup()
                                .addComponent(lblVarian17, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(opsiMenu17, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 19, Short.MAX_VALUE))
                    .addComponent(picMenu17, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblMenu17, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelMenu17Layout.setVerticalGroup(
            panelMenu17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMenu17Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(picMenu17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblMenu17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelMenu17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(opsiMenu17)
                    .addComponent(lblVarian17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(13, 13, 13)
                .addGroup(panelMenu17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(qtyMenu17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(addMenu17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(15, 15, 15))
        );

        panelMenu14.setBackground(new java.awt.Color(255, 255, 255));

        lblMenu14.setFont(new java.awt.Font("Poppins SemiBold", 0, 14)); // NOI18N
        lblMenu14.setText("Aplle Crumble");
        lblMenu14.setPreferredSize(new java.awt.Dimension(135, 20));

        lblVarian14.setFont(new java.awt.Font("Poppins Light", 1, 12)); // NOI18N
        lblVarian14.setText("Varian");

        opsiMenu14.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        opsiMenu14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opsiMenu14ActionPerformed(evt);
            }
        });

        qtyMenu14.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        qtyMenu14.setPreferredSize(new java.awt.Dimension(65, 22));

        addMenu14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addMenu14ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelMenu14Layout = new javax.swing.GroupLayout(panelMenu14);
        panelMenu14.setLayout(panelMenu14Layout);
        panelMenu14Layout.setHorizontalGroup(
            panelMenu14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMenu14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelMenu14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelMenu14Layout.createSequentialGroup()
                        .addGroup(panelMenu14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelMenu14Layout.createSequentialGroup()
                                .addComponent(qtyMenu14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(addMenu14)
                                .addGap(8, 8, 8))
                            .addGroup(panelMenu14Layout.createSequentialGroup()
                                .addComponent(lblVarian14, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(opsiMenu14, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 18, Short.MAX_VALUE))
                    .addComponent(picMenu14, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblMenu14, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelMenu14Layout.setVerticalGroup(
            panelMenu14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMenu14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(picMenu14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblMenu14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelMenu14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(opsiMenu14)
                    .addComponent(lblVarian14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(13, 13, 13)
                .addGroup(panelMenu14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(qtyMenu14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(addMenu14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(15, 15, 15))
        );

        panelMenu13.setBackground(new java.awt.Color(255, 255, 255));

        lblMenu13.setFont(new java.awt.Font("Poppins SemiBold", 0, 14)); // NOI18N
        lblMenu13.setText("Virgin Mojito");
        lblMenu13.setPreferredSize(new java.awt.Dimension(135, 20));

        lblVarian13.setFont(new java.awt.Font("Poppins Light", 1, 12)); // NOI18N
        lblVarian13.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblVarian13.setText("Varian");

        opsiMenu13.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        opsiMenu13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opsiMenu13ActionPerformed(evt);
            }
        });

        qtyMenu13.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        qtyMenu13.setPreferredSize(new java.awt.Dimension(65, 22));

        addMenu13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addMenu13ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelMenu13Layout = new javax.swing.GroupLayout(panelMenu13);
        panelMenu13.setLayout(panelMenu13Layout);
        panelMenu13Layout.setHorizontalGroup(
            panelMenu13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMenu13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelMenu13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelMenu13Layout.createSequentialGroup()
                        .addGroup(panelMenu13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(panelMenu13Layout.createSequentialGroup()
                                .addComponent(qtyMenu13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(addMenu13)
                                .addGap(14, 14, 14))
                            .addGroup(panelMenu13Layout.createSequentialGroup()
                                .addComponent(lblVarian13, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(opsiMenu13, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 18, Short.MAX_VALUE))
                    .addComponent(picMenu13, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblMenu13, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelMenu13Layout.setVerticalGroup(
            panelMenu13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMenu13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(picMenu13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblMenu13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelMenu13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(opsiMenu13)
                    .addComponent(lblVarian13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(13, 13, 13)
                .addGroup(panelMenu13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(qtyMenu13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(addMenu13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(15, 15, 15))
        );

        rightPanel.setBackground(new java.awt.Color(245, 245, 245));
        rightPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(159, 159, 158), 2));

        jTextAreaOrder.setColumns(20);
        jTextAreaOrder.setRows(5);
        jScrollPane1.setViewportView(jTextAreaOrder);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(159, 159, 158), 2));

        jLabel4.setFont(new java.awt.Font("Poppins Medium", 0, 13)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("Tunai");
        jLabel4.setPreferredSize(new java.awt.Dimension(55, 25));

        jLabel5.setFont(new java.awt.Font("Poppins Medium", 0, 13)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("Kembali");
        jLabel5.setPreferredSize(new java.awt.Dimension(55, 25));

        inputTunai.setBackground(new java.awt.Color(245, 245, 245));
        inputTunai.setFont(new java.awt.Font("Poppins Medium", 0, 13)); // NOI18N
        inputTunai.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        inputTunai.setBorder(null);

        outputKembali.setBackground(new java.awt.Color(245, 245, 245));
        outputKembali.setFont(new java.awt.Font("Poppins Medium", 0, 13)); // NOI18N
        outputKembali.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        outputKembali.setBorder(null);
        outputKembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                outputKembaliActionPerformed(evt);
            }
        });

        btnPrint.setBackground(new java.awt.Color(9, 170, 41));
        btnPrint.setFont(new java.awt.Font("Poppins SemiBold", 0, 14)); // NOI18N
        btnPrint.setForeground(new java.awt.Color(255, 255, 255));
        btnPrint.setText("Print");
        btnPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintActionPerformed(evt);
            }
        });

        btnReset.setBackground(new java.awt.Color(51, 120, 229));
        btnReset.setFont(new java.awt.Font("Poppins SemiBold", 0, 14)); // NOI18N
        btnReset.setForeground(new java.awt.Color(255, 255, 255));
        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        btnBayar.setBackground(new java.awt.Color(252, 128, 25));
        btnBayar.setFont(new java.awt.Font("Poppins SemiBold", 0, 14)); // NOI18N
        btnBayar.setForeground(new java.awt.Color(255, 255, 255));
        btnBayar.setText("Bayar");
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
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(65, 65, 65)
                                .addComponent(inputTunai))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(65, 65, 65)
                                .addComponent(outputKembali))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17)
                        .addComponent(btnBayar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputTunai, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(outputKembali, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPrint, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBayar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
        );

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("Subtotal");
        jLabel1.setPreferredSize(new java.awt.Dimension(55, 25));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("PPN 12%");
        jLabel2.setPreferredSize(new java.awt.Dimension(55, 25));

        outputSubtotal.setBackground(new java.awt.Color(245, 245, 245));
        outputSubtotal.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        outputSubtotal.setBorder(null);

        outputPPN.setBackground(new java.awt.Color(245, 245, 245));
        outputPPN.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        outputPPN.setBorder(null);

        jLabel3.setFont(new java.awt.Font("Poppins Medium", 0, 13)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("Total");
        jLabel3.setPreferredSize(new java.awt.Dimension(55, 25));

        outputTotal.setBackground(new java.awt.Color(245, 245, 245));
        outputTotal.setFont(new java.awt.Font("Poppins Medium", 0, 13)); // NOI18N
        outputTotal.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        outputTotal.setBorder(null);
        outputTotal.setPreferredSize(new java.awt.Dimension(181, 25));

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
                        .addGroup(rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(outputTotal, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                            .addComponent(outputPPN)
                            .addComponent(outputSubtotal))))
                .addContainerGap())
        );
        rightPanelLayout.setVerticalGroup(
            rightPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rightPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout menuPanelLayout = new javax.swing.GroupLayout(menuPanel);
        menuPanel.setLayout(menuPanelLayout);
        menuPanelLayout.setHorizontalGroup(
            menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuPanelLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(menuPanelLayout.createSequentialGroup()
                        .addComponent(panelMenu13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(panelMenu14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(panelMenu15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(panelMenu16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(panelMenu17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(panelMenu18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(menuPanelLayout.createSequentialGroup()
                        .addComponent(panelMenu1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(panelMenu2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(panelMenu3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(panelMenu4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(panelMenu5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(panelMenu6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(menuPanelLayout.createSequentialGroup()
                        .addComponent(panelMenu7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(panelMenu8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(panelMenu9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(panelMenu10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(panelMenu11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(panelMenu12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(rightPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        menuPanelLayout.setVerticalGroup(
            menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuPanelLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(panelMenu4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(panelMenu3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(panelMenu2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(panelMenu5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(panelMenu6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelMenu1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(panelMenu10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(panelMenu9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(panelMenu8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(panelMenu7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(panelMenu11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(panelMenu12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(panelMenu16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(panelMenu15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(panelMenu14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(panelMenu13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(panelMenu17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(panelMenu18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(7, Short.MAX_VALUE))
            .addComponent(rightPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layerDasarHomeLayout = new javax.swing.GroupLayout(layerDasarHome);
        layerDasarHome.setLayout(layerDasarHomeLayout);
        layerDasarHomeLayout.setHorizontalGroup(
            layerDasarHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layerDasarHomeLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(layerDasarHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(topPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layerDasarHomeLayout.createSequentialGroup()
                        .addComponent(leftPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(menuPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(0, 0, 0))
        );
        layerDasarHomeLayout.setVerticalGroup(
            layerDasarHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layerDasarHomeLayout.createSequentialGroup()
                .addComponent(topPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layerDasarHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(menuPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(leftPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 689, Short.MAX_VALUE)))
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
        int qty = Integer.parseInt(qtyMenu1.getValue().toString());
        if(qtyIsZero(qty) && addMenu1.isSelected()){
            x++;
            if(x==1){
                orderList();
            }
            double price = qty*69000;
            subtotal += price;
            jTextAreaOrder.setText(jTextAreaOrder.getText()+x+". "+lblMenu1.getText()+"\t"+qty+"\t"+price+"\n");
            hitung();
        }else{
            addMenu1.setSelected(false);
        }
    }//GEN-LAST:event_addMenu1ActionPerformed

    private void opsiMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opsiMenu1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_opsiMenu1ActionPerformed

    private void opsiMenu2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opsiMenu2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_opsiMenu2ActionPerformed

    private void addMenu2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addMenu2ActionPerformed
        int qty = Integer.parseInt(qtyMenu2.getValue().toString());
        if(qtyIsZero(qty) && addMenu2.isSelected()){
            x++;
            if(x==1){
                orderList();
            }
            double price = qty*108000;
            subtotal += price;
            jTextAreaOrder.setText(jTextAreaOrder.getText()+x+". "+lblMenu2.getText()+"\t"+qty+"\t"+price+"\n");
            hitung();
        }else{
            addMenu2.setSelected(false);
        }
    }//GEN-LAST:event_addMenu2ActionPerformed

    private void opsiMenu3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opsiMenu3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_opsiMenu3ActionPerformed

    private void addMenu3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addMenu3ActionPerformed
        int qty = Integer.parseInt(qtyMenu3.getValue().toString());
        if(qtyIsZero(qty) && addMenu3.isSelected()){
            x++;
            if(x==1){
                orderList();
            }
            double price = qty*241000;
            subtotal += price;
            jTextAreaOrder.setText(jTextAreaOrder.getText()+x+". "+lblMenu3.getText()+"\t"+qty+"\t"+price+"\n");
            hitung();
        }else{
            addMenu3.setSelected(false);
        }
    }//GEN-LAST:event_addMenu3ActionPerformed

    private void opsiMenu4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opsiMenu4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_opsiMenu4ActionPerformed

    private void addMenu4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addMenu4ActionPerformed
        int qty = Integer.parseInt(qtyMenu4.getValue().toString());
        if(qtyIsZero(qty) && addMenu4.isSelected()){
            x++;
            if(x==1){
                orderList();
            }
            double price = qty*150000;
            subtotal += price;
            jTextAreaOrder.setText(jTextAreaOrder.getText()+x+". "+lblMenu4.getText()+"\t"+qty+"\t"+price+"\n");
            hitung();
        }else{
            addMenu4.setSelected(false);
        }
    }//GEN-LAST:event_addMenu4ActionPerformed

    private void opsiMenu5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opsiMenu5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_opsiMenu5ActionPerformed

    private void addMenu5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addMenu5ActionPerformed
        int qty = Integer.parseInt(qtyMenu5.getValue().toString());
        if(qtyIsZero(qty) && addMenu5.isSelected()){
            x++;
            if(x==1){
                orderList();
            }
            double price = qty*119000;
            subtotal += price;
            jTextAreaOrder.setText(jTextAreaOrder.getText()+x+". "+lblMenu5.getText()+"\t"+qty+"\t"+price+"\n");
            hitung();
        }else{
            addMenu5.setSelected(false);
        }
    }//GEN-LAST:event_addMenu5ActionPerformed

    private void opsiMenu6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opsiMenu6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_opsiMenu6ActionPerformed

    private void addMenu6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addMenu6ActionPerformed
        int qty = Integer.parseInt(qtyMenu6.getValue().toString());
        if(qtyIsZero(qty) && addMenu6.isSelected()){
            x++;
            if(x==1){
                orderList();
            }
            double price = qty*116000;
            subtotal += price;
            jTextAreaOrder.setText(jTextAreaOrder.getText()+x+". "+lblMenu6.getText()+"\t\t"+qty+"\t"+price+"\n");
            hitung();
        }else{
            addMenu6.setSelected(false);
        }
    }//GEN-LAST:event_addMenu6ActionPerformed

    private void opsiMenu7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opsiMenu7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_opsiMenu7ActionPerformed

    private void addMenu7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addMenu7ActionPerformed
        int qty = Integer.parseInt(qtyMenu7.getValue().toString());
        if(qtyIsZero(qty) && addMenu7.isSelected()){
            x++;
            if(x==1){
                orderList();
            }
            double price = qty*141000;
            subtotal += price;
            jTextAreaOrder.setText(jTextAreaOrder.getText()+x+". "+lblMenu7.getText()+"\t"+qty+"\t"+price+"\n");
            hitung();
        }else{
            addMenu7.setSelected(false);
        }
    }//GEN-LAST:event_addMenu7ActionPerformed

    private void opsiMenu8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opsiMenu8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_opsiMenu8ActionPerformed

    private void addMenu8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addMenu8ActionPerformed
        int qty = Integer.parseInt(qtyMenu8.getValue().toString());
        if(qtyIsZero(qty) && addMenu8.isSelected()){
            x++;
            if(x==1){
                orderList();
            }
            double price = qty*176000;
            subtotal += price;
            jTextAreaOrder.setText(jTextAreaOrder.getText()+x+". "+lblMenu8.getText()+"\t"+qty+"\t"+price+"\n");
            hitung();
        }else{
            addMenu8.setSelected(false);
        }
    }//GEN-LAST:event_addMenu8ActionPerformed

    private void opsiMenu9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opsiMenu9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_opsiMenu9ActionPerformed

    private void addMenu9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addMenu9ActionPerformed
        int qty = Integer.parseInt(qtyMenu9.getValue().toString());
        if(qtyIsZero(qty) && addMenu9.isSelected()){
            x++;
            if(x==1){
                orderList();
            }
            double price = qty*45000;
            subtotal += price;
            jTextAreaOrder.setText(jTextAreaOrder.getText()+x+". "+lblMenu9.getText()+"\t"+qty+"\t"+price+"\n");
            hitung();
        }else{
            addMenu9.setSelected(false);
        }
    }//GEN-LAST:event_addMenu9ActionPerformed

    private void opsiMenu10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opsiMenu10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_opsiMenu10ActionPerformed

    private void addMenu10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addMenu10ActionPerformed
        int qty = Integer.parseInt(qtyMenu10.getValue().toString());
        if(qtyIsZero(qty) && addMenu10.isSelected()){
            x++;
            if(x==1){
                orderList();
            }
            double price = qty*55000;
            subtotal += price;
            jTextAreaOrder.setText(jTextAreaOrder.getText()+x+". "+lblMenu10.getText()+"\t"+qty+"\t"+price+"\n");
            hitung();
        }else{
            addMenu10.setSelected(false);
        }
    }//GEN-LAST:event_addMenu10ActionPerformed

    private void opsiMenu11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opsiMenu11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_opsiMenu11ActionPerformed

    private void addMenu11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addMenu11ActionPerformed
        int qty = Integer.parseInt(qtyMenu11.getValue().toString());
        if(qtyIsZero(qty) && addMenu11.isSelected()){
            x++;
            if(x==1){
                orderList();
            }
            double price = qty*69000;
            subtotal += price;
            jTextAreaOrder.setText(jTextAreaOrder.getText()+x+". "+lblMenu11.getText()+"\t\t"+qty+"\t"+price+"\n");
            hitung();
        }else{
            addMenu11.setSelected(false);
        }
    }//GEN-LAST:event_addMenu11ActionPerformed

    private void opsiMenu12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opsiMenu12ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_opsiMenu12ActionPerformed

    private void addMenu12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addMenu12ActionPerformed
        int qty = Integer.parseInt(qtyMenu12.getValue().toString());
        if(qtyIsZero(qty) && addMenu12.isSelected()){
            x++;
            if(x==1){
                orderList();
            }
            double price = qty*57000;
            subtotal += price;
            jTextAreaOrder.setText(jTextAreaOrder.getText()+x+". "+lblMenu12.getText()+"\t"+qty+"\t"+price+"\n");
            hitung();
        }else{
            addMenu12.setSelected(false);
        }
    }//GEN-LAST:event_addMenu12ActionPerformed

    private void opsiMenu18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opsiMenu18ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_opsiMenu18ActionPerformed

    private void addMenu18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addMenu18ActionPerformed
        int qty = Integer.parseInt(qtyMenu18.getValue().toString());
        if(qtyIsZero(qty) && addMenu18.isSelected()){
            x++;
            if(x==1){
                orderList();
            }
            double price = qty*130000;
            subtotal += price;
            jTextAreaOrder.setText(jTextAreaOrder.getText()+x+". "+lblMenu18.getText()+"\t"+qty+"\t"+price+"\n");
            hitung();
        }else{
            addMenu18.setSelected(false);
        }
    }//GEN-LAST:event_addMenu18ActionPerformed

    private void opsiMenu16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opsiMenu16ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_opsiMenu16ActionPerformed

    private void addMenu16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addMenu16ActionPerformed
        int qty = Integer.parseInt(qtyMenu16.getValue().toString());
        if(qtyIsZero(qty) && addMenu16.isSelected()){
            x++;
            if(x==1){
                orderList();
            }
            double price = qty*97000;
            subtotal += price;
            jTextAreaOrder.setText(jTextAreaOrder.getText()+x+". "+lblMenu16.getText()+"\t"+qty+"\t"+price+"\n");
            hitung();
        }else{
            addMenu16.setSelected(false);
        }
    }//GEN-LAST:event_addMenu16ActionPerformed

    private void opsiMenu15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opsiMenu15ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_opsiMenu15ActionPerformed

    private void addMenu15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addMenu15ActionPerformed
        int qty = Integer.parseInt(qtyMenu15.getValue().toString());
        if(qtyIsZero(qty) && addMenu15.isSelected()){
            x++;
            if(x==1){
                orderList();
            }
            double price = qty*81000;
            subtotal += price;
            jTextAreaOrder.setText(jTextAreaOrder.getText()+x+". "+lblMenu15.getText()+"\t\t"+qty+"\t"+price+"\n");
            hitung();
        }else{
            addMenu15.setSelected(false);
        }
    }//GEN-LAST:event_addMenu15ActionPerformed

    private void opsiMenu17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opsiMenu17ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_opsiMenu17ActionPerformed

    private void addMenu17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addMenu17ActionPerformed
        int qty = Integer.parseInt(qtyMenu17.getValue().toString());
        if(qtyIsZero(qty) && addMenu17.isSelected()){
            x++;
            if(x==1){
                orderList();
            }
            double price = qty*93000;
            subtotal += price;
            jTextAreaOrder.setText(jTextAreaOrder.getText()+x+". "+lblMenu17.getText()+"\t\t"+qty+"\t"+price+"\n");
            hitung();
        }else{
            addMenu17.setSelected(false);
        }
    }//GEN-LAST:event_addMenu17ActionPerformed

    private void opsiMenu14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opsiMenu14ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_opsiMenu14ActionPerformed

    private void addMenu14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addMenu14ActionPerformed
        int qty = Integer.parseInt(qtyMenu14.getValue().toString());
        if(qtyIsZero(qty) && addMenu14.isSelected()){
            x++;
            if(x==1){
                orderList();
            }
            double price = qty*110000;
            subtotal += price;
            jTextAreaOrder.setText(jTextAreaOrder.getText()+x+". "+lblMenu14.getText()+"\t"+qty+"\t"+price+"\n");
            hitung();
        }else{
            addMenu14.setSelected(false);
        }
    }//GEN-LAST:event_addMenu14ActionPerformed

    private void opsiMenu13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opsiMenu13ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_opsiMenu13ActionPerformed

    private void addMenu13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addMenu13ActionPerformed
        int qty = Integer.parseInt(qtyMenu13.getValue().toString());
        if(qtyIsZero(qty) && addMenu13.isSelected()){
            x++;
            if(x==1){
                orderList();
            }
            double price = qty*55000;
            subtotal += price;
            jTextAreaOrder.setText(jTextAreaOrder.getText()+x+". "+lblMenu13.getText()+"\t\t"+qty+"\t"+price+"\n");
            hitung();
        }else{
            addMenu13.setSelected(false);
        }
    }//GEN-LAST:event_addMenu13ActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        reset();
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnBayarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBayarActionPerformed
        tunai = Double.parseDouble(inputTunai.getText());
        kembali = tunai - total;
        
        if(tunai==0.0){
            JOptionPane.showMessageDialog(null,("Masukkan nominal tunai"));
        }else{
          outputKembali.setText(outputKembali.getText()+kembali); 
          btnBayar.setEnabled(false);
        } 
    }//GEN-LAST:event_btnBayarActionPerformed

    private void btnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintActionPerformed
          
    }//GEN-LAST:event_btnPrintActionPerformed

    private void outputKembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_outputKembaliActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_outputKembaliActionPerformed

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
                new HomePage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LogoTop;
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
    private javax.swing.JCheckBox addMenu2;
    private javax.swing.JCheckBox addMenu3;
    private javax.swing.JCheckBox addMenu4;
    private javax.swing.JCheckBox addMenu5;
    private javax.swing.JCheckBox addMenu6;
    private javax.swing.JCheckBox addMenu7;
    private javax.swing.JCheckBox addMenu8;
    private javax.swing.JCheckBox addMenu9;
    private javax.swing.JButton btnBayar;
    private javax.swing.JButton btnPrint;
    private javax.swing.JButton btnReset;
    private javax.swing.JTextField inputTunai;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
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
    private javax.swing.JLabel lblMenu2;
    private javax.swing.JLabel lblMenu3;
    private javax.swing.JLabel lblMenu4;
    private javax.swing.JLabel lblMenu5;
    private javax.swing.JLabel lblMenu6;
    private javax.swing.JLabel lblMenu7;
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
    private javax.swing.JLabel lblVarian2;
    private javax.swing.JLabel lblVarian3;
    private javax.swing.JLabel lblVarian4;
    private javax.swing.JLabel lblVarian5;
    private javax.swing.JLabel lblVarian6;
    private javax.swing.JLabel lblVarian7;
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
    private javax.swing.JComboBox<String> opsiMenu2;
    private javax.swing.JComboBox<String> opsiMenu3;
    private javax.swing.JComboBox<String> opsiMenu4;
    private javax.swing.JComboBox<String> opsiMenu5;
    private javax.swing.JComboBox<String> opsiMenu6;
    private javax.swing.JComboBox<String> opsiMenu7;
    private javax.swing.JComboBox<String> opsiMenu8;
    private javax.swing.JComboBox<String> opsiMenu9;
    private javax.swing.JTextField outputKembali;
    private javax.swing.JTextField outputPPN;
    private javax.swing.JTextField outputSubtotal;
    private javax.swing.JTextField outputTotal;
    private javax.swing.JPanel panelMenu1;
    private javax.swing.JPanel panelMenu10;
    private javax.swing.JPanel panelMenu11;
    private javax.swing.JPanel panelMenu12;
    private javax.swing.JPanel panelMenu13;
    private javax.swing.JPanel panelMenu14;
    private javax.swing.JPanel panelMenu15;
    private javax.swing.JPanel panelMenu16;
    private javax.swing.JPanel panelMenu17;
    private javax.swing.JPanel panelMenu18;
    private javax.swing.JPanel panelMenu2;
    private javax.swing.JPanel panelMenu3;
    private javax.swing.JPanel panelMenu4;
    private javax.swing.JPanel panelMenu5;
    private javax.swing.JPanel panelMenu6;
    private javax.swing.JPanel panelMenu7;
    private javax.swing.JPanel panelMenu8;
    private javax.swing.JPanel panelMenu9;
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
    private javax.swing.JLabel picMenu2;
    private javax.swing.JLabel picMenu3;
    private javax.swing.JLabel picMenu4;
    private javax.swing.JLabel picMenu5;
    private javax.swing.JLabel picMenu6;
    private javax.swing.JLabel picMenu7;
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
    private javax.swing.JSpinner qtyMenu2;
    private javax.swing.JSpinner qtyMenu3;
    private javax.swing.JSpinner qtyMenu4;
    private javax.swing.JSpinner qtyMenu5;
    private javax.swing.JSpinner qtyMenu6;
    private javax.swing.JSpinner qtyMenu7;
    private javax.swing.JSpinner qtyMenu8;
    private javax.swing.JSpinner qtyMenu9;
    private javax.swing.JPanel rightPanel;
    private javax.swing.JPanel topPanel;
    // End of variables declaration//GEN-END:variables

}