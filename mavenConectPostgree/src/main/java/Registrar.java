
import DAO.DAOColegio;
import DAO.DAOEstudiante;
import java.awt.TrayIcon;
import java.awt.event.ItemEvent;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import pocos.Colegio;
import pocos.Estudiante;


public class Registrar extends javax.swing.JFrame {

    public Registrar() {
        initComponents();
        llenarCombo();
        verificarAccion();
    }
    
    String claveColegio = "";
    String nombreColegio = "";
    boolean esEdicion = false;
    Estudiante editarEstudiante = CRUD.estudianteObtenido;
    
    /**
     * método que verifica si se desea editar o registrar un estudiante, esto porque la misma ventana se usa para ambos fines
     */
    private void verificarAccion(){
        if(CRUD.botonPresionado.equalsIgnoreCase("editar")){
            esEdicion = true;
            lbTitulo.setText("Editar Estudiante");
            btnRegistrar_Editar.setText("Editar");
            llenarCampos();
            seleccionarOpcionDeComboParaEditar();
        }
    }
    
    /**
     * este método llena los campos de edición en caso de que la acción a realizar sea editar
     */
    void llenarCampos(){
        txtMatricula.setText(editarEstudiante.getIdEstudiante());
        txtMatricula.setEditable(false);
        txtPrimerNombre.setText(editarEstudiante.getPrimerNombre());
        txtSegundoNombre.setText(editarEstudiante.getSegundoNombre());
        txtPrimerApellido.setText(editarEstudiante.getPrimerApellido());
        txtSegundoApellido.setText(editarEstudiante.getSegundoApellido());
    }
    
    /**
     * este método llena el combo box de colegios (tanto para editar como para registrar)
     */
    void llenarCombo(){
        cbColegios.removeAllItems();
        ArrayList<Colegio> colegios = DAOColegio.ObtenerColegios();
        for (int i = 0; i < colegios.size(); i++){
            cbColegios.addItem(colegios.get(i).getNombreColegio());
        }
    }
    
    /**
     * método que selecciona por defecto la opción del combo box que está guardada (para editar)
     */
    void seleccionarOpcionDeComboParaEditar(){
        int sizeCombo = cbColegios.getItemCount();
        int contador = 0;
        while (contador <= sizeCombo){
            if (editarEstudiante.getNombreColegio().equals(cbColegios.getItemAt(contador))){
                cbColegios.setSelectedIndex(contador);
                break;
            }
            contador++;
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbTitulo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtMatricula = new javax.swing.JTextField();
        txtPrimerNombre = new javax.swing.JTextField();
        txtSegundoNombre = new javax.swing.JTextField();
        txtPrimerApellido = new javax.swing.JTextField();
        txtSegundoApellido = new javax.swing.JTextField();
        btnRegistrar_Editar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        lbMensaje = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btn_nuevoColegio = new javax.swing.JButton();
        cbColegios = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 51, 0));

        lbTitulo.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        lbTitulo.setText("Registrar Estudiante");

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setText("Matrícula: ");

        jLabel2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel2.setText("Segundo Nombre: ");

        jLabel3.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel3.setText("Primer Apellido: ");

        jLabel4.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel4.setText("Primer Nombre: ");

        jLabel5.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel5.setText("Segundo Apellido: ");

        btnRegistrar_Editar.setBackground(new java.awt.Color(153, 255, 204));
        btnRegistrar_Editar.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnRegistrar_Editar.setText("Registrar");
        btnRegistrar_Editar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrar_EditarActionPerformed(evt);
            }
        });

        btnCancelar.setBackground(new java.awt.Color(255, 204, 0));
        btnCancelar.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        lbMensaje.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lbMensaje.setForeground(new java.awt.Color(255, 0, 0));

        jLabel7.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel7.setText("Colegio: ");

        btn_nuevoColegio.setBackground(new java.awt.Color(153, 255, 153));
        btn_nuevoColegio.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        btn_nuevoColegio.setText("Nuevo colegio");
        btn_nuevoColegio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nuevoColegioActionPerformed(evt);
            }
        });

        cbColegios.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbColegios.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbColegiosItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel7)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtPrimerApellido, javax.swing.GroupLayout.DEFAULT_SIZE, 473, Short.MAX_VALUE)
                    .addComponent(txtSegundoNombre)
                    .addComponent(txtSegundoApellido)
                    .addComponent(txtPrimerNombre)
                    .addComponent(txtMatricula, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnRegistrar_Editar, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(cbColegios, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_nuevoColegio))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lbMensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(33, 33, 33))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lbTitulo)
                .addGap(160, 160, 160))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lbTitulo)
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtPrimerNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtSegundoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtPrimerApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtSegundoApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbMensaje, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cbColegios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_nuevoColegio))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegistrar_Editar)
                    .addComponent(btnCancelar))
                .addGap(64, 64, 64))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        CRUD crud = new CRUD();
        crud.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    
    
    private void btnRegistrar_EditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrar_EditarActionPerformed
        
        txtMatricula.setBorder(BorderFactory.createLineBorder(java.awt.Color.GRAY));
        txtPrimerNombre.setBorder(BorderFactory.createLineBorder(java.awt.Color.GRAY));
        txtSegundoNombre.setBorder(BorderFactory.createLineBorder(java.awt.Color.GRAY));
        txtPrimerApellido.setBorder(BorderFactory.createLineBorder(java.awt.Color.GRAY));
        txtSegundoApellido.setBorder(BorderFactory.createLineBorder(java.awt.Color.GRAY));
        
        String matricula = txtMatricula.getText();
        String primerNombre = txtPrimerNombre.getText();
        String segundoNombre = txtSegundoNombre.getText();
        String primerApellido = txtPrimerApellido.getText();
        String segundoApellido = txtSegundoApellido.getText();
        
        boolean esCorrecto = true;
        boolean sonMuchosCaracteres = false;
        
        if(matricula.isEmpty()){
            esCorrecto = false;
            txtMatricula.setBorder(BorderFactory.createLineBorder(java.awt.Color.red));
        }else{
            if(matricula.length() > 10){
                sonMuchosCaracteres = true;
                txtMatricula.setBorder(BorderFactory.createLineBorder(java.awt.Color.red));
            }
        }
        if(primerNombre.isEmpty()){
            esCorrecto = false;
            txtPrimerNombre.setBorder(BorderFactory.createLineBorder(java.awt.Color.red));
        }else{
            if(primerNombre.length() >50){
               sonMuchosCaracteres = true; 
               txtPrimerNombre.setBorder(BorderFactory.createLineBorder(java.awt.Color.red));
            }
        }
        if(segundoNombre.isEmpty()){
            segundoNombre = "*No existe*";
        }else{
            if(segundoNombre.length() > 50){
                sonMuchosCaracteres = true;
                txtSegundoNombre.setBorder(BorderFactory.createLineBorder(java.awt.Color.red));
            }   
        }
        if(primerApellido.isEmpty()){
            esCorrecto = false;
            txtPrimerApellido.setBorder(BorderFactory.createLineBorder(java.awt.Color.red));
        }else{
            if(primerApellido.length() > 50){
                sonMuchosCaracteres = true;
                txtPrimerApellido.setBorder(BorderFactory.createLineBorder(java.awt.Color.red));
            }
        }
        if(segundoApellido.isEmpty()){
            esCorrecto = false;
            txtSegundoApellido.setBorder(BorderFactory.createLineBorder(java.awt.Color.red));
        }else{
            if(segundoApellido.length() > 50){
                sonMuchosCaracteres = true;
                txtSegundoApellido.setBorder(BorderFactory.createLineBorder(java.awt.Color.red));
            }
        }
       
        int resultado;
        boolean matriculaRepetida = DAOEstudiante.verificarMatriculaRepetida(matricula);
        
        System.out.println("Clave: " + claveColegio);
        if(esCorrecto){
            if(!sonMuchosCaracteres){
                lbMensaje.setText("");
                if(!esEdicion){
                    if(!matriculaRepetida){
                        resultado = DAOEstudiante.registrarEstudiante(matricula, primerNombre, segundoNombre, primerApellido, segundoApellido, claveColegio);
                        if(resultado > 0){
                            JOptionPane.showMessageDialog(null, "El Estudiante se registró exitosamente", "Registro exitoso", JOptionPane.INFORMATION_MESSAGE);
                            regresarCrud();
                        }else{
                            JOptionPane.showMessageDialog(null, "No fue posible completar el registro", "Algo salió mal", JOptionPane.WARNING_MESSAGE);
                        }
                    }else{
                        JOptionPane.showMessageDialog(null, "La matrícula que usted proporcionó ya se encuentra registrada", "ATENCIÓN", JOptionPane.WARNING_MESSAGE);
                    }
                }else{
                    resultado = DAOEstudiante.editarEstudiante(matricula, primerNombre, segundoNombre, primerApellido, segundoApellido, claveColegio, editarEstudiante.getIdEstudiante());
                    if(resultado > 0){
                        JOptionPane.showMessageDialog(null, "El estudiante fue editado exitosamente", "Edición exitosa", JOptionPane.INFORMATION_MESSAGE);
                        regresarCrud();
                    }else{
                        JOptionPane.showMessageDialog(null, "No fue posible hacer la edición", "Algo salió mal", JOptionPane.WARNING_MESSAGE);
                    }
                }
            }else{
                JOptionPane.showMessageDialog(null, "Un campo excede los caracteres permitidos, reviselo", "ATENCIÓN", JOptionPane.WARNING_MESSAGE);
            }
        }else{
            lbMensaje.setText("* Favor de llenar todos los campos");
        }
    }//GEN-LAST:event_btnRegistrar_EditarActionPerformed

    private void btn_nuevoColegioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nuevoColegioActionPerformed
        registrarColegio registrar = new registrarColegio();
        registrar.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_nuevoColegioActionPerformed

    private void cbColegiosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbColegiosItemStateChanged
       
        if(evt.getStateChange() == ItemEvent.SELECTED){
            nombreColegio = this.cbColegios.getSelectedItem().toString();
        }
        claveColegio = DAOColegio.ObtenerColegioSeleccionado(nombreColegio);
    }//GEN-LAST:event_cbColegiosItemStateChanged

    public void regresarCrud(){
        CRUD crud = new CRUD();
        crud.setVisible(true);
        this.dispose();
    }
    
    
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Registrar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnRegistrar_Editar;
    private javax.swing.JButton btn_nuevoColegio;
    private javax.swing.JComboBox<String> cbColegios;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel lbMensaje;
    private javax.swing.JLabel lbTitulo;
    private javax.swing.JTextField txtMatricula;
    private javax.swing.JTextField txtPrimerApellido;
    private javax.swing.JTextField txtPrimerNombre;
    private javax.swing.JTextField txtSegundoApellido;
    private javax.swing.JTextField txtSegundoNombre;
    // End of variables declaration//GEN-END:variables
}
