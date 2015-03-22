package com.esic.homePage;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.esic.Launch;

/**
 * 
 * @author Mauli
 *
 */
public class IPRegistration {

	final static Logger logger = Logger.getLogger(IPRegistration.class);
	
	@FindBy(id="lnkRegisterNewIP")
	WebElement registerNewIP;
	
	@FindBy(className="pageHeaderText")
	WebElement registerNewIPHeader;
	
	@FindBy(id="ctl00_HomePageContent_rbtnlistIsregistered_1")
	WebElement selectNoRadioButton;
	
	@FindBy(id="ctl00_HomePageContent_btnContinue")
	WebElement continueButton;
	
	public EmployeeRegistrationForm1 openRegisterNewIP() throws RegisterNewIPPageLoadError{
		//open IP registration page
		if(registerNewIP.getText().contains("Register New IP")){
			registerNewIP.click();}
		
		//switch to new window 
		boolean switchSuccess=Launch.switchToNewWindow();
		String registerIPURL="http://www.esic.in/InsuranceGlobalWebV4/Employee/RegisteredEmployees.aspx";
		if(switchSuccess && Launch.driver.getCurrentUrl().contains(registerIPURL)){			
			return goToRegistrationForm();
		}	
		else return null;
	}

	private EmployeeRegistrationForm1 goToRegistrationForm() throws RegisterNewIPError{
		if(registerNewIPHeader.getText().contains("Track Registered Employees")){
		logger.info("Success Scenario: Register New IP page has been opened");	
		}
		selectNoRadioButton.click();
		continueButton.click();
		//go to EmployeeRegistrationForm1
		return PageFactory.initElements(Launch.driver, EmployeeRegistrationForm1.class);
	}
	
	class RegisterNewIPPageLoadError extends RuntimeException{

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		
	}
	
	class RegisterNewIPError extends RuntimeException{

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		
	}
}
