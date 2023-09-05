package page;

import com.codeborne.selenide.SelenideElement;
import data.DataHelper;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    private final SelenideElement loginField = $("[data-test-id=login] input");
    private final SelenideElement passwordField = $("[data-test-id=password] input");
    private final SelenideElement loginButton = $("[data-test-id=action-login]");
    private final SelenideElement errorNotification = $("[data-test-id= error-notification]");
    public VerificationPage validLogin(DataHelper.RegUser user){
        loginField.setValue(user.getLogin());
        passwordField.setValue(user.getPassword());
        loginButton.click();
        return new VerificationPage();
    }
    public void verifyErrorNotificationVisible(){
        errorNotification.shouldBe(visible);
        errorNotification.$$(" .notification_content").findBy(exactText("Ошибка! Неверно указан логин или пароль"));
    }
}
