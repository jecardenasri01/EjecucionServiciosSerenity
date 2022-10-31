package ArquitecturaServicios.Recursos.ServicesAction.Json.CasosPositivos.Put;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.interactions.Put;

import java.util.HashMap;

public class Ser_PutEjecucion {

    public void PutJsonEjecutar(Actor actor, HashMap infoServicio,String idcliente,String requestbodys){
        String theRestApiBaseUrl = infoServicio.get("UrlBase").toString();
        actor.whoCan(CallAnApi.at(theRestApiBaseUrl));
        actor.attemptsTo(
                Put.to("/user/"+idcliente).
                        with(request -> request.headers("app-id",infoServicio.get("app-id").toString()).body(requestbodys).contentType("application/json; charset=utf-8"))
        );

    }
}
