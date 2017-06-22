package App;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 * @author Borja Blanco & Diego Sanchez
 */
public class AgregarCarta extends javax.swing.JFrame {

    Connection con;
    ResultSet rs;
    ResultSet rs2;
    Statement st;
    JFileChooser dig = new JFileChooser();
    Cartas Agre = new Cartas();
    Portada p0 = new Portada();
    String E2, H2, VA2, VG2, O2, V2, A2, calidadCarta2, tipoCarta2,
            descripcionCarta2, vaciar;
    static String nombreCarta2;
    static String ruta;
    static int id;
    int id_usuario;

    public AgregarCarta() {
        initComponents();
        setLocationRelativeTo(null);
        cDescripcion.setLineWrap(true);

    }

    public void crearCarta() throws SQLException, InterruptedException {

        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/prueba", "root", "root");
        nombreCarta2 = nombreCarta.getText();
        calidadCarta2 = calidadCarta.getText();
        tipoCarta2 = tipoCarta.getText();
        descripcionCarta2 = cDescripcion.getText();
        E2 = E.getText();
        H2 = H.getText();
        VA2 = VA.getText();
        VG2 = VG.getText();
        O2 = O.getText();
        V2 = V.getText();
        A2 = A.getText();
        id = 0;
        id_usuario = Principal.id_user;
        sonido s2 = new sonido();

        String query = "SELECT count(*) FROM cartas where nombre like '" + nombreCarta2 + "'";
        String query2 = "SELECT count(*) FROM detalleCartas ";
        st = con.createStatement();
        rs = st.executeQuery(query);
        rs.next();

        if (rs.getInt(1) > 0) {
            JOptionPane.showMessageDialog(rootPane, "Esa carta ya existe", "Aviso", JOptionPane.ERROR_MESSAGE);
        } else if (nombreCarta2.equals("") || calidadCarta2.equals("") || tipoCarta2.equals("")
                || descripcionCarta2.equals("")
                || E2 == null || H2 == null || VA2 == null || VG2 == null || O2 == null || V2 == null || A2 == null) {
            JOptionPane.showMessageDialog(rootPane, "Hay algun campo vacío", "Aviso", JOptionPane.ERROR_MESSAGE);
        } else {
            st = con.createStatement();
            String query3 = "insert into cartas values(" + null + ",'" + nombreCarta2 + "','" + tipoCarta2 + "','" + calidadCarta2 + "','" + descripcionCarta2 + "')";
            int n = st.executeUpdate(query3);

            String query4 = "select id_carta from cartas where nombre like '" + nombreCarta2 + "'";
            rs2 = st.executeQuery(query4);
            while (rs2.next()) {
                id = rs2.getInt("id_carta");
            }

            String query5 = "insert into detalleCartas values(" + id_usuario + "," + id + ",'" + ruta + "'," + E2 + "," + H2 + "," + VA2 + "," + VG2 + ",'" + O2 + "','" + V2 + "'," + A2 + ")";
            int q = st.executeUpdate(query5);

            s2.sound2();
            Thread.sleep(8000);
            JOptionPane.showMessageDialog(rootPane, "Carta creada", "Aviso", JOptionPane.INFORMATION_MESSAGE);

            vaciar = " ";
            nombreCarta.setText("");
            calidadCarta.setText("");
            tipoCarta.setText("");
            cDescripcion.setText("");
            E.setText("");
            H.setText("");
            VA.setText("");
            VG.setText("");
            O.setText("");
            V.setText("");
            A.setText("");
            foto.setIcon(new ImageIcon(vaciar));
            this.setVisible(false);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser1 = new javax.swing.JFileChooser();
        jPanel1 = new javax.swing.JPanel();
        salir = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        archivos = new javax.swing.JButton();
        foto = new javax.swing.JLabel();
        Aceptar = new javax.swing.JLabel();
        Aceptar2 = new javax.swing.JButton();
        Cancelar = new javax.swing.JLabel();
        Cancelar2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        nombreCarta = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tipoCarta = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        calidadCarta = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        E = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        H = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        VA = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        VG = new javax.swing.JTextField();
        O = new javax.swing.JTextField();
        V = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        A = new javax.swing.JTextField();
        descripcionCarta = new javax.swing.JScrollPane();
        cDescripcion = new javax.swing.JTextArea();
        jLabel14 = new javax.swing.JLabel();
        Fondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(550, 650));
        setUndecorated(true);

        jPanel1.setMinimumSize(new java.awt.Dimension(550, 650));
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
        jLabel2.setText("Editor de cartas");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, -1, 40));

        archivos.setFont(new java.awt.Font("Snap ITC", 0, 24)); // NOI18N
        archivos.setForeground(new java.awt.Color(255, 255, 255));
        archivos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/button2.png"))); // NOI18N
        archivos.setText("Abrir");
        archivos.setBorderPainted(false);
        archivos.setContentAreaFilled(false);
        archivos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        archivos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                archivosActionPerformed(evt);
            }
        });
        jPanel1.add(archivos, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 150, 70));
        jPanel1.add(foto, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 130, 120));

        Aceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/okay.png"))); // NOI18N
        jPanel1.add(Aceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 590, 60, 50));

        Aceptar2.setOpaque(false);
        Aceptar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Aceptar2ActionPerformed(evt);
            }
        });
        jPanel1.add(Aceptar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 600, 40, 30));

        Cancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/cancel.png"))); // NOI18N
        jPanel1.add(Cancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 590, 60, 50));

        Cancelar2.setOpaque(false);
        Cancelar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Cancelar2ActionPerformed(evt);
            }
        });
        jPanel1.add(Cancelar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 600, 40, 30));

        jLabel3.setFont(new java.awt.Font("Snap ITC", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(240, 240, 240));
        jLabel3.setText("Nombre:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 120, -1, -1));

        nombreCarta.setFont(new java.awt.Font("Snap ITC", 0, 14)); // NOI18N
        nombreCarta.setForeground(new java.awt.Color(240, 240, 240));
        nombreCarta.setOpaque(false);
        jPanel1.add(nombreCarta, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 110, 170, 30));

        jLabel4.setFont(new java.awt.Font("Snap ITC", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(240, 240, 240));
        jLabel4.setText("Calidad:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 220, -1, -1));

        tipoCarta.setFont(new java.awt.Font("Snap ITC", 0, 14)); // NOI18N
        tipoCarta.setForeground(new java.awt.Color(240, 240, 240));
        tipoCarta.setToolTipText("Tropa, Estructura o Hechizo");
        tipoCarta.setOpaque(false);
        jPanel1.add(tipoCarta, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 160, 170, 30));

        jLabel5.setFont(new java.awt.Font("Snap ITC", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(240, 240, 240));
        jLabel5.setText("Tipo:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 170, 50, -1));

        calidadCarta.setFont(new java.awt.Font("Snap ITC", 0, 14)); // NOI18N
        calidadCarta.setForeground(new java.awt.Color(240, 240, 240));
        calidadCarta.setToolTipText("Comun, Especial, Epica o Legendaria");
        calidadCarta.setOpaque(false);
        jPanel1.add(calidadCarta, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 210, 170, 30));

        jLabel6.setFont(new java.awt.Font("Snap ITC", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(240, 240, 240));
        jLabel6.setText("Descripción:");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 270, -1, -1));

        jLabel7.setFont(new java.awt.Font("Snap ITC", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(240, 240, 240));
        jLabel7.setText("Elixir:");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 380, -1, -1));

        E.setFont(new java.awt.Font("Snap ITC", 0, 14)); // NOI18N
        E.setForeground(new java.awt.Color(255, 51, 255));
        E.setToolTipText("Elixir del 1-10");
        E.setOpaque(false);
        jPanel1.add(E, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 380, 90, -1));

        jLabel8.setFont(new java.awt.Font("Snap ITC", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(240, 240, 240));
        jLabel8.setText("Hitpoints:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 420, -1, -1));

        H.setFont(new java.awt.Font("Snap ITC", 0, 14)); // NOI18N
        H.setForeground(new java.awt.Color(255, 51, 255));
        H.setOpaque(false);
        jPanel1.add(H, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 420, 90, -1));

        jLabel9.setFont(new java.awt.Font("Snap ITC", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(240, 240, 240));
        jLabel9.setText("Velocidad Ataque:");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 460, -1, -1));

        VA.setFont(new java.awt.Font("Snap ITC", 0, 14)); // NOI18N
        VA.setForeground(new java.awt.Color(255, 51, 255));
        VA.setOpaque(false);
        jPanel1.add(VA, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 460, 90, -1));

        jLabel10.setFont(new java.awt.Font("Snap ITC", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(240, 240, 240));
        jLabel10.setText("Velocidad de generación:");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 380, -1, -1));

        jLabel11.setFont(new java.awt.Font("Snap ITC", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(240, 240, 240));
        jLabel11.setText("Objetivo");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 420, -1, -1));

        jLabel12.setFont(new java.awt.Font("Snap ITC", 0, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(240, 240, 240));
        jLabel12.setText("Velocidad:");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 460, -1, -1));

        VG.setFont(new java.awt.Font("Snap ITC", 0, 14)); // NOI18N
        VG.setForeground(new java.awt.Color(255, 51, 255));
        VG.setOpaque(false);
        jPanel1.add(VG, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 380, 90, -1));

        O.setFont(new java.awt.Font("Snap ITC", 0, 14)); // NOI18N
        O.setForeground(new java.awt.Color(255, 51, 255));
        O.setToolTipText("Tierra, Aire o Tierra y Aire");
        O.setOpaque(false);
        jPanel1.add(O, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 420, 90, -1));

        V.setFont(new java.awt.Font("Snap ITC", 0, 14)); // NOI18N
        V.setForeground(new java.awt.Color(255, 51, 255));
        V.setToolTipText("Baja, Media, Alta o Muy Alta");
        V.setOpaque(false);
        jPanel1.add(V, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 460, 90, -1));

        jLabel13.setFont(new java.awt.Font("Snap ITC", 0, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(240, 240, 240));
        jLabel13.setText("Alcance:");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 510, -1, 20));

        A.setFont(new java.awt.Font("Snap ITC", 0, 14)); // NOI18N
        A.setForeground(new java.awt.Color(255, 51, 255));
        A.setOpaque(false);
        jPanel1.add(A, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 510, 90, -1));

        descripcionCarta.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        descripcionCarta.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        cDescripcion.setBackground(new java.awt.Color(0, 102, 153));
        cDescripcion.setColumns(20);
        cDescripcion.setFont(new java.awt.Font("Snap ITC", 0, 14)); // NOI18N
        cDescripcion.setForeground(new java.awt.Color(240, 240, 240));
        cDescripcion.setRows(5);
        cDescripcion.setHighlighter(null);
        descripcionCarta.setViewportView(cDescripcion);

        jPanel1.add(descripcionCarta, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 260, 170, -1));

        jLabel14.setFont(new java.awt.Font("Snap ITC", 0, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(240, 240, 240));
        jLabel14.setText("Foto:");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 250, -1, -1));

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
        nombreCarta.setText("");
        tipoCarta.setText("");
        calidadCarta.setText("");
        cDescripcion.setText("");
        E.setText("");
        H.setText("");
        VA.setText("");
        VG.setText("");
        O.setText("");
        V.setText("");
        A.setText("");
        p0.nombrePerfil.setText(Principal.cUsuario);
        p0.setVisible(true);

    }//GEN-LAST:event_salirActionPerformed

    private void archivosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_archivosActionPerformed

        JOptionPane.showMessageDialog(rootPane, "Recuerda que la imagen debe de ser de 130x120px", "Aviso", JOptionPane.INFORMATION_MESSAGE);
        int option = dig.showOpenDialog(this);
        if (option == JFileChooser.APPROVE_OPTION) {
            ruta = dig.getSelectedFile().getPath();
            foto.setIcon(new ImageIcon(ruta));
        }
    }//GEN-LAST:event_archivosActionPerformed

    private void Cancelar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Cancelar2ActionPerformed

        this.setVisible(false);
        nombreCarta.setText("");
        tipoCarta.setText("");
        calidadCarta.setText("");
        cDescripcion.setText("");
        E.setText("");
        H.setText("");
        VA.setText("");
        VG.setText("");
        O.setText("");
        V.setText("");
        A.setText("");
        p0.setVisible(true);

    }//GEN-LAST:event_Cancelar2ActionPerformed

    private void Aceptar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Aceptar2ActionPerformed

        try {
            crearCarta();
            p0.nombrePerfil.setText(Principal.cUsuario);
            p0.setVisible(true);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(rootPane, "Hay algun error en la BBDD", "Aviso", JOptionPane.INFORMATION_MESSAGE);
        } catch (InterruptedException ex) {
            JOptionPane.showMessageDialog(rootPane, "Hay algun error en la BBDD", "Aviso", JOptionPane.INFORMATION_MESSAGE);
        }


    }//GEN-LAST:event_Aceptar2ActionPerformed

    /**
     * @param args the command line arguments
     */
    //public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(AgregarCarta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AgregarCarta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AgregarCarta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AgregarCarta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
    //  java.awt.EventQueue.invokeLater(new Runnable() {
    //    public void run() {
    //   new AgregarCarta().setVisible(true);
    // }
    // });
    //}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField A;
    private javax.swing.JLabel Aceptar;
    private javax.swing.JButton Aceptar2;
    private javax.swing.JLabel Cancelar;
    private javax.swing.JButton Cancelar2;
    private javax.swing.JTextField E;
    private javax.swing.JLabel Fondo;
    private javax.swing.JTextField H;
    private javax.swing.JTextField O;
    private javax.swing.JTextField V;
    private javax.swing.JTextField VA;
    private javax.swing.JTextField VG;
    private javax.swing.JButton archivos;
    private javax.swing.JTextArea cDescripcion;
    private javax.swing.JTextField calidadCarta;
    private javax.swing.JScrollPane descripcionCarta;
    private javax.swing.JLabel foto;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField nombreCarta;
    private javax.swing.JButton salir;
    private javax.swing.JTextField tipoCarta;
    // End of variables declaration//GEN-END:variables
}
