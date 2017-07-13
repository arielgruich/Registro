/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package CapaServicio;

import CapaDatos.BCanal;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.Date;
import java.util.List;
import CapaDatos.*;
import CapaDatos.Resultado;
import CapaNegocio.*;

/**
 *
 * @author Ariel Luis Gruich Arratia
 */
@WebService(serviceName = "RegistroWS")
public class RegistroWS{

    /**
     * This is a sample web service operation
     */
    
    /**
     *Método para obtener la lista de la entidad Canal
     * @return 
     */
    @WebMethod(operationName = "ObtenerListaCompletaCanal")
    public List<BCanal> ObtenerListaCompletaCanal() {    
       GestorCanal gf= new GestorCanal();
       return gf.ObtenerListaCompletaCanal();
    }
    
    /**
     *Método para obtener la entidad Canal a traves de su identificador único
     * @param i
     * @return 
     */
    @WebMethod(operationName = "ObtenerCanalPorId")
    public BCanal ObtenerCanalPorId(@WebParam(name = "IdCanal")long i) {
        GestorCanal gf= new GestorCanal();
        return gf.ObtenerCanalPorId(i);
    }
    
    /**
     *Método para insertar la entidad Canal
     *@param NombreCanal
     *@param UsuarioBitacora     
     *@param RegistroBitacora
     *@return 
     */
    @WebMethod(operationName = "InsertarCanal")    
    public Resultado InsertarCanal( @WebParam(name = "NombreCanal") String NombreCanal, 
                                    @WebParam(name = "UsuarioBitacora") String UsuarioBitacora, 
                                    @WebParam(name = "RegistroBitacora") String RegistroBitacora
                                    ) 
    {        
        GestorCanal gf= new GestorCanal();
        return gf.InsertarCanal( NombreCanal, 
        UsuarioBitacora, RegistroBitacora);
    }
    
     /**
     *Método para modificar la entidad Canal
     *@param IdCanal
     *@param NombreCanal
     * @param UsuarioBitacora     
     * @param RegistroBitacora
     * @return 
     */
    @WebMethod(operationName = "ModificarCanal")
    public Resultado ModificarCanal( @WebParam(name = "IdCanal") Long IdCanal,
    @WebParam(name = "NombreCanal") String NombreCanal,
                                    @WebParam(name = "UsuarioBitacora") String UsuarioBitacora,                                       
                                    @WebParam(name = "RegistroBitacora") String RegistroBitacora
                                   ) 
    {
        GestorCanal gf= new GestorCanal();
        return gf.ModificarCanal( IdCanal, 
        NombreCanal, 
        UsuarioBitacora, RegistroBitacora);
    }
    
    /**
     *Método para eliminar la entidad Canal
     *@param IdCanal
     *@return 
    */
    @WebMethod(operationName = "EliminarCanal")
    public Resultado EliminarCanal(@WebParam(name = "IdCanal")Long IdCanal) 
    {
        GestorCanal gf= new GestorCanal();
        return gf.EliminarCanal(IdCanal);
    }     
     /*    
     */
        /**
     *Método para obtener la lista de la entidad Tipo
     * @return 
     */
    @WebMethod(operationName = "ObtenerListaCompletaTipo")
    public List<BTipo> ObtenerListaCompletaTipo() {    
        GestorTipo gf= new GestorTipo();
        return gf.ObtenerListaCompletaTipo();
    }
    
    /**
     *Método para obtener la entidad Tipo a traves de su identificador único
     * @param i
     * @return 
     */
    @WebMethod(operationName = "ObtenerTipoPorId")
    public BTipo ObtenerTipoPorId(@WebParam(name = "IdTipo")long i) {
        GestorTipo gf= new GestorTipo();
        return gf.ObtenerTipoPorId(i);
    }
    
    /**
     *Método para insertar la entidad Tipo
     *@param NombreTipo
     *@param UsuarioBitacora     
     *@param FechaBitacora
     *@param RegistroBitacora
     *@return 
     */
    @WebMethod(operationName = "InsertarTipo")    
    public Resultado InsertarTipo( @WebParam(name = "NombreTipo") String NombreTipo,
                                   @WebParam(name = "UsuarioBitacora") String UsuarioBitacora,                                    
                                   @WebParam(name = "FechaBitacora") Date FechaBitacora,  
                                   @WebParam(name = "RegistroBitacora") String RegistroBitacora
                                  ) 
    {        
        GestorTipo gf= new GestorTipo();
        return gf.InsertarTipo( NombreTipo, 
        UsuarioBitacora, FechaBitacora, RegistroBitacora);
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
    @WebMethod(operationName = "ModificarTipo")
    public Resultado ModificarTipo( @WebParam(name = "IdTipo") Long IdTipo,
                                    @WebParam(name = "NombreTipo") String NombreTipo,
                                    @WebParam(name = "UsuarioBitacora") String UsuarioBitacora,                                     
                                    @WebParam(name = "FechaBitacora") Date FechaBitacora,  
                                    @WebParam(name = "RegistroBitacora") String RegistroBitacora
                                  ) 
    {
        GestorTipo gf= new GestorTipo();
        return gf.ModificarTipo( IdTipo, 
        NombreTipo,  
        UsuarioBitacora, FechaBitacora, RegistroBitacora);
    }
    
    /**
     *Método para eliminar la entidad Tipo
     *@param IdTipo
     *@return 
    */
    @WebMethod(operationName = "EliminarTipo")
    public Resultado EliminarTipo(@WebParam(name = "IdTipo")Long IdTipo) 
    {
        GestorTipo gf= new GestorTipo();
        return gf.EliminarTipo(IdTipo);
    }
    
    /*
    ***************************************************************
    ********************Peticion***********************************
    ***************************************************************
    */
     /**
     *Método para obtener la lista de la entidad Peticion
     * @return 
     */
    @WebMethod(operationName = "ObtenerListaCompletaPeticion")
    public List<BPeticion> ObtenerListaCompletaPeticion() {    
        GestorPeticion gf= new GestorPeticion();
        return gf.ObtenerListaCompletaPeticion();
    }    
    /**
    *Método para obtener la entidad Peticion a traves de su identificador único
    * @param i
    * @return 
    */
    @WebMethod(operationName = "ObtenerPeticionPorId")
    public BPeticion ObtenerPeticionPorId(@WebParam(name = "IdPeticion")long i) {
        GestorPeticion gf= new GestorPeticion();
        return gf.ObtenerPeticionPorId(i);
    }
    
    /**
     *Método para insertar la entidad Peticion     
     *@param Nombre
     *@param Telefono1       
     *@param Canal
     *@param Tipo
     *@param UsuarioBitacora     
     *@param RegistroBitacora
     *@return 
     */
    @WebMethod(operationName = "InsertarPeticion")    
    public Resultado InsertarPeticion(            
            @WebParam(name = "Nombre") String Nombre,
            @WebParam(name = "Telefono1") String Telefono1, 
            @WebParam(name = "Canal") String Canal,
            @WebParam(name = "Tipo") String Tipo,
            @WebParam(name = "UsuarioBitacora") String UsuarioBitacora,             
            @WebParam(name = "FechaBitacora") Date FechaBitacora,  
            @WebParam(name = "RegistroBitacora") String RegistroBitacora
        ) 
    {        
        GestorPeticion gf= new GestorPeticion();
        return gf.InsertarPeticion( 
        Nombre, 
        Telefono1, 
        Canal, 
        Tipo, 
        UsuarioBitacora, FechaBitacora, RegistroBitacora);
    }
    
     /**
     *Método para modificar la entidad Peticion
     *@param IdPeticion     
     *@param Nombre
     *@param Telefono1  
     *@param Canal
     *@param Tipo
     *@param UsuarioBitacora     
     *@param RegistroBitacora
     *@return 
     */
    @WebMethod(operationName = "ModificarPeticion")
    public Resultado ModificarPeticion(
            @WebParam(name = "IdPeticion") Long IdPeticion,            
            @WebParam(name = "Nombre") String Nombre,
            @WebParam(name = "Telefono1") String Telefono1,            
            @WebParam(name = "Canal") String Canal,
            @WebParam(name = "Tipo") String Tipo,
            @WebParam(name = "UsuarioBitacora") String UsuarioBitacora, 
            @WebParam(name = "FechaBitacora") Date FechaBitacora,  
            @WebParam(name = "RegistroBitacora") String RegistroBitacora                                      
        ) 
    {
        GestorPeticion gf= new GestorPeticion();
        return gf.ModificarPeticion( IdPeticion,         
        Nombre, 
        Telefono1,         
        Canal, 
        Tipo, 
        UsuarioBitacora, FechaBitacora, RegistroBitacora);
    }
    
    /**
    *Método para eliminar la entidad Peticion
    *@param IdPeticion
    *@return 
    */
    @WebMethod(operationName = "EliminarPeticion")
    public Resultado EliminarPeticion(@WebParam(name = "IdPeticion")Long IdPeticion) 
    {
        GestorPeticion gf= new GestorPeticion();
        return gf.EliminarPeticion(IdPeticion);
    }     
    /*    
    */
}