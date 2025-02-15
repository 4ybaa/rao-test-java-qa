package pages.dzen;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class DzenMainPage {

  private static final String SIGN_IN_BUTTON_CSS_SELECTOR = "[data-testid='login-button']";

  /**
   * Открывает главную страницу Яндекса.
   */
  public DzenMainPage openPage() {
    open("https://yandex.ru/");
    return this;
  }

  /**
   * Клик по кнопке "Войти" для перехода на страницу авторизации.
   */
  public DzenLoginPage clickSignIn() {
    $(SIGN_IN_BUTTON_CSS_SELECTOR).shouldBe(visible).click();
    return new DzenLoginPage();
  }

  /**
   * Проверяет, что главная страница Яндекса загрузилась.
   */
  public DzenMainPage checkPageIsLoaded() {
    $(SIGN_IN_BUTTON_CSS_SELECTOR).shouldBe(visible);
    return this;
  }
}
