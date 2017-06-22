package App;

import java.awt.*;
import java.io.*;
import javax.swing.*;
import java.lang.*;
import java.net.*;
import java.sql.*;
import java.util.logging.*;

/**
 * @author Borja Blanco & Diego Sanchez
 */
public class Principal extends javax.swing.JFrame {

    creaUsuario cU = new creaUsuario();
    Portada Porta = new Portada();
    Connection con;
    ResultSet rs;
    Statement st;
    static String cUsuario;
    String cContrasenia;
    static int id_user;

    public Principal() {
        initComponents();
        setLocationRelativeTo(null);

    }

    public boolean existeUsuario() throws SQLException {

        cUsuario = Usuario.getText();
        Porta.nombrePerfil.setText(cUsuario);
        cContrasenia = password.getText();

        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/prueba", "root", "root");
        String query = "SELECT COUNT(*) FROM usuarios WHERE nombre LIKE '" + cUsuario + "' AND AES_ENCRYPT('" + cContrasenia + "', '1234') "
                + "= (SELECT contrasenia_desen FROM desencriptacion WHERE id_user = (SELECT id_user FROM usuarios WHERE nombre LIKE '" + cUsuario + "'))";
        st = con.createStatement();
        rs = st.executeQuery(query);
        rs.next();
        if (Integer.parseInt(rs.getString(1)) > 0) {
            return true;

        } else {
            return false;
        }

    }

    public void idUsuario() throws SQLException {
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/prueba", "root", "root");
        st = con.createStatement();
        String query2 = "SELECT id_user FROM usuarios WHERE nombre LIKE '" + cUsuario + "'";
        rs = st.executeQuery(query2);
        while (rs.next()) {
            id_user = rs.getInt(1);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        layoutPrincipal = new javax.swing.JPanel();
        titulo = new javax.swing.JLabel();
        usuario = new javax.swing.JLabel();
        contrasenia = new javax.swing.JLabel();
        Usuario = new javax.swing.JTextField();
        password = new javax.swing.JPasswordField();
        entrar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        nuevo = new javax.swing.JButton();
        iconoJuego = new javax.swing.JLabel();
        facebook = new javax.swing.JLabel();
        twitter = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Fondo = new javax.swing.JLabel();
        bTwitter = new javax.swing.JButton();
        bFacebook = new javax.swing.JButton();
        bIcono = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        layoutPrincipal.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        titulo.setFont(new java.awt.Font("Snap ITC", 0, 36)); // NOI18N
        titulo.setForeground(new java.awt.Color(240, 240, 240));
        titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo.setText("CR CARD CUSTOMIZER");
        titulo.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        layoutPrincipal.add(titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 530, 60));

        usuario.setFont(new java.awt.Font("Snap ITC", 0, 18)); // NOI18N
        usuario.setForeground(new java.awt.Color(240, 240, 240));
        usuario.setText("Usuario:");
        layoutPrincipal.add(usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 260, -1, -1));

        contrasenia.setFont(new java.awt.Font("Snap ITC", 0, 18)); // NOI18N
        contrasenia.setForeground(new java.awt.Color(240, 240, 240));
        contrasenia.setText("Contraseña:");
        layoutPrincipal.add(contrasenia, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 320, -1, -1));
        layoutPrincipal.add(Usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 260, 150, -1));
        layoutPrincipal.add(password, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 320, 150, -1));

        entrar.setFont(new java.awt.Font("Snap ITC", 0, 24)); // NOI18N
        entrar.setForeground(new java.awt.Color(255, 255, 255));
        entrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/button2.png"))); // NOI18N
        entrar.setText("Entrar");
        entrar.setBorderPainted(false);
        entrar.setContentAreaFilled(false);
        entrar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        entrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                entrarActionPerformed(evt);
            }
        });
        layoutPrincipal.add(entrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 400, 150, 70));

        jLabel1.setFont(new java.awt.Font("Snap ITC", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Crear");
        layoutPrincipal.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 400, -1, -1));

        jLabel3.setFont(new java.awt.Font("Snap ITC", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Usuario");
        layoutPrincipal.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 430, -1, -1));

        nuevo.setFont(new java.awt.Font("Snap ITC", 0, 24)); // NOI18N
        nuevo.setForeground(new java.awt.Color(255, 255, 255));
        nuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/button2.png"))); // NOI18N
        nuevo.setBorderPainted(false);
        nuevo.setContentAreaFilled(false);
        nuevo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevoActionPerformed(evt);
            }
        });
        layoutPrincipal.add(nuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 400, 150, 70));

        iconoJuego.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/iconoJuego.jpg"))); // NOI18N
        iconoJuego.setPreferredSize(new java.awt.Dimension(127, 154));
        layoutPrincipal.add(iconoJuego, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 560, 250, 60));

        facebook.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/facebook.png"))); // NOI18N
        layoutPrincipal.add(facebook, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 500, 120, 110));

        twitter.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/twitter.png"))); // NOI18N
        layoutPrincipal.add(twitter, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 490, 160, 120));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/emoticonos.png"))); // NOI18N
        layoutPrincipal.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 520, 130));

        Fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/background.jpg"))); // NOI18N
        layoutPrincipal.add(Fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 550, 650));

        bTwitter.setText("jButton1");
        bTwitter.setOpaque(false);
        bTwitter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bTwitterActionPerformed(evt);
            }
        });
        layoutPrincipal.add(bTwitter, new org.netbeans.lib.awtextra.AbsoluteConstraints(53, 493, 150, 120));

        bFacebook.setText("jButton1");
        bFacebook.setOpaque(false);
        bFacebook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bFacebookActionPerformed(evt);
            }
        });
        layoutPrincipal.add(bFacebook, new org.netbeans.lib.awtextra.AbsoluteConstraints(363, 493, 140, 120));

        bIcono.setText("jButton1");
        bIcono.setOpaque(false);
        bIcono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bIconoActionPerformed(evt);
            }
        });
        layoutPrincipal.add(bIcono, new org.netbeans.lib.awtextra.AbsoluteConstraints(223, 563, 130, 60));

        getContentPane().add(layoutPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bTwitterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bTwitterActionPerformed
        try {
            Desktop.getDesktop().browse(new URI("https://twitter.com/diegosruby"));
        } catch (URISyntaxException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_bTwitterActionPerformed

    private void bFacebookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bFacebookActionPerformed
        // TODO add your handling code here:
        try {
            Desktop.getDesktop().browse(new URI("https://www.facebook.com/borja.blanco.35"));
        } catch (IOException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (URISyntaxException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_bFacebookActionPerformed

    private void bIconoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bIconoActionPerformed
        try {
            Desktop.getDesktop().browse(new URI("http://supercell.com/en/games/clashroyale/"));
        } catch (IOException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (URISyntaxException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_bIconoActionPerformed

    private void entrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_entrarActionPerformed

        try {
            if (!existeUsuario()) {
                JOptionPane.showMessageDialog(rootPane, "Usuario o contraseña incorrecto", "Aviso", JOptionPane.ERROR_MESSAGE);
                Usuario.setText("");
                password.setText("");
            } else {
                JOptionPane.showMessageDialog(rootPane, "Bienvenido", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                idUsuario();
                Porta.setVisible(true);
                this.setVisible(false);
                Usuario.setText("");
                password.setText("");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_entrarActionPerformed

    private void nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevoActionPerformed

        cU.setVisible(true);
        this.setVisible(false);

    }//GEN-LAST:event_nuevoActionPerformed
    /*
    public static void main(String args[]) {

        Principal a1 = new Principal();

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Fondo;
    private javax.swing.JTextField Usuario;
    private javax.swing.JButton bFacebook;
    private javax.swing.JButton bIcono;
    private javax.swing.JButton bTwitter;
    private javax.swing.JLabel contrasenia;
    private javax.swing.JButton entrar;
    private javax.swing.JLabel facebook;
    private javax.swing.JLabel iconoJuego;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel layoutPrincipal;
    private javax.swing.JButton nuevo;
    private javax.swing.JPasswordField password;
    private javax.swing.JLabel titulo;
    private javax.swing.JLabel twitter;
    private javax.swing.JLabel usuario;
    // End of variables declaration//GEN-END:variables
}
