package ArquitecturaServicios.Recursos.ServicesAction.Json.CasosPositivos.Get;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.interactions.Get;

import java.util.HashMap;

public class Ser_GetEjecucion {

    public void GetJsonEjecutar(Actor actor, HashMap infoServicio){
        String theRestApiBaseUrl = infoServicio.get("UrlBase").toString();
        actor.whoCan(CallAnApi.at(theRestApiBaseUrl));
        actor.attemptsTo(
                Get.resource("/user").
                        with(request -> request.headers("app-id",infoServicio.get("app-id").toString()).contentType("application/json; charset=utf-8"))
        );

    }
}
