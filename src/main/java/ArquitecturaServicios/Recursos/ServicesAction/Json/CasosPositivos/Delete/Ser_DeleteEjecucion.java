package ArquitecturaServicios.Recursos.ServicesAction.Json.CasosPositivos.Delete;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.interactions.Delete;

import java.util.HashMap;

public class Ser_DeleteEjecucion {

    public void DeleteJsonEjecutar(Actor actor, HashMap infoServicio,String idcliente){
        String theRestApiBaseUrl = infoServicio.get("UrlBase").toString();
        actor.whoCan(CallAnApi.at(theRestApiBaseUrl));
        actor.attemptsTo(
                Delete.from("/user/"+idcliente).
                        with(request -> request.headers("app-id",infoServicio.get("app-id").toString()).contentType("application/json; charset=utf-8"))
        );

    }
}
