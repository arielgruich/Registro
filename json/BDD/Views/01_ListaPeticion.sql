-- Database: registro
-- DROP DATABASE registro;
-- Procedimiento lista de Peticiones

CREATE FUNCTION ListaPeticion()
RETURNS TABLE(quantity int, total numeric) AS $
BEGIN
    RETURN QUERY SELECT * FROM Peticion;
END;
            
$ LANGUAGE plpgsql;