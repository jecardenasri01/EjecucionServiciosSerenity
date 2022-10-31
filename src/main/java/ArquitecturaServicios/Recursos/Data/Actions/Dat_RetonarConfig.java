package ArquitecturaServicios.Recursos.Data.Actions;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class Dat_RetonarConfig {

    public String retornarDatos(String dato,String entidad) {
        String archivoconfig=null;
        String datoNuevo=null;
        try{
            Properties propiedades =new Properties();
            InputStream datos =null;
            archivoconfig=RetornarRuta(entidad);
            datos = new FileInputStream(archivoconfig);
            propiedades.load(datos);
            datoNuevo=   propiedades.getProperty(dato);
        }catch (Exception fallo){
            new AssertionError("No se lleno la entidad "+archivoconfig );
        }
        return datoNuevo;
    }
    public String RetornarRuta(String entidad){
        String rutaconfig=null;
        String rutaPropiedades = "src/main/java/ArquitecturaServicios/Recursos/Data/Propiedades";

        switch (entidad){
            case  "Dat_GeneralPropiedades":
                rutaconfig= rutaPropiedades+"/General/"+entidad+".properties";
                break;
            case  "Dat_NegativoGeneralPropiedades":
                rutaconfig= rutaPropiedades+"/General/"+entidad+".properties";
                break;
            case  "01_CrearUsuario":
                rutaconfig= rutaPropiedades+"/Especificos/Post/"+entidad+".properties";
                break;
            case  "01_DeleteUsuario":
                rutaconfig= rutaPropiedades+"/Especificos/Delete/"+entidad+".properties";
                break;
            case  "01_NegativoDeleteUsuario":
                rutaconfig= rutaPropiedades+"/Especificos/Delete/"+entidad+".properties";
                break;
            case  "01_ModificarUsuario":
                rutaconfig= rutaPropiedades+"/Especificos/Put/"+entidad+".properties";
                break;
        }
        return  rutaconfig;
    }
}
