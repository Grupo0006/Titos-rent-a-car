package Vista.Coche;

// Creamos importaciones necesarios para el codigo
// Importaciones necesarias para el funcionamiento de la clase
import Controlador.CocheControlador;          // Importa la clase del controlador que maneja la lógica de los coches
import Modelo.Coche;                          // Importa la clase del modelo que representa a un coche
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
import javax.swing.table.DefaultTableModel;   // Importa el modelo de tabla por defecto para manejar datos en tablas


/**
 *
 * @author Ernesto José Sevilla Inglés
 */
public class VistaCoche extends javax.swing.JPanel {

    // inicializa vaiable del cocheControlador
    private final CocheControlador cocheControlador;

    /**
     * Creates new form VistaCoche
     */
    public VistaCoche() {

        initComponents();
        this.cocheControlador = new CocheControlador();

        // Llama al metodo cargar datos de tabla
        cargarDatosTabla();

        // carga metodo para mostrar la fecha actual
        mostrarFechaActual();

        // Define formato de la tabla
        jTableCoches.getTableHeader().setFont(
                new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 30));

        // Llama al metodo para ajustar las columnas
        ajustarAnchoColumnas(jTableCoches);

        // Manda tamaño de las filas
        jTableCoches.setRowHeight(40);

        // Crear un renderizador para centrar los encabezados
        DefaultTableCellRenderer headerRenderer = (DefaultTableCellRenderer) jTableCoches.getTableHeader().getDefaultRenderer();
        headerRenderer.setHorizontalAlignment(SwingConstants.CENTER);

        // Crear un renderizado para centrar los contenidos de la tabla
        DefaultTableCellRenderer centrado = new DefaultTableCellRenderer();
        centrado.setHorizontalAlignment(SwingConstants.CENTER);

        // Aplicar a todas las columnas
        for (int i = 0; i < jTableCoches.getColumnCount(); i++) {
            // obtiene cada columna y aplica el formato de centrado
            jTableCoches.getColumnModel().getColumn(i).setCellRenderer(centrado);
        }

        // muestra las lineas divisoras de la tabla
        jTableCoches.setShowGrid(true);
        // Les asigna un color a las lineas divisoras
        jTableCoches.setGridColor(Color.gray);

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
        cocheFormulario formulario = new cocheFormulario(parentFrame, true, this); // Da error si agrego el this

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
    public Coche obtenerCocheSeleccionado() {
        // Declaramos variable para definir la condicion
        int fila = jTableCoches.getSelectedRow();
        // la codicion se ejecuta si la fila no es null es decir que hallan datos validos
        if (fila != -1) {
            /*
            Crea un nuevo objecto para proceder a obtener los valores de cada fila
             */
            Coche coche = new Coche();
            coche.setId_Coche((int) jTableCoches.getValueAt(fila, 0));
            coche.setMarca((String) jTableCoches.getValueAt(fila, 1));
            coche.setModelo((String) jTableCoches.getValueAt(fila, 2));
            coche.setPlaca((String) jTableCoches.getValueAt(fila, 3));
            coche.setColor((String) jTableCoches.getValueAt(fila, 4));
            coche.setEstado((String) jTableCoches.getValueAt(fila, 5));
            coche.setAnio((int) jTableCoches.getValueAt(fila, 6));
            String fechaTexto = (String) jTableCoches.getValueAt(fila, 7);

            // Se define elformato de la fecha
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");

            // Creamos try catch para comvertir la fechaTexto a fecha sql
            try {
                Date FechaRegistro = new Date(formato.parse(fechaTexto).getTime());
                coche.setFecha_Registro(FechaRegistro);
            } catch (ParseException e) {
                e.printStackTrace();
                coche.setFecha_Registro(null);
            }
            // Retorna un coche creado
            return coche;
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
        for (int col = 0; col < tabla.getColumnCount(); col++) {
            // Obtiene la columna actual del modelo de columnas de la tabla tomando como refencia a col
            TableColumn columna = tabla.getColumnModel().getColumn(col);

            // Mínimo ancho base
            int ancho = 15;

            // Recorre todas las filas de la tabla para esta columna
            for (int fila = 0; fila < tabla.getRowCount(); fila++) {
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

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 50)); // NOI18N
        jLabel1.setText("Coches");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 1139, Short.MAX_VALUE)
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

        jTableCoches.setBackground(new java.awt.Color(244, 233, 205));
        jTableCoches.setFont(new java.awt.Font("Segoe UI", 0, 30)); // NOI18N
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
        jButtonAgregar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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
                .addGap(28, 28, 28)
                .addComponent(jTextFieldBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 593, Short.MAX_VALUE)
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
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1456, Short.MAX_VALUE)
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

    private void jButtonAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAgregarActionPerformed
        // Llamamos metodo
        mostrarFormulario();
    }//GEN-LAST:event_jButtonAgregarActionPerformed

    private void jTableCochesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableCochesMouseClicked
        // Define una condicion de 2 clics para ejecutar
        if (evt.getClickCount() >= 2) {
            // Declara una vaiable de tipo entero como referencia
            int filaSeleccionada = jTableCoches.getSelectedRow();
            // Define condicion para verificar si la fila seleccionada es positivo
            if (filaSeleccionada != -1) {

                // Obtener los valores de la fila seleccionada
                int idCoche = (int) jTableCoches.getValueAt(filaSeleccionada, 0); // Id_Coche
                String marca = (String) jTableCoches.getValueAt(filaSeleccionada, 1); // Marca
                String modelo = (String) jTableCoches.getValueAt(filaSeleccionada, 2); // Modelo
                int anio = (int) jTableCoches.getValueAt(filaSeleccionada, 3); // Anio
                String placa = (String) jTableCoches.getValueAt(filaSeleccionada, 4); // Placa
                String color = (String) jTableCoches.getValueAt(filaSeleccionada, 5); // Color
                java.util.Date fechaRegistro = (java.util.Date) jTableCoches.getValueAt(filaSeleccionada, 6); // Fecha_Registro
                String estado = (String) jTableCoches.getValueAt(filaSeleccionada, 7); // Estado

                //Creamos objecto para mandar a llamar metodo de cargar datos en los jTextField
                Frame parentFrame = JOptionPane.getFrameForComponent(this);
                cocheFormulario formulario = new cocheFormulario(parentFrame, true, this);

                // Solo si no está visible aún, aplicar undecorated (evita error) en ejecución
                if (!formulario.isDisplayable()) {
                    formulario.setUndecorated(true);
                }
                //Llamamos metodo cargarDatosJTextFIeld
                formulario.cargarDatosJTextField(idCoche, marca, modelo, anio, placa, color, estado, fechaRegistro);

                formulario.setLocationRelativeTo(parentFrame); //Centramos la ventana
                formulario.setVisible(true); // Mostramos formulario
            }
        }
    }//GEN-LAST:event_jTableCochesMouseClicked

    private void jTextFieldBuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldBuscarKeyTyped
        // Declara variable y crea una lista de coches de la base de datos
        // Nota: trim elimina los espacios al inicio y al final y toLowerCase comverte todo a minusculas
        String textoBusqueda = jTextFieldBuscar.getText().trim().toLowerCase();
        CocheControlador controlador = new CocheControlador();
        List<Coche> coches = controlador.obtenerTodosCoches();
        // Obtiene los modelos de datos de la tabla coches
        DefaultTableModel modelo = (DefaultTableModel) jTableCoches.getModel();
        // Elimina las filas que no coinciden
        modelo.setRowCount(0);

        // Creamos condicion para verificar si coches no es null
        if (coches != null) {
            for (Coche coc : coches) {
                // Define la condicion para realizar busquedas verificando que la barra de busqyeda no quede vacia 
                if (textoBusqueda.isEmpty() || coc.getMarca().toLowerCase().contains(textoBusqueda)
                        || coc.getModelo().toLowerCase().contains(textoBusqueda)
                        || coc.getColor().toLowerCase().contains(textoBusqueda)
                        || coc.getEstado().toLowerCase().contains(textoBusqueda)
                        || coc.getPlaca().toLowerCase().contains(textoBusqueda)) {
                    // Creamos arreglos si la condicion de cumple para mostrar las filas que coinciden
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
                    // Agrega la fila con los valores
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
    private javax.swing.JButton jButtonAgregar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable jTableCoches;
    protected javax.swing.JTextField jTextFieldBuscar;
    private javax.swing.JPanel panelInferior;
    // End of variables declaration//GEN-END:variables
}
