
import DAO.DAOTutor;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import pocos.Tutor;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author Eduardo DA
 */
public class GestionTutor extends javax.swing.JFrame {

     private DefaultTableModel model;
     ArrayList<Tutor> tutores = new ArrayList<Tutor>();
    
    public GestionTutor() {
        initComponents();
        cargarTutores();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        BtRegistrar = new javax.swing.JButton();
        BtEditar = new javax.swing.JButton();
        BtEliminar = new javax.swing.JButton();
        BtCerrar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TbTutores = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        jLabel1.setText("Gestion de Tutor");

        BtRegistrar.setText("Registrar");
        BtRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtRegistrarActionPerformed(evt);
            }
        });

        BtEditar.setText("Editar");
        BtEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtEditarActionPerformed(evt);
            }
        });

        BtEliminar.setText("Eliminar");
        BtEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtEliminarActionPerformed(evt);
            }
        });

        BtCerrar.setText("Cerrar");
        BtCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtCerrarActionPerformed(evt);
            }
        });

        TbTutores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(TbTutores);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 19, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(BtRegistrar)
                        .addGap(18, 18, 18)
                        .addComponent(BtEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(BtEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(BtCerrar, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 633, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel1)
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtEliminar)
                    .addComponent(BtEditar)
                    .addComponent(BtRegistrar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BtCerrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtRegistrarActionPerformed
        RegistrarYModificarTutor ventanaRegistrar = new RegistrarYModificarTutor(true);
        ventanaRegistrar.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BtRegistrarActionPerformed

    private void BtEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtEditarActionPerformed
        int seleccion = TbTutores.getSelectedRow();
        if(seleccion >= 0){
            Tutor tutorEditar = tutores.get(seleccion);
            RegistrarYModificarTutor ventanaRegistrar = new RegistrarYModificarTutor(false,tutorEditar);
            ventanaRegistrar.setVisible(true);
            this.dispose();      
        }else{
            mensaje("Para modificar debe seleccionar una fila");
        }
    }//GEN-LAST:event_BtEditarActionPerformed

    private void BtEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtEliminarActionPerformed
        int seleccion = TbTutores.getSelectedRow();
        if(seleccion >= 0){
            Tutor tutorEliminar = tutores.get(seleccion);
            
            int confirmacion = JOptionPane.showConfirmDialog(null, "¿Seguro que desea eliminar el tutor?", "Confirmar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if(confirmacion == JOptionPane.YES_OPTION){ 
                int resultado;
                resultado = DAOTutor.deleteTutor(tutorEliminar.getIdTutor());
                if(resultado == 1){
                    cargarTutores();
                     mensaje("Se elimino exitosamente");
                }else{
                    mensaje("No se puedo hacer la eliminación");
                }
            }   
        }else{
            mensaje("Para eliminar debe seleccionar una fila");
        }
    }//GEN-LAST:event_BtEliminarActionPerformed

    private void BtCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtCerrarActionPerformed
        // TODO add your handling code here:
        
        
        Principal ventanaPrincipal = new Principal();
        ventanaPrincipal.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BtCerrarActionPerformed

    /*
    * Muestra a todos los tutores del sistema
    */
    private void cargarTutores(){
        
        tutores = DAOTutor.getTutors();
        
        String[] columnNames = {"Nombre", "Apellido Materno", "Apellido Paterno", "Direccion", "Numero Fijo", "Numero Celular"};
        model = new DefaultTableModel(null, columnNames);
        TbTutores = new JTable(model);
        jScrollPane1.setViewportView(TbTutores);
         
        for(Tutor tutor:tutores){
            
            model.addRow(new Object[]{tutor.getNombre(), tutor.getApellidoPaterno(), tutor.getApellidoMaterno(),
                                      tutor.getDirección(), tutor.getNumeroFijo(), tutor.getNumeroCelular()});
        }
    }
    /*
    * Mensajes de advertencia, informativos, etc.
    */
    private void mensaje(String mensaje){
        
        JOptionPane.showMessageDialog(null, mensaje);
    }
    
    public static void main(String args[]) {
 
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GestionTutor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtCerrar;
    private javax.swing.JButton BtEditar;
    private javax.swing.JButton BtEliminar;
    private javax.swing.JButton BtRegistrar;
    private javax.swing.JTable TbTutores;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
