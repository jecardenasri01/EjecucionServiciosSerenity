package ArquitecturaServicios.Serenity.StepDefinition.CasosPositivos.Get;

import ArquitecturaServicios.Recursos.ServicesAction.Global.Ser_JsonFormato;
import ArquitecturaServicios.Serenity.Task.CasosPositivos.Get.Task_GetConsultarUsuario;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.questions.LastResponse;
import org.junit.Assert;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.rest.questions.ResponseConsequence.seeThatResponse;

public class Step_GetEjecucion {
    public static Actor jeisson;
    Task_GetConsultarUsuario task_getconsultar;
    Ser_JsonFormato ser_jsonFormato;
    public void instanciasBasicas(){
        task_getconsultar = new Task_GetConsultarUsuario(jeisson);
        ser_jsonFormato = new Ser_JsonFormato(jeisson);

    }
    @Before
    public void EjecutarAntes(){
        jeisson = Actor.named("Jeisson el ingeniero automatizador");
    }

    @Given("^Jeisson ejecuta servicio get user$")
    public void Jeissonejecutaserviciogetuser(){
        instanciasBasicas();
        task_getconsultar.EjecutarServicioGet();
    }
    @When("^Jeisson obtiene el responce del servicio get user$")
    public void Jeissonobtieneelresponcedelserviciogetuser(){
        instanciasBasicas();
        String responce = ser_jsonFormato.JsonFormato();
        jeisson.should(responce);
    }

    @Then("^Jeisson muestra el codigo de respuesta del servicio$")
    public void Jeissonmuestraelcodigoderespuestadelservicio(){
        int codigoRespuesta = LastResponse.received().answeredBy(jeisson).getStatusCode();

        if(200==codigoRespuesta){
            jeisson.should("Finaliza correctamente con el codigo : "+ codigoRespuesta);

        }else{
            Assert.fail("Error El servicio no respondio correctamente : "+codigoRespuesta);
        }
    }
}
