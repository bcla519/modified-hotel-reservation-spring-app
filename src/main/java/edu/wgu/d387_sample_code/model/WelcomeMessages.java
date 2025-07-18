package edu.wgu.d387_sample_code.model;


import org.springframework.core.io.ClassPathResource;

import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.ExecutorService;

public class WelcomeMessages {

    static public String[] getWelcomeMessages(ExecutorService messageExecutor) {
        String[] welcomeMessages = {"", ""};
        Properties properties = new Properties();

        // displays English welcome message
        messageExecutor.execute(() -> {
            try {
                InputStream stream = new ClassPathResource("welcome_en_CA.properties").getInputStream();
                properties.load(stream);

                if (welcomeMessages[0].equals("")) {
                    welcomeMessages[0] = properties.getProperty("welcomeMessage");
                }
                else {
                    welcomeMessages[1] = properties.getProperty("welcomeMessage");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        // displays French welcome message
        messageExecutor.execute(() -> {
            try {
                InputStream stream = new ClassPathResource("welcome_fr_CA.properties").getInputStream();
                properties.load(stream);

                if (welcomeMessages[0].equals("")) {
                    welcomeMessages[0] = properties.getProperty("welcomeMessage");
                }
                else {
                    welcomeMessages[1] = properties.getProperty("welcomeMessage");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        try {
            Thread.sleep(50);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return welcomeMessages;
    }
}

