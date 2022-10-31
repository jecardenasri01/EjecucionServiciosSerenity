package ArquitecturaServicios.Serenity.Task.CasosPositivos.Post;

import ArquitecturaServicios.Recursos.ServicesAction.Global.Ser_JsonLeerArchivo;
import ArquitecturaServicios.Recursos.ServicesAction.Json.CasosPositivos.Post.GenerarServicio.Ser_01_CrearUsuario;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.questions.LastResponse;

public class Task_PostEjecutarCrearUsuarioBase {
    Actor jeisson;
    public Task_PostEjecutarCrearUsuarioBase(Actor _jeisson){
        jeisson = _jeisson;
    }

    public void ObtenerCrearUsuarioBase(){
        int codigoRespuesta=0;
        boolean emailescrito= true;
        do {
        Ser_01_CrearUsuario ser_01_crearusuario = new Ser_01_CrearUsuario();
        Ser_JsonLeerArchivo ser_jsonLeerArchivo = new Ser_JsonLeerArchivo();
        Task_PostCrearUsuario task_postcrearusuario = new Task_PostCrearUsuario(jeisson);
        //retornar servicio
        String rutaServicio ="src/main/java/ArquitecturaServicios/Recursos/Data/ServicesStructure/Post/01_CrearUsuario.json";
        Object filejson = ser_jsonLeerArchivo.JsonLeerArchivo(rutaServicio);
        //modificar servicio
        String jsonmodificado= ser_01_crearusuario.Generar_01_CrearUsuario(filejson,emailescrito);
        emailescrito = false;
        task_postcrearusuario.EjecutarServicioPost(jsonmodificado);
        codigoRespuesta = LastResponse.received().answeredBy(jeisson).getStatusCode();

        }while (codigoRespuesta==400);
    }
}
