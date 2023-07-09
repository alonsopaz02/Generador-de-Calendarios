/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interfaces;

import Clases.Equipo;
import Clases.Torneo;
import java.awt.Graphics;
import java.awt.Image;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author LG
 */
public class PantallaInicial extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    public ArrayList<Torneo> Torneos = new ArrayList<>();
    FondoPanel fondo = new FondoPanel();

    public PantallaInicial(ArrayList torneos) {
        this.Torneos = torneos;
        this.setContentPane(fondo);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Fondo = new javax.swing.JPanel();
        FondoJ = new FondoPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Iniciar = new javax.swing.JButton();

        javax.swing.GroupLayout FondoLayout = new javax.swing.GroupLayout(Fondo);
        Fondo.setLayout(FondoLayout);
        FondoLayout.setHorizontalGroup(
            FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 558, Short.MAX_VALUE)
        );
        FondoLayout.setVerticalGroup(
            FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 279, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel1.setFont(new java.awt.Font("Lucida Fax", 1, 30)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("BIENVENIDO");

        jLabel2.setFont(new java.awt.Font("Lucida Fax", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Generador de Torneos");

        Iniciar.setFont(new java.awt.Font("Serif", 1, 16)); // NOI18N
        Iniciar.setForeground(new java.awt.Color(102, 204, 255));
        Iniciar.setText("Iniciar");
        Iniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IniciarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout FondoJLayout = new javax.swing.GroupLayout(FondoJ);
        FondoJ.setLayout(FondoJLayout);
        FondoJLayout.setHorizontalGroup(
            FondoJLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FondoJLayout.createSequentialGroup()
                .addContainerGap(136, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(133, 133, 133))
            .addGroup(FondoJLayout.createSequentialGroup()
                .addGroup(FondoJLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(FondoJLayout.createSequentialGroup()
                        .addGap(177, 177, 177)
                        .addComponent(jLabel1))
                    .addGroup(FondoJLayout.createSequentialGroup()
                        .addGap(236, 236, 236)
                        .addComponent(Iniciar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        FondoJLayout.setVerticalGroup(
            FondoJLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FondoJLayout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 294, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(42, 42, 42)
                .addComponent(Iniciar)
                .addGap(40, 40, 40))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(FondoJ, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(FondoJ, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void IniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IniciarActionPerformed
        PantallaMenu menu = new PantallaMenu(Torneos);
        menu.setVisible(true);
        dispose();
    }//GEN-LAST:event_IniciarActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(PantallaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PantallaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PantallaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PantallaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
      /*  ArrayList<Torneo> todoslosTorneos = new ArrayList<>();
        ArrayList teams = new ArrayList<Equipo>();
        teams.add(new Equipo("A"));
        teams.add(new Equipo("B"));
        teams.add(new Equipo("C"));
        teams.add(new Equipo("D"));
        teams.add(new Equipo("E"));
        teams.add(new Equipo("F"));
        teams.add(new Equipo("H"));
        teams.add(new Equipo("I"));
        teams.add(new Equipo("J"));
        Calendar calendario = Calendar.getInstance();
        Date fechaHoy = calendario.getTime();
        Torneo tor = new Torneo(teams, fechaHoy, "Premier League");
        todoslosTorneos.add(tor);

        ArrayList teams2 = new ArrayList<Equipo>();
        teams2.add(new Equipo("A"));
        teams2.add(new Equipo("B"));
        teams2.add(new Equipo("C"));
        teams2.add(new Equipo("D"));
        teams2.add(new Equipo("E"));
        teams2.add(new Equipo("F"));
        teams2.add(new Equipo("H"));
        teams2.add(new Equipo("I"));
        Torneo tor1 = new Torneo(teams2, fechaHoy, "La Liga");
        todoslosTorneos.add(tor1); */
        
        ArrayList<Torneo> torneosCargados = cargarTorneos("torneos.dat");
        

        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PantallaInicial(torneosCargados).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Fondo;
    private javax.swing.JPanel FondoJ;
    private javax.swing.JButton Iniciar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables

    public static void guardarTorneos(ArrayList<Torneo> torneos, String nombreArchivo) {
        try {
            FileOutputStream fileOut = new FileOutputStream(nombreArchivo);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(torneos);
            out.close();
            fileOut.close();
            System.out.println("Los torneos se han guardado correctamente en el archivo " + nombreArchivo);
        } catch (IOException e) {
            System.out.println("Error al guardar los torneos: " + e.getMessage());
        }
    }
    
    public static ArrayList<Torneo> cargarTorneos(String nombreArchivo) {
        ArrayList<Torneo> torneos = null;
        try {
            FileInputStream fileIn = new FileInputStream(nombreArchivo);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            torneos = (ArrayList<Torneo>) in.readObject();
            in.close();
            fileIn.close();
            System.out.println("Los torneos se han cargado correctamente desde el archivo " + nombreArchivo);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al cargar los torneos: " + e.getMessage());
        }
        return torneos;
    }

    class FondoPanel extends JPanel {

        private Image imagen;

        @Override
        public void paint(Graphics g) {
            imagen = new ImageIcon(getClass().getResource("/Imagenes/fondo_2.png")).getImage();
            g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);

            setOpaque(false);

            super.paint(g);
        }
    }

}