package com.selenium.loginSearchAutoCompletion;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Hello world!
 *
 */

/*
 * 
 * 
 * create an account - insert an email address and click create
 * navigate to the reigster page and fill in all the details and submit.
 */
public class App 
{
    public static void main( String[] args )
    {
       //System.out.println( "Hello World!" );
    	
    	System.setProperty("webdriver.chrome.driver",
    			"C:\\Users\\anirudhmaanvi\\Desktop\\Java\\Selenium\\chromedriver.exe");
    	
    	WebDriver dr = new ChromeDriver();
    	
    	WebDriverWait wait = new WebDriverWait(dr,10);
    	
    	String url = "http://automationpractice.com/index.php";
    	
    	dr.get(url);
    	
    	
    	// found class of div which has sign in to be : header_user_info
    	
    	WebElement divThatHasSignIn = dr.findElement(By.className("header_user_info"));
    	
    	WebElement signInToClick = divThatHasSignIn.findElement(By.className("login"));
    	
    	//System.out.println(signInToClick.getText());
    	
    	signInToClick.click();
    	
    	String login_url = "http://automationpractice.com/index.php?controller=authentication&back=my-account";
    	
    	dr.navigate().to(login_url);
    	
    //System.out.println(dr.getCurrentUrl());
    	try{
    		//WebElement login_form_acc= dr.findElement(By.xpath("//*[@id="login_form"]"));
    		WebElement form_hasLogin = dr.findElement(By.cssSelector("#login_form"));
    		WebElement div_login_form=form_hasLogin.findElement(By.cssSelector("#login_form > div")); 
    		
    		WebElement div_Login=div_login_form.findElement(By.cssSelector("#login_form > div > div:nth-child(1)"));
    		WebElement txt_login=div_Login.findElement(By.cssSelector("#email"));
    		txt_login.sendKeys("anriudhdams@gmail.com");
    		
    		WebElement div_Password=div_login_form.findElement(By.cssSelector("#login_form > div > div:nth-child(2)"));
    		WebElement txt_password=div_Password.findElement(By.cssSelector("#passwd"));
    		txt_password.sendKeys("qwer1234");
    		
    		//#login_form > div > p.submit
    		WebElement p_Login_Submit=div_login_form.findElement(By.cssSelector("#login_form > div > p.submit"));
    		WebElement submit_Button=p_Login_Submit.findElement(By.cssSelector("#SubmitLogin"));
    		submit_Button.click();
    				
    		
    		
    	}
    	
    	catch (Exception ee){
    	WebElement form_create_acc = dr.findElement(By.xpath("//*[@id='create-account_form']"));
    	WebElement formContent = form_create_acc.findElement(By.cssSelector("#create-account_form > div"));
    	WebElement textBox = formContent.findElement(By.tagName("input"));
    	textBox.sendKeys("anirudhdams@gmail.com");
    	WebElement submitButton = formContent.findElement(By.cssSelector("#SubmitCreate"));
    	submitButton.click();
    	String url2 = "http://automationpractice.com/index.php?controller=authentication&back=my-account#account-creation";
    	dr.navigate().to(url2);
    	
    	
    	// Inside the registration page
    	try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	RegisterNewUser(dr,wait);
    	}
    	
    	LoginExistingUser(dr,wait);
    	
    		
    }
    //Account Creation Functionality
	private static void RegisterNewUser(WebDriver dr,WebDriverWait wait) {
		
		
		
		
		WebElement mrRadio = dr.findElement(By.cssSelector("#id_gender1"));
		
		mrRadio.click();
		
		
		WebElement firstname = dr.findElement(By.cssSelector("#customer_firstname"));
		
		
		firstname.sendKeys("anirudh");
		
		WebElement lastname = dr.findElement(By.cssSelector("#customer_lastname"));
		
		lastname.sendKeys("Maanvi");
		
		
		WebElement password = dr.findElement(By.cssSelector("#passwd"));
		
		password.sendKeys("qwer1234");
		
		WebElement dayOfMonth = dr.findElement(By.cssSelector("#days"));
		
		
		Select dropdown = new Select(dayOfMonth);
		
		dropdown.selectByValue("28");
		
		WebElement month = dr.findElement(By.cssSelector("#months"));
		
		
		dropdown = new Select(month);
		
		dropdown.selectByValue("5");
		
		WebElement year = dr.findElement(By.cssSelector("#years"));
		
		
		dropdown = new Select(year);
		
		dropdown.selectByValue("1993");
		
		
		/// Address section
		
		
		WebElement addr1 = dr.findElement(By.cssSelector("#address1"));
		
		
		addr1.sendKeys("the dudes");
		
		dr.findElement(By.cssSelector("#city")).sendKeys("rock");
		
		
		dropdown = new Select(dr.findElement(By.cssSelector("#id_state")));
		
		dropdown.selectByValue("30");
		
		
		dr.findElement(By.cssSelector("#postcode")).sendKeys("08854");
		
		
		dr.findElement(By.cssSelector("#phone_mobile")).sendKeys("9168059152");
		
		dr.findElement(By.cssSelector("#alias")).sendKeys("anirudhdams@gmail.com");
		
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		dr.findElement(By.cssSelector("#submitAccount")).click();
		
		
		
		
		
	}
	//Login Functionality
	private static void LoginExistingUser(WebDriver dr, WebDriverWait wait){
		WebElement userName=dr.findElement(By.cssSelector("#email"));
		userName.sendKeys("anirudhdams@gmail.com");
		
		WebElement password=dr.findElement(By.cssSelector("#passwd"));
		password.sendKeys("qwer1234");
		
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		WebElement submit=dr.findElement(By.cssSelector("#SubmitLogin"));
		submit.click();
	
	}
	
}
