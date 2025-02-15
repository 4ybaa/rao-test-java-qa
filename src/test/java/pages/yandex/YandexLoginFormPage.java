package pages.yandex;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

import org.openqa.selenium.By;

public class YandexLoginFormPage {

  public static String LOGIN_INPUT_ID = "passp-field-login";
  public static String LOGIN_SUBMIT_BUTTON_ID = "passp:sign-in";

  /**
   * Ввод логина (почты).
   */
  public YandexLoginFormPage setLogin(String login) {
    $(By.id(LOGIN_INPUT_ID)).shouldBe(visible).setValue(login);
    return this;
  }

  /**
   * Нажимает кнопку "Войти".
   */
  public YandexPasswordPage clickLoginSubmit() {
    $(By.id(LOGIN_SUBMIT_BUTTON_ID)).shouldBe(visible).click();
    return new YandexPasswordPage();
  }
}
