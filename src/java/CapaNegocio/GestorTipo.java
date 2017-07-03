/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaNegocio;
import CapaDatos.BTipo;
import CapaDatos.Resultado;
import java.util.Date;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 * @author Christian Marbel Vega Mamani
 * @Gestor Tipo
 */
public class GestorTipo {
    //Se define la variable conexión
    private ConexionBD conexion;    
    /**
     *Método para obtener la lista de la entidad Tipo 
     * @return 
     */
    public List<BTipo> ObtenerListaCompletaTipo() {
        //Se instancia la lista de la entidad
        List<BTipo> lista = new ArrayList();
        try {
            //Se instancia la conexión a la Base de datos
            conexion = new ConexionBD();
            //Se declara la sentencia sql
            String sql = "SELECT * FROM public.tipo";
            //Se declara la variable de sentencia
            Statement consulta;
            //Se obtiene la conexión y se crea la declaración
            consulta = conexion.getConexion().createStatement();
            //Se ejecuta la sentencia
            ResultSet registro = consulta.executeQuery(sql);
            //Se recorre los componentes del resultado obtenido
            while (registro.next()) {
                BTipo e = new BTipo ();
                e.setIdTipo(registro.getLong("idtipo"));
                e.setNombreTipo(registro.getString("nombretipo"));
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
     *Método para obtener la entidad Tipo a traves de su identificador único
     * @param i
     * @return 
     */
     public BTipo ObtenerTipoPorId(long i) {
        //Se inicializa la entidad
        BTipo  e = null;
        try {
            //Se inicializa la entidad
            conexion = new ConexionBD();
            //Se ingresa la sentencia sql
            String sql = "SELECT * FROM public.tipo WHERE idtipo=?";
            //Se obtiene la conexión y se prepara la sentencia
            PreparedStatement consulta = conexion.getConexion().prepareStatement(sql);
            //Se asigna el valor a la consulta
            consulta.setLong(1, i);
            //Se ejecuta la sentencia sql
            ResultSet registro=consulta.executeQuery();
            //Se valida si existe un registro en el resultado
            if(registro.next()){
                e=new BTipo();
                e.setIdTipo(registro.getLong("idtipo"));
                e.setNombreTipo(registro.getString("nombretipo"));
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
     *Método para insertar la entidad Tipo
      *@param NombreTipo
     * @param UsuarioBitacora
     * @param FechaBitacora
     * @param RegistroBitacora
     * @return 
     */
        public Resultado InsertarTipo( String NombreTipo, String UsuarioBitacora, Date FechaBitacora,  String RegistroBitacora) 
        {        
        //Se instancia el objeto resultado
        Resultado vObjResultado= new Resultado();                
        //Se valida la entidad
        vObjResultado = this.ValidarEntidad
        (
            Long.parseLong("0"),
            NombreTipo, 
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
                String sql = "INSERT INTO public.tipo "
                    + "( nombretipo, usuario_bitacora,fecha_bitacora,registro_bitacora) VALUES ( ?,?,?,?)";
                //Se obtiene la conexión y se prepara la sentencia
                PreparedStatement consulta = conexion.getConexion().prepareStatement(sql);
            
                // Definiendo valores para ?
                java.sql.Date fecha = new java.sql.Date(FechaBitacora.getTime());
                consulta.setString(1,NombreTipo); 
                consulta.setString(2,UsuarioBitacora);
                consulta.setDate(3,fecha);
                consulta.setString(4,RegistroBitacora);

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
     *Método para modificar la entidad Tipo
     *@param IdTipo
     *@param NombreTipo
     *@param UsuarioBitacora
     *@param FechaBitacora
     *@param RegistroBitacora
     *@return 
     */
    public Resultado ModificarTipo( Long IdTipo, String NombreTipo, String UsuarioBitacora, Date FechaBitacora,  String RegistroBitacora) 
    {        
        //Se instancia el objeto resultado
        Resultado vObjResultado= new Resultado();                
        //Se valida la entidad
        vObjResultado = this.ValidarEntidad
            (
                IdTipo, 
                NombreTipo,  
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
                String sql = "UPDATE public.tipo SET "
                    + "nombretipo=?,usuario_bitacora=?,fecha_bitacora=?,registro_bitacora=? WHERE idtipo=?";
                //Se obtiene la conexión y se prepara la sentencia
                PreparedStatement consulta = conexion.getConexion().prepareStatement(sql);
            
                // Definiendo valores para ?
                java.sql.Date fecha = new java.sql.Date(FechaBitacora.getTime());
                consulta.setString(1,NombreTipo); 
                consulta.setString(2,UsuarioBitacora);
                consulta.setDate(3,fecha);
                consulta.setString(4,RegistroBitacora);
                consulta.setLong(5, IdTipo);

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
     *Método para eliminar la entidad Tipo
     * @param IdTipo
     * @return 
     */
    public Resultado EliminarTipo(Long IdTipo) 
    {
         //Se instancia el objeto resultado
        Resultado vObjResultado= new Resultado();
        
        //Se verifica que el identificador sea válido
        if(IdTipo>0)
        {
            //Se inicializa el objeto transacción
            try{
                //Se instancia la conexión a la Base de datos
                conexion = new ConexionBD();
                //Se ingresa la sentencia sql
                String sql = "DELETE FROM public.tipo WHERE idtipo=?";
                //Se obtiene la conexion y se prepara la sentencia
                PreparedStatement consulta = conexion.getConexion().prepareStatement(sql);
                //Asignación de valores a la consulta
                consulta.setLong(1, IdTipo);
                //Se ejecuta la consulta y se asigna el resultado
                int nroEliminados = consulta.executeUpdate();
                // Se cierra la conexión a la base de datos
                conexion.getConexion().close();
                // Se verifica si se realizó la eliminación
                if (nroEliminados > 0) {
                    System.out.println("Registro Eliminado :" + IdTipo);                    
                    // Se asigna al objeto el resultado obtenido
                    vObjResultado.setEsValido(true);
                    vObjResultado.setValido("true");
                    vObjResultado.setMensaje("La eliminación se realizó correctamente");
                    return vObjResultado;
                }else{
                    // Se asigna al objeto el resultado obtenido
                    vObjResultado.setMensaje("No existe Registro Nro. : "+IdTipo);
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
    private Resultado ValidarEntidad( Long IdTipo, String NombreTipo, String UsuarioBitacora, Date FechaBitacora,  String RegistroBitacora, boolean esInsertar)
    {
        // Predetermina valor de validación.
        Resultado pObjResultado = new Resultado();
        // Se inicializa el estado
        pObjResultado.setEsValido(true);
        //Se verifica que es un método insertar
        if(!esInsertar)
        {
            //Se valida el identificador de la entidad Fuente
            if(IdTipo<=0)
            {
                pObjResultado.setEsValido(false);
                pObjResultado.setMensaje("Se requiere el identificador de la entidad Tipo");
            }
        }
            
        //Se validan los parámetros de entrada obligatorios
        if(pObjResultado.EsValido()&&GeneralUtil.isNullOrEmpty(NombreTipo))
        { 
            pObjResultado.setEsValido(false); 
            pObjResultado.setMensaje("Ingrese porfavor el campo NombreTipo"); 
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