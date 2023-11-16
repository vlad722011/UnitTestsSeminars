package userService;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
public class TestUserService {
    @Test
    void testUserService(){
        UserRepository userRepository = new UserRepository();
        UserService userService = new UserService(userRepository);
        assertThat(userService.getUserName(1)).isEqualTo("User 1");
    }
}
