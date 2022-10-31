package ArquitecturaServicios.Recursos.ServicesAction.Json.CasosPositivos.Post;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.interactions.Post;

import java.util.HashMap;

public class Ser_PostEjecucion {

    public void PostJsonEjecutar(Actor actor, HashMap infoServicio,String requestbodys){

        String theRestApiBaseUrl = infoServicio.get("UrlBase").toString();
        actor.whoCan(CallAnApi.at(theRestApiBaseUrl));
        actor.attemptsTo(
                Post.to("/user/create").
                        with(request ->
                                request.headers("app-id",infoServicio.get("app-id")).
                                        body(requestbodys).contentType("application/json; charset=utf-8")

                        )
        );

    }
}
