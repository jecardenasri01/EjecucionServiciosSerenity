package ArquitecturaServicios.Serenity.StepDefinition.CasosNegativos.ErrorType;

import ArquitecturaServicios.Recursos.ServicesAction.Global.Ser_JsonFormato;
import ArquitecturaServicios.Serenity.Task.CasosNegativos.ErrorType.Task_Neg_GetConsultarUsuario;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.questions.LastResponse;
import org.junit.Assert;

public class Step_GetEjecucion {
    public static Actor jeisson;

    Task_Neg_GetConsultarUsuario task_neg_getconsultarusuario;
    Ser_JsonFormato ser_jsonFormato;
    public void instanciasBasicas(){
        task_neg_getconsultarusuario = new Task_Neg_GetConsultarUsuario(jeisson);
        ser_jsonFormato = new Ser_JsonFormato(jeisson);

    }
    @Before
    public void EjecutarAntes(){
        jeisson = Actor.named("Jeisson el ingeniero automatizador");
    }

    @Given("^Jeisson ejecuta servicio get user con appid invalido$")
    public void Jeisson_ejecuta_servicio_get_user_con_appid_invalido(){
        instanciasBasicas();
        task_neg_getconsultarusuario.NegativoEjecutarServicioGetHeader();

    }
    @When("^Jeisson obtiene el responce del servicio get user con appid invalido$")
    public void Jeisson_obtiene_el_responce_del_servicio_get_user_con_appid_invalido(){
        instanciasBasicas();
        String responce = ser_jsonFormato.JsonFormato();
        jeisson.should(responce);
    }

    @Then("^Jeisson muestra el codigo de respuesta del servicio con appid invalido$")
    public void Jeisson_muestra_el_codigo_de_respuesta_del_servicio_con_appid_invalido(){

        int codigoRespuesta = LastResponse.received().answeredBy(jeisson).getStatusCode();
        if(200==codigoRespuesta){
            jeisson.should("Finaliza correctamente con el codigo : "+ codigoRespuesta);

        }else{
            Assert.fail("Error El servicio no respondio correctamente : "+codigoRespuesta);
        }
        }
}
