package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WishListPage {

	public WebDriver ldriver;

	By WishListProductCount = By.xpath("//tbody[@class='wishlist-items-wrapper']");
	By WishListProducts = By.xpath("//td[@class='product-price']");
	@FindBy(xpath = "(//a[text()='Add to cart'])[2]")
	WebElement AddToCart;
	@FindBy(xpath = "(//a[@class='cart-contents'])[1]")
	WebElement CartLink;

	public WishListPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	public void validateProductCount() {

		if (ldriver.findElements(WishListProductCount).size() != 4) {
			System.out.println("Product count is not displayed as 4 in wish list page");
		} else {
			System.out.println("Product count is  displayed as 4 in wish list page");
		}
	}

	public void getLowestProductPrice() {
		float minPrice = 0;
		for (int i = 0; i < ldriver.findElements(WishListProducts).size(); i++) {
			if (ldriver.findElement(By.xpath("(//td[@class='product-price'])[" + i + "]")).isDisplayed()) {

				System.out
						.println(ldriver.findElement(By.xpath("(//td[@class='product-price'])[" + i + "]")).getText());
			} else {
				System.out.println(
						ldriver.findElement(By.xpath("(//td[@class='product-price'])[" + i + "]/ins/span")).getText());
			}
		}
	}

	public void addToCart() {
		AddToCart.click();
		waitForPageLoad();
	}

	public void clickCartLink() {
		CartLink.click();
		waitForPageLoad();
	}

	public void waitForPageLoad() {

		WebDriverWait wait = new WebDriverWait(ldriver, 120);
		wait.until(ldriver -> "complete"
				.equals(((JavascriptExecutor) ldriver).executeScript("return document.readyState")));

	}

}
