package sepanjangrasapos;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MethodClass {

    // Metode untuk mengatur ikon pada JButton
    public static void setIconBtn(JButton button, String resourcePath) {
        ImageIcon icon = new ImageIcon(MethodClass.class.getResource(resourcePath));
        Image img = icon.getImage().getScaledInstance(button.getWidth(), button.getHeight(), Image.SCALE_SMOOTH);
        button.setIcon(new ImageIcon(img));
    }

    // Metode untuk memasukkan gambar ke dalam label dengan ukuran yang disesuaikan
    public static void setIconLabel(JLabel label, String imagePath) {
        ImageIcon icon = new ImageIcon(MethodClass.class.getResource(imagePath));
        Image img = icon.getImage().getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
        label.setIcon(new ImageIcon(img));
    }

    // Metode untuk mengatur waktu secara real-time pada JLabel
    public static void setTime(JLabel waktuLabel, JLabel tanggalLabel) {
        new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(MethodClass.class.getName()).log(Level.SEVERE, null, ex);
                }
                Date date = new Date();
                SimpleDateFormat tf = new SimpleDateFormat("h:mm:ss aa");
                SimpleDateFormat df = new SimpleDateFormat("EEEE, dd-MM-yyyy");
                String time = tf.format(date);
                String dateText = df.format(date);

                // Update label secara real-time
                waktuLabel.setText(time);
                tanggalLabel.setText(dateText);
            }
        }).start();
    }
}
