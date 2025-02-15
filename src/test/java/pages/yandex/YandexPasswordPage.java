package pages.yandex;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

import org.openqa.selenium.By;

public class YandexPasswordPage {

  public static final String PASSWORD_INPUT_ID = "passp-field-passwd";
  public static final String PASSWORD_SUBMIT_BUTTON_ID = "passp:sign-in";

  /**
   * Ввод пароля.
   */
  public YandexPasswordPage setPassword(String password) {
    $(By.id(PASSWORD_INPUT_ID)).shouldBe(visible).setValue(password);
    return this;
  }

  /**
   * Нажимаем кнопку "Продолжить".
   */
  public Yandex2FAPage clickPasswordSubmit() {
    $(By.id(PASSWORD_SUBMIT_BUTTON_ID)).shouldBe(visible).click();
    return new Yandex2FAPage();
  }
}
