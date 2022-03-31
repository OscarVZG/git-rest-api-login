package com.example.RestLOgin.ApiRestLoginTest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.RestLOgin.ApiRestLoginTest.common.APIResponse;
import com.example.RestLOgin.ApiRestLoginTest.dto.LoginRequestDTO;
import com.example.RestLOgin.ApiRestLoginTest.dto.SignUpRequestDTO;
import com.example.RestLOgin.ApiRestLoginTest.entity.User;
import com.example.RestLOgin.ApiRestLoginTest.repo.UserRepository;
import com.example.RestLOgin.ApiRestLoginTest.util.JwtUtils;

import java.util.HashMap;
import java.util.Map;

@Service
public class LoginService {
	
	 @Autowired
	    private UserRepository userRepository;
	    @Autowired
	    private JwtUtils jwtUtils;

	    public APIResponse signUp(SignUpRequestDTO signUpRequestDTO) {
	        APIResponse apiResponse = new APIResponse();

	        // validation

	        // dto to entity
	        User userEntity = new User();
	        userEntity.setName(signUpRequestDTO.getName());
	        userEntity.setEmail(signUpRequestDTO.getEmail());
	        userEntity.setPassword(signUpRequestDTO.getPassword());

	        // store entity
	        userEntity = userRepository.save(userEntity);

	        // generate jwt
	        String token = jwtUtils.generateJwt(userEntity);

	        Map<String , Object> data = new HashMap<>();
	        data.put("accessToken", token);

	        apiResponse.setData(token);

	        // return
	        return apiResponse;
	    }

	    public APIResponse login(LoginRequestDTO loginRequestDTO) {

	        APIResponse apiResponse = new APIResponse();

	        // validation

	        // verify user exist with given email and password
	        User user = userRepository.findOneByEmailAndPassword(loginRequestDTO.getEmail(),loginRequestDTO.getPassword());
	        
	        		//(loginRequestDTO.getEmail(), loginRequestDTO.getPassword());

	        // response
	        if(user == null){
	            apiResponse.setData("User login failed");
	            apiResponse.setError("Error");
	            apiResponse.setStatus(HttpStatus.OK.value());
	            return apiResponse;
	            
	        }

	        // generate jwt
	        String token = jwtUtils.generateJwt(user);

	        Map<String , Object> data = new HashMap<>();
	        data.put("Token", token);

	        apiResponse.setData(data);
	        apiResponse.setError("OK..");
	        
	        return apiResponse;
	    }
}
