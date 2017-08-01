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
  primary key (IdCanal)
);

create table Tipo(
  IdTipo serial,
  NombreTipo varchar(50) not null,  
  usuario_bitacora varchar(50) null,
  fecha_bitacora timestamp(0) null,
  registro_bitacora varchar(50) null,
  primary key (IdTipo)
);

create table Departamento(
  IdDepartamento serial,
  NombreDepartamento varchar(50) not null,  
  usuario_bitacora varchar(50) null,
  fecha_bitacora timestamp(0) null,
  registro_bitacora varchar(50) null,
  primary key (IdCiudad)
);

create table Peticion(
  IdPeticion serial,  
  Nombre varchar(50) null,
  Telefono1 varchar(50) null,    
  Canal varchar(50) references Canal(NombreCanal),
  Tipo varchar(50) references Tipo(NombreTipo),
  Accion varchar(50) null,
  Ciudad varchar(50) references Departamento(NombreDepartamento),
  Observaciones varchar(50) null,
  usuario_bitacora varchar(50) null,
  fecha_bitacora timestamp(0) null,
  registro_bitacora varchar(50) null,
  primary key (IdPeticion)
);
