package tests.yandex;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.dzen.DzenLoginPage;
import pages.dzen.DzenMainPage;
import pages.yandex.Yandex2FAPage;
import pages.yandex.YandexPasswordPage;
import utils.YamlConfigReader;


public class YandexLoginTests {

  private final String VALID_LOGIN = YamlConfigReader.getYandexLogin();
  private final String VALID_PASSWORD = YamlConfigReader.getYandexPassword();

  @Test
  @DisplayName("Проверка ввода логина и пароля пользователя."
      + " Доходим до шага с вводом кода из двухфакторной авторизации")
  void fullYandexIDLoginTest() {
    DzenMainPage mainPage = new DzenMainPage().openPage().checkPageIsLoaded();
    DzenLoginPage loginPage = mainPage.clickSignIn();

    var loginFormPage = loginPage.selectYandexIDLogin();

    loginFormPage.setLogin(VALID_LOGIN);

    YandexPasswordPage yandexPasswordPage = loginFormPage.clickLoginSubmit();

    yandexPasswordPage.setPassword(VALID_PASSWORD);

    Yandex2FAPage yandex2FAPage = yandexPasswordPage.clickPasswordSubmit();

    assertThat(yandex2FAPage.isYandex2FAPageIsLoaded()).as("Проверка, что страница загрузилась")
        .isTrue();

  }
}

