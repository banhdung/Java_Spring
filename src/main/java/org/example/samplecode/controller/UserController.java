package org.example.samplecode.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.example.samplecode.dto.request.UserRequestDTO;
import org.example.samplecode.response.ResponseData;
import org.example.samplecode.response.ResponseError;
import org.example.samplecode.service.UserService;
import org.example.samplecode.util.statusValidator.UserStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@Validated
public class UserController {
@Autowired
private UserService userService;

    @PostMapping("/")
    public ResponseData<Integer> addUser(@RequestBody @Valid UserRequestDTO userRequestDTO) {
       try{
           userService.addUser(userRequestDTO);
           return new ResponseData<>(HttpStatus.CREATED.value(), "User added successfully", 1);
       }catch (Exception e){
           return new ResponseError(HttpStatus.BAD_REQUEST.value(), e.getMessage());
       }
    }

    @PutMapping("/{userId}")
    public ResponseData<?> updateUser(@PathVariable int userId, @RequestBody UserRequestDTO userRequestDTO) {
        return new ResponseData<>(HttpStatus.ACCEPTED.value(), "User updated successfully");
    }

    @PatchMapping("/{userId}")
    public ResponseData<?> changeStatus(@PathVariable int userId, @RequestParam boolean status) {
        return new ResponseData(HttpStatus.ACCEPTED.value(), "User updated successfully");
    }

    @DeleteMapping("/{userId}")
    public ResponseData<?> deleteUser(@PathVariable int userId) {
        return new ResponseData<>(HttpStatus.NO_CONTENT.value(), "User deleted successfully");
    }

    @GetMapping("/{userId}")
    public ResponseData<?> getUser(@PathVariable int userId) {
        UserRequestDTO user =  new UserRequestDTO("Java", "Spring","Spring@gmail.com","0912345678", UserStatus.ACTIVE);
        return new ResponseData(HttpStatus.OK.value(), "User successfully", user);
    }

    @GetMapping("/list")
    public ResponseData<?> getUsers(@RequestParam(defaultValue = "0", required = false) int pageNo,
                                    @Min(10) @RequestParam(defaultValue = "20", required = false) int pageSize) {
        List<UserRequestDTO> users =  List.of(new UserRequestDTO("Java", "Spring","Spring@gmail.com","0912345678" , UserStatus.ACTIVE),
                new UserRequestDTO("C", "React","React@gmail.com","0912345678", UserStatus.ACTIVE));
        return new ResponseData<>(HttpStatus.OK.value(), "Users successfully", users);
    }

}
