package pl.polsl.filmoteka.services;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.polsl.filmoteka.dto.UserDto;
import pl.polsl.filmoteka.models.User;
import pl.polsl.filmoteka.repositories.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void saveUser(UserDto userDto) {
        User user = new User();
        user.setName(userDto.getName());
        user.setSurname(userDto.getSurname());
        user.setUsername(userDto.getUsername());

        String password = userDto.getPassword();
        if (password != null && !password.isEmpty()) {
            user.setPassword(passwordEncoder.encode(password));
        } else {
            throw new IllegalArgumentException("Password cannot be null or empty");
        }

        user.setRole("USER");
        userRepository.save(user);
    }

    public User findUserByUsername(String username){
        return userRepository.findByUsername(username);
    }

    private UserDto mapToUserDto(User user){
        UserDto userDto = new UserDto();
        userDto.setName(user.getName());
        userDto.setSurname(user.getSurname());
        return userDto;
    }

    public List<UserDto> findAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(this::mapToUserDto)
                .collect(Collectors.toList());
    }
}
