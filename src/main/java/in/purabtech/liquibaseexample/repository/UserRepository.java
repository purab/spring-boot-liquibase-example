package in.purabtech.liquibaseexample.repository;

import in.purabtech.liquibaseexample.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT name FROM User s WHERE s.name LIKE %:userName%")
    String findByName(String userName);
}
