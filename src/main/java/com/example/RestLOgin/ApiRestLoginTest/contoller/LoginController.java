package com.example.RestLOgin.ApiRestLoginTest.contoller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.RestLOgin.ApiRestLoginTest.common.APIResponse;
import com.example.RestLOgin.ApiRestLoginTest.dto.LoginRequestDTO;
import com.example.RestLOgin.ApiRestLoginTest.dto.SignUpRequestDTO;
import com.example.RestLOgin.ApiRestLoginTest.service.LoginService;

/*Comentario*/
@RestController
@RequestMapping("/Api")

public class LoginController {


	private Logger LOGGER= LoggerFactory.getLogger(LoginController.class);
	
	   @Autowired
	    private LoginService loginService;

	    @PostMapping("/signup")
	    public ResponseEntity<APIResponse> signUp(@RequestBody SignUpRequestDTO signUpRequestDTO ){

	        APIResponse apiResponse = loginService.signUp(signUpRequestDTO);

	        return ResponseEntity
	                .status(apiResponse.getStatus())
	                .body(apiResponse);
	    }

	    @PostMapping(path = "/login", produces = {"application/json"})
	    public ResponseEntity<APIResponse> login(@RequestBody LoginRequestDTO loginRequestDTO ){

	        APIResponse apiResponse = loginService.login(loginRequestDTO);

	        return ResponseEntity
	                .status(apiResponse.getStatus())
	                .body(apiResponse);
	    }

		
}
