package ArquitecturaServicios.Recursos.ServicesAction.Global;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.questions.LastResponse;

import java.io.FileReader;

import static io.cucumber.core.gherkin.messages.internal.gherkin.internal.com.eclipsesource.json.Json.parse;

public class Ser_JsonLeerArchivo {
    public Object JsonLeerArchivo(String archivoruta) {
        String Servicio = null;
        Object obj = null;

        try{
        JsonParser parser = new JsonParser();
        obj= parse(new FileReader(archivoruta));
        Servicio = obj.toString();
        }catch (Exception fallo){
            System.out.println(fallo.getMessage());
        }
        return obj;

    }
}
