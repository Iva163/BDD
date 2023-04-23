package web.steps;

import com.codeborne.selenide.Selenide;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Пусть;
import io.cucumber.java.ru.Тогда;
import org.junit.jupiter.api.Assertions;
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

    @Когда("пользователь выбирает {int} карту для пополнения")
    public void clickTopUpCard(int id) {
        topUpPage = dashboardPage.topUpCard(id);
    }

    @Когда("пользователь указывает {int} рублей и счет списания {string}")
    public void clickTopUpCard(int sum, String numberCard) {
        topUpPage.topUpCard(String.valueOf(sum), numberCard);
        dashboardPage.updateButton();

    }

    @Тогда("баланс его {int} карты из списка на главной странице должен стать {int} рублей")
    public void verifyDashboardPage(int id, int sum) {
        Assertions.assertEquals(dashboardPage.getCardBalance(id), sum);
    }
}
