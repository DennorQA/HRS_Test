package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.TestUtils;

public class LoginPage extends BasePage{

   @FindBy(xpath = "//input[@id='loginEmail']")
   private WebElement userInput;

    @FindBy (xpath = "//input[@id='password']")
    private WebElement passwordInput;

    @FindBy (xpath = "//button[@id='loginSubmitButton']")
    private WebElement loginButton;

    @FindBy (xpath = "???")
    private WebElement successText;

    @FindBy (xpath = "//span/i")
    private WebElement eyeButton;

    @FindBy (xpath = "//div[@ng-show='$messageTemplate']/span")
    private WebElement errorMessage;

    @FindBy (xpath = "//a[@title='Click here to reset your password']")
    private WebElement forgotPasswordButton;

    @FindBy (xpath = "//input[@id='resetPassword_username']")
    private WebElement resetPasswordInput;

    @FindBy (xpath = "//button[@id='resetPasswordSaveButton']")
    private WebElement resetSubmitButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage Login(String username, String password){
        TestUtils.inputKeys(getWait(), userInput, username);
        TestUtils.inputKeys(getWait(), passwordInput, password);
        TestUtils.click(getWait(), loginButton);

        return this;
    }

    public String afterLoginText() {
        TestUtils.elementVisibility(getWait(), successText);

        return successText.getText();
    }

    public String getErrorText(){
        TestUtils.elementVisibility(getWait(), errorMessage);

        return errorMessage.getText();
    }

    public LoginPage showPassword(String password){
        TestUtils.inputKeys(getWait(), passwordInput, password);
        TestUtils.click(getWait(), eyeButton);

        return this;
    }

    public String getAttr(){
        TestUtils.elementVisibility(getWait(), passwordInput);

        return passwordInput.getAttribute("type");
    }

    public Boolean blankedFields(){

        return TestUtils.elementIsClickable(getWait(), loginButton);
    }

    public LoginPage forgotPassword(String username){
        TestUtils.click(getWait(), forgotPasswordButton);
        TestUtils.inputKeys(getWait(), resetPasswordInput, username);
        TestUtils.click(getWait(), resetSubmitButton);

        return this;
    }

    public LoginPage blankForgotPassword(){
        TestUtils.click(getWait(), forgotPasswordButton);
        TestUtils.click(getWait(), resetSubmitButton);

        return this;
    }

}
