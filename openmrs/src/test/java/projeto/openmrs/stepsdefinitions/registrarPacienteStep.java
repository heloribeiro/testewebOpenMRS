package projeto.openmrs.stepsdefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

public class registrarPacienteStep {

	static WebDriver driver;

	@Dado("que acesso o site OpenMRS")
	public void que_acesso_o_site_OpenMRS() {

		System.setProperty("webdriver.chrome.driver", "C:/chromedriver_win32/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://demo.openmrs.org/openmrs/login.htm");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);

	}

	@E("coloco meu login e senha")
	public void coloco_meu_login_e_senha() {

		// Username
		driver.findElement(By.id("username")).sendKeys("Admin");
		// Password
		driver.findElement(By.id("password")).sendKeys("Admin123");

	}

	@E("clico na opção InpacientWard")
	public void clico_na_opção_InpacientWard() {

		// Em Location for this session
		driver.findElement(By.id("Inpatient Ward")).click();

	}

	@E("clico em Log In")
	public void clico_em_Log_In() {

		driver.findElement(By.id("loginButton")).click();

	}

	@Quando("logo na pagina clico em Registrar Paciente")
	public void logo_na_pagina_clico_em_Registrar_Paciente() {

		driver.findElement(By.linkText("Register a patient")).click();

	}

	@E("informo todos os dados do paciente")
	public void informo_todos_os_dados_do_paciente() {

		/*-----Name-What's the patient's name?-----*/
		// Given
		driver.findElement(By.name("givenName")).sendKeys("Maria");
		// Middle
		driver.findElement(By.name("middleName")).sendKeys("Santana");
		// FamilyName
		driver.findElement(By.name("familyName")).sendKeys("Santos");
		// BotãoAvançar
		driver.findElement(By.id("next-button")).click();

		/*-----Gender-----*/
		WebElement gender = driver.findElement(By.id("gender-field"));
		Select genero = new Select(gender);
		genero.selectByValue("F");
		// BotãoAvançar
		driver.findElement(By.id("next-button")).click();

		/*-----What's the patient's birth date?-----*/
		// Day
		driver.findElement(By.id("birthdateDay-field")).sendKeys("8");
		// Month
		WebElement birthday = driver.findElement(By.id("birthdateMonth-field"));
		Select aniversario = new Select(birthday);
		aniversario.selectByValue("4");
		// Year
		driver.findElement(By.id("birthdateYear-field")).sendKeys("1963");
		// BotãoAvançar
		driver.findElement(By.id("next-button")).click();

		/*-----What is the patient's address?-----*/
		// Address
		driver.findElement(By.id("address1")).sendKeys("Rua amarela, B");
		// Address2
		driver.findElement(By.id("address2")).sendKeys("Rua Azul, C");
		// City/Village
		driver.findElement(By.id("cityVillage")).sendKeys("Rio de Janeiro");
		// State/Province
		driver.findElement(By.id("stateProvince")).sendKeys("RJ");
		// Country
		driver.findElement(By.id("country")).sendKeys("Brazil");
		// PostalCode
		driver.findElement(By.id("postalCode")).sendKeys("20240080");
		// BotãoAvançar
		driver.findElement(By.id("next-button")).click();

		/*-----What's the patient phone number?-----*/
		driver.findElement(By.name("phoneNumber")).sendKeys("999999999");
		// BotãoAvançar
		driver.findElement(By.id("next-button")).click();

		/*-----Who is the patient related to?-----*/
		// Selection Relationship Type
		WebElement relationship = driver.findElement(By.id("relationship_type"));
		Select relacionamento = new Select(relationship);
		relacionamento.selectByValue("8d91a3dc-c2cc-11de-8d13-0010c6dffd0f-B");
		// Person Name
		driver.findElement(By.className("person-typeahead")).sendKeys("Amanda");
		// BotãoAvançar
		driver.findElement(By.id("next-button")).click();

	}
	
	@Entao("clico em confirmar e tenho os dados registrados")
	public void clico_em_confirmar_e_tenho_os_dados_registrados() {
		driver.findElement(By.id("submit")).click();
		
		
	}
}
