import com.kms.katalon.core.model.FailureHandling

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.keyword.builtin.CallTestCaseKeyword
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.annotation.Keyword as Keyword
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUiCommonHelper
import com.kms.katalon.core.webui.keyword.internal.WebUIAbstractKeyword as WebUIAbstractKeyword
import catalog.catlogComponants as catlogComponants
import java.util.List as List
import org.openqa.selenium.By as By
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

boolean isMobile=false


WebUI.callTestCase(findTestCase('Test Cases/Helpdesk/karazlinen/karazlinen-KSA/SharedScripts/LaunchFE'), [:],	FailureHandling.STOP_ON_FAILURE)
isMobile=WebUI.callTestCase(findTestCase('Test Cases/Helpdesk/karazlinen/karazlinen-KSA/SharedScripts/isMobile'), [:],	FailureHandling.CONTINUE_ON_FAILURE)
//if(WebUI.waitForElementVisible(findTestObject('Object Repository/Helpdesk/karazlinen/karazlinen-KSA/FE/Shared/BottomMenu-Mobile'),3)) {
//	isMobile=true
//}

WebUI.callTestCase(findTestCase('Test Cases/Helpdesk/karazlinen/karazlinen-KSA/SharedScripts/Login'), [:],	FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Test Cases/Helpdesk/karazlinen/karazlinen-KSA/SharedScripts/ClearProductsFromCartPage'), [:],	FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('Test Cases/Helpdesk/karazlinen/karazlinen-KSA/SharedScripts/ClickLogo'), [:],	FailureHandling.STOP_ON_FAILURE)


WebUI.callTestCase(findTestCase('Test Cases/Helpdesk/karazlinen/karazlinen-KSA/SharedScripts/OpenAndAddProductToCart'), [:],	FailureHandling.STOP_ON_FAILURE)
/////////////////////////
CustomKeywords.'helpdesk.HelpdeskUtil.ScrollToElement'(findTestObject('Object Repository/Helpdesk/karazlinen/karazlinen-KSA/FE/Product/productFullDetail-Name'))
def ProductTitle = WebUI.getText(findTestObject('Object Repository/Helpdesk/karazlinen/karazlinen-KSA/FE/Product/productFullDetail-Name'))
CustomKeywords.'helpdesk.HelpdeskUtil.ScrollToElement'(findTestObject('Object Repository/Helpdesk/karazlinen/karazlinen-KSA/FE/Product/productFullDetail-sku'))
if(!WebUI.waitForElementVisible(findTestObject('Object Repository/Helpdesk/karazlinen/karazlinen-KSA/FE/Product/productFullDetail-sku'), 3)) {
	CustomKeywords.'helpdesk.HelpdeskUtil.ScrollToElement'(findTestObject('Object Repository/Helpdesk/karazlinen/karazlinen-KSA/FE/Product/DetailsSectionClosed'))
	WebUI.click(findTestObject('Object Repository/Helpdesk/karazlinen/karazlinen-KSA/FE/Product/DetailsSectionClosed'))
}
CustomKeywords.'helpdesk.HelpdeskUtil.ScrollToElement'(findTestObject('Object Repository/Helpdesk/karazlinen/karazlinen-KSA/FE/Product/productFullDetail-sku'))
def ProductSKU = WebUI.getText(findTestObject('Object Repository/Helpdesk/karazlinen/karazlinen-KSA/FE/Product/productFullDetail-sku'))
def ProductURL = WebUI.getUrl() //.replace(GlobalVariable.FE_URL, "")
String PriceElement = 'Object Repository/Helpdesk/karazlinen/karazlinen-KSA/FE/Product/Product_Price'
if(!WebUI.waitForElementVisible(findTestObject('Object Repository/Helpdesk/karazlinen/karazlinen-KSA/FE/Product/Product_Price'), 3)) {
	PriceElement = 'Object Repository/Helpdesk/karazlinen/karazlinen-KSA/FE/Product/Product_SpecialPrice'
}

def ProductPrice = WebUI.getText(findTestObject(PriceElement))
def ProductPriceOrg = ProductPrice
ProductPrice=ProductPrice.replace("ر.س", "").replace(" ", "")
println ProductTitle
println ProductSKU
println ProductURL
println ProductPrice

String CartIcon='Object Repository/Helpdesk/karazlinen/karazlinen-KSA/FE/Shared/Cart'
if(!WebUI.waitForElementClickable(findTestObject(CartIcon),5)) {
	CartIcon='Object Repository/Helpdesk/karazlinen/karazlinen-KSA/FE/Shared/Cart-Mobile'
}

WebUI.waitForElementClickable(findTestObject(CartIcon),10)
CustomKeywords.'helpdesk.HelpdeskUtil.clickJS'(findTestObject(CartIcon), 10)

//Check Total Paid for Tabby and Tamara
WebUI.waitForElementVisible(findTestObject('Object Repository/Helpdesk/karazlinen/karazlinen-KSA/FE/Cart/totalNeededPay'), 10)
String totalText=WebUI.getText(findTestObject('Object Repository/Helpdesk/karazlinen/karazlinen-KSA/FE/Cart/totalNeededPay'))
println(totalText)
totalText =totalText.replace(" ", "").replace("ر.س", "").replace(",", "")
Float totalValue = totalText.toFloat()
println(totalValue)

if (totalValue < 99) {
    //increase the products
    int neededQty = ((Math.ceil(99 / totalValue)) as int)
	for(int i=1;i<=neededQty;i++) {
		CustomKeywords.'helpdesk.HelpdeskUtil.clickJS'(findTestObject('Object Repository/Helpdesk/karazlinen/karazlinen-KSA/FE/Product/IncreaseQty'), 5)
//		if(WebUI.waitForElementVisible(findTestObject('Object Repository/Helpdesk/karazlinen/karazlinen-KSA/FE/Cart/ErrorWhenAdd'), 1)) {
//			Add another product
//		}
		WebUI.delay(1)
	}
 //remove and select another product (need to remove and seach again)
} else if (totalValue > 2500) {
	// To-Do Remove and add another product with less amount
}

WebUI.delay(3)





String SubPrice=WebUI.getText(findTestObject('Object Repository/Helpdesk/karazlinen/karazlinen-KSA/FE/Cart/SubPrice'))
String VAT_Amount=WebUI.getText(findTestObject('Object Repository/Helpdesk/karazlinen/karazlinen-KSA/FE/Cart/VAT_Amount'))
String TotalAmount=WebUI.getText(findTestObject('Object Repository/Helpdesk/karazlinen/karazlinen-KSA/FE/Cart/TotalAmount'))
String Discount_Amount="0.0"
if(WebUI.waitForElementVisible(findTestObject('Object Repository/Helpdesk/karazlinen/karazlinen-KSA/FE/Cart/DiscountBuyOneGetOne'), 5)) {
	Discount_Amount=WebUI.getText(findTestObject('Object Repository/Helpdesk/karazlinen/karazlinen-KSA/FE/Cart/DiscountBuyOneGetOne')).replace("-", "")
}
println SubPrice
println VAT_Amount
println TotalAmount
println Discount_Amount

WebUI.waitForElementVisible(findTestObject('Object Repository/Helpdesk/karazlinen/karazlinen-KSA/FE/Cart/PriceSummaryButton'),10)
WebUI.waitForElementClickable(findTestObject('Object Repository/Helpdesk/karazlinen/karazlinen-KSA/FE/Cart/PriceSummaryButton'),10)
CustomKeywords.'helpdesk.HelpdeskUtil.ScrollToElement'(findTestObject('Object Repository/Helpdesk/karazlinen/karazlinen-KSA/FE/Cart/PriceSummaryButton'))
WebUI.click(findTestObject('Object Repository/Helpdesk/karazlinen/karazlinen-KSA/FE/Cart/PriceSummaryButton'))

if(!WebUI.verifyElementVisible(findTestObject('Object Repository/Helpdesk/karazlinen/karazlinen-KSA/FE/Checkout/Checkout_Step_1'),FailureHandling.OPTIONAL)) {
	WebUI.click(findTestObject('Object Repository/Helpdesk/karazlinen/karazlinen-KSA/FE/Cart/PriceSummaryButton'))
}

//Check Step 1
WebUI.verifyElementVisible(findTestObject('Object Repository/Helpdesk/karazlinen/karazlinen-KSA/FE/Checkout/Checkout_Step_1'))

WebUI.verifyElementVisible(findTestObject('Object Repository/Helpdesk/karazlinen/karazlinen-KSA/FE/Checkout/Checkout_Step_1_FullName'))
WebUI.verifyMatch(WebUI.getAttribute(findTestObject('Object Repository/Helpdesk/karazlinen/karazlinen-KSA/FE/Checkout/Checkout_Step_1_FullName'),"value").toLowerCase(), GlobalVariable.CustomerName.toString().toLowerCase(), false)

WebUI.verifyElementVisible(findTestObject('Object Repository/Helpdesk/karazlinen/karazlinen-KSA/FE/Checkout/Checkout_Step_1_Email'))
WebUI.verifyMatch(WebUI.getAttribute(findTestObject('Object Repository/Helpdesk/karazlinen/karazlinen-KSA/FE/Checkout/Checkout_Step_1_Email'),"value").toLowerCase(), GlobalVariable.CustomerEmail.toString().toLowerCase(), false)

WebUI.verifyElementVisible(findTestObject('Object Repository/Helpdesk/karazlinen/karazlinen-KSA/FE/Checkout/Checkout_Step_1_ContinueToShipment'))

//Check Step 2
WebUI.click(findTestObject('Object Repository/Helpdesk/karazlinen/karazlinen-KSA/FE/Checkout/Checkout_Step_1_ContinueToShipment'))

WebUI.verifyElementVisible(findTestObject('Object Repository/Helpdesk/karazlinen/karazlinen-KSA/FE/Checkout/Checkout_Step_2_Map'))
WebUI.verifyElementVisible(findTestObject('Object Repository/Helpdesk/karazlinen/karazlinen-KSA/FE/Checkout/Checkout_Step_2_EnterAddressManually'))
WebUI.verifyElementVisible(findTestObject('Object Repository/Helpdesk/karazlinen/karazlinen-KSA/FE/Checkout/Checkout_Step_2_SelctLocationOnMap'))

WebUI.click(findTestObject('Object Repository/Helpdesk/karazlinen/karazlinen-KSA/FE/Checkout/Checkout_Step_2_EnterAddressManually'))

WebUI.verifyElementVisible(findTestObject('Object Repository/Helpdesk/karazlinen/karazlinen-KSA/FE/Checkout/Checkout_Step_2'))

WebUI.verifyElementVisible(findTestObject('Object Repository/Helpdesk/karazlinen/karazlinen-KSA/FE/Checkout/Checkout_Step_2_Country'))
WebUI.verifyMatch(WebUI.getText(findTestObject('Object Repository/Helpdesk/karazlinen/karazlinen-KSA/FE/Checkout/Checkout_Step_2_Country')),"السعودية",false)
	
WebUI.verifyElementVisible(findTestObject('Object Repository/Helpdesk/karazlinen/karazlinen-KSA/FE/Checkout/Checkout_Step_2_City'))
WebUI.verifyElementVisible(findTestObject('Object Repository/Helpdesk/karazlinen/karazlinen-KSA/FE/Checkout/Checkout_Step_2_District'))
WebUI.verifyElementVisible(findTestObject('Object Repository/Helpdesk/karazlinen/karazlinen-KSA/FE/Checkout/Checkout_Step_2_PostCode'))

WebUI.click(findTestObject('Object Repository/Helpdesk/karazlinen/karazlinen-KSA/FE/Checkout/Checkout_Step_2_City'))
WebUI.delay(1)
WebUI.sendKeys(findTestObject('Object Repository/Helpdesk/karazlinen/karazlinen-KSA/FE/Checkout/Checkout_Step_2_CityInput'), "الرياض")
WebUI.sendKeys(findTestObject('Object Repository/Helpdesk/karazlinen/karazlinen-KSA/FE/Checkout/Checkout_Step_2_CityInput'), Keys.chord(Keys.ENTER))


WebUI.click(findTestObject('Object Repository/Helpdesk/karazlinen/karazlinen-KSA/FE/Checkout/Checkout_Step_2_District'))
WebUI.delay(1)
WebUI.sendKeys(findTestObject('Object Repository/Helpdesk/karazlinen/karazlinen-KSA/FE/Checkout/Checkout_Step_2_DistrictInput'), "العليا")
WebUI.sendKeys(findTestObject('Object Repository/Helpdesk/karazlinen/karazlinen-KSA/FE/Checkout/Checkout_Step_2_DistrictInput'), Keys.chord(Keys.ENTER))

WebUI.sendKeys(findTestObject('Object Repository/Helpdesk/karazlinen/karazlinen-KSA/FE/Checkout/Checkout_Step_2_Address'), "شارع العليا، العليا، الرياض 12214")
WebUI.sendKeys(findTestObject('Object Repository/Helpdesk/karazlinen/karazlinen-KSA/FE/Checkout/Checkout_Step_2_PostCode'), "1234")
WebUI.click(findTestObject('Object Repository/Helpdesk/karazlinen/karazlinen-KSA/FE/Checkout/Checkout_Step_2_ContinueToPay'))

//Check Step 3

//We should check if shipment fee is 0 when total paid is more than x and 20 if less than x
//PaymentMethods
TestObject paymentPath = new TestObject()
paymentPath.addProperty('xpath', ConditionType.EQUALS, '//div[contains(@class,"payment-paymentMethod")]')
WebUI.waitForElementVisible(paymentPath,10)
List Paymentlist = WebUiCommonHelper.findWebElements(paymentPath, 30)

if (Paymentlist.size() != 4) {
 	println (Paymentlist.size())
   assert false
} else {
	// Tabby
	CustomKeywords.'helpdesk.HelpdeskUtil.ScrollToElement'(findTestObject('Object Repository/Helpdesk/karazlinen/karazlinen-KSA/FE/Checkout/Checkout_Step_3_PaymentMethod_1_Text'))
    WebUI.verifyElementVisible(findTestObject('Object Repository/Helpdesk/karazlinen/karazlinen-KSA/FE/Checkout/Checkout_Step_3_PaymentMethod_1_Text'))
	// Tamara
	CustomKeywords.'helpdesk.HelpdeskUtil.ScrollToElement'(findTestObject('Object Repository/Helpdesk/karazlinen/karazlinen-KSA/FE/Checkout/Checkout_Step_3_PaymentMethod_2_Text'))
    WebUI.verifyElementVisible(findTestObject('Object Repository/Helpdesk/karazlinen/karazlinen-KSA/FE/Checkout/Checkout_Step_3_PaymentMethod_2_Text'))
	// Credit
	CustomKeywords.'helpdesk.HelpdeskUtil.ScrollToElement'(findTestObject('Object Repository/Helpdesk/karazlinen/karazlinen-KSA/FE/Checkout/Checkout_Step_3_PaymentMethod_3_Text'))
    WebUI.verifyElementVisible(findTestObject('Object Repository/Helpdesk/karazlinen/karazlinen-KSA/FE/Checkout/Checkout_Step_3_PaymentMethod_3_Text'))
	// In the shop
	CustomKeywords.'helpdesk.HelpdeskUtil.ScrollToElement'(findTestObject('Object Repository/Helpdesk/karazlinen/karazlinen-KSA/FE/Checkout/Checkout_Step_3_PaymentMethod_4_Text'))
    WebUI.verifyElementVisible(findTestObject('Object Repository/Helpdesk/karazlinen/karazlinen-KSA/FE/Checkout/Checkout_Step_3_PaymentMethod_4_Text'))
	
	WebUI.verifyElementVisible(findTestObject('Object Repository/Helpdesk/karazlinen/karazlinen-KSA/FE/Checkout/Checkout_Step_3_Continue'))
}

//Order with COD
WebUI.click(findTestObject('Object Repository/Helpdesk/karazlinen/karazlinen-KSA/FE/Checkout/Checkout_Step_3_PaymentMethod_4_Text'))
WebUI.waitForElementClickable(findTestObject('Object Repository/Helpdesk/karazlinen/karazlinen-KSA/FE/Checkout/Checkout_Step_3_Continue'), 5)
WebUI.click(findTestObject('Object Repository/Helpdesk/karazlinen/karazlinen-KSA/FE/Checkout/Checkout_Step_3_Continue'))

WebUI.verifyElementVisible(findTestObject('Object Repository/Helpdesk/karazlinen/karazlinen-KSA/FE/Checkout/Checkout_Step_3_ConfirmOrder'))

WebUI.verifyElementVisible(findTestObject('Object Repository/Helpdesk/karazlinen/karazlinen-KSA/FE/Checkout/Checkout_Step_3_Summary_SubPrice'))
WebUI.verifyElementVisible(findTestObject('Object Repository/Helpdesk/karazlinen/karazlinen-KSA/FE/Checkout/Checkout_Step_3_Summary_ShipmentFees'))
WebUI.verifyElementVisible(findTestObject('Object Repository/Helpdesk/karazlinen/karazlinen-KSA/FE/Checkout/Checkout_Step_3_Summary_VATFees'))
WebUI.verifyElementVisible(findTestObject('Object Repository/Helpdesk/karazlinen/karazlinen-KSA/FE/Checkout/Checkout_Step_3_Summary_TotalPrice'))

String ACTSubPrice=WebUI.getText(findTestObject('Object Repository/Helpdesk/karazlinen/karazlinen-KSA/FE/Checkout/Checkout_Step_3_Summary_SubPrice'))
String ACTShippment=WebUI.getText(findTestObject('Object Repository/Helpdesk/karazlinen/karazlinen-KSA/FE/Checkout/Checkout_Step_3_Summary_ShipmentFees'))
String ACTVAT_Amount=WebUI.getText(findTestObject('Object Repository/Helpdesk/karazlinen/karazlinen-KSA/FE/Checkout/Checkout_Step_3_Summary_VATFees'))
String ACTTotalAmount=WebUI.getText(findTestObject('Object Repository/Helpdesk/karazlinen/karazlinen-KSA/FE/Checkout/Checkout_Step_3_Summary_TotalPrice'))
String ACTDiscount_Amount="0.0"
if(WebUI.waitForElementVisible(findTestObject('Object Repository/Helpdesk/karazlinen/karazlinen-KSA/FE/Checkout/Checkout_Step_3_Summary_BuyOneGetOne'), 3)) {
	ACTDiscount_Amount=WebUI.getText(findTestObject('Object Repository/Helpdesk/karazlinen/karazlinen-KSA/FE/Checkout/Checkout_Step_3_Summary_BuyOneGetOne')).replace("-", "")
}

Float ACTSubPriceNum=ACTSubPrice.replace("ر.س", "").replace(",", "").replace(" ", "").toFloat()
Float ACTShippmentNum=ACTShippment.replace("ر.س", "").replace(",", "").replace(" ", "").toFloat()
Float ACTVAT_AmountNum=ACTVAT_Amount.replace("ر.س", "").replace(",", "").replace(" ", "").toFloat()
Float ACTDiscount_AmountNum=ACTDiscount_Amount.replace("ر.س", "").replace(",", "").replace(" ", "").toFloat()
Float ACTTotalAmountNum=ACTTotalAmount.replace("ر.س", "").replace(",", "").replace(" ", "").toFloat()

//We should check the shipment amount for out side SA
WebUI.verifyMatch(ACTShippmentNum.toString(), "0.0", false)
//WebUI.verifyMatch(ACTTotalAmountNum.toString(),(ACTSubPriceNum+ACTShippmentNum-ACTDiscount_AmountNum).round(2).toString(),false)
//To handle the wrong calculation in fractions related to tax
if (Math.abs (ACTTotalAmountNum-(ACTSubPriceNum+ACTShippmentNum-ACTDiscount_AmountNum).round(2))>1){
	assert false
}
//WebUI.verifyMatch(ACTVAT_AmountNum.toString(),( ACTTotalAmountNum-((ACTSubPriceNum-ACTDiscount_AmountNum)/1.15) ).round(2).toString(),false)
//To handle the wrong calculation in fractions related to tax
if (Math.abs (ACTVAT_AmountNum-( ACTTotalAmountNum-((ACTSubPriceNum-ACTDiscount_AmountNum)/1.15) ).round(2))>1){
	assert false
}

WebUI.verifyMatch(ACTSubPrice, SubPrice, false)
if(WebUI.waitForElementVisible(findTestObject('Object Repository/Helpdesk/karazlinen/karazlinen-KSA/FE/Checkout/Checkout_Step_3_Summary_BuyOneGetOne'), 3)) {
	WebUI.verifyMatch(ACTDiscount_Amount, Discount_Amount, false)
}
WebUI.verifyMatch(ACTVAT_Amount, VAT_Amount, false)

WebUI.click(findTestObject('Object Repository/Helpdesk/karazlinen/karazlinen-KSA/FE/Checkout/Checkout_Step_3_ConfirmOrder'))


TestObject OrderDetails = new TestObject()

OrderDetails.addProperty('xpath', ConditionType.EQUALS, '//div[contains(@class,"style-description-") and contains(text(),"تم انشاء طلبك رقم")]')

WebElement OrderDetailsElement = WebUiCommonHelper.findWebElement(OrderDetails, 30)

def orderDetailsText = OrderDetailsElement.getText()

println(orderDetailsText)

def orderNumber = orderDetailsText.findAll('\\d+').get(0)

//remove the order
WebUI.delay(2)
int currentTab = WebUI.getWindowIndex()
WebUI.switchToWindowIndex(currentTab + 1)

WebUI.click(findTestObject('Object Repository/Helpdesk/karazlinen/karazlinen-KSA/BE/Menu/Menu_Sales'))

WebUI.click(findTestObject('Object Repository/Helpdesk/karazlinen/karazlinen-KSA/BE/Menu/Menu_Sales_orders'))

if (WebUI.verifyElementVisible(findTestObject('Object Repository/Helpdesk/karazlinen/karazlinen-KSA/BE/Sales_Order_page/FilterClear'), FailureHandling.OPTIONAL)) {
    WebUI.click(findTestObject('Object Repository/Helpdesk/karazlinen/karazlinen-KSA/BE/Sales_Order_page/FilterClear'))
}

WebUI.delay(2)

WebUI.click(findTestObject('Object Repository/Helpdesk/karazlinen/karazlinen-KSA/BE/Sales_Order_page/button_Filters'))

WebUI.waitForElementClickable(findTestObject('Object Repository/Helpdesk/karazlinen/karazlinen-KSA/BE/Sales_Order_page/Filter_ID_FROM'), 2)

WebUI.setText(findTestObject('Object Repository/Helpdesk/karazlinen/karazlinen-KSA/BE/Sales_Order_page/Filter_increment_id'), orderNumber)

WebUI.click(findTestObject('Object Repository/Helpdesk/karazlinen/karazlinen-KSA/BE/Sales_Order_page/Sales_orders_FilterButton'))

TestObject searchResultTO = new TestObject()

searchResultTO.addProperty('xpath', ConditionType.EQUALS, ('//div[@class="data-grid-cell-content" and text()="' + orderNumber) + 
    '"]')

List<WebElement> searchResultElm = WebUiCommonHelper.findWebElements(searchResultTO, 10)

if (searchResultElm.size().equals(1)) {
    searchResultElm.get(0).click()

    TestObject OrderHeaderTO = new TestObject()

    OrderHeaderTO.addProperty('xpath', ConditionType.EQUALS, '//div[@class="page-header-hgroup col-l-8 col-m-6"]//div[@class="page-title-wrapper"]//h1[@class="page-title"]')

    WebElement OrderHeaderElem = WebUiCommonHelper.findWebElement(OrderHeaderTO, 30)

    def OrderHeaderText = OrderHeaderElem.getText()

    if (OrderHeaderText.equals('#' + orderNumber)) {
        TestObject CustomerNameTO = new TestObject()

        CustomerNameTO.addProperty('xpath', ConditionType.EQUALS, '//a[@target="_blank"]//span[text()="' + GlobalVariable.CustomerName + '"]')

        WebElement CustomerNameElem = WebUiCommonHelper.findWebElement(CustomerNameTO, 30)

        if (CustomerNameElem.getText().equals(GlobalVariable.CustomerName)) {
            TestObject CancelButtonTO = new TestObject()

            CancelButtonTO.addProperty('xpath', ConditionType.EQUALS, '//button[@id="order-view-cancel-button"]')

            WebElement CancelButtonElem = WebUiCommonHelper.findWebElement(CancelButtonTO, 30)

            CancelButtonElem.click()

            TestObject CancelButtonOKTO = new TestObject()

            CancelButtonOKTO.addProperty('xpath', ConditionType.EQUALS, '//button[@class="action-primary action-accept"]')

            WebElement CancelButtonOKElem = WebUiCommonHelper.findWebElement(CancelButtonOKTO, 30)

            CancelButtonOKElem.click()
        }
    }
}

WebUI.delay(5)

WebUI.closeBrowser()