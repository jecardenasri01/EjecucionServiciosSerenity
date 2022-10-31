package ArquitecturaServicios.Serenity.Task.CasosPositivos.Get;
import ArquitecturaServicios.Recursos.Data.Actions.Dat_RetonarConfig;
import ArquitecturaServicios.Recursos.ServicesAction.Json.CasosPositivos.Get.Ser_GetEjecucion;
import ArquitecturaServicios.Serenity.Task.Global.Task_JsonDisenoServicio;
import net.serenitybdd.screenplay.Actor;

import java.util.HashMap;

public class Task_GetConsultarUsuario {
    public  Actor actor;
    Dat_RetonarConfig dat_retonarconfig;
    Ser_GetEjecucion ser_jsonejecucion;
    HashMap<String, String> infoServicio;
    Task_JsonDisenoServicio task_jsondisenoservicio;
    public Task_GetConsultarUsuario(Actor _actor){
        actor = _actor;
    }
    public void InstanciasBasicas(){
        dat_retonarconfig = new Dat_RetonarConfig();
        ser_jsonejecucion = new Ser_GetEjecucion();
        task_jsondisenoservicio = new Task_JsonDisenoServicio();

    }
    public void EjecutarServicioGet(){
        InstanciasBasicas();
        infoServicio = task_jsondisenoservicio.GetLLenarInformacionServicio("Dat_GeneralPropiedades");
        ser_jsonejecucion.GetJsonEjecutar(actor,infoServicio);
    }

}
