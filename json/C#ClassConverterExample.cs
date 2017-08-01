using System;


namespace Minedu.Web.General.Dto
{
    public class ComponenteDto
    {
        
        /// <summary>
        /// Identificador de la entidad componente
        /// </summary>
        public long IdComponente { get; set; }

        /// <summary>
        /// Identificador de la entidad proyecto
        /// </summary>
        public long IdProyectoAe { get; set; }

        /// <summary>
        /// Descripcion del componente
        /// </summary>
        public string Descripcion { get; set; }

        /// <summary>
        /// Parte conceptual del componente
        /// </summary>
        public string Concepto { get; set; }

        /// <summary>
        /// Identificador del tipo de componente
        /// </summary>
        public long TipoComponente { get; set; }

        /// <summary>
        /// Identificador de la entidad componente superior
        /// </summary>
        public long IdComponenteSuperior { get; set; } 

        /// <summary>
        /// Usuario bitácora.
        /// </summary>
        public string UsuarioBitacora { get; set; }

        /// <summary>
        /// Feha bitácora.
        /// </summary>
        public DateTime FechaBitacora { get; set; }

        /// <summary>
        /// Registro bitacora.
        /// </summary>
        public string RegistroBitacora { get; set; }
    }
}