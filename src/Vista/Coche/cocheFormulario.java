/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package Vista.Coche;

import Controlador.CocheControlador;
import java.util.Date;
import Modelo.POJOCoche;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author Ernesto José Sevilla Inglés
 */
public class cocheFormulario extends javax.swing.JDialog {

    // Definimos variable para almacenar datos
    private Integer idCoche = null;
    private String marca;
    private String modelo;
    private Integer anio;
    private String placa;
    private String color;
    private String estado;
    private Date fechaRegistro;

    private VistaCoche vista;

    /**
     * Creates new form cocheFormulario1
     */
    public cocheFormulario(java.awt.Frame parent, boolean modal, VistaCoche vista) {
        super(parent, modal);
        this.vista = vista;
        initComponents();
        // Desabilitamos el campo del Id ya que no sera editable
        jTextFieldId.setEnabled(false);

    }

    // Metodo para limpiar los campos
    private void limpiarCampos() {
        jTextFieldId.setText("");
        jTextFieldMarca.setText("");
        jTextFieldModelo.setText("");
        jTextFieldPlaca.setText("");
        jTextFieldColor.setText("");
        jTextFieldAnio.setText("");
        jDateChooserFecha.setDate(new Date());
        jComboBoxEstado.setSelectedIndex(0);

        // habilita el boton de guardar.
        jButtonGuardar.setEnabled(true);

        // Inabilita los botones eliminar y actualizar
        jButtonEliminar.setEnabled(false);
        jButtonActualizar.setEnabled(false);

    }
    
    // Metodo para cargar datos en los JtextField
    public void cargarDatosJTextField(int idCoche, String marca, String modelo, int anio, String placa, String color, String estado, Date fechaRegistro) {
        this.idCoche = idCoche;
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
        this.placa = placa;
        this.color = color;
        this.estado = estado;
        this.fechaRegistro = fechaRegistro;

        // Creamos codigo para mandar los datos almacenados a los JtextField
        jTextFieldId.setText(String.valueOf(idCoche));
        jTextFieldMarca.setText(marca);
        jTextFieldModelo.setText(modelo);
        jTextFieldPlaca.setText(placa);
        jTextFieldColor.setText(color);
        jComboBoxEstado.setSelectedItem(estado); // Por si no obtiene los datos correcto puede que esta linea de codigo sea la responsable
        jTextFieldAnio.setText(String.valueOf(anio));
        jDateChooserFecha.setDate(fechaRegistro);

        // Desactiva botones de eliminar
        jButtonGuardar.setEnabled(false);
    }

    // Metodo para comprovar si hay cambios en los jtextfield
    // Nota al final de la comparacion asignamos
    private boolean hayCambios(String marca, String modelo, int anio, String placa, String color, String estado, Date fecha, POJOCoche original) {
        // Devuelve datos de originales de la base de datos y compara con los campos de los jtextField
        return !marca.equals(original.getMarca())
                || !modelo.equals(original.getModelo())
                || anio != original.getAnio()
                || !placa.equals(original.getPlaca())
                || !color.equals(original.getColor())
                || !estado.equals(original.getEstado())
                || !fecha.equals(original.getFecha_Registro());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelInferiorFormulario = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
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
        jTextFieldMarca = new javax.swing.JTextField();
        jTextFieldModelo = new javax.swing.JTextField();
        jTextFieldAnio = new javax.swing.JTextField();
        jTextFieldColor = new javax.swing.JTextField();
        jTextFieldPlaca = new javax.swing.JTextField();
        jButtonGuardar = new javax.swing.JButton();
        jButtonActualizar = new javax.swing.JButton();
        jButtonEliminar = new javax.swing.JButton();
        jComboBoxEstado = new javax.swing.JComboBox<>();
        jButtonLimpiar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jDateChooserFecha = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        jPanelInferiorFormulario.setBackground(new java.awt.Color(255, 57, 54));
        jPanelInferiorFormulario.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanelInferiorFormulario.setPreferredSize(new java.awt.Dimension(1440, 1024));

        jPanel1.setBackground(new java.awt.Color(255, 4, 0));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel3.setBackground(new java.awt.Color(255, 118, 115));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 30)); // NOI18N
        jLabel3.setText("ID");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 30)); // NOI18N
        jLabel4.setText("Marca");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 30)); // NOI18N
        jLabel5.setText("Modelo");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 30)); // NOI18N
        jLabel6.setText("Año");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 30)); // NOI18N
        jLabel7.setText("Color");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 30)); // NOI18N
        jLabel8.setText("Fecha Registro");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 30)); // NOI18N
        jLabel9.setText("Placa");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 30)); // NOI18N
        jLabel10.setText("Estado");

        jTextFieldId.setBackground(new java.awt.Color(244, 233, 205));
        jTextFieldId.setFont(new java.awt.Font("Segoe UI", 0, 26)); // NOI18N
        jTextFieldId.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jTextFieldId.setPreferredSize(new java.awt.Dimension(632, 51));

        jTextFieldMarca.setBackground(new java.awt.Color(244, 233, 205));
        jTextFieldMarca.setFont(new java.awt.Font("Segoe UI", 0, 26)); // NOI18N
        jTextFieldMarca.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jTextFieldMarca.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTextFieldMarca.setPreferredSize(new java.awt.Dimension(632, 51));

        jTextFieldModelo.setBackground(new java.awt.Color(244, 233, 205));
        jTextFieldModelo.setFont(new java.awt.Font("Segoe UI", 0, 26)); // NOI18N
        jTextFieldModelo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jTextFieldModelo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTextFieldModelo.setPreferredSize(new java.awt.Dimension(632, 51));

        jTextFieldAnio.setBackground(new java.awt.Color(244, 233, 205));
        jTextFieldAnio.setFont(new java.awt.Font("Segoe UI", 0, 26)); // NOI18N
        jTextFieldAnio.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jTextFieldAnio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTextFieldAnio.setPreferredSize(new java.awt.Dimension(632, 41));

        jTextFieldColor.setBackground(new java.awt.Color(244, 233, 205));
        jTextFieldColor.setFont(new java.awt.Font("Segoe UI", 0, 26)); // NOI18N
        jTextFieldColor.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jTextFieldColor.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTextFieldColor.setPreferredSize(new java.awt.Dimension(632, 51));

        jTextFieldPlaca.setBackground(new java.awt.Color(244, 233, 205));
        jTextFieldPlaca.setFont(new java.awt.Font("Segoe UI", 0, 26)); // NOI18N
        jTextFieldPlaca.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jTextFieldPlaca.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTextFieldPlaca.setPreferredSize(new java.awt.Dimension(632, 51));

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

        jComboBoxEstado.setBackground(new java.awt.Color(244, 233, 205));
        jComboBoxEstado.setFont(new java.awt.Font("Segoe UI", 0, 26)); // NOI18N
        jComboBoxEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar...", "Disponible", "En Mantenimiento", "En Alquiler" }));
        jComboBoxEstado.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jComboBoxEstado.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jComboBoxEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxEstadoActionPerformed(evt);
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

        jPanel2.setBackground(new java.awt.Color(255, 118, 115));
        jPanel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jDateChooserFecha.setBackground(new java.awt.Color(244, 233, 205));
        jDateChooserFecha.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jDateChooserFecha.setFont(new java.awt.Font("Segoe UI", 0, 26)); // NOI18N
        jDateChooserFecha.setPreferredSize(new java.awt.Dimension(89, 41));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jDateChooserFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 632, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDateChooserFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(104, 104, 104)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButtonGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jButtonActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(jButtonLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51)
                        .addComponent(jButtonEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldModelo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextFieldMarca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextFieldId, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextFieldAnio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextFieldColor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextFieldPlaca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBoxEstado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(82, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextFieldId, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextFieldMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextFieldModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTextFieldAnio, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jTextFieldColor, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jTextFieldPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jComboBoxEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(47, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 30)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Rellene el campo con la información que se le solicita ");
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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanelInferiorFormularioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelInferiorFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelInferiorFormularioLayout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 1142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelInferiorFormularioLayout.setVerticalGroup(
            jPanelInferiorFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelInferiorFormularioLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelInferiorFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2)
                    .addGroup(jPanelInferiorFormularioLayout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(3, 3, 3)))
                .addGap(8, 8, 8)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanelInferiorFormulario, javax.swing.GroupLayout.PREFERRED_SIZE, 1229, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelInferiorFormulario, javax.swing.GroupLayout.PREFERRED_SIZE, 693, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGuardarActionPerformed
        // Declara vaiables que almacenen los campos de los jTextField
        String Marca = jTextFieldMarca.getText().trim();
        String Modelo = jTextFieldModelo.getText().trim();
        String AnioTexto = jTextFieldAnio.getText().trim();
        String Color = jTextFieldColor.getText().trim();
        Date Fecha = jDateChooserFecha.getDate();
        String Placa = jTextFieldPlaca.getText().trim();
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
        String marca = jTextFieldMarca.getText().trim();
        String modelo = jTextFieldModelo.getText().trim();
        int anio = Integer.parseInt(jTextFieldAnio.getText().trim());
        String color = jTextFieldColor.getText().trim();
        Date fecha = jDateChooserFecha.getDate();
        String placa = jTextFieldPlaca.getText().trim();
        String estado = jComboBoxEstado.getSelectedItem().toString();

        try {
            // Obtenemos el registro de coches original desde la base de datos creando un objecto
            CocheControlador controlador = new CocheControlador();
            // Mandamos a llamar el metodo obtener datos por Id
            POJOCoche original = controlador.obtenerCochePorId(idCoche);

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

    private void jComboBoxEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxEstadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxEstadoActionPerformed

    private void jButtonLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLimpiarActionPerformed
        // Mandamos a llamar el metodo
        limpiarCampos();
    }//GEN-LAST:event_jButtonLimpiarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    protected javax.swing.JButton jButtonActualizar;
    protected javax.swing.JButton jButtonEliminar;
    protected javax.swing.JButton jButtonGuardar;
    protected javax.swing.JButton jButtonLimpiar;
    private javax.swing.JComboBox<String> jComboBoxEstado;
    private com.toedter.calendar.JDateChooser jDateChooserFecha;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanelInferiorFormulario;
    protected javax.swing.JTextField jTextFieldAnio;
    protected javax.swing.JTextField jTextFieldColor;
    protected javax.swing.JTextField jTextFieldId;
    protected javax.swing.JTextField jTextFieldMarca;
    protected javax.swing.JTextField jTextFieldModelo;
    protected javax.swing.JTextField jTextFieldPlaca;
    // End of variables declaration//GEN-END:variables
}
