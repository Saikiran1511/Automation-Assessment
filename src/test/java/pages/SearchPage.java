package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utils.UIUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SearchPage extends UIUtils {

    WebDriver driver;

    @FindBy(id = "js-site-search-input")
    WebElement searchField;

    @FindBy(xpath = "//div[contains(@class,'product-frame product-ga product')]")
    List<WebElement> searchGrid;



    public SearchPage(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

   public void inputSearchText(String searchText){
        try{
            waitAndSetText(searchField, searchText);
            searchField.sendKeys(Keys.ENTER);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public void clickOnProduct(String productName){
        String productText = "";
        try {
            for (WebElement element : searchGrid) {
                productText = getElementText(element);
                productText = productText.split("\\r?\\n")[1];
                if (productText.contains(productName)) {
                    WebElement product = driver.findElement(By.xpath("//a[contains(text(),'"+productText+"')]"));
                    waitAndClickElement(product);
                    break;
                }
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

}
