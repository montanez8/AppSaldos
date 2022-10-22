package Appsaldos.datos;
import Appsaldos.dominio.cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class clienteDaoJDBc {

    private static final String SQL_SELECT = "select id_cliente, nombres, apellidos, email, telefono, saldo from db_saldos.cliente";
    private static final String SQL_SELECT_BY_ID = "select id_cliente,   nombres, apellidos, email, telefono, saldo from db_saldos.cliente where id_cliente=?";
    private static final String SQL_INSERT = "insert into db_saldos.cliente( nombres, apellidos, email, telefono, saldo) values (?,?,?,?,?)";
    private static final String SQL_UPDATE = "update db_saldos.cliente set nombres=?,apellidos=?,email=?,telefono=?,saldo=? where id_cliente=?";
    private static final String SQL_DELETE = "DELETE FROM db_saldos.cliente WHERE id_cliente=?";

    public List<cliente> getAll() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        cliente cliente;
        List<cliente> clientes = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareCall(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id_cliente = rs.getInt("id_cliente");
                String nombres = rs.getString("nombres");
                String apellidos = rs.getString("apellidos");
                String email = rs.getString("email");
                String telefono = rs.getString("telefono");
                double saldo = rs.getDouble("saldo");
                cliente = new cliente(id_cliente, nombres, apellidos, email, telefono, saldo);
                clientes.add(cliente);

            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);

        }
        return clientes;
    }
    //Metodo Mostrar por id :

    public cliente encontrar(cliente cliente){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_BY_ID);
            stmt.setInt(1, cliente.getId_cliente());
            rs = stmt.executeQuery();
            rs.absolute(1);
            String nombres = rs.getString("nombres");
            String apellidos = rs.getString("apellidos");
            String email = rs.getString("email");
            String telefono = rs.getString("telefono");
            double saldo = rs.getDouble("saldo");
            cliente.setNombres(nombres);
            cliente.setApellidos(apellidos);
            cliente.setEmail(email);
            cliente.setTelefono(telefono);
            cliente.setSaldo(saldo);
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return cliente;
    }

    


     //Metodo Insertar:
    
    public int insertar(cliente cliente) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareCall(SQL_INSERT);
            stmt.setString(1, cliente.getNombres());
            stmt.setString(2, cliente.getApellidos());
            stmt.setString(3, cliente.getEmail());
            stmt.setString(4, cliente.getTelefono());
            stmt.setDouble(5, cliente.getSaldo());

            rows = stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(System.out);
        } finally {
            Conexion.close(conn);
            Conexion.close(stmt);
        }
        return rows;

    }
    
    // Metodo eliminar

    public int eliminar(cliente cliente) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareCall(SQL_DELETE);
            stmt.setInt(1, cliente.getId_cliente());

            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;

    }
    
 //Metodo Actualizar
    public int actualizar(cliente cliente) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareCall(SQL_UPDATE);
            stmt.setString(1, cliente.getNombres());
            stmt.setString(2, cliente.getApellidos());
            stmt.setString(3, cliente.getEmail());
            stmt.setString(4, cliente.getTelefono());
            stmt.setDouble(5, cliente.getSaldo());
            stmt.setInt(6, cliente.getId_cliente());

            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;

    }

}
