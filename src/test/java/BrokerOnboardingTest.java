import com.asux.config.base;
import com.asux.pageobjects.BrokerOnboardingPage;
import com.asux.utilities.ApachePOIExcelReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;

public class BrokerOnboardingTest extends base {

    private BrokerOnboardingPage onboardingPage;

    @BeforeMethod
    public void setup() {
        try {
            openBrowser(url);
            //navigateToItsmePage();
            onboardingPage = new BrokerOnboardingPage();
        } catch (Exception e) {
            System.out.println("Setup failed: " + e.getMessage());
            Assert.fail("Setup failed due to an exception.");
        }
    }
    @Test
    public void testLogoIsDisplayed() {
        Assert.assertTrue(onboardingPage.isLogoDisplayed(), "Logo is not displayed on Broker Onboarding Page.");
    }

    @Test
    public void testLogoIsNotClickable() {
        Assert.assertFalse(onboardingPage.isLogoClickable(), "Logo should not be clickable.");
    }

    @Test(priority = 1)
    public void verifyWelcomeTextForEnglish() throws InterruptedException {
        onboardingPage.BrokerWelcomePage("English");
        String actualText = onboardingPage.BrokerWelcometext();
        String expectedText = "Welcome to ASU, We are excited to welcome you here and provide access to a world of possibilities. This portal is designed to optimise your experience and provide you with the necessary tools to further your clientele better insurance. We will guide you to our portal in 3 steps. Have your KBO & FSMA number at hand and make sure you have your BA available in electronic format so you can upload it immediately. Please click on the itsme button.";
        Assert.assertEquals(actualText, expectedText, "Welcome text for English does not match");
    }

    @Test(priority = 2)
    public void verifyWelcomeTextForFrancais() throws InterruptedException {
        onboardingPage.BrokerWelcomePage("Francais");
        String actualText = onboardingPage.BrokerWelcometext();
        String expectedText = "Bienvenue à l'ASU, Nous sommes ravis de vous accueillir ici et de vous donner accès à un monde de possibilités. Ce portail est conçu pour optimiser votre expérience et vous fournir les outils nécessaires pour assurer à votre clientèle une meilleure assurance. Nous vous guiderons vers notre portail en 3 étapes. Ayez votre numéro KBO & FSMA à portée de main et assurez-vous d'avoir votre BA disponible au format électronique afin de pouvoir le télécharger immédiatement. Veuillez cliquer sur le bouton itsme.";
        Assert.assertEquals(actualText, expectedText, "Welcome text for Français does not match");
    }

    @Test(priority = 3)
    public void verifyWelcomeTextForDeutsch() throws InterruptedException{
        onboardingPage.BrokerWelcomePage("Deutsch");
        String actualText = onboardingPage.BrokerWelcometext();
        String expectedText = "Willkommen bei ASU, Wir freuen uns, Sie hier begrüßen zu dürfen und Ihnen den Zugang zu einer Welt voller Möglichkeiten zu ermöglichen. Dieses Portal soll Ihr Erlebnis optimieren und Ihnen die notwendigen Tools zur Verfügung stellen, um Ihren Kunden eine bessere Versicherung zu ermöglichen. Wir führen Sie in 3 Schritten zu unserem Portal. Halten Sie Ihre KBO- und FSMA-Nummer bereit und stellen Sie sicher, dass Sie Ihren BA in elektronischer Form zur Verfügung haben, damit Sie ihn sofort hochladen können. Bitte klicken Sie auf die Schaltfläche „itsme“.";
        Assert.assertEquals(actualText, expectedText, "Welcome text for Deutsch does not match");
    }

    @Test(priority = 4)
    public void verifyWelcomeTextForNederlands() throws InterruptedException {
        onboardingPage.BrokerWelcomePage("Nederlands");
        String actualText = onboardingPage.BrokerWelcometext();
        String expectedText = "Welkom bij ASU, We zijn blij u hier te mogen verwelkomen en toegang te bieden tot een wereld aan mogelijkheden. Dit portaal is ontworpen om uw ervaring te optimaliseren en u de nodige hulpmiddelen te bieden om uw klantenkring beter te verzekeren. In 3 stappen begeleiden wij u naar ons portaal. Houd uw KBO- & FSMA-nummer bij de hand en zorg ervoor dat u uw BA in elektronisch formaat beschikbaar heeft, zodat u deze onmiddellijk kunt uploaden. Klik dan op de itsme-knop.";
        Assert.assertEquals(actualText, expectedText, "Welcome text for Nederlands does not match");
    }

    @Test(priority = 5)
    public void verifyButtonTextForEnglish() throws InterruptedException {
        onboardingPage.BrokerWelcomePage("English");
        String actualText = onboardingPage.ButtonText();
        String expectedText = "Continue with itsme  ";
        Assert.assertEquals(actualText, expectedText, "Button text for English does not match");
    }

    @Test(priority = 6)
    public void verifyButtonTextForFrancais() throws InterruptedException {
        onboardingPage.BrokerWelcomePage("Francais");
        String actualText = onboardingPage.ButtonText();
        String expectedText = "Continuer avec itsme  ";
        Assert.assertEquals(actualText, expectedText, "Button text for Francais does not match");
    }

    @Test(priority = 7)
    public void verifyButtonTextForDeutsch() throws InterruptedException {
        onboardingPage.BrokerWelcomePage("Deutsch");
        String actualText = onboardingPage.ButtonText();
        String expectedText = "Fahren Sie mit itsme fort  ";
        Assert.assertEquals(actualText, expectedText, "Button text for Deutsch does not match");
    }

    @Test(priority = 8)
    public void verifyButtonTextForNederlands() throws InterruptedException {
        onboardingPage.BrokerWelcomePage("Nederlands");
        String actualText = onboardingPage.ButtonText();
        String expectedText = "Ga verder met itsme  ";
        Assert.assertEquals(actualText, expectedText, "Button text for Deutsch does not match");
    }

     @Test
    public void testwelcomeitsmeIsDisplayed() {
        Assert.assertTrue(onboardingPage.isWelcometoItsmeDisplayed(), "Welcome to Itsme Button is not displayed on Broker Onboarding Page.");
    }

    @Test
    public void testwelcomeitsmeIsClickable() {
        Assert.assertTrue(onboardingPage.isWelcometoItsmeClickable(), "Welcome to Itsme Button should be clickable.");
    }

    // @Test(priority = 1)
    // public void testSubmitWithoutEmail() {
    //     try {
    //         onboardingPage.BrokerOnboardingdetailsPage("", "123456", "2025-01-01", "C:\\path\\to\\file.pdf");
    //         WebElement emailError = getDriver().findElement(By.xpath("//span[contains(text(),'Email is required')]"));
    //         Assert.assertTrue(emailError.isDisplayed(), "Email validation error not displayed");
    //     } catch (Exception e) {
    //         System.out.println("Exception in testSubmitWithoutEmail: " + e.getMessage());
    //         Assert.fail("Exception occurred in testSubmitWithoutEmail.");
    //     }
    // }

    // @Test(priority = 2)
    // public void testSubmitWithoutKBO() {
    //     try {
    //         onboardingPage.BrokerOnboardingdetailsPage("test@example.com", "", "2025-01-01", "C:\\path\\to\\file.pdf");
    //         WebElement kboError = getDriver().findElement(By.xpath("//span[contains(text(),'KBO is required')]"));
    //         Assert.assertTrue(kboError.isDisplayed(), "KBO validation error not displayed");
    //     } catch (Exception e) {
    //         System.out.println("Exception in testSubmitWithoutKBO: " + e.getMessage());
    //         Assert.fail("Exception occurred in testSubmitWithoutKBO.");
    //     }
    // }

    // @Test(priority = 3)
    // public void testSubmitWithoutDate() {
    //     try {
    //         onboardingPage.BrokerOnboardingdetailsPage("test@example.com", "123456", "", "C:\\path\\to\\file.pdf");
    //         WebElement dateError = getDriver().findElement(By.xpath("//span[contains(text(),'Date is required')]"));
    //         Assert.assertTrue(dateError.isDisplayed(), "Date validation error not displayed");
    //     } catch (Exception e) {
    //         System.out.println("Exception in testSubmitWithoutDate: " + e.getMessage());
    //         Assert.fail("Exception occurred in testSubmitWithoutDate.");
    //     }
    // }

    // @Test(priority = 4)
    // public void testSubmitWithoutDocument() {
    //     try {
    //         onboardingPage.BrokerOnboardingdetailsPage("test@example.com", "123456", "2025-01-01", "");
    //         WebElement docError = getDriver().findElement(By.xpath("//span[contains(text(),'Document is required')]"));
    //         Assert.assertTrue(docError.isDisplayed(), "Document validation error not displayed");
    //     } catch (Exception e) {
    //         System.out.println("Exception in testSubmitWithoutDocument: " + e.getMessage());
    //         Assert.fail("Exception occurred in testSubmitWithoutDocument.");
    //     }
    // }

    // @Test(priority = 5)
    // public void testSubmitWithAllDetails() {
    //     try {
    //         onboardingPage.BrokerOnboardingdetailsPage("test@example.com", "123456", "2025-01-01", "C:\\path\\to\\file.pdf");
    //         WebElement successMessage = getDriver().findElement(By.xpath("//span[contains(text(),'Form submitted successfully')]"));
    //         Assert.assertTrue(successMessage.isDisplayed(), "Form submission failed");
    //     } catch (Exception e) {
    //         System.out.println("Exception in testSubmitWithAllDetails: " + e.getMessage());
    //         Assert.fail("Exception occurred in testSubmitWithAllDetails.");
    //     }
    // }

    @AfterMethod
    public void tearDown() {
        try {
            closeBrowser();
            System.out.println("Browser closed successfully.");
        } catch (Exception e) {
            System.out.println("Exception during teardown: " + e.getMessage());
        }
    }
}
