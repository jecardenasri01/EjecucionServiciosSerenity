package ArquitecturaServicios.Serenity.StepDefinition.CasosNegativos.ApliccacionIdMissin;

import ArquitecturaServicios.Recursos.ServicesAction.Global.Ser_JsonFormato;
import ArquitecturaServicios.Serenity.Task.CasosNegativos.AplicacionIdMissing.Task_Neg_GetSinHeader;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.questions.LastResponse;
import org.junit.Assert;

public class Step_GetSinHeader {
    public static Actor jeisson;

    Task_Neg_GetSinHeader task_neg_getSinHeader;
    Ser_JsonFormato ser_jsonFormato;
    public void instanciasBasicas(){
        task_neg_getSinHeader = new Task_Neg_GetSinHeader(jeisson);
        ser_jsonFormato = new Ser_JsonFormato(jeisson);

    }
    @Before
    public void EjecutarAntes(){
        jeisson = Actor.named("Jeisson el ingeniero automatizador");
    }

    @Given("^Jeisson_ejecuta_servicio_get_user_sin_enviar_app-id$")
    public void Jeisson_ejecuta_servicio_get_user_sin_enviar_app_id(){
        instanciasBasicas();
        task_neg_getSinHeader.NegativoEjecutarServicioGetHeader();

    }
    @When("^Jeisson_obtiene_el_responce_del_servicio_get_user_sin_enviar_app-id$")
    public void Jeisson_obtiene_el_responce_del_servicio_get_user_sin_enviar_app_id(){
        instanciasBasicas();
        String responce = ser_jsonFormato.JsonFormato();
        jeisson.should(responce);
    }

    @Then("^Jeisson_muestra_el_codigo_de_respuesta_del_servicio_sin_enviar_app-id$")
    public void Jeisson_muestra_el_codigo_de_respuesta_del_servicio_sin_enviar_app_id(){
        int codigoRespuesta = LastResponse.received().answeredBy(jeisson).getStatusCode();
        if(200==codigoRespuesta){
            jeisson.should("Finaliza correctamente con el codigo : "+ codigoRespuesta);

        }else{
            Assert.fail("Error El servicio no respondio correctamente : "+codigoRespuesta);
        }
    }
}
