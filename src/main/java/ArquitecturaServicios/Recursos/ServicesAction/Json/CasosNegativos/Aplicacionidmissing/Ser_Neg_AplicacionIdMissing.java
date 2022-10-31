package ArquitecturaServicios.Recursos.ServicesAction.Json.CasosNegativos.Aplicacionidmissing;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.interactions.Get;

import java.util.HashMap;

public class Ser_Neg_AplicacionIdMissing {

    public void Neg_GetSinHeader(Actor actor, HashMap infoServicio){
        String theRestApiBaseUrl = infoServicio.get("UrlBase").toString();
        actor.whoCan(CallAnApi.at(theRestApiBaseUrl));
        actor.attemptsTo(
                Get.resource("/user").
                        with(request -> request.contentType("application/json; charset=utf-8"))
        );

    }
}
