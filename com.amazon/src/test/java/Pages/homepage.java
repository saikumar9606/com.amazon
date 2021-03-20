package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class homepage {
	
	public WebDriver driver;
	
	By txt_search = By.xpath("//input[@id=\"twotabsearchtextbox\"]");
	By btn_search = By.xpath("//input[@id=\"nav-search-submit-button\"]");
	By btn_mobile = By.xpath("//*[@id=\"search\"]/div[1]/div/div[1]/div/span[3]/div[2]/div[3]/div/span/div/div/div[2]/div[2]/div/div[1]/div/div/div[1]/h2/a/span");
	By btn_cart = By.xpath("//input[@id=\"add-to-cart-button\"]");
	By btn_addtocart = By.xpath("//a[@class=\"nav-a nav-a-2 nav-progressive-attribute\"]");
	By btn_pay = By.xpath("//input[@class=\"a-button-input\"and@name=\"proceedToRetailCheckout\"]");
	
	
	
	public homepage(WebDriver driver) {
		this.driver = driver;
		
	}
	
	public void ClickOnSearch() {
		driver.findElement(txt_search).sendKeys("redmi note 9 pro");
	}
	
	public void ClickEnter() {
		driver.findElement(btn_search).click();
	}
	
	public void SelectMobile() {
		driver.findElement(btn_mobile).click();
	}
	
	public void AddToCart() {
		driver.findElement(btn_cart).click();
	}
	
	public void ClickOnCart() {
		driver.findElement(btn_addtocart).click();
	}
	
	public void ProceedToPay() {
		driver.findElement(btn_pay).click();
	}

}
