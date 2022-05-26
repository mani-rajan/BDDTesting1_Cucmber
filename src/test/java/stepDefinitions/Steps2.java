package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;
import junit.framework.Assert;
import pageObjects.ProductCartPage;
import pageObjects.WishListPage;

public class Steps2 {
	
	public WebDriver driver;
	public ProductCartPage productCartPage=new ProductCartPage(driver) ;
	public WishListPage wishListPage=new WishListPage(driver) ;

	
	
	
	@Given("User lanches chrome browser")
	public void user_lanches_chrome_browser() {
	 System.setProperty("webDriver.chrome.drive)",System.getProperty("user")+"//Drivers/chromedriver.exe");
	 this.driver= new ChromeDriver();
	  driver.get("https://testscriptdemo.com/");
	}

@Given("I add four different products to my wish list")
public void i_add_four_different_products_to_my_wish_list() {
	productCartPage.addProductsToWishList();
	
}
@When("I view my wishlist table")
public void i_view_my_wishlist_table() {
	productCartPage.clickBrowseWishList();
	
}
@Then("I find total four selected items in my Wishlist")
public void i_find_total_four_selected_items_in_my_wishlist() {
	wishListPage.validateProductCount();
    
}
@When("I search for lowest price product")
public void i_search_for_lowest_price_product() {
	wishListPage.getLowestProductPrice();

}
@When("I am able to add the lowest price item to my cart")
public void i_am_able_to_add_the_lowest_price_item_to_my_cart() {
	wishListPage.addToCart();
	wishListPage.clickCartLink();
   
}
@Then("I am able o verify the item in my cart")
public void i_am_able_o_verify_the_item_in_my_cart() {

    
}
}


