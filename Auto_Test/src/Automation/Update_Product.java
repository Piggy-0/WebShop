package Automation;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Update_Product {
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
	public void updateProduct() throws InterruptedException {
		WebElement buttonProductManager = driver.findElement(By.xpath("//*[@id=\"sidenavAccordion\"]/div[1]/div/a[2]"));
		buttonProductManager.click();
		Thread.sleep(1000);
		
		WebElement listProduct = driver.findElement(By.xpath("//*[@id=\"collapseLayouts\"]/nav/a[3]"));
		listProduct.click();
		Thread.sleep(1000);
		
		WebElement btnUpdate = driver.findElement(By.xpath("//*[@id=\"layoutSidenav_content\"]/app-list-products/div[3]/div/div[2]/div/button[1]"));
		btnUpdate.click();
		Thread.sleep(1000);
		
		WebElement uploadInput = driver.findElement(By.xpath("//*[@id=\"image\"]"));
		String filePath = "C:\\Users\\Dell\\Pictures\\Saved Pictures\\maytinhbang.jpg";
		uploadInput.sendKeys(filePath);
		Thread.sleep(2000);
		
//		WebElement inputName = driver.findElement(By.xpath("//*[@id=\"layoutSidenav_content\"]/app-list-products/div[3]/div/div[2]/div/button[1]"));
//		//inputName.clear();
//		inputName.sendKeys("Máy tính bảng");
//		Thread.sleep(1000);
		
		WebElement inputCategory = driver.findElement(By.xpath("//*[@id=\"addModal\"]/div/div/div[2]/form/div[2]/div[2]/div/select"));
		Select dropdown = new Select(inputCategory);
		dropdown.selectByVisibleText("Laptop");
		Thread.sleep(1000);
		
		WebElement inputBrands = driver.findElement(By.xpath("//*[@id=\"addModal\"]/div/div/div[2]/form/div[2]/div[3]/div/select"));
		Select dropdownz = new Select(inputBrands);
		dropdownz.selectByVisibleText("Apple");
		Thread.sleep(1000);
		
		WebElement inputPrice = driver.findElement(By.xpath("//*[@id=\"addModal\"]/div/div/div[2]/form/div[2]/div[4]/div/input"));
		inputPrice.sendKeys("890");
		Thread.sleep(1000);
		
		WebElement inputQuantity = driver.findElement(By.xpath("//*[@id=\"addModal\"]/div/div/div[2]/form/div[2]/div[5]/div/input"));
		inputQuantity.sendKeys("0");
		Thread.sleep(1000);
		
		WebElement btnCapNhat = driver.findElement(By.xpath("//*[@id=\"addModal\"]/div/div/div[2]/form/div[3]/button"));
		btnCapNhat.click();
		Thread.sleep(2000);
		
		driver.quit();
		System.out.println("Update sản phẩm thành công!");
	}
}
