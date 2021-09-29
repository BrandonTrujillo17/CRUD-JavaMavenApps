
import DAO.DAOEstudiante;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import pocos.Estudiante;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author brand
 */
public class CRUD extends javax.swing.JFrame {

    public CRUD() {
        initComponents();
        llenarTabla();
    }
    
    public static String botonPresionado = "";
    public static Estudiante estudianteObtenido = new Estudiante();
    
    private void llenarTabla(){
        DefaultTableModel modelo = new DefaultTableModel();
        ArrayList<Object>headEstudiante = new ArrayList<>();
        headEstudiante.add("Matrícula");
        headEstudiante.add("Primer Nombre");
        headEstudiante.add("Segundo Nombre");
        headEstudiante.add("Primer Apellido");
        headEstudiante.add("Segundo Apellido");
        headEstudiante.add("Clave de colegio");
        headEstudiante.add("Nombre de colegio");
        headEstudiante.forEach((columna) -> {
            modelo.addColumn(columna);
        });
        this.tablaEstudiantes.setModel(modelo);
        
        ArrayList<Estudiante> estudiantesObtenidos = DAO.DAOEstudiante.ObtenerEstudiantes();
        Object[] datosEstudiante = new Object[tablaEstudiantes.getColumnCount()];
        for(Estudiante estudiante: estudiantesObtenidos){
            datosEstudiante[0] = estudiante.getIdEstudiante();
            datosEstudiante[1] = estudiante.getPrimerNombre();
            datosEstudiante[2] = estudiante.getSegundoNombre();
            datosEstudiante[3] = estudiante.getPrimerApellido();
            datosEstudiante[4] = estudiante.getSegundoApellido();
            datosEstudiante[5] = estudiante.getClaveColegio();
            datosEstudiante[6] = estudiante.getNombreColegio();
            modelo.addRow(datosEstudiante);
        }
        this.tablaEstudiantes.setModel(modelo);
    }
    
    boolean haySeleccion = false;
    public void obtenerSeleccion(){
        int seleccion = tablaEstudiantes.getSelectedRow();
        if(seleccion >= 0){
            haySeleccion = true;
            estudianteObtenido.setIdEstudiante((String) tablaEstudiantes.getValueAt(seleccion, 0));
            estudianteObtenido.setPrimerNombre((String) tablaEstudiantes.getValueAt(seleccion, 1));
            estudianteObtenido.setSegundoNombre((String) tablaEstudiantes.getValueAt(seleccion, 2));
            estudianteObtenido.setPrimerApellido((String) tablaEstudiantes.getValueAt(seleccion, 3));
            estudianteObtenido.setSegundoApellido((String) tablaEstudiantes.getValueAt(seleccion, 4));
            estudianteObtenido.setClaveColegio((String) tablaEstudiantes.getValueAt(seleccion, 5));
            estudianteObtenido.setNombreColegio((String) tablaEstudiantes.getValueAt(seleccion, 6));
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tablaEstudiantes = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btnRegistrar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();
        btnInfoMedica = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tablaEstudiantes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Matricula", "Primer nombre", "Segundo nombre", "Primer apellido", "Segundo apellido"
            }
        ));
        jScrollPane1.setViewportView(tablaEstudiantes);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel1.setText("Gestión de estudiantes");

        btnRegistrar.setBackground(new java.awt.Color(153, 255, 204));
        btnRegistrar.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        btnEditar.setBackground(new java.awt.Color(255, 204, 0));
        btnEditar.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnEliminar.setBackground(new java.awt.Color(255, 102, 51));
        btnEliminar.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnCerrar.setBackground(new java.awt.Color(102, 204, 255));
        btnCerrar.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnCerrar.setText("Cerrar");
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });

        btnInfoMedica.setBackground(new java.awt.Color(0, 255, 204));
        btnInfoMedica.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        btnInfoMedica.setText("Información medica");
        btnInfoMedica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInfoMedicaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 186, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnCerrar, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnInfoMedica)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnRegistrar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(9, 9, 9)
                                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(139, 139, 139)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegistrar)
                    .addComponent(btnEliminar)
                    .addComponent(btnEditar)
                    .addComponent(btnInfoMedica))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(btnCerrar)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        botonPresionado = "Registrar";
        Registrar ventanaRegistrar = new Registrar();
        ventanaRegistrar.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        botonPresionado = "Editar";
        obtenerSeleccion();
        if(haySeleccion){
            Registrar editarSeleccion = new Registrar();
            editarSeleccion.setVisible(true);
            this.dispose(); 
        }else{
            JOptionPane.showMessageDialog(null, "Para editar un estudiante, primero seleccionelo", "ATENCIÓN", JOptionPane.INFORMATION_MESSAGE);
        }
        
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        Principal principal = new Principal();
        principal.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnCerrarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int confirmacion = JOptionPane.showConfirmDialog(null, "¿Seguro que desea eliminar el estudiante?", "Confirmar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if(confirmacion == JOptionPane.YES_OPTION){
           eliminarEstudiante(); 
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnInfoMedicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInfoMedicaActionPerformed
       this.obtenerSeleccion();
       if(estudianteObtenido.getIdEstudiante().equals("")){
           JOptionPane.showMessageDialog(null, "Debe seleccionar un estudiante");
       }else{
           GUIInfoMedica infoMedica = new GUIInfoMedica();
            infoMedica.setVisible(true);
            this.setVisible(false);
       }
    }//GEN-LAST:event_btnInfoMedicaActionPerformed

    private void eliminarEstudiante(){
        obtenerSeleccion();
        if(haySeleccion){
            int resultado = DAOEstudiante.eliminarEstudiante(estudianteObtenido.getIdEstudiante());
            if(resultado > 0){
                JOptionPane.showMessageDialog(null, "El estudiante fue dado de baja con éxito", "Baja exitosa", JOptionPane.INFORMATION_MESSAGE);
                llenarTabla();
            }else{
                JOptionPane.showMessageDialog(null, "No fue posible completar la baja", "Algo salió mal", JOptionPane.WARNING_MESSAGE);
            } 
        }else{
            JOptionPane.showMessageDialog(null, "Para eliminar un estudiante, primero seleccionelo", "ATENCIÓN", JOptionPane.INFORMATION_MESSAGE);
        }  
    }
    
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
            java.util.logging.Logger.getLogger(CRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CRUD().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnInfoMedica;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaEstudiantes;
    // End of variables declaration//GEN-END:variables
}
