package ArquitecturaServicios.Recursos.ServicesAction.Json.CasosPositivos.Put.GenerarServicio;


import ArquitecturaServicios.Recursos.Data.Actions.Dat_RetonarConfig;
import io.cucumber.core.gherkin.messages.internal.gherkin.internal.com.eclipsesource.json.JsonObject;

import java.util.Random;

public class Ser_01_ModificarUsuario {

    public String  Generar_01_ModificarUsuario(Object obj) {
        Dat_RetonarConfig dat_retonarconfig = new Dat_RetonarConfig();

        Random random = new Random();
        int idcorreo = random.nextInt(90000000);
        ((JsonObject) obj).set("title",dat_retonarconfig.retornarDatos("title","01_ModificarUsuario"));
        ((JsonObject) obj).set("firstName",dat_retonarconfig.retornarDatos("firstName","01_ModificarUsuario"));
        ((JsonObject) obj).set("lastName",dat_retonarconfig.retornarDatos("lastName","01_ModificarUsuario"));
        ((JsonObject) obj).set("picture",dat_retonarconfig.retornarDatos("picture","01_ModificarUsuario"));

        String jsonmodificado= ((JsonObject) obj).toString();
        return jsonmodificado;
    }
}
