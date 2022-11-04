package com.cg.services.impl;

import com.cg.dto.userDTO.UserParam;
import com.cg.dto.userDTO.UserResult;
import com.cg.mapper.UserMapper;
import com.cg.repositories.UserRepository;
import com.cg.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<UserResult> findAll() {
        return userRepository.findAll()
                .stream()
                .map(user -> userMapper.toDTO(user))
                .collect(Collectors.toList());
    }

    @Override
    public UserResult findByRoleId(long id) {
        return  userMapper.toDTO(userRepository.findByRoleId(id));
    }

    @Override
    public UserResult createUser(UserParam userParam) {
        return userMapper.toDTO(userRepository.save(userMapper.toModel(userParam)));
    }
}
