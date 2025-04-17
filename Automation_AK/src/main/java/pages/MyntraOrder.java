package pages;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class MyntraOrder {
	
	
	 private WebDriver driver;
	
	public MyntraOrder(WebDriver driver) {
		this.driver = driver;
	}
	
	//locator
	
	private By WomenCataloguelocator = By.xpath("//a[contains(text(),'Women')]");
    private By Dresseslocator = By.xpath("//a[contains(text(),'Jumpsuits')]");
    private By ColorSelectlocator = By.cssSelector("span[data-colorhex='black']");
    private By searchBrandlocator = By.xpath("//div[@class='vertical-filters-filters brand-container']//span[@class='myntraweb-sprite filter-search-iconSearch sprites-search']");
    private By enterBrandlocator = By.xpath("//input[@placeholder='Search for Brand']");
    private By brandlocator = By.xpath("//div[@class='vertical-filters-filters brand-container']/ul/li/label[contains(text(),'KASSUALLY')]");
    private By productlocator = By.xpath("(//div[@class='product-productMetaInfo'])[3]");
    private By selectsizeloactor = By.xpath("//p[@class='size-buttons-unified-size' and contains(text(),'M')]");
    private By addtoBaglocator = By.cssSelector(".pdp-add-to-bag.pdp-button.pdp-flex.pdp-center");
    //Methods
    
    public void HoverOnWomenSection() {
    	WebElement WomenCatalogue = driver.findElement(WomenCataloguelocator);
    	 Actions action = new Actions(driver);
		 action.moveToElement(WomenCatalogue).build().perform();
    }
    
    public void selectDresses() {
    	WebElement Dresses = driver.findElement(Dresseslocator);
    	Dresses.click();
    }
    
    public void SelectColor() {
    	WebElement ColorSelect = driver.findElement(ColorSelectlocator);
    	ColorSelect.click();
    }
    
    public void SelectBrand() {
    	WebElement searchBrand = driver.findElement(searchBrandlocator);
    	searchBrand.click();
    	WebElement enterBrand = driver.findElement(enterBrandlocator);
    	enterBrand.sendKeys("KASSUALLY");
    	WebElement brand = driver.findElement(brandlocator);
    	brand.click();
    }
    
    public void SelectProduct() {
    	WebElement product = driver.findElement(productlocator);
    	product.click();
    }
    
    public void SelectSize() {
    	WebElement size = driver.findElement(selectsizeloactor);
    	size.click();
    }
    public void AddToBag() {
    	WebElement bag = driver.findElement(addtoBaglocator);
    	bag.click();
    }
    
}
