package com.chat.speak;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@ComponentScan(basePackages = {"com.chat.speak"})
@EntityScan("com.chat.speak.model")
@EnableJpaRepositories(basePackages = {"com.chat.speak.repository"})
@SpringBootApplication
public class SpeakApplication {


    public static void main(String[] args) {
        SpringApplication.run(SpeakApplication.class, args);
    }

    @Bean
    public JavaMailSender javaMailSend() {
        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
        javaMailSender.setHost("smtp.gmail.com");
        javaMailSender.setPort(465);
        javaMailSender.setUsername("ditrim023@gmail.com");
        javaMailSender.setPassword("7Hfycfltkmhtkfvgfuf7&");
        javaMailSender.setJavaMailProperties(getMailProperties());

        return javaMailSender;
    }

    private Properties getMailProperties() {
        final Properties properties = new Properties();
        properties.setProperty("mail.transport.protocol", "smtp");
        properties.setProperty("mail.smtp.auth", "true");
        properties.setProperty("mail.smtp.ssl.enable", "true");
        properties.setProperty("mail.debug", "false");
        properties.setProperty("mail.smtp.connecttimeout", "6000");
        properties.setProperty("mail.smtp.timeout", "4000");
        properties.setProperty("mail.smtp.writetimeout", "6000");
        return properties;
    }
}
