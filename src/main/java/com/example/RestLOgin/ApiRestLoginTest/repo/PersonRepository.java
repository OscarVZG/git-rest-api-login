package com.example.RestLOgin.ApiRestLoginTest.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.RestLOgin.ApiRestLoginTest.entity.Person;

@Repository("RepositoryPerson")
public interface PersonRepository extends CrudRepository<Person,Integer>{

	

		@Query(value = "select * from PERSON p", nativeQuery = true)
		List<Person> selectALLPerson();
		
		@Query(value = "select * from PERSON p where p.id = ?1", nativeQuery = true)
		List<Person> findPersonId(int id);
		
		

}
