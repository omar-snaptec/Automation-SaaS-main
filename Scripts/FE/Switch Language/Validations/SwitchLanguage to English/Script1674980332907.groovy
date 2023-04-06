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
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

//WebUI.click(findTestObject('Headers and Footers/Header contents/Language'))

WebUI.waitForElementVisible(findTestObject('Switch Language/button_English'), 0)

WebUI.click(findTestObject('Switch Language/button_English'), FailureHandling.STOP_ON_FAILURE)


//GlobalVariable.URL = (GlobalVariable.URL + 'en')


def x = GlobalVariable.URL
def matcher = ''
try {
	matcher = x =~ 'http\\w://.*(/.*)'

	if (matcher[0][1].size() > 1) {
		
		GlobalVariable.URL = x.replace(matcher[0][1].toString(), '/en')
		//println GlobalVariable.URL
	} else {
		
		GlobalVariable.URL = x + 'en'
		//println GlobalVariable.URL
	}
} catch (Exception ex) {
	matcher = 'null'
	GlobalVariable.URL = x +'/en'
	//println GlobalVariable.URL
}


