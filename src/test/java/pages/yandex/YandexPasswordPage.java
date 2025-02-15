package pages.yandex;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

import org.openqa.selenium.By;

public class YandexPasswordPage {

  private final String passwordInputCss = "passp-field-passwd";
  private final String passwordSubmitButtonCss = "passp:sign-in";

  /**
   * Ввод пароля.
   */
  public YandexPasswordPage setPassword(String password) {
    $(By.id(passwordInputCss)).shouldBe(visible).setValue(password);
    return this;
  }

  /**
   * Нажимаем кнопку "Продолжить".
   */
  public Yandex2FAPage clickPasswordSubmit() {
    $(By.id(passwordSubmitButtonCss)).shouldBe(visible).click();
    return new Yandex2FAPage();
  }
}
