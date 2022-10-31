package ArquitecturaServicios.Serenity.StepDefinition.CasosNegativos.BodyInvalid;

import ArquitecturaServicios.Recursos.ServicesAction.Global.Ser_JsonFormato;
import ArquitecturaServicios.Serenity.Task.CasosNegativos.BodyInvalid.Task_Neg_BodyInvalid;
import ArquitecturaServicios.Serenity.Task.CasosPositivos.Post.Task_PostEjecutarCrearUsuarioBase;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.questions.LastResponse;
import org.junit.Assert;

public class Step_PostBodyInvalid {
    public static Actor jeisson;

    Task_Neg_BodyInvalid taskNegBodyInvalid;
    Ser_JsonFormato ser_jsonFormato;

    public void instanciasBasicas() {
        taskNegBodyInvalid = new Task_Neg_BodyInvalid(jeisson);
        ser_jsonFormato = new Ser_JsonFormato(jeisson);


    }

    @Before
    public void EjecutarAntes() {
        jeisson = Actor.named("Jeisson el ingeniero automatizador");
    }

    @Given("^Jeisson_ejecuta_servicio_create_user_con_body_erroneo$")
    public void Jeisson_ejecuta_servicio_create_user_con_body_erroneo() {
        instanciasBasicas();
        taskNegBodyInvalid.ObtenerCrearUsuarioBase();
    }

    @When("^Jeisson_obtiene_el_responce_del_servicio_create_user_con_body_erroneo$")
    public void Jeisson_obtiene_el_responce_del_servicio_create_user_con_body_erroneo() {
        instanciasBasicas();
        String responce = ser_jsonFormato.JsonFormato();
        jeisson.should(responce);
    }

    @Then("^Jeisson_muestra_el_codigo_de_respuesta_del_servicio_con_body_erroneo$")
    public void Jeisson_muestra_el_codigo_de_respuesta_del_servicio_con_body_erroneo() {
        int codigoRespuesta = LastResponse.received().answeredBy(jeisson).getStatusCode();
        if(200==codigoRespuesta){
            jeisson.should("Finaliza correctamente con el codigo : "+ codigoRespuesta);

        }else{
            Assert.fail("Error El servicio no respondio correctamente : "+codigoRespuesta);
        }
    }
}
