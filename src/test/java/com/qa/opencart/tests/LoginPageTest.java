package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.errors.AppError;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Issue;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;


public class LoginPageTest extends BaseTest {

	@Description("checking login page title ----")
	@Severity(SeverityLevel.MINOR)
	@Owner("Naveen Automation Labs")
	@Issue("Login-123")
	@Feature("login page title features")
	@Test(priority = 1)
	public void loginPageTitleTest() {
	String actTitle=loginPage.getLoginPageTitle();
	Assert.assertEquals(actTitle,AppConstants.LOGIN_PAGE_TITLE,AppError.TITLE_NOT_FOUND);
	}
	
	@Description("checking login page url ----")
	@Severity(SeverityLevel.NORMAL)
	@Owner("Naveen Automation Labs")
	@Feature("login page URL features")
	@Test(priority = 2)
	public void loginPageURLTest() {
		String actURL=loginPage.getLoginPageUrl();
	    Assert.assertTrue(actURL.contains(AppConstants.LOGIN_PAGE_FRACTION_URL),AppError.URL_NOT_FOUND);
    }
	
	
	@Description("checking forgot pwd link exist on the login page ----")
	@Severity(SeverityLevel.CRITICAL)
	@Owner("Naveen Automation Labs")
	@Feature("login page forgot pwd features")
	@Test(priority = 3)
	public void forgotPwdLinkExistTest() {
		Assert.assertTrue(loginPage.checkForgotPwdLinkExist(),AppError.ELEMENT_NOT_FOUND);
	}
	
	
	@Description("checking user is able to login successfully ----")
	@Severity(SeverityLevel.BLOCKER)
	@Owner("Naveen Automation Labs")
	@Feature("login page features")
	@Test(priority = 4)
	public void loginTest(){
	 accPage= loginPage.doLogin(prop.getProperty("username"),(prop.getProperty("password")));
	Assert.assertEquals(accPage.getAccPageTitle(), AppConstants.ACCOUNTS_PAGE_TITLE, AppError.TITLE_NOT_FOUND);
		
	
	}
}