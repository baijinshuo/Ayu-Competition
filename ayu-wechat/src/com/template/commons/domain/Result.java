package com.template.commons.domain;

import java.io.Serializable;

public class Result implements Serializable {

	private static final long serialVersionUID = 1L;

	private String resultcode;

	private String resultmessage;

	private Object data;

	public Result() {
		super();
	}

	public Result(String resultcode, String resultmessage) {
		super();
		this.resultcode = resultcode;
		this.resultmessage = resultmessage;
	}

	public String getResultcode() {
		return resultcode;
	}

	public void setResultcode(String resultcode) {
		this.resultcode = resultcode;
	}

	public String getResultmessage() {
		return resultmessage;
	}

	public void setResultmessage(String resultmessage) {
		this.resultmessage = resultmessage;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

}
