using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using System.Web.Routing;
using System.Web.Security;
using RegistroFE.Controllers;
using RegistroFE.Models;
using RegistroFE.Models.Classes;

namespace RegistroFE.Controllers
{
    public class TipoController : Controller
    {
        #region Servicio(s)
        //referencia al servicio wsdl RegistroWS
        RegistroWS.RegistroWSClient RegistroBackEnd = new RegistroWS.RegistroWSClient();
        // GET: /Tipo/
        #endregion


        #region Método(s) Público(s)

        public ActionResult Index()
        {
            return View();
        }

        //
        // GET: /Tipo/Details/5

        public ActionResult Details(int id)
        {
            return View();
        }

        
        // POST: /Tipo/Create
        /// <summary>
        /// Método que inserta un EjecucionFisica.
        /// </summary>
        /// <param name="pModelo">Modelo de la vista que trasporta los datos del formulario, para realizar la inserción.</param>
        /// <returns></returns>        
        [HttpPost]
        [ValidateInput(false)]
        //[EsRecursoVerificable]
        public PartialViewResult Create() //
        {
            RegistrarTipoModel pModelo = new RegistrarTipoModel();
            // Verifica el modelo.
            if (ModelState.IsValid)
            {
                // Inserta la entidad en la base de datos.                
                var vObjEjecucionFisica = ObtenerTipoInsercion(pModelo);

                var vResultadoTransaccion = RegistroBackEnd.InsertarTipo(
                    vObjEjecucionFisica.NombreTipo,
                    vObjEjecucionFisica.UsuarioBitacora,
                    vObjEjecucionFisica.FechaBitacora,
                    vObjEjecucionFisica.RegistroBitacora);

                /*Resultado vobResultado = new Resultado()
                {
                    Mensaje = vResultadoTransaccion.mensaje,
                    DatosAdicionales = vResultadoTransaccion.datosAdicionales,
                    TipoMensaje = vResultadoTransaccion.tipoMensaje,
                    EsValido = Boolean.Parse(vResultadoTransaccion.valido)

                };*/

                // Notifica de acuerdo al resultado de transacción.
                //this.Notificacion(vobResultado);
            }
            // Obtiene la información del formulario.
            // ObtenerInformacionFormulario(pModelo);


            // Retorna el formulario con las validaciones.
            return PartialView("_FormularioEjecucionFisica", pModelo);
        }
        
        //
        // GET: /Tipo/Edit/5
 
        public ActionResult Edit(int id)
        {
            return View();
        }
        //mov
        [HttpGet]
        //[EsRecursoVerificable]
        public ActionResult RegistroTipo()
        {
            // define la botonera.
            //this.DefinirBotonera();

            // Instancia el modelo de Ejecucion Financiera.
            //var vModelo = new ();
            /*

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
             */
            //return View(vModelo);
            return View();
           
        }
        //
        // POST: /Tipo/Edit/5

        [HttpPost]
        public ActionResult Edit(int id, FormCollection collection)
        {
            try
            {
                // TODO: Add update logic here
 
                return RedirectToAction("Index");
            }
            catch
            {
                return View();
            }
        }

        //
        // GET: /Tipo/Delete/5
 
        public ActionResult Delete(int id)
        {
            return View();
        }

        //
        // POST: /Tipo/Delete/5

        [HttpPost]
        public ActionResult Delete(int id, FormCollection collection)
        {
            try
            {
                // TODO: Add delete logic here
 
                return RedirectToAction("Index");
            }
            catch
            {
                return View();
            }
        }
        //fin metodos publicos
        #endregion

        #region Método(s) Privado(s)

        /// <summary>
        /// Realiza el volcado del modelo de administración de Tipo a un objeto de transferencia de datos.
        /// </summary>
        /// <param name="pModelo">Modelo de administración de Tipo.</param>
        /// <returns>Objeto de transferencia de datos de la entidad Tipo.</returns>
        private ClassTipo ObtenerTipoInsercion(RegistrarTipoModel pModelo)
        {
            // Instancia datos a el dto.
            var vObjTipo = new ClassTipo()
            {    
                IdTipo = pModelo.IdTipo,
                NombreTipo = pModelo.NombreTipo,                
                UsuarioBitacora = pModelo.UsuarioBitacora,                
                RegistroBitacora = pModelo.RegistroBitacora,                
            };
            // Retorna objeto EjecucionFisica.
            return vObjTipo;
        }

        /// <summary>
        /// Inicializa los parámetros para la vista de inicio.
        /// </summary>
        /// <param name="pModel">Modelo de la vista.</param>
        private void IniciarParametros(RegistrarTipoModel pModel)
        {
            //Define la botonera
            //DefinirBotonera();            
            long IdTipo = 0;

            if (pModel.IdTipo > 0)
            {
                IdTipo = pModel.IdTipo;
            }
            
            //Se obtiene el listado de Tipos
            var lista = RegistroBackEnd.ObtenerTipoPorId(IdTipo);

            //a traves del identificador del proyecto
            if (lista != null)
            {
                
                    List<ClassTipo> vLista = new List<ClassTipo>();
                    ClassTipo vItem = new ClassTipo();
                    //foreach (var elemento in lista)
                    //{
                        vItem.IdTipo = lista.idTipo;
                        vItem.NombreTipo = lista.nombreTipo;
                        vItem.UsuarioBitacora = lista.usuarioBitacora;
                        vItem.RegistroBitacora = lista.registroBitacora;
                        vLista.Add(vItem);
                        vItem = new ClassTipo();                        
                    //}
                    //VariableSesion[ConstantesProyecto.cSesionListaEjecucionFisica] = pModel.ListaEjecFinanciera = vLista;

                    // Persiste la lista de EjecucionFisica en una variable de sesión para paginación de grilla.
                    //VariableSesion[ConstanteGeneralInfraestructura.cDatosGrilla] = pModel.ListaEjecFinanciera.ToList<object>();
                }  
            }
        }
        /// <summary>
        /// Define el tipo de botonera.
        /// </summary>
        /*private void DefinirBotonera()
        {
            // Define botonera de interacción para la pantalla de administración de estados. 
            //TipoBotonera = eTipoBotonera.Lista;
        }*/
        #endregion
}