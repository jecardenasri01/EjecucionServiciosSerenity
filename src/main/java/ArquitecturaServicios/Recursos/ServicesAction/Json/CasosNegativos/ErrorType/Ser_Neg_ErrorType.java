package ArquitecturaServicios.Recursos.ServicesAction.Json.CasosNegativos.ErrorType;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import net.serenitybdd.screenplay.rest.interactions.Get;

import java.util.HashMap;

public class Ser_Neg_ErrorType {

    public void Neg_GetErrorType(Actor actor, HashMap infoServicio){
        String theRestApiBaseUrl = infoServicio.get("UrlBase").toString();
        actor.whoCan(CallAnApi.at(theRestApiBaseUrl));
        actor.attemptsTo(
                Get.resource("/user").
                        with(request -> request.headers("app-id",infoServicio.get("app-id")).contentType("application/json; charset=utf-8"))
        );

    }
}
