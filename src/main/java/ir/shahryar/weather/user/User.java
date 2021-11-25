package ir.shahryar.weather.user;

import javax.persistence.*;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "username", length = 50, unique = true, nullable = false)
    private String username;
    @Column(length = 50)
    private String password;
    @Column(name = "request_remains")
    private int requestRemains;

    public User() {
    }

    public String getUsername() {
        return username;
    }

    public void setRequestRemains(int requestRemains) {
        this.requestRemains = requestRemains;
    }

    public long getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }
}
