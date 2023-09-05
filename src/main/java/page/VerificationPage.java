package page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class VerificationPage {
    private final SelenideElement codeField = $("[data-test-id=code] input");
    private final SelenideElement verifyButton = $("[data-test-id=action-verify]");
    private final SelenideElement errorNotification = $("[data-test-id= error-notification]");

    public void validVerifyNotificationVisible() {
        codeField.shouldBe(visible);
    }

    public void verifyErrorNotificationVisible() {
        errorNotification.shouldBe(visible);
    }

    public DashboardPage validVerify(String verificationCode){
        verify(verificationCode);
        return new DashboardPage();
    }

    public void errorVerify(String verificationCode){
        codeField.shouldBe(visible);
        codeField.setValue(verificationCode);
        verifyButton.click();
    }
    public void verify(String verificationCode){
        codeField.setValue(verificationCode);
        verifyButton.click();
    }
}
