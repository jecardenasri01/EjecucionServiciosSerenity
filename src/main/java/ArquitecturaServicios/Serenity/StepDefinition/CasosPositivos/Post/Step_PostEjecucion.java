package ArquitecturaServicios.Serenity.StepDefinition.CasosPositivos.Post;

import ArquitecturaServicios.Recursos.ServicesAction.Global.Ser_JsonFormato;
import ArquitecturaServicios.Serenity.Task.CasosPositivos.Post.Task_PostEjecutarCrearUsuarioBase;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.questions.LastResponse;
import org.junit.Assert;

public class Step_PostEjecucion {
    public static Actor jeisson;
    Task_PostEjecutarCrearUsuarioBase taskPostEjecutarCrearUsuarioBase;
    Ser_JsonFormato ser_jsonFormato;

    public void instanciasBasicas() {
        taskPostEjecutarCrearUsuarioBase = new Task_PostEjecutarCrearUsuarioBase(jeisson);
        ser_jsonFormato = new Ser_JsonFormato(jeisson);


    }

    @Before
    public void EjecutarAntes() {
        jeisson = Actor.named("Jeisson el ingeniero automatizador");
    }

    @Given("^Jeisson busca correo disponible para usuario nuevo$")
    public void Jeisson_busca_correo_disponible_para_usuario_nuevo() {
        instanciasBasicas();
        taskPostEjecutarCrearUsuarioBase.ObtenerCrearUsuarioBase();
    }

    @When("^Jeisson obtiene el responce del servicio create user$")
    public void Jeisson_obtiene_el_responce_del_servicio_create_user() {
        instanciasBasicas();
        String responce = ser_jsonFormato.JsonFormato();
        jeisson.should(responce);
    }

    @Then("^Jeisson muestra el codigo de respuesta del servicio create user$")
    public void Jeisson_muestra_el_codigo_de_respuesta_del_servicio_create_user() {
        int codigoRespuesta = LastResponse.received().answeredBy(jeisson).getStatusCode();
        if(200==codigoRespuesta){
            jeisson.should("Finaliza correctamente con el codigo : "+ codigoRespuesta);

        }else{
            Assert.fail("Error El servicio no respondio correctamente : "+codigoRespuesta);
        };
    }
}
