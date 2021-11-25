package ir.shahryar.weather.user;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository repository;
    String secret = "E)H@McQfThWmZq4t7w!z%C*F-JaNdRgU";

    public List<User> getAllUsers() {
        return (List<User>) repository.findAll();
    }

    public User findUserByUsername(String name) {
        Optional<User> user = repository.findByUsername(name);
        return user.orElseGet(User::new);
    }

    public User findUserByUsernameAndPassword(String username, String password) {
        Optional<User> user = repository.findByUsernameAndPassword(username, password);
        return user.orElseGet(User::new);
    }

    public String getToken(User mainUser) {
        String payload = String.format("{\"message\" : %d }", mainUser.getId());
        return Jwts.builder()
                .setPayload(payload)
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

    public void save(User user) {
        repository.save(user);
    }
}
