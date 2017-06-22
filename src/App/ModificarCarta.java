package App;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 * @author Borja Blanco & Diego Sanchez
 */
public class ModificarCarta extends javax.swing.JFrame {

    Portada p3 = new Portada();
    static Cartas c = new Cartas();
    static BarajaCartas bc2 = new BarajaCartas();
    Connection con;
    ResultSet rs;
    Statement st;

    public ModificarCarta() {
        initComponents();
        setLocationRelativeTo(null);
    }

    public void actualizaCarta() throws SQLException {
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/prueba", "root", "root");
        String query = "UPDATE detalleCartas SET elixir = "+elix.getText()+", hitpoints = "+Hit.getText()+", velocidadAtaque = "+VAta.getText()+", velocidadGeneracion = "+VGen.getText()+", objetivo='"+Obj.getText()+"', velocidad='"+Vel.getText()+"', alcance="+Al.getText()+" where id_user like " + Principal.id_user + " AND id_carta in(select id_carta from cartas where nombre like '" + BarajaCartas.jComboBox1.getSelectedItem().toString() + "')";
        String query2 = "UPDATE cartas SET nombre = '"+NCar.getText()+"', tipo = '"+Tip.getText()+"', calidad ='"+Cali.getText()+"', descripcion = '"+descrip.getText()+"' where nombre like '" + BarajaCartas.jComboBox1.getSelectedItem().toString() + "'";
        st = con.createStatement();
        int up = st.executeUpdate(query);
        int up2 = st.executeUpdate(query2);
    }
    
    public void nuevaCarta(){
        c.NCar.setText(NCar.getText());
        c.Cali.setText(Cali.getText());
        c.Tip.setText(Tip.getText());
        c.descrip.setText(descrip.getText());
        c.elix.setText(elix.getText());
        c.Hit.setText(Hit.getText());
        c.Vel.setText(Vel.getText());
        c.Obj.setText(Obj.getText());
        c.VGen.setText(VGen.getText());
        c.VAta.setText(VAta.getText());
        c.Al.setText(Al.getText());
        c.muestraFoto.setIcon(new ImageIcon(AgregarCarta.ruta));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        elix = new javax.swing.JTextField();
        elixir = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        NCar = new javax.swing.JTextField();
        Cali = new javax.swing.JTextField();
        Tip = new javax.swing.JTextField();
        Hit = new javax.swing.JTextField();
        Vel = new javax.swing.JTextField();
        Obj = new javax.swing.JTextField();
        VGen = new javax.swing.JTextField();
        Al = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        VAta = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        descrip = new javax.swing.JTextArea();
        muestraFoto = new javax.swing.JLabel();
        modificar = new javax.swing.JButton();
        Fondo1 = new javax.swing.JLabel();

        setUndecorated(true);

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        elix.setFont(new java.awt.Font("Snap ITC", 0, 30)); // NOI18N
        elix.setForeground(new java.awt.Color(255, 255, 255));
        elix.setBorder(null);
        elix.setOpaque(false);
        jPanel2.add(elix, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, 40, 40));

        elixir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/elixir.png"))); // NOI18N
        jPanel2.add(elixir, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 90, 80));

        jLabel2.setFont(new java.awt.Font("Snap ITC", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Puntos de vida");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 270, 170, 30));

        jLabel3.setFont(new java.awt.Font("Snap ITC", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(240, 240, 240));
        jLabel3.setText("Tipo");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 70, -1, -1));

        jLabel5.setFont(new java.awt.Font("Snap ITC", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Calidad");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 70, -1, -1));

        jLabel6.setFont(new java.awt.Font("Snap ITC", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(240, 240, 240));
        jLabel6.setText("Velocidad de generación");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 340, -1, 40));

        jLabel7.setFont(new java.awt.Font("Snap ITC", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Objetivo");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 350, -1, -1));

        jLabel9.setFont(new java.awt.Font("Snap ITC", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(240, 240, 240));
        jLabel9.setText("Velocidad");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 270, -1, -1));

        jLabel10.setFont(new java.awt.Font("Snap ITC", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(240, 240, 240));
        jLabel10.setText("Alcance");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 420, -1, -1));

        NCar.setFont(new java.awt.Font("Snap ITC", 0, 24)); // NOI18N
        NCar.setForeground(new java.awt.Color(255, 51, 255));
        NCar.setBorder(null);
        NCar.setOpaque(false);
        jPanel2.add(NCar, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, 270, 50));

        Cali.setBackground(new java.awt.Color(255, 51, 255));
        Cali.setFont(new java.awt.Font("Snap ITC", 0, 18)); // NOI18N
        Cali.setForeground(new java.awt.Color(255, 51, 255));
        Cali.setBorder(null);
        Cali.setOpaque(false);
        jPanel2.add(Cali, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 100, 120, -1));

        Tip.setBackground(new java.awt.Color(255, 51, 255));
        Tip.setFont(new java.awt.Font("Snap ITC", 0, 18)); // NOI18N
        Tip.setForeground(new java.awt.Color(255, 51, 255));
        Tip.setBorder(null);
        Tip.setOpaque(false);
        jPanel2.add(Tip, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 100, 120, -1));

        Hit.setBackground(new java.awt.Color(255, 51, 255));
        Hit.setFont(new java.awt.Font("Snap ITC", 0, 18)); // NOI18N
        Hit.setForeground(new java.awt.Color(255, 51, 255));
        Hit.setBorder(null);
        Hit.setOpaque(false);
        jPanel2.add(Hit, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 310, 100, -1));

        Vel.setBackground(new java.awt.Color(255, 51, 255));
        Vel.setFont(new java.awt.Font("Snap ITC", 0, 18)); // NOI18N
        Vel.setForeground(new java.awt.Color(255, 51, 255));
        Vel.setBorder(null);
        Vel.setOpaque(false);
        jPanel2.add(Vel, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 310, 100, -1));

        Obj.setBackground(new java.awt.Color(255, 51, 255));
        Obj.setFont(new java.awt.Font("Snap ITC", 0, 18)); // NOI18N
        Obj.setForeground(new java.awt.Color(255, 51, 255));
        Obj.setBorder(null);
        Obj.setOpaque(false);
        jPanel2.add(Obj, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 380, 150, -1));

        VGen.setBackground(new java.awt.Color(255, 51, 255));
        VGen.setFont(new java.awt.Font("Snap ITC", 0, 18)); // NOI18N
        VGen.setForeground(new java.awt.Color(255, 51, 255));
        VGen.setBorder(null);
        VGen.setOpaque(false);
        jPanel2.add(VGen, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 380, 100, -1));

        Al.setBackground(new java.awt.Color(255, 51, 255));
        Al.setFont(new java.awt.Font("Snap ITC", 0, 18)); // NOI18N
        Al.setForeground(new java.awt.Color(255, 51, 255));
        Al.setBorder(null);
        Al.setOpaque(false);
        jPanel2.add(Al, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 450, 90, -1));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/closeButton.png"))); // NOI18N
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.setHideActionText(true);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(443, 30, 80, 30));

        jLabel1.setFont(new java.awt.Font("Snap ITC", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(240, 240, 240));
        jLabel1.setText("Velocidad de ataque");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 420, -1, -1));

        VAta.setBackground(new java.awt.Color(255, 51, 255));
        VAta.setFont(new java.awt.Font("Snap ITC", 0, 18)); // NOI18N
        VAta.setForeground(new java.awt.Color(255, 51, 255));
        VAta.setBorder(null);
        VAta.setOpaque(false);
        jPanel2.add(VAta, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 450, 100, 20));

        jLabel4.setFont(new java.awt.Font("Snap ITC", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Descripción");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 180, -1, -1));

        descrip.setBackground(new java.awt.Color(0, 102, 153));
        descrip.setColumns(20);
        descrip.setFont(new java.awt.Font("Snap ITC", 0, 18)); // NOI18N
        descrip.setForeground(new java.awt.Color(255, 51, 255));
        descrip.setLineWrap(true);
        descrip.setRows(5);
        descrip.setBorder(null);
        jScrollPane1.setViewportView(descrip);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 130, 230, -1));
        jPanel2.add(muestraFoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 120, 150));

        modificar.setFont(new java.awt.Font("Snap ITC", 0, 24)); // NOI18N
        modificar.setForeground(new java.awt.Color(255, 255, 255));
        modificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/button2.png"))); // NOI18N
        modificar.setText("Modificar");
        modificar.setBorderPainted(false);
        modificar.setContentAreaFilled(false);
        modificar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarActionPerformed(evt);
            }
        });
        jPanel2.add(modificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 510, 190, 80));

        Fondo1.setFont(new java.awt.Font("Snap ITC", 0, 18)); // NOI18N
        Fondo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/background.jpg"))); // NOI18N
        jPanel2.add(Fondo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 550, 650));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        this.setVisible(false);
        p3.nombrePerfil.setText(Principal.cUsuario);
        p3.setVisible(true);

    }//GEN-LAST:event_jButton1ActionPerformed

    private void modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarActionPerformed
        try {
            actualizaCarta();
            nuevaCarta();
            c.contador++;
            JOptionPane.showMessageDialog(rootPane, "La carta ha sido actualizada", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            this.setVisible(false);
            c.setVisible(true);
            
            
        } catch (SQLException ex) {
            Logger.getLogger(ModificarCarta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_modificarActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(ModificarCarta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ModificarCarta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ModificarCarta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ModificarCarta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
    // java.awt.EventQueue.invokeLater(new Runnable() {
    //    public void run() {
    //        new ModificarCarta().setVisible(true);
    //    }
    // });
    // }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTextField Al;
    public javax.swing.JTextField Cali;
    private javax.swing.JLabel Fondo1;
    public javax.swing.JTextField Hit;
    public javax.swing.JTextField NCar;
    public javax.swing.JTextField Obj;
    public javax.swing.JTextField Tip;
    public javax.swing.JTextField VAta;
    public javax.swing.JTextField VGen;
    public javax.swing.JTextField Vel;
    public javax.swing.JTextArea descrip;
    public javax.swing.JTextField elix;
    private javax.swing.JLabel elixir;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton modificar;
    public javax.swing.JLabel muestraFoto;
    // End of variables declaration//GEN-END:variables
}
