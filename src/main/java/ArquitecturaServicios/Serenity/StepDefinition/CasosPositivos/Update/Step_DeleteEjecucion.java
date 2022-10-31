package ArquitecturaServicios.Serenity.StepDefinition.CasosPositivos.Update;

import ArquitecturaServicios.Recursos.ServicesAction.Global.Ser_JsonFormato;
import ArquitecturaServicios.Serenity.Task.CasosPositivos.Update.Task_UpdateConsultarUsuario;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.questions.LastResponse;
import org.junit.Assert;

public class Step_DeleteEjecucion {
    public static Actor jeisson;
    Task_UpdateConsultarUsuario task_updateConsultarUsuario;
    Ser_JsonFormato ser_jsonFormato;
    public void instanciasBasicas(){
        task_updateConsultarUsuario = new Task_UpdateConsultarUsuario(jeisson);
        ser_jsonFormato = new Ser_JsonFormato(jeisson);

    }
    @Before
    public void EjecutarAntes(){
        jeisson = Actor.named("Jeisson el ingeniero automatizador");
    }

    @Given("^Jeisson ejecuta servicio modificar user$")
    public void Jeisson_ejecuta_servicio_modificar_user(){
        instanciasBasicas();
        task_updateConsultarUsuario.EjecutarServicioUpdate();
    }
    @When("^Jeisson obtiene el responce del servicio modificar user$")
    public void Jeisson_obtiene_el_responce_del_servicio_modificar_user(){
        instanciasBasicas();
        String responce = ser_jsonFormato.JsonFormato();
        jeisson.should(responce);
    }

    @Then("^Jeisson muestra el codigo de respuesta del servicio modificar user$")
    public void Jeisson_muestra_el_codigo_de_respuesta_del_servicio_modificar_user(){
        int codigoRespuesta = LastResponse.received().answeredBy(jeisson).getStatusCode();
        if(200==codigoRespuesta){
            jeisson.should("Finaliza correctamente con el codigo : "+ codigoRespuesta);

        }else{
            Assert.fail("Error El servicio no respondio correctamente : "+codigoRespuesta);
        }
    }
}
