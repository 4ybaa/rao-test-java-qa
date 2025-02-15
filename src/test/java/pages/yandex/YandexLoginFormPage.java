package pages.yandex;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

import org.openqa.selenium.By;

public class YandexLoginFormPage {

  private final String loginInputCss = "input[name='login']";
  private final String loginSubmitButtonCss = "passp:sign-in";

  /**
   * Ввод логина (почты).
   */
  public YandexLoginFormPage setLogin(String login) {
    $(loginInputCss).shouldBe(visible).setValue(login);
    return this;
  }

  /**
   * Нажимает кнопку "Войти".
   */
  public YandexPasswordPage clickLoginSubmit() {
    $(By.id(loginSubmitButtonCss)).shouldBe(visible).click();
    return new YandexPasswordPage();
  }
}
