package CapaDatos;
import java.sql.SQLException;
import java.util.Date;
/**
 * @author Ariel Luis Gruich Arratia
 *Entidad Tipo
 */
public class BTipo implements java.io.Serializable {
    
    // Declaración de los atributos de la entidad
    private Long IdTipo;
    private String NombreTipo;
    private String UsuarioBitacora; 
    private Date FechaBitacora; 
    private String RegistroBitacora;

    @Override
    public int hashCode()
    {
        return Long.hashCode(IdTipo);
    }

    // Se crea el constructor de la clase
    public BTipo() {
    }
    public BTipo ( Long idTipo, String nombreTipo, String usuarioBitacora, Date fechaBitacora, String registroBitacora) {
        this.IdTipo = idTipo;
        this.NombreTipo = nombreTipo;
        this.UsuarioBitacora = usuarioBitacora;
        this.FechaBitacora = fechaBitacora;
        this.RegistroBitacora = registroBitacora; 
    }

    // Se realizan los getters y setter de toda la entidad
    public Long getIdTipo() { 
        return this.IdTipo; 
    }

    public void setIdTipo(Long idTipo) { 
        this.IdTipo = idTipo; 
    } 

    public String getNombreTipo() { 
        return this.NombreTipo; 
    }

    public void setNombreTipo(String nombreTipo) { 
        this.NombreTipo = nombreTipo; 
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