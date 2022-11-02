package com.cg.repository;

<<<<<<< HEAD



import com.cg.model.User;
=======
import com.cg.model1.User;
>>>>>>> development
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
