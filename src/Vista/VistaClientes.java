/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Vista;
import Controlador.EmpleadoControlador;
import Modelo.Empleado;
import java.util.List;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Maryi Lazo
 */
public class VistaClientes extends javax.swing.JPanel {
private final EmpleadoControlador empleadoControlador;
private Integer Id_EmpleadoSeleccionada = null;
    /**
     * Creates new form VistaEmpleados
     */
    public VistaClientes() {
        initComponents();
        this.empleadoControlador = new EmpleadoControlador();
cargarDatosTabla();
    }

    private void cargarDatosTabla(){
        List<Empleado> empleados = empleadoControlador.obtenerTodosEmpleados();
        if(empleados != null){
            DefaultTableModel model = (DefaultTableModel) TablaEmpleados.getModel();
            model.setRowCount(0);
            
            for(Empleado emp : empleados){
                Object[] row = {
                    emp.getId_Empleado(),
                    emp.getCedula(),
                    emp.getNombre1(),
                    emp.getNombre2(),
                    emp.getApellido1(),
                    emp.getApellido2(),
                    emp.getDireccion(),
                    emp.getEmail()
                };
                model.addRow(row);
            }
        }
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
        jLabel2 = new javax.swing.JLabel();
        TextBuscar = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaEmpleados = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        TextNombre1 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        TextApellido1 = new javax.swing.JTextField();
        TextApellido2 = new javax.swing.JTextField();
        TextEmail = new javax.swing.JTextField();
        TextCedula = new javax.swing.JTextField();
        TextDireccion = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        TextNombre2 = new javax.swing.JTextField();

        jLabel1.setText("Cedula");

        jLabel2.setText("Apellido2");

        TextBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textBuscarKeyTyped(evt);
            }
        });

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accionBotonGuardar(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
                accionBotonEliminar(evt);
            }
        });

        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accionBotonActualizar(evt);
            }
        });

        TablaEmpleados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Id_Empleado", "Cedula", "Nombre1", "Nombre2", "Apellido1", "Apellido2", "Direccion", "Email"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TablaEmpleados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaEmpleadoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TablaEmpleados);

        jLabel3.setText("Nombre1");

        jLabel4.setText("Nombre2");

        jLabel5.setText("Apellido1");

        jLabel6.setText("Direccion");

        jLabel7.setText("Email");

        jLabel8.setText("Buscar");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel9.setText("Registro de Clientes");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel6)
                                    .addGap(18, 18, 18)
                                    .addComponent(TextDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(TextCedula, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(18, 18, 18)
                                        .addComponent(TextNombre1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(18, 18, 18)
                                        .addComponent(TextNombre2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addGap(18, 18, 18)
                                        .addComponent(TextApellido1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(18, 18, 18)
                                        .addComponent(TextApellido2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(TextEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel8))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(TextBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(77, 77, 77)
                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 756, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TextNombre1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TextNombre2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TextApellido1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TextApellido2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TextEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TextCedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TextDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TextBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardar)
                    .addComponent(btnEliminar)
                    .addComponent(btnActualizar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void accionBotonGuardar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_accionBotonGuardar
        // TODO add your handling code here:
        String Cedula = TextCedula.getText();
        String Nombre1 = TextNombre1.getText();
        String Nombre2 = TextNombre2.getText();
        String Apellido1 = TextApellido1.getText();
        String Apellido2 = TextApellido2.getText();
        String Direccion = TextDireccion.getText();
        String Email = TextEmail.getText();
        
        if(!Cedula.isEmpty()&& !Nombre1.isEmpty()&& !Nombre2.isEmpty()&& !Apellido1.isEmpty()&& !Apellido2.isEmpty()&& !Direccion.isEmpty()&& !Email.isEmpty()){
            empleadoControlador.crearEmpleado(Cedula, Nombre1, Nombre2, Apellido1, Apellido2, Direccion, Email);
            cargarDatosTabla();
            TextCedula.setText("");
            TextNombre1.setText("");
            TextNombre2.setText("");
            TextApellido1.setText("");
            TextApellido2.setText("");
            TextDireccion.setText("");
            TextEmail.setText("");
        }else{
            javax.swing.JOptionPane.showMessageDialog(this, "Por favor, llene todos loscampos.","Error", javax.swing.JOptionPane.ERROR_MESSAGE);
            
        }
    }//GEN-LAST:event_accionBotonGuardar

    private void accionBotonEliminar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_accionBotonEliminar
        // TODO add your handling code here:
        int filaSeleccionada = TablaEmpleados.getSelectedRow();
        if (filaSeleccionada != -1){
            int Id_Empleado = (int) TablaEmpleados.getValueAt(filaSeleccionada, 0);
            empleadoControlador.eliminarEmpleado(Id_Empleado);
            cargarDatosTabla();
        }else{
            javax.swing.JOptionPane.showMessageDialog(this, "Selecciona una filapara eliminar.", "Error", javax.swing.JOptionPane.ERROR_MESSAGE);
            
        }
    }//GEN-LAST:event_accionBotonEliminar

    private void tablaEmpleadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaEmpleadoMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount()==2){
            int filaSeleccionada = TablaEmpleados.getSelectedRow();
            
            if (filaSeleccionada !=-1){
                Id_EmpleadoSeleccionada = (int) TablaEmpleados.getValueAt(filaSeleccionada, 0);
                String Cedula = (String) TablaEmpleados.getValueAt(filaSeleccionada, 1);
                String Nombre1 = (String) TablaEmpleados.getValueAt(filaSeleccionada, 2);
                String Nombre2 = (String) TablaEmpleados.getValueAt(filaSeleccionada, 3);
                String Apellido1 = (String) TablaEmpleados.getValueAt(filaSeleccionada, 4);
                String Apellido2 = (String) TablaEmpleados.getValueAt(filaSeleccionada, 5);
                String Direccion = (String) TablaEmpleados.getValueAt(filaSeleccionada, 6);
                String Email = (String) TablaEmpleados.getValueAt(filaSeleccionada, 7);
                
                TextCedula.setText(Cedula);
                TextNombre1.setText(Nombre1);
                TextNombre2.setText(Nombre2);
                TextApellido1.setText(Apellido1);
                TextApellido2.setText(Apellido2);
                TextDireccion.setText(Direccion);
                TextEmail.setText(Email);
                
                btnEliminar.setEnabled(false);
                btnGuardar.setEnabled(false);
            }
        }
    }//GEN-LAST:event_tablaEmpleadoMouseClicked

    private void accionBotonActualizar(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_accionBotonActualizar
        // TODO add your handling code here:
        String Cedula = TextCedula.getText();
        String Nombre1 = TextNombre1.getText();
        String Nombre2 = TextNombre2.getText();
        String Apellido1 = TextApellido1.getText();
        String Apellido2 = TextApellido2.getText();
        String Direccion = TextDireccion.getText();
        String Email = TextEmail.getText();
        
        if (Id_EmpleadoSeleccionada !=null && !Cedula.isEmpty()&& !Nombre1.isEmpty()&& !Nombre2.isEmpty()&& !Apellido1.isEmpty()&& !Apellido2.isEmpty()&& !Direccion.isEmpty()&& Email.isEmpty()){
            
            empleadoControlador.actualizarEmpleado(Id_EmpleadoSeleccionada, Cedula, Nombre1, Nombre2, Apellido1, Apellido2, Direccion, Email);
            cargarDatosTabla();
            
            TextCedula.setText("");
            TextNombre1.setText("");
            TextNombre2.setText("");
            TextApellido1.setText("");
            TextApellido2.setText("");
            TextDireccion.setText("");
            TextEmail.setText("");
            
            btnEliminar.setEnabled(true);
            btnGuardar.setEnabled(true);
    }else{
            javax.swing.JOptionPane.showMessageDialog(this, "por favor, llene todos los campos.","Error", javax.swing.JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_accionBotonActualizar

    private void textBuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textBuscarKeyTyped
        // TODO add your handling code here:
        
        String textBusqueda = TextBuscar.getText().trim().toLowerCase();
        List <Empleado> empleados = empleadoControlador.obtenerTodosEmpleados();
        
        DefaultTableModel modelo = (DefaultTableModel) TablaEmpleados.getModel();
        modelo.setRowCount(0);
        
        if (empleados != null){
            for (Empleado emp : empleados){
                if (textBusqueda.isEmpty()||
                        emp.getCedula().toLowerCase().contains(textBusqueda)||
                        emp.getNombre1().toLowerCase().contains(textBusqueda)||
                        emp.getNombre2().toLowerCase().contains(textBusqueda)||
                        emp.getApellido1().toLowerCase().contains(textBusqueda)||
                        emp.getApellido2().toLowerCase().contains(textBusqueda)||
                        emp.getDireccion().toLowerCase().contains(textBusqueda)||
                        emp.getEmail().toLowerCase().contains(textBusqueda)){
                    Object[] fila = {
                        emp.getId_Empleado(),
                        emp.getCedula(),
                        emp.getNombre1(),
                        emp.getNombre2(),
                        emp.getApellido1(),
                        emp.getApellido2(),
                        emp.getDireccion(),
                        emp.getEmail()
                    };
                    modelo.addRow(fila);
                }
            }
        }
    }//GEN-LAST:event_textBuscarKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TablaEmpleados;
    private javax.swing.JTextField TextApellido1;
    private javax.swing.JTextField TextApellido2;
    private javax.swing.JTextField TextBuscar;
    private javax.swing.JTextField TextCedula;
    private javax.swing.JTextField TextDireccion;
    private javax.swing.JTextField TextEmail;
    private javax.swing.JTextField TextNombre1;
    private javax.swing.JTextField TextNombre2;
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
