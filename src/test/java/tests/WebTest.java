package tests;

import config.WebConfig;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class WebTest {

    @Test
    public void webLocaleTest() {
        System.setProperty("env", "local");

        WebConfig webConfig = ConfigFactory.create(WebConfig.class, System.getProperties());
        assertThat(webConfig.browserName()).isEqualTo("chrome");
        assertThat(webConfig.browserVersion()).isEqualTo("96");
    }

    @Test
    public void webRemoteTest() {
        System.setProperty("env", "remote");

        WebConfig webConfig = ConfigFactory.create(WebConfig.class, System.getProperties());
        assertThat(webConfig.browserName()).isEqualTo("chrome");
        assertThat(webConfig.browserVersion()).isEqualTo("95");
        assertThat(webConfig.remoteUrl()).isEqualTo("https://user1:1234@selenoid.autotests.cloud/wd/hub/");
    }
}
