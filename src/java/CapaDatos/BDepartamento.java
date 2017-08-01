/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaDatos;
import java.sql.SQLException;
import java.util.Date;
/**
 *
 * @author agruich
 */
public class BDepartamento implements java.io.Serializable {
    
    // Declaración de los atributos de la entidad
    private Long IdDepartamento;
    private String NombreDepartamento;
    private String UsuarioBitacora; 
    private Date FechaBitacora; 
    private String RegistroBitacora;
    
    @Override
    public int hashCode()
    {
        return Long.hashCode(IdDepartamento);
    }

    // Se crea el constructor de la clase
    public BDepartamento() {
    }

    public BDepartamento ( Long idDepartamento, String nombreDepartamento, String usuarioBitacora, Date fechaBitacora, String registroBitacora) {
        this.IdDepartamento = idDepartamento;
        this.NombreDepartamento = nombreDepartamento;
        this.UsuarioBitacora = usuarioBitacora;
        this.FechaBitacora = fechaBitacora;
        this.RegistroBitacora = registroBitacora; 
    }

    // Se realizan los getters y setter de toda la entidad
    public Long getIdDepartamento() { 
        return this.IdDepartamento; 
    }
    public void setIdDepartamento(Long idDepartamento) { 
        this.IdDepartamento = idDepartamento; 
    } 

    public String getNombreDepartamento() { 
        return this.NombreDepartamento; 
    }

    public void setNombreDepartamento(String nombreCanal) { 
        this.NombreDepartamento = nombreCanal; 
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