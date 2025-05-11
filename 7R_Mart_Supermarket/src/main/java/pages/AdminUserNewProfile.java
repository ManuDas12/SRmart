package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.Page_Utilities;

public class AdminUserNewProfile {
	WebDriver driver;
	
public AdminUserNewProfile(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub		
	}
@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin'][@class='small-box-footer']") WebElement adminUserClick;
@FindBy(xpath="//a[@onclick='click_button(1)']") WebElement clickNewButton;
@FindBy(xpath="//input[@name='username']") WebElement userNameField;
@FindBy(xpath="//input[@name='password']") WebElement passwordField;
@FindBy(xpath="//select[@id='user_type']") WebElement userTypeDropDown;
@FindBy(xpath="//button[@name='Create']") WebElement submitButton;
@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']") WebElement alertMsg;

public AdminUserNewProfile adminUserClickButton() {
	adminUserClick.click();
	return this;
}

public AdminUserNewProfile newButtonClick() {
	clickNewButton.click();
	return this;
}

public AdminUserNewProfile userNamevalue(String username) {
	userNameField.sendKeys(username);
	return this;
}

public AdminUserNewProfile passwordValue(String password) {
	passwordField.sendKeys(password);
	return this;
}

public AdminUserNewProfile userTypeDropDownField(String usertype) {
	//Select selectuser=new Select(userTypeDropDown);
	//selectuser.selectByVisibleText(usertype);
	Page_Utilities page=new Page_Utilities();
	page.selectionMethods(userTypeDropDown, usertype);
	return this;
}
public AdminUserNewProfile clickSubmitButton() {
	submitButton.click();
	return new AdminUserNewProfile(driver);
}

public boolean isNewUserCreated() {
	return alertMsg.isDisplayed();
}

}

