package config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:${env}.properties")
public interface WebConfig extends Config {

    @Key("browserName")
    @DefaultValue("chrome")
    String browserName();

    @Key("browserVersion")
    @DefaultValue("96")
    String browserVersion();

    @Key("selenoidUrl")
    String remoteUrl();
}
