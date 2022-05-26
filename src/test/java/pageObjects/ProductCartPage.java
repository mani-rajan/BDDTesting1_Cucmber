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


public class ProductCartPage {

	public WebDriver ldriver;
	By AddWishListLoader = By.xpath("//div[@class='blockUI blockOverlay']");
	@FindBy(xpath = "(//a[@data-title='Add to wishlist'])[1]")
	WebElement Product1;
	@FindBy(xpath = "(//a[@data-title='Add to wishlist'])[2]")
	WebElement Product2;
	@FindBy(xpath = "(//a[@data-title='Add to wishlist'])[3]")
	WebElement Product3;
	@FindBy(xpath = "(//a[@data-title='Add to wishlist'])[4]")
	WebElement Product4;
	@FindBy(xpath = "(//a[@data-title='Browse wishlist'])[1]")
	WebElement BrowseWishList;
	@FindBy(xpath = "//tbody[@class='wishlist-items-wrapper']")
	WebElement WishListProductCount;

	public ProductCartPage(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	public void addProductsToWishList() {
		Product1.click();
		waitForLoadingIconToDisappear();
		Product2.click();
		waitForLoadingIconToDisappear();
		Product3.click();
		waitForLoadingIconToDisappear();
		Product4.click();
		waitForLoadingIconToDisappear();
	}
	public void clickBrowseWishList() {
		BrowseWishList.click();
		waitForPageLoad();
	}
	
	public void waitForLoadingIconToDisappear() {
		new WebDriverWait(ldriver, 120).until(ExpectedConditions.invisibilityOfElementLocated(AddWishListLoader));
	}
	public void waitForPageLoad() {

		WebDriverWait wait = new WebDriverWait(ldriver, 120);
		wait.until(ldriver -> "complete"
				.equals(((JavascriptExecutor) ldriver).executeScript("return document.readyState")));

	}

}
