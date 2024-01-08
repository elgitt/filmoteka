package pl.polsl.filmoteka.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.polsl.filmoteka.dto.UserDto;
import pl.polsl.filmoteka.models.User;
import pl.polsl.filmoteka.repositories.UserRepository;
import pl.polsl.filmoteka.services.UserService;

import java.util.Map;

@RestController
public class AuthController {

    private UserRepository userRepository;

    private UserService userService;

    private PasswordEncoder passwordEncoder;

    @Autowired
    public AuthController(UserRepository userRepository, UserService userService, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/index")
    public String home(){
        return "index";
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model){
        UserDto user = new UserDto();
        model.addAttribute("user", user);
        return "register";
    }

    @PostMapping("/register/save")
    public ResponseEntity<String> registration(@Valid @RequestBody UserDto userDto,
                                               BindingResult result) {
        System.out.println("Received data from frontend: " + userDto.toString());

        User existingUserByUsername = userService.findUserByUsername(userDto.getUsername());

        if (existingUserByUsername != null && existingUserByUsername.getUsername() != null &&
                !existingUserByUsername.getUsername().isEmpty()) {
            result.rejectValue("username", null, "This username is already taken");
        }

        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body("Registration failed. Please check your details and try again.");
        }

        userService.saveUser(userDto);
        return ResponseEntity.ok("Registration successful!");
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> credentials) {
        String username = credentials.get("username");
        String password = credentials.get("password");
        try {
            User existingUser = userRepository.findByUsername(username);

            if (existingUser != null && passwordEncoder.matches(password, existingUser.getPassword())) {
                // Tworzenie obiektu UserDto na podstawie User
                UserDto userDto = new UserDto() ;
                userDto.setId(existingUser.getId());
                userDto.setName(existingUser.getName());
                userDto.setSurname(existingUser.getSurname());
                userDto.setUsername(existingUser.getUsername());
                userDto.setPassword(existingUser.getPassword());

                return new ResponseEntity<>(userDto, HttpStatus.OK);
            } else {
                return new ResponseEntity<>("Invalid username or password", HttpStatus.UNAUTHORIZED);
            }

        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.UNAUTHORIZED);
        }
    }
}