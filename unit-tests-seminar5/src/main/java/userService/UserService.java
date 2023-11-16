package userService;

public class UserService {
    /*
    У вас есть два класса - UserService и UserRepository.
    UserService использует UserRepository для получения информации о пользователе.
    Задача - написать интеграционный тест, который проверяет, что UserService и
    UserRepository работают вместе должным образом.
     */
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String getUserName(int id) {
        return userRepository.getUserById(id);
    }
}
