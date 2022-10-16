package stepdefinitions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginStepDef {
	
	WebDriver driver = Hooks.driver;
	@Given("I have launched the application")
	public void i_have_launched_the_application() {
	    // Write code here that turns the phrase above into concrete actions
	    
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		
		
	}

	@When("I enter a correct {string} and {string}")
	public void i_enter_a_correct_and(String UserNameVal, String PasswordVal) {
	    // Write code here that turns the phrase above into concrete actions
	    WebElement username = driver.findElement(By.id("user-name"));
	    username.sendKeys(UserNameVal);
	    
	    WebElement password = driver.findElement(By.id("password"));
	    password.sendKeys(PasswordVal);
	}

	@When("I click on Login button")
	public void i_click_on_Login_button() {
	    // Write code here that turns the phrase above into concrete actions
		WebElement LoginButton = driver.findElement(By.id("login-button"));
		LoginButton.click();
	}

	@Then("I should land on home page")
	public void i_should_land_on_home_page() {
	    // Write code here that turns the phrase above into concrete actions
	  //  driver.switchTo().alert().accept();
	}

	@When("I enter an incorrect {string} and {string}")
	public void i_enter_an_incorrect_and(String UserNameVal, String PasswordVal) {
	    // Write code here that turns the phrase above into concrete actions
		  WebElement username = driver.findElement(By.id("user-name"));
		    username.sendKeys(UserNameVal);
		    
		    WebElement password = driver.findElement(By.id("password"));
		    password.sendKeys(PasswordVal);
	}

	@Then("I should get an error message {string}")
	public void i_should_get_an_error_message(String ExpError) {
	    // Write code here that turns the phrase above into concrete actions
	    WebElement Error = driver.findElement(By.xpath("//h3[@data-test='error']"));
	    
	    String ActualError = Error.getText();
	    Assert.assertEquals(ExpError, ActualError);
	}

}
