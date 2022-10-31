package Runner;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        plugin = {"pretty"},
        features = "src/test/resources/features/PruebasUnitarias",
    //    tags = "@neg_getserviciosbodyincorrecto",
        glue = {"ArquitecturaServicios.Recursos","ArquitecturaServicios.Serenity"}
)
public class JeissonTest {
    public void escribir(){
        System.out.println("abd");
    }
}
