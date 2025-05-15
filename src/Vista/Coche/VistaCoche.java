/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Vista.Coche;

import Controlador.CocheControlador;
import Modelo.Coche;
import java.sql.Date;
import java.awt.BorderLayout;
import java.awt.Color;
import java.util.List;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.table.TableColumn;
import javax.swing.table.TableCellRenderer;
import java.awt.Component;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Estudiante
 */
public class VistaCoche extends javax.swing.JPanel {

    private VistaCocheFormulario vistaCocheFormulario; // Referencia al formulario con los JTextField
    private final CocheControlador cocheControlador;
    private Integer idCocheSeleccionada = null;

    /**
     * Creates new form VistaCoche
     */
    public VistaCoche() {
        initComponents();
        this.cocheControlador = new CocheControlador();
        this.vistaCocheFormulario = vistaCocheFormulario;
        cargarDatosTabla();

        mostrarFechaActual();

        jTableCoches.getTableHeader().setFont(
                new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 36));

        ajustarAnchoColumnas(jTableCoches);

        jTableCoches.setRowHeight(46);

        // Crear un renderizador para centrar los encabezados
        DefaultTableCellRenderer headerRenderer = (DefaultTableCellRenderer) jTableCoches.getTableHeader().getDefaultRenderer();
        headerRenderer.setHorizontalAlignment(SwingConstants.CENTER);

        DefaultTableCellRenderer centrado = new DefaultTableCellRenderer();
        centrado.setHorizontalAlignment(SwingConstants.CENTER);

        // Aplicar a todas las columnas
        for (int i = 0; i < jTableCoches.getColumnCount(); i++) {
            jTableCoches.getColumnModel().getColumn(i).setCellRenderer(centrado);
        }

        jTableCoches.setShowGrid(true);
        jTableCoches.setGridColor(Color.gray); // Puedes elegir otro color si prefieres

        // TODO add your handling code here
    }

    public void cargarDatosTabla() {
        // Obtener todas las categorias del controlador
        //Creamos objeto de clase Coche controlador
        CocheControlador cocheControlador = new CocheControlador();
        List<Coche> coches = cocheControlador.obtenerTodosCoches();

        if (coches != null) {
            //Obtener el modelo existentes de la tabla
            DefaultTableModel model = (DefaultTableModel) jTableCoches.getModel();

            // Limpiar las filas existentes
            model.setRowCount(0);

            //Llenar las filas con los datos de coche
            for (Coche coc : coches) {
                Object[] row = {
                    coc.getId_Coche(),
                    coc.getMarca(),
                    coc.getModelo(),
                    coc.getAnio(),
                    coc.getPlaca(),
                    coc.getColor(),
                    coc.getFecha_Registro(),
                    coc.getEstado()
                };
                model.addRow(row);
            }

        }
    }

    // Metodo para mostrar formulario cargado de datos
    public void mostrarFormulario(JPanel formulario) {
        panelInferior.removeAll();
        panelInferior.setLayout(new BorderLayout());
        panelInferior.add(formulario, BorderLayout.CENTER);
        panelInferior.revalidate();
        panelInferior.repaint();
    }

    // Metodo para cargar formulario Limpio
    public void mostrarFormularioLimpio() {
        VistaCocheFormulario formulario = new VistaCocheFormulario(); // Crear instancia

        panelInferior.removeAll();
        panelInferior.setLayout(new BorderLayout());
        panelInferior.add(formulario, BorderLayout.CENTER);
        panelInferior.revalidate();
        panelInferior.repaint();
        formulario.jButtonActualizar.setEnabled(false);
        formulario.jButtonEliminar.setEnabled(false);
    }

    public Coche obtenerCocheSeleccionado() {
        int fila = jTableCoches.getSelectedRow();
        if (fila != -1) {
            Coche coche = new Coche();
            coche.setId_Coche((int) jTableCoches.getValueAt(fila, 0));
            coche.setMarca((String) jTableCoches.getValueAt(fila, 1));
            coche.setModelo((String) jTableCoches.getValueAt(fila, 2));
            coche.setPlaca((String) jTableCoches.getValueAt(fila, 3));
            coche.setColor((String) jTableCoches.getValueAt(fila, 4));
            coche.setEstado((String) jTableCoches.getValueAt(fila, 5));
            coche.setAnio((int) jTableCoches.getValueAt(fila, 6));
            String fechaTexto = (String) jTableCoches.getValueAt(fila, 7);

            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            Date FechaRegistro = null;

            coche.setFecha_Registro(FechaRegistro);
            return coche;
        }
        return null;
    }

    // Metodo para mostrar fecha
    public void mostrarFechaActual() {
        LocalDateTime fechaActual = LocalDateTime.now(); //Extrae la fecha del dispositivo
        DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");// Se le aplica formato
        String fechaFormateada = fechaActual.format(formatoFecha);//Se formatea la fecha a String para mostrar en tabla

        DateTimeFormatter formatoHora = DateTimeFormatter.ofPattern("HH:mm");
        String horaFormateada = fechaActual.format(formatoHora);

        campoFecha.setText(fechaFormateada);
        campoHora.setText(horaFormateada);

        campoFecha.setOpaque(false);
        campoFecha.setBackground(new java.awt.Color(0, 0, 0, 0));
        campoFecha.setBackground(null);
    }

    //Creamos metodo para ajustar el ancho de la tabla automaticamente
    public void ajustarAnchoColumnas(javax.swing.JTable tabla) {
        for (int col = 0; col < tabla.getColumnCount(); col++) {
            TableColumn columna = tabla.getColumnModel().getColumn(col);
            int ancho = 15; // Mínimo ancho base

            for (int fila = 0; fila < tabla.getRowCount(); fila++) {
                TableCellRenderer renderizador = tabla.getCellRenderer(fila, col);
                Component comp = tabla.prepareRenderer(renderizador, fila, col);
                ancho = Math.max(comp.getPreferredSize().width + 1, ancho);
            }

            columna.setPreferredWidth(ancho);
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

        panelInferior = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        campoFecha = new javax.swing.JLabel();
        campoHora = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableCoches = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jButtonAgregar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldBuscar = new javax.swing.JTextField();

        panelInferior.setBackground(new java.awt.Color(255, 57, 54));

        jPanel1.setBackground(new java.awt.Color(255, 118, 115));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        campoFecha.setFont(new java.awt.Font("Segoe UI", 1, 32)); // NOI18N
        campoFecha.setText("Fecha");

        campoHora.setFont(new java.awt.Font("Segoe UI", 1, 32)); // NOI18N
        campoHora.setText("Hora");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 50)); // NOI18N
        jLabel1.setText("Coches");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(campoFecha, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(campoHora, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(campoFecha)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(campoHora)
                .addGap(0, 8, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTableCoches.setBackground(new java.awt.Color(244, 233, 205));
        jTableCoches.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jTableCoches.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Marca", "Modelo", "Año", "Placa", "Color", "Registro", "Estado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
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
        jTableCoches.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableCochesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableCoches);

        jPanel2.setBackground(new java.awt.Color(255, 57, 54));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jButtonAgregar.setBackground(new java.awt.Color(244, 233, 205));
        jButtonAgregar.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        jButtonAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Añadir.png"))); // NOI18N
        jButtonAgregar.setText("  Coche");
        jButtonAgregar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButtonAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAgregarActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 28)); // NOI18N
        jLabel2.setText("Buscador");

        jTextFieldBuscar.setBackground(new java.awt.Color(244, 233, 205));
        jTextFieldBuscar.setFont(new java.awt.Font("Segoe UI", 0, 26)); // NOI18N
        jTextFieldBuscar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jTextFieldBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldBuscarActionPerformed(evt);
            }
        });
        jTextFieldBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldBuscarKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(28, 28, 28)
                .addComponent(jTextFieldBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2))
                    .addComponent(jTextFieldBuscar))
                .addContainerGap())
        );

        javax.swing.GroupLayout panelInferiorLayout = new javax.swing.GroupLayout(panelInferior);
        panelInferior.setLayout(panelInferiorLayout);
        panelInferiorLayout.setHorizontalGroup(
            panelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelInferiorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1428, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelInferiorLayout.setVerticalGroup(
            panelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInferiorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 796, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelInferior, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelInferior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAgregarActionPerformed
        // TODO add your handling code here:
        mostrarFormularioLimpio();
    }//GEN-LAST:event_jButtonAgregarActionPerformed

    private void jTableCochesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableCochesMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() >= 2) {
            int filaSeleccionada = jTableCoches.getSelectedRow();
            if (filaSeleccionada != -1) {

                /*
                // Creamos objeto del formulario 
                 VistaCocheFormulario formulario = new VistaCocheFormulario();
                 // Mandamos a llamar el metodo cargarDatosJTextField
                 formulario.cargarDatosJTextField(jTableCoches.getValueAt(filaSeleccionada, 0),
                         jTableCoches.getValueAt(filaSeleccionada, 1),
                         jTableCoches.getValueAt(filaSeleccionada, 2),
                         jTableCoches.getValueAt(filaSeleccionada, 3),
                         jTableCoches.getValueAt(filaSeleccionada, 4),
                         jTableCoches.getValueAt(filaSeleccionada, 5),
                         jTableCoches.getValueAt(filaSeleccionada, 6),
                         jTableCoches.getValueAt(filaSeleccionada, 7)); 
                         
                 */
                // Obtener los valores de la fila seleccionada
                int idCoche = (int) jTableCoches.getValueAt(filaSeleccionada, 0); // Id_Coche
                String marca = (String) jTableCoches.getValueAt(filaSeleccionada, 1); // Marca
                String modelo = (String) jTableCoches.getValueAt(filaSeleccionada, 2); // Modelo
                int anio = (int) jTableCoches.getValueAt(filaSeleccionada, 3); // Anio
                String placa = (String) jTableCoches.getValueAt(filaSeleccionada, 4); // Placa
                String color = (String) jTableCoches.getValueAt(filaSeleccionada, 5); // Color
                java.util.Date fechaRegistro = (java.util.Date) jTableCoches.getValueAt(filaSeleccionada, 6); // Fecha_Registro
                String estado = (String) jTableCoches.getValueAt(filaSeleccionada, 7); // Estado

                VistaCocheFormulario formulario = new VistaCocheFormulario();
                formulario.cargarDatosJTextField(idCoche, marca, modelo, anio, placa, color, estado, fechaRegistro);
                mostrarFormulario(formulario);
                // Actualizar los JTextField en el otro panel
                /*
                Formulario();
                vistaCocheFormulario.jTextFieldId.setText(String.valueOf(idCoche));
                vistaCocheFormulario.jTextFieldMarca.setText(marca);
                vistaCocheFormulario.jTextFieldModelo.setText(modelo);
                vistaCocheFormulario.jTextFieldPlaca.setText(placa);
                vistaCocheFormulario.jTextFieldColor.setText(color);
                vistaCocheFormulario.jTextFieldEstado.setText(estado);
                vistaCocheFormulario.jTextFieldAnio.setText(String.valueOf(anio));
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                vistaCocheFormulario.jTextFieldFecha.setText(fechaRegistro != null ? sdf.format(fechaRegistro) : "");
                
                vistaCocheFormulario.jButtonGuardar.setEnabled(false);
                vistaCocheFormulario.jButtonEliminar.setEnabled(false);
                
                
                // Deshabilitar botones
               /* vistaCocheFormulario.jButtonGuardar.setEnabled(false);
                vistaCocheFormulario.jButtonEliminar.setEnabled(false);*/

            }
        }
    }//GEN-LAST:event_jTableCochesMouseClicked

    private void jTextFieldBuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldBuscarKeyTyped
        // TODO add your handling code here:
        String textoBusqueda = jTextFieldBuscar.getText().trim().toLowerCase();
        CocheControlador controlador = new CocheControlador();
        List<Coche> coches = controlador.obtenerTodosCoches();

        DefaultTableModel modelo = (DefaultTableModel) jTableCoches.getModel();
        modelo.setRowCount(0);

        if (coches != null) {
            for (Coche coc : coches) {
                if (textoBusqueda.isEmpty() || coc.getMarca().toLowerCase().contains(textoBusqueda)
                        || coc.getModelo().toLowerCase().contains(textoBusqueda)
                        || coc.getColor().toLowerCase().contains(textoBusqueda)
                        || coc.getEstado().toLowerCase().contains(textoBusqueda)
                        || coc.getPlaca().toLowerCase().contains(textoBusqueda)) {
                    Object[] fila = {
                        coc.getId_Coche(),
                        coc.getMarca(),
                        coc.getModelo(),
                        coc.getAnio(),
                        coc.getPlaca(),
                        coc.getColor(),
                        coc.getFecha_Registro(),
                        coc.getEstado()
                    };
                    modelo.addRow(fila);
                }
            }
        }
    }//GEN-LAST:event_jTextFieldBuscarKeyTyped

    private void jTextFieldBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldBuscarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel campoFecha;
    private javax.swing.JLabel campoHora;
    private javax.swing.JButton jButtonAgregar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable jTableCoches;
    private javax.swing.JTextField jTextFieldBuscar;
    private javax.swing.JPanel panelInferior;
    // End of variables declaration//GEN-END:variables
}
