package App;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Borja Blanco & Diego Sanchez
 */
public class BarajaCartas extends javax.swing.JFrame {

    Connection con;
    ResultSet rs;
    Statement st;
    static Cartas car = new Cartas();
    Portada p5 = new Portada();
    AgregarCarta agre0 = new AgregarCarta();
    Principal prin0 = new Principal();

    public BarajaCartas() {
        initComponents();
        setLocationRelativeTo(null);
    }

    public void consultarCartas() throws SQLException {
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/prueba", "root", "root");
        String query = "SELECT nombre FROM cartas where " + agre0.id + " in(select " + agre0.id + " from detallecartas where id_user like " + prin0.id_user + ")";
        st = con.createStatement();
        rs = st.executeQuery(query);
        try {
            while (rs.next()) {
                jComboBox1.addItem(rs.getString(1));
            }
            st.close();
        } catch (SQLException ex) {
        }
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        salir = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        icono = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        Fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(550, 650));
        setUndecorated(true);

        jPanel1.setPreferredSize(new java.awt.Dimension(550, 650));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        salir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/closeButton.png"))); // NOI18N
        salir.setBorderPainted(false);
        salir.setContentAreaFilled(false);
        salir.setHideActionText(true);
        salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salirActionPerformed(evt);
            }
        });
        jPanel1.add(salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 20, 30, 30));

        jLabel2.setFont(new java.awt.Font("Snap ITC", 0, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Mi baraja");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 30, 280, 80));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/clash-royale.png"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 450, 520, 200));

        icono.setFont(new java.awt.Font("Snap ITC", 0, 24)); // NOI18N
        icono.setForeground(new java.awt.Color(255, 255, 255));
        icono.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/button2.png"))); // NOI18N
        icono.setText("Consultar");
        icono.setBorderPainted(false);
        icono.setContentAreaFilled(false);
        icono.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        icono.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        icono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iconoActionPerformed(evt);
            }
        });
        jPanel1.add(icono, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 320, 170, 90));

        jComboBox1.setBackground(new java.awt.Color(255, 153, 0));
        jComboBox1.setFont(new java.awt.Font("Snap ITC", 0, 18)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione una carta" }));
        jComboBox1.setBorder(new javax.swing.border.MatteBorder(null));
        jComboBox1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jComboBox1FocusGained(evt);
            }
        });
        jPanel1.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 150, -1, -1));

        Fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/background.jpg"))); // NOI18N
        jPanel1.add(Fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 550, 650));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salirActionPerformed

        this.setVisible(false);
        p5.nombrePerfil.setText(Principal.cUsuario);
        p5.setVisible(true);

    }//GEN-LAST:event_salirActionPerformed

    private void iconoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iconoActionPerformed
        try {
            car.setVisible(true);
            car.rellenarCampos();
            this.setVisible(false);
        } catch (SQLException ex) {
            Logger.getLogger(BarajaCartas.class.getName()).log(Level.SEVERE, null, ex);
        }
    

    }//GEN-LAST:event_iconoActionPerformed

    private void jComboBox1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jComboBox1FocusGained
        try {
            jComboBox1.removeAllItems();
            consultarCartas();
        } catch (SQLException ex) {
            Logger.getLogger(BarajaCartas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jComboBox1FocusGained

    //public static void main(String args[]) {
    /* Set the Nimbus look and feel */
    //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
    /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
     */
 /* try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(BarajaCartas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BarajaCartas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BarajaCartas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BarajaCartas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
    // java.awt.EventQueue.invokeLater(new Runnable() {
    //    public void run() {
    //        new BarajaCartas().setVisible(true);
    //    }
    //});
    //}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Fondo;
    private javax.swing.JButton icono;
    public static javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton salir;
    // End of variables declaration//GEN-END:variables
}
