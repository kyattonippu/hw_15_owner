package tests;

import config.ApiConfig;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ApiTest {

    @Test
    public void apiLocalTest() {
        ApiConfig apiConfig = ConfigFactory.create(ApiConfig.class, System.getProperties());
        assertThat(apiConfig.baseUrl()).isEqualTo("https://github.com");
        assertThat(apiConfig.token()).isEqualTo("some_token");
    }

    @Test
    public void apiWithTempFileTest() throws IOException {
        String content = "token=another_token";
        Path properties = Paths.get("/tmp/token.properties");
        Files.write(properties, content.getBytes(StandardCharsets.UTF_8));

        ApiConfig apiConfig = ConfigFactory.create(ApiConfig.class, System.getProperties());
        assertThat(apiConfig.baseUrl()).isEqualTo("https://github.com");
        assertThat(apiConfig.token()).isEqualTo("another_token");

        Files.delete(properties);
    }
}
