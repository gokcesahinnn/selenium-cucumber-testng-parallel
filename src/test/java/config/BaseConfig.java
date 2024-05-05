package config;

public class BaseConfig {

    public static BaseConfig getInstance() {
        return new BaseConfig();
    }

    String browser = System.getProperty("browser");
    String env = System.getProperty("env");
    String headless = System.getProperty("headless");
    String locale = System.getProperty("locale");
    String threadCount = System.getProperty("threadCount");
    String maxRetryCountForFailedScenarios = System.getProperty("maxRetryCountForFailedScenarios");

    public String getBrowser() {
        return (browser != null) ? browser : "chrome";
    }

    public String getUrl() {
        env = (env != null) ? env : "test";
        String url = null;
        switch (env) {
            case "test" -> url = "https://automationexercise.com/";
            case "prod" -> url = "https://www.google.com/";
        }
        return url;
    }

    public Boolean getHeadless() {
        return Boolean.parseBoolean(headless);
    }

    public String getLocale() {
        return (locale != null) ? locale : "tr";
    }

    public String getThreadCount() {
        return (threadCount != null) ? threadCount : "3";
    }
    public String getMaxRetryCountForFailedScenarios() {
        return (maxRetryCountForFailedScenarios != null) ? maxRetryCountForFailedScenarios : "1";
    }
}