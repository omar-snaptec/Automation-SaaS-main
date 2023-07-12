package generalactions

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.common.WebUiCommonHelper
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable

public class generalStrings {
	Random random = new Random()

	@Keyword
	def generatRandomEmail() {
		def generator = { String alphabet, int n ->
			new Random().with {
				(1..n).collect { alphabet[ nextInt( alphabet.length() ) ] }.join()
			}
		}

		def randomEmail= generator( (('A'..'Z')+('a'..'z')+('0'..'9')).join(), 5 )+'@SnaptecTest.com'
		return randomEmail
	}
	@Keyword
	def generateRandomPhoneNumber() {
		def generator = { String alphabet, int n ->
			new Random().with {
				(1..n).collect { alphabet[ nextInt( alphabet.length() ) ] }.join()
			}
		}


		def phoneFormate =WebUiCommonHelper.findWebElement(findTestObject('Object Repository/OTP/input Phone number'),30).getAttribute("placeholder")
		def nonZerosFromString
		def ZerosfromString = ''
		nonZerosFromString = phoneFormate =~ '[1-9]+'

		ZerosfromString = phoneFormate =~ '(0.*?$)'

		def randomNumber=generator( (('0'..'9')).join(), ZerosfromString[0][1].toString().replaceAll("-","").length() )
		//		KeywordUtil.logInfo(nonZerosFromString[0].toString()+randomNumber)
		//		KeywordUtil.logInfo(ZerosfromString[0].toString())
		//		KeywordUtil.logInfo(nonZerosFromString[0].toString())
		//		KeywordUtil.logInfo(phoneFormate)
		return nonZerosFromString[0].toString()+randomNumber
	}
	@Keyword
	def generatePhoneWithConditions(int expectedPhoneSize , int isPhoneKeyReplaced) {

		if (expectedPhoneSize==0) {
			return ''
		}
		def generator = { String alphabet, int n ->
			new Random().with {
				(1..n).collect { alphabet[ nextInt( alphabet.length() ) ] }.join()
			}
		}
		def phoneFormate =WebUiCommonHelper.findWebElement(findTestObject('Object Repository/OTP/input Phone number'),30).getAttribute("placeholder")
		def nonZerosFromString
		def ZerosfromString = ''

		nonZerosFromString = phoneFormate =~ '[1-9]+'

		ZerosfromString = phoneFormate =~ '(0.*?$)'
		def phoneSizeFraction =nonZerosFromString[0].toString().length() +ZerosfromString[0][1].toString().replaceAll("-","").length() -expectedPhoneSize
		def randomNumber=generator( (('0'..'9')).join(), ZerosfromString[0][1].toString().replaceAll("-","").length() - phoneSizeFraction )
		def replacedPhoneKey=nonZerosFromString[0].toString()
		if(isPhoneKeyReplaced==1) {
			def replacingWith= generator( (('1'..'9')).join(), nonZerosFromString[0].toString().length() )
			if(replacingWith==replacedPhoneKey) {
				replacedPhoneKey=generator( (('1'..'4')).join(), nonZerosFromString[0].toString().length() )
			}else {
				replacedPhoneKey=replacingWith
			}
		}
		return replacedPhoneKey+randomNumber
	}
	@Keyword
	int getRandomNumberBetweenOnetoTarget(int targetNumber) {
		if(targetNumber<=0) {
			return 1
		}
		return Math.abs(random.nextInt(targetNumber))+1
	}
	@Keyword
	int getRandomNumberBetweenAnytoAny(int upperLimit, int lowerLimit) {
		return Math.abs(random.nextInt((upperLimit+1)-lowerLimit))+lowerLimit
	}
}

