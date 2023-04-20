package web.steps;

import com.codeborne.selenide.Selenide;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Пусть;
import io.cucumber.java.ru.Тогда;
import org.junit.jupiter.api.Assertions;
import web.data.DataHelper;
import web.page.DashboardPage;
import web.page.LoginPage;
import web.page.TopUpPage;
import web.page.VerificationPage;

public class TemplateSteps {
    private static LoginPage loginPage;
    private static DashboardPage dashboardPage;
    private static VerificationPage verificationPage;
    private static TopUpPage topUpPage;

    @Пусть("открыта страница с формой авторизации {string}")
    public void openAuthPage(String url) {
        loginPage = Selenide.open(url, LoginPage.class);
    }

    @Когда("пользователь пытается авторизоваться с именем {string} и паролем {string}")
    public void loginWithNameAndPassword(String login, String password) {
        verificationPage = loginPage.validLogin(login, password);
    }

    @Когда("пользователь вводит проверочный код 'из смс' {string}")
    public void setValidCode(String verificationCode) {
        dashboardPage = verificationPage.validVerify(verificationCode);

    }

    @Когда("пользователь выбирает первую карту для пополнения")
    public void clickTopUpCard() {
        topUpPage = dashboardPage.topUpCard1();
    }

    @Когда("пользователь указывает {string} рублей и счет списания")
    public void clickTopUpCard(String sum) {
        int amount = Integer.parseInt(sum.trim());
        topUpPage.topUpCard(String.valueOf(amount), DataHelper.getCardNumber().getCard2());
        dashboardPage.updateButton();

    }

    @Тогда("баланс его первой карты из списка на главной странице должен стать {string} рублей")
    public void verifyDashboardPage(String sum) {
        int balance = Integer.parseInt(sum.trim());
        Assertions.assertEquals(dashboardPage.getCard1Balance(), balance);
    }
}
