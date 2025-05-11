package com.asux;
import com.asux.actiondriver.ImplicitwaitHelper;
import com.asux.config.base;
import com.asux.pageobjects.BrokerOnboardingPage;
import com.asux.pageobjects.ItsmePage;

public class Main extends base {

    public static void main(String[] args) {
        System.out.println("Starting Test...");
        try {
            openBrowser(url);
            Thread.sleep(5000); 
            BrokerOnboardingPage onboardingPage = new BrokerOnboardingPage();
            onboardingPage.isLogoClickable();
            System.out.println(onboardingPage.isLogoClickable());
            // ItsmePage itsme = new ItsmePage();

        
            // onboardingPage.navigateToItsmePage();
        
            // // Validate redirection before proceeding
            // if (!getDriver().getCurrentUrl().contains("https://idp.e2e.itsme.services")) {
            //     System.out.println("Navigation failed, stopping Execution.");
            //     getDriver().close();
            //     return;
            // }
        
            // itsme.enterPhoneAndSubmit(BrokerPhone);
            // ImplicitwaitHelper.setImplicitWait(15);

            // Thread.sleep(15000);
            
            // onboardingPage.BrokerOnboardingdetailsPage(Email, KBO, date, Docfilepath);
            System.out.println("Well Executed");
            closeBrowser();
        
        } catch (Exception e) {
            System.out.println("Execution failed: " + e.getMessage());
        }
    }
}
