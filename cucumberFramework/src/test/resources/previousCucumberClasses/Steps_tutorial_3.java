package stepDefinitions;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import managers.PageObjectManager;
import pageObjects.CartPage;
import pageObjects.CheckoutPage;
import pageObjects.HomePage;
import pageObjects.ProductListingPage;

public class Steps_tutorial_3 {
	WebDriver driver;
	HomePage home;
	ProductListingPage productListingPage;
	CartPage cartPage;	
	CheckoutPage checkoutPage;
		
	@Given("^user is on Home page$")
	public void user_is_on_Home_page() throws Throwable {
		System.setProperty("webdriver.chrome.driver",
				"C:/Users/haris/OneDrive/Documents/libs/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://www.shop.demoqa.com");
	}

	@When("^he search for \"([^\"]*)\"$")
	public void he_search_for(String product) throws Throwable {
		home = new HomePage(driver);
		home.perform_Search(product);
	}
	

	@When("^choose to buy the first item$")
	public void choose_to_buy_the_first_item() throws Throwable {
		productListingPage = new ProductListingPage(driver);
		productListingPage.select_Product(0);
		productListingPage.clickOn_AddToCart();	
	}

	@When("^moves to checkout from mini cart$")
	public void moves_to_checkout_from_mini_cart() throws Throwable {
		cartPage = new CartPage(driver);
		cartPage.clickOn_Cart();
		cartPage.clickOn_ContinueToCheckout();	
	}

	@When("^enter personal details on checkout page$")
	public void enter_personal_details_on_checkout_page() throws Throwable {
		checkoutPage = new CheckoutPage(driver);
		checkoutPage.fill_PersonalDetails();
	}

	@When("^Select same delivery address$")
	public void select_same_delivery_address() throws Throwable {
		checkoutPage.check_ShipToDifferentAddress(false);
	}

	@When("^Select payment method as \"([^\"]*)\" payment$")
	public void select_payment_method_as_payment(String arg1) throws Throwable {
		checkoutPage.select_PaymentMethod("CheckPayment");
	}

	@When("^place the order$")
	public void place_the_order() throws Throwable {
		checkoutPage.check_TermsAndCondition(true);
		checkoutPage.clickOn_PlaceOrder();
	}

	@Then("^browser close$")
	public void browser_close() throws Throwable {
		driver.close();
		driver.quit();
	}


}
