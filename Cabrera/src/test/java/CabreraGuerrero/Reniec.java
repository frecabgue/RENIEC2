package CabreraGuerrero;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Reniec {

	private WebDriver driver;
	
	By PeruanosenelExtranjero = By.linkText("Peruanos en el Extranjero");
	By Page1Locator = By.xpath("//*[@id=\"seleccion\"]/table/tbody/tr[1]/td/span");
	By ConsuladosenelMundo = By.linkText("CONSULADOS EN EL MUNDO");
	By ListaConsuladosenelMundo = By.linkText("Lista de Consulados en el mundo");
	
	By Page2Locator = By.className("map_titulo-seccion");
	By nombre = By.id("txtSearch");
	By botonbuscar = By.xpath("//*[@id=\"ctl00_PlaceHolderMain_g_f7685c60_a054_442d_bbdf_c5b4207b1300_ctl00_divCuerpo\"]/div[1]/div[3]/table/tbody/tr/td/a/img");
	
	By Page3Locator = By.className("ms-dlgTitleText");
	
	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver","./src/test/resources/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.reniec.gob.pe/portal/masServiciosLinea.htm");
	}
	
	@Test
	public void testGooglePage() throws InterruptedException {
		
		driver.findElement(PeruanosenelExtranjero).click();
		Thread.sleep(3000);
		
		if(driver.findElement(Page1Locator).isDisplayed()) {
			driver.findElement(ConsuladosenelMundo).click();
			Thread.sleep(3000);
			if(driver.findElement(ListaConsuladosenelMundo).isDisplayed()) {
				driver.get("http://www.consulado.pe/paginas/Inicio.aspx");
				if(driver.findElement(Page2Locator).isDisplayed()) {
					driver.findElement(nombre).sendKeys("Cuenca");
					driver.findElement(botonbuscar).click();
					   if(driver.findElement(Page3Locator).isDisplayed()){
						   driver.get("https://www.reniec.gob.pe/portal/masServiciosLinea.htm");
					   }else {
						   System.out.print("error");
					   }
				}else {
					System.out.print("error");		
				}
			}else {
			System.out.print("error");	
			}
		}
		else {
			System.out.print("error");
		}
		
	}
	
	@After
	
	public void tearDown() throws Exception {
	//driver.quit();
	}
}
