package edu.susl.my_auth.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.susl.my_auth.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{
	Optional<User> findByUserName(String userName);
}
