using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using Control.Web.ControlWeb.ControlExtendido;
using Framework.Comun.Resultado;
using Infraestructura.Web.General.Declaracion.Constante;
using Infraestructura.Web.General.Declaracion.Enumerador;
using Infraestructura.Web.SegipInfraestructura.Filtro;
using Minedu.Web.General.Declaraciones.Constantes;
using Minedu.Web.General.Dto;
using Minedu.Web.Presentacion.Areas.Proyecto.Models;
using Minedu.Web.Presentacion.Base.Base;

namespace Minedu.Web.Presentacion.Areas.Proyecto.Controllers
{
    public class EjecucionFisicaController : BaseController
    {
        #region Servicio(s)
		/// ejemplo de consumo de servicio WSDL
        /// <summary>
        /// Referencia al servicio interno de proyecto
        /// </summary>
        ServicioInternoProyecto.ProyectoWSClient _vServicio = new ServicioInternoProyecto.ProyectoWSClient();

        #endregion

        #region Método(s) Público(s)

        /// <summary>
        /// Método que construye la vista de administración de Ejecucion Financiera
        /// </summary>
        [Volver]
        [HttpGet]
        //[EsRecursoVerificable]
        public ActionResult EjecucionFisica(string pIdProyectoAe)
        {
            // define la botonera.
            this.DefinirBotonera();

            // Instancia el modelo de Ejecucion Financiera.
            var vModelo = new EjecucionFisicaViewModel();


            // Valida el identificador del proyecto/accion estrategica 
            if (!string.IsNullOrEmpty(pIdProyectoAe))
            {

                #region Declaraciones
                // Instancia variables para id.
                long vIdProyectoAe = 0;

                // Convierte las cadenas a números.
                Int64.TryParse(pIdProyectoAe, out vIdProyectoAe);
                #endregion

                // Guarda en sesíón el identificador del componente
                VariableSesion[ConstantesProyecto.cSesionEjecucionFisicaIdProyectoAe] = vIdProyectoAe;

                // Asigna el identificador del componente
                vModelo.IdProyectoAe = vIdProyectoAe;

                // Inicia los parametros del modelo.
                this.IniciarParametros(vModelo);
            }
            // Retorna el modelo a la vista.
            return View(vModelo);

        }

        /// <summary>
        /// Método que obtiene un registro de EjecucionFisica a través de su identificador.
        /// </summary>
        /// <param name="pParametro">Identificador del EjecucionFisica que llega desde la vista.</param>
        /// <returns>Parcial con datos del EjecucionFisica.</returns>
        public PartialViewResult ObtenerRegistro(string pParametro)
        {
            // Instancia el modelo de administración de EjecucionFisica.
            EjecucionFisicaFormularioViewModel vModel = null;

            if (VariableSesion.ContainsKey(ConstantesProyecto.cSesionEjecucionFisicaIdProyectoAe))
            {
                long vIdProyectoAe = (long)VariableSesion[ConstantesProyecto.cSesionEjecucionFisicaIdProyectoAe];

                //verifica que la cadewna del parametro sea valida
                //                if (pParametro == "null")
                if (pParametro != "null")
                {
                    //Se obtiene el parametro de entrada como identificador del componente
                    long vIdEjecucionFisica;
                    Int64.TryParse(pParametro, out vIdEjecucionFisica);


                    // Obtiene de sesión la lista de EjecucionFisica en funcion al componente.
                    List<ProgFisicaDto> vListaEjecucionFisica = (List<ProgFisicaDto>)VariableSesion[ConstantesProyecto.cSesionListaEjecucionFisica];

                    // Obtiene el EjecucionFisica
                    ProgFisicaDto vObjEjecucionFisica = vListaEjecucionFisica.Where(p => p.IdEjecucion == vIdEjecucionFisica).FirstOrDefault();

                    // Determina datos del ViewModel.
                    vModel = new EjecucionFisicaFormularioViewModel
                    {
                        IdEjecucion = vObjEjecucionFisica.IdEjecucion,
                        FechaProg = vObjEjecucionFisica.FechaProg,
                        FechaEjec = vObjEjecucionFisica.FechaEjec,
                        ProgramadoFis = vObjEjecucionFisica.ProgramadoFis,
                        EjecutadoFis = vObjEjecucionFisica.EjecutadoFis,
                        EsFinanciera = vObjEjecucionFisica.EsFinanciera,
                        IdProgFinanciera = vObjEjecucionFisica.IdProgFinanciera,
                        IdIndicador = vObjEjecucionFisica.IdIndicador,
                        DescripcionIndicador = vObjEjecucionFisica.DescripcionIndicador,
                        FechaInicio = vObjEjecucionFisica.FechaInicio,
                        FechaFin = vObjEjecucionFisica.FechaFin,
                        IdComponente = vObjEjecucionFisica.IdComponente,
                        Concepto = vObjEjecucionFisica.Concepto,
                        IdProyectoAe = vIdProyectoAe,
                        IdUnidadEjecutora = vObjEjecucionFisica.IdUnidadEjecutora

                    };

                }
                else
                {
                    // Predetermina ViewModel vacío para nuevo registro.
                    vModel = new EjecucionFisicaFormularioViewModel { EsNuevoRegistro = true };
                    vModel.IdProyectoAe = vIdProyectoAe;
                }


                // Obtiene la información del formulario.
                ObtenerInformacionFormulario(vModel);
            }
            else
            {
                // Predetermina ViewModel vacío para nuevo registro.
                vModel = new EjecucionFisicaFormularioViewModel { EsNuevoRegistro = true };

            }
            // Retorna modelo a la vista parcial.
            return PartialView("_FormularioEjecucionFisica", vModel);
        }

        /// <summary>
        /// Método que inserta un EjecucionFisica.
        /// </summary>
        /// <param name="pModelo">Modelo de la vista que trasporta los datos del formulario, para realizar la inserción.</param>
        /// <returns></returns>        
        [HttpPost]
        [ValidateInput(false)]
        //[EsRecursoVerificable]
        public PartialViewResult Guardar(EjecucionFisicaFormularioViewModel pModelo)
        {
            // Verifica el modelo.
            if (ModelState.IsValid)
            {
                // Inserta la entidad en la base de datos.
                var vObjEjecucionFisica = ObtenerEntidadInsersion(pModelo);

                var vResultadoTransaccion = _vServicio.InsertarEjecucion(
                    vObjEjecucionFisica.FechaProg,
                    vObjEjecucionFisica.FechaEjec,
                    0,
                    0,
                    vObjEjecucionFisica.ProgramadoFis,
                    vObjEjecucionFisica.EjecutadoFis,
                    false,
                    vObjEjecucionFisica.IdProgFinanciera,
                    vObjEjecucionFisica.IdIndicador,
                    vObjEjecucionFisica.UsuarioBitacora,
                    vObjEjecucionFisica.FechaBitacora,
                    vObjEjecucionFisica.RegistroBitacora);

                Resultado vobResultado = new Resultado()
                {
                    Mensaje = vResultadoTransaccion.mensaje,
                    DatosAdicionales = vResultadoTransaccion.datosAdicionales,
                    TipoMensaje = vResultadoTransaccion.tipoMensaje,
                    EsValido = Boolean.Parse(vResultadoTransaccion.valido)

                };

                // Notifica de acuerdo al resultado de transacción.
                this.Notificacion(vobResultado);
            }
            // Obtiene la información del formulario.
            ObtenerInformacionFormulario(pModelo);


            // Retorna el formulario con las validaciones.
            return PartialView("_FormularioEjecucionFisica", pModelo);
        }

        /// <summary>
        /// Método que inserta un EjecucionFisica.
        /// </summary>
        /// <param name="pModelo">Modelo de la vista que trasporta los datos del formulario, para realizar la modificación.</param>
        /// <returns></returns>        
        [HttpPost]
        [ValidateInput(false)]
        //[EsRecursoVerificable]
        public PartialViewResult Modificar(EjecucionFisicaFormularioViewModel pModelo)
        {
            // Verifica el modelo.
            if (ModelState.IsValid)
            {
                //Obtiene la entidad a modificar
                var vObjEjecucionFisica = ObtenerEntidadInsersion(pModelo);

                // Modifica la entidad en la base de datos.
                var vResultadoTransaccion = _vServicio.ModificarEjecucion(
                    vObjEjecucionFisica.IdEjecucion,
                    vObjEjecucionFisica.FechaProg,
                    vObjEjecucionFisica.FechaEjec,
                    0,
                    0,
                    vObjEjecucionFisica.ProgramadoFis,
                    vObjEjecucionFisica.EjecutadoFis,
                    false,
                    vObjEjecucionFisica.IdProgFinanciera,
                    vObjEjecucionFisica.IdIndicador,
                    vObjEjecucionFisica.UsuarioBitacora,
                    vObjEjecucionFisica.FechaBitacora,
                    vObjEjecucionFisica.RegistroBitacora);

                //Seteo de valores
                Resultado vobResultado = new Resultado()
                {
                    Mensaje = vResultadoTransaccion.mensaje,
                    DatosAdicionales = vResultadoTransaccion.datosAdicionales,
                    TipoMensaje = vResultadoTransaccion.tipoMensaje,
                    EsValido = true

                };

                // Notifica de acuerdo al resultado de transacción.
                this.Notificacion(vobResultado);
            }

            // Obtiene la información del formulario.
            ObtenerInformacionFormulario(pModelo);

            // Retorna el formulario con las validaciones.
            return PartialView("_FormularioEjecucionFisica", pModelo);
        }

        /// <summary>
        /// Método que realiza la eliminación de un componente.
        /// </summary>
        /// <param name="pModelo">Modelo de la vista que trae los datos del EjecucionFisica a ser eliminado.</param>
        /// <returns></returns>
        //[EsRecursoVerificable]
        public PartialViewResult Eliminar(EjecucionFisicaFormularioViewModel pModelo)
        {
            // Verifica el modelo.
            if (pModelo != null)
            {
                // Elimina el EjecucionFisica.
                var vResultadoTransacccion = _vServicio.EliminarEjecucion(pModelo.IdEjecucion);

                //Seteo de valores
                Resultado vobResultado = new Resultado()
                {
                    Mensaje = vResultadoTransacccion.mensaje,
                    DatosAdicionales = vResultadoTransacccion.datosAdicionales,
                    EsValido = Convert.ToBoolean(vResultadoTransacccion.valido)

                };

                //Notifica de acuerdo al resultado de transacción.
                this.Notificacion(vobResultado);
            }
            // Obtiene la información del formulario.
            ObtenerInformacionFormulario(pModelo);

            // Retorna el modelo a la vista.
            return PartialView("_FormularioEjecucionFisica", pModelo);
        }

        /// <summary>
        /// Método para la actualización de la grilla.
        /// </summary>
        /// <returns></returns>
        [HttpPost]
        public PartialViewResult ActualizarListaGrid()
        {
            // Instancia el modelo de administración de EjecucionFisica.
            var vModel = new EjecucionFisicaViewModel();

            // Inicia los parametros del modelo.
            this.IniciarParametros(vModel);

            // Retorna modelo a la vista parcial.
            return PartialView("_ListaEjecucionFisica", vModel);
        }

        #endregion

        #region Método(s) Privado(s)

        /// <summary>
        /// Obtiene la información del formulario.
        /// </summary>
        /// <param name="pModelo">Modelo de la vista</param>
        private void ObtenerInformacionFormulario(EjecucionFisicaFormularioViewModel pModelo)
        {


        }

        /// <summary>
        /// Realiza el volcado del modelo de administración de EjecucionFisica a un objeto de transferencia de datos.
        /// </summary>
        /// <param name="pModelo">Modelo de administración de EjecucionFisica.</param>
        /// <returns>Objeto de transferencia de datos de la entidad EjecucionFisica.</returns>
        private ProgFisicaDto ObtenerEntidadInsersion(EjecucionFisicaFormularioViewModel pModelo)
        {
            // Instancia datos a el dto.
            var vObjEjecucionFisica = new ProgFisicaDto()
            {
                IdEjecucion = pModelo.IdEjecucion,
                FechaProg = pModelo.FechaProg,
                FechaEjec = pModelo.FechaEjec,
                ProgramadoFis = pModelo.ProgramadoFis,
                EjecutadoFis = pModelo.EjecutadoFis,
                EsFinanciera = pModelo.EsFinanciera,
                IdProgFinanciera = pModelo.IdProgFinanciera,
                IdIndicador = pModelo.IdIndicador,
                DescripcionIndicador = pModelo.DescripcionIndicador,
                FechaInicio = pModelo.FechaInicio,
                FechaFin = pModelo.FechaFin,
                IdComponente = pModelo.IdComponente,
                Concepto = !string.IsNullOrEmpty(pModelo.Concepto) ? pModelo.Concepto.Trim() : null,
                IdProyectoAe = pModelo.IdProyectoAe,
                IdUnidadEjecutora = pModelo.IdUnidadEjecutora,
                UsuarioBitacora = InformacionContexto.NombreCompletoUsuario,
                RegistroBitacora = InformacionContexto.IpMaquina


            };
            // Retorna objeto EjecucionFisica.
            return vObjEjecucionFisica;
        }

        /// <summary>
        /// Inicializa los parámetros para la vista de inicio.
        /// </summary>
        /// <param name="pModel">Modelo de la vista.</param>
        private void IniciarParametros(EjecucionFisicaViewModel pModel)
        {
            //Define la botonera
            DefinirBotonera();

            //Se obtiene el identificador del proyecto ae
            long vIdProyectoAe = 0;

            if (pModel.IdProyectoAe > 0)
            {
                vIdProyectoAe = pModel.IdProyectoAe;
            }
            else
            {
                if (VariableSesion.ContainsKey(ConstantesProyecto.cSesionEjecucionFisicaIdProyectoAe))
                {
                    vIdProyectoAe = (long)VariableSesion[ConstantesProyecto.cSesionEjecucionFisicaIdProyectoAe];

                }
            }

            //Se obtiene el listado de ejecucion financiera por proyecto
            var lista = _vServicio.ObtenerProgFisicaPorIdProyectoAe(vIdProyectoAe);

            //a traves del identificador del proyecto
            if (lista != null)
            {
                //obtener la lista en funcion a los EjecucionFisica asiganados
                if (lista.Any())
                {
                    List<ProgFisicaDto> vLista = new List<ProgFisicaDto>();
                    ProgFisicaDto vItem = new ProgFisicaDto();
                    foreach (var elemento in lista)
                    {
                        vItem.IdEjecucion = elemento.idEjecucion;
                        vItem.FechaProg = elemento.fechaProg;
                        vItem.FechaEjec = elemento.fechaEjec;
                        vItem.ProgramadoFis = elemento.programadoFis;
                        vItem.EjecutadoFis = elemento.ejecutadoFis;
                        vItem.EsFinanciera = elemento.esFinanciera;
                        vItem.IdProgFinanciera = elemento.idProgFinanciera;
                        vItem.IdIndicador = elemento.idIndicador;
                        vItem.DescripcionIndicador = elemento.descripcionIndicador;
                        vItem.FechaInicio = elemento.fechaInicio;
                        vItem.FechaFin = elemento.fechaFin;
                        vItem.IdComponente = elemento.idComponente;
                        vItem.Concepto = elemento.concepto;
                        vItem.IdProyectoAe = elemento.idProyectoAe;
                        vItem.IdUnidadEjecutora = elemento.idUnidadEjecutora;
                        
                        vLista.Add(vItem);
                        vItem = new ProgFisicaDto();
                    }
                    VariableSesion[ConstantesProyecto.cSesionListaEjecucionFisica] = pModel.ListaEjecFinanciera = vLista;

                    // Persiste la lista de EjecucionFisica en una variable de sesión para paginación de grilla.
                    VariableSesion[ConstanteGeneralInfraestructura.cDatosGrilla] = pModel.ListaEjecFinanciera.ToList<object>();

                }
            }



        }

        /// <summary>
        /// Define el tipo de botonera.
        /// </summary>
        private void DefinirBotonera()
        {
            // Define botonera de interacción para la pantalla de administración de estados. 
            TipoBotonera = eTipoBotonera.Lista;
        }

        #endregion
    }
}
