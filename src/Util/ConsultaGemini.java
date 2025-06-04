
package Util;

import okhttp3.*;
import org.json.JSONObject;
/**
 *
 * @author Maryi 
 */
public class ConsultaGemini {
    private static final String API_URL = "https://generativelanguage.googleapis.com/v1beta/models/gemini-1.5-flash:generateContent";
    private static final String API_KEY = "AIzaSyDtPmNVQ5EUgRkYZ0dVsEceqAQh7AHwFqs"; // Reemplaza con tu clave de API de Gemini

    public String generarConsultaSQL(String consultaNatural, String esquemaBD) throws Exception {
        OkHttpClient client = new OkHttpClient();
        String prompt = """
            Genera una consulta SQL válida para una base de datos MySQL con las siguientes tablas y relaciones:
            %s
            Instrucciones:
            - Usa solo las columnas listadas en cada tabla.
            - Respeta el orden de los atributos de cada tabla según el esquemade la base de datos.
            - Asegúrate de que los JOINs sean correctos y utilicen las claves foráneas especificadas.
            - Si se solicita información de múltiples tablas, usa JOINs explícitos.
            - No generes subconsultas complejas ni funciones avanzadas a menos que sean explícitamente solicitadas.
            - Devuelve la consulta SQL en una sola línea, sin saltos de línea, comillas triples, ni formato adicional.
            Pregunta del usuario: "%s"
            """.formatted(esquemaBD, consultaNatural);

        JSONObject json = new JSONObject();
        json.put("contents", new JSONObject().put("parts", new JSONObject().put("text", prompt)));
        json.put("generationConfig", new JSONObject().put("response_mime_type", "text/plain"));

        RequestBody body = RequestBody.create(json.toString(), MediaType.parse("application/json"));
        Request request = new Request.Builder()
                .url(API_URL + "?key=" + API_KEY)
                .post(body)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                throw new Exception("Error en la solicitud a Gemini: " + response.code());
            }
            String respuesta = response.body().string();
            return new JSONObject(respuesta).getJSONArray("candidates")
                    .getJSONObject(0)
                    .getJSONObject("content")
                    .getJSONArray("parts")
                    .getJSONObject(0)
                    .getString("text");
        }
    }

    // Método para obtener el esquema de la base de datos
    public String obtenerEsquemaBD() {
        return """
            Tabla Cliente (
                Id_Cliente INT PRIMARY KEY AUTO_INCREMENT,
                Cedula VARCHAR (16) NOT NULL,
                Nombre1 VARCHAR(50) NOT NULL,
                Nombre2 varchar(50) not null,
                Apellido1 varchar(50) not null,
                Apellido2 VARCHAR(50),
                Telefono VARCHAR(8) NOT NULL,
                Direccion TEXT NOT NULL,
                Email VARCHAR(100) UNIQUE,
                Licencia VARCHAR (8)
            );
            
            Tabla Empleado (
                Id_Empleado INT PRIMARY KEY AUTO_INCREMENT,
                Cedula VARCHAR (16) NOT NULL,
                Nombre1 VARCHAR(50) NOT NULL,
                Nombre2 varchar(50) not null,
                Apellido1 VARCHAR(50) NOT NULL,
                Apellido2 varchar(50),
                Direccion VARCHAR(150) NOT NULL,
                Email VARCHAR(150) UNIQUE
            );
            
            Tabla Coche
            CREATE TABLE Coche (
                Id_Coche INT PRIMARY KEY AUTO_INCREMENT,
                Marca VARCHAR(50) NOT NULL,
                Modelo VARCHAR(20) NOT NULL,
                Anio INT NOT NULL,
                Placa VARCHAR (7),
                Color VARCHAR (50),
                Fecha_Registro DATE,
                Estado text
            );
            
            Tabla Alquiler
            CREATE TABLE Alquiler (
                Id_Alquiler INT PRIMARY KEY AUTO_INCREMENT,
                Fecha_Inicio DATETime NOT NULL,
                Fecha_Fin DATETime NOT NULL
            );
            
            Tabla Detalle_Alquiler
            CREATE TABLE Detalle_Alquiler (
                Id_Detalle_Alquiler INT PRIMARY KEY AUTO_INCREMENT,
                Id_Alquiler INT,
                Id_Coche INT,
                Id_Cliente INT,
                Precio_Total DECIMAL(10,2) NOT NULL,
                FOREIGN KEY (Id_Alquiler) REFERENCES Alquiler(Id_Alquiler) ON DELETE CASCADE,
                FOREIGN KEY (Id_Coche) REFERENCES Coche(Id_Coche) ON DELETE CASCADE,
                FOREIGN KEY (Id_Cliente) REFERENCES Cliente(Id_Cliente) ON DELETE CASCADE
            );
            
            Tabla Mantenimiento de Coche
            CREATE TABLE Mantenimiento (
                Id_Mantenimiento INT PRIMARY KEY AUTO_INCREMENT,
                Descripcion TEXT NOT NULL,
                Justificacion TEXT NOT NULL,
                Fecha_Inicio DATETIME NOT NULL,
                Fecha_Fin DATETIME NOT NULL,
                Costo DECIMAL(10,2) NOT NULL
            );
            
            Tabla Detalle_Mantenimiento (
            	Id_Detalle_Mantenimiento INT PRIMARY KEY AUTO_INCREMENT,
                Id_Mantenimiento INT,
                Id_Empleado INT,
                Id_Coche INT,
                Observaciones TEXT,
                Recomendaciones TEXT,
                Partes_Cambiadas text,
                FOREIGN KEY (Id_Mantenimiento) REFERENCES Mantenimiento(Id_Mantenimiento),
                FOREIGN KEY (Id_Empleado) REFERENCES Empleado(Id_Empleado),
                FOREIGN KEY (Id_Coche) REFERENCES Coche(Id_Coche)
            );
            """;
    }

    // Validación de consultas SQL
    public boolean esConsultaSegura(String sql) {
        String consulta = sql.toLowerCase().trim();
        return consulta.startsWith("select") &&
               !consulta.contains("drop") &&
               !consulta.contains("update") &&
               !consulta.contains("insert");
    }

}
