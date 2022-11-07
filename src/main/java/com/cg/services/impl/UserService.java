package com.cg.services.impl;

import com.cg.dto.userDTO.CreateUserParam;
import com.cg.dto.userDTO.UserResult;
import com.cg.mapper.UserMapper;
import com.cg.repositories.RoleRepository;
import com.cg.repositories.UserRepository;
import com.cg.repositories.model.Role;
import com.cg.repositories.model.User;
import com.cg.repositories.model.UserStatus;
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
<<<<<<< HEAD
=======
    public UserResult findByRoleId(long id) {
        return userMapper.toDTO(userRepository.findByRoleId(id));
    }

    @Override
>>>>>>> development
    public UserResult findById(long id) {
        return userMapper.toDTO(userRepository.findById(id).get());
    }

    @Override
    public UserResult createUser(CreateUserParam createUserParam) {
        User user = userMapper.toModel(createUserParam);
        user.setId(0L);
        user.setStatus(UserStatus.AVAILABLE);
        user.setRoleId(createUserParam.getRoleId());
        user.setRole(new Role().setId(user.getRoleId()));
        UserResult userResult =userMapper.toDTO(userRepository.save(user));
        return userResult;
    }

<<<<<<< HEAD
    @Override
    public UserResult updateUser(UserResult userResult, User user) {
         user.setId(userResult.getId());
         UserResult userResults = userMapper.toDTO(userRepository.save(user));
         return  userResults;
    }



=======
//    @Override
//    public UserResult updateUser(UserResult userResult, User user) {
//         user.setId(userResult.getId());
//         UserResult userResults = userMapper.toDTO(userRepository.save(user));
//         return  userResults;
//    }
//
//
//    @Override
//    public List<UserResult> findUserByFullNameAndPhone(String keyword) {
//        return userRepository.findUserByFullNameAndPhone(keyword);
//    }
>>>>>>> development
}
