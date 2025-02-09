package org.example.samplecode.controller;

import jakarta.validation.Valid;
import org.example.samplecode.dto.request.UserRequestDTO;
import org.example.samplecode.util.statusValidator.UserStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @PostMapping("/")
    public String addUser(@RequestBody @Valid UserRequestDTO userRequestDTO) {
        return "User added successfully";
    }

    @PutMapping("/{userId}")
    public String updateUser(@PathVariable int userId, @RequestBody UserRequestDTO userRequestDTO) {
        return "User updated successfully";
    }

    @PatchMapping("/{userId}")
    public String changeStatus(@PathVariable int userId, @RequestParam boolean status) {
        return "User status changed successfully";
    }

    @DeleteMapping("/{userId}")
    public String deleteUser(@PathVariable int userId) {
        return "User deleted successfully";
    }

    @GetMapping("/{userId}")
    public UserRequestDTO getUser(@PathVariable int userId) {
        return new UserRequestDTO("Java", "Spring","Spring@gmail.com","0912345678", UserStatus.ACTIVE);
    }

    @GetMapping("/list")
    public List<UserRequestDTO> getUsers() {
        return List.of(new UserRequestDTO("Java", "Spring","Spring@gmail.com","0912345678" , UserStatus.ACTIVE),
                new UserRequestDTO("C", "React","React@gmail.com","0912345678", UserStatus.ACTIVE));
    }
}
