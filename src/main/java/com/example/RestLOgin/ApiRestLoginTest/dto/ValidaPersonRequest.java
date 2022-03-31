package com.example.RestLOgin.ApiRestLoginTest.dto;

public class ValidaPersonRequest {
	
	private boolean error;
	private String msg;
	
	public boolean isError() {
		return error;
	}
	public void setError(boolean error) {
		this.error = error;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	private boolean validaFirstname(String firstName) 
	{
		boolean flag = false;
		if (firstName == "")
		{
			flag = true;
		}	
		return flag;
	}
	
	private boolean validaLastName(String lastName) 
	{
		boolean flag = false;
		if (lastName == "")
		{
			flag = true;
		}	
		return flag;
	}
	
	private boolean validaEmail(String email) 
	{
		boolean flag = false;
		if (email == "")
		{
			flag = true;
		}	
		return flag;
	}
	
	private boolean validaAddress(String address) 
	{
		boolean flag = false;
		if (address == "")
		{
			flag = true;
		}	
		return flag;
	}
	
	public static ValidaPersonRequest validaPerson(String firstName, String lastName, String email, String address ) {
		
		ValidaPersonRequest validaPerson = new ValidaPersonRequest();
		if(validaPerson.validaFirstname(firstName))
		{
			validaPerson.setError(true);
			validaPerson.setMsg("Nombre no puede ser vacio.");
		}
		else
		{
			if(validaPerson.validaLastName(lastName)) {
				validaPerson.setError(true);
				validaPerson.setMsg("Apellido no puede ser vacio.");
			}
			else
			{
				if(validaPerson.validaEmail(email)) {
					validaPerson.setError(true);
					validaPerson.setMsg("Email no puede ser vacio.");
				}
				else
				{
					if(validaPerson.validaAddress(address)) {
						validaPerson.setError(true);
						validaPerson.setMsg("Dirección no puede ser vacio.");
					}
				}
			}
		}
		
		return validaPerson;
	}
	

}
