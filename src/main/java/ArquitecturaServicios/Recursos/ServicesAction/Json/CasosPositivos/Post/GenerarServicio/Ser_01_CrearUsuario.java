package ArquitecturaServicios.Recursos.ServicesAction.Json.CasosPositivos.Post.GenerarServicio;


import ArquitecturaServicios.Recursos.Data.Actions.Dat_RetonarConfig;
import io.cucumber.core.gherkin.messages.internal.gherkin.internal.com.eclipsesource.json.JsonObject;

import java.util.Random;


import static io.cucumber.core.gherkin.messages.internal.gherkin.internal.com.eclipsesource.json.Json.parse;

public class Ser_01_CrearUsuario {
    public String  Generar_01_CrearUsuario(Object obj,boolean correousado) {
        Dat_RetonarConfig dat_retonarconfig = new Dat_RetonarConfig();

        Random random = new Random();
        int idcorreo = random.nextInt(90000000);
        ((JsonObject) obj).set("title",dat_retonarconfig.retornarDatos("title","01_CrearUsuario"));
        ((JsonObject) obj).set("firstName",dat_retonarconfig.retornarDatos("firstName","01_CrearUsuario"));
        ((JsonObject) obj).set("lastName",dat_retonarconfig.retornarDatos("lastName","01_CrearUsuario"));
        ((JsonObject) obj).set("picture",dat_retonarconfig.retornarDatos("picture","01_CrearUsuario"));

        if(correousado){
        ((JsonObject) obj).set("email",dat_retonarconfig.retornarDatos("email","01_CrearUsuario"));
        }else{
            ((JsonObject) obj).set("email","Test"+idcorreo+"@gmail.com");
        }
        String jsonmodificado= ((JsonObject) obj).toString();
        return jsonmodificado;
    }
}
