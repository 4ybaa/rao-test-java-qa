package pages.dzen;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

import pages.yandex.YandexLoginFormPage;

public class DzenLoginPage {

  private final String phoneInputCss = "input[value='+7']";
  private final String continueButtonCss = "button[aria-label='Продолжить']";
  private final String yandexIdButtonCss = "a[aria-label='Войти через Яндекс ID']";
  private final String loginPopupCss = "div.Popup2_visible";

  /**
   * Проверяем, что модальное окно логина появилось.
   */
  public DzenLoginPage checkLoginPopupIsVisible() {
    $(loginPopupCss).shouldBe(visible);
    return this;
  }

  /**
   * Ввод номера телефона.
   */
  public DzenLoginPage setPhoneNumber(String phoneNumber) {
    $(phoneInputCss).shouldBe(visible).setValue(phoneNumber);
    return this;
  }

  /**
   * Нажимаем кнопку "Продолжить".
   */
  public DzenLoginPage clickContinue() {
    $(continueButtonCss).shouldBe(visible).click();
    return this;
  }

  /**
   * Переход на авторизацию через Яндекс ID.
   */
  public YandexLoginFormPage selectYandexIDLogin() {
    $(yandexIdButtonCss).shouldBe(visible).click();
    return new YandexLoginFormPage();
  }
}
