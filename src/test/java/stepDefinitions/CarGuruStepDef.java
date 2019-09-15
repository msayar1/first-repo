package stepDefinitions;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import pages.CarGuruHomePage;
import utils.ConfigurationReader;
import utils.Driver;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class CarGuruStepDef {
	WebDriver driver;
	CarGuruHomePage CarGuruHomePage = new CarGuruHomePage();
	List<String> CarGurulistOfTopMenus = new ArrayList<>();

	@Given("I am on CarGuru's Home Page")
	public void i_am_on_CarGuru_s_Home_Page() {
		driver = Driver.getDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.navigate().to(ConfigurationReader.getProperty("url"));
	}

	@Then("I now get all menus from top")
	public void i_now_get_all_menus_from_top() {
		CarGurulistOfTopMenus.add("Used Cars");
		CarGurulistOfTopMenus.add("New Cars");
		CarGurulistOfTopMenus.add("Car Values");
		CarGurulistOfTopMenus.add("Sell My Car");
		CarGurulistOfTopMenus.add("Research");
		CarGurulistOfTopMenus.add("Questions");
	}

	@And("I verify all the menus are exist")
	public void i_verify_all_the_menus_are_exist() {
		int i = 0;
		for (WebElement element : CarGuruHomePage.CarGrurutopMenuBars) {
			Assert.assertTrue(element.isDisplayed());
			Assert.assertEquals(CarGurulistOfTopMenus.get(i), element.getText());
			i++;
		}
	}

}
