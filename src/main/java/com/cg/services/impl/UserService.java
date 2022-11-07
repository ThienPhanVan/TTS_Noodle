package com.cg.services.impl;

import com.cg.dto.userDTO.UserParam;
import com.cg.dto.userDTO.UserResult;
import com.cg.mapper.UserMapper;
import com.cg.repositories.RoleRepository;
import com.cg.repositories.UserRepository;
import com.cg.repositories.model.User;
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
    private RoleRepository roleRepository;

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
    public UserResult findById(long id) {
        return userMapper.toDTO(userRepository.findById(id).get());
    }

    @Override
    public UserResult createUser(UserParam userParam) {
        User u = userMapper.toModel(userParam);
        u.setRole(roleRepository.findRoleById(u.getRoleId()));
        UserResult userResult = userMapper.toDTO(userRepository.save(u));
        return userResult;
    }

    @Override
    public UserResult updateUser(UserResult userResult, User user) {
         user.setId(userResult.getId());
         UserResult userResults = userMapper.toDTO(userRepository.save(user));
         return  userResults;
    }



}
