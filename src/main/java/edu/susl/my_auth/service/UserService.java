package edu.susl.my_auth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import edu.susl.my_auth.dto.UserRegistrationDto;
import edu.susl.my_auth.entity.User;
import edu.susl.my_auth.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	private PasswordEncoder passwordEncoder;

	public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
	}
	
	public User registerNewUser(UserRegistrationDto registrationDto) throws Exception{
		if (!registrationDto.getPassword().equals(registrationDto.getConfirmPassword())){
			throw new Exception("Pasword does not match!");
		}
		
		User user = new User();
		user.setUsername(registrationDto.getUserName());
		user.setPassword(passwordEncoder.encode(registrationDto.getPassword()));
		user.setRole("User");
		
		return userRepository.save(user);
	}
	
	public User findByUserName(String userName) {
		return userRepository.findByUserName(userName).orElse(null);
	}
}
