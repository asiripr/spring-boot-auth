package edu.susl.my_auth.dto;

import lombok.Data;

@Data
public class UserRegistrationDto {
	private String userName;
	private String password;	
	private String confirmPassword;
	
}
