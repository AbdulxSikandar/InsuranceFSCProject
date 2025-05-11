package com.asux.pageobjects;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.asux.actiondriver.ActionHelper;
import com.asux.actiondriver.ExplicitWaitHelper;
import com.asux.config.base;
import java.util.List;


public class BrokerOnboardingPage extends base {

    private WebDriver driver;
    private ActionHelper ac;
    private ExplicitWaitHelper waitHelper;  

    // WebElement Nextbutton = driver.findElement(By.xpath("//button[contains(@class, 'next-button')]"));

    @FindBy(xpath = "//div[@class='comnylogo-container']//img[@class='comnylogo']")
    WebElement ASUlogo;

    @FindBy(xpath = "//button[contains(@class, 'next-button')]")
    WebElement Nextbutton;

    @FindBy(xpath ="(//input[@class='slds-input'])[7]" )
    WebElement BrokerEmail;

    @FindBy(xpath ="(//input[@class='slds-input'])[8]" )
    WebElement BrokerCompanyKBO;

    @FindBy(xpath ="(//input[@class='slds-input'])[10]" )
    WebElement BrokerDateofJoining;

    @FindBy(xpath ="//input[@type='file']" )
    WebElement LiabilityInsuranceDocument;

    @FindBy(xpath="/html/body/div[3]/div[2]/div/div[1]/div/div/c-cyn_-broker-portal-onboarding-form/div/div/div/div[2]/div[4]/lightning-input/lightning-primitive-input-checkbox/div[1]/span/label/span[1]")
    WebElement Checkbox1;

    @FindBy(xpath="/html/body/div[3]/div[2]/div/div[1]/div/div/c-cyn_-broker-portal-onboarding-form/div/div/div/div[2]/div[4]/div/lightning-input/lightning-primitive-input-checkbox/div[1]/span/label/span[1]")
    WebElement Checkbox2;

    @FindBy(xpath = "//button[@class='slds-button slds-button_neutral validate-button']")
    WebElement Submitbutton;

     // Method to check if the logo is displayed
    public boolean isLogoDisplayed() {
        waitHelper.waitForElementToBeVisible(ASUlogo);
        return ASUlogo.isDisplayed();
    }

    // Method to check if the logo is Clickable
    public boolean isLogoClickable() {
        waitHelper.waitForElementToBeVisible(ASUlogo);
        try {
            ac.click(ASUlogo);
            System.out.println("Logo is clickable");
            return true; // If no exception, it's clickable
        } catch (Exception e) {
            System.out.println("Logo is not clickable");
            return false;
             // If exception occurs, it's not clickable
        }
    }

    // Constructor to use the shared driver
    public BrokerOnboardingPage() {
        this.driver = base.getDriver();
        this.ac = new ActionHelper(this.driver);
        this.waitHelper = new ExplicitWaitHelper(this.driver, 10); // 10 seconds timeout
        PageFactory.initElements(driver, this);
    }

    public void BrokerWelcomePage(String language){
        WebElement Dropdown = driver.findElement(By.xpath("//span[text()='English']"));
        Dropdown.click();
        switch(language){
            case "English":
            WebElement Englishlanguage = driver.findElement(By.xpath("//div[@data-lang='English']"));
                waitHelper.waitForElementToBeVisible(Englishlanguage);
                waitHelper.waitForElementToBeClickable(Englishlanguage);
                Englishlanguage.click();
                
                break;
            case "Francais":
                WebElement Francaislanguage = driver.findElement(By.xpath("//div[@data-lang='French']"));
                waitHelper.waitForElementToBeVisible(Francaislanguage);
                waitHelper.waitForElementToBeClickable(Francaislanguage);
                Francaislanguage.click();
                break;
            case "Deutsch" :
                WebElement Deutschlanguage = driver.findElement(By.xpath("//div[@data-lang='German']"));
                waitHelper.waitForElementToBeVisible(Deutschlanguage);
                waitHelper.waitForElementToBeClickable(Deutschlanguage);
                Deutschlanguage.click();
                break;
            case "Nederlands":
                WebElement Nederlandslanguage = driver.findElement(By.xpath("//div[@data-lang='Dutch']"));
                waitHelper.waitForElementToBeVisible(Nederlandslanguage);
                waitHelper.waitForElementToBeClickable(Nederlandslanguage);
                Nederlandslanguage.click();
                break;
            default:
                throw new IllegalArgumentException("Unsupported language: " + language);
        }
        
    }

        
    public String BrokerWelcometext() throws InterruptedException{
        try {
            // Use a more flexible XPath to locate the div
            WebElement ParagraphDiv = driver.findElement(By.xpath("//c-cyn_-broker-onboarding-form-landing-page//lightning-card//slot//div/div[2]"));
    
            // Wait for the ParagraphDiv to be visible
            waitHelper.waitForElementToBeVisible(ParagraphDiv);
            Thread.sleep(3000);
    
            // Get all the <p> tags inside the div
            List<WebElement> paragraphs = ParagraphDiv.findElements(By.tagName("p"));
    
            // Handle empty paragraph case
            if (paragraphs.isEmpty()) {
                System.err.println("No paragraphs found in the Broker Welcome text.");
                return "";
            }
    
            // Extract and concatenate the text from all <p> tags
            StringBuilder extractedText = new StringBuilder();
            for (WebElement paragraph : paragraphs) {
                extractedText.append(paragraph.getText().trim()).append(" ");
            }
    
            return extractedText.toString().trim();
    
        } catch (Exception e) {
            System.err.println("Error extracting Broker Welcome text: " + e.getMessage());
            return "";
        }
    }


    public String ButtonText() throws InterruptedException{
        Thread.sleep(3000);
        String TextonButton = Nextbutton.getText();
        return TextonButton;
    }

    
    public ItsmePage navigateToItsmePage() {
        waitHelper.waitForElementToBeVisible(Nextbutton);
        waitHelper.waitForElementToBeClickable(Nextbutton);
    
        if (Nextbutton.isDisplayed() && Nextbutton.isEnabled()) {
            ac.click(Nextbutton);
        } else {
            System.out.println("Element not ready for click.");
        }
    
        return new ItsmePage();
    }
    // Broker Onboarding Details Fill Form
    public void BrokerOnboardingdetailsPage(String EMail, String KBO, String Date, String Path) throws InterruptedException {
        
        // Wait & Enter Email
        Thread.sleep(20000);
        waitHelper.waitForElementToBeVisible(BrokerEmail);
        ac.sendKeys(BrokerEmail, EMail);

        // Wait & Enter KBO
        waitHelper.waitForElementToBeVisible(BrokerCompanyKBO);
        ac.sendKeys(BrokerCompanyKBO, KBO);

        // Wait & Enter Date of Joining
        JavascriptExecutor js = (JavascriptExecutor) driver;
        waitHelper.waitForElementToBeClickable(BrokerDateofJoining);
        js.executeScript("arguments[0].click();", BrokerDateofJoining);
        ac.sendKeys(BrokerDateofJoining, Date);

        // Wait & Upload File
        waitHelper.waitForElementToBeVisible(LiabilityInsuranceDocument);
        ac.sendKeys(LiabilityInsuranceDocument, Path);

        // Wait & Check Checkbox 1
        waitHelper.waitForElementToBeClickable(Checkbox1);
        ac.scrollToElement(Checkbox1);
        ac.click(Checkbox1);

        // Wait & Check Checkbox 2
        waitHelper.waitForElementToBeClickable(Checkbox2);
        ac.scrollToElement(Checkbox2);
        ac.click(Checkbox2);

        // Wait & Click Submit Button
        waitHelper.waitForElementToBeClickable(Submitbutton);
        ac.click(Submitbutton);
    }
}
