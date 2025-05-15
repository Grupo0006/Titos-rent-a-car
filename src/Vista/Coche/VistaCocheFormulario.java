/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Vista.Coche;

import Controlador.CocheControlador;
import java.util.Date;
import Modelo.Coche;
import DAO.DAOCoche;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 *
 * @author Estudiante
 */
public class VistaCocheFormulario extends javax.swing.JPanel {

    private Integer idCoche = null;
    private String marca;
    private String modelo;
    private Integer anio;
    private String placa;
    private String color;
    private String estado;
    private Date fechaRegistro;

    /**
     * Creates new form VistaCoche
     */
    public VistaCocheFormulario() {
        initComponents();

        jTextFieldId.setEnabled(false);
        jComboBoxEstado.setForeground(Color.GRAY);
        jComboBoxEstado.setBackground(new Color(244, 233, 205));
        setPreferredSize(new Dimension(1440, 1024)); // o el tamaño que necesites

    }

    // Metodo para limpiar campos
    private void limpiarCampos() {
        jTextFieldId.setText("");
        jTextFieldMarca.setText("");
        jTextFieldModelo.setText("");
        jTextFieldPlaca.setText("");
        jTextFieldColor.setText("");
        jTextFieldAnio.setText("");
        jDateChooserFecha.setDate(new Date());
        jComboBoxEstado.setSelectedIndex(0);

        jButtonGuardar.setEnabled(true);
        jButtonEliminar.setEnabled(false);
        jButtonActualizar.setEnabled(false);
        
    }

    // Metodo para hacer parecer el JPanel de formulario vacio
    public void aparecerVista() {
        VistaCoche Vista = new VistaCoche();
        jPanelInferiorFormulario.removeAll();
        jPanelInferiorFormulario.setLayout(new BorderLayout());
        jPanelInferiorFormulario.add(Vista, BorderLayout.CENTER);
        jPanelInferiorFormulario.revalidate();
        jPanelInferiorFormulario.repaint();
    }

    // Metodo para cargar datos en los JtextField 2
    // Creamos metodo para declarar variable que almacenen datos
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
        jComboBoxEstado.setSelectedItem(estado); // Por si no obtiene los atos qcorrecto puede que esta linea de codigo sea la responsable
        jTextFieldAnio.setText(String.valueOf(anio));
        jDateChooserFecha.setDate(fechaRegistro);

        // Desactiva botones de eliminar
        jButtonGuardar.setEnabled(false);
    }

    private boolean hayCambios(String marca, String modelo, int anio, String placa, String color, String estado, Date fecha, Coche original) {
        return !marca.equals(original.getMarca())
                || !modelo.equals(original.getModelo())
                || anio != original.getAnio()
                || !placa.equals(original.getPlaca())
                || !color.equals(original.getColor())
                || !estado.equals(original.getEstado())
                || !fecha.equals(original.getFecha_Registro());
    }
    
    public void desactivarBotonActualizar() {
    jButtonActualizar.setEnabled(false);
}


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelInferiorFormulario = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
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
        jDateChooserFecha = new com.toedter.calendar.JDateChooser();

        jPanelInferiorFormulario.setBackground(new java.awt.Color(255, 57, 54));
        jPanelInferiorFormulario.setPreferredSize(new java.awt.Dimension(1440, 1024));

        jPanel1.setBackground(new java.awt.Color(255, 4, 0));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 50)); // NOI18N
        jLabel1.setText("Registro de Coches");

        jButton1.setBackground(new java.awt.Color(244, 233, 205));
        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 32)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/X.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
                .addGap(18, 18, 18))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 57, 54));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 37)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Rellene el campo con la información que se le solicita ");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 118, 115));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 37)); // NOI18N
        jLabel3.setText("ID");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 37)); // NOI18N
        jLabel4.setText("Marca");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 37)); // NOI18N
        jLabel5.setText("Modelo");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 37)); // NOI18N
        jLabel6.setText("Año");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 37)); // NOI18N
        jLabel7.setText("Color");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 37)); // NOI18N
        jLabel8.setText("Fecha Registro");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 37)); // NOI18N
        jLabel9.setText("Placa");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 37)); // NOI18N
        jLabel10.setText("Estado");

        jTextFieldId.setBackground(new java.awt.Color(244, 233, 205));
        jTextFieldId.setFont(new java.awt.Font("Segoe UI", 0, 26)); // NOI18N
        jTextFieldId.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jTextFieldId.setPreferredSize(new java.awt.Dimension(632, 51));

        jTextFieldMarca.setBackground(new java.awt.Color(244, 233, 205));
        jTextFieldMarca.setFont(new java.awt.Font("Segoe UI", 0, 26)); // NOI18N
        jTextFieldMarca.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jTextFieldMarca.setPreferredSize(new java.awt.Dimension(632, 51));

        jTextFieldModelo.setBackground(new java.awt.Color(244, 233, 205));
        jTextFieldModelo.setFont(new java.awt.Font("Segoe UI", 0, 26)); // NOI18N
        jTextFieldModelo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jTextFieldModelo.setPreferredSize(new java.awt.Dimension(632, 51));

        jTextFieldAnio.setBackground(new java.awt.Color(244, 233, 205));
        jTextFieldAnio.setFont(new java.awt.Font("Segoe UI", 0, 26)); // NOI18N
        jTextFieldAnio.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jTextFieldAnio.setPreferredSize(new java.awt.Dimension(632, 51));

        jTextFieldColor.setBackground(new java.awt.Color(244, 233, 205));
        jTextFieldColor.setFont(new java.awt.Font("Segoe UI", 0, 26)); // NOI18N
        jTextFieldColor.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jTextFieldColor.setPreferredSize(new java.awt.Dimension(632, 51));

        jTextFieldPlaca.setBackground(new java.awt.Color(244, 233, 205));
        jTextFieldPlaca.setFont(new java.awt.Font("Segoe UI", 0, 26)); // NOI18N
        jTextFieldPlaca.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jTextFieldPlaca.setPreferredSize(new java.awt.Dimension(632, 51));

        jButtonGuardar.setBackground(new java.awt.Color(244, 233, 205));
        jButtonGuardar.setFont(new java.awt.Font("Segoe UI", 0, 37)); // NOI18N
        jButtonGuardar.setText("Guardar");
        jButtonGuardar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
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

        jButtonLimpiar.setBackground(new java.awt.Color(244, 233, 205));
        jButtonLimpiar.setFont(new java.awt.Font("Segoe UI", 0, 37)); // NOI18N
        jButtonLimpiar.setText("Limpiar");
        jButtonLimpiar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jButtonLimpiar.setPreferredSize(new java.awt.Dimension(240, 69));
        jButtonLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLimpiarActionPerformed(evt);
            }
        });

        jDateChooserFecha.setBackground(new java.awt.Color(244, 233, 205));
        jDateChooserFecha.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jDateChooserFecha.setFont(new java.awt.Font("Segoe UI", 0, 26)); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(105, 105, 105)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(199, 199, 199)
                        .addComponent(jTextFieldMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(jLabel5)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextFieldModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLabel7)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextFieldId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel6)
                                .addComponent(jLabel10)
                                .addComponent(jLabel9)
                                .addComponent(jLabel8))
                            .addGap(60, 60, 60)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jTextFieldPlaca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTextFieldAnio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jTextFieldColor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jComboBoxEstado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jDateChooserFecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jButtonActualizar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonLimpiar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButtonGuardar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(128, 128, 128))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jTextFieldMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(38, 38, 38))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(78, 78, 78)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(jTextFieldId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(99, 99, 99)
                                .addComponent(jButtonGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(78, 78, 78)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextFieldModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(jTextFieldAnio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(45, 45, 45)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jTextFieldColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addComponent(jButtonLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(jButtonEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jDateChooserFecha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(7, 7, 7)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jTextFieldPlaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel10)
                    .addComponent(jComboBoxEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanelInferiorFormularioLayout = new javax.swing.GroupLayout(jPanelInferiorFormulario);
        jPanelInferiorFormulario.setLayout(jPanelInferiorFormularioLayout);
        jPanelInferiorFormularioLayout.setHorizontalGroup(
            jPanelInferiorFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelInferiorFormularioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelInferiorFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanelInferiorFormularioLayout.setVerticalGroup(
            jPanelInferiorFormularioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelInferiorFormularioLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelInferiorFormulario, javax.swing.GroupLayout.DEFAULT_SIZE, 1428, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelInferiorFormulario, javax.swing.GroupLayout.DEFAULT_SIZE, 1012, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        aparecerVista();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButtonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGuardarActionPerformed
        // TODO add your handling code here:
        String Marca = jTextFieldMarca.getText().trim();
        String Modelo = jTextFieldModelo.getText().trim();
        String AnioTexto = jTextFieldAnio.getText().trim();
        String Color = jTextFieldColor.getText().trim();
        Date Fecha = jDateChooserFecha.getDate();
        String Placa = jTextFieldPlaca.getText().trim();
        String Estado = (String) jComboBoxEstado.getSelectedItem();

        // Validación previa
        if (Marca.isEmpty() || Modelo.isEmpty() || AnioTexto.isEmpty() || Color.isEmpty()
                || Fecha == null || Placa.isEmpty() || Estado.equals("Seleccionar...")) {
            JOptionPane.showMessageDialog(
                    SwingUtilities.getWindowAncestor(this),
                    "Llene todos los campos correctamente.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
            return;
        }

        // Si pasa validación, entonces convierte a int
        int Anio = 0;
        try {
            Anio = Integer.parseInt(AnioTexto);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(
                    SwingUtilities.getWindowAncestor(this),
                    "El campo Año debe ser un número válido.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
            return;
        }

        try {
            java.sql.Date fechaSQL = new java.sql.Date(Fecha.getTime());
            CocheControlador controlador = new CocheControlador();
            controlador.crearCoche(Marca, Modelo, Placa, Color, Estado, Anio, fechaSQL);
            VistaCoche Vista = new VistaCoche();
            Vista.cargarDatosTabla();
            limpiarCampos();
            aparecerVista();
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
        // TODO add your handling code here:
        int idCoche = Integer.parseInt(jTextFieldId.getText());
        String marca = jTextFieldMarca.getText().trim();
        String modelo = jTextFieldModelo.getText().trim();
        int anio = Integer.parseInt(jTextFieldAnio.getText().trim());
        String color = jTextFieldColor.getText().trim();
        Date fecha = jDateChooserFecha.getDate();
        String placa = jTextFieldPlaca.getText().trim();
        String estado = jComboBoxEstado.getSelectedItem().toString();

        if (!marca.isEmpty() && !modelo.isEmpty() && anio != 0 && !color.isEmpty() && !estado.isEmpty() && !placa.isEmpty()) {
            try {
                // Obtienes el coche original desde la base de datos
                CocheControlador controlador = new CocheControlador();
                Coche original = controlador.obtenerCochePorId(idCoche); // Debes tener esta función

                if (!hayCambios(marca, modelo, anio, placa, color, estado, fecha, original)) {
                    JOptionPane.showMessageDialog(this, "No se detectaron cambios.", "Información", JOptionPane.INFORMATION_MESSAGE);
                    return;
                }

                java.sql.Date fechaSQL = new java.sql.Date(fecha.getTime());
                controlador.actualizarCoche(idCoche, marca, modelo, placa, color, estado, anio, fechaSQL);
                aparecerVista();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Llene los campos obligatorios.", "Error", JOptionPane.ERROR_MESSAGE);
        }


    }//GEN-LAST:event_jButtonActualizarActionPerformed

    private void jButtonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEliminarActionPerformed
        // TODO add your handling code here:
        int IdCoche = (int) Integer.valueOf(jTextFieldId.getText());
        CocheControlador controlador = new CocheControlador();
        controlador.eliminarCoche(IdCoche);
        VistaCoche vista = new VistaCoche();
        aparecerVista();
        vista.cargarDatosTabla();
    }//GEN-LAST:event_jButtonEliminarActionPerformed

    private void jButtonLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLimpiarActionPerformed
        // TODO add your handling code here:
        limpiarCampos();
    }//GEN-LAST:event_jButtonLimpiarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    protected javax.swing.JButton jButtonActualizar;
    protected javax.swing.JButton jButtonEliminar;
    protected javax.swing.JButton jButtonGuardar;
    protected javax.swing.JButton jButtonLimpiar;
    private javax.swing.JComboBox<String> jComboBoxEstado;
    private com.toedter.calendar.JDateChooser jDateChooserFecha;
    private javax.swing.JLabel jLabel1;
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
