package Appsaldos.datos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;

public class Conexion {
    private  static final String JDBC_URL="jdbc:mysql://localhost:3307/db_saldos?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    private  static final String JDBC_USER="root";
    private  static final String JDBC_PaASSWOR="arkan22";
    
private static BasicDataSource dataSource;

public static DataSource getDataSource(){
    if (dataSource==null) {
        dataSource= new BasicDataSource();
        dataSource.setUrl(JDBC_URL);
        dataSource.setUsername(JDBC_USER);
        dataSource.setPassword(JDBC_PaASSWOR);
        dataSource.setInitialSize(10);  
    } 
    return dataSource;
    }

public static Connection getConnection() throws SQLException{
    return getDataSource().getConnection();
}
   public static void close(ResultSet rs){
       try {
           rs.close();
       } catch (SQLException ex) {
           ex.printStackTrace(System.out);
       }
   } 
   public static void close(PreparedStatement stmt){
       try {
           stmt.close();
       } catch (SQLException ex) {
           ex.printStackTrace(System.out);
       }
   } 
   public static void close(Connection conn){
       try {
           conn.close();
       } catch (SQLException ex) {
           ex.printStackTrace(System.out);
       }
   } 
    
}
