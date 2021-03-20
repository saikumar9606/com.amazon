package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class loginPage {
	WebDriver driver;
	
	
	By btn_signinSecurely = By.xpath("//span[@id=\"nav-link-accountList-nav-line-1\"]");
	By txt_username = By.xpath("//input[@id=\"ap_email\"]");
	By btn_continue = By.xpath("//input[@id=\"continue\"]");
	By txt_password = By.xpath("//input[@id=\"ap_password\"]");
	By btn_signin = By.xpath("//input[@id=\"signInSubmit\"]");
	By btn_cart = By.xpath("//span//span[@class=\"nav-line-2\"]");
	
	public loginPage(WebDriver driver) {
		this.driver = driver;
		
	}
	
	public void SigninSecurely() {
		driver.findElement(btn_signinSecurely).click();
	}
	
	public void Enterusername(String username) {
		driver.findElement(txt_username).sendKeys("9550829606");
	}
	
	public void ClickContinue() {
		driver.findElement(btn_continue).click();
	}
	
	public void Enterpassword(String password) {
		driver.findElement(txt_password).sendKeys("venkatasubbaiah");
	}
	
	public void ClickSignin() {
		driver.findElement(btn_signin).click();
	}
	
	public void VisibleCart() {
		driver.findElement(btn_cart).isDisplayed();
	}
}
