package CapaNegocio;

import java.text.DateFormat;
import java.util.Date;

/**
 * @author Christian Marbel Vega Mamani
 */
public  abstract class GeneralUtil {
    
//Clase boleana que determina si el campo es nulo o vacio
public static boolean isNullOrEmpty(String s) 
{
   return s == null || s.length() == 0;
}

//Clase boleana que determina si el campo es nulo o en blanco
public static boolean isNullOrWhitespace(String s) {
    return s == null || isWhitespace(s);

}

//Clase boleana que determina si el campo es un espacio en blanco
private static boolean isWhitespace(String s) {
    int length = s.length();
    if (length > 0) {
        for (int i = 0; i < length; i++) {
            if (!Character.isWhitespace(s.charAt(i))) {
                return false;
            }
        }
        return true;
    }
    return false;
}


    public static String formatDateTime(Date dateOrNull) {
        return (dateOrNull == null ? null : DateFormat.getDateTimeInstance().format(dateOrNull));
    }



}
