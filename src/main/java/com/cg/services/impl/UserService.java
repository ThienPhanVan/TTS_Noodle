package com.cg.services.impl;

import com.cg.dto.userDTO.CreateUserParam;
import com.cg.dto.userDTO.UpdateUserParam;
import com.cg.dto.userDTO.UserResult;
import com.cg.exceptions.NotFoundException;
import com.cg.mapper.UserMapper;
import com.cg.repositories.UserRepository;
import com.cg.repositories.model.Role;
import com.cg.repositories.model.User;
import com.cg.repositories.model.UserStatus;
import com.cg.services.IUserService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
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
        return userMapper.toDTO(userRepository.findByRoleId(id));
    }

    @Override
    public UserResult findById(long id) {
        Optional<User> optional = userRepository.findById(id);
        if (!optional.isPresent())
            throw new NotFoundException("User Not Found");
        return userMapper.toDTO(optional.get());
    }

    private User findById(Long id) {
        Optional<User> optional = userRepository.findById(id);
        if (!optional.isPresent())
            throw new NotFoundException("User Not Found");
        return optional.get();
    }

    @Override
    public UserResult createUser(CreateUserParam createUserParam) {
        User user = userMapper.toModel(createUserParam);
//        int desiredLength = 5;
//        String random = UUID.randomUUID().toString().substring(0, desiredLength);
//        user.setUsername(random);
//        user.setPassword("123");
        user.setId(0L);
        user.setStatus(UserStatus.AVAILABLE);
        user.setRoleId(createUserParam.getRoleId());
        user.setRole(new Role().setId(user.getRoleId()));
        return userMapper.toDTO(userRepository.save(user));
    }

    @Override
    public List<UserResult> findByFullNameAndPhone(String keyword) {
        return userRepository.findAllByFullNameOrPhone(keyword)
                .stream()
                .map(userMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public UserResult updateUser(UpdateUserParam param) {
        User user = findById(param.getId());
        String fullName = param.getFullName();
        if (Strings.isNotEmpty(fullName))
            user.setFullName(fullName);
        return userMapper.toDTO(userRepository.save(user));
    }


}
