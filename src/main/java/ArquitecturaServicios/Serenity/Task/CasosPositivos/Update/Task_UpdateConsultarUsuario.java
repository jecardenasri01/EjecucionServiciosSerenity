package ArquitecturaServicios.Serenity.Task.CasosPositivos.Update;
import ArquitecturaServicios.Recursos.Data.Actions.Dat_RetonarConfig;
import ArquitecturaServicios.Recursos.ServicesAction.Global.Ser_JsonLeerArchivo;
import ArquitecturaServicios.Recursos.ServicesAction.Json.CasosPositivos.Put.GenerarServicio.Ser_01_ModificarUsuario;
import ArquitecturaServicios.Recursos.ServicesAction.Json.CasosPositivos.Put.Ser_PutEjecucion;
import ArquitecturaServicios.Serenity.Task.Global.Task_JsonDisenoServicio;
import net.serenitybdd.screenplay.Actor;

import java.util.HashMap;

public class Task_UpdateConsultarUsuario {

    public  Actor actor;
    Dat_RetonarConfig dat_retonarconfig;
    Ser_PutEjecucion ser_putejecucion;
    Ser_01_ModificarUsuario ser_01_modificarUsuario;
    HashMap<String, String> infoServicio;
    Task_JsonDisenoServicio task_jsondisenoservicio;

    public Task_UpdateConsultarUsuario(Actor _actor){
        actor = _actor;
    }
    public void InstanciasBasicas(){
        dat_retonarconfig = new Dat_RetonarConfig();
        ser_putejecucion = new Ser_PutEjecucion();
        task_jsondisenoservicio = new Task_JsonDisenoServicio();
        ser_01_modificarUsuario = new Ser_01_ModificarUsuario();

    }
    public void EjecutarServicioUpdate(){
        InstanciasBasicas();
        Dat_RetonarConfig dat_retonarconfig = new Dat_RetonarConfig();
        Ser_JsonLeerArchivo ser_jsonLeerArchivo = new Ser_JsonLeerArchivo();
        String idcliente = dat_retonarconfig.retornarDatos("id","01_ModificarUsuario");
        //obtener request servicio
        String rutaServicio ="src/main/java/ArquitecturaServicios/Recursos/Data/ServicesStructure/Put/01_ModificarUsuario.json";
        Object filejson = ser_jsonLeerArchivo.JsonLeerArchivo(rutaServicio);
        // modificar servicio
        String jsonmodificado= ser_01_modificarUsuario.Generar_01_ModificarUsuario(filejson);
        // ejecutar servicio
        infoServicio = task_jsondisenoservicio.GetLLenarInformacionServicio("Dat_GeneralPropiedades");
        ser_putejecucion.PutJsonEjecutar(actor,infoServicio,idcliente,jsonmodificado);
    }

}
