/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaDatos;
import java.sql.SQLException;
import java.util.Date;
/**
 * @author Ariel Luis Gruich Arratia
 *Entidad Canal
 */
public class BCanal implements java.io.Serializable {
    
    // Declaración de los atributos de la entidad
    private Long IdCanal;
    private String NombreCanal;
    private String UsuarioBitacora; 
    private Date FechaBitacora; 
    private String RegistroBitacora;
    
    @Override
    public int hashCode()
    {
        return Long.hashCode(IdCanal);
    }

    // Se crea el constructor de la clase
    public BCanal() {
    }

    public BCanal ( Long idCanal, String nombreCanal, String usuarioBitacora, Date fechaBitacora, String registroBitacora) {
        this.IdCanal = idCanal;
        this.NombreCanal = nombreCanal;
        this.UsuarioBitacora = usuarioBitacora;
        this.FechaBitacora = fechaBitacora;
        this.RegistroBitacora = registroBitacora; 
    }

    // Se realizan los getters y setter de toda la entidad
    public Long getIdCanal() { 
        return this.IdCanal; 
    }
    public void setIdCanal(Long idCanal) { 
        this.IdCanal = idCanal; 
    } 

    public String getNombreCanal() { 
        return this.NombreCanal; 
    }

    public void setNombreCanal(String nombreCanal) { 
        this.NombreCanal = nombreCanal; 
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