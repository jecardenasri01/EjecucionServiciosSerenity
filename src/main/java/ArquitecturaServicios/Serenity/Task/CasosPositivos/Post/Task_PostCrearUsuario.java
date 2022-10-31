package ArquitecturaServicios.Serenity.Task.CasosPositivos.Post;
import ArquitecturaServicios.Recursos.Data.Actions.Dat_RetonarConfig;
import ArquitecturaServicios.Recursos.ServicesAction.Json.CasosPositivos.Post.Ser_PostEjecucion;
import ArquitecturaServicios.Serenity.Task.Global.Task_JsonDisenoServicio;
import net.serenitybdd.screenplay.Actor;

import java.util.HashMap;

public class Task_PostCrearUsuario {
    public  Actor actor;
    Dat_RetonarConfig dat_retonarconfig;
    Ser_PostEjecucion ser_postejecucion;
    HashMap<String, String> infoServicio;
    Task_JsonDisenoServicio task_jsondisenoservicio;
    public Task_PostCrearUsuario(Actor _actor){
        actor = _actor;
    }
    public void InstanciasBasicas(){
        dat_retonarconfig = new Dat_RetonarConfig();
        ser_postejecucion = new Ser_PostEjecucion();
        task_jsondisenoservicio = new Task_JsonDisenoServicio();

    }
    public void EjecutarServicioPost(String request){
        InstanciasBasicas();
        infoServicio = task_jsondisenoservicio.GetLLenarInformacionServicio("Dat_GeneralPropiedades");
        ser_postejecucion.PostJsonEjecutar(actor,infoServicio,request);
    }

}
