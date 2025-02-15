package pages.yandex;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class YandexAccountSelectionPage {

  private final String addAccountButtonCss = "button[data-testid='add-account']";

  /**
   * Нажимает кнопку "Добавить аккаунт".
   */
  public YandexLoginFormPage clickAddAccount() {
    $(addAccountButtonCss).shouldBe(visible).click();
    return new YandexLoginFormPage();
  }
}
