package Automation;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Add_Product {
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
	public void addProduct() throws InterruptedException {
		WebElement buttonProductManager = driver.findElement(By.xpath("//*[@id=\"sidenavAccordion\"]/div[1]/div/a[2]"));
		buttonProductManager.click();
		Thread.sleep(1000);
		
		WebElement listProduct = driver.findElement(By.xpath("//*[@id=\"collapseLayouts\"]/nav/a[3]"));
		listProduct.click();
		Thread.sleep(1000);
		
		WebElement btnProduct = driver.findElement(By.xpath("//*[@id=\"layoutSidenav_content\"]/app-list-products/div[2]/button"));
		btnProduct.click();
		Thread.sleep(1000);
		
		WebElement uploadInput = driver.findElement(By.xpath("//*[@id=\"image\"]"));
		String filePath = "C:\\Users\\Dell\\Pictures\\Saved Pictures\\download.jpg";
		uploadInput.sendKeys(filePath);
		Thread.sleep(2000);
		
		WebElement productName = driver.findElement(By.xpath("//*[@id=\"product_name\"]"));
		productName.sendKeys("Iphone 18");
		Thread.sleep(1000);
		
		WebElement productBrands = driver.findElement(By.xpath("//*[@id=\"layoutSidenav_content\"]/app-create-product/div/form/select[1]"));
		productBrands.sendKeys("Apple");
		Thread.sleep(1000);
		
		WebElement productCategory = driver.findElement(By.xpath("//*[@id=\"layoutSidenav_content\"]/app-create-product/div/form/select[2]"));
		Select dropdown = new Select(productCategory);
		dropdown.selectByVisibleText("Smartphones");
		Thread.sleep(1000);
		
		WebElement productPrice = driver.findElement(By.xpath("//*[@id=\"price\"]"));
		productPrice.sendKeys("2900000");
		Thread.sleep(1000);
		
		WebElement productQuantity = driver.findElement(By.xpath("//*[@id=\"quantity\"]"));
		productQuantity.sendKeys("10");
		Thread.sleep(1000);
		
		WebElement btnCreateProduct = driver.findElement(By.xpath("//*[@id=\"layoutSidenav_content\"]/app-create-product/div/form/button"));
		btnCreateProduct.click();
		Thread.sleep(2000);
		
		driver.quit();
		System.out.println("Thêm sản phẩm thành công!");
	}
	
//	@Test(priority = 4)
//	public void addProductFail() throws InterruptedException {
//		WebElement buttonProductManager = driver.findElement(By.xpath("//*[@id=\"sidenavAccordion\"]/div[1]/div/a[2]"));
//		buttonProductManager.click();
//		Thread.sleep(1000);
//		
//		WebElement listProduct = driver.findElement(By.xpath("//*[@id=\"collapseLayouts\"]/nav/a[3]"));
//		listProduct.click();
//		Thread.sleep(1000);
//		
//		WebElement btnProduct = driver.findElement(By.xpath("//*[@id=\"layoutSidenav_content\"]/app-list-products/div[2]/button"));
//		btnProduct.click();
//		Thread.sleep(1000);
//		
//		WebElement uploadInput = driver.findElement(By.xpath("//*[@id=\"image\"]"));
//		String filePath = "C:\\Users\\Dell\\Pictures\\Saved Pictures\\dienthoai.jfif";
//		uploadInput.sendKeys(filePath);
//		Thread.sleep(2000);
//		
//		WebElement productName = driver.findElement(By.xpath("//*[@id=\"product_name\"]"));
//		productName.sendKeys("Iphone 18");
//		Thread.sleep(1000);
//		
//		WebElement productBrands = driver.findElement(By.xpath("//*[@id=\"layoutSidenav_content\"]/app-create-product/div/form/select[1]"));
//		productBrands.sendKeys("Apple");
//		Thread.sleep(1000);
//		
//		WebElement productCategory = driver.findElement(By.xpath("//*[@id=\"layoutSidenav_content\"]/app-create-product/div/form/select[2]"));
//		Select dropdown = new Select(productCategory);
//		dropdown.selectByVisibleText("Smartphones");
//		Thread.sleep(1000);
//		
//		WebElement productPrice = driver.findElement(By.xpath("//*[@id=\"price\"]"));
//		productPrice.sendKeys("2900000");
//		Thread.sleep(1000);
//		
//		WebElement productQuantity = driver.findElement(By.xpath("//*[@id=\"quantity\"]"));
//		productQuantity.sendKeys("10");
//		Thread.sleep(1000);
//		
//		WebElement btnCreateProduct = driver.findElement(By.xpath("//*[@id=\"layoutSidenav_content\"]/app-create-product/div/form/button"));
//		btnCreateProduct.click();
//		Thread.sleep(2000);
//		
//		driver.quit();
//		System.out.println("Thêm sản phẩm thất bại");
//	}
}
