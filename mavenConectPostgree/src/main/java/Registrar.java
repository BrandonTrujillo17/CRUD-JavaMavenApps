
import DAO.DAOEstudiante;
import java.awt.TrayIcon;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import pocos.Estudiante;


public class Registrar extends javax.swing.JFrame {

    public Registrar() {
        initComponents();
        verificarAccion();
    }

    boolean esEdicion = false;
    Estudiante editarEstudiante = CRUD.estudianteObtenido;
    private void verificarAccion(){
        if(CRUD.botonPresionado.equalsIgnoreCase("editar")){
            esEdicion = true;
            lbTitulo.setText("Editar Estudiante");
            btnRegistrar_Editar.setText("Editar");
            llenarCampos();
        }
    }
    
    void llenarCampos(){
        txtMatricula.setText(editarEstudiante.getIdEstudiante());
        txtMatricula.setEditable(false);
        txtPrimerNombre.setText(editarEstudiante.getPrimerNombre());
        txtSegundoNombre.setText(editarEstudiante.getSegundoNombre());
        txtPrimerApellido.setText(editarEstudiante.getPrimerApellido());
        txtSegundoApellido.setText(editarEstudiante.getSegundoApellido());
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 153, Short.MAX_VALUE)
                .addComponent(lbTitulo)
                .addGap(123, 123, 123))
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lbMensaje)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btnCancelar)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 391, Short.MAX_VALUE)
                            .addComponent(btnRegistrar_Editar))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel5)
                                .addComponent(jLabel2)
                                .addComponent(jLabel4)
                                .addComponent(jLabel3))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtPrimerNombre)
                                .addComponent(txtSegundoNombre)
                                .addComponent(txtPrimerApellido)
                                .addComponent(txtSegundoApellido, javax.swing.GroupLayout.DEFAULT_SIZE, 395, Short.MAX_VALUE)))))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbTitulo)
                .addGap(35, 35, 35)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbMensaje)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegistrar_Editar)
                    .addComponent(btnCancelar))
                .addGap(23, 23, 23))
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
        
        if(esCorrecto){
            if(!sonMuchosCaracteres){
                lbMensaje.setText("");
                if(!esEdicion){
                    if(!matriculaRepetida){
                        resultado = DAOEstudiante.registrarEstudiante(matricula, primerNombre, segundoNombre, primerApellido, segundoApellido);
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
                    resultado = DAOEstudiante.editarEstudiante(matricula, primerNombre, segundoNombre, primerApellido, segundoApellido, editarEstudiante.getIdEstudiante());
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel lbMensaje;
    private javax.swing.JLabel lbTitulo;
    private javax.swing.JTextField txtMatricula;
    private javax.swing.JTextField txtPrimerApellido;
    private javax.swing.JTextField txtPrimerNombre;
    private javax.swing.JTextField txtSegundoApellido;
    private javax.swing.JTextField txtSegundoNombre;
    // End of variables declaration//GEN-END:variables
}
