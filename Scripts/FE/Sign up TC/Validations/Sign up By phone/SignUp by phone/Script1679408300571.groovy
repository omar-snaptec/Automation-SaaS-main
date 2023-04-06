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

//WebUI.sendKeys(findTestObject('Sign up Page/Sgin up By phone/Last name sign up Mobile'), Keys.chord(Keys.CONTROL, ‘a’))
//WebUI.sendKeys(findTestObject('Sign up Page/Sgin up By phone/First name sign up mobile'), Keys.chord(Keys.BACK_SPACE))
 

WebUI.uncheck(findTestObject('Sign up Page/Sgin up By phone/Check box rules'))

WebUI.clearText(findTestObject('Sign up Page/Sgin up By phone/First name sign up mobile'))
//WebUI.sendKeys(findTestObject('Sign up Page/Sgin up By phone/First name sign up mobile'), Keys.chord(Keys.CONTROL, ‘a’))

WebUI.clearText(findTestObject('Sign up Page/Sgin up By phone/Last name sign up Mobile'))
WebUI.clearText(findTestObject('Sign up Page/Sgin up By phone/insert phone number'))
//WebUI.sendKeys(findTestObject('Sign up Page/Sgin up By phone/Last name sign up Mobile'), Keys.chord(Keys.CONTROL, ‘a’))
WebUI.setText(findTestObject('Sign up Page/Sgin up By phone/First name sign up mobile'), firstname)
WebUI.setText(findTestObject('Sign up Page/Sgin up By phone/Last name sign up Mobile'), lastname)
WebUI.setText(findTestObject('Sign up Page/Sgin up By phone/insert phone number'), PhoneNumber)

//WebUI.delay(3)
if(isCheck=='1') {
	WebUI.check(findTestObject('Sign up Page/Sgin up By phone/Check box rules'))
}

if(firstname.length()==0) {
	WebUI.sendKeys(findTestObject('Sign up Page/Sgin up By phone/First name sign up mobile'), Keys.chord(Keys.CONTROL, 'a'))
	WebUI.sendKeys(findTestObject('Sign up Page/Sgin up By phone/First name sign up mobile'), Keys.chord(Keys.BACK_SPACE))
	
		//WebUI.clearText(findTestObject('Sign up Page/Sgin up By phone/First name sign up mobile'))
		WebUI.sendKeys(findTestObject('Sign up Page/Sgin up By phone/First name sign up mobile'),'')
	}
	//WebUI.delay(3)
	if(lastname.length()==0) {
		WebUI.sendKeys(findTestObject('Sign up Page/Sgin up By phone/Last name sign up Mobile'), Keys.chord(Keys.CONTROL, 'a'))
		WebUI.sendKeys(findTestObject('Sign up Page/Sgin up By phone/Last name sign up Mobile'), Keys.chord(Keys.BACK_SPACE))
		
		//WebUI.clearText(findTestObject('Sign up Page/Sgin up By phone/Last name sign up Mobile'))
		WebUI.sendKeys(findTestObject('Sign up Page/Sgin up By phone/Last name sign up Mobile'),' ')
		//WebUI.mouseOver(findTestObject('Sign up Page/Sgin up By phone/Submit Button Sign up mobile page'))
	}
	//WebUI.delay(3)
	if(PhoneNumber.length()==0) {
		WebUI.sendKeys(findTestObject('Sign up Page/Sgin up By phone/insert phone number'), Keys.chord(Keys.CONTROL, 'a'))
		WebUI.sendKeys(findTestObject('Sign up Page/Sgin up By phone/insert phone number'), Keys.chord(Keys.BACK_SPACE))
		//WebUI.sendKeys(findTestObject('Sign up Page/Sgin up By phone/insert phone number'),'')
	}
//WebUI.delay(1)
WebUI.click(findTestObject('Sign up Page/Sgin up By phone/Submit Button Sign up mobile page'))


