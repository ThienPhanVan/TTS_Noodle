<<<<<<< HEAD:src/main/java/com/cg/service/user/UserServiceImpl.java
package com.cg.service.user;
import com.cg.repository.model.User;
import com.cg.repository.UserRepository;
=======
package com.cg.services.user;


import com.cg.repositories.model.User;
import com.cg.repositories.UserRepository;
>>>>>>> development:src/main/java/com/cg/services/user/UserServiceImpl.java
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Component
@Transactional
public class UserServiceImpl implements UserService {


    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public Optional<User> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public User getById(Long id) {
        return null;
    }

    @Override
    public User save(User user) {
        return null;
    }

    @Override
    public void remove(Long id) {

    }

    @Override
    public void softDelete(User user) {

    }
}
