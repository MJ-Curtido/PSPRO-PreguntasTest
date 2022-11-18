/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package preguntasTest.vista;

/**
 *
 * @author Dam
 */
public class PanelInicio extends javax.swing.JPanel {

    private final VentanaPreguntasTest miVentana;

    /**
     * Creates new form panelInicio
     */
    public PanelInicio(VentanaPreguntasTest miVentana) {
        initComponents();
        this.miVentana = miVentana;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitulo = new javax.swing.JLabel();
        btnJugar = new javax.swing.JButton();

        setMaximumSize(new java.awt.Dimension(400, 400));
        setMinimumSize(new java.awt.Dimension(400, 400));
        setName(""); // NOI18N
        setPreferredSize(new java.awt.Dimension(400, 400));

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblTitulo.setText("MOVIDAS TOPE DE TOCHAS QUE NO ENTENDERÉIS");
        lblTitulo.setName("lblTitulo"); // NOI18N

        btnJugar.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        btnJugar.setText("Jugar");
        btnJugar.setName("btnJugar"); // NOI18N
        btnJugar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnJugarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addComponent(lblTitulo))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(206, 206, 206)
                        .addComponent(btnJugar)))
                .addGap(66, 66, 66))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addComponent(btnJugar)
                .addContainerGap(116, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnJugarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnJugarActionPerformed
        PanelPreguntas panel =new PanelPreguntas(miVentana);
        
        miVentana.cambiarPanel(panel);
    }//GEN-LAST:event_btnJugarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnJugar;
    private javax.swing.JLabel lblTitulo;
    // End of variables declaration//GEN-END:variables
}
