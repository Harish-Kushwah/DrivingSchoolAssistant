package crazypanel;

import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.extras.FlatAnimatedLafChange;
import com.formdev.flatlaf.fonts.roboto.FlatRobotoFont;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JProgressBar;
import javax.swing.UIManager;

/**
 *
 * @author RAVEN
 */
public class Test extends javax.swing.JFrame {

    /**
     * Creates new form Test
     */
    public Test() {
        initComponents();
        new JProgressBar().setIndeterminate(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        glassIcon1 = new raven.glassmorphism.GlassIcon();
        glassIcon2 = new raven.glassmorphism.GlassIcon();
        glassIcon3 = new raven.glassmorphism.GlassIcon();
        glassIcon4 = new raven.glassmorphism.GlassIcon();
        jButton2 = new javax.swing.JButton();
        crazyPanel1 = new raven.crazypanel.CrazyPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jTextField10 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        glassIcon1.setGlassIconConfig(new raven.glassmorphism.GlassIconConfig(
            "/glassicon/icon/card.svg", 5.0f, 0, 5,
            new java.util.HashMap<Integer, String>(){
                {
                    put(0,"@background");
                    put(1,"#6691a1");
                    put(2,"#6691a1");
                }
            },
            new raven.glassmorphism.GlassIconConfig.GlassShape(
                java.awt.Color.decode("#db214f"),
                new java.awt.geom.RoundRectangle2D.Double(2.0, 2.0, 10.0, 10.0, 5.0, 5.0),
                45.0f)
        ));

        glassIcon2.setGlassIconConfig(new raven.glassmorphism.GlassIconConfig(
            "/glassicon/icon/doc.svg", 5.0f, 1, 5,
            new java.util.HashMap<Integer, String>(){
                {
                    put(0,"#6691a1");
                    put(1,"@background");
                    put(2,"#6691a1");
                    put(3,"#6691a1");
                    put(4,"#6691a1");
                }
            },
            new raven.glassmorphism.GlassIconConfig.GlassShape(
                java.awt.Color.decode("#0ca064"),
                new java.awt.geom.RoundRectangle2D.Double(2.0, 2.0, 10.0, 10.0, 5.0, 5.0),
                45.0f)
        ));

        glassIcon3.setGlassIconConfig(new raven.glassmorphism.GlassIconConfig(
            "/glassicon/icon/currency.svg", 5.0f, 0, 5,
            new java.util.HashMap<Integer, String>(){
                {
                    put(0,"@background");
                    put(1,"#6691a1");
                    put(2,"#6691a1");
                }
            },
            new raven.glassmorphism.GlassIconConfig.GlassShape(
                java.awt.Color.decode("#9db035"),
                new java.awt.geom.RoundRectangle2D.Double(2.0, 2.0, 10.0, 10.0, 5.0, 5.0),
                45.0f)
        ));

        glassIcon4.setGlassIconConfig(new raven.glassmorphism.GlassIconConfig(
            "/glassicon/icon/dollar.svg", 5.0f, 0, 5,
            new java.util.HashMap<Integer, String>(){
                {
                    put(0,"@background");
                    put(1,"#6691a1");
                    put(2,"#6691a1");
                    put(3,"#6691a1");
                    put(4,"#6691a1");
                }
            },
            new raven.glassmorphism.GlassIconConfig.GlassShape(
                java.awt.Color.decode("#2ca6f3"),
                new java.awt.geom.RoundRectangle2D.Double(6.0, 7.0, 10.0, 10.0, 10.0, 10.0),
                45.0f)
        ));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton2.setText("Change Mode");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        crazyPanel1.setFlatLafStyleComponent(new raven.crazypanel.FlatLafStyleComponent(
            "[light]border:0,0,0,0,shade(@background,5%),,20;[dark]border:0,0,0,0,tint(@background,5%),,20;[light]background:shade(@background,2%);[dark]background:tint(@background,2%)",
            new String[]{
                "font:bold +10",
                "font:bold +1",
                "",
                "",
                "showClearButton:true;JTextField.placeholderText=first",
                "showClearButton:true;JTextField.placeholderText=last",
                "",
                "showClearButton:true;JTextField.placeholderText=e.g. tesla motors",
                "",
                "showClearButton:true;JTextField.placeholderText=e.g. example@gmail.com",
                "",
                "font:bold +1",
                "",
                "",
                "showClearButton:true;JTextField.placeholderText=street. apt/suite",
                "",
                "showClearButton:true;JTextField.placeholderText=office.room/flat",
                "",
                "showClearButton:true",
                "",
                "",
                "",
                "showClearButton:true",
                "",
                "showClearButton:true",
                "",
                "showClearButton:true;JTextField.placeholderText=for us non-residents only"
            }
        ));
        crazyPanel1.setMigLayoutConstraints(new raven.crazypanel.MigLayoutConstraints(
            "wrap 2,fillx,insets 25",
            "[grow 0,trail]15[fill]",
            "",
            new String[]{
                "wrap,al lead",
                "wrap,al lead",
                "wrap,al lead",
                "",
                "split 2",
                "",
                "",
                "",
                "",
                "",
                "span 2,grow 1",
                "wrap,al lead",
                "wrap,al lead",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "span 2,al trail"
            }
        ));

        jLabel1.setText("User Details");
        crazyPanel1.add(jLabel1);

        jLabel2.setText("Contact info");
        crazyPanel1.add(jLabel2);

        jLabel3.setText("Used for tracking you");
        crazyPanel1.add(jLabel3);

        jLabel4.setText("Full Name");
        crazyPanel1.add(jLabel4);
        crazyPanel1.add(jTextField1);
        crazyPanel1.add(jTextField2);

        jLabel5.setText("Application Number");
        crazyPanel1.add(jLabel5);
        crazyPanel1.add(jTextField3);

        jLabel6.setText("Email Address");
        crazyPanel1.add(jLabel6);
        crazyPanel1.add(jTextField4);
        crazyPanel1.add(jSeparator1);

        jLabel7.setText("Delivery address");
        crazyPanel1.add(jLabel7);

        jLabel8.setText("used for shipping ordres");
        crazyPanel1.add(jLabel8);

        jLabel9.setText("Address");
        crazyPanel1.add(jLabel9);
        crazyPanel1.add(jTextField5);

        jLabel10.setText("Optional");
        crazyPanel1.add(jLabel10);
        crazyPanel1.add(jTextField6);

        jLabel11.setText("City");
        crazyPanel1.add(jLabel11);
        crazyPanel1.add(jTextField7);

        jLabel12.setText("Country");
        crazyPanel1.add(jLabel12);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "United States", "Canada", "Germany", "Japan", "Brazil" }));
        crazyPanel1.add(jComboBox1);

        jLabel13.setText("State / Province");
        crazyPanel1.add(jLabel13);
        crazyPanel1.add(jTextField8);

        jLabel14.setText("Sip / Postal");
        crazyPanel1.add(jLabel14);
        crazyPanel1.add(jTextField9);

        jLabel15.setText("VAT number");
        crazyPanel1.add(jLabel15);
        crazyPanel1.add(jTextField10);

        jButton1.setText("Save");
        crazyPanel1.add(jButton1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(crazyPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 549, Short.MAX_VALUE)
                .addGap(30, 30, 30))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton2)
                .addGap(30, 30, 30)
                .addComponent(crazyPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (!FlatLaf.isLafDark()) {
            EventQueue.invokeLater(() -> {
                FlatAnimatedLafChange.showSnapshot();
                FlatMacDarkLaf.setup();
                FlatLaf.updateUI();
                FlatAnimatedLafChange.hideSnapshotWithAnimation();
            });
        } else {
            EventQueue.invokeLater(() -> {
                FlatAnimatedLafChange.showSnapshot();
                FlatMacLightLaf.setup();
                FlatLaf.updateUI();
                FlatAnimatedLafChange.hideSnapshotWithAnimation();
            });
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    public static void main(String args[]) {
        FlatRobotoFont.install();
        FlatLaf.registerCustomDefaultsSource("themes");
        UIManager.put("defaultFont", new Font(FlatRobotoFont.FAMILY, Font.PLAIN, 13));
        FlatMacLightLaf.setup();
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Test().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private raven.crazypanel.CrazyPanel crazyPanel1;
    private raven.glassmorphism.GlassIcon glassIcon1;
    private raven.glassmorphism.GlassIcon glassIcon2;
    private raven.glassmorphism.GlassIcon glassIcon3;
    private raven.glassmorphism.GlassIcon glassIcon4;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    // End of variables declaration//GEN-END:variables
}
