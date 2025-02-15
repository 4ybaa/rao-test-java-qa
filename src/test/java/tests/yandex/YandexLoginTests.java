package tests.yandex;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.dzen.DzenLoginPage;
import pages.dzen.DzenMainPage;
import pages.yandex.Yandex2FAPage;
import pages.yandex.YandexLoginFormPage;
import pages.yandex.YandexPasswordPage;
import utils.YamlConfigReader;

@Epic("Авторизация на странице яндекса")
@Feature("Логин через Яндекс ID")
@Story("Полный флоу авторизации до 2FA")
public class YandexLoginTests {

  private final String VALID_LOGIN = YamlConfigReader.getYandexLogin();
  private final String VALID_PASSWORD = YamlConfigReader.getYandexPassword();

  @Test
  @DisplayName("Проверка ввода логина и пароля пользователя. Доходим до шага с вводом кода из двухфакторной авторизации")
  @Severity(SeverityLevel.CRITICAL)
  @Description("Проверяем успешный ввод логина, пароля и загрузку страницы 2FA")
  void whenUserEntersRightCredentialsShouldLoad2FPage() {
    // Открываем главную страницу
    DzenMainPage mainPage = Allure.step("Открываем главную страницу Дзен", () ->
        new DzenMainPage().openPage().checkPageIsLoaded()
    );

    // Переходим на страницу логина
    DzenLoginPage loginPage = Allure.step("Нажимаем 'Войти' и переходим на страницу логина",
        mainPage::clickSignIn
    );

    // Выбираем вход через Яндекс ID
    YandexLoginFormPage loginFormPage = Allure.step("Выбираем авторизацию через Яндекс ID",
        loginPage::selectYandexIDLogin
    );

    // Ввод логина
    Allure.step("Вводим логин", () ->
        loginFormPage.setLogin(VALID_LOGIN)
    );

    // Подтверждение логина и переход на ввод пароля
    YandexPasswordPage yandexPasswordPage = Allure.step(
        "Подтверждаем логин и переходим на страницу ввода пароля", loginFormPage::clickLoginSubmit
    );

    // Ввод пароля
    Allure.step("Вводим пароль", () ->
        yandexPasswordPage.setPassword(VALID_PASSWORD)
    );

    // Подтверждаем пароль и переходим на 2FA
    Yandex2FAPage yandex2FAPage = Allure.step(
        "Подтверждаем пароль и переходим на страницу двухфакторной аутентификации",
        yandexPasswordPage::clickPasswordSubmit
    );

    // Проверяем, что 2FA загрузилась
    Allure.step("проверяем, что она 2FA загрузилась", () -> {
      assertThat(yandex2FAPage.isYandex2FAPageIsLoaded())
          .as("Проверяем, что страница 2FA загрузилась")
          .isTrue();
    });
  }
}
