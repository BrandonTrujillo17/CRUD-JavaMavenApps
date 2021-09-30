
import DAO.DAOEstudiante;
import DAO.DAOHistoriaAcademica;
import java.awt.event.ItemEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import pocos.Estudiante;
import pocos.HistoriaAcademica;



/**
 *
 * @author Brandon Trujillo
 */
public class registrarHistorial extends javax.swing.JFrame {

    public registrarHistorial() {
        initComponents();
        llenarCombo();
        verificarAccion();
    }

    String idEstudiante = "";
    String nombreEstudiante = "";
    boolean esEdicion = false;
    HistoriaAcademica historialEditar = gestionDeHistorialAcademico.historialSeleccionado;
    
    private void verificarAccion(){
        if(gestionDeHistorialAcademico.botonPresionado.equalsIgnoreCase("editar")){
            esEdicion = true;
            lbTitulo.setText("Editar Historial");
            btn_registrar.setText("Editar");
            llenarCampos();
        }else{
            lbEstudianteSeleccionado.setVisible(false);
            txt_estudianteSeleccionado.setVisible(false);
        }
    }
    
    private void llenarCampos(){
        cbEstudiantes.setVisible(false);
        lbEstudianteCombo.setVisible(false);
        txt_estudianteSeleccionado.setText(historialEditar.getNombreEstudiante());
        txt_estudianteSeleccionado.setEnabled(false);
        txt_antiguedad.setText(historialEditar.getAntiguedad());
        txt_añoIngreso.setText(historialEditar.getAñoIngreso());
        txt_seccion.setText(historialEditar.getSeccion());
        txtAnterior.setText(historialEditar.getColegio_anterior());
    }
    
    ArrayList<Estudiante> estudiantesObtenidos = new ArrayList();
    void llenarCombo(){
        cbEstudiantes.removeAllItems();
        estudiantesObtenidos = DAOEstudiante.obtenerEstudiantesConHistorial();
        for(int i = 0; i < estudiantesObtenidos.size(); i++){
            cbEstudiantes.addItem(estudiantesObtenidos.get(i).getPrimerNombre());
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbTitulo = new javax.swing.JLabel();
        lbEstudianteCombo = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cbEstudiantes = new javax.swing.JComboBox<>();
        txt_antiguedad = new javax.swing.JTextField();
        txt_añoIngreso = new javax.swing.JTextField();
        txt_seccion = new javax.swing.JTextField();
        btn_cancelar = new javax.swing.JButton();
        btn_registrar = new javax.swing.JButton();
        lbEstudianteSeleccionado = new javax.swing.JLabel();
        txt_estudianteSeleccionado = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtAnterior = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lbTitulo.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        lbTitulo.setText("Registrar historial");

        lbEstudianteCombo.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        lbEstudianteCombo.setText("Estudiante: ");

        jLabel3.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel3.setText("Año de ingreso: ");

        jLabel4.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel4.setText("Antigüedad: ");

        jLabel5.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel5.setText("Colegio anterior: ");

        cbEstudiantes.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbEstudiantes.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbEstudiantesItemStateChanged(evt);
            }
        });

        btn_cancelar.setBackground(new java.awt.Color(255, 204, 102));
        btn_cancelar.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        btn_cancelar.setText("Cancelar");
        btn_cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelarActionPerformed(evt);
            }
        });

        btn_registrar.setBackground(new java.awt.Color(102, 255, 204));
        btn_registrar.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        btn_registrar.setText("Registrar");
        btn_registrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_registrarActionPerformed(evt);
            }
        });

        lbEstudianteSeleccionado.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        lbEstudianteSeleccionado.setText("Estudiante: ");

        jLabel6.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel6.setText("Sección: ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(137, 137, 137)
                        .addComponent(lbTitulo))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(140, 140, 140)
                        .addComponent(btn_cancelar)
                        .addGap(33, 33, 33)
                        .addComponent(btn_registrar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbEstudianteCombo)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(lbEstudianteSeleccionado)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_estudianteSeleccionado, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(cbEstudiantes, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txt_antiguedad)
                                .addComponent(txt_añoIngreso)
                                .addComponent(txt_seccion, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtAnterior, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbTitulo)
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbEstudianteSeleccionado)
                        .addGap(29, 29, 29)
                        .addComponent(lbEstudianteCombo)
                        .addGap(36, 36, 36)
                        .addComponent(jLabel4)
                        .addGap(33, 33, 33)
                        .addComponent(jLabel3)
                        .addGap(35, 35, 35)
                        .addComponent(jLabel6))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txt_estudianteSeleccionado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(cbEstudiantes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(txt_antiguedad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(txt_añoIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(txt_seccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtAnterior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_cancelar)
                    .addComponent(btn_registrar))
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelarActionPerformed
        gestionDeHistorialAcademico gestion = new gestionDeHistorialAcademico();
        gestion.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_cancelarActionPerformed

    private void btn_registrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_registrarActionPerformed
        
        String antiguedad = txt_antiguedad.getText();
        String añoIngreso = txt_añoIngreso.getText();
        String seccion = txt_seccion.getText();
        String colegioAnterior = txtAnterior.getText();
        
        boolean esCorrecto = true;
        if(antiguedad.isEmpty()){
            esCorrecto=false;
        }
        if(añoIngreso.isEmpty()){
            esCorrecto=false;
        }
        if(seccion.isEmpty()){
            esCorrecto = false;
        }
        if(colegioAnterior.isEmpty()){
            colegioAnterior = "*no existe*";
        }
        
        int resultado = 0;
        if(esCorrecto){
            if(!esEdicion){
                resultado = DAOHistoriaAcademica.registrarHistorial(idEstudiante, antiguedad, añoIngreso, seccion, colegioAnterior);
                if(resultado > 0){
                    JOptionPane.showMessageDialog(null, "El historial se registró exitosamente", "Registro exitoso", JOptionPane.INFORMATION_MESSAGE);
                    regresarACrud();
                }else{
                   JOptionPane.showMessageDialog(null, "No fue posible completar el registro", "Algo salió mal", JOptionPane.WARNING_MESSAGE);
                }
            }else{
               
                System.out.println("Id: " + historialEditar.getIdEstudiante());
               resultado = DAOHistoriaAcademica.editarHistorial(antiguedad, añoIngreso, seccion, colegioAnterior, historialEditar.getIdEstudiante());
               if(resultado > 0){
                    JOptionPane.showMessageDialog(null, "El historial se editó exitosamente", "edición exitosa", JOptionPane.INFORMATION_MESSAGE);
                    regresarACrud();
                }else{
                   JOptionPane.showMessageDialog(null, "No fue posible completar la edición", "Algo salió mal", JOptionPane.WARNING_MESSAGE);
                }
            }
        }else{
            JOptionPane.showMessageDialog(null, "Favor de llenar todos los campos", "ATENCIÓN", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btn_registrarActionPerformed

    void regresarACrud(){
        gestionDeHistorialAcademico gestion = new gestionDeHistorialAcademico();
        gestion.setVisible(true);
        this.dispose();
    }
    
    private void cbEstudiantesItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbEstudiantesItemStateChanged
        if(evt.getStateChange() <= ItemEvent.SELECTED){
            nombreEstudiante = this.cbEstudiantes.getSelectedItem().toString();
        }
        idEstudiante = DAOEstudiante.ObtenerEstudianteSeleccionado(nombreEstudiante);
    }//GEN-LAST:event_cbEstudiantesItemStateChanged

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
            java.util.logging.Logger.getLogger(registrarHistorial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(registrarHistorial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(registrarHistorial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(registrarHistorial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new registrarHistorial().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cancelar;
    private javax.swing.JButton btn_registrar;
    private javax.swing.JComboBox<String> cbEstudiantes;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel lbEstudianteCombo;
    private javax.swing.JLabel lbEstudianteSeleccionado;
    private javax.swing.JLabel lbTitulo;
    private javax.swing.JTextField txtAnterior;
    private javax.swing.JTextField txt_antiguedad;
    private javax.swing.JTextField txt_añoIngreso;
    private javax.swing.JTextField txt_estudianteSeleccionado;
    private javax.swing.JTextField txt_seccion;
    // End of variables declaration//GEN-END:variables
}
