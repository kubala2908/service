package pl.jakubtuminski.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findUserById(Long id);

    User findByUsername(String username);

    @Override
    <S extends User> S save(S s);

    @Override
    List<User> findAll();
}
