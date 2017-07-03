
package CapaNegocio;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Christian Marbel Vega Mamani
 */
public class ConexionBD {    
    //Se declara variable privada conexion
    private Connection conexion;    
    public ConexionBD()
    {
        try{
            //Se establece el driver
            Class.forName("org.postgresql.Driver");
            //Se establece la cadena de conexion a la base de datos
            conexion = DriverManager.getConnection("jdbc:postgresql://localhost:5432/registro", "registro", "registro");            
        }catch (ClassNotFoundException ex){
            //Se imprime el error generado
            System.out.println("Error en el Driver :" + ex);                        
        }catch (SQLException ex){
            //Se imprime el error generado
            System.out.println("Error en la Conexion :" + ex);            
        }
    }    
    //Se define constuctor
    public Connection getConexion() {
        return conexion;
    }    
    //Set de la variable conexion
    public void setConexion(Connection conexion) {
        this.conexion = conexion;
    }    
}