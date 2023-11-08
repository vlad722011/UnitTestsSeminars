package seminars.third.tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserTest {
    private User user;

    @BeforeEach
    void setup() {
        user = new User("Roma","testpass", true);
    }

    @Test
    void authenticationTestPass() {
        assertTrue(user.authenticate("Roma","testpass"));
    }

    @Test
    void authenticationTestFailed() {
        assertFalse(user.authenticate("admin","123123"));
    }
}