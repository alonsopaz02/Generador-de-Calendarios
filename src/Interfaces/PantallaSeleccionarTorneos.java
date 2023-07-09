/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interfaces;

import Clases.Torneo;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author LG
 */
public class PantallaSeleccionarTorneos extends javax.swing.JFrame {

    /**
     * Creates new form PantallaMostrarTorneos
     */
    FondoPanel fondo = new FondoPanel();
    public ArrayList<Torneo> Torneos;

    public PantallaSeleccionarTorneos(ArrayList torneos) {
        this.setContentPane(fondo);
        //this.Torneos = torneos;
        this.Torneos = PantallaInicial.cargarTorneos("torneos.dat");
        initComponents();
        inicializarComboBox();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        Seleccionar = new javax.swing.JButton();
        Regresar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Lucida Fax", 1, 28)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("SELECCIONAR TORNEO");

        jComboBox1.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione el torneo" }));

        jLabel3.setFont(new java.awt.Font("Serif", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Torneos");

        Seleccionar.setFont(new java.awt.Font("Serif", 1, 16)); // NOI18N
        Seleccionar.setForeground(new java.awt.Color(51, 204, 255));
        Seleccionar.setText("Seleccionar");
        Seleccionar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                SeleccionarMousePressed(evt);
            }
        });

        Regresar.setFont(new java.awt.Font("Serif", 1, 16)); // NOI18N
        Regresar.setForeground(new java.awt.Color(51, 204, 255));
        Regresar.setText("Regresar");
        Regresar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                RegresarMousePressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(220, 220, 220)
                        .addComponent(Seleccionar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(Regresar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(110, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(126, 126, 126)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(111, 111, 111)
                            .addComponent(jLabel3)))
                    .addContainerGap(126, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 222, Short.MAX_VALUE)
                .addComponent(Seleccionar)
                .addGap(107, 107, 107)
                .addComponent(Regresar)
                .addGap(44, 44, 44))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(201, 201, 201)
                    .addComponent(jLabel3)
                    .addGap(12, 12, 12)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(260, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void RegresarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RegresarMousePressed
        PantallaMenu menu = new PantallaMenu(Torneos);
        menu.setVisible(true);
        dispose();
    }//GEN-LAST:event_RegresarMousePressed

    private void SeleccionarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SeleccionarMousePressed
        String nombreTorneo = jComboBox1.getSelectedItem().toString();
        PantallaSeccionEquipos mostrar = new PantallaSeccionEquipos(Torneos, nombreTorneo);
        mostrar.setVisible(true);
        dispose();
    }//GEN-LAST:event_SeleccionarMousePressed

    private void inicializarComboBox() {
        String[] nombresTorneos = new String[Torneos.size()];

        for (int i = 0; i < Torneos.size(); i++) {
            nombresTorneos[i] = Torneos.get(i).getNombre();
        }

        for (int i = 0; i < nombresTorneos.length - 1; i++) {
            int indiceMinimo = i;

            for (int j = i + 1; j < nombresTorneos.length; j++) {
                if (nombresTorneos[j].compareToIgnoreCase(nombresTorneos[indiceMinimo]) < 0) {
                    indiceMinimo = j;
                }
            }

            if (indiceMinimo != i) {
                String temp = nombresTorneos[i];
                nombresTorneos[i] = nombresTorneos[indiceMinimo];
                nombresTorneos[indiceMinimo] = temp;
            }
        }

        for (String nombreTorneo : nombresTorneos) {
            jComboBox1.addItem(nombreTorneo);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Regresar;
    private javax.swing.JButton Seleccionar;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
class FondoPanel extends JPanel {

        private Image imagen;

        @Override
        public void paint(Graphics g) {
            imagen = new ImageIcon(getClass().getResource("/Imagenes/segundo_fondo.png")).getImage();
            g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);

            setOpaque(false);

            super.paint(g);
        }
    }

}
