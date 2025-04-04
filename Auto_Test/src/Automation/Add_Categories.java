package Automation;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Add_Categories {
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
	public void addCategories() throws InterruptedException {
		WebElement buttonProduct = driver.findElement(By.xpath("//*[@id=\"sidenavAccordion\"]/div[1]/div/a[2]"));
		buttonProduct.click();
		Thread.sleep(1000);
		
		WebElement listCategories = driver.findElement(By.xpath("//*[@id=\"collapseLayouts\"]/nav/a[1]"));
		listCategories.click();
		Thread.sleep(1000);
		
		WebElement btnAdd = driver.findElement(By.xpath("//*[@id=\"layoutSidenav_content\"]/app-list-categories/button"));
		btnAdd.click();
		
		WebElement inputName = driver.findElement(By.xpath("//*[@id=\"name\"]"));
		inputName.sendKeys("Luu dep trai 3");
		Thread.sleep(1000);
		
		WebElement btnThemDonHang = driver.findElement(By.xpath("//*[@id=\"layoutSidenav_content\"]/app-create-categories/form/button"));
		btnThemDonHang.click();
		Thread.sleep(2000);
		
		driver.quit();
		System.out.println("Thêm danh mục thành công!");
	}
}
