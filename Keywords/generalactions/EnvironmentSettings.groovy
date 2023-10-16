package generalactions

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.appium.driver.AppiumDriverManager
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.constants.StringConstants
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable

public class EnvironmentSettings {

	@Keyword
	String isRunningByMobile() {
		String runningMode='1'
		def mobileEmulation = (Map<String,Object>)RunConfiguration.getDriverPreferencesProperties().get('WebUI')
		if(mobileEmulation !=null) {
		println mobileEmulation.get('mobileEmulation')
		if(mobileEmulation.get('mobileEmulation')!=null) {
			runningMode='2'
		}
		}else {
			mobileEmulation = (Map<String,Object>)RunConfiguration.getDriverPreferencesProperties().get('Mobile')
			if(mobileEmulation!= null) {
				KeywordUtil.logInfo("Mobile -->" +  AppiumDriverManager.getDeviceOS(StringConstants.CONF_PROPERTY_MOBILE_DRIVER) )
				if(AppiumDriverManager.getDeviceOS(StringConstants.CONF_PROPERTY_MOBILE_DRIVER)=="Android") {
					runningMode='3'
				}
			}
		}
		return runningMode
	}
}
