package App;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import static App.ModificarCarta.c;

/**
 * @author Borja Blanco & Diego Sanchez
 */
public class Cartas extends javax.swing.JFrame {

    static AgregarCarta mCR3 = new AgregarCarta();
    static BarajaCartas Bc = new BarajaCartas();
    Portada p2 = new Portada();
    static Principal p = new Principal();
    static ModificarCarta md = new ModificarCarta();
    Connection con;
    ResultSet rs;
    Statement st;
    static int contador = 0;
    static String nombre2 = "", calidad2 = "", tipo2 = "", descripcion2 = "", objetivo2 = "", velocidad2 = "";
    static int elixir2 = 0, hp2 = 0, vAtaque2 = 0, vGeneracion2 = 0, alcance2 = 0;

    public Cartas() {
        initComponents();
        setLocationRelativeTo(null);
        descrip.setLineWrap(true);
    }

    public void rellenarCampos() throws SQLException {

        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/prueba", "root", "root");
        st = con.createStatement();
        String query = "select nombre, calidad, tipo, descripcion from cartas where nombre like '" + BarajaCartas.jComboBox1.getSelectedItem().toString() + "'";
        String query2 = "select * from detalleCartas where id_carta in(select id_carta from cartas where nombre like '" + BarajaCartas.jComboBox1.getSelectedItem().toString() + "') AND id_user = " + Principal.id_user + "";
        rs = st.executeQuery(query);
        while (rs.next()) {
            nombre2 = rs.getString(1);
            calidad2 = rs.getString(2);
            tipo2 = rs.getString(3);
            descripcion2 = rs.getString(4);
        }
        rs = st.executeQuery(query2);
        while (rs.next()) {
            elixir2 = rs.getInt(4);
            hp2 = rs.getInt(5);
            vAtaque2 = rs.getInt(6);
            vGeneracion2 = rs.getInt(7);
            objetivo2 = rs.getString(8);
            velocidad2 = rs.getString(9);
            alcance2 = rs.getInt(10);
        }

        NCar.setText(nombre2);
        Cali.setText(calidad2);
        Tip.setText(tipo2);
        descrip.setText(descripcion2);
        elix.setText(Integer.toString(elixir2));
        Hit.setText(Integer.toString(hp2));
        Vel.setText(velocidad2);
        Obj.setText(objetivo2);
        VGen.setText(Integer.toString(vGeneracion2));
        VAta.setText(Integer.toString(vAtaque2));
        Al.setText(Integer.toString(alcance2));
        muestraFoto.setIcon(new ImageIcon(AgregarCarta.ruta));

    }

    public void borrarCarta() throws SQLException {

        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/prueba", "root", "root");
        st = con.createStatement();
        String query = "delete from cartas where nombre like '" + BarajaCartas.jComboBox1.getSelectedItem().toString() + "'";
        String query2 = "delete from detalleCartas where id_user like " + p.id_user + " AND id_carta in(select id_carta from cartas where nombre like '" + BarajaCartas.jComboBox1.getSelectedItem().toString() + "')";
        int n = st.executeUpdate(query2);
        int o = st.executeUpdate(query);
    }

    public void rellenar() throws SQLException {
        rellenarCampos();
        md.NCar.setText(NCar.getText());
        md.Cali.setText(Cali.getText());
        md.Tip.setText(Tip.getText());
        md.descrip.setText(descrip.getText());
        md.elix.setText(elix.getText());
        md.Hit.setText(Hit.getText());
        md.Vel.setText(Vel.getText());
        md.Obj.setText(Obj.getText());
        md.VGen.setText(VGen.getText());
        md.VAta.setText(VAta.getText());
        md.Al.setText(Al.getText());
        md.muestraFoto.setIcon(new ImageIcon(AgregarCarta.ruta));
    }

    public void rellenar2() throws SQLException {
        md.NCar.setText(c.NCar.getText());
        md.Cali.setText(c.Cali.getText());
        md.Tip.setText(c.Tip.getText());
        md.descrip.setText(c.descrip.getText());
        md.elix.setText(c.elix.getText());
        md.Hit.setText(c.Hit.getText());
        md.Vel.setText(c.Vel.getText());
        md.Obj.setText(c.Obj.getText());
        md.VGen.setText(c.VGen.getText());
        md.VAta.setText(c.VAta.getText());
        md.Al.setText(c.Al.getText());
        md.muestraFoto.setIcon(new ImageIcon(AgregarCarta.ruta));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
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
        jLabel8 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        borrar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        descrip = new javax.swing.JTextArea();
        muestraFoto = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        modificar = new javax.swing.JButton();
        Fondo = new javax.swing.JLabel();

        setUndecorated(true);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        elix.setEditable(false);
        elix.setFont(new java.awt.Font("Snap ITC", 0, 30)); // NOI18N
        elix.setForeground(new java.awt.Color(255, 255, 255));
        elix.setBorder(null);
        elix.setOpaque(false);
        jPanel1.add(elix, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, 40, 40));

        elixir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/elixir.png"))); // NOI18N
        jPanel1.add(elixir, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 90, 80));

        jLabel2.setFont(new java.awt.Font("Snap ITC", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Puntos de vida");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 270, 170, 30));

        jLabel3.setFont(new java.awt.Font("Snap ITC", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(240, 240, 240));
        jLabel3.setText("Tipo");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 70, -1, -1));

        jLabel5.setFont(new java.awt.Font("Snap ITC", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Calidad");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 70, -1, -1));

        jLabel6.setFont(new java.awt.Font("Snap ITC", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(240, 240, 240));
        jLabel6.setText("Velocidad de generación");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 340, -1, 40));

        jLabel7.setFont(new java.awt.Font("Snap ITC", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Objetivo");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 350, -1, -1));

        jLabel9.setFont(new java.awt.Font("Snap ITC", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(240, 240, 240));
        jLabel9.setText("Velocidad");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 270, -1, -1));

        jLabel10.setFont(new java.awt.Font("Snap ITC", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(240, 240, 240));
        jLabel10.setText("Alcance");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 420, -1, -1));

        NCar.setEditable(false);
        NCar.setFont(new java.awt.Font("Snap ITC", 0, 24)); // NOI18N
        NCar.setForeground(new java.awt.Color(255, 51, 255));
        NCar.setBorder(null);
        NCar.setOpaque(false);
        jPanel1.add(NCar, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, 270, 50));

        Cali.setEditable(false);
        Cali.setBackground(new java.awt.Color(255, 51, 255));
        Cali.setFont(new java.awt.Font("Snap ITC", 0, 18)); // NOI18N
        Cali.setForeground(new java.awt.Color(255, 51, 255));
        Cali.setBorder(null);
        Cali.setOpaque(false);
        jPanel1.add(Cali, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 100, 130, -1));

        Tip.setEditable(false);
        Tip.setBackground(new java.awt.Color(255, 51, 255));
        Tip.setFont(new java.awt.Font("Snap ITC", 0, 18)); // NOI18N
        Tip.setForeground(new java.awt.Color(255, 51, 255));
        Tip.setBorder(null);
        Tip.setOpaque(false);
        jPanel1.add(Tip, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 100, 120, -1));

        Hit.setEditable(false);
        Hit.setBackground(new java.awt.Color(255, 51, 255));
        Hit.setFont(new java.awt.Font("Snap ITC", 0, 18)); // NOI18N
        Hit.setForeground(new java.awt.Color(255, 51, 255));
        Hit.setBorder(null);
        Hit.setOpaque(false);
        jPanel1.add(Hit, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 310, 100, -1));

        Vel.setEditable(false);
        Vel.setBackground(new java.awt.Color(255, 51, 255));
        Vel.setFont(new java.awt.Font("Snap ITC", 0, 18)); // NOI18N
        Vel.setForeground(new java.awt.Color(255, 51, 255));
        Vel.setBorder(null);
        Vel.setOpaque(false);
        jPanel1.add(Vel, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 310, 100, -1));

        Obj.setEditable(false);
        Obj.setBackground(new java.awt.Color(255, 51, 255));
        Obj.setFont(new java.awt.Font("Snap ITC", 0, 18)); // NOI18N
        Obj.setForeground(new java.awt.Color(255, 51, 255));
        Obj.setBorder(null);
        Obj.setOpaque(false);
        jPanel1.add(Obj, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 380, 160, -1));

        VGen.setEditable(false);
        VGen.setBackground(new java.awt.Color(255, 51, 255));
        VGen.setFont(new java.awt.Font("Snap ITC", 0, 18)); // NOI18N
        VGen.setForeground(new java.awt.Color(255, 51, 255));
        VGen.setBorder(null);
        VGen.setOpaque(false);
        jPanel1.add(VGen, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 380, 100, -1));

        Al.setEditable(false);
        Al.setBackground(new java.awt.Color(255, 51, 255));
        Al.setFont(new java.awt.Font("Snap ITC", 0, 18)); // NOI18N
        Al.setForeground(new java.awt.Color(255, 51, 255));
        Al.setBorder(null);
        Al.setOpaque(false);
        jPanel1.add(Al, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 450, 90, -1));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/closeButton.png"))); // NOI18N
        jButton1.setBorderPainted(false);
        jButton1.setContentAreaFilled(false);
        jButton1.setHideActionText(true);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(443, 30, 80, 30));

        jLabel1.setFont(new java.awt.Font("Snap ITC", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(240, 240, 240));
        jLabel1.setText("Velocidad de ataque");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 420, -1, -1));

        VAta.setEditable(false);
        VAta.setBackground(new java.awt.Color(255, 51, 255));
        VAta.setFont(new java.awt.Font("Snap ITC", 0, 18)); // NOI18N
        VAta.setForeground(new java.awt.Color(255, 51, 255));
        VAta.setBorder(null);
        VAta.setOpaque(false);
        jPanel1.add(VAta, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 450, 100, 20));

        jLabel4.setFont(new java.awt.Font("Snap ITC", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Descripción");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 180, -1, -1));

        jLabel8.setFont(new java.awt.Font("Snap ITC", 0, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Borrar");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 520, -1, -1));

        jLabel11.setFont(new java.awt.Font("Snap ITC", 0, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Carta");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 550, -1, -1));

        borrar.setFont(new java.awt.Font("Snap ITC", 0, 24)); // NOI18N
        borrar.setForeground(new java.awt.Color(255, 255, 255));
        borrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/button2.png"))); // NOI18N
        borrar.setBorderPainted(false);
        borrar.setContentAreaFilled(false);
        borrar.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        borrar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        borrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                borrarActionPerformed(evt);
            }
        });
        jPanel1.add(borrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 520, -1, 70));

        descrip.setEditable(false);
        descrip.setBackground(new java.awt.Color(0, 102, 153));
        descrip.setColumns(20);
        descrip.setFont(new java.awt.Font("Snap ITC", 0, 18)); // NOI18N
        descrip.setForeground(new java.awt.Color(255, 51, 255));
        descrip.setLineWrap(true);
        descrip.setRows(5);
        descrip.setToolTipText("Describe las caracteristicas de tu carta");
        descrip.setBorder(null);
        jScrollPane1.setViewportView(descrip);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 130, 230, -1));
        jPanel1.add(muestraFoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 120, 150));

        jLabel12.setFont(new java.awt.Font("Snap ITC", 0, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Modificar");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 520, -1, -1));

        jLabel13.setFont(new java.awt.Font("Snap ITC", 0, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Carta");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 550, -1, -1));

        modificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/button2.png"))); // NOI18N
        modificar.setBorderPainted(false);
        modificar.setContentAreaFilled(false);
        modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarActionPerformed(evt);
            }
        });
        jPanel1.add(modificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 520, 160, 70));

        Fondo.setFont(new java.awt.Font("Snap ITC", 0, 18)); // NOI18N
        Fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/background.jpg"))); // NOI18N
        jPanel1.add(Fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 550, 650));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        this.setVisible(false);
        p2.nombrePerfil.setText(Principal.cUsuario);
        p2.setVisible(true);


    }//GEN-LAST:event_jButton1ActionPerformed

    private void borrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_borrarActionPerformed
        try {
            borrarCarta();
            JOptionPane.showMessageDialog(rootPane, "La carta ha sido borrada", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            BarajaCartas.jComboBox1.removeAllItems();
            this.setVisible(false);
            p2.setVisible(true);
            p2.nombrePerfil.setText(Principal.cUsuario);
        } catch (SQLException ex) {
            Logger.getLogger(Cartas.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_borrarActionPerformed

    private void modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarActionPerformed

        try {
            if (contador == 0) {
                rellenar();
                this.setVisible(false);
                md.setVisible(true);
            } else {
                rellenar2();
                this.setVisible(false);
                md.setVisible(true);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Cartas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_modificarActionPerformed

    /**
     * @param args the command line arguments
     */
    // public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(Cartas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Cartas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Cartas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Cartas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
    //java.awt.EventQueue.invokeLater(new Runnable() {
    //  public void run() {
    //     new Cartas().setVisible(true);
    // }
    //});
    //}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTextField Al;
    public javax.swing.JTextField Cali;
    private javax.swing.JLabel Fondo;
    public javax.swing.JTextField Hit;
    public javax.swing.JTextField NCar;
    public javax.swing.JTextField Obj;
    public javax.swing.JTextField Tip;
    public javax.swing.JTextField VAta;
    public javax.swing.JTextField VGen;
    public javax.swing.JTextField Vel;
    private javax.swing.JButton borrar;
    public javax.swing.JTextArea descrip;
    public javax.swing.JTextField elix;
    private javax.swing.JLabel elixir;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton modificar;
    public javax.swing.JLabel muestraFoto;
    // End of variables declaration//GEN-END:variables
}
