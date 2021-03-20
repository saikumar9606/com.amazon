package com.amazonStepDefinitions;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Pages.homepage;
import Pages.loginPage;
import io.cucumber.java.en.*;

public class loginSteps {
	WebDriver driver = null;
	loginPage login;
	String browser;
	homepage home;
	
	@Given("Browser is in open")
	public void browser_is_in_open() {
		browser = "chrome";
		if(browser.equalsIgnoreCase("chrome")) {
			String projectPath =System.getProperty("user.dir");
			System.out.println(projectPath);
			System.setProperty("webdriver.chrome.driver", projectPath+"\\src\\test\\resources\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			driver.manage().window().maximize();
		} else if(browser.equalsIgnoreCase("firefox")) {
			String projectPath =System.getProperty("user.dir");
			System.out.println(projectPath);
			System.setProperty("webdriver.gecko.driver", projectPath+"\\src\\test\\resources\\drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			driver.manage().window().maximize();
		} else {
			System.out.println("Provide correct browser name");
		}
	}

	@And("Navigate to login page")
	public void navigate_to_login_page() throws InterruptedException {
		driver.get("https://www.amazon.in/");
		Thread.sleep(5000);
	}

	@When("^user enters valid (.*) and (.*)$")
	public void user_enters_valid_username_and_password(String username,String password) {
		login = new loginPage(driver);
		
		login.SigninSecurely();
		login.Enterusername(username);
		login.ClickContinue();
		login.Enterpassword(password);
		
		
	}

	@And("Cick on login button")
	public void cick_on_login_button() throws InterruptedException {
		login.ClickSignin();
		Thread.sleep(10000);
	}

	@Then("Navigate to Home page")
	public void navigate_to_home_page() {
		login.VisibleCart();
		System.out.println("cart object is found");
	}
	
	
	
	@Given("home page is opened")
	public void home_page_is_opened() {
		home = new homepage(driver);
		home.ClickOnSearch();
		
	}

	@When("user search the redmi note 9 pro mobile")
	public void user_search_the_redmi_note_9_pro_mobile() throws InterruptedException {
		home.ClickEnter();
		Thread.sleep(10000);
	}

	@When("click on required mobile")
	public void click_on_required_mobile() throws InterruptedException {
		try {
			home.SelectMobile();
		}catch (NoSuchElementException e) {
			System.out.println("NoSuchElementException Found");
		}
		
		Thread.sleep(10000);
	}

	@Then("add that mobile to cart")
	public void add_that_mobile_to_cart() {
		Set<String> handler = driver.getWindowHandles();
		Iterator<String> it =handler.iterator();
		
		String parentwindowid = it.next();
		System.out.println("parentwindowid"+parentwindowid);
		String childwindowid = it.next();
		System.out.println("childwindowid"+childwindowid);
		
		driver.switchTo().window(childwindowid);
		System.out.println(driver.getTitle());
		
		
		home.AddToCart();
		
		
	}
	
	@Given("home page is opened and click on cart")
	public void home_page_is_opened_and_click_on_cart() throws InterruptedException {
		Thread.sleep(8000);
		home = new homepage(driver);
		home.ClickOnCart();
		
	}

	@When("user click on proceed to pay")
	public void user_click_on_proceed_to_pay() {
		home.ProceedToPay();
	}
	

	@And("enter the address")
	public void enter_the_address() {
		driver.close();
		driver.quit();
	}



	
	

}
