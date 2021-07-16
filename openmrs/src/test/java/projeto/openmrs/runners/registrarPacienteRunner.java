package projeto.openmrs.runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/Feature/registrarpaciente.feature", 
				 glue = "projeto.openmrs.stepsdefinitions", 
				 tags = "@registrarPaciente",
				 monochrome = true)

public class registrarPacienteRunner {

}
