package App;

import java.sql.*;
import javax.swing.JOptionPane;

/**
 * @author Borja Blanco & Diego Sanchez
 */
public class creaUsuario extends javax.swing.JFrame {

    static Principal mCR = new Principal();
    Connection con;
    ResultSet rs;
    Statement st;

    public creaUsuario() {
        initComponents();
        setLocationRelativeTo(null);
    }

    public void cargaUsuario() throws SQLException {

        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/prueba", "root", "root");
        String newUsuario = nUsuario.getText();
        String newContrasenia = Password.getText();

        String query = "SELECT count(*)as numero FROM usuarios WHERE nombre like "
                + "'" + newUsuario + "'";
        st = con.createStatement();
        rs = st.executeQuery(query);
        rs.next();

        if (rs.getInt(1) > 0) {
            JOptionPane.showMessageDialog(rootPane, "Ya existe ese usuario", "Aviso", JOptionPane.ERROR_MESSAGE);
            nUsuario.setText("");
            Password.setText("");
        } else {
            st = con.createStatement();
            String query2 = "insert into usuarios values(" + null + ",'" + newUsuario + "','" + newContrasenia + "')";
            JOptionPane.showMessageDialog(rootPane, "Usuario creado", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            int n = st.executeUpdate(query2);
            nUsuario.setText("");
            Password.setText("");
            mCR.setVisible(true);
            this.setVisible(false);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        labelUsuario = new javax.swing.JLabel();
        labelContraseña = new javax.swing.JLabel();
        nUsuario = new javax.swing.JTextField();
        Password = new javax.swing.JPasswordField();
        crear = new javax.swing.JButton();
        volver = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        Fondo = new javax.swing.JLabel();

        setUndecorated(true);

        jPanel1.setPreferredSize(new java.awt.Dimension(450, 450));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        labelUsuario.setFont(new java.awt.Font("Snap ITC", 0, 18)); // NOI18N
        labelUsuario.setForeground(new java.awt.Color(240, 240, 240));
        labelUsuario.setText("Nuevo Usuario:");
        jPanel1.add(labelUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 60, -1, -1));

        labelContraseña.setFont(new java.awt.Font("Snap ITC", 0, 18)); // NOI18N
        labelContraseña.setForeground(new java.awt.Color(240, 240, 240));
        labelContraseña.setText("Nueva Contraseña:");
        jPanel1.add(labelContraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 120, -1, -1));
        jPanel1.add(nUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 60, 130, -1));
        jPanel1.add(Password, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 120, 110, -1));

        crear.setFont(new java.awt.Font("Snap ITC", 0, 24)); // NOI18N
        crear.setForeground(new java.awt.Color(255, 255, 255));
        crear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/button2.png"))); // NOI18N
        crear.setText("Crear");
        crear.setBorderPainted(false);
        crear.setContentAreaFilled(false);
        crear.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        crear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crearActionPerformed(evt);
            }
        });
        jPanel1.add(crear, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 190, 160, 90));

        volver.setFont(new java.awt.Font("Snap ITC", 0, 24)); // NOI18N
        volver.setForeground(new java.awt.Color(255, 255, 255));
        volver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/button2.png"))); // NOI18N
        volver.setText("Volver");
        volver.setBorderPainted(false);
        volver.setContentAreaFilled(false);
        volver.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        volver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                volverActionPerformed(evt);
            }
        });
        jPanel1.add(volver, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 280, 140, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/character.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 230, 300));

        Fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/background.jpg"))); // NOI18N
        Fondo.setPreferredSize(new java.awt.Dimension(450, 450));
        jPanel1.add(Fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 450, 450));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void crearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crearActionPerformed

        try {
            cargaUsuario();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }


    }//GEN-LAST:event_crearActionPerformed

    private void volverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_volverActionPerformed

        mCR.setVisible(true);
        this.setVisible(false);

    }//GEN-LAST:event_volverActionPerformed

    // public static void main(String args[]) {
    /* Set the Nimbus look and feel */
    //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
    /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
     */
 /*  try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(creaUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(creaUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(creaUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(creaUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
    //java.awt.EventQueue.invokeLater(new Runnable() {
    //    public void run() {
    //        new creaUsuario().setVisible(true);
    //    }
    // });
    //}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Fondo;
    private javax.swing.JPasswordField Password;
    private javax.swing.JButton crear;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel labelContraseña;
    private javax.swing.JLabel labelUsuario;
    private javax.swing.JTextField nUsuario;
    private javax.swing.JButton volver;
    // End of variables declaration//GEN-END:variables
}
