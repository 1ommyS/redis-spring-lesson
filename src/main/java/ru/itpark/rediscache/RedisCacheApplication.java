package ru.itpark.rediscache;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class RedisCacheApplication implements CommandLineRunner {

    private final UserRepository userRepository;

    public RedisCacheApplication(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(RedisCacheApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {

    }
}
