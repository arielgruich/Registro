
package CapaDatos;

/**
 *
 * @author Christian Marbel Vega Mamani
 * Entidad Resultado
 */
public class Resultado implements java.io.Serializable {
    
    
    private boolean EsValido;
    public boolean EsValido() {
        return this.EsValido;
    }
    
    public void setEsValido(boolean EsValido) {
        this.EsValido = EsValido;
    }
    
    private String Mensaje;
    
       public String getMensaje() {
        return this.Mensaje;
    }
    
    public void setMensaje(String Mensaje) {
        this.Mensaje = Mensaje;
    }
    
    private String TipoMensaje;
    
    public String getTipoMensaje() {
        return this.TipoMensaje;
    }
    
    public void setTipoMensaje(String TipoMensaje) {
        this.TipoMensaje = TipoMensaje;
    }
    
    private String Valido;
    public String getValido() {
        return this.Valido;
    }
    
    public void setValido(String Valido) {
        this.Valido = Valido;
    }
    
    private Object DatosAdicionales;
    
    public Object getDatosAdicionales() {
        return this.DatosAdicionales;
    }
    
    public void setDatosAdicionales(Object DatosAdicionales) {
        this.DatosAdicionales = DatosAdicionales;
    }

}
