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
import com.kms.katalon.core.util.KeywordcustomUtils.Util
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

Random randomNumberforCatalog = new Random()

Random randomNumberforProduct = new Random()

int elementIndexProduct;

TestObject tb = new TestObject()

	List Categories = CustomKeywords.'catalog.catlogComponants.getCategoryElements'()

   // int elementIndex = 0

	//= Math.abs((randomNumber.nextInt(Categories.size() - 1)))
	for (int elementIndex=0; elementIndex<=Math.abs((Categories.size()-1)/2) ;elementIndex++ ) {
		//elementIndex = elementIndex++
		CustomKeywords.'catalog.catlogComponants.getSpecifiedCatalogElement'(elementIndex, Categories)

		//WebUI.delay(5)
		for (int i = 1; i <= 5; i++) {
			WebUI.scrollToElement(findTestObject('Headers and Footers/Footer contents/Web footer'), 0, FailureHandling.CONTINUE_ON_FAILURE)
		}
		
		WebUI.delay(2)

		
		/*
	 * List prod =
	 * CustomKeywords.'products.productsFromCatalog.getinStockProductFromOnePage'()
	 * //KeywordcustomUtils.Util.markError(prod.get(1)) if(prod.size()==0){
	 * //WebUI.closeBrowser(FailureHandling.STOP_ON_FAILURE)
	 * KeywordcustomUtils.Util.markError("No Products in this Page")
	 *
	 * } else{ def elementIndexproduct=
	 * Math.abs((randomNumberforProduct.nextInt(prod.size())))
	 * KeywordcustomUtils.Util.logInfo(elementIndexproduct.toString()
	 * +prod.get(elementIndexproduct).toString()) if(elementIndexproduct==0) {
	 * elementIndexproduct=1 }
	 */
		List OutOfStockProducts = CustomKeywords.'products.productsFromCatalog.getOutOfStockProduct'()
		KeywordcustomUtils.Util.logInfo("00000000000000000000000000000000000000\t"+OutOfStockProducts.size())
		if (OutOfStockProducts.size() >= 1 ) {
			elementIndexProduct = Math.abs((randomNumberforProduct.nextInt(OutOfStockProducts.size() - 1)))	
			tb.addProperty('xpath', ConditionType.EQUALS, "(//div[@class='styles_productItem__YY5Bs']//button[@class='styles_atcButton__qYfHB styles_atcButton__kaT52'][contains(text(),'Sold out') or contains(text(),'مباع بالكامل')])["+elementIndexProduct+"]")
			//(//div[@class='styles_productItem__YY5Bs']//button[@class='styles_atcButton__qYfHB styles_atcButton__kaT52'][contains(text(),'Sold out') or contains(text(),'مباع بالكامل')])
			//CustomKeywords.'products.productsFromCatalog.getSpecifiedOutOfStockProduct'(elementIndexProduct, OutOfStockProducts)
			WebUI.verifyElementNotClickable(tb)
			break;
		}
		
		KeywordcustomUtils.Util.markPassed("no out of stock product")
	}




//-------->

