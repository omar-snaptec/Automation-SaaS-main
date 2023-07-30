import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable

import org.openqa.selenium.By
import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement


WebUI.callTestCase(findTestCase('Test Cases/Helpdesk/AjStore/SharedScripts/LaunchFE'), [:],	FailureHandling.STOP_ON_FAILURE)

int currentTab = WebUI.getWindowIndex()
WebDriver driver = DriverFactory.getWebDriver()
JavascriptExecutor js = ((driver) as JavascriptExecutor)
js.executeScript('window.open();')
WebUI.switchToWindowIndex(currentTab + 1)
WebUI.navigateToUrl(GlobalVariable.BE_URL)
WebUI.setText(findTestObject('Object Repository/Helpdesk/AjStore/BE/Login/UserName'), GlobalVariable.BE_UserName)
WebUI.setText(findTestObject('Object Repository/Helpdesk/AjStore/BE/Login/Password'), GlobalVariable.BE_Password)
WebUI.click(findTestObject('Object Repository/Helpdesk/AjStore/BE/Login/LoginButton'))
if(WebUI.waitForElementPresent(findTestObject('Object Repository/Helpdesk/AjStore/BE/Shared/SomethingWentWrong'), 5)
	& WebUI.waitForElementPresent(findTestObject('Object Repository/Helpdesk/AjStore/BE/Shared/SomethingWentWrongOK'), 5) ) {
	WebUI.click(findTestObject('Object Repository/Helpdesk/AjStore/BE/Shared/SomethingWentWrongOK'))
}
if(WebUI.waitForElementPresent(findTestObject('Object Repository/Helpdesk/AjStore/BE/Shared/SurveyDivClose'), 5)
	& WebUI.waitForElementPresent(findTestObject('Object Repository/Helpdesk/karazlinen/karazlinen-KSA/BE/Shared/SurveyDivClose'), 5) ) {
	WebUI.click(findTestObject('Object Repository/Helpdesk/AjStore/BE/Shared/SurveyDivClose'))
}
WebUI.switchToWindowIndex(currentTab)

WebUI.waitForElementClickable(findTestObject('Object Repository/Helpdesk/AjStore/FE/Shared/Login'), 20)
WebUI.click(findTestObject('Object Repository/Helpdesk/AjStore/FE/Shared/Login'))

WebUI.waitForElementClickable(findTestObject('Object Repository/Helpdesk/AjStore/FE/SignUp/SignNewAccountUp'), 5)
CustomKeywords.'helpdesk.HelpdeskUtil.ScrollToElement'(findTestObject('Object Repository/Helpdesk/AjStore/FE/SignUp/SignNewAccountUp'))
WebUI.click(findTestObject('Object Repository/Helpdesk/AjStore/FE/SignUp/SignNewAccountUp'))

WebUI.waitForElementVisible(findTestObject('Object Repository/Helpdesk/AjStore/FE/SignUp/FirstName'), 5)

WebUI.delay(1)
CustomKeywords.'helpdesk.HelpdeskUtil.ScrollToElement'(findTestObject('Object Repository/Helpdesk/AjStore/FE/SignUp/FirstName'))
WebUI.sendKeys(findTestObject('Object Repository/Helpdesk/AjStore/FE/SignUp/FirstName'), 'Snaptec')
WebUI.sendKeys(findTestObject('Object Repository/Helpdesk/AjStore/FE/SignUp/FamilyName'), 'testing')
WebUI.sendKeys(findTestObject('Object Repository/Helpdesk/AjStore/FE/SignUp/Email'), 'mahmoud@snaptec.co')
WebUI.sendKeys(findTestObject('Object Repository/Helpdesk/AjStore/FE/SignUp/CustomerPhone'), GlobalVariable.SignUp_Phone)
CustomKeywords.'helpdesk.HelpdeskUtil.ScrollToElement'(findTestObject('Object Repository/Helpdesk/AjStore/FE/SignUp/Acknowledgement'))
WebUI.click(findTestObject('Object Repository/Helpdesk/AjStore/FE/SignUp/Acknowledgement'))
CustomKeywords.'helpdesk.HelpdeskUtil.ScrollToElement'(findTestObject('Object Repository/Helpdesk/AjStore/FE/SignUp/SignNewAccountUp'))
WebUI.click(findTestObject('Object Repository/Helpdesk/AjStore/FE/SignUp/SignNewAccountUp'))
WebUI.delay(2)
String xPath = "//input[@type='tel' and contains( @aria-label,'Digit 1')]"
TestObject firstOTPDigit = new TestObject('objectName')
firstOTPDigit.addProperty('xpath', ConditionType.EQUALS, xPath)

if(WebUI.waitForElementVisible(firstOTPDigit, 20)) {
	String OTP = getSignUpOTP()
	WebUI.switchToWindowIndex(currentTab)
	WebUI.sendKeys(firstOTPDigit, OTP)
}else if(WebUI.waitForElementVisible(findTestObject('Object Repository/Helpdesk/AjStore/FE/SignUp/ErrAccountAlreadyExists'), 20)){
	deleteCustomerProfile()
	WebUI.switchToWindowIndex(currentTab)
	WebUI.click(findTestObject('Object Repository/Helpdesk/AjStore/FE/SignUp/SignNewAccountUp'))
	if(WebUI.waitForElementVisible(firstOTPDigit, 20)) {
		String OTP = getSignUpOTP()
		WebUI.switchToWindowIndex(currentTab)
		WebUI.sendKeys(firstOTPDigit, OTP)
	}else {
		KeywordUtil.markFailedAndStop('Something went wrong')
	}
}else {
	KeywordUtil.markFailedAndStop('Something went wrong')
}


WebUI.waitForElementVisible(findTestObject('Object Repository/Helpdesk/AjStore/FE/AccountPage/AccountPageTitle'), 20)
WebUI.verifyElementVisible(findTestObject('Object Repository/Helpdesk/AjStore/FE/AccountPage/AccountPageTitle')
, FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementNotPresent(findTestObject('Object Repository/Helpdesk/AjStore/FE/Login/EnterOTP'), 2)
WebUI.verifyElementClickable(findTestObject('Object Repository/Helpdesk/AjStore/FE/AccountPage/SignOut'))

WebUI.delay(5)
WebUI.closeBrowser()



String getSignUpOTP() {
	int currentTab = WebUI.getWindowIndex()
	WebUI.switchToWindowIndex(currentTab + 1)
	WebUI.click(findTestObject('Object Repository/Helpdesk/AjStore/BE/Menu/Menu_MageDelight'))
	WebUI.click(findTestObject('Object Repository/Helpdesk/AjStore/BE/Menu/Menu_MageDelight_MobileOTPLogin'))
	WebUI.click(findTestObject('Object Repository/Helpdesk/AjStore/BE/Menu/Menu_MageDelight_MobileOTPLogin_SMSLog'))
	if(WebUI.waitForElementVisible(findTestObject('Object Repository/Helpdesk/AjStore/BE/SmsLogPage/ClearFilter'), 10)) {
		WebUI.click(findTestObject('Object Repository/Helpdesk/AjStore/BE/SmsLogPage/ClearFilter'))
	}
	WebUI.delay(2)
	WebUI.click(findTestObject('Object Repository/Helpdesk/AjStore/BE/SmsLogPage/button_Filters'))
	WebUI.waitForElementClickable(findTestObject('Object Repository/Helpdesk/AjStore/BE/SmsLogPage/recipient_phone'), 2)
	WebUI.setText(findTestObject('Object Repository/Helpdesk/AjStore/BE/SmsLogPage/recipient_phone'), GlobalVariable.SignUp_Phone)
	WebUI.click(findTestObject('Object Repository/Helpdesk/AjStore/BE/Sales_Order_page/Sales_orders_FilterButton'))
	WebUI.waitForElementVisible(findTestObject('Object Repository/Helpdesk/AjStore/BE/SmsLogPage/SmsContentFirstRow'), 20)
	String OTP = WebUI.getText(findTestObject('Object Repository/Helpdesk/AjStore/BE/SmsLogPage/SmsContentFirstRow'))
	println('>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>')
	println(OTP)
	OTP = OTP.replace('كلمة المرور لتسجيل الدخول رمز: ', '')
	println(OTP)
	WebUI.delay(2)
	return OTP
}





void deleteCustomerProfile() {
	int currentTab = WebUI.getWindowIndex()
	WebUI.switchToWindowIndex(currentTab + 1)
	WebUI.waitForElementClickable(findTestObject('Object Repository/Helpdesk/AjStore/BE/Menu/Menu_Customer'),5)
	WebUI.click(findTestObject('Object Repository/Helpdesk/AjStore/BE/Menu/Menu_Customer'))
	
	WebUI.waitForElementClickable(findTestObject('Object Repository/Helpdesk/AjStore/BE/Menu/Menu_Customer_AllCustomers'),5)
	WebUI.click(findTestObject('Object Repository/Helpdesk/AjStore/BE/Menu/Menu_Customer_AllCustomers'))
	
	if(WebUI.waitForElementVisible(findTestObject('Object Repository/Helpdesk/AjStore/BE/SmsLogPage/ClearFilter'), 5)) {
		WebUI.click(findTestObject('Object Repository/Helpdesk/AjStore/BE/SmsLogPage/ClearFilter'))
	}
	
	WebUI.delay(1)
	
	WebUI.click(findTestObject('Object Repository/Helpdesk/AjStore/BE/CustomerPage/button_Filters'))
	
	WebUI.waitForElementClickable(findTestObject('Object Repository/Helpdesk/AjStore/BE/CustomerPage/Filter_Phone'), 2)
	
	WebUI.setText(findTestObject('Object Repository/Helpdesk/AjStore/BE/CustomerPage/Filter_Phone'), "966" +  GlobalVariable.SignUp_Phone.toString())
	WebUI.click(findTestObject('Object Repository/Helpdesk/AjStore/BE/CustomerPage/Customers_FilterButton'))
	WebUI.delay(3)
	WebUI.waitForElementVisible(findTestObject('Object Repository/Helpdesk/AjStore/BE/CustomerPage/PhoneColumn'), 10)
	
	List<WebElement> SearchResultsPhone = WebUiCommonHelper.findWebElements(findTestObject('Object Repository/Helpdesk/AjStore/BE/CustomerPage/PhoneColumn'), 10)
	SearchResultsPhone.any {
		String Phone = it.getText()
		println Phone
		if(Phone.contains("966" + GlobalVariable.SignUp_Phone.toString())) {
			WebElement editCustomer = it.findElement(By.xpath('./ancestor::tr//a[text()="Edit"]'))
			CustomKeywords.'helpdesk.HelpdeskUtil.ScrollToElement'(editCustomer)
			editCustomer.click()
			return
		}
	}
	if (WebUI.waitForElementVisible(findTestObject('Object Repository/Helpdesk/AjStore/BE/CustomerPage/CustomerInformationTab'),
		10)) {
//		WebUI.click(findTestObject('Object Repository/Helpdesk/AjStore/BE/CustomerPage/CustomerInformationTab'))
		CustomKeywords.'helpdesk.HelpdeskUtil.clickJS'(findTestObject('Object Repository/Helpdesk/AjStore/BE/CustomerPage/CustomerInformationTab'),5)
		String PhoneOnCustomerProfile = WebUI.getAttribute(findTestObject('Object Repository/Helpdesk/AjStore/BE/CustomerPage/CustomerMobile'),
			'value')
	
		if (PhoneOnCustomerProfile.equalsIgnoreCase('966' + GlobalVariable.SignUp_Phone.toString())) {
			WebUI.click(findTestObject('Object Repository/Helpdesk/AjStore/BE/CustomerPage/CustomerProfileDelete'))
	
			TestObject DeleteButtonOKTO = new TestObject()
	
			DeleteButtonOKTO.addProperty('xpath', ConditionType.EQUALS, '//button[@class="action-primary action-accept"]')
	
			WebElement DeleteButtonOKElem = WebUiCommonHelper.findWebElement(DeleteButtonOKTO, 30)
			WebUI.waitForElementVisible(DeleteButtonOKTO, 10)
			DeleteButtonOKElem.click()
			WebUI.delay(2)
		} else {
			KeywordUtil.markFailedAndStop('Fail to find the customer profile with phone: ' + GlobalVariable.SignUp_Phone.toString())
		}
	} else {
		KeywordUtil.markFailedAndStop('Fail to find the customer profile with phone: ' + GlobalVariable.SignUp_Phone.toString())
	}
}
