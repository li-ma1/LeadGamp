package web.helpers;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class UserPropertiesReader {
    private static Properties userProperties;

    static {
        Properties appProperties = loadProperties("src\\main\\resources\\app.properties");
        String environment = appProperties.getProperty("environment"); // Получаем значение из app.properties

        if ("stage".equalsIgnoreCase(environment)) {
            userProperties = loadProperties("src\\main\\resources\\userStage.properties");
        } else if ("prod".equalsIgnoreCase(environment)) {
            userProperties = loadProperties("src\\main\\resources\\userProd.properties");
        } else {
            // Обработка ситуации, когда значение environment не корректно.
            // Можно установить значения по умолчанию или выбросить исключение.
            System.err.println("Некорректное значение environment в app.properties: " + environment);
            userProperties = new Properties(); // Пустой объект Properties, чтобы избежать NullPointerException
            // Или: throw new RuntimeException("Некорректное значение environment.");
        }
    }

    private static Properties loadProperties(String filename) {
        Properties properties = new Properties();
        try (FileInputStream input = new FileInputStream(filename)) {
            properties.load(input);
        } catch (IOException ex) {
            System.err.println("Ошибка загрузки файла свойств " + filename + ": " + ex.getMessage());
            // Обработка ошибки: можно выбросить исключение или использовать значения по умолчанию
        }
        return properties;
    }

    public static String getProperty(String key) {
        return userProperties.getProperty(key);
    }

    public static String BASE_URL = getProperty("base_url");
    public static String COMPANY_EMAIL = getProperty("company_email");
    public static String COMPANY_NAME = getProperty("company_name");
    public static String COMPANY_PASSWORD = getProperty("company_password");
    public static String DRIVER_PHONE = getProperty("driver_phone");
    public static String NAME_DRIVER = getProperty("name_driver");
    public static String EMAIL_DRIVER = getProperty("email_driver");
    public static String NAME_CONTACT = getProperty("name_contact");
    public static String EMAIL_CONTACT = getProperty("email_contact");
    public static String DRIVER_PASSWORD = getProperty("driver_password");
    public static String INPUT_SEARCH = getProperty("input_search");
    public static String INPUT_SEARCH_CONTACT = getProperty("input_search_contact");
    public static String DRIVER_ID = getProperty("driver_id");
    public static String DRIVER_CONTACT_ID = getProperty("driver_contact_id");
    public static String COMPANY_ID = getProperty("company_id");
    public static String BASE_URL_DEPOSIT_API = getProperty("base_url_deposit_api");
    public static String API_TOKEN = getProperty("api_token");
    public static String FILTER_EXPERIENCE = getProperty("filter_experienceSearch");
    public static String FILTER_FREIGHTTYPE = getProperty("filter_freightTypeSearch");
    public static String FILTER_HOMETIMES = getProperty("filter_homeTimesSearch");
}
