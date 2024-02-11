package my.security.zero.dao.security;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.springframework.lang.NonNull;

@Entity(name = "users")
public class AppUser {
    @Id
    String login;
    @NonNull
    String password;

    public AppUser() {
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @NonNull
    public String getPassword() {
        return password;
    }

    public void setPassword(@NonNull String password) {
        this.password = password;
    }
}
