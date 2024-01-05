package pl.polsl.filmoteka.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.polsl.filmoteka.dto.UserDto;
import pl.polsl.filmoteka.models.User;
import pl.polsl.filmoteka.services.UserService;

@RestController
public class AuthController {

    private UserService userService;

    @Autowired
    public AuthController(UserService userService) {
        this.userService = userService;
    }

    // homepage
    @GetMapping("/index")
    public String home(){
        return "index";
    }

    // handler method to handle user registration form request
    @GetMapping("/register")
    public String showRegistrationForm(Model model){
        // create model object to store form data
        UserDto user = new UserDto();
        model.addAttribute("user", user);
        return "register";
    }

    // handler method to handle user registration form submit request
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


    @GetMapping("/login")
    public String login(){
        return "login";
    }


}