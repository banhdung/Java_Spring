package org.example.samplecode.service.impl;

import org.example.samplecode.dto.request.UserRequestDTO;
import org.example.samplecode.exception.ResourceNotFoundException;
import org.example.samplecode.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public int addUser(UserRequestDTO userRequestDTO) {
        if(userRequestDTO.getFirstName().equals("admin")){
            throw new ResourceNotFoundException("User not found");
        }
        return 0;
    }
}
