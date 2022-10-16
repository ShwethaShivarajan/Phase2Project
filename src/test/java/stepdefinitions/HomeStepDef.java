package stepdefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomeStepDef {
	WebDriver driver = Hooks.driver;

	

	@When("I select the {string} and click on the Add to cart button")
	public void i_click_on_the_Add_to_cart_button(String productval) {
		// Write code here that turns the phrase above into concrete actions
		WebElement product = driver.findElement(By.xpath("//div[text()='"+productval+"']//following::button[1]"));
		product.click();

	}

	@Then("I should see the cart number increased by {int}")
	public void i_should_see_the_cart_number_increased_by(int cartCountExp) {
		
	    // Write code here that turns the phrase above into concrete actions
	//	WebElement product = driver.findElement(By.xpath("//div[text()='Sauce Labs Fleece Jacket']//following::button[1]"));
	//	product.click();
	    WebElement cartNum = driver.findElement(By.xpath("//a/span[@class=\"shopping_cart_badge\"]"));
	    int cartvalActual = Integer.parseInt(cartNum.getText());
	   
	    System.out.println("Cart expected count is " + cartCountExp);
	    System.out.println("Cart actual count is " + cartvalActual);
	    Assert.assertEquals(cartCountExp, cartvalActual);
	}

}
