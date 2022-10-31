package ArquitecturaServicios.Serenity.Task.CasosNegativos.BodyInvalid;

import ArquitecturaServicios.Recursos.ServicesAction.Global.Ser_JsonLeerArchivo;
import ArquitecturaServicios.Recursos.ServicesAction.Json.CasosPositivos.Post.GenerarServicio.Ser_01_CrearUsuario;
import ArquitecturaServicios.Serenity.Task.CasosPositivos.Post.Task_PostCrearUsuario;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.questions.LastResponse;

public class Task_Neg_BodyInvalid {
    Actor jeisson;
    public Task_Neg_BodyInvalid(Actor _jeisson){
        jeisson = _jeisson;
    }

    public void ObtenerCrearUsuarioBase(){
        int codigoRespuesta=0;
        boolean emailescrito= true;

        Ser_01_CrearUsuario ser_01_crearusuario = new Ser_01_CrearUsuario();
        Ser_JsonLeerArchivo ser_jsonLeerArchivo = new Ser_JsonLeerArchivo();
        Task_PostCrearUsuario task_postcrearusuario = new Task_PostCrearUsuario(jeisson);
        //retornar servicio
        String rutaServicio ="src/main/java/ArquitecturaServicios/Recursos/Data/ServicesStructure/Post/01_Negativo_CrearUsuario.json";
        Object filejson = ser_jsonLeerArchivo.JsonLeerArchivo(rutaServicio);
        //ejecutar
        task_postcrearusuario.EjecutarServicioPost(filejson.toString());
        codigoRespuesta = LastResponse.received().answeredBy(jeisson).getStatusCode();


    }
}
