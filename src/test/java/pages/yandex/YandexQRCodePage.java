package pages.yandex;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class YandexQRCodePage {

  private final String loginWithPasswordButtonCss = "button[aria-label='Войти с паролем']";

  /**
   * Нажимаем "Войти с паролем".
   */
  public YandexPasswordPage clickLoginWithPassword() {
    $(loginWithPasswordButtonCss).shouldBe(visible).click();
    return new YandexPasswordPage();
  }
}
