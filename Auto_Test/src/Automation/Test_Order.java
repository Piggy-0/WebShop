package Automation;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Test_Order {
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
	
//	@Test(priority =3)
//	public void addProductSuccess() throws InterruptedException {
//		WebElement buttonProduct = driver.findElement(By.xpath("//*[@id=\"sidenavAccordion\"]/div[1]/div/a[2]"));
//		buttonProduct.click();
//		Thread.sleep(2000);
//		
//		WebElement listOrder = driver.findElement(By.xpath("//*[@id=\"collapseLayouts\"]/nav/a[4]"));
//		listOrder.click();
//		Thread.sleep(1000);
//		
//		WebElement buttonAdd = driver.findElement(By.xpath("//*[@id=\"layoutSidenav_content\"]/app-list-donhang/div[2]/div/button"));
//		buttonAdd.click();
//		Thread.sleep(2000);
//		//Chọn tên khách hàng
//		WebElement addUser = driver.findElement(By.xpath("//*[@id=\"exampleModal\"]/div/div/div[2]/div[1]/select"));
//		Select dropdown = new Select(addUser);
//		dropdown.selectByVisibleText("Nguyen Van B");
//		Thread.sleep(1000);
//		
//		//Chọn sản phẩm
//		WebElement addSanpham = driver.findElement(By.xpath("//*[@id=\"exampleModal\"]/div/div/div[2]/div[2]/select"));
//		Select dropdown2 = new Select(addSanpham);
//		dropdown2.selectByVisibleText("iPhone 15 ProMax");
//		Thread.sleep(1000);
//		
//		//Chọn địa chỉ giao hàng
//		WebElement inputAddress = driver.findElement(By.xpath("//*[@id=\"address\"]"));
//		inputAddress.sendKeys("17 Nguyen Nhạc, Quy Nhơn");
//        Thread.sleep(1000);
//        
//        //Nhập số điện thoại
//      	WebElement inputPhone = driver.findElement(By.xpath("//*[@id=\"phone\"]"));
//      	inputPhone.sendKeys("0362547099");
//        Thread.sleep(1000);
//        
//        //Chọn phương thức giao hàng
//        WebElement DeliveryMethod = driver.findElement(By.xpath("//*[@id=\"payment\"]"));
//		Select dropdown3 = new Select(DeliveryMethod);
//		dropdown3.selectByVisibleText("Thanh toán khi nhận hàng");
//		Thread.sleep(1000);
//		
//		//Nhấn nút Thêm
//		WebElement buttonAddProduct = driver.findElement(By.xpath("//*[@id=\"exampleModal\"]/div/div/div[3]/button[2]"));
//		buttonAddProduct.click();
//		Thread.sleep(1000);
//		
//		driver.quit();
//		System.out.println("Thêm đơn hàng thành công!");
//	}
//}
	@Test(priority = 3)
	public void addProductFail() throws InterruptedException {
		WebElement buttonProduct = driver.findElement(By.xpath("//*[@id=\"sidenavAccordion\"]/div[1]/div/a[2]"));
		buttonProduct.click();
		Thread.sleep(2000);
		
		WebElement listOrder = driver.findElement(By.xpath("//*[@id=\"collapseLayouts\"]/nav/a[4]"));
		listOrder.click();
		Thread.sleep(1000);
		
		WebElement buttonAdd = driver.findElement(By.xpath("//*[@id=\"layoutSidenav_content\"]/app-list-donhang/div[2]/div/button"));
		buttonAdd.click();
		
		WebElement addSanpham = driver.findElement(By.xpath("//*[@id=\"exampleModal\"]/div/div/div[2]/div[2]/select"));
		//Xổ xuống chọn sản phẩm
		Select dropdown = new Select(addSanpham);
		dropdown.selectByVisibleText("iPhone 15 ProMax");
		Thread.sleep(1000);
		
		//Chọn địa chỉ giao hàng
		WebElement inputAddress = driver.findElement(By.xpath("//*[@id=\"address\"]"));
		inputAddress.sendKeys("17 Nguyen Nhạc, Quy Nhơn");
        Thread.sleep(1000);
        
        //Nhập số điện thoại
      	WebElement inputPhone = driver.findElement(By.xpath("//*[@id=\"phone\"]"));
      	inputPhone.sendKeys("0362547099");
        Thread.sleep(1000);
        
        //Chọn phương thức giao hàng
        WebElement DeliveryMethod = driver.findElement(By.xpath("//*[@id=\"payment\"]"));
		Select dropdownm = new Select(DeliveryMethod);
		dropdownm.selectByVisibleText("Thanh toán khi nhận hàng");
		Thread.sleep(1000);
		
		//Nhấn nút Thêm
		WebElement buttonAddProduct = driver.findElement(By.xpath("//*[@id=\"exampleModal\"]/div/div/div[3]/button[2]"));
		buttonAddProduct.click();
		Thread.sleep(1000);
		
		driver.quit();
		System.out.println("Thêm đơn hàng thất bại!");
	}
}

