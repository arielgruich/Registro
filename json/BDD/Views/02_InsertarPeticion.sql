-- Database: registro
-- DROP DATABASE registro;
-- Procedimiento lista de Peticiones

CREATE OR REPLACE FUNCTION InsertarPeticion(
	usuario varchar(50),
	nombre varchar(50),
	telefono1 varchar(50),
	telefono2 varchar(50),
	fecha date,
	canal varchar(50),
	tipo varchar(50))
RETURNS VOID AS $$

BEGIN
    INSERT INTO Peticion (Usuario, Nombre, Telefono1, Telefono2, Fecha, Canal, Tipo)
		VALUES (usuario, nombre, telefono1, telefono2, fecha, canal, tipo);
END;
            
$$ LANGUAGE plpgsql;