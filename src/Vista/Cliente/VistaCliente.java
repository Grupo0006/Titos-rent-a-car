/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Vista.Cliente;

import Controlador.ClienteControlador;          // Importa la clase del controlador que maneja la lógica de los coches
import Modelo.POJOCliente;                          // Importa la clase del modelo que representa a un coche
import java.sql.Date;                         // Importa la clase Date del paquete SQL para trabajar con fechas compatibles con bases de datos
import java.awt.Color;                        // Importa la clase Color para definir y manipular colores
import java.util.List;                        // Importa la interfaz List para trabajar con listas de objetos
import java.time.LocalDateTime;               // Importa la clase para obtener la fecha y hora actual del sistema
import java.time.format.DateTimeFormatter;    // Importa la clase para formatear objetos de tipo fecha y hora
import javax.swing.table.TableColumn;         // Importa la clase para manipular columnas de tablas en interfaces gráficas
import javax.swing.table.TableCellRenderer;   // Importa la interfaz para personalizar la renderización de celdas en tablas
import java.awt.Component;                    // Importa la clase base de todos los componentes gráficos
import java.awt.Frame;                        // Importa la clase Frame
import java.text.ParseException;               // Importa la clase ParseException
import java.text.SimpleDateFormat;            // Importa la clase para convertir fechas a cadenas de texto con formato
import javax.swing.JOptionPane;               // Importa la clase JOptionPane
import javax.swing.SwingConstants;            // Importa constantes para alinear contenido en componentes Swing
import javax.swing.table.DefaultTableCellRenderer; // Importa clase para personalizar celdas en tablas Swing
import javax.swing.table.DefaultTableModel; 

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.layout.property.UnitValue;
import java.awt.FileDialog;
import javax.swing.JOptionPane;
/**
 *
 * @author Estudiante
 */
public class VistaCliente extends javax.swing.JPanel {

    private final ClienteControlador clienteControlador;
    /**
     * Creates new form VistaCliente
     */
    public VistaCliente() {
        initComponents();
        this.clienteControlador = new ClienteControlador();

        // Llama al metodo cargar datos de tabla
        cargarDatosTabla();

        // Define formato de la tabla
        jTableCliente.getTableHeader().setFont(
                new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 30));

        // Llama al metodo para ajustar las columnas
        ajustarAnchoColumnas(jTableCliente);

        // Manda tamaño de las filas
        jTableCliente.setRowHeight(40);

        // Crear un renderizador para centrar los encabezados
        DefaultTableCellRenderer headerRenderer = (DefaultTableCellRenderer) jTableCliente.getTableHeader().getDefaultRenderer();
        headerRenderer.setHorizontalAlignment(SwingConstants.CENTER);

        // Crear un renderizado para centrar los contenidos de la tabla
        DefaultTableCellRenderer centrado = new DefaultTableCellRenderer();
        centrado.setHorizontalAlignment(SwingConstants.CENTER);

        // Aplicar a todas las columnas
        for (int i = 0; i < jTableCliente.getColumnCount(); i++) {
            // obtiene cada columna y aplica el formato de centrado
            jTableCliente.getColumnModel().getColumn(i).setCellRenderer(centrado);
        }

        // muestra las lineas divisoras de la tabla
        jTableCliente.setShowGrid(true);
        // Les asigna un color a las lineas divisoras
        jTableCliente.setGridColor(Color.gray);

    }
    
     public void cargarDatosTabla() {
        // Obtener todas las categorias del controlador
        //Creamos objeto de clase Empleados controlador
       ClienteControlador clienteControlador1 = new ClienteControlador();
        List<POJOCliente> cliente = clienteControlador1.obtenerTodosClientes();

        if (cliente != null) {
            //Obtener el modelo existentes de la tabla
            DefaultTableModel model = (DefaultTableModel) jTableCliente.getModel();

            // Limpiar las filas existentes
            model.setRowCount(0);

            //Llenar las filas con los datos de coche
            for (POJOCliente cl : cliente) {
                Object[] row = {
                    cl.getIdCliente(),
                    cl.getCedula(),
                    cl.getNombre1(),
                    cl.getNombre2(),
                    cl.getApellido1(),
                    cl.getApellido2(),
                    cl.getTelefono(),
                    cl.getDireccion(),
                    cl.getEmail(),
                    cl.getLicencia()
                };
                // Añade la fila
                model.addRow(row);
            }

        }
    }
     
      public void mostrarFormulario() {
        // Obtener el JFrame contenedor más cercano
        Frame parentFrame = JOptionPane.getFrameForComponent(this);

        // Crear el JDialog 
        ClienteFormulario formulario = new ClienteFormulario(parentFrame, true, this); // Da error si agrego el this

        // Evitar error de IllegalComponentStateException
        if (!formulario.isDisplayable()) {
            formulario.setUndecorated(true); // Esto solo si quieres sin botones
        }

        // Desavilitamos los botones
        formulario.jButtonEliminar.setEnabled(false);
        formulario.jButtonActualizar.setEnabled(false);

        //Mostramos y centramos el formulario
        formulario.setLocationRelativeTo(parentFrame); // Centrado respecto al padre
        formulario.setVisible(true); // Mostrar

    }
       // Creamos meodo para obtener datos de la tabla selecionando una fila
    public POJOCliente obtenerClienteSeleccionado() {
        // Declaramos variable para definir la condicion
        int fila = jTableCliente.getSelectedRow();
        // la codicion se ejecuta si la fila no es null es decir que hallan datos validos
        if (fila != -1) {
            /*
            Crea un nuevo objecto para proceder a obtener los valores de cada fila
             */
            POJOCliente cl = new POJOCliente();
            cl.setIdCliente((int) jTableCliente.getValueAt(fila, 0));
            cl.setCedula((String) jTableCliente.getValueAt(fila, 1));
            cl.setNombre1((String) jTableCliente.getValueAt(fila, 2));
            cl.setNombre2((String) jTableCliente.getValueAt(fila, 3));
            cl.setApellido1((String) jTableCliente.getValueAt(fila, 4));
            cl.setApellido2((String) jTableCliente.getValueAt(fila, 5));
            cl.setTelefono((String) jTableCliente.getValueAt( fila, 6));
            cl.setDireccion((String) jTableCliente.getValueAt(fila, 7));
            cl.setEmail((String) jTableCliente.getValueAt(fila, 8));
            cl.setLicencia((String) jTableCliente.getValueAt(fila, 9));

            // Retorna un coche creado
            return cl;
        }
        // retorna null si no se selecciono ninguna fila
        return null;
    }
    
    public void mostrarFechaActual() {
        LocalDateTime fechaActual = LocalDateTime.now(); //Extrae la fecha del dispositivo
        DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");// Se le aplica formato
        String fechaFormateada = fechaActual.format(formatoFecha);//Se formatea la fecha a String para mostrar en la interfaz

        // Se manda la hora a los jLabel de la interfaz
        campoFecha.setText(fechaFormateada);
    }
    
     public void ajustarAnchoColumnas(javax.swing.JTable tabla) {
        // Recorre todas las columnas de la tabla
        for (int col = 1; col < tabla.getColumnCount(); col++) {
            // Obtiene la columna actual del modelo de columnas de la tabla tomando como refencia a col
            TableColumn columna = tabla.getColumnModel().getColumn(col);

            // Mínimo ancho base
            int ancho = 5;

            // Recorre todas las filas de la tabla para esta columna
            for (int fila = 1; fila < tabla.getRowCount(); fila++) {
                // Obtiene el renderizado qie muestra el contenido de esta celda 
                TableCellRenderer renderizador = tabla.getCellRenderer(fila, col);
                // Prepara el componente que se usara para mostra la celda
                Component comp = tabla.prepareRenderer(renderizador, fila, col);

                // Calcula el ancho máximo entre el tamaño preferido del componente y el ancho actual
                // Se suma 1 para añadir un poco de espacio para un margen
                ancho = Math.max(comp.getPreferredSize().width + 1, ancho); // Aqui
            }
            // Establece el ancho preferido de la columna según el valor calculado
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
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableCliente = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jButtonAgregar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btnGenerarReporte = new javax.swing.JButton();
        jTextFieldBuscar = new javax.swing.JTextField();

        panelInferior.setBackground(new java.awt.Color(255, 57, 54));

        jPanel1.setBackground(new java.awt.Color(255, 118, 115));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        campoFecha.setFont(new java.awt.Font("Segoe UI", 1, 32)); // NOI18N
        campoFecha.setText("Fecha");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 50)); // NOI18N
        jLabel1.setText("Cliente");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(campoFecha)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(campoFecha)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(7, Short.MAX_VALUE))
        );

        jTableCliente.setBackground(new java.awt.Color(244, 233, 205));
        jTableCliente.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jTableCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Cedula", "Nombre1", "Nombre2", "Apellido1", "Apellido2", "Telefono", "Direccion", "Email", "Licencia"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableClienteMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableCliente);

        jPanel2.setBackground(new java.awt.Color(255, 57, 54));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jButtonAgregar.setBackground(new java.awt.Color(244, 233, 205));
        jButtonAgregar.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        jButtonAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Añadir.png"))); // NOI18N
        jButtonAgregar.setText("Cliente");
        jButtonAgregar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonAgregar.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButtonAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAgregarActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 28)); // NOI18N
        jLabel2.setText("Buscador");

        btnGenerarReporte.setBackground(new java.awt.Color(244, 233, 205));
        btnGenerarReporte.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        btnGenerarReporte.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Reportes.png"))); // NOI18N
        btnGenerarReporte.setText("Generar Reporte");
        btnGenerarReporte.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnGenerarReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarReporteActionPerformed(evt);
            }
        });

        jTextFieldBuscar.setBackground(new java.awt.Color(244, 233, 205));
        jTextFieldBuscar.setFont(new java.awt.Font("Segoe UI", 0, 26)); // NOI18N
        jTextFieldBuscar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jTextFieldBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnGenerarReporte)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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
                        .addComponent(jLabel2)
                        .addComponent(btnGenerarReporte, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING))
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 514, Short.MAX_VALUE)
                .addContainerGap())
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

    private void jTableClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableClienteMouseClicked
        // Define una condicion de 2 clics para ejecutar
        if (evt.getClickCount() >= 2) {
            // Declara una vaiable de tipo entero como referencia
            int filaSeleccionada = jTableCliente.getSelectedRow();
            // Define condicion para verificar si la fila seleccionada es positivo
            if (filaSeleccionada != -1) {

                // Obtener los valores de la fila seleccionada
                int IdCliente = (int) jTableCliente.getValueAt(filaSeleccionada, 0);
                String Cedula = (String) jTableCliente.getValueAt(filaSeleccionada, 1);
                String Nombre1 = (String) jTableCliente.getValueAt(filaSeleccionada,2);
                String Nombre2 = (String) jTableCliente.getValueAt(filaSeleccionada, 3);
                String Apellido1 = (String) jTableCliente.getValueAt(filaSeleccionada, 4);
                String Apellido2 = (String) jTableCliente.getValueAt(filaSeleccionada, 5);
                String Telefono = (String) jTableCliente.getValueAt(filaSeleccionada, 6);
                String Direccion = (String) jTableCliente.getValueAt(filaSeleccionada, 7);
                String Email = (String) jTableCliente.getValueAt(filaSeleccionada, 8);
                String Licencia = (String) jTableCliente.getValueAt(filaSeleccionada, 9);

                //Creamos objecto para mandar a llamar metodo de cargar datos en los jTextField
                Frame parentFrame = JOptionPane.getFrameForComponent(this);
                ClienteFormulario formulario = new ClienteFormulario(parentFrame, true, this);

                // Solo si no está visible aún, aplicar undecorated (evita error) en ejecución
                if (!formulario.isDisplayable()) {
                    formulario.setUndecorated(true);
                }
                //Llamamos metodo cargarDatosJTextFIeld
                formulario.cargarDatosJTextField(IdCliente, Cedula, Nombre1, Nombre2, Apellido1, Apellido2, Direccion, Telefono, Email, Licencia);

                formulario.setLocationRelativeTo(parentFrame); //Centramos la ventana
                formulario.setVisible(true); // Mostramos formulario
            }
        }
    }//GEN-LAST:event_jTableClienteMouseClicked

    private void jButtonAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAgregarActionPerformed
        // Llamamos metodo
        mostrarFormulario();
    }//GEN-LAST:event_jButtonAgregarActionPerformed

    private void jTextFieldBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldBuscarActionPerformed

    private void jTextFieldBuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldBuscarKeyTyped
        // Declara variable y crea una lista de coches de la base de datos
        // Nota: trim elimina los espacios al inicio y al final y toLowerCase comverte todo a minusculas
        String textoBusqueda = jTextFieldBuscar.getText().trim().toLowerCase();
        ClienteControlador controlador = new ClienteControlador();
        List<POJOCliente> cliente = controlador.obtenerTodosClientes();
        // Obtiene los modelos de datos de la tabla coches
        DefaultTableModel modelo = (DefaultTableModel) jTableCliente.getModel();
        // Elimina las filas que no coinciden
        modelo.setRowCount(0);

        // Creamos condicion para verificar si coches no es null
        if (cliente != null) {
            for (POJOCliente cl : cliente) {
                // Define la condicion para realizar busquedas verificando que la barra de busqyeda no quede vacia
                if (textoBusqueda.isEmpty() || cl.getCedula().toLowerCase().contains(textoBusqueda)
                    || cl.getNombre1().toLowerCase().contains(textoBusqueda)
                    || cl.getNombre2().toLowerCase().contains(textoBusqueda)
                    || cl.getApellido1().toLowerCase().contains(textoBusqueda)
                    || cl.getApellido2().toLowerCase().contains(textoBusqueda)) {
                    // Creamos arreglos si la condicion de cumple para mostrar las filas que coinciden
                    Object[] fila = {
                        cl.getIdCliente(),
                        cl.getNombre1(),
                        cl.getNombre2(),
                        cl.getApellido1(),
                        cl.getApellido2(),
                        cl.getTelefono(),
                        cl.getDireccion(),
                        cl.getEmail(),
                        cl.getLicencia()
                    };
                    // Agrega la fila con los valores
                    modelo.addRow(fila);
                }
            }
        }
    }//GEN-LAST:event_jTextFieldBuscarKeyTyped

    private void btnGenerarReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarReporteActionPerformed

    try {
        FileDialog dialogoArchivo = new FileDialog((java.awt.Frame) null, "Guardar Reporte PDF", FileDialog.SAVE);
        dialogoArchivo.setFile("Reporte de Cliente.pdf");
        dialogoArchivo.setVisible(true);

        String ruta = dialogoArchivo.getDirectory();
        String nombreArchivo = dialogoArchivo.getFile();

        if (ruta == null || nombreArchivo == null) {
            JOptionPane.showMessageDialog(this, "Operación cancelada.", "Información", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        String rutaCompleta = ruta + nombreArchivo;

        PdfWriter escritor = new PdfWriter(rutaCompleta);
        PdfDocument pdf = new PdfDocument(escritor);
        Document documento = new Document(pdf);
        documento.setMargins(20, 20, 20, 20); // Márgenes

        // Título
        documento.add(new Paragraph("Reporte de Cliente")
            .setTextAlignment(TextAlignment.CENTER)
            .setFontSize(14)
            .setBold());

        // Fecha
        documento.add(new Paragraph("Fecha: " + new java.util.Date().toString())
            .setTextAlignment(TextAlignment.CENTER)
            .setFontSize(10));

        // Tamaños proporcionales de columnas (10 columnas)
        float[] tamaniosColumnas = {1, 2, 2, 2, 2, 2, 2, 3, 3, 2}; 
        Table tabla = new Table(tamaniosColumnas);
        tabla.setWidth(UnitValue.createPercentValue(100));

        // Encabezados
        String[] headers = {"ID", "Cédula", "Nombre1", "Nombre2", "Apellido1", "Apellido2", "Teléfono", "Dirección", "Email", "Licencia"};
        for (String encabezado : headers) {
            tabla.addHeaderCell(new Cell().add(new Paragraph(encabezado).setFontSize(9).setBold()));
        }

        // Datos
        List<POJOCliente> listaPOJOCliente = clienteControlador.obtenerTodosClientes();
        if (listaPOJOCliente != null) {
            for (POJOCliente cliente : listaPOJOCliente) {
                tabla.addCell(new Cell().add(new Paragraph(String.valueOf(cliente.getIdCliente())).setFontSize(8)));
                tabla.addCell(new Cell().add(new Paragraph(cliente.getCedula()).setFontSize(8)));
                tabla.addCell(new Cell().add(new Paragraph(cliente.getNombre1()).setFontSize(8)));
                tabla.addCell(new Cell().add(new Paragraph(cliente.getNombre2()).setFontSize(8)));
                tabla.addCell(new Cell().add(new Paragraph(cliente.getApellido1()).setFontSize(8)));
                tabla.addCell(new Cell().add(new Paragraph(cliente.getApellido2()).setFontSize(8)));
                tabla.addCell(new Cell().add(new Paragraph(cliente.getTelefono()).setFontSize(8)));
                tabla.addCell(new Cell().add(new Paragraph(cliente.getDireccion()).setFontSize(8)));
                tabla.addCell(new Cell().add(new Paragraph(cliente.getEmail()).setFontSize(8)));
                tabla.addCell(new Cell().add(new Paragraph(cliente.getLicencia()).setFontSize(8)));
            }
        }

        documento.add(tabla);

        // Nota final
        documento.add(new Paragraph("Notas: Reporte generado automáticamente desde el sistema.")
            .setFontSize(9)
            .setMarginTop(20));

        documento.close();
        JOptionPane.showMessageDialog(this, "Reporte PDF generado con éxito en: " + rutaCompleta,
            "Éxito", JOptionPane.INFORMATION_MESSAGE);

    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this,
            "Error al generar el PDF: " + e.getMessage(),
            "Error", JOptionPane.ERROR_MESSAGE);
    }


    }//GEN-LAST:event_btnGenerarReporteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGenerarReporte;
    private javax.swing.JLabel campoFecha;
    private javax.swing.JButton jButtonAgregar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable jTableCliente;
    protected javax.swing.JTextField jTextFieldBuscar;
    private javax.swing.JPanel panelInferior;
    // End of variables declaration//GEN-END:variables
}
