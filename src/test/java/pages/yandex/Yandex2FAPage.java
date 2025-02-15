package pages.yandex;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

import org.openqa.selenium.By;

public class Yandex2FAPage {

  private final String codeInputCss = "passp-field-phoneCode";
  private final String confirmButtonCss = "button[aria-label='Далее']";

  /**
   * Ввод кода из SMS/приложения.
   */
  public Yandex2FAPage setAuthCode(String code) {
    $(By.id(codeInputCss)).shouldBe(visible).setValue(code);
    return this;
  }

  /**
   * Проверка, что страница загрузилась
   */

  public boolean isYandex2FAPageIsLoaded() {
    return $(By.id(codeInputCss)).shouldBe(visible).exists();
  }


}
