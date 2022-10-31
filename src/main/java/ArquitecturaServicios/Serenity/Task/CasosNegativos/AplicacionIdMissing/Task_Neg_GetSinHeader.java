package ArquitecturaServicios.Serenity.Task.CasosNegativos.AplicacionIdMissing;
import ArquitecturaServicios.Recursos.Data.Actions.Dat_RetonarConfig;
import ArquitecturaServicios.Recursos.ServicesAction.Json.CasosNegativos.Aplicacionidmissing.Ser_Neg_AplicacionIdMissing;
import ArquitecturaServicios.Serenity.Task.Global.Task_JsonDisenoServicio;
import net.serenitybdd.screenplay.Actor;

import java.util.HashMap;

public class Task_Neg_GetSinHeader {
    public  Actor jeisson;
    Dat_RetonarConfig dat_retonarconfig;
    Ser_Neg_AplicacionIdMissing ser_neg_aplicacionIdMissing;
    HashMap<String, String> infoServicio;
    Task_JsonDisenoServicio task_jsondisenoservicio;
    public Task_Neg_GetSinHeader(Actor _jeisson){
        jeisson = _jeisson;
    }
    public void InstanciasBasicas(){
        dat_retonarconfig = new Dat_RetonarConfig();
        ser_neg_aplicacionIdMissing = new Ser_Neg_AplicacionIdMissing();
        task_jsondisenoservicio = new Task_JsonDisenoServicio();

    }
    public void NegativoEjecutarServicioGetHeader(){
        InstanciasBasicas();
        infoServicio = task_jsondisenoservicio.GetLLenarInformacionServicio("Dat_GeneralPropiedades");
        jeisson.should("Se elimina variable app-id en la estructura del servicio ");

        ser_neg_aplicacionIdMissing.Neg_GetSinHeader(jeisson,infoServicio);
    }

}
