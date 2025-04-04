package Automation;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Update_Save {
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
	
//	@Test(priority = 2)
//	public void updateDonhang() throws InterruptedException {
//		WebElement buttonProduct = driver.findElement(By.xpath("//*[@id=\"sidenavAccordion\"]/div[1]/div/a[2]"));
//		buttonProduct.click();
//		Thread.sleep(2000);
//		
//		WebElement listOrder = driver.findElement(By.xpath("//*[@id=\"collapseLayouts\"]/nav/a[4]"));
//		listOrder.click();
//		Thread.sleep(1000);
//		
//		WebElement btnDetails = driver.findElement(By.xpath("//*[@id=\"layoutSidenav_content\"]/app-list-donhang/div[4]/table/tbody/tr[2]/td[6]/button[1]"));
//		btnDetails.click();
//		Thread.sleep(1000);
//		
//		WebElement inputDay = driver.findElement(By.xpath("//*[@id=\"create_at\"]"));
//		inputDay.click();
//		//Nhập ngày tháng năm mong muốn
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("arguments[0].value='2024-12-12';", inputDay);
//		Thread.sleep(1000);
//		
//		WebElement inputPrice = driver.findElement(By.xpath("//*[@id=\"total_amount\"]"));
//		inputPrice.clear();
//		inputPrice.sendKeys("28000000");
//		Thread.sleep(1000);
//		
//		WebElement btnUpdate = driver.findElement(By.xpath("//*[@id=\"addModal\"]/div/div/div[2]/form/button"));
//		btnUpdate.click();
//		Thread.sleep(1000);
//		
//		driver.quit();
//		System.out.println("Update đơn hàng thành công!");
//	}
	
	@Test(priority = 2)
	public void saveDonhang() throws InterruptedException {
		WebElement buttonProduct = driver.findElement(By.xpath("//*[@id=\"sidenavAccordion\"]/div[1]/div/a[2]"));
		buttonProduct.click();
		Thread.sleep(2000);
		
		WebElement listOrder = driver.findElement(By.xpath("//*[@id=\"collapseLayouts\"]/nav/a[4]"));
		listOrder.click();
		Thread.sleep(1000);
		
		//Nhấn thay đổi trạng thái đơn hàng
		WebElement btnState = driver.findElement(By.xpath("//*[@id=\"layoutSidenav_content\"]/app-list-donhang/div[4]/table/tbody/tr[2]/td[3]/select"));
		//Xổ xuống chọn sản phẩm
		Select dropdown = new Select(btnState);
		dropdown.selectByVisibleText("Đã xác nhận");
		Thread.sleep(1000);
		
		WebElement btnSave = driver.findElement(By.xpath("//*[@id=\"layoutSidenav_content\"]/app-list-donhang/div[4]/table/tbody/tr[2]/td[6]/button[3]"));
		btnSave.click();
		Thread.sleep(1000);
		
		driver.quit();
		System.out.println("Lưu thành công!");
	}
}
