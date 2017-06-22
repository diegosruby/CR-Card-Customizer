package App;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * @author Borja Blanco & Diego Sanchez
 */
public class Portada extends javax.swing.JFrame {

    static BarajaCartas car = new BarajaCartas();
    static AgregarCarta agre = new AgregarCarta();
    static Principal mCR2 = new Principal();
    Connection con;
    ResultSet rs;
    Statement st;

    public Portada() {
        initComponents();
        setLocationRelativeTo(null);
    }

    public void ponerUsuario(String x) throws SQLException {
        nombrePerfil.setText(x);
    }

    public boolean tieneCartas() throws SQLException {

        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/prueba", "root", "root");
        String query = "SELECT COUNT(*) FROM detalleCartas WHERE id_user = " + Principal.id_user + "";
        st = con.createStatement();
        rs = st.executeQuery(query);
        rs.next();
        if (Integer.parseInt(rs.getString(1)) > 0) {
            return true;

        } else {
            return false;
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        cSesion = new javax.swing.JButton();
        nombrePerfil = new javax.swing.JTextField();
        agregarCarta = new javax.swing.JButton();
        verBaraja = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        Fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setMinimumSize(new java.awt.Dimension(550, 650));
        jPanel2.setPreferredSize(new java.awt.Dimension(550, 650));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cSesion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/closeButton.png"))); // NOI18N
        cSesion.setBorderPainted(false);
        cSesion.setContentAreaFilled(false);
        cSesion.setHideActionText(true);
        cSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cSesionActionPerformed(evt);
            }
        });
        jPanel2.add(cSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 20, 30, 30));

        nombrePerfil.setEditable(false);
        nombrePerfil.setFont(new java.awt.Font("Snap ITC", 0, 36)); // NOI18N
        nombrePerfil.setForeground(new java.awt.Color(240, 240, 240));
        nombrePerfil.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        nombrePerfil.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        nombrePerfil.setHighlighter(null);
        nombrePerfil.setOpaque(false);
        jPanel2.add(nombrePerfil, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 340, 80));

        agregarCarta.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/añadir.png"))); // NOI18N
        agregarCarta.setBorderPainted(false);
        agregarCarta.setContentAreaFilled(false);
        agregarCarta.setHideActionText(true);
        agregarCarta.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        agregarCarta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarCartaActionPerformed(evt);
            }
        });
        jPanel2.add(agregarCarta, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, 360, 50));

        verBaraja.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/baraja.png"))); // NOI18N
        verBaraja.setBorderPainted(false);
        verBaraja.setContentAreaFilled(false);
        verBaraja.setHideActionText(true);
        verBaraja.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        verBaraja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verBarajaActionPerformed(evt);
            }
        });
        jPanel2.add(verBaraja, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 280, 360, 50));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/puntoVerde.png"))); // NOI18N
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 60, 30, 30));

        jLabel3.setFont(new java.awt.Font("Snap ITC", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(240, 240, 240));
        jLabel3.setText("Añadir cartas");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 220, -1, -1));

        jLabel4.setFont(new java.awt.Font("Snap ITC", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(240, 240, 240));
        jLabel4.setText("Ver mis cartas");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 290, -1, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/clashroyale.png"))); // NOI18N
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 380, 320, 230));

        Fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/background.jpg"))); // NOI18N
        jPanel2.add(Fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 550, 650));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 550, 650));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cSesionActionPerformed

        mCR2.setVisible(true);
        this.setVisible(false);

    }//GEN-LAST:event_cSesionActionPerformed

    private void agregarCartaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarCartaActionPerformed

        agre.setVisible(true);
        this.setVisible(false);

    }//GEN-LAST:event_agregarCartaActionPerformed

    private void verBarajaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verBarajaActionPerformed
        try {
            if (tieneCartas()) {
                car.setVisible(true);
                this.setVisible(false);
                this.setVisible(false);
            } else {
                JOptionPane.showMessageDialog(rootPane, "No tiene cartas disponibles", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Portada.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_verBarajaActionPerformed

    /**
     * @param args the command line arguments
     */
    // public static void main(String args[]) {
    /* Set the Nimbus look and feel */
    //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
    /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
     */
 /*try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Portada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Portada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Portada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Portada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
    //   java.awt.EventQueue.invokeLater(new Runnable() {
    //       public void run() {
    //           new Portada().setVisible(true);
    //       }
    //   });
    // }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Fondo;
    private javax.swing.JButton agregarCarta;
    private javax.swing.JButton cSesion;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    public javax.swing.JTextField nombrePerfil;
    private javax.swing.JButton verBaraja;
    // End of variables declaration//GEN-END:variables
}
