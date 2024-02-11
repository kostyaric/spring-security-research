package my.security.zero.repository;

import my.security.zero.dao.security.AppUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<AppUser, String> {

    AppUser findByLogin(String login);
}
