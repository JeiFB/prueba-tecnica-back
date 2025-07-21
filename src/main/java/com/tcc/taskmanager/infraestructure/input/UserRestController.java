package com.tcc.taskmanager.infraestructure.input;

import com.tcc.taskmanager.application.dtos.request.UserRequestDto;
import com.tcc.taskmanager.application.dtos.response.UserResponseDto;
import com.tcc.taskmanager.application.handler.IUserHandler;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserRestController {
    private final IUserHandler userHandler;

    public  UserRestController(IUserHandler userHandler){
        this.userHandler = userHandler;
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDto> getUserById(@PathVariable(value = "id")Long id){
        return  ResponseEntity.ok(userHandler.getUserById(id));
    }

    @PostMapping("/")
    public ResponseEntity<Void> createUser(@Valid @RequestBody UserRequestDto userRequestDto){
        try {
            userHandler.createUser(userRequestDto);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
