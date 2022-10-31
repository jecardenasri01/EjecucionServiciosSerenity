package ArquitecturaServicios.Serenity.Task.CasosNegativos.ParamsNoValid;
import ArquitecturaServicios.Recursos.Data.Actions.Dat_RetonarConfig;
import ArquitecturaServicios.Recursos.ServicesAction.Json.CasosPositivos.Delete.Ser_DeleteEjecucion;
import ArquitecturaServicios.Serenity.Task.Global.Task_JsonDisenoServicio;
import net.serenitybdd.screenplay.Actor;

import java.util.HashMap;

public class Task_Neg_DeleteConsultarUsuario {
    public  Actor actor;
    Dat_RetonarConfig dat_retonarconfig;
    Ser_DeleteEjecucion ser_deleteejecucion;

    HashMap<String, String> infoServicio;
    Task_JsonDisenoServicio task_jsondisenoservicio;
    public Task_Neg_DeleteConsultarUsuario(Actor _actor){
        actor = _actor;
    }
    public void InstanciasBasicas(){
        dat_retonarconfig = new Dat_RetonarConfig();
        ser_deleteejecucion = new Ser_DeleteEjecucion();
        task_jsondisenoservicio = new Task_JsonDisenoServicio();

    }
    public void EjecutarServicioDelete(){
        InstanciasBasicas();
        Dat_RetonarConfig dat_retonarconfig = new Dat_RetonarConfig();
        String idcliente = dat_retonarconfig.retornarDatos("UsuarioBorrar","01_NegativoDeleteUsuario");
        infoServicio = task_jsondisenoservicio.GetLLenarInformacionServicio("Dat_GeneralPropiedades");
        ser_deleteejecucion.DeleteJsonEjecutar(actor,infoServicio,idcliente);
    }

}
