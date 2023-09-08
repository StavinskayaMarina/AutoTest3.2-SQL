package page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import data.DataHelper;

public class LoginPage {

    private final SelenideElement loginField = Selenide.$("[data-test-id=login] input");
    private final SelenideElement passwordField = Selenide.$("[data-test-id=password] input");
    private final SelenideElement loginButton = Selenide.$("[data-test-id=action-login]");
    private final SelenideElement errorNotification = Selenide.$("[data-test-id= error-notification]");

    public VerificationPage validLogin(DataHelper.RegUser user) {
        loginField.setValue(user.getLogin());
        passwordField.setValue(user.getPassword());
        loginButton.click();
        return new VerificationPage();
    }

    public void verifyErrorNotificationVisible() {
        errorNotification.shouldBe(Condition.visible);
        errorNotification.$$(" .notification_content").findBy(Condition.exactText("Ошибка! Неверно указан логин или пароль"));
    }
}
