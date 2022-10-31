package ArquitecturaServicios.Serenity.Task.CasosNegativos.ErrorType;
import ArquitecturaServicios.Recursos.Data.Actions.Dat_RetonarConfig;
import ArquitecturaServicios.Recursos.ServicesAction.Json.CasosNegativos.ErrorType.Ser_Neg_ErrorType;
import ArquitecturaServicios.Serenity.Task.Global.Task_JsonDisenoServicio;
import net.serenitybdd.screenplay.Actor;

import java.util.HashMap;

public class Task_Neg_GetConsultarUsuario {
    public  Actor jeisson;
    Dat_RetonarConfig dat_retonarconfig;
    Ser_Neg_ErrorType ser_neg_errorType;
    HashMap<String, String> infoServicio;
    Task_JsonDisenoServicio task_jsondisenoservicio;
    public Task_Neg_GetConsultarUsuario(Actor _jeisson){
        jeisson = _jeisson;
    }
    public void InstanciasBasicas(){
        dat_retonarconfig = new Dat_RetonarConfig();
        ser_neg_errorType = new Ser_Neg_ErrorType();
        task_jsondisenoservicio = new Task_JsonDisenoServicio();

    }
    public void NegativoEjecutarServicioGetHeader(){
        InstanciasBasicas();
        infoServicio = task_jsondisenoservicio.GetLLenarInformacionServicio("Dat_NegativoGeneralPropiedades");
        jeisson.should("Se agrega variable incorrecta al app-id : "+infoServicio.get("app-id"));

        ser_neg_errorType.Neg_GetErrorType(jeisson,infoServicio);
    }

}
