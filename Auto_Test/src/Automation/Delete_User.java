package Automation;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Delete_User {
	private WebDriver driver;
	@Test(priority = 1)
	public void openBrowser() {
		//Mở trang web 
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	@Test(priority = 2)
	public void loginAdmin() throws InterruptedException {
		//Chuyển đến trang home
		driver.get("http://localhost:4200/home/login");
		//WebElement buttonLogin = driver.findElement(By.xpath("//*[@id=\"login-btn\"]"));
		JavascriptExecutor jjs = (JavascriptExecutor) driver;
        jjs.executeScript("window.scrollBy(0, 300)");
        
        WebElement userName = driver.findElement(By.xpath("//*[@id=\"username\"]"));
        userName.sendKeys("Nguyen Van A");
        Thread.sleep(1000);
        
        WebElement passWord = driver.findElement(By.xpath("//*[@id=\"password\"]"));
        passWord.sendKeys("123");
        Thread.sleep(1000);
        
        WebElement buttonSubmit = driver.findElement(By.xpath("/html/body/app-root/app-home/div[2]/app-login/div/div/form/button"));
        buttonSubmit.click();
	}
	
	@Test(priority = 3)
	public void deleteUser() throws InterruptedException {
		 WebElement buttonUserManagement = driver.findElement(By.xpath("//*[@id=\"sidenavAccordion\"]/div[1]/div/a[3]"));
		 buttonUserManagement.click();
	     Thread.sleep(1000);
	     
	     WebElement listUser = driver.findElement(By.xpath("//*[@id=\"sidenavAccordionPages\"]/a"));
	     listUser.click();
	     Thread.sleep(1000);
	     
	     WebElement btnDelete = driver.findElement(By.xpath("//*[@id=\"layoutSidenav_content\"]/app-list-users/div[2]/table/tbody/tr[2]/td[6]/button[2]"));
	     btnDelete.click();
	     Thread.sleep(1000);
	}
}
