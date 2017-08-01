package CapaDatos;
import java.sql.SQLException;
import java.util.Date;
/**
 * @author Ariel Luis Gruich Arratia * 
 *Entidad Peticion
 */
public class BPeticion implements java.io.Serializable {    
    // Declaración de los atributos de la entidad
    private Long IdPeticion;
    private String Nombre;
    private String Telefono1;    
    private String Canal;
    private String Tipo;
    private String Accion;
    private String Departamento;
    private String Observaciones;
    private String UsuarioBitacora; 
    private Date FechaBitacora; 
    private String RegistroBitacora;
    
    @Override
    public int hashCode()
    {
        return Long.hashCode(IdPeticion);
    }
     
    // Se crea el constructor de la clase
    public BPeticion() {
    }
    public BPeticion ( Long idPeticion, String nombre, String telefono1, String canal, String tipo, String accion, String departamento, String observaciones, String usuarioBitacora, Date fechaBitacora, String registroBitacora) 
    {
        this.IdPeticion = idPeticion;
        this.Nombre = nombre;
        this.Telefono1 = telefono1;        
        this.Canal = canal;
        this.Tipo = tipo;
        this.Accion = accion;
        this.Departamento = departamento;
        this.Observaciones = observaciones;
        this.UsuarioBitacora = usuarioBitacora;
        this.FechaBitacora = fechaBitacora;
        this.RegistroBitacora = registroBitacora; 
    }
    
    // Se realizan los getters y setter de toda la entidad
    public Long getIdPeticion() { 
        return this.IdPeticion; 
    }
    public void setIdPeticion(Long idPeticion) { 
        this.IdPeticion = idPeticion; 
    } 

    public String getNombre() { 
        return this.Nombre; 
    }  
    public void setNombre(String nombre) { 
        this.Nombre = nombre; 
    } 
    public String getTelefono1() { 
        return this.Telefono1; 
    }
    public void setTelefono1(String telefono1) { 
        this.Telefono1 = telefono1; 
    } 
    
    public String getCanal() { 
        return this.Canal; 
    }
    public void setCanal(String canal) { 
        this.Canal = canal; 
    } 
    public String getTipo() { 
        return this.Tipo; 
    }
    public void setTipo(String tipo) { 
        this.Tipo = tipo; 
    } 
    
    public String getAccion() { 
        return this.Accion; 
    }
    public void setAccion(String accion) { 
        this.Accion = accion; 
    }
    public String getDepartamento() { 
        return this.Departamento; 
    }
    public void setDepartamento(String departamento) { 
        this.Departamento = departamento; 
    }
    public String getObservaciones() { 
        return this.Observaciones; 
    }
    public void setObservaciones(String observaciones) { 
        this.Observaciones = observaciones; 
    }
    public String getUsuarioBitacora() {
        return this.UsuarioBitacora;
    }
    public void setUsuarioBitacora(String usuarioBitacora) {
        this.UsuarioBitacora = usuarioBitacora;
    }
    public Date getFechaBitacora() {
        return this.FechaBitacora;
    }
    public void setFechaBitacora(Date fechaBitacora) {
        this.FechaBitacora = fechaBitacora;
    }
    public String getRegistroBitacora() {
        return this.RegistroBitacora;
    }
    
    public void setRegistroBitacora(String registroBitacora) {
        this.RegistroBitacora = registroBitacora;
    }
}