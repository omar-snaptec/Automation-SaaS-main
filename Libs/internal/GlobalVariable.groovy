package internal

import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.main.TestCaseMain


/**
 * This class is generated automatically by Katalon Studio and should not be modified or deleted.
 */
public class GlobalVariable {
     
    /**
     * <p></p>
     */
    public static Object URL
     
    /**
     * <p></p>
     */
    public static Object Vaild_email
     
    /**
     * <p></p>
     */
    public static Object Wrong_email
     
    /**
     * <p></p>
     */
    public static Object languageMode
     
    /**
     * <p></p>
     */
    public static Object gDBUrl
     
    /**
     * <p></p>
     */
    public static Object gDBUserName
     
    /**
     * <p></p>
     */
    public static Object gDBPassword
     
    /**
     * <p></p>
     */
    public static Object gJDBCClass
     
    /**
     * <p></p>
     */
    public static Object testSuiteStatus
     
    /**
     * <p></p>
     */
    public static Object textSearch
     
    /**
     * <p></p>
     */
    public static Object ValidPassword
     
    /**
     * <p></p>
     */
    public static Object FixedOTP
     
    /**
     * <p></p>
     */
    public static Object phoneNumber
     
    /**
     * <p></p>
     */
    public static Object FirstName
     
    /**
     * <p></p>
     */
    public static Object LastName
     
    /**
     * <p>Profile default : 1 = Web Browser, 2 = Mobile Browser, 3= Mobile App</p>
     */
    public static Object RunningMode
     
    /**
     * <p>Profile default : 1=iPhone, 2=Android</p>
     */
    public static Object MobileType
     
    /**
     * <p></p>
     */
    public static Object FE_URL
     
    /**
     * <p>Profile Orange : 581492572</p>
     */
    public static Object FE_Tel
     
    /**
     * <p></p>
     */
    public static Object BE_UserName
     
    /**
     * <p></p>
     */
    public static Object BE_Password
     
    /**
     * <p></p>
     */
    public static Object BE_URL
     
    /**
     * <p>Profile Orange : testing dev</p>
     */
    public static Object CustomerName
     
    /**
     * <p></p>
     */
    public static Object MadaCardNum
     
    /**
     * <p></p>
     */
    public static Object MadaExpiryDate
     
    /**
     * <p></p>
     */
    public static Object MadaCVV
     
    /**
     * <p></p>
     */
    public static Object BEBasicAuthUser
     
    /**
     * <p></p>
     */
    public static Object BEBasicAuthPassword
     
    /**
     * <p></p>
     */
    public static Object Latitude
     
    /**
     * <p></p>
     */
    public static Object Longtitude
     
    /**
     * <p>Profile Orange : mahmoud@snaptec.co</p>
     */
    public static Object CustomerEmail
     
    /**
     * <p></p>
     */
    public static Object MadaCardHoldName
     

    static {
        try {
            def selectedVariables = TestCaseMain.getGlobalVariables("default")
			selectedVariables += TestCaseMain.getGlobalVariables(RunConfiguration.getExecutionProfile())
            selectedVariables += TestCaseMain.getParsedValues(RunConfiguration.getOverridingParameters(), selectedVariables)
    
            URL = selectedVariables['URL']
            Vaild_email = selectedVariables['Vaild_email']
            Wrong_email = selectedVariables['Wrong_email']
            languageMode = selectedVariables['languageMode']
            gDBUrl = selectedVariables['gDBUrl']
            gDBUserName = selectedVariables['gDBUserName']
            gDBPassword = selectedVariables['gDBPassword']
            gJDBCClass = selectedVariables['gJDBCClass']
            testSuiteStatus = selectedVariables['testSuiteStatus']
            textSearch = selectedVariables['textSearch']
            ValidPassword = selectedVariables['ValidPassword']
            FixedOTP = selectedVariables['FixedOTP']
            phoneNumber = selectedVariables['phoneNumber']
            FirstName = selectedVariables['FirstName']
            LastName = selectedVariables['LastName']
            RunningMode = selectedVariables['RunningMode']
            MobileType = selectedVariables['MobileType']
            FE_URL = selectedVariables['FE_URL']
            FE_Tel = selectedVariables['FE_Tel']
            BE_UserName = selectedVariables['BE_UserName']
            BE_Password = selectedVariables['BE_Password']
            BE_URL = selectedVariables['BE_URL']
            CustomerName = selectedVariables['CustomerName']
            MadaCardNum = selectedVariables['MadaCardNum']
            MadaExpiryDate = selectedVariables['MadaExpiryDate']
            MadaCVV = selectedVariables['MadaCVV']
            BEBasicAuthUser = selectedVariables['BEBasicAuthUser']
            BEBasicAuthPassword = selectedVariables['BEBasicAuthPassword']
            Latitude = selectedVariables['Latitude']
            Longtitude = selectedVariables['Longtitude']
            CustomerEmail = selectedVariables['CustomerEmail']
            MadaCardHoldName = selectedVariables['MadaCardHoldName']
            
        } catch (Exception e) {
            TestCaseMain.logGlobalVariableError(e)
        }
    }
}
