package com.example.RestLOgin.ApiRestLoginTest.service;


import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.RestLOgin.ApiRestLoginTest.common.ListPersonResponse;
import com.example.RestLOgin.ApiRestLoginTest.contoller.LoginController;
import com.example.RestLOgin.ApiRestLoginTest.dto.ValidaPersonRequest;
import com.example.RestLOgin.ApiRestLoginTest.entity.Person;
import com.example.RestLOgin.ApiRestLoginTest.repo.PersonRepository;

@Service("PersonService")
public class PersonService {

	@Autowired
	@Qualifier("RepositoryPerson")
	private PersonRepository repositoryPerson;
	
	private Logger LOGGER= LoggerFactory.getLogger(LoginController.class);
	
	public List<Person> ListPerson() {
	
        return (List<Person>) repositoryPerson.selectALLPerson();
    }
	
	
	public ListPersonResponse actualizaPerson(Person person) {
		 LOGGER.info("Revisando persona" + person.getId());
		 ListPersonResponse listPersonResponse = new ListPersonResponse();
		
		 List<Person> listPerson  = repositoryPerson.findPersonId(person.getId()); 
	
		 if(!listPerson.isEmpty() ){
			 LOGGER.info("Valida persona - " + person.getId() + " - " + person.getLastName());
			 
			ValidaPersonRequest validaPerson  = ValidaPersonRequest.validaPerson(person.getFirstName(),
						person.getLastName(), person.getEmail(), person.getAddress());
				
			 if(validaPerson.isError()) {
				 listPersonResponse.setData(person);
				 listPersonResponse.setError(validaPerson.getMsg());
				 listPersonResponse.setStatus(300);
			 }else{
				 LOGGER.info("Actualiza persona - " + person.getId() + " -" + person.getFirstName());

				 repositoryPerson.save(person);
				 
				 listPersonResponse.setData(person);
				 listPersonResponse.setError("OK");
				 listPersonResponse.setStatus(200);
				
			 }
		 }
		 else
		 {
			 listPersonResponse.setData("Persona con id " + person.getId() + " y nombre" + person.getFirstName() + " " +
					 "No se encuentra registrado");
			 listPersonResponse.setError("Error");
			 listPersonResponse.setStatus(300);
		 }
		 return listPersonResponse;
	}
	
	public ListPersonResponse deletePerson(Person person) {
		 LOGGER.info("Revisando persona" + person.getId());
		 
		 ListPersonResponse listPersonResponse = new ListPersonResponse();
		 listPersonResponse = this.findByIdPerson(person.getId());
		 
		 if(listPersonResponse.getStatus() == 200 ){
			 LOGGER.info("Elimina persona - " + person.getId() + " - " + person.getLastName());

				 repositoryPerson.deleteById(person.getId());				 
				 listPersonResponse.setData("Registro eliminado exitosamente.. Id Persona: " +
						 person.getId() + " Nombre:" + " " + person.getFirstName());
				 listPersonResponse.setError("OK");
				 listPersonResponse.setStatus(200);
		 }
		 return listPersonResponse;
	}
	

	public ListPersonResponse addPerson(Person person) {
		 LOGGER.info("Guardando persona" + person.getFirstName());
		 
		 ListPersonResponse listPersonResponse = new ListPersonResponse();
		
		 ValidaPersonRequest validaPerson  = ValidaPersonRequest.validaPerson(person.getFirstName(),
					person.getLastName(), person.getEmail(), person.getAddress());
		 
		 if(validaPerson.isError()) {
			 listPersonResponse.setData(person);
			 listPersonResponse.setError(validaPerson.getMsg());
			 listPersonResponse.setStatus(300);
		 }else{
			 LOGGER.info("Guardando persona - "  + person.getFirstName());
			 int id = 1;
			 
			 Person per =  new Person();
			 per.setId(id);
			 per.setFirstName(person.getFirstName());
			 per.setLastName(person.getLastName());
			 per.setEmail(person.getEmail());
			 per.setAddress(person.getAddress());
			
			 repositoryPerson.save(person);
			 
			 listPersonResponse.setData(person);
			 listPersonResponse.setError("OK");
			 listPersonResponse.setStatus(200);
			
		 }
		 
		 return listPersonResponse;
	}
	public ListPersonResponse findByIdPerson(int id) {
		
			ListPersonResponse responsePerson = new ListPersonResponse();
			
			try {
				LOGGER.info("Consultando informacion Person con select");
				List<Person> listPerson = repositoryPerson.findPersonId(id);
	        
	        if(listPerson.isEmpty()){
	        	responsePerson.setData("No existe registro de la persona con id " + id );
	        	responsePerson.setError("Empty");
	        	responsePerson.setStatus(300);
	            return responsePerson;
	            
	        }
	        else
	        {
	        	responsePerson.setStatus(200);
		        responsePerson.setError("OK");
		        responsePerson.setData(listPerson);
		        return responsePerson;
	        }
			
		} catch(DataAccessException e) {
			responsePerson.setStatus(HttpStatus.EXPECTATION_FAILED.value());
			responsePerson.setError("Error");
			responsePerson.setData("Error al obtener datos del select" + "- " + e.getMostSpecificCause().getMessage() );
			return responsePerson;
		}
        
    }
	
	  public ListPersonResponse getPersonAll() {

		  ListPersonResponse responsePerson = new ListPersonResponse();
	        // validation
	        // Obtenemos personas
	        LOGGER.info("Consultando informacion Person con select");
	        List<Person> listPerson = this.ListPerson();
	        
	         /*Person person = repositoryPerson.selectALLPerson();*/
	        
	        try {
	        	 // response
		        if(listPerson == null){
		        	responsePerson.setData("No existen registro de personas");
		        	responsePerson.setError("Vacio");
		        	responsePerson.setStatus(HttpStatus.OK.value());
		            return responsePerson;
		            
		        }
		        else
		        {
		           /* Map<String , Object> data = new HashMap<>();
			        data.put("ListaPersonas", listPerson);
		            */
			        responsePerson.setListaPerson(listPerson);
			        responsePerson.setError("OK..");
			        responsePerson.setData(listPerson);
			        
			        
			        return responsePerson;
		        }
				
			} catch(DataAccessException e) {
				responsePerson.setStatus(HttpStatus.EXPECTATION_FAILED.value());
				responsePerson.setError("Error");
				responsePerson.setData("Error al obtener datos del select" + "- " + e.getMostSpecificCause().getMessage() );
				return responsePerson;
			}
	        
	    
	    }
	
}
