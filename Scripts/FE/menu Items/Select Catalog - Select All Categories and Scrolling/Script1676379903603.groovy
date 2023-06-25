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
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

Random randomNumberforProduct = new Random()

Random randomNumber = new Random()

try {
    List Categories = CustomKeywords.'catalog.catlogComponants.getCategoryElements'()

    if (Categories.size() == 0) {
        KeywordUtil.markFailed('There is a problem on the site')
    }
    

    for (int elementIndex = 0; elementIndex <= (Categories.size() - 1); elementIndex++) {

        if ((elementIndex == 0) & (GlobalVariable.RunningMode > 1)) {
            WebUI.callTestCase(findTestCase('FE/Scrolling/scrollingAtTheBottom'), [:], FailureHandling.CONTINUE_ON_FAILURE)

            CustomKeywords.'products.productsFromCatalog.getRandominStockProductsFromOnePage'()
        }
        
        CustomKeywords.'catalog.catlogComponants.getSpecifiedCatalogElement'(elementIndex, Categories)

        WebUI.callTestCase(findTestCase('FE/Scrolling/scrollingAtTheBottom'), [:], FailureHandling.CONTINUE_ON_FAILURE)

        CustomKeywords.'products.productsFromCatalog.getRandominStockProductsFromOnePage'()
    }
}
catch (Exception e) {
    e.printStackTrace()
}