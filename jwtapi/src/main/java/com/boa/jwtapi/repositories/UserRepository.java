package com.boa.jwtapi.repositories;

import com.boa.jwtapi.models.User;
import org.springframework.data.jpa.repository.JpaRepository;





public interface UserRepository extends JpaRepository<User,String>{

}
