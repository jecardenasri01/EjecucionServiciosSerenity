package ArquitecturaServicios.Recursos.ServicesAction.Global;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.questions.LastResponse;

public class Ser_JsonFormato {
    Actor jeisson;
    JsonParser parser;
    Gson gson;

    public Ser_JsonFormato(Actor _jeisson) {
        jeisson = _jeisson;
    }

    public void InstanciasBasicas() {
        parser = new JsonParser();
        gson = new GsonBuilder().setPrettyPrinting().create();
    }

    public String JsonFormato() {
        InstanciasBasicas();
        JsonParser parser = new JsonParser();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String responce = LastResponse.received().answeredBy(jeisson).asString();
        JsonElement el = parser.parse(responce);
        responce = gson.toJson(el);
        return responce;
    }
}
