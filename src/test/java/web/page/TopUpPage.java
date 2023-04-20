package web.page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class TopUpPage {
    private SelenideElement amountInput = $("[data-test-id=amount] input");
    private SelenideElement numberCardFromInput = $("[data-test-id=from] input");
    private SelenideElement topUpButton = $("[data-test-id=action-transfer]");
    private SelenideElement cancelButton = $("[data-test-id=action-cancel]");

    private SelenideElement errorNotification = $("[data-test-id=error-notification]");

    public TopUpPage() {
        amountInput.shouldBe(visible);
    }


    public DashboardPage topUpCard(String amount, String cardFrom) {
        amountInput.setValue(amount);
        numberCardFromInput.setValue(cardFrom);
        topUpButton.click();
        return new DashboardPage();
    }


}
