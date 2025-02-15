package utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import java.io.File;
import java.io.IOException;
import java.util.Map;

public class YamlConfigReader {

  private static Map<String, Object> yamlData;

  static {
    try {
      ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
      yamlData = mapper.readValue(new File("src/test/resources/config.yaml"), Map.class);
    } catch (IOException e) {
      throw new RuntimeException("Ошибка загрузки config.yaml", e);
    }
  }

  /**
   * Получает логин (если авторизация через Яндекс ID).
   */
  public static String getYandexLogin() {
    return ((Map<String, String>) yamlData.get("yandex")).get("login");
  }

  /**
   * Получает пароль.
   */
  public static String getYandexPassword() {
    return ((Map<String, String>) yamlData.get("yandex")).get("password");
  }

  /**
   * Получает номер телефона (если авторизация по номеру).
   */
  public static String getYandexPhone() {
    return ((Map<String, String>) yamlData.get("yandex")).get("phone");
  }
}
