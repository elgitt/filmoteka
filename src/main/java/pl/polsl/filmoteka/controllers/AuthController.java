package pl.polsl.filmoteka.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
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

    @PutMapping("/editProfile")
    public ResponseEntity<String> editProfile(@Valid @RequestBody UserDto updatedUser, BindingResult result) {
        try {
            User existingUser = userRepository.findById(updatedUser.getId()).orElse(null);

            if (existingUser == null) {
                return ResponseEntity.badRequest().body("User not found");
            }


            User existingUserByUsername = userService.findUserByUsername(updatedUser.getUsername());
            if (existingUserByUsername != null && !existingUserByUsername.getId().equals(updatedUser.getId())) {
                result.rejectValue("username", null, "This username is already taken");
            }


            if (result.hasErrors()) {
                return ResponseEntity.badRequest().body("Profile update failed. Please check your details and try again.");
            }

            existingUser.setName(updatedUser.getName());
            existingUser.setSurname(updatedUser.getSurname());
            existingUser.setUsername(updatedUser.getUsername());

            String newPassword = updatedUser.getPassword();
            if (newPassword != null && !newPassword.isEmpty()) {
                existingUser.setPassword(passwordEncoder.encode(newPassword));
            }

            userRepository.save(existingUser);

            return ResponseEntity.ok("Profile updated successfully!");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred during profile update");
        }
    }

}
