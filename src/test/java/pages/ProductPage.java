package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.UIUtils;

import java.util.List;

public class ProductPage extends UIUtils {

    WebDriver driver;

    @FindBy(className = "special-price__price")
    WebElement priceLabel;

    @FindBy(className = "pdp__description")
    WebElement productDescription;

    @FindBy(xpath = "//a[text()='Product Information']")
    WebElement productInformationTab;

    @FindBy(className = "pdp__product-information")
    WebElement productInformationTable;




    public ProductPage(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

   public String getProductPrice(){
        String productPrice = "";
        try{
            productPrice = getElementText(priceLabel);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return productPrice;
    }

    public String getProductDescription(){
        String productDescriptionTxt = "";
        try{
            productDescriptionTxt = getElementText(productDescription);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return productDescriptionTxt;
    }

    public boolean isProductInformationPresent(){
        boolean flag = true;
        try{
            waitAndClickElement(productInformationTab);
            List<WebElement> rows = productInformationTable.findElements(By.tagName("tr"));
            for(WebElement row : rows){
                List<WebElement> cols = row.findElements(By.tagName("td"));
                for(WebElement col : cols) {
                   if (getElementText(col).equals("")) {
                        flag = false;
                        break;
                    }
                }
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }

}
