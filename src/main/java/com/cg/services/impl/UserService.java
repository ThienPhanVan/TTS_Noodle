package com.cg.services.impl;


import com.cg.dto.userDTO.CreateUserParam;
import com.cg.dto.userDTO.UpdateUserParam;
import com.cg.dto.userDTO.UserResult;
import com.cg.exceptions.NotFoundException;
import com.cg.mapper.OrderMapper;
import com.cg.mapper.UserMapper;
import com.cg.repositories.PaymentCustomerRepository;
import com.cg.repositories.UserRepository;
 import com.cg.repositories.model.Role;
import com.cg.repositories.model.User;
import com.cg.repositories.model.UserStatus;
import com.cg.services.IUserService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
 import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private PaymentCustomerRepository paymentCustomerRepository;

    @Override
    @Transactional(readOnly = true)
    public List<UserResult> findAll() {
        return userRepository.findAll()
                .stream()
                .map(user -> userMapper.toDTO(user))
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<UserResult> findAllByRoleId(long id) {
        return userRepository.getAllByRoleId(id).stream()
                .map(userMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
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
    @Transactional
    public UserResult createCustomer(CreateUserParam createUserParam ) {
        User user = userMapper.toModel(createUserParam);
         int desiredLength = 5;
        String random = UUID.randomUUID().toString().substring(0, desiredLength);
        user.setUsername(random);
        user.setPassword("123");
        user.setId(0L);
        user.setStatus(UserStatus.AVAILABLE);
        user.setRoleId(2L);
        return userMapper.toDTO(userRepository.save(user));
    }

    @Override
    @Transactional
    public UserResult createSupplier(CreateUserParam createUserParam) {
        User user = userMapper.toModel(createUserParam);
        int desiredLength = 5;
        String random = UUID.randomUUID().toString().substring(0, desiredLength);
        user.setUsername(random);
        user.setPassword("123");
        user.setId(0L);
        user.setStatus(UserStatus.AVAILABLE);
        user.setRole(new Role().setId(3L));
        return userMapper.toDTO(userRepository.save(user));
    }

    @Override
    @Transactional
    public List<UserResult> searchCustomer(String keyword) {
        return userRepository.searchCustomer(keyword)
                .stream()
                .map(userMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public List<UserResult> searchSupplier(String keyword) {
        return userRepository.searchSupplier(keyword)
                .stream()
                .map( userMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public UserResult updateUser(UpdateUserParam param) {
        User user = findById(param.getId());
        String fullName = param.getFullName();
        if (Strings.isNotEmpty(fullName)) {
            user.setFullName(fullName);
        }
        String phone = param.getPhone();
        if (Strings.isNotEmpty(phone)) {
            user.setPhone(phone);
        }
        String email = param.getEmail();
        if (Strings.isNotEmpty(email)) {
            user.setEmail(email);
        }
        String address = param.getAddress();
        if (Strings.isNotEmpty(address)) {
            user.setAddress(address);
        }
        String avatar = param.getAvatarUrl();
        if (Strings.isNotEmpty(avatar)) {
            user.setAvatarUrl(avatar);
        }
        user.getPassword();

        user.getUsername();

        user.getRole();
        return userMapper.toDTO(userRepository.save(user));

    }

    @Override
    public boolean findUserByRoleId(Long roleId) {
        return userRepository.findUserByRoleId(roleId);
    }

    @Override
    public BigDecimal totalOrderOfUser(long id) {
        return userRepository.totalOrderOfUser(id);
    }

    @Override
    public List<UserResult> findAllByFullNameOrPhone(String keyword) {
        return userRepository.findAllByFullNameOrPhone(keyword)
                .stream()
                .map(userMapper::toDTO)
                .collect(Collectors.toList());
    }


}
