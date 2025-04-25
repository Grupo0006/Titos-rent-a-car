package DAO;

import Modelo.Detalle_Mantenimiento;
import Util.ConexionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAODetalle_Mantenimiento {

    public void crearDetalleMantenimiento(Detalle_Mantenimiento detalle) throws SQLException {
        String sql = """
        INSERT INTO Detalle_Mantenimiento (
            Mantenimiento,
            Id_Empleado,
            Id_Coche,
            Observaciones,
            Recomentaciones,
            PartesCambiadas
        ) VALUES (?, ?, ?, ?, ?, ?)
    """;

        try (Connection c = ConexionDB.getConnection(); PreparedStatement stmt = c.prepareStatement(sql)) {
            stmt.setInt(1, detalle.getIdMantenimiento());
            stmt.setInt(2, detalle.getIdEmpleado());
            stmt.setInt(3, detalle.getIdCoche());
            stmt.setString(4, detalle.getObservaciones());
            stmt.setString(5, detalle.getRecomendaciones());
            stmt.setString(6, detalle.getPartesCambiadas());
            stmt.executeUpdate();
        }
    }

    public Detalle_Mantenimiento leerDetallePorId(int idDetalle) throws SQLException {
        String sql = "SELECT * FROM Detalle_Mantenimiento WHERE DetalleMantenimiento = ?";
        Detalle_Mantenimiento detalle = null;

        try (Connection c = ConexionDB.getConnection(); PreparedStatement stmt = c.prepareStatement(sql)) {
            stmt.setInt(1, idDetalle);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                detalle = new Detalle_Mantenimiento();
                detalle.setIdDetalleMantenimiento(rs.getInt("DetalleMantenimiento"));
                detalle.setIdMantenimiento(rs.getInt("Mantenimiento"));
                detalle.setIdEmpleado(rs.getInt("Id_Empleado"));
                detalle.setIdCoche(rs.getInt("Id_Coche"));
                detalle.setObservaciones(rs.getString("Observaciones"));
                detalle.setRecomendaciones(rs.getString("Recomentaciones"));
                detalle.setPartesCambiadas(rs.getString("PartesCambiadas"));
            }
        }

        return detalle;
    }

    public void actualizarDetalleMantenimiento(Detalle_Mantenimiento detalle) throws SQLException {
        String sql = """
        UPDATE Detalle_Mantenimiento SET
            Mantenimiento = ?,
            Id_Empleado = ?,
            Id_Coche = ?,
            Observaciones = ?,
            Recomentaciones = ?,
            PartesCambiadas = ?
        WHERE DetalleMantenimiento = ?
    """;

        try (Connection c = ConexionDB.getConnection(); PreparedStatement stmt = c.prepareStatement(sql)) {
            stmt.setInt(1, detalle.getIdMantenimiento());
            stmt.setInt(2, detalle.getIdEmpleado());
            stmt.setInt(3, detalle.getIdCoche());
            stmt.setString(4, detalle.getObservaciones());
            stmt.setString(5, detalle.getRecomendaciones());
            stmt.setString(6, detalle.getPartesCambiadas());
            stmt.setInt(7, detalle.getIdDetalleMantenimiento());
            stmt.executeUpdate();
        }
    }

    public void eliminarDetalleMantenimiento(int idDetalle) throws SQLException {
        String sql = "DELETE FROM Detalle_Mantenimiento WHERE DetalleMantenimiento = ?";

        try (Connection c = ConexionDB.getConnection(); PreparedStatement stmt = c.prepareStatement(sql)) {
            stmt.setInt(1, idDetalle);
            stmt.executeUpdate();
        }
    }

    public static void main(String[] args) {
        try {
            DAODetalle_Mantenimiento dao = new DAODetalle_Mantenimiento();

            // Crear un nuevo detalle de mantenimiento
            Detalle_Mantenimiento nuevo = new Detalle_Mantenimiento();
            nuevo.setIdMantenimiento(1);
            nuevo.setIdEmpleado(101);
            nuevo.setIdCoche(202);
            nuevo.setObservaciones("Se realizó cambio de aceite.");
            nuevo.setRecomendaciones("Revisar cada 3 meses.");
            nuevo.setPartesCambiadas("Filtro de aceite, aceite");
            dao.crearDetalleMantenimiento(nuevo);
            System.out.println("Detalle de mantenimiento creado.");

            // Leer detalle por ID
            Detalle_Mantenimiento detalle = dao.leerDetallePorId(1); // ID de ejemplo
            if (detalle != null) {
                System.out.println("\nDetalle leído:");
                System.out.println("Empleado: " + detalle.getIdEmpleado());
                System.out.println("Coche: " + detalle.getIdCoche());
                System.out.println("Observaciones: " + detalle.getObservaciones());
            } else {
                System.out.println("Detalle no encontrado.");
            }

            // Actualizar detalle
            detalle.setObservaciones("Se reemplazaron frenos y se hizo cambio de aceite.");
            dao.actualizarDetalleMantenimiento(detalle);
            System.out.println("Detalle actualizado.");

            // Eliminar detalle (usa el ID del detalle leído)
            dao.eliminarDetalleMantenimiento(detalle.getIdDetalleMantenimiento());
            System.out.println("Detalle eliminado.");

        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

}
