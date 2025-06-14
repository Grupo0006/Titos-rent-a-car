/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/AWTForms/Dialog.java to edit this template
 */
package Vista.Mantenimiento;

/**
 *
 * @author Estudiantes
 */
public class mantenimientoFormulario extends java.awt.Dialog {

    private vistaMantenimiento vista;
    /**
     * Creates new form mantenimientoFormulario
     */
    public mantenimientoFormulario(java.awt.Frame parent, boolean modal, vistaMantenimiento vista) {
        super(parent, modal);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelInferiorFormulario = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jTextFieldId = new javax.swing.JTextField();
        jTextFieldDescripcion = new javax.swing.JTextField();
        jTextFieldJustificacion = new javax.swing.JTextField();
        jTextFieldObservaciones = new javax.swing.JTextField();
        jButtonGuardar = new javax.swing.JButton();
        jButtonActualizar = new javax.swing.JButton();
        jButtonEliminar = new javax.swing.JButton();
        jButtonLimpiar = new javax.swing.JButton();
        jTextFieldObservaciones1 = new javax.swing.JTextField();
        jTextFieldObservaciones2 = new javax.swing.JTextField();
        timePicker1 = new com.github.lgooddatepicker.components.TimePicker();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        timePicker2 = new com.github.lgooddatepicker.components.TimePicker();
        jComboBoxCoche = new javax.swing.JComboBox<>();
        jComboBoxEmpleado = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        jPanelInferiorFormulario.setBackground(new java.awt.Color(255, 57, 54));
        jPanelInferiorFormulario.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelInferiorFormulario.setPreferredSize(new java.awt.Dimension(1440, 1024));

        jPanel3.setBackground(new java.awt.Color(255, 118, 115));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 30)); // NOI18N
        jLabel3.setText("ID");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 30)); // NOI18N
        jLabel4.setText("Descripción");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 30)); // NOI18N
        jLabel5.setText("Justificación");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 30)); // NOI18N
        jLabel6.setText("Fecha Incio");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 30)); // NOI18N
        jLabel7.setText("Fecha Fin");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 30)); // NOI18N
        jLabel8.setText("Costo");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 30)); // NOI18N
        jLabel9.setText("Observaciones");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 30)); // NOI18N
        jLabel10.setText("Recomendaciones");

        jTextFieldId.setBackground(new java.awt.Color(244, 233, 205));
        jTextFieldId.setFont(new java.awt.Font("Segoe UI", 0, 26)); // NOI18N
        jTextFieldId.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jTextFieldId.setPreferredSize(new java.awt.Dimension(632, 51));

        jTextFieldDescripcion.setBackground(new java.awt.Color(244, 233, 205));
        jTextFieldDescripcion.setFont(new java.awt.Font("Segoe UI", 0, 26)); // NOI18N
        jTextFieldDescripcion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jTextFieldDescripcion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTextFieldDescripcion.setPreferredSize(new java.awt.Dimension(632, 51));

        jTextFieldJustificacion.setBackground(new java.awt.Color(244, 233, 205));
        jTextFieldJustificacion.setFont(new java.awt.Font("Segoe UI", 0, 26)); // NOI18N
        jTextFieldJustificacion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jTextFieldJustificacion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTextFieldJustificacion.setPreferredSize(new java.awt.Dimension(632, 51));
        jTextFieldJustificacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldJustificacionActionPerformed(evt);
            }
        });

        jTextFieldObservaciones.setBackground(new java.awt.Color(244, 233, 205));
        jTextFieldObservaciones.setFont(new java.awt.Font("Segoe UI", 0, 26)); // NOI18N
        jTextFieldObservaciones.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jTextFieldObservaciones.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTextFieldObservaciones.setPreferredSize(new java.awt.Dimension(632, 51));

        jButtonGuardar.setBackground(new java.awt.Color(244, 233, 205));
        jButtonGuardar.setFont(new java.awt.Font("Segoe UI", 0, 37)); // NOI18N
        jButtonGuardar.setText("Guardar");
        jButtonGuardar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jButtonGuardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonGuardar.setPreferredSize(new java.awt.Dimension(240, 69));
        jButtonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGuardarActionPerformed(evt);
            }
        });

        jButtonActualizar.setBackground(new java.awt.Color(244, 233, 205));
        jButtonActualizar.setFont(new java.awt.Font("Segoe UI", 0, 37)); // NOI18N
        jButtonActualizar.setText("Actualizar");
        jButtonActualizar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jButtonActualizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonActualizar.setPreferredSize(new java.awt.Dimension(240, 69));
        jButtonActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonActualizarActionPerformed(evt);
            }
        });

        jButtonEliminar.setBackground(new java.awt.Color(244, 233, 205));
        jButtonEliminar.setFont(new java.awt.Font("Segoe UI", 0, 37)); // NOI18N
        jButtonEliminar.setText("Eliminar");
        jButtonEliminar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jButtonEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonEliminar.setPreferredSize(new java.awt.Dimension(240, 69));
        jButtonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEliminarActionPerformed(evt);
            }
        });

        jButtonLimpiar.setBackground(new java.awt.Color(244, 233, 205));
        jButtonLimpiar.setFont(new java.awt.Font("Segoe UI", 0, 37)); // NOI18N
        jButtonLimpiar.setText("Limpiar");
        jButtonLimpiar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jButtonLimpiar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonLimpiar.setPreferredSize(new java.awt.Dimension(240, 69));
        jButtonLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLimpiarActionPerformed(evt);
            }
        });

        jTextFieldObservaciones1.setBackground(new java.awt.Color(244, 233, 205));
        jTextFieldObservaciones1.setFont(new java.awt.Font("Segoe UI", 0, 26)); // NOI18N
        jTextFieldObservaciones1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jTextFieldObservaciones1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTextFieldObservaciones1.setPreferredSize(new java.awt.Dimension(632, 51));

        jTextFieldObservaciones2.setBackground(new java.awt.Color(244, 233, 205));
        jTextFieldObservaciones2.setFont(new java.awt.Font("Segoe UI", 0, 26)); // NOI18N
        jTextFieldObservaciones2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jTextFieldObservaciones2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTextFieldObservaciones2.setPreferredSize(new java.awt.Dimension(632, 51));

        timePicker1.setBackground(new java.awt.Color(244, 233, 205));
        timePicker1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        timePicker1.setFont(new java.awt.Font("Segoe UI", 0, 26)); // NOI18N

        jDateChooser1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jDateChooser1.setFont(new java.awt.Font("Segoe UI", 0, 26)); // NOI18N

        jDateChooser2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jDateChooser2.setFont(new java.awt.Font("Segoe UI", 0, 26)); // NOI18N

        timePicker2.setBackground(new java.awt.Color(244, 233, 205));
        timePicker2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        timePicker2.setFont(new java.awt.Font("Segoe UI", 0, 26)); // NOI18N

        jComboBoxCoche.setBackground(new java.awt.Color(244, 233, 205));
        jComboBoxCoche.setFont(new java.awt.Font("Segoe UI", 0, 26)); // NOI18N
        jComboBoxCoche.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jComboBoxEmpleado.setBackground(new java.awt.Color(244, 233, 205));
        jComboBoxEmpleado.setFont(new java.awt.Font("Segoe UI", 0, 26)); // NOI18N
        jComboBoxEmpleado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(jButtonGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(84, 84, 84)
                                .addComponent(jButtonActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(63, 63, 63)
                                .addComponent(jButtonLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                                .addComponent(jButtonEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jTextFieldObservaciones1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldObservaciones2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldObservaciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldJustificacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(timePicker1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(timePicker2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE))))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel8)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel9)
                            .addComponent(jLabel4)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(jTextFieldId, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(68, 68, 68)
                                .addComponent(jComboBoxCoche, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(87, 87, 87)
                                .addComponent(jComboBoxEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(50, 50, 50))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jTextFieldId, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jComboBoxEmpleado, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBoxCoche, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextFieldDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextFieldJustificacion, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(timePicker1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel7)
                    .addComponent(jDateChooser2, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
                    .addComponent(timePicker2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldObservaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jTextFieldObservaciones1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jTextFieldObservaciones2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(372, 372, 372))
        );

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 30)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Rellene los campo con la información que se le solicita ");
        jLabel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jButton1.setBackground(new java.awt.Color(244, 233, 205));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/X.png"))); // NOI18N
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelInferiorFormularioLayout = new javax.swing.GroupLayout(jPanelInferiorFormulario);
        jPanelInferiorFormulario.setLayout(jPanelInferiorFormularioLayout);
        jPanelInferiorFormularioLayout.setHorizontalGroup(
            jPanelInferiorFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelInferiorFormularioLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanelInferiorFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelInferiorFormularioLayout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanelInferiorFormularioLayout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 1142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanelInferiorFormularioLayout.setVerticalGroup(
            jPanelInferiorFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelInferiorFormularioLayout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(jPanelInferiorFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 561, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        add(jPanelInferiorFormulario, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Closes the dialog
     */
    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        setVisible(false);
        dispose();
    }//GEN-LAST:event_closeDialog

    private void jButtonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGuardarActionPerformed
        // Declara vaiables que almacenen los campos de los jTextField
        String Marca = jTextFieldDescripcion.getText().trim();
        String Modelo = jTextFieldJustificacion.getText().trim();
        String AnioTexto = jTextFieldAnio.getText().trim();
        String Color = jTextFieldColor.getText().trim();
        Date Fecha = jDateChooserFecha.getDate();
        String Placa = jTextFieldObservaciones.getText().trim();
        String Estado = (String) jComboBoxEstado.getSelectedItem();

        // Validación previa si los jTextField estan vacios
        if (Marca.isEmpty() || Modelo.isEmpty() || AnioTexto.isEmpty() || Color.isEmpty()
            || Fecha == null || Placa.isEmpty() || Estado.equals("Seleccionar...")) {
            // En caso de no estar llenos muestra un mensaje
            JOptionPane.showMessageDialog(
                SwingUtilities.getWindowAncestor(this),
                "Llene todos los campos correctamente.",
                "Error",
                JOptionPane.ERROR_MESSAGE
            );
            return; // Detiene el codigo en caso de que los campos si esten vacios
        }

        // Si pasa validación, entonces convierte a int
        int Anio = 0;

        // creamos try - catch para intentar comvertir el texto del jtextField a entero
        try {
            Anio = Integer.parseInt(AnioTexto);

            // En caso de no comvertirse manda un mensaje confirmando el error
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(
                SwingUtilities.getWindowAncestor(this),
                "El campo Año debe ser un número válido.",
                "Error",
                JOptionPane.ERROR_MESSAGE
            );
            return; // Detiene codigo en caso de fracaso en la comvercion
        }

        /*
        Hacemos try - catch para guardar un nuevo registro de coche
        */
        try {
            java.sql.Date fechaSQL = new java.sql.Date(Fecha.getTime());
            CocheControlador controlador = new CocheControlador();
            controlador.crearCoche(Marca, Modelo, Placa, Color, Estado, Anio, fechaSQL);
            // Mandamos a llamar el metodo cargar datos en la tabla
            vista.cargarDatosTabla();
            // Mandamos a llamar el meod para limpiar los campos
            limpiarCampos();

            // Cerramos formulario
            this.dispose();

            // Limpiamos la barra de busqueda
            vista.jTextFieldBuscar.setText("");
            // En caso de error al guardar muestra mensaje
        } catch (Exception e) {
            JOptionPane.showMessageDialog(
                SwingUtilities.getWindowAncestor(this),
                "Error al guardar: " + e.getMessage(),
                "Error",
                JOptionPane.ERROR_MESSAGE
            );
        }
    }//GEN-LAST:event_jButtonGuardarActionPerformed

    private void jButtonActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonActualizarActionPerformed
        // Creamos variables que almacenen los campos de los jTextField
        int idCoche = Integer.parseInt(jTextFieldId.getText());
        String marca = jTextFieldDescripcion.getText().trim();
        String modelo = jTextFieldJustificacion.getText().trim();
        int anio = Integer.parseInt(jTextFieldAnio.getText().trim());
        String color = jTextFieldColor.getText().trim();
        Date fecha = jDateChooserFecha.getDate();
        String placa = jTextFieldObservaciones.getText().trim();
        String estado = jComboBoxEstado.getSelectedItem().toString();

        try {
            // Obtenemos el registro de coches original desde la base de datos creando un objecto
            CocheControlador controlador = new CocheControlador();
            // Mandamos a llamar el metodo obtener datos por Id
            Coche original = controlador.obtenerCochePorId(idCoche);

            // Creamos condicion que compara los datos de los jTextField con los datos de la base de datos
            if (!hayCambios(marca, modelo, anio, placa, color, estado, fecha, original)) {
                JOptionPane.showMessageDialog(this, "No se detectaron cambios.", "Información", JOptionPane.INFORMATION_MESSAGE);
                return; // Detiene el codigo en caso de que la condicion no se cumpla
            }

            // Si los datos son diferentes se actualizan datos en la base de datos
            java.sql.Date fechaSQL = new java.sql.Date(fecha.getTime());
            controlador.actualizarCoche(idCoche, marca, modelo, placa, color, estado, anio, fechaSQL);
            // Mandamos a llamar el metodo cargar datos en la tabla
            vista.cargarDatosTabla();
            // Quitar formulario
            this.dispose();

            // Limpiamos la barra de busqueda
            vista.jTextFieldBuscar.setText("");

            // En caso de error mandamos un mensaje de error
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonActualizarActionPerformed

    private void jButtonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEliminarActionPerformed
        // Declara y extrae el dato que esta en el Id para localizar el registro en la base de datos
        int IdCoche = (int) Integer.valueOf(jTextFieldId.getText());
        // Declaramos la variable confirmacion
        int confirmacion = JOptionPane.showConfirmDialog(
            null,
            "¿Deseas eliminar este coche?",
            "Confirmar eliminación",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.WARNING_MESSAGE
        );
        // Creamos condición para realizar acción en caso de si
        if (confirmacion == JOptionPane.YES_OPTION) {
            try {
                // Creamos objecto del cotrolador
                CocheControlador controlador = new CocheControlador();
                // Mandamos a llamar el metodo de eliminar coche del controlador
                controlador.eliminarCoche(IdCoche);
                // Cargamos dato de la tabla
                vista.cargarDatosTabla();
                // Cerramos formulario
                this.dispose();
                // Limpiamos la barra de busqueda
                vista.jTextFieldBuscar.setText("");
            } catch (Exception e) {
                //Manda mensaje de error
                JOptionPane.showMessageDialog(null,
                    "Error al eliminar. Asegúrese de que el coche no esté en uso por otro resgistro ",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_jButtonEliminarActionPerformed

    private void jButtonLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLimpiarActionPerformed
        // Mandamos a llamar el metodo
        limpiarCampos();
    }//GEN-LAST:event_jButtonLimpiarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextFieldJustificacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldJustificacionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldJustificacionActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    protected javax.swing.JButton jButtonActualizar;
    protected javax.swing.JButton jButtonEliminar;
    protected javax.swing.JButton jButtonGuardar;
    protected javax.swing.JButton jButtonLimpiar;
    private javax.swing.JComboBox<String> jComboBoxCoche;
    private javax.swing.JComboBox<String> jComboBoxEmpleado;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanelInferiorFormulario;
    protected javax.swing.JTextField jTextFieldDescripcion;
    protected javax.swing.JTextField jTextFieldId;
    protected javax.swing.JTextField jTextFieldJustificacion;
    protected javax.swing.JTextField jTextFieldObservaciones;
    protected javax.swing.JTextField jTextFieldObservaciones1;
    protected javax.swing.JTextField jTextFieldObservaciones2;
    private com.github.lgooddatepicker.components.TimePicker timePicker1;
    private com.github.lgooddatepicker.components.TimePicker timePicker2;
    // End of variables declaration//GEN-END:variables
}
