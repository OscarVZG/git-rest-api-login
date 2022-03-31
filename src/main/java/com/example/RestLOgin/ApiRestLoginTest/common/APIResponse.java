package com.example.RestLOgin.ApiRestLoginTest.common;

import org.springframework.http.HttpStatus;

public class APIResponse {
	 	private Integer status;
	    private Object data;
	    private String error;

	    public APIResponse() {
	        this.status = HttpStatus.OK.value();
	        this.data = data;
	        this.error = "";
	    }

	    public Integer getStatus() {
	        return status;
	    }

	    public void setStatus(Integer status) {
	        this.status = status;
	    }

	    public Object getData() {
	        return data;
	    }

	    public void setData(Object data) {
	        this.data = data;
	    }

	    public String getError() {
	        return error;
	    }

	    public void setError(String error) {
	        this.error = error;
	    }
}
