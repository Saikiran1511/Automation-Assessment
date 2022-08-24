package stepdefinitions;

import base.TestBase;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.ProductPage;
import pages.SearchPage;

public class SearchProduct extends TestBase {

    SearchPage searchPage;
    ProductPage productPage;
    String price = "";
    String description = "";

    @Given("user lands on application")
    public void user_lands_on_application() {
        searchPage = new SearchPage(driver);
        productPage = new ProductPage(driver);
    }

    @And("user searches for product \"([^\"]*)\"$")
    public void user_searches_for_product(String product) {
        searchPage.inputSearchText(product);

    }

    @When("user clicks on the product \"([^\"]*)\"$")
    public void user_clicks_on_the_product(String product) {
        searchPage.clickOnProduct(product);
    }

    @Then("user verifies price and description are present")
    public void user_verifies_price_and_description_are_present() {
        price = productPage.getProductPrice();
        description = productPage.getProductDescription();
        System.out.println("Product Price : " +price);
        System.out.println("Product Description : " +description);
    }

    @And("product information is displayed")
    public void product_information_is_displayed() {
        Assert.assertEquals(productPage.isProductInformationPresent(), true, "Verifying Whether the product information is present");
    }

}
