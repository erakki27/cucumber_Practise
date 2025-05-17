package stepDefinations;


import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import pages.MyntraOrder;



@RunWith(Cucumber.class)
public class SearchstepDefination {
	private static final String MyntraUrl = "https://www.myntra.com/";
	private WebDriver driver;
	private MyntraOrder myntraOrder;
	  

	    @Before
	    public void setup(){
	    	driver = new ChromeDriver();
	    	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
	    	  driver.manage().window().maximize();
	    }

	    @After
	    public void tearDown(){
	        if(driver!=null){
	            driver.quit();
	        }
	    }
	@Given("Launch Website")
	public void launch_website() {
	    // Write code here that turns the phrase above into concrete actions
	    driver.get(MyntraUrl);   
	    myntraOrder = new MyntraOrder(driver);
		
	}

	@Given("Select Women Section")
	public void select_women_section() {
	    // Write code here that turns the phrase above into concrete actions
		myntraOrder.HoverOnWomenSection();
	}

	@When("search with product dresses")
	public void search_with_product_dresses() {
	    // Write code here that turns the phrase above into concrete actions
		myntraOrder.selectDresses();
	}

	@Then("Select Color and Brand {string}")
	public void select_color_and_brand(String Brand) throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		myntraOrder.SelectColor();
		myntraOrder.searchBoxforBrand();
		myntraOrder.searchBrand(Brand);
		Thread.sleep(3000);;
		myntraOrder.selectBrand();
		Thread.sleep(3000);;
	}

	@Then("Select product and click on it for order")
	public void select_product_and_click_on_it_for_order() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		myntraOrder.SelectProduct();
		
      String currentwindow = driver.getWindowHandle();
		
		Set<String> s =driver.getWindowHandles();
		
		Iterator<String> li = s.iterator();
		
		while(li.hasNext()) {
			String childwindow = li.next();
			if(!currentwindow.equals(childwindow)) {
				driver.switchTo().window(childwindow);
				
			String childwindowtitle=	driver.switchTo().window(childwindow).getTitle();
			System.out.println(childwindowtitle);
			
			}
		}
		myntraOrder.SelectSize();
		myntraOrder.AddToBag();
	}

}