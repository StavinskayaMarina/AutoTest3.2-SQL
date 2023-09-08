package page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

public class VerificationPage {
    private final SelenideElement codeField = Selenide.$("[data-test-id=code] input");
    private final SelenideElement verifyButton = Selenide.$("[data-test-id=action-verify]");
    private final SelenideElement errorNotification = Selenide.$("[data-test-id= error-notification]");

    public void validVerifyNotificationVisible() {
        codeField.shouldBe(Condition.visible);
    }

    public void verifyErrorNotificationVisible() {
        errorNotification.shouldBe(Condition.visible);
    }

    public DashboardPage validVerify(String verificationCode) {
        verify(verificationCode);
        return new DashboardPage();
    }

    public void errorVerify(String verificationCode) {
        codeField.shouldBe(Condition.visible);
        codeField.setValue(verificationCode);
        verifyButton.click();
    }

    public void verify(String verificationCode) {
        codeField.setValue(verificationCode);
        verifyButton.click();
    }
}
