package com.example.RestLOgin.ApiRestLoginTest.common;

import java.util.List;

import com.example.RestLOgin.ApiRestLoginTest.entity.Person;

public class ListPersonResponse extends APIResponse {

	private List<Person> listaPerson;
	
	public ListPersonResponse() {
        super();
    }
	
	public List<Person> getListaPerson() {
		return listaPerson;
	}

	public void setListaPerson(List<Person> listaPerson) {
		this.listaPerson = listaPerson;
	}
	
}
