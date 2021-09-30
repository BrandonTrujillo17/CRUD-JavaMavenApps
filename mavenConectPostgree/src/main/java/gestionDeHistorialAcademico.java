
import DAO.DAOHistoriaAcademica;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import pocos.HistoriaAcademica;


/**
 *
 * @author Brandon Trujillo
 */
public class gestionDeHistorialAcademico extends javax.swing.JFrame {

    public gestionDeHistorialAcademico() {
        initComponents();
        llenarTabla();
    }
    
    public static String botonPresionado = "";
    public static HistoriaAcademica historialSeleccionado = new HistoriaAcademica();
    
    void llenarTabla(){
        DefaultTableModel modelo = new DefaultTableModel();
        ArrayList<Object> headHistorial = new ArrayList<>();
        headHistorial.add("Matricula");
        headHistorial.add("Estudiante");
        headHistorial.add("antiguedad");
        headHistorial.add("Año");
        headHistorial.add("sección");
        headHistorial.add("Colegio anterior");
        headHistorial.forEach((columna) ->{
            modelo.addColumn(columna);
        });
        this.tableHistorial.setModel(modelo);
        
        ArrayList<HistoriaAcademica> historialObtenido = DAOHistoriaAcademica.obtenerHistorial();
        System.out.println("Object: " + historialObtenido.toString());
        Object[] datosHistorial = new Object[tableHistorial.getColumnCount()];
        for(HistoriaAcademica historial: historialObtenido){
            datosHistorial[0] = historial.getIdEstudiante();
            datosHistorial[1] = historial.getNombreEstudiante();
            datosHistorial[2] = historial.getAntiguedad();
            datosHistorial[3] = historial.getAñoIngreso();
            datosHistorial[4] = historial.getSeccion();
            datosHistorial[5] = historial.getColegio_anterior();
            modelo.addRow(datosHistorial);
        }
        this.tableHistorial.setModel(modelo);
    }
    
    boolean haySeleccion = false;
    public void obtenerSeleccion(){
        int seleccion = tableHistorial.getSelectedRow();
        if(seleccion >= 0){
            haySeleccion = true;
            historialSeleccionado.setIdEstudiante((String) tableHistorial.getValueAt(seleccion, 0));
            historialSeleccionado.setNombreEstudiante((String) tableHistorial.getValueAt(seleccion, 1));
            historialSeleccionado.setAntiguedad((String) tableHistorial.getValueAt(seleccion, 2));
            historialSeleccionado.setAñoIngreso((String) tableHistorial.getValueAt(seleccion, 3));
            historialSeleccionado.setSeccion((String) tableHistorial.getValueAt(seleccion, 4));
            historialSeleccionado.setColegio_anterior((String) tableHistorial.getValueAt(seleccion, 5));
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableHistorial = new javax.swing.JTable();
        btnRegistrarHistoria = new javax.swing.JButton();
        btn_editar = new javax.swing.JButton();
        btn_cerrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setText("Historia Académica");

        tableHistorial.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tableHistorial);

        btnRegistrarHistoria.setBackground(new java.awt.Color(153, 255, 204));
        btnRegistrarHistoria.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        btnRegistrarHistoria.setText("Registrar");
        btnRegistrarHistoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarHistoriaActionPerformed(evt);
            }
        });

        btn_editar.setBackground(new java.awt.Color(255, 204, 102));
        btn_editar.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        btn_editar.setText("Editar");
        btn_editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editarActionPerformed(evt);
            }
        });

        btn_cerrar.setBackground(new java.awt.Color(255, 255, 102));
        btn_cerrar.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        btn_cerrar.setText("Cerrar");
        btn_cerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cerrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 569, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnRegistrarHistoria, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btn_editar, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(182, 182, 182))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btn_cerrar)
                                .addContainerGap())))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_editar)
                    .addComponent(btnRegistrarHistoria))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addComponent(btn_cerrar)
                .addGap(24, 24, 24))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarHistoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarHistoriaActionPerformed
        botonPresionado = "Registrar";
        registrarHistorial registrar = new registrarHistorial();
        registrar.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnRegistrarHistoriaActionPerformed

    private void btn_cerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cerrarActionPerformed
        Principal principal = new Principal();
        principal.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_cerrarActionPerformed

    private void btn_editarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editarActionPerformed
        botonPresionado = "Editar";
        obtenerSeleccion();
        if(haySeleccion){
           registrarHistorial editar = new registrarHistorial();
           editar.setVisible(true);
           this.dispose(); 
        }else{
            JOptionPane.showMessageDialog(null, "Para editar un registro, primero seleccionelo", "ATENCIÓN", JOptionPane.INFORMATION_MESSAGE);
        }
        
    }//GEN-LAST:event_btn_editarActionPerformed

    public static void main(String args[]) {
 
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new gestionDeHistorialAcademico().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegistrarHistoria;
    private javax.swing.JButton btn_cerrar;
    private javax.swing.JButton btn_editar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableHistorial;
    // End of variables declaration//GEN-END:variables
}
