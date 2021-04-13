package test;

import Pages.LoginPage;
import Runner.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;


public class LoginTest extends BaseTest {

        private final static String VALID_USERNAME = "ValidUsername";
        private final static String VALID_PASS = "ValidPassword";
        private final static String ERROR_MESSAGE = "Username and/or password invalid";

        //Ignored this test, because I don't have any valid test credentials for successful login
        @Ignore
        @Test(description = "VALID login and password")
        public void loginTest1(){
                LoginPage loginPage = new LoginPage(getDriver())
                     .Login(VALID_USERNAME, VALID_PASS);

                Assert.assertEquals(loginPage.afterLoginText(), VALID_USERNAME,
                        "Login was not successful");
        }

        @Test(description = "VALID login and INVALID password")
        public void loginTest2(){
                LoginPage loginPage = new LoginPage(getDriver())
                        .Login(VALID_USERNAME, "InvalidPassword");

                Assert.assertEquals(loginPage.getErrorText(), ERROR_MESSAGE,
                        "Error Message was not shown");
        }

        @Test(description = "INVALID login and VALID password")
        public void loginTest3(){
                LoginPage loginPage = new LoginPage(getDriver())
                        .Login("InvalidUsername", VALID_PASS);

                Assert.assertEquals(loginPage.getErrorText(), ERROR_MESSAGE,
                        "Error Message was not shown");
        }

        @Test(description = "password is shown")
        public void loginTest5(){
                LoginPage loginPage = new LoginPage(getDriver())
                        .showPassword(VALID_PASS);

                Assert.assertEquals(loginPage.getAttr(), "text",
                        "Password was not shown");
        }

        @Test(description = "login with blanked username and password fields")
        public void loginTest7(){
                LoginPage loginPage = new LoginPage(getDriver());

                Assert.assertFalse(loginPage.blankedFields());
        }

        @Test(description = "forgot password with ValidUsername")
        public void loginTest8(){
                LoginPage loginPage = new LoginPage(getDriver())
                        .forgotPassword(VALID_USERNAME);

                Assert.assertEquals(loginPage.getErrorText(),
                        "Reset password request successfully submitted.",
                        "Success message expected, but it is not displayed");
        }

        @Test(description = "forgot password with ValidUsername")
        public void loginTest9(){
                LoginPage loginPage = new LoginPage(getDriver())
                        .blankForgotPassword();

                Assert.assertEquals(loginPage.getErrorText(),
                        "Failed to submit reset password request.",
                        "Error message expected, but it is not displayed");
        }
}
