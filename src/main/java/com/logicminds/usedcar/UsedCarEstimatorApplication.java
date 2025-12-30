package com.logicminds.usedcar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;

import java.awt.Desktop;
import java.net.URI;

@SpringBootApplication
public class UsedCarEstimatorApplication {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(UsedCarEstimatorApplication.class);
        app.addListeners(new BrowserLauncher());
        app.run(args);
    }
}

class BrowserLauncher implements ApplicationListener<ApplicationReadyEvent> {

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        try {
            String url = "http://localhost:8080/";
            if (Desktop.isDesktopSupported() && !java.awt.GraphicsEnvironment.isHeadless()) {
                Desktop.getDesktop().browse(new URI(url));
            } else {
                Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + url);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
