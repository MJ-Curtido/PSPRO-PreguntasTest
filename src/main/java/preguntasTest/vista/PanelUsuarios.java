/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package preguntasTest.vista;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import preguntasTest.clases.Opcion;
import preguntasTest.clases.Pregunta;
import preguntasTest.clases.Usuario;
import preguntasTest.gestion.DAOProyecto;

/**
 *
 * @author Dam
 */
public class PanelUsuarios extends javax.swing.JPanel {
    VentanaPreguntas miVentana;
    private Boolean editar;
    private Usuario usuarioAEditar;
    private List<Usuario> listaUsuarios;
    private Pregunta pregunta;
    private List<Opcion> opciones;
    private List<Pregunta> preguntas;
    
    /**
     * Creates new form PanelUsuarios
     */
    public PanelUsuarios(VentanaPreguntas miVentana) {
        initComponents();
        
        this.miVentana = miVentana;
        editar = false;                                                                                                                                        
        
        cargarTabla();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tablaUsuarios = new javax.swing.JTable();
        lblNombre = new javax.swing.JLabel();
        tbApellido1 = new javax.swing.JTextField();
        lblApellido1 = new javax.swing.JLabel();
        tbNombre = new javax.swing.JTextField();
        lblApellido2 = new javax.swing.JLabel();
        tbApellido2 = new javax.swing.JTextField();
        btnRegistrar = new javax.swing.JButton();
        btnBorrar = new javax.swing.JButton();
        btnLeer = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();

        tablaUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Id", "Nombre", "Apellido1", "Apellido2"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaUsuarios);

        lblNombre.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblNombre.setText("Nombre");
        lblNombre.setName(""); // NOI18N

        lblApellido1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblApellido1.setText("Apellido1");
        lblApellido1.setName(""); // NOI18N

        lblApellido2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblApellido2.setText("Apellido2");
        lblApellido2.setName(""); // NOI18N

        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        btnBorrar.setText("Borrar");
        btnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBorrarActionPerformed(evt);
            }
        });

        btnLeer.setText("Leer");
        btnLeer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLeerActionPerformed(evt);
            }
        });

        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblApellido2)
                                        .addGap(18, 18, 18)
                                        .addComponent(tbApellido2, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblNombre)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnLeer, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(27, 27, 27))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 488, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(tbNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblApellido1)
                                .addGap(18, 18, 18)
                                .addComponent(tbApellido1, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tbNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNombre)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnLeer, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tbApellido1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblApellido1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblApellido2)
                            .addComponent(tbApellido2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(btnBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        if (editar) {
            DAOProyecto.getInstance().editarUsuario(usuarioAEditar, tbNombre.getText().toString(), tbApellido1.getText().toString(), tbApellido2.getText().toString());
            JOptionPane.showMessageDialog(null, "Usuario editado correctamente.");
            cargarTabla();
            
            btnRegistrar.setText("Registrar");
            editar = false;
        }
        else {
            if (tbNombre.getText().equals("") || tbApellido1.getText().equals("") || tbApellido2.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Debes introducir todos los valores para poder registrar un usuario.");
            }
            else {
                insertarUsuario();
                cargarTabla();
            }
        }
        
        this.updateUI();
    }//GEN-LAST:event_btnRegistrarActionPerformed
    
    private void btnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBorrarActionPerformed
        if (tablaUsuarios.getSelectedRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "Debes seleccionar mínimo un usuario para poder eliminarlo.");
        }
        else {
            int[] filas = tablaUsuarios.getSelectedRows();
            List<Usuario> usuariosSinPreg = new ArrayList<Usuario>();
            List<Usuario> usuariosConPreg = new ArrayList<Usuario>();
            
            for (int i = 0; i < filas.length; i++) {
                if (DAOProyecto.getInstance().obtenerPreguntas(listaUsuarios.get(filas[i])).size() == 0) {
                    usuariosSinPreg.add(listaUsuarios.get(filas[i]));   
                }
                else {
                    usuariosConPreg.add(listaUsuarios.get(filas[i])); 
                }
            }
            
            DAOProyecto.getInstance().eliminarUsuarios(usuariosSinPreg);
            
            if (usuariosConPreg.size() > 0) {
                if (JOptionPane.showConfirmDialog(null, "Algún usuario seleccionado tiene preguntas, ¿Desea eliminarlo?", "CUIDADO", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                    for (int i = 0; i < usuariosConPreg.size(); i++) {
                        preguntas = DAOProyecto.getInstance().obtenerPreguntas(usuariosConPreg.get(i));
                        
                        for (int j = 0; j < preguntas.size(); j++) {
                            DAOProyecto.getInstance().eliminarRespuestas(DAOProyecto.getInstance().obtenerRespuestas(preguntas.get(j)));
                            DAOProyecto.getInstance().eliminarPregunta(preguntas.get(j));  
                        }
                    }
                    
                    DAOProyecto.getInstance().eliminarUsuarios(usuariosConPreg);
                }
            }
            
            cargarTabla();
        }
        
        this.updateUI();
    }//GEN-LAST:event_btnBorrarActionPerformed

    private void btnLeerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLeerActionPerformed
        if (!editar) {
            if (tablaUsuarios.getSelectedRowCount() == 1) {
                usuarioAEditar = listaUsuarios.get(tablaUsuarios.getSelectedRow());

                tbNombre.setText(tablaUsuarios.getValueAt(tablaUsuarios.getSelectedRow(), 1).toString());
                tbApellido1.setText(tablaUsuarios.getValueAt(tablaUsuarios.getSelectedRow(), 2).toString());
                tbApellido2.setText(tablaUsuarios.getValueAt(tablaUsuarios.getSelectedRow(), 3).toString());

                btnRegistrar.setText("Editar");
                btnLeer.setText("Cancelar");
                editar = true;
            }
            else if (tablaUsuarios.getSelectedRowCount() == 0) {
                JOptionPane.showMessageDialog(null, "Debes seleccionar mínimo un usuario para poder editarlo.");
            }
            else {
                JOptionPane.showMessageDialog(null, "No puedes editar más de un usuario a la vez.");
            }
        }
        else {
            editar = false;
            
            btnRegistrar.setText("Registrar");
            btnLeer.setText("Leer");
        }
    }//GEN-LAST:event_btnLeerActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        PanelInicio panel = new PanelInicio(miVentana);
        
        miVentana.cambiarPanel(panel);
    }//GEN-LAST:event_btnVolverActionPerformed

    public void insertarUsuario() {
        if (DAOProyecto.getInstance().obtenerIDUsuMax() != -1) {
            DAOProyecto.getInstance().anyadirUsuario(new Usuario((DAOProyecto.getInstance().obtenerIDUsuMax() + 1), tbNombre.getText().toString(), tbApellido1.getText().toString(), tbApellido2.getText().toString()));
        }
        else {
            DAOProyecto.getInstance().anyadirUsuario(new Usuario(tbNombre.getText().toString(), tbApellido1.getText().toString(), tbApellido2.getText().toString()));
        }
        
        cargarTabla();
    }
    
    public void cargarTabla() {
        listaUsuarios = DAOProyecto.getInstance().obtenerUsuarios();

        DefaultTableModel modelo = new DefaultTableModel();

        modelo.addColumn("Id");

        modelo.addColumn("Nombre");

        modelo.addColumn("Apellido1");
        
        modelo.addColumn("Apellido2");

        for (Usuario usuario : listaUsuarios) {

            Object[] registroLeido
                    = {
                        usuario.getId(),
                        usuario.getNombre(),
                        usuario.getApellido1(),
                        usuario.getApellido2()
                    };

            modelo.addRow(registroLeido);

        }

        tablaUsuarios.setModel(modelo);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBorrar;
    private javax.swing.JButton btnLeer;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblApellido1;
    private javax.swing.JLabel lblApellido2;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JTable tablaUsuarios;
    private javax.swing.JTextField tbApellido1;
    private javax.swing.JTextField tbApellido2;
    private javax.swing.JTextField tbNombre;
    // End of variables declaration//GEN-END:variables
}
