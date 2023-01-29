import com.kms.katalon.core.testobject.ConditionType

import org.apache.poi.ss.usermodel.ConditionType

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import javax.xml.xpath.XPath

import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.testobject.ConditionType


WebUI.callTestCase(findTestCase('Test Cases/FE/Search/Verification/Arabic/Verify elemnts for the search'), [:], FailureHandling.STOP_ON_FAILURE)


/*
 * WebUI.delay(10)
 * 
 * WebUI.scrollToPosition(9999999, 9999999)
 */



//WebUI.scrollToElement(findTestObject('Object Repository/Subscribe/Subscribe block'), 10)
//def elementProduct = WebUI.verifyElementPresent(findTestObject('Object Repository/Products/List of products'),0,FailureHandling.CONTINUE_ON_FAILURE)
//KeywordUtil.logInfo(elementProduct.toString())

while(!WebUI.verifyElementPresent(findTestObject('Object Repository/Products/List of products'),0,FailureHandling.CONTINUE_ON_FAILURE)) {
	//WebUI.scrollToElement(findTestObject('Headers and Footers/Footer contents/Web footer'), 0,FailureHandling.CONTINUE_ON_FAILURE)
	WebUI.scrollToPosition(9999999, 9999999)
	//elementProduct = WebUI.verifyElementPresent(findTestObject('Object Repository/Products/List of products'),0,FailureHandling.CONTINUE_ON_FAILURE)
	//KeywordUtil.logInfo(elementProduct.toString())

}
/*
 * WebUI.waitForElementPresent(findTestObject('Object Repository/Products/List
 * of products'), 10) WebUI.delay(10)
 * WebUI.scrollToPosition(9999999, 9999999)
 */


//WebUI.scrollToElement(findTestObject('Object Repository/Products/Products action block'), 10)
//WebUI.waitForElementPresent(findTestObject('Object Repository/Products/Products action block'), 0)

WebUI.waitForElementClickable(findTestObject('Object Repository/Products/Products action block'), 0)


List products = WebUI.findWebElements(findTestObject('Object Repository/Products/List of products'),30)


//for (int i = 0; i < products.size(); i++) {
//if (products.size() > 0) {
//WebUI.click((products[0]))
//}
//}


//sleep(1000)

//WebUI.waitForElementClickable(findTestObject('Object Repository/Products/List of products'), 10)

TestObject product = new TestObject()
product.addProperty('xpath', ConditionType.EQUALS, '(//*[@class="styles_productItem__YY5Bs"])[10]/div[@class="styles_mainContainer__UqqCY"]')
WebUI.scrollToElement(product, 0,FailureHandling.CONTINUE_ON_FAILURE)
WebUI.waitForElementVisible(product, 0)
int size = products.size()
WebUI.click(product)
products.get(3)
products.get(3).sendKeys(Keys.ENTER);
/*
 * if (size > 0) { for (int i = 0; i < size; i++) {
 * products.get(i).sendKeys(Keys.ENTER); } }
 */