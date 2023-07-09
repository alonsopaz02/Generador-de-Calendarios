/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interfaces;

import Clases.Equipo;
import Clases.Partido;
import Clases.Torneo;
import java.awt.Graphics;
import java.awt.Image;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author LG
 */
public class PantallaSeccionPartidos extends javax.swing.JFrame {

    /**
     * Creates new form PantallaSecciónPartidos
     */
    FondoPanel fondo = new FondoPanel();
    ArrayList<Torneo> torneos;
    String nombreTorneo;
    Torneo tor;

    public PantallaSeccionPartidos(ArrayList torneo, String nombreTorneo) {
        this.setContentPane(fondo);
        initComponents();
        //this.torneos = torneo;
        this.torneos = PantallaInicial.cargarTorneos("torneos.dat");
        this.nombreTorneo = nombreTorneo;
        for (int i = 0; i < torneos.size(); i++) {
            if (torneos.get(i).getNombre().equals(nombreTorneo)) {
                this.tor = torneos.get(i);
            }
        }
        inicializarMenu();
    }

    private void inicializarMenu() {
        Equipo[] equiposArray = tor.getEquipos().toArray(new Equipo[tor.getEquipos().size()]);
        ArrayList<Equipo> equiposOrdenados = new ArrayList<>();
        Equipo equipoDescanso = null;

        for (Equipo equipo : equiposArray) {
            if (equipo.getNombre().equalsIgnoreCase("Descanso")) {
                equipoDescanso = equipo;
            } else {
                equiposOrdenados.add(equipo);
            }
        }

        for (int i = 1; i < equiposOrdenados.size(); i++) {
            Equipo equipoActual = equiposOrdenados.get(i);
            int j = i - 1;

            while (j >= 0 && equiposOrdenados.get(j).getNombre().compareToIgnoreCase(equipoActual.getNombre()) > 0) {
                equiposOrdenados.set(j + 1, equiposOrdenados.get(j));
                j--;
            }

            equiposOrdenados.set(j + 1, equipoActual);
        }

        for (Equipo equipo : equiposOrdenados) {
            jComboBox1.addItem(equipo.getNombre()); // Agrega cada nombre de equipo ordenado al JComboBox
        }

        if (equipoDescanso != null) {
            jComboBox1.addItem(equipoDescanso.getNombre()); // Agrega el equipo "Descanso" al final del JComboBox
        }

        jComboBox1.addItem("Todos");
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
        Siguiente = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jComboBox1 = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Lucida Fax", 1, 28)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Torneos");

        Siguiente.setFont(new java.awt.Font("Serif", 1, 16)); // NOI18N
        Siguiente.setForeground(new java.awt.Color(51, 204, 255));
        Siguiente.setText("Siguiente");
        Siguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SiguienteActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Serif", 2, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Sección de partidos");

        jLabel3.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Partidos");

        jLabel6.setFont(new java.awt.Font("Serif", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Programación");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Jornada", "Local", "Visita", "Fecha"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jComboBox1.setFont(new java.awt.Font("Serif", 0, 14)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione un equipo" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Siguiente, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(223, 223, 223))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(216, 216, 216)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(188, 188, 188)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel3)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 476, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(Siguiente)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SiguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SiguienteActionPerformed
        PantallaSeccionJornada jornada = new PantallaSeccionJornada(torneos, nombreTorneo);
        jornada.setVisible(true);
        dispose();
    }//GEN-LAST:event_SiguienteActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        String equipoSeleccionado = (String) jComboBox1.getSelectedItem();

        if (equipoSeleccionado.equals("Todos")) {
            mostrarTodosLosPartidos(); // Mostrar todos los partidos si se selecciona "Todos"
        } else {
            mostrarPartidosDelEquipo(equipoSeleccionado); // Mostrar los partidos del equipo seleccionado
        }
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void mostrarTodosLosPartidos() {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0); // Limpiar el contenido del JTable

        // Agregar todos los partidos al JTable
        for (int i = 0; i < tor.getNumeroJornadas(); i++) {
            for (int j = 0; j < tor.getNumeroPartidosXJornada(); j++) {
                Partido partido = tor.getPartidos()[i][j];
                Object[] rowData = {i + 1, partido.getLocal().getNombre(), partido.getVisita().getNombre(), partido.getFecha()};
                model.addRow(rowData);
            }
        }
    }

    private void mostrarPartidosDelEquipo(String nombreEquipo) {
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0); // Limpiar el contenido del JTable

        // Filtrar los partidos del equipo seleccionado
        for (int i = 0; i < tor.getNumeroJornadas(); i++) {
            for (int j = 0; j < tor.getNumeroPartidosXJornada(); j++) {
                Partido partido = tor.getPartidos()[i][j];
                // Verificar si el equipo seleccionado participa en el partido como local o visita
                if (partido.getLocal().getNombre().equals(nombreEquipo) || partido.getVisita().getNombre().equals(nombreEquipo)) {
                    Object[] rowData = {i + 1, partido.getLocal().getNombre(), partido.getVisita().getNombre(), partido.getFecha()};
                    model.addRow(rowData);
                }
            }
        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Siguiente;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
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