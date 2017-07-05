--Database: registro
--import java.util.Calendar;
--Calendar cal1 = Calendar.getInstance(); //obtiene hora del sistema actual
--java.sql.Date fecha = new java.sql.Date(cal1.get(Calendar.MILLISECOND));
-- DROP DATABASE registro;

create table Canal(
  IdCanal serial,
  NombreCanal varchar(50) not null,
  usuario_bitacora varchar(50) null,
  fecha_bitacora timestamp(0) null,
  registro_bitacora varchar(50) null,
  primary key (NombreCanal)
);

create table Tipo(
  IdTipo serial,
  NombreTipo varchar(50) not null,  
  usuario_bitacora varchar(50) null,
  fecha_bitacora timestamp(0) null,
  registro_bitacora varchar(50) null,
  primary key (NombreTipo)
);


create table Peticion(
  IdPeticion serial,  
  Nombre varchar(50) null,
  Telefono1 varchar(50) null,    
  Canal varchar(50) references Canal(NombreCanal),
  Tipo varchar(50) references Tipo(NombreTipo),
  usuario_bitacora varchar(50) null,
  fecha_bitacora timestamp(0) null,
  registro_bitacora varchar(50) null,
  primary key (IdPeticion)
);
