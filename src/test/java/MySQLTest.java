import data.DataHelper;
import data.SQLHelper;
import page.LoginPage;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

public class MySQLTest {

    @AfterAll
    static void clearBase() {
        SQLHelper.cleanDB();
    }

    @Test
    void successfulLogin() {
        var loginPage = open("http://localhost:9999", LoginPage.class);
        var RegUser = DataHelper.getRegisteredUser();
        var verificationPage = loginPage.validLogin(RegUser);
        verificationPage.validVerifyNotificationVisible();
        var verificationCode = SQLHelper.getVerificationCode();
        verificationPage.validVerify(verificationCode.getCode());
    }

    @Test
    void randomUserLogin() {
        var loginPage = open("http://localhost:9999", LoginPage.class);
        var RegUser = DataHelper.generateRandomUser();
        loginPage.validLogin(RegUser);
        loginPage.verifyErrorNotificationVisible();
    }

    @Test
    void invalidVerificationCode() {
        var loginPage = open("http://localhost:9999", LoginPage.class);
        var RegUser = DataHelper.getRegisteredUser();
        var verificationPage = loginPage.validLogin(RegUser);
        verificationPage.validVerifyNotificationVisible();
        var verificationCode = DataHelper.generateRandomVerificationCode();
        verificationPage.errorVerify(verificationCode.getCode());
        verificationPage.verifyErrorNotificationVisible();
    }


}