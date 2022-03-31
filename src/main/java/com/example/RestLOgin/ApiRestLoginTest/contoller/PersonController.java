package com.example.RestLOgin.ApiRestLoginTest.contoller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import com.example.RestLOgin.ApiRestLoginTest.common.ListPersonResponse;
import com.example.RestLOgin.ApiRestLoginTest.entity.Person;
import com.example.RestLOgin.ApiRestLoginTest.service.PersonService;



@RestController
@RequestMapping("/Api")

public class PersonController {
	
	private Logger LOGGER= LoggerFactory.getLogger(LoginController.class);
	
	
	 @Autowired
	 private PersonService personService;
	 
	 @GetMapping(path = "/getPersonas", produces = {"application/json"})
		public ResponseEntity<ListPersonResponse>  getlistPersonas() {

	        
		 ListPersonResponse responsePerson = new ListPersonResponse();
	        
		 responsePerson = personService.getPersonAll();
		 
		 return  new ResponseEntity<ListPersonResponse>(responsePerson,HttpStatus.OK);	

	    }
	 
	 @GetMapping(path = "/getPerson/{id}", produces = {"application/json"})
		public  ResponseEntity<ListPersonResponse>  getPersonById(@PathVariable int id ){
			
			LOGGER.info("Consultando informacion Person con select");
			ListPersonResponse responsePerson = new ListPersonResponse();
						
			responsePerson = personService.findByIdPerson(id); 
			
			 return  new ResponseEntity<ListPersonResponse>(responsePerson,HttpStatus.OK);
		} 
	    

	 @PutMapping(path = "/actualiza", produces = {"application/json"})
		public ResponseEntity<ListPersonResponse>  actualizaPerson( @RequestBody Person persona) {

		 LOGGER.info("Revisiando persona.. ");
		 ListPersonResponse listPersonResponse = new ListPersonResponse();
		
		listPersonResponse =   personService.actualizaPerson( persona ); 
		
		return  new ResponseEntity<ListPersonResponse>(listPersonResponse,HttpStatus.OK);
		
	  }
	 
	 @DeleteMapping(path = "/delete", produces = {"application/json"})
		public ResponseEntity<ListPersonResponse>  deletePerson( @RequestBody Person persona) {
		
		 LOGGER.info("Revisiando persona.. ");
		 ListPersonResponse listPersonResponse = new ListPersonResponse();
		
		listPersonResponse =   personService.deletePerson(persona); 
		
		return  new ResponseEntity<ListPersonResponse>(listPersonResponse,HttpStatus.OK);
		
	  }
	 
	 @PostMapping(path = "/new", produces = {"application/json"})
		public ResponseEntity<ListPersonResponse> insertProducto(@RequestBody Person persona) {
		 LOGGER.info("Guardando persona.. ");
		 ListPersonResponse listPersonResponse = new ListPersonResponse();
		 listPersonResponse = personService.addPerson(persona);
			
			
		return  new ResponseEntity<ListPersonResponse>(listPersonResponse,HttpStatus.OK);
		}
		

}
