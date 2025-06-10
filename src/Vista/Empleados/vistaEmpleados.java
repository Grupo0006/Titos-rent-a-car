package Vista.Empleados;

// Creamos importaciones necesarios para el codigo
// Importaciones necesarias para el funcionamiento de la clase
import Vista.Empleados.*;
import Controlador.EmpleadoControlador;          // Importa la clase del controlador que maneja la lógica de los coches
import Modelo.POJOEmpleado;                          // Importa la clase del modelo que representa a un coche
import java.sql.Date;                         // Importa la clase Date del paquete SQL para trabajar con fechas compatibles con bases de datos
import java.awt.Color;                        // Importa la clase Color para definir y manipular colores
import java.util.List;                        // Importa la interfaz List para trabajar con listas de objetos
import java.time.LocalDateTime;               // Importa la clase para obtener la fecha y hora actual del sistema
import java.time.format.DateTimeFormatter;    // Importa la clase para formatear objetos de tipo fecha y hora
import javax.swing.table.TableColumn;         // Importa la clase para manipular columnas de tablas en interfaces gráficas
import javax.swing.table.TableCellRenderer;   // Importa la interfaz para personalizar la renderización de celdas en tablas
import java.awt.Component;                    // Importa la clase base de todos los componentes gráficos
import java.awt.FontMetrics;
import java.awt.Frame;                        // Importa la clase Frame
import java.text.ParseException;               // Importa la clase ParseException
import java.text.SimpleDateFormat;            // Importa la clase para convertir fechas a cadenas de texto con formato
import javax.swing.JOptionPane;               // Importa la clase JOptionPane
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;            // Importa constantes para alinear contenido en componentes Swing
import javax.swing.table.DefaultTableCellRenderer; // Importa clase para personalizar celdas en tablas Swing
import javax.swing.table.DefaultTableModel;   // Importa el modelo de tabla por defecto para manejar datos en tablas

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
 * @author Ernesto José Sevilla Inglés
 */
public class vistaEmpleados extends javax.swing.JPanel {

    // inicializa vaiable del cocheControlador
    private final EmpleadoControlador empleadoControlador;

    /**
     * Creates new form VistaCoche
     */
    public vistaEmpleados() {

        initComponents();
        this.empleadoControlador = new EmpleadoControlador();

        // Llama al metodo cargar datos de tabla
        cargarDatosTabla();

        // carga metodo para mostrar la fecha actual
        mostrarFechaActual();
        
        ajustarAnchoColumnas(jTableEmpleado);

        // Define formato de la tabla
        jTableEmpleado.getTableHeader().setFont(
                new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 20));

        // Llama al metodo para ajustar las columnas

        // Manda tamaño de las filas
        jTableEmpleado.setRowHeight(40);

        // Crear un renderizador para centrar los encabezados
        DefaultTableCellRenderer headerRenderer = (DefaultTableCellRenderer) jTableEmpleado.getTableHeader().getDefaultRenderer();
        headerRenderer.setHorizontalAlignment(SwingConstants.CENTER);

        // Crear un renderizado para centrar los contenidos de la tabla
        DefaultTableCellRenderer centrado = new DefaultTableCellRenderer();
        centrado.setHorizontalAlignment(SwingConstants.CENTER);

        // Aplicar a todas las columnas
        for (int i = 0; i < jTableEmpleado.getColumnCount(); i++) {
            // obtiene cada columna y aplica el formato de centrado
            jTableEmpleado.getColumnModel().getColumn(i).setCellRenderer(centrado);
        }

        // muestra las lineas divisoras de la tabla
        jTableEmpleado.setShowGrid(true);
        // Les asigna un color a las lineas divisoras
        jTableEmpleado.setGridColor(Color.gray);

    }

    public void cargarDatosTabla() {
        // Obtener todas las categorias del controlador
        //Creamos objeto de clase Empleados controlador
        EmpleadoControlador empleadoControlador = new EmpleadoControlador();
        List<POJOEmpleado> empleado = empleadoControlador.obtenerTodosEmpleados();

        if (empleado != null) {
            //Obtener el modelo existentes de la tabla
            DefaultTableModel model = (DefaultTableModel) jTableEmpleado.getModel();

            // Limpiar las filas existentes
            model.setRowCount(0);

            //Llenar las filas con los datos de coche
            for (POJOEmpleado emp : empleado) {
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
                // Añade la fila
                model.addRow(row);
            }

        }
    }

    // Metodo para mostrar formulario cargado de datos
    public void mostrarFormulario() {
        // Obtener el JFrame contenedor más cercano
        Frame parentFrame = JOptionPane.getFrameForComponent(this);

        // Crear el JDialog 
        empleadoFormulario formulario = new empleadoFormulario(parentFrame, true, this); // Da error si agrego el this

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
    public POJOEmpleado obtenerEmpleadosSeleccionado() {
        // Declaramos variable para definir la condicion
        int fila = jTableEmpleado.getSelectedRow();
        // la codicion se ejecuta si la fila no es null es decir que hallan datos validos
        if (fila != -1) {
            /*
            Crea un nuevo objecto para proceder a obtener los valores de cada fila
             */
            POJOEmpleado emp = new POJOEmpleado();
            emp.setId_Empleado((int) jTableEmpleado.getValueAt(fila, 0));
            emp.setCedula((String) jTableEmpleado.getValueAt(fila, 1));
            emp.setNombre1((String) jTableEmpleado.getValueAt(fila, 2));
            emp.setNombre2((String) jTableEmpleado.getValueAt(fila, 3));
            emp.setApellido1((String) jTableEmpleado.getValueAt(fila, 4));
            emp.setApellido2((String) jTableEmpleado.getValueAt(fila, 5));
            emp.setDireccion((String) jTableEmpleado.getValueAt(fila, 6));
            emp.setEmail((String) jTableEmpleado.getValueAt(fila, 7));

            // Retorna un coche creado
            return emp;
        }
        // retorna null si no se selecciono ninguna fila
        return null;
    }

    // Metodo para mostrar fecha
    public void mostrarFechaActual() {
        LocalDateTime fechaActual = LocalDateTime.now(); //Extrae la fecha del dispositivo
        DateTimeFormatter formatoFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");// Se le aplica formato
        String fechaFormateada = fechaActual.format(formatoFecha);//Se formatea la fecha a String para mostrar en la interfaz

        // Se manda la hora a los jLabel de la interfaz
        campoFecha.setText(fechaFormateada);
    }

    
    //Creamos metodo para ajustar el ancho de la tabla automaticamente
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

    /*
    (No hace nada, solo esta existiendo)
    
    //Creamos metodo para ajustar el ancho de la tabla automaticamente
    public void ajustarAnchoYAltoTabla(JTable tabla) {
    for (int col = 0; col < tabla.getColumnCount(); col++) {
        TableColumn columna = tabla.getColumnModel().getColumn(col);
        int ancho = 15;

        for (int fila = 0; fila < tabla.getRowCount(); fila++) {
            Object valor = tabla.getValueAt(fila, col);

            // Crear un JTextArea temporal para medir el tamaño del contenido
            JTextArea area = new JTextArea(valor != null ? valor.toString() : "");
            area.setLineWrap(true);
            area.setWrapStyleWord(true);
            area.setFont(tabla.getFont());

            // Ajustar tamaño según el contenido
            ancho = Math.max(area.getPreferredSize().width + 1, ancho);

            // Limitar a 2 líneas de alto
            FontMetrics fm = area.getFontMetrics(area.getFont());
            int alturaDeseada = fm.getHeight() * 2;

            if (tabla.getRowHeight(fila) < alturaDeseada) {
                tabla.setRowHeight(fila, alturaDeseada);
            }
        }

        columna.setPreferredWidth(ancho);
    }
}
    */


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
        jTableEmpleado = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jButtonAgregar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldBuscar = new javax.swing.JTextField();
        btnGenerarReporte = new javax.swing.JButton();

        panelInferior.setBackground(new java.awt.Color(255, 57, 54));

        jPanel1.setBackground(new java.awt.Color(255, 118, 115));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        campoFecha.setFont(new java.awt.Font("Segoe UI", 1, 32)); // NOI18N
        campoFecha.setText("Fecha");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 50)); // NOI18N
        jLabel1.setText("Empleados");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(campoFecha)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(campoFecha)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(7, Short.MAX_VALUE))
        );

        jTableEmpleado.setBackground(new java.awt.Color(244, 233, 205));
        jTableEmpleado.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        jTableEmpleado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Cedula", "Nombre1", "Nombre2", "Apellido1", "Apellido2", "Direccion", "Email"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class
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
        jTableEmpleado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableEmpleadoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableEmpleado);

        jPanel2.setBackground(new java.awt.Color(255, 57, 54));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jButtonAgregar.setBackground(new java.awt.Color(244, 233, 205));
        jButtonAgregar.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        jButtonAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Añadir.png"))); // NOI18N
        jButtonAgregar.setText("Empleado");
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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addGap(28, 28, 28)
                .addComponent(jTextFieldBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 285, Short.MAX_VALUE)
                .addComponent(btnGenerarReporte)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonAgregar)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextFieldBuscar)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addComponent(btnGenerarReporte, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout panelInferiorLayout = new javax.swing.GroupLayout(panelInferior);
        panelInferior.setLayout(panelInferiorLayout);
        panelInferiorLayout.setHorizontalGroup(
            panelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInferiorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        panelInferiorLayout.setVerticalGroup(
            panelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInferiorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 514, Short.MAX_VALUE)
                .addGap(88, 88, 88))
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
        // Llamamos metodo
        mostrarFormulario();
    }//GEN-LAST:event_jButtonAgregarActionPerformed

    private void jTableEmpleadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableEmpleadoMouseClicked
        // Define una condicion de 2 clics para ejecutar
        if (evt.getClickCount() >= 2) {
            // Declara una vaiable de tipo entero como referencia
            int filaSeleccionada = jTableEmpleado.getSelectedRow();
            // Define condicion para verificar si la fila seleccionada es positivo
            if (filaSeleccionada != -1) {

                // Obtener los valores de la fila seleccionada
                int idEmpleado = (int) jTableEmpleado.getValueAt(filaSeleccionada, 0);
                String Cedula = (String) jTableEmpleado.getValueAt(filaSeleccionada, 1);
                String Nombre1 = (String) jTableEmpleado.getValueAt(filaSeleccionada,2);
                String Nombre2 = (String) jTableEmpleado.getValueAt(filaSeleccionada, 3);
                String Apellido1 = (String) jTableEmpleado.getValueAt(filaSeleccionada, 4);
                String Apellido2 = (String) jTableEmpleado.getValueAt(filaSeleccionada, 5);
                String Direccion = (String) jTableEmpleado.getValueAt(filaSeleccionada, 6);
                String Email = (String) jTableEmpleado.getValueAt(filaSeleccionada, 7);

                //Creamos objecto para mandar a llamar metodo de cargar datos en los jTextField
                Frame parentFrame = JOptionPane.getFrameForComponent(this);
                empleadoFormulario formulario = new empleadoFormulario(parentFrame, true, this);

                // Solo si no está visible aún, aplicar undecorated (evita error) en ejecución
                if (!formulario.isDisplayable()) {
                    formulario.setUndecorated(true);
                }
                //Llamamos metodo cargarDatosJTextFIeld
                formulario.cargarDatosJTextField(idEmpleado, Cedula, Nombre1, Nombre2, Apellido1, Apellido2, Direccion, Email);

                formulario.setLocationRelativeTo(parentFrame); //Centramos la ventana
                formulario.setVisible(true); // Mostramos formulario
            }
        }
    }//GEN-LAST:event_jTableEmpleadoMouseClicked

    private void jTextFieldBuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldBuscarKeyTyped
        // Declara variable y crea una lista de coches de la base de datos
        // Nota: trim elimina los espacios al inicio y al final y toLowerCase comverte todo a minusculas
        String textoBusqueda = jTextFieldBuscar.getText().trim().toLowerCase();
        EmpleadoControlador controlador = new EmpleadoControlador();
        List<POJOEmpleado> empleado = controlador.obtenerTodosEmpleados();
        // Obtiene los modelos de datos de la tabla coches
        DefaultTableModel modelo = (DefaultTableModel) jTableEmpleado.getModel();
        // Elimina las filas que no coinciden
        modelo.setRowCount(0);
        // Creamos condicion para verificar si coches no es null
        if (empleado != null) {
            for (POJOEmpleado emp : empleado) {
                // Define la condicion para realizar busquedas verificando que la barra de busqyeda no quede vacia 
                if (textoBusqueda.isEmpty() || emp.getCedula().toLowerCase().contains(textoBusqueda)
                        || emp.getNombre1().toLowerCase().contains(textoBusqueda)
                        || emp.getNombre2().toLowerCase().contains(textoBusqueda)
                        || emp.getApellido1().toLowerCase().contains(textoBusqueda)
                        || emp.getApellido2().toLowerCase().contains(textoBusqueda)
                        || emp.getDireccion().toLowerCase().contains(textoBusqueda)
                        || emp.getEmail().toLowerCase().contains(textoBusqueda)) {
                    // Creamos arreglos si la condicion de cumple para mostrar las filas que coinciden
                    Object[] fila = {
                        emp.getId_Empleado(),
                        emp.getCedula(),
                        emp.getNombre1(),
                        emp.getNombre2(),
                        emp.getApellido1(),
                        emp.getApellido2(),
                        emp.getDireccion(),
                        emp.getEmail(),};
                    // Agrega la fila con los valores
                    modelo.addRow(fila);
                }
            }
        }
    }//GEN-LAST:event_jTextFieldBuscarKeyTyped

    private void jTextFieldBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldBuscarActionPerformed

    private void btnGenerarReporteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarReporteActionPerformed
       
    try {
        FileDialog dialogoArchivo = new FileDialog((java.awt.Frame) null, "Guardar Reporte PDF", FileDialog.SAVE);
        dialogoArchivo.setFile("Reporte de Empleado.pdf");
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
        documento.add(new Paragraph("Reporte de Empleado")
                .setTextAlignment(TextAlignment.CENTER)
                .setFontSize(14)
                .setBold());

        // Fecha
        documento.add(new Paragraph("Fecha: " + new java.util.Date().toString())
                .setTextAlignment(TextAlignment.CENTER)
                .setFontSize(10));

        // Crear tabla con proporciones de columnas
        float[] tamaniosColumnas = {1, 2, 2, 2, 2, 2, 4, 3}; // proporciones de ancho por columna
        Table tabla = new Table(tamaniosColumnas);
        tabla.setWidth(UnitValue.createPercentValue(100));

        // Estilo de cabecera
        String[] headers = {"ID", "Cédula", "Nombre1", "Nombre2", "Apellido1", "Apellido2", "Dirección", "Email"};
        for (String encabezado : headers) {
            tabla.addHeaderCell(new Cell().add(new Paragraph(encabezado).setFontSize(9).setBold()));
        }

        // Agregar datos
        List<POJOEmpleado> listaPOJOEmpleado = empleadoControlador.obtenerTodosEmpleados();
        if (listaPOJOEmpleado != null) {
            for (POJOEmpleado empleado : listaPOJOEmpleado) {
                tabla.addCell(new Cell().add(new Paragraph(String.valueOf(empleado.getId_Empleado())).setFontSize(8)));
                tabla.addCell(new Cell().add(new Paragraph(empleado.getCedula()).setFontSize(8)));
                tabla.addCell(new Cell().add(new Paragraph(empleado.getNombre1()).setFontSize(8)));
                tabla.addCell(new Cell().add(new Paragraph(empleado.getNombre2()).setFontSize(8)));
                tabla.addCell(new Cell().add(new Paragraph(empleado.getApellido1()).setFontSize(8)));
                tabla.addCell(new Cell().add(new Paragraph(empleado.getApellido2()).setFontSize(8)));
                tabla.addCell(new Cell().add(new Paragraph(empleado.getDireccion()).setFontSize(8)));
                tabla.addCell(new Cell().add(new Paragraph(empleado.getEmail()).setFontSize(8)));
            }
        }

        documento.add(tabla);

        documento.add(new Paragraph("Notas: Reporte generado automáticamente desde el sistema.")
                .setFontSize(9)
                .setMarginTop(20));

        documento.close();
        JOptionPane.showMessageDialog(this, "Reporte PDF generado con éxito en: " + rutaCompleta, "Éxito", JOptionPane.INFORMATION_MESSAGE);

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
    public javax.swing.JTable jTableEmpleado;
    protected javax.swing.JTextField jTextFieldBuscar;
    private javax.swing.JPanel panelInferior;
    // End of variables declaration//GEN-END:variables
}
