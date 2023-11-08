package seminars.third.tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

class UserRepositoryTest {

    UserRepository repository;

    @BeforeEach
    void setup() {
        repository = new UserRepository();
    }

    @Test
    void addAuthorizedUserToRepository() {
        User user = new User("1","1", false);
        user.authenticate("1","1");
        repository.addUser(user);
        assertTrue(repository.data.contains(user));
    }
    @Test
    void addNotAuthorizedUserToRepository() {
        User user = new User("1","1", false);
        user.authenticate("1","4");
        repository.addUser(user);
        assertFalse(repository.data.contains(user));
    }
}