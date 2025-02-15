package pages.dzen;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;

public class DzenMainPage {

  static final String SIGN_IN_BUTTON_CSS = "button.dzen-layout--login-button__textButton-1t";


  /**
   * Открывает главную страницу Яндекса.
   */
  public DzenMainPage openPage() {
    open("https://yandex.ru/");
    sleep(2000);
    return this;
  }

  /**
   * Клик по кнопке "Войти" для перехода на страницу авторизации.
   */
  public DzenLoginPage clickSignIn() {
    $(SIGN_IN_BUTTON_CSS).shouldBe(visible).click();
    return new DzenLoginPage();
  }

  /**
   * Проверяет, что главная страница Яндекса загрузилась.
   */
  public DzenMainPage checkPageIsLoaded() {
    $(SIGN_IN_BUTTON_CSS).shouldBe(visible);
    return this;
  }
}
