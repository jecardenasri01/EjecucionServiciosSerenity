package ArquitecturaServicios.Serenity.StepDefinition.CasosNegativos.ParamsNoValid;

import ArquitecturaServicios.Recursos.ServicesAction.Global.Ser_JsonFormato;
import ArquitecturaServicios.Serenity.Task.CasosPositivos.Delete.Task_DeleteConsultarUsuario;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.questions.LastResponse;
import org.junit.Assert;

public class Step_DeleteParamsNoValid {
    public static Actor jeisson;
    Task_DeleteConsultarUsuario task_deleteConsultarUsuario;
    Ser_JsonFormato ser_jsonFormato;
    public void instanciasBasicas(){
        task_deleteConsultarUsuario = new Task_DeleteConsultarUsuario(jeisson);
        ser_jsonFormato = new Ser_JsonFormato(jeisson);

    }
    @Before
    public void EjecutarAntes(){
        jeisson = Actor.named("Jeisson el ingeniero automatizador");
    }

    @Given("^Jeisson_ejecuta_servicio_delete_user_con_id_inexistente$")
    public void Jeisson_ejecuta_servicio_delete_user_con_id_inexistente(){
        instanciasBasicas();
        task_deleteConsultarUsuario.EjecutarServicioIdInexistente();
    }
    @When("^Jeisson_obtiene_el_responce_del_servicio_delete_user_con_id_inexistente$")
    public void Jeisson_obtiene_el_responce_del_servicio_delete_user_con_id_inexistente(){
        instanciasBasicas();
        String responce = ser_jsonFormato.JsonFormato();
        jeisson.should(responce);
    }

    @Then("^Jeisson_muestra_el_codigo_de_respuesta_del_servicio_con_id_inexistente$")
    public void Jeisson_muestra_el_codigo_de_respuesta_del_servicio_con_id_inexistente(){
        int codigoRespuesta = LastResponse.received().answeredBy(jeisson).getStatusCode();
        if(200==codigoRespuesta){
            jeisson.should("Finaliza correctamente con el codigo : "+ codigoRespuesta);

        }else{
            Assert.fail("Error El servicio no respondio correctamente : "+codigoRespuesta);
        }
    }
}
