package ru.itpark.rediscache;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;

    @GetMapping("{id}")
//    @Cacheable(value = "myCache", key = "'user_id' + #id")
    public User getUser(@PathVariable  long id) {
        List<User> list = new ArrayList<>();

        for (int i = 0; i < 100_000; i++) {
            User user = new User();
            user.setName("User " + i);
            list.add(user);
        }

        userRepository.saveAll(list);
//        return userRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        return null;
    }

    @GetMapping
    @Cacheable(value = "myCache", key = "'users'")
    public List<User> getUser() {
        return userRepository.findAll();
    }
}
