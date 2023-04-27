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
import java.awt.Robot as Robot
import java.awt.event.KeyEvent as KeyEvent
import org.openqa.selenium.JavascriptExecutor as JavascriptExecutor
import org.openqa.selenium.WebDriver as WebDriver
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
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
import java.util.concurrent.ConcurrentHashMap.KeySetView as KeySetView
import org.eclipse.jdt.internal.compiler.ast.ForeachStatement as ForeachStatement
import org.openqa.selenium.By as By
import org.openqa.selenium.WebElement as WebElement

WebUI.openBrowser('')

WebUI.navigateToUrl(GlobalVariable.FE_URL)

WebUI.maximizeWindow()

WebUI.waitForElementClickable(findTestObject('Object Repository/Helpdesk/AjStore/Shared/Login'), 20)

WebUI.click(findTestObject('Object Repository/Helpdesk/AjStore/Shared/Login'))

WebUI.waitForElementVisible(findTestObject('Object Repository/Helpdesk/AjStore/Login/LoginTolephone'), 20)

WebUI.waitForElementClickable(findTestObject('Object Repository/Helpdesk/AjStore/Login/LoginTolephone'), 20)

WebUI.sendKeys(findTestObject('Object Repository/Helpdesk/AjStore/Login/LoginTolephone'), GlobalVariable.FE_Tel)

WebUI.click(findTestObject('Object Repository/Helpdesk/AjStore/Login/acknowledgement'))

WebUI.click(findTestObject('Object Repository/Helpdesk/AjStore/Login/LoginButton'))

WebUI.waitForElementVisible(findTestObject('Object Repository/Helpdesk/AjStore/Login/EnterOTP'), 10)

WebUI.verifyElementVisible(findTestObject('Object Repository/Helpdesk/AjStore/Login/EnterOTP'), FailureHandling.STOP_ON_FAILURE)

int currentTab = WebUI.getWindowIndex()

//Robot robot = new Robot()
//robot.keyPress(KeyEvent.VK_CONTROL)
//robot.keyPress(KeyEvent.VK_T)
//robot.keyRelease(KeyEvent.VK_CONTROL)
//robot.keyRelease(KeyEvent.VK_T)
WebDriver driver = DriverFactory.getWebDriver()

JavascriptExecutor js = ((driver) as JavascriptExecutor)

js.executeScript('window.open();')

WebUI.switchToWindowIndex(currentTab + 1)

WebUI.navigateToUrl(GlobalVariable.BE_URL)

//WebUI.switchToWindowTitle('متجر عجلان واخوانه')
WebUI.setText(findTestObject('Object Repository/Helpdesk/AjStore/BE/Login/UserName'), GlobalVariable.BE_UserName)

//WebUI.setEncryptedText(findTestObject('Object Repository/Helpdesk/AjStore/BE/Login/Password'), 'h9YfHV16ZyMBoeJlmdP5xA==')
WebUI.setText(findTestObject('Object Repository/Helpdesk/AjStore/BE/Login/Password'), GlobalVariable.BE_Password)

WebUI.click(findTestObject('Object Repository/Helpdesk/AjStore/BE/Login/LoginButton'))

WebUI.click(findTestObject('Object Repository/Helpdesk/AjStore/BE/Menu/Menu_MageDelight'))

WebUI.click(findTestObject('Object Repository/Helpdesk/AjStore/BE/Menu/Menu_MageDelight_MobileOTPLogin'))

WebUI.click(findTestObject('Object Repository/Helpdesk/AjStore/BE/Menu/Menu_MageDelight_MobileOTPLogin_SMSLog'))

//WebUI.click(findTestObject('Object Repository/Helpdesk/AjStore/Page_SMS Log  Magento Admin/button_Remove'))
WebUI.click(findTestObject('Object Repository/Helpdesk/AjStore/BE/SmsLogPage/button_Filters'))

WebUI.setText(findTestObject('Object Repository/Helpdesk/AjStore/BE/SmsLogPage/transaction_type'), '')

WebUI.setText(findTestObject('Object Repository/Helpdesk/AjStore/BE/SmsLogPage/status'), '')

WebUI.setText(findTestObject('Object Repository/Helpdesk/AjStore/BE/SmsLogPage/s_id'), '')

WebUI.setText(findTestObject('Object Repository/Helpdesk/AjStore/BE/SmsLogPage/recipient_phone'), '')

WebUI.setText(findTestObject('Object Repository/Helpdesk/AjStore/BE/SmsLogPage/message_body'), '')

WebUI.setText(findTestObject('Object Repository/Helpdesk/AjStore/BE/SmsLogPage/entity_id_to'), '')

WebUI.setText(findTestObject('Object Repository/Helpdesk/AjStore/BE/SmsLogPage/entity_id_from'), '')

WebUI.setText(findTestObject('Object Repository/Helpdesk/AjStore/BE/SmsLogPage/api_service'), '')

WebUI.click(findTestObject('Object Repository/Helpdesk/AjStore/BE/Sales_Order_page/Sales_orders_FilterButton'))

WebUI.delay(2)

WebUI.click(findTestObject('Object Repository/Helpdesk/AjStore/BE/SmsLogPage/button_Filters'))

WebUI.waitForElementClickable(findTestObject('Object Repository/Helpdesk/AjStore/BE/SmsLogPage/recipient_phone'), 2)

WebUI.setText(findTestObject('Object Repository/Helpdesk/AjStore/BE/SmsLogPage/recipient_phone'), GlobalVariable.FE_Tel)

//WebUI.sendKeys(findTestObject('Object Repository/Helpdesk/AjStore/BE/SmsLogPage/recipient_phone'), 
//    Keys.chord(Keys.ENTER))
WebUI.click(findTestObject('Object Repository/Helpdesk/AjStore/BE/Sales_Order_page/Sales_orders_FilterButton'))

//TestObject FirstRowReceiptPhone = new TestObject()
//FirstRowReceiptPhone.addProperty("xpath",ConditionType.EQUALS,"//tr[@class='data-row' and @data-repeat-index='0']/td[6]/div")
WebUI.waitForElementVisible(findTestObject('Object Repository/Helpdesk/AjStore/BE/SmsLogPage/SmsContentFirstRow'), 20)

String OTP = WebUI.getText(findTestObject('Object Repository/Helpdesk/AjStore/BE/SmsLogPage/SmsContentFirstRow'))

println('>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>')

println(OTP)

OTP = OTP.replace('كلمة المرور لتسجيل الدخول رمز: ', '')

println(OTP)

//WebUI.switchToWindowTitle('SMS Log / Magento Admin')
//WebUI.switchToWindowTitle('متجر عجلان واخوانه')
WebUI.delay(2)

WebUI.switchToWindowIndex(currentTab)

String xPath = '//input[@type=\'tel\' and contains( @aria-label,\'Digit 1\')]'

TestObject firstOTPDigit = new TestObject('objectName')

firstOTPDigit.addProperty('xpath', ConditionType.EQUALS, xPath)

WebUI.sendKeys(firstOTPDigit, OTP)

//WebUI.waitForElementNotPresent(findTestObject('Object Repository/Helpdesk/AjStore/Login/EnterOTP'), 20, FailureHandling.STOP_ON_FAILURE)
WebUI.waitForElementVisible(findTestObject('Object Repository/Helpdesk/AjStore/AccountPage/AccountPageTitle'), 20)

WebUI.verifyElementVisible(findTestObject('Object Repository/Helpdesk/AjStore/AccountPage/AccountPageTitle'), FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementNotPresent(findTestObject('Object Repository/Helpdesk/AjStore/Login/EnterOTP'), 2)

/////////////////////////
WebUI.click(findTestObject('Object Repository/Helpdesk/AjStore/Shared/Logo2'))

///Clear Cart
WebUI.click(findTestObject('Object Repository/Helpdesk/AjStore/Shared/Cart'))

TestObject removeProductFromCart = new TestObject()

removeProductFromCart.addProperty('xpath', ConditionType.EQUALS, '//button[contains(@class,"product-button")]//span//div/img[@alt="Remove" and @loading="lazy"]')

List removeProductFromCartElements = WebUiCommonHelper.findWebElements(removeProductFromCart, 10)

while (removeProductFromCartElements.size() != 0) {
    if (removeProductFromCartElements.size().equals(1)) {
        removeProductFromCartElements.get(0).click()

        removeProductFromCartElements.remove(0)
    } else {
        removeProductFromCartElements.get(0).click()

        removeProductFromCartElements = WebUiCommonHelper.findWebElements(removeProductFromCart, 10)
    }
}

WebUI.click(findTestObject('Object Repository/Helpdesk/AjStore/Shared/Logo2'))

List prod = CustomKeywords.'products.productsFromCatalog.getinStockProductFromOnePage'()

Random randomNumberforProduct = new Random()

def elementIndexproduct = Math.abs(randomNumberforProduct.nextInt(prod.size()))

def currentURL = WebUI.getUrl()

TestObject tb = new TestObject()

tb.addProperty('xpath', ConditionType.EQUALS, ('(//button[contains(text(),\'Add to Cart\') or contains(text(),\'أضف إلى السلة\')])[' + 
    elementIndexproduct) + ']')

WebElement element = WebUiCommonHelper.findWebElement(tb, 30)

WebUI.executeJavaScript('arguments[0].click()', Arrays.asList(element))

if (WebUI.getUrl() == currentURL) {
    WebUI.click(findTestObject('Object Repository/Cart/Continue Shopping'), FailureHandling.CONTINUE_ON_FAILURE)
} else {
    KeywordUtil.markPassed('Trying to Get Configurable product')

    tb.addProperty('xpath', ConditionType.EQUALS, '//section[starts-with(@class,\'productFullDetail-groupOption-\')]//div[starts-with(@class,\'option-root-\')]')

    List genralDropDowns = WebUI.findWebElements(tb, 30)

    if (genralDropDowns.size() != 0) {
        for (int i = 1; i <= genralDropDowns.size(); i++) {
            tb.addProperty('xpath', ConditionType.EQUALS, ('(//section[starts-with(@class,\'productFullDetail-groupOption-\')]//div[starts-with(@class,\'option-root-\')])[' + 
                i) + ']//div//button[not( @disabled)]')

            WebUI.click(tb)
        }
    }
}

///// Save Data in variable gettext getSKU
WebUI.waitForElementVisible(findTestObject('Object Repository/Helpdesk/AjStore/Shared/Logo'), 10)

//WebUI.callTestCase(findTestCase('Test Cases/FE/Website launch/Validations/Website launch'), [:], FailureHandling.STOP_ON_FAILURE)
WebUI.verifyElementVisible(findTestObject('Object Repository/Helpdesk/AjStore/Search/Search icon'))

WebUI.click(findTestObject('Object Repository/Helpdesk/AjStore/Search/Search icon'))

WebUI.verifyElementVisible(findTestObject('Object Repository/Helpdesk/AjStore/Search/Search Feild'))

WebUI.verifyElementVisible(findTestObject('Object Repository/Helpdesk/AjStore/Search/Search Bar context'))

WebUI.verifyElementVisible(findTestObject('Object Repository/Helpdesk/AjStore/Cart/Add to cart'))

WebUI.click(findTestObject('Object Repository/Helpdesk/AjStore/Cart/Add to cart'))

WebUI.verifyElementClickable(findTestObject('Object Repository/Helpdesk/AjStore/Cart/view cart'))

WebUI.click(findTestObject('Object Repository/Helpdesk/AjStore/Cart/view cart'))

//Check Total Paid for Tabby and Tamara
TestObject totalPaidTO = new TestObject()

totalPaidTO.addProperty('xpath', ConditionType.EQUALS, '//span[text()="المجموع الكلي (شامل الضريبة)"]//following-sibling::span//div/span')

List totalPaidElements = WebUI.findWebElements(totalPaidTO, 10)

def totalText = ''

totalPaidElements.each({ 
        totalText += it.getText()
    })

//println(totalValue)
def totalValue = totalText.toDouble()

if (totalValue < 99) {
    //increase the products
    def neededQty = ((Math.ceil(99 / totalValue)) as int)

    TestObject numberOfItems = new TestObject()

    numberOfItems.addProperty('xpath', ConditionType.EQUALS, '//input[@aria-label="كمية المنتج"]')

    WebElement numberOfItemsElement = WebUiCommonHelper.findWebElement(numberOfItems, 10)

    numberOfItemsElement.sendKeys(Keys.chord(Keys.BACK_SPACE))

    numberOfItemsElement.sendKeys(Keys.chord(Keys.DELETE))

    println(neededQty.toString())

    numberOfItemsElement.sendKeys(neededQty.toString())

    numberOfItemsElement.sendKeys(Keys.chord(Keys.ENTER)) //   
    //remove and select another product (need to remove and seach again)
} else if (totalValue > 2500) {
}

WebUI.click(findTestObject('Object Repository/Helpdesk/AjStore/Cart/PriceSummaryButton'))

WebUI.verifyElementVisible(findTestObject('Object Repository/Helpdesk/AjStore/Checkout/MapOnCheckout'))

//WebUI.verifyElementNotVisible(findTestObject('Object Repository/Helpdesk/AjStore/Checkout/MapErrorCannotLoad'))
//Steps
WebUI.verifyElementVisible(findTestObject('Object Repository/Helpdesk/AjStore/Checkout/Step_4_PaymentMethods'))

WebUI.verifyElementVisible(findTestObject('Object Repository/Helpdesk/AjStore/Checkout/Step_3_ShipmentMethod'))

WebUI.verifyElementVisible(findTestObject('Object Repository/Helpdesk/AjStore/Checkout/Step_2_ShipmentLocation'))

WebUI.verifyElementVisible(findTestObject('Object Repository/Helpdesk/AjStore/Checkout/Step_1_Login'))

//Shipment Methods
WebUI.verifyElementVisible(findTestObject('Object Repository/Helpdesk/AjStore/Checkout/ShipmentMethodsList'))

def ShipmentMethodsList = findTestObject('Object Repository/Helpdesk/AjStore/Checkout/ShipmentMethodsList')

def ULXPath = ShipmentMethodsList.findPropertyValue('xpath')

def LiXPath = ULXPath + '//li'

TestObject temp = new TestObject()

temp.addProperty('xpath', ConditionType.EQUALS, LiXPath)

List Shipmentlist = WebUiCommonHelper.findWebElements(temp, 30)

if (Shipmentlist.size() != 1) {
    assert false
} else {
    WebUI.verifyElementVisible(findTestObject('Object Repository/Helpdesk/AjStore/Checkout/ShpmentMethod_1'))

    WebUI.verifyElementVisible(findTestObject('Object Repository/Helpdesk/AjStore/Checkout/ShipmentMethod_1_FastShipmentText_1'))

    WebUI.verifyElementVisible(findTestObject('Object Repository/Helpdesk/AjStore/Checkout/ShipmentMethod_1_FastShipmentText_2'))

    WebUI.verifyElementVisible(findTestObject('Object Repository/Helpdesk/AjStore/Checkout/ShipmentMethod_1_FastShipmentText_3'))
}

//We should check if shipment fee is 0 when total paid is more than x and 20 if less than x
//PaymentMethods
TestObject paymentPath = new TestObject()

paymentPath.addProperty('xpath', ConditionType.EQUALS, '//div[contains(@class,"checkoutPage-paymentMethod-")]/div[not(@*)]//div[contains(@class,"paymentMethod-item-")]')

List Paymentlist = WebUiCommonHelper.findWebElements(paymentPath, 30)

if (Paymentlist.size() != 4) {
    assert false
} else {
    WebUI.verifyElementVisible(findTestObject('Object Repository/Helpdesk/AjStore/Checkout/PaymentMethod_1_Text'))

    WebUI.verifyElementVisible(findTestObject('Object Repository/Helpdesk/AjStore/Checkout/PaymentMethod_2_Text'))

    WebUI.verifyElementVisible(findTestObject('Object Repository/Helpdesk/AjStore/Checkout/PaymentMethod_3_Text'))

    WebUI.verifyElementVisible(findTestObject('Object Repository/Helpdesk/AjStore/Checkout/PaymentMethod_4_Text'))
}

//Order with COD
WebUI.click(findTestObject('Object Repository/Helpdesk/AjStore/Checkout/PaymentMethod_4_Text'))

WebUI.click(findTestObject('Object Repository/Helpdesk/AjStore/Checkout/FinishPayment'))

TestObject OrderDetails = new TestObject()

OrderDetails.addProperty('xpath', ConditionType.EQUALS, '//h4[contains(@class,"styles-orderNumber-")]')

WebElement OrderDetailsElement = WebUiCommonHelper.findWebElement(OrderDetails, 30)

def orderDetailsText = OrderDetailsElement.getText()

println(orderDetailsText)

def orderNumber = orderDetailsText.findAll('\\d+').get(0)

//remove the order
WebUI.delay(2)

WebUI.switchToWindowIndex(currentTab + 1)

WebUI.click(findTestObject('Object Repository/Helpdesk/AjStore/BE/Menu/Menu_Sales'))

WebUI.click(findTestObject('Object Repository/Helpdesk/AjStore/BE/Menu/Menu_Sales_orders'))

if (WebUI.verifyElementVisible(findTestObject('Object Repository/Helpdesk/AjStore/BE/Sales_Order_page/FilterClear'))) {
    WebUI.click(findTestObject('Object Repository/Helpdesk/AjStore/BE/Sales_Order_page/FilterClear'))
}

WebUI.delay(2)

WebUI.click(findTestObject('Object Repository/Helpdesk/AjStore/BE/Sales_Order_page/button_Filters'))

WebUI.waitForElementClickable(findTestObject('Object Repository/Helpdesk/AjStore/BE/Sales_Order_page/Filter_ID_FROM'), 2)

WebUI.setText(findTestObject('Object Repository/Helpdesk/AjStore/BE/Sales_Order_page/Filter_increment_id'), orderNumber)

WebUI.click(findTestObject('Object Repository/Helpdesk/AjStore/BE/Sales_Order_page/Sales_orders_FilterButton'))

TestObject searchResultTO = new TestObject()

searchResultTO.addProperty('xpath', ConditionType.EQUALS, ('//div[@class="data-grid-cell-content" and text()="' + orderNumber) + 
    '"]')

List searchResultElm = WebUiCommonHelper.findWebElements(searchResultTO, 10)

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