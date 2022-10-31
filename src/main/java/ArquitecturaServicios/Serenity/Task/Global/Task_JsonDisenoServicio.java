package ArquitecturaServicios.Serenity.Task.Global;

import ArquitecturaServicios.Recursos.Data.Actions.Dat_RetonarConfig;

import java.util.HashMap;

public class Task_JsonDisenoServicio {
    Dat_RetonarConfig dat_retonarconfig;
    HashMap<String, String> infoServicio;

    public void InstanciasBasicas(){
        dat_retonarconfig = new Dat_RetonarConfig();
    }
    public HashMap GetLLenarInformacionServicio(String archivoConfiguracion){
        //retornarInformacion
        InstanciasBasicas();
        String appid = dat_retonarconfig.retornarDatos("app-id",archivoConfiguracion);
        String urlService  =dat_retonarconfig.retornarDatos("urlBase",archivoConfiguracion);
        //crearHasMap
        infoServicio=new HashMap<String,String>();
        infoServicio.put("app-id",appid);
        infoServicio.put("UrlBase",urlService);
        return infoServicio;

    }
}
