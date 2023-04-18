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
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

//WebUI.click(findTestObject('Headers and Footers/Header contents/Language'))

WebUI.waitForElementVisible(findTestObject('Switch Language/button_English'), 0)

WebUI.click(findTestObject('Switch Language/button_English'), FailureHandling.STOP_ON_FAILURE)


//GlobalVariable.FE_URL = (GlobalVariable.FE_URL + 'en')

GlobalVariable.languageMode='en'
WebUI.delay(2)
KeywordUtil.logInfo(WebUI.getUrl())
GlobalVariable.FE_URL=WebUI.getUrl()
/*
 * def x = GlobalVariable.FE_URL def matcher = '' try { matcher = x =~
 * 'http\\w://.*(/.*)'
 * 
 * if (matcher[0][1].size() > 1) {
 * 
 * GlobalVariable.FE_URL = x.replace(matcher[0][1].toString(), '/en') //println
 * GlobalVariable.FE_URL } else {
 * 
 * GlobalVariable.FE_URL = x + 'en' //println GlobalVariable.FE_URL } } catch
 * (Exception ex) { matcher = 'null' GlobalVariable.FE_URL = x +'/en' //println
 * GlobalVariable.FE_URL }
 */


