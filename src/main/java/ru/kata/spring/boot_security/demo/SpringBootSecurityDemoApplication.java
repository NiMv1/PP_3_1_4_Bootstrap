package ru.kata.spring.boot_security.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "ru.kata.spring.boot_security.demo")
@EnableTransactionManagement
@EntityScan(basePackages = "ru.kata.spring.boot_security.demo.model")
public class SpringBootSecurityDemoApplication {

    public static void main(String[] args) {

        SpringApplication.run(SpringBootSecurityDemoApplication.class, args);

        // Создаем новый пароль
        String newPassword = "12345";

        // Создаем объект BCryptPasswordEncoder
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        // Хешируем пароль
        String hashedPassword = passwordEncoder.encode(newPassword);

        // Выводим хеш в консоль
        System.out.println("Захешированный пароль: " + hashedPassword);

    }

}
