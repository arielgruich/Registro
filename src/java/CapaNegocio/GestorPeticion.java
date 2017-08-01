package CapaNegocio;
import CapaDatos.BPeticion;
import CapaDatos.Resultado;
import java.util.Date;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 * @author Ariel Luis Gruich Arratia
 * @Gestor Peticion
 */
public class GestorPeticion {
//Se define la variable conexión
    private ConexionBD conexion;
    java.sql.Date fecha;
    /**
     *Método para obtener la lista de la entidad Peticion 
     * @return 
     */
    public List<BPeticion> ObtenerListaCompletaPeticion() {
        //Se instancia la lista de la entidad
        List<BPeticion> lista = new ArrayList();
        try {
            //Se instancia la conexión a la Base de datos
            conexion = new ConexionBD();
            //Se declara la sentencia sql
            String sql = "SELECT * FROM public.peticion ORDER BY IdPeticion";
            //Se declara la variable de sentencia
            Statement consulta;
            //Se obtiene la conexión y se crea la declaración
            consulta = conexion.getConexion().createStatement();
            //Se ejecuta la sentencia
            ResultSet registro = consulta.executeQuery(sql);
            //Se recorre los componentes del resultado obtenido
            while (registro.next()) {
                BPeticion e = new BPeticion ();
                e.setIdPeticion(registro.getLong("idpeticion"));                
                e.setNombre(registro.getString("nombre"));
                e.setTelefono1(registro.getString("telefono1"));                
                e.setCanal(registro.getString("canal"));
                e.setTipo(registro.getString("tipo"));
                e.setCanal(registro.getString("accion"));
                e.setCanal(registro.getString("departamento"));
                e.setCanal(registro.getString("observaciones"));
                e.setUsuarioBitacora(registro.getString("usuario_bitacora"));
                e.setFechaBitacora(registro.getDate("fecha_bitacora"));
                e.setRegistroBitacora(registro.getString("registro_bitacora"));                
                lista.add(e);
            }
            // Se cierra la conexión a la base de datos
            conexion.getConexion().close();
        } catch (SQLException ex) {
            //Se despliega el error
            System.out.println("Error al listar: " + ex);
        }
        return lista;
    }
        
    /**
     *Método para obtener la entidad Peticion a traves de su identificador único
     * @param i
     * @return 
     */
    public BPeticion ObtenerPeticionPorId(long i) {
        //Se inicializa la entidad
        BPeticion  e = null;
        try {
            //Se inicializa la entidad
            conexion = new ConexionBD();
            //Se ingresa la sentencia sql
            String sql = "SELECT * FROM public.peticion WHERE idpeticion=?";
            //Se obtiene la conexión y se prepara la sentencia
            PreparedStatement consulta = conexion.getConexion().prepareStatement(sql);
            //Se asigna el valor a la consulta
            consulta.setLong(1, i);
            //Se ejecuta la sentencia sql
            ResultSet registro=consulta.executeQuery();
            //Se valida si existe un registro en el resultado
            if(registro.next()){
                e=new BPeticion();
                e.setIdPeticion(registro.getLong("idpeticion"));                
                e.setNombre(registro.getString("nombre"));
                e.setTelefono1(registro.getString("telefono1"));                
                e.setCanal(registro.getString("canal"));
                e.setTipo(registro.getString("tipo"));
                e.setCanal(registro.getString("accion"));
                e.setCanal(registro.getString("departamento"));
                e.setCanal(registro.getString("observaciones"));
                e.setUsuarioBitacora(registro.getString("usuario_bitacora"));
                e.setFechaBitacora(registro.getDate("fecha_bitacora"));
                e.setRegistroBitacora(registro.getString("registro_bitacora"));
            }
            // Se cierra la conexión a la base de datos
            conexion.getConexion().close();
        } catch (SQLException ex) {
            //Se despliega el error
            System.out.println("Error al buscar: "+ex);
        }
        return e;         
    }
     
    /**
     *Método para insertar la entidad Peticion     
     *@param Nombre
     *@param Telefono1     
     *@param Canal
     *@param Tipo
     *@param Accion
     *@param Departamento
     *@param Observaciones
     *@param UsuarioBitacora
     *@param FechaBitacora
     *@param RegistroBitacora
     *@return 
     */
    public Resultado InsertarPeticion( String Nombre, String Telefono1, String Canal, String Tipo, String Accion, String Departamento, String Observaciones, String UsuarioBitacora, Date FechaBitacora,  String RegistroBitacora) 
    {       
        //Se instancia el objeto resultado
        Resultado vObjResultado= new Resultado();                
        //Se valida la entidad
        vObjResultado = this.ValidarEntidad
        (
            Long.parseLong("0"),
            Nombre, 
            Telefono1,             
            Canal, 
            Tipo,
            Accion,
            Departamento,
            Observaciones,
            UsuarioBitacora, 
            FechaBitacora, 
            RegistroBitacora,
            true
        );
            
        //Se verifica que el resultado sea válido
        if(vObjResultado.EsValido())
        {
            try{
                //Se instancia la conexión a la Base de datos
                conexion = new ConexionBD();
                //Se ingresa la sentencia sql
                String sql = "INSERT INTO public.peticion "
                    + "( nombre,  telefono1,  canal,  tipo, accion, departamento, observaciones, usuario_bitacora,fecha_bitacora,registro_bitacora) VALUES ( ?, ?, ?, ?, ?, ?,?,?,?,?)";
                //Se obtiene la conexión y se prepara la sentencia
                PreparedStatement consulta = conexion.getConexion().prepareStatement(sql);
                // Definiendo valores para ?                
                Date dat = new Date();  
                java.sql.Date fecha = new java.sql.Date(dat.getTime());
                
                consulta.setString(1,Nombre); 
                consulta.setString(2,Telefono1);                 
                consulta.setString(3,Canal); 
                consulta.setString(4,Tipo); 
                consulta.setString(5,Accion);
                consulta.setString(6,Departamento);
                consulta.setString(7,Observaciones);
                consulta.setString(8,UsuarioBitacora);
                consulta.setDate(9,fecha);
                consulta.setString(10,RegistroBitacora);            
                // Ejecutando consulta
                consulta.executeUpdate();            
                // Se cierra la conexión a la base de datos
                conexion.getConexion().close();                    
                // Se asigna al objeto el resultado obtenido
                vObjResultado.setEsValido(true);
                vObjResultado.setValido("true");
                vObjResultado.setMensaje("La inserción se realizó correctamente");
            } catch (Exception e){            
                // Se asigna al objeto el resultado obtenido
                vObjResultado.setMensaje("-"+e);
                vObjResultado.setEsValido(false);
                vObjResultado.setValido("false");
            }             
        }
        //Se retorna el resultado
        return vObjResultado;         
        }        
    /**
     *Método para modificar la entidad Peticion
     *@param IdPeticion
     *@param Nombre
     *@param Telefono1
     *@param Canal
     *@param Tipo
     *@param Accion
     *@param Departamento
     *@param Observaciones
     *@param UsuarioBitacora
     *@param FechaBitacora
     *@param RegistroBitacora
     *@return 
     */
    public Resultado ModificarPeticion( Long IdPeticion, String Nombre, String Telefono1, String Canal, String Tipo, String Accion, String Departamento, String Observaciones, String UsuarioBitacora, Date FechaBitacora,  String RegistroBitacora) 
    {        
        //Se instancia el objeto resultado
        Resultado vObjResultado= new Resultado();                
        //Se valida la entidad
        vObjResultado = this.ValidarEntidad
            (
                IdPeticion,
                Nombre, 
                Telefono1, 
                Canal, 
                Tipo, 
                Accion,
                Departamento,
                Observaciones,
                UsuarioBitacora, 
                FechaBitacora, 
                RegistroBitacora,
                false
            );
            
        //Se verifica que el resultado sea válido
        if(vObjResultado.EsValido())
        {
            try{
                //Se instancia la conexión a la Base de datos
                conexion = new ConexionBD();
                //Se ingresa la sentencia sql
                String sql = "UPDATE public.peticion SET "
                    + "nombre=?,telefono1=?,canal=?,tipo=?,accion=?,departamento=?,observaciones=?,usuario_bitacora=?,fecha_bitacora=?,registro_bitacora=? WHERE idpeticion=?";
                  
                //Se obtiene la conexión y se prepara la sentencia
                PreparedStatement consulta = conexion.getConexion().prepareStatement(sql);
            
                // Definiendo valores para ?
            Date dat = new Date();  
            java.sql.Date fecha = new java.sql.Date(dat.getTime());            
            consulta.setString(1,Nombre); 
            consulta.setString(2,Telefono1);             
            consulta.setString(3,Canal); 
            consulta.setString(4,Tipo); 
            consulta.setString(5,Accion);
            consulta.setString(6,Departamento);
            consulta.setString(7,Observaciones);
            consulta.setString(8,UsuarioBitacora);
            consulta.setDate(9,fecha);
            consulta.setString(10,RegistroBitacora);
            consulta.setLong(11, IdPeticion);            
            // Ejecutando consulta
            consulta.executeUpdate();            
            // Se cierra la conexión a la base de datos
            conexion.getConexion().close();                    
            // Se asigna al objeto el resultado obtenido
            vObjResultado.setEsValido(true);
            vObjResultado.setValido("true");
            vObjResultado.setMensaje("La modificación se realizó correctamente");
            } catch (Exception e){            
                // Se asigna al objeto el resultado obtenido
                vObjResultado.setMensaje("-"+e);
                vObjResultado.setEsValido(false);
                vObjResultado.setValido("false");
            }             
        }
        //Se retorna el resultado
        return vObjResultado;         
    }
    
    /**
     *Método para eliminar la entidad Peticion
     * @param IdPeticion
     * @return 
     */
    public Resultado EliminarPeticion(Long IdPeticion) 
    {
        //Se instancia el objeto resultado
        Resultado vObjResultado= new Resultado();        
        //Se verifica que el identificador sea válido
        if(IdPeticion>0)
        {
            //Se inicializa el objeto transacción
            try{
                //Se instancia la conexión a la Base de datos
                conexion = new ConexionBD();
                //Se ingresa la sentencia sql
                String sql = "DELETE FROM public.peticion WHERE idpeticion=?";
                //Se obtiene la conexion y se prepara la sentencia
                PreparedStatement consulta = conexion.getConexion().prepareStatement(sql);
                //Asignación de valores a la consulta
                consulta.setLong(1, IdPeticion);
                //Se ejecuta la consulta y se asigna el resultado
                int nroEliminados = consulta.executeUpdate();
                // Se cierra la conexión a la base de datos
                conexion.getConexion().close();
                // Se verifica si se realizó la eliminación
                if (nroEliminados > 0) {
                    System.out.println("Registro Eliminado :" + IdPeticion);                    
                    //Se asigna al objeto el resultado obtenido
                    vObjResultado.setEsValido(true);
                    vObjResultado.setValido("true");
                    vObjResultado.setMensaje("La eliminación se realizó correctamente");
                    return vObjResultado;
                }else{
                    // Se asigna al objeto el resultado obtenido
                    vObjResultado.setMensaje("No existe Registro Nro. : "+IdPeticion);
                    vObjResultado.setEsValido(false);
                    vObjResultado.setValido("false");
                }
            } 
            catch (Exception e)
            {
                // Se asigna al objeto el resultado obtenido
                vObjResultado.setMensaje("-"+e);
                vObjResultado.setEsValido(false);
                vObjResultado.setValido("false");                
            }
        }
        else
        {
            // Se asigna al objeto el resultado obtenido
            vObjResultado.setEsValido(false);
            vObjResultado.setMensaje("Identificador de entidad no valido");
            vObjResultado.setValido("false");
        }        
        //Se retorna la entidad
        return vObjResultado;
    }
    private Resultado ValidarEntidad( Long IdPeticion, String Nombre, String Telefono1, String Canal, String Tipo, String Accion, String Departamento, String Observaciones, String UsuarioBitacora, Date FechaBitacora,  String RegistroBitacora, boolean esInsertar) {
            // Predetermina valor de validación.
            Resultado pObjResultado = new Resultado();
            // Se inicializa el estado
            pObjResultado.setEsValido(true);
            //Se verifica que es un método insertar
            if(!esInsertar)
            {
                //Se valida el identificador de la entidad Fuente
                if(IdPeticion<=0)
                {
                    pObjResultado.setEsValido(false);
                    pObjResultado.setMensaje("Se requiere el identificador de la entidad Peticion");
                }
            }
            
            if(pObjResultado.EsValido()&&GeneralUtil.isNullOrEmpty(Canal)){ 
                pObjResultado.setEsValido(false); 
                pObjResultado.setMensaje("Ingrese porfavor el campo Canal"); 
            } 
            if(pObjResultado.EsValido()&&GeneralUtil.isNullOrEmpty(Tipo)){ 
                pObjResultado.setEsValido(false); 
                pObjResultado.setMensaje("Ingrese porfavor el campo Tipo"); 
            } 
    
             else if(pObjResultado.EsValido()&& GeneralUtil.isNullOrEmpty(UsuarioBitacora))
            {
            // Se asigna al objeto el resultado obtenido
                 pObjResultado.setEsValido(false);
                 pObjResultado.setMensaje("Se requiere usuario bitacora");
            }
            else if(pObjResultado.EsValido()&& GeneralUtil.isNullOrEmpty(RegistroBitacora))
            {
            // Se asigna al objeto el resultado obtenido
                pObjResultado.setEsValido(false);
                pObjResultado.setMensaje("Se requiere registro bitacora");
            }
            //Se retorna el resultado
            return pObjResultado;
     }
}