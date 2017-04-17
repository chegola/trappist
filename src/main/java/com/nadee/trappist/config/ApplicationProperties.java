package com.nadee.trappist.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Properties specific to JHipster.
 *
 * <p>
 *     Properties are configured in the application.yml file.
 * </p>
 */
@ConfigurationProperties(prefix = "application", ignoreUnknownFields = false)
public class ApplicationProperties {

    private LoginScreen loginScreen = new LoginScreen();

    public LoginScreen getLoginScreen() {
        return loginScreen;
    }

    public void setLoginScreen(LoginScreen loginScreen) {
        this.loginScreen = loginScreen;
    }

    public static class LoginScreen {
        private String logoUrl;

        public String getLogoUrl() {
            return logoUrl;
        }

        public void setLogoUrl(String logoUrl) {
            this.logoUrl = logoUrl;
        }

        @Override
        public String toString() {
            return "LoginScreen{" +
                    "logoUrl='" + this.logoUrl + '\'' +
                    '}';
        }

    }

}
