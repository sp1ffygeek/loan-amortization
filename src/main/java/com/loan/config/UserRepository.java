package com.loan.config;

import com.loan.models.User;
import com.loan.models.dto.UserDTO;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by pyada01 on 10/7/16.
 */
public interface UserRepository extends CrudRepository<UserDTO, String> {
    UserDTO findByUserId(String userId);
    UserDTO save(User u);
}
