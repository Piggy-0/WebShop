package Automation;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Update_Delete_Caterogies {
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
	
//	@Test(priority = 3)
//	public void updateCategories() throws InterruptedException {
//		WebElement buttonProduct = driver.findElement(By.xpath("//*[@id=\"sidenavAccordion\"]/div[1]/div/a[2]"));
//		buttonProduct.click();
//		Thread.sleep(1000);
//		
//		WebElement listCategories = driver.findElement(By.xpath("//*[@id=\"collapseLayouts\"]/nav/a[1]"));
//		listCategories.click();
//		Thread.sleep(1000);
//		
//		WebElement btnDetails = driver.findElement(By.xpath("//*[@id=\"layoutSidenav_content\"]/app-list-categories/div[2]/table/tbody/tr[2]/td[2]/button[1]"));
//		btnDetails.click();
//		
//		WebElement inputName = driver.findElement(By.xpath("//*[@id=\"Name\"]"));
//		inputName.sendKeys("12");
//		Thread.sleep(1000);
//		
//		WebElement btnAdd = driver.findElement(By.xpath("//*[@id=\"addModal\"]/div/div/div[2]/form/button"));
//		btnAdd.click();
//		Thread.sleep(1000);
//		
//		driver.quit();
//		System.out.println("Cập nhật danh mục thành công!");
//	}
	
	@Test(priority = 3)
	public void deleteCategories() throws InterruptedException {
		WebElement buttonProduct = driver.findElement(By.xpath("//*[@id=\"sidenavAccordion\"]/div[1]/div/a[2]"));
		buttonProduct.click();
		Thread.sleep(1000);
		
		WebElement listCategories = driver.findElement(By.xpath("//*[@id=\"collapseLayouts\"]/nav/a[1]"));
		listCategories.click();
		Thread.sleep(1000);
		
		WebElement btnDelete = driver.findElement(By.xpath("//*[@id=\"layoutSidenav_content\"]/app-list-categories/div[2]/table/tbody/tr[4]/td[2]/button[2]"));
		btnDelete.click();
		Thread.sleep(1000);
		
		driver.quit();
		System.out.println("Xóa danh mục thành công!");
	}
}
